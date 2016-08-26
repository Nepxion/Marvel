package com.nepxion.util.searcher.ip.local;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class IPSearcher
{
	private static final int IP_RECORD_LENGTH = 7;
	private static final byte REDIRECT_MODE_1 = 0x01;
	private static final byte REDIRECT_MODE_2 = 0x02;
	
	private Map ipCache;
	private RandomAccessFile ipFile;
	private MappedByteBuffer ipByteBuffer;
	private StringBuffer ipStringBuffer;
	
	private long ipStart;
	private long ipEnd;
	
	private IPEntity ipEntity;
	private byte[] buffer;
	private byte[] b3;
	private byte[] b4;
	
	private static IPSearcher ipSearcher;
	
	public static IPSearcher getInstance()
	{
		if (ipSearcher == null)
		{
			try
			{
				ipSearcher = new IPSearcher();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}	
		
		return ipSearcher;
	}
	
	public IPSearcher()
		throws Exception
	{
		this(IPContext.getFile());
	}
	
	public IPSearcher(String filePath)
		throws Exception
	{	
		this(new File(filePath));
	}
	
	public IPSearcher(File file)
		throws Exception
	{		
		ipCache = new HashMap();
		ipStringBuffer = new StringBuffer();
		ipEntity = new IPEntity();
		buffer = new byte[1000];
		b3 = new byte[3];
		b4 = new byte[4];
	
		try
		{
			ipFile = new RandomAccessFile(file, "r");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			
			throw e;
		}
		if (ipFile != null)
		{
			try
			{
				ipStart = readLong4(0);
				ipEnd = readLong4(4);
				if (ipStart == -1 || ipEnd == -1)
				{
					ipFile.close();
					ipFile = null;
				}
			}
			catch (IOException e)
			{
				ipFile = null;
				e.printStackTrace();
				throw new Exception("Invalid IP data format file", e);	
			}
		}
	}
	
	public List getIPEntityListDebug(String ipString)
	{
		List list = new ArrayList();
		long endOffset = ipEnd + 4;
		for (long offset = ipStart + 4; offset <= endOffset; offset += IP_RECORD_LENGTH)
		{
			long value = readLong3(offset);
			if (value != -1)
			{
				IPEntity ipEntity = getIPEntity(value);
				if (ipEntity.getCountry().indexOf(ipString) != -1 || ipEntity.getRegion().indexOf(ipString) != -1)
				{
					IPEntity entity = new IPEntity();
					entity.setCountry(ipEntity.getCountry());
					entity.setRegion(ipEntity.getRegion());
					readIP(offset - 4, b4);
					entity.setStartIP(getString(b4));
					readIP(value, b4);
					entity.setEndIP(getString(b4));
					list.add(entity);
				}
			}
		}
		
		return list;
	}
	
	public List getIPEntityList(String ipString)
	{
		List list = new ArrayList();
		try
		{
			if (ipByteBuffer == null)
			{
				FileChannel fileChannel = ipFile.getChannel();
				ipByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, ipFile.length());
				ipByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
			}
			
			int endOffset = (int) ipEnd;
			for (int offset = (int) ipStart + 4; offset <= endOffset; offset += IP_RECORD_LENGTH)
			{
				int value = readInt3(offset);
				if (value != -1)
				{
					IPEntity ipEntity = getIPEntity(value);
					if (ipEntity.getCountry().indexOf(ipString) != -1 || ipEntity.getRegion().indexOf(ipString) != -1)
					{
						IPEntity entity = new IPEntity();
						entity.setCountry(ipEntity.getCountry());
						entity.setRegion(ipEntity.getRegion());
						readIP(offset - 4, b4);
						entity.setStartIP(getString(b4));
						readIP(value, b4);
						entity.setEndIP(getString(b4));
						list.add(entity);
					}
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	public String getCountry(byte[] ipBytes)
	{
		if (ipFile == null)
		{
			return "Invalid IP data file path";
		}
		
		String ipString = getString(ipBytes);
		if (ipCache.containsKey(ipString))
		{
			IPEntity ipEntity = (IPEntity) ipCache.get(ipString);
			
			return ipEntity.getCountry();
		}
		else
		{
			IPEntity ipEntity = getIPEntity(ipBytes);
			ipCache.put(ipString, ipEntity.clone());
			
			return ipEntity.getCountry();
		}
	}
	
	public String getCountry(String ipString)
	{
		return getCountry(getBytes(ipString));
	}
	
	public String getRegion(byte[] ipBytes)
	{
		if (ipFile == null)
		{
			return "Invalid IP data file path";
		}
		
		String ipString = getString(ipBytes);
		if (ipCache.containsKey(ipString))
		{
			IPEntity ipEntity = (IPEntity) ipCache.get(ipString);
			
			return ipEntity.getRegion();
		}
		else
		{
			IPEntity ipEntity = getIPEntity(ipBytes);
			ipCache.put(ipString, ipEntity.clone());
			
			return ipEntity.getRegion();
		}
	}
	
	public String getRegion(String ipString)
	{
		return getRegion(getBytes(ipString));
	}
	
	private String readRegion(long offset)
		throws IOException
	{
		ipFile.seek(offset);
		byte ipByte = ipFile.readByte();
		if (ipByte == REDIRECT_MODE_1 || ipByte == REDIRECT_MODE_2)
		{
			long regionOffset = readLong3(offset + 1);
			if (regionOffset == 0)
			{
				return "Unknown Region";
			}
			else
			{
				return readString(regionOffset);
			}
		}
		else
		{
			return readString(offset);
		}
	}
	
	private String readRegion(int offset)
	{
		ipByteBuffer.position(offset);
		byte ipByte = ipByteBuffer.get();
		if (ipByte == REDIRECT_MODE_1 || ipByte == REDIRECT_MODE_2)
		{
			int regionOffset = readInt3();
			if (regionOffset == 0)
			{
				return "Unknown Region";
			}
			else
			{
				return readString(regionOffset);
			}
		}
		else
		{
			return readString(offset);
		}
	}
	
	private IPEntity getIPEntity(byte[] ipBytes)
	{
		IPEntity ipEntity = null;
		long offset = locateIP(ipBytes);
		if (offset != -1)
		{
			ipEntity = getIPEntity(offset);
		}
		if (ipEntity == null)
		{
			ipEntity = new IPEntity();
			ipEntity.setCountry("Unknown Country");
			ipEntity.setRegion("Unknown Region");
		}
		
		return ipEntity;
	}
	
	private IPEntity getIPEntity(long offset)
	{
		try
		{
			ipFile.seek(offset + 4);
			byte ipByte = ipFile.readByte();
			if (ipByte == REDIRECT_MODE_1)
			{
				long countryOffset = readLong3();
				ipFile.seek(countryOffset);
				ipByte = ipFile.readByte();
				if (ipByte == REDIRECT_MODE_2)
				{
					ipEntity.setCountry(readString(readLong3()));
					ipFile.seek(countryOffset + 4);
				}
				else
				{
					ipEntity.setCountry(readString(countryOffset));
				}
				ipEntity.setRegion(readRegion(ipFile.getFilePointer()));
			}
			else if (ipByte == REDIRECT_MODE_2)
			{
				ipEntity.setCountry(readString(readLong3()));
				ipEntity.setRegion(readRegion(offset + 8));
			}
			else
			{
				ipEntity.setCountry(readString(ipFile.getFilePointer() - 1));
				ipEntity.setRegion(readRegion(ipFile.getFilePointer()));
			}
			
			return ipEntity;
		}
		catch (IOException e)
		{
			return null;
		}
	}
	
	private IPEntity getIPEntity(int offset)
	{
		ipByteBuffer.position(offset + 4);
		byte ipByte = ipByteBuffer.get();
		if (ipByte == REDIRECT_MODE_1)
		{
			int countryOffset = readInt3();
			ipByteBuffer.position(countryOffset);
			ipByte = ipByteBuffer.get();
			if (ipByte == REDIRECT_MODE_2)
			{
				ipEntity.setCountry(readString(readInt3()));
				ipByteBuffer.position(countryOffset + 4);
			}
			else
			{
				ipEntity.setCountry(readString(countryOffset));
			}
			ipEntity.setRegion(readRegion(ipByteBuffer.position()));
		}
		else if (ipByte == REDIRECT_MODE_2)
		{
			ipEntity.setCountry(readString(readInt3()));
			ipEntity.setRegion(readRegion(offset + 8));
		}
		else
		{
			ipEntity.setCountry(readString(ipByteBuffer.position() - 1));
			ipEntity.setRegion(readRegion(ipByteBuffer.position()));
		}
		
		return ipEntity;
	}
	
	private long locateIP(byte[] ipBytes)
	{
		long m = 0;
		int r;
		readIP(ipStart, b4);
		r = compareIP(ipBytes, b4);
		if (r == 0)
		{
			return ipStart;
		}
		else if (r < 0)
		{
			return -1;
		}
		for (long i = ipStart, j = ipEnd; i < j;)
		{
			m = getMiddleOffset(i, j);
			readIP(m, b4);
			r = compareIP(ipBytes, b4);
			if (r > 0)
			{
				i = m;
			}
			else if (r < 0)
			{
				if (m == j)
				{
					j -= IP_RECORD_LENGTH;
					m = j;
				}
				else
				{
					j = m;
				}
			}
			else
			{
				return readLong3(m + 4);
			}
		}
		m = readLong3(m + 4);
		readIP(m, b4);
		r = compareIP(ipBytes, b4);
		if (r <= 0)
		{
			return m;
		}
		else
		{
			return -1;
		}
	}
	
	private void readIP(long offset, byte[] ipBytes)
	{
		try
		{
			ipFile.seek(offset);
			ipFile.readFully(ipBytes);
			byte value = ipBytes[0];
			ipBytes[0] = ipBytes[3];
			ipBytes[3] = value;
			value = ipBytes[1];
			ipBytes[1] = ipBytes[2];
			ipBytes[2] = value;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void readIP(int offset, byte[] ipBytes)
	{
		ipByteBuffer.position(offset);
		ipByteBuffer.get(ipBytes);
		byte value = ipBytes[0];
		ipBytes[0] = ipBytes[3];
		ipBytes[3] = value;
		value = ipBytes[1];
		ipBytes[1] = ipBytes[2];
		ipBytes[2] = value;
	}
	
	private int compareIP(byte[] ipBytes, byte[] startIp)
	{
		for (int i = 0; i < 4; i++)
		{
			int r = compareByte(ipBytes[i], startIp[i]);
			if (r != 0)
			{
				return r;
			}
		}
		
		return 0;
	}
	
	private int compareByte(byte byte1, byte byte2)
	{
		if ((byte1 & 0xFF) > (byte2 & 0xFF))
		{
			return 1;
		}
		else if ((byte1 ^ byte2) == 0)
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}
	
	private int readInt3(int offset)
	{
		ipByteBuffer.position(offset);
		
		return ipByteBuffer.getInt() & 0x00FFFFFF;
	}
	
	private int readInt3()
	{
		return ipByteBuffer.getInt() & 0x00FFFFFF;
	}
	
	private long readLong4(long offset)
	{
		long value = 0;
		try
		{
			ipFile.seek(offset);
			value |= (ipFile.readByte() & 0xFF);
			value |= ((ipFile.readByte() << 8) & 0xFF00);
			value |= ((ipFile.readByte() << 16) & 0xFF0000);
			value |= ((ipFile.readByte() << 24) & 0xFF000000);
			
			return value;
		}
		catch (IOException e)
		{
			return -1;
		}
	}
	
	private long readLong3(long offset)
	{
		long value = 0;
		try
		{
			ipFile.seek(offset);
			ipFile.readFully(b3);
			value |= (b3[0] & 0xFF);
			value |= ((b3[1] << 8) & 0xFF00);
			value |= ((b3[2] << 16) & 0xFF0000);
			
			return value;
		}
		catch (IOException e)
		{
			return -1;
		}
	}
	
	private long readLong3()
	{
		long value = 0;
		try
		{
			ipFile.readFully(b3);
			value |= (b3[0] & 0xFF);
			value |= ((b3[1] << 8) & 0xFF00);
			value |= ((b3[2] << 16) & 0xFF0000);
			
			return value;
		}
		catch (IOException e)
		{
			return -1;
		}
	}
	
	private long getMiddleOffset(long start, long end)
	{
		long records = (end - start) / IP_RECORD_LENGTH;
		records >>= 1;
		if (records == 0)
		{
			records = 1;
		}
		
		return start + records * IP_RECORD_LENGTH;
	}
	
	private byte[] getBytes(String ipString)
	{
		byte[] ipBytes = new byte[4];
		StringTokenizer st = new StringTokenizer(ipString, ".");
		try
		{
			ipBytes[0] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ipBytes[1] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ipBytes[2] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ipBytes[3] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return ipBytes;
	}
	
	private String readString(long offset)
	{
		try
		{
			ipFile.seek(offset);
			int i;
			for (i = 0, buffer[i] = ipFile.readByte(); buffer[i] != 0; buffer[++i] = ipFile.readByte())
			{
				;
			}
			
			if (i != 0)
			{
				return getString(buffer, 0, i, "GBK");
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return "";
	}
	
	private String readString(int offset)
	{
		try
		{
			ipByteBuffer.position(offset);
			int i;
			for (i = 0, buffer[i] = ipByteBuffer.get(); buffer[i] != 0; buffer[++i] = ipByteBuffer.get())
			{
				;
			}
			   
			if (i != 0)
			{
				return getString(buffer, 0, i, "GBK");
			}
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		return "";
	}
	
	private String getString(byte[] ipBytes)
	{
		ipStringBuffer.delete(0, ipStringBuffer.length());
		ipStringBuffer.append(ipBytes[0] & 0xFF);
		ipStringBuffer.append('.');
		ipStringBuffer.append(ipBytes[1] & 0xFF);
		ipStringBuffer.append('.');
		ipStringBuffer.append(ipBytes[2] & 0xFF);
		ipStringBuffer.append('.');
		ipStringBuffer.append(ipBytes[3] & 0xFF);
		
		return ipStringBuffer.toString();
	}
	
	private String getString(byte[] ipBytes, int offset, int length, String encoding)
	{
		try
		{
			return new String(ipBytes, offset, length, encoding);
		}
		catch (UnsupportedEncodingException e)
		{
			return new String(ipBytes, offset, length);
		}
	}
}