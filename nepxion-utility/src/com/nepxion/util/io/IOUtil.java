package com.nepxion.util.io;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import com.nepxion.util.encoder.EncoderContext;

public class IOUtil
{
	/**
	 * Writes the object to an outputStream.
	 * @param outputStream the instance of OutputStream
	 * @param object the object
	 * @throws IOException
	 */
	public static void write(OutputStream outputStream, Object object)
		throws IOException
	{
		ObjectOutputStream oos = null;
		try
		{
			oos = new ObjectOutputStream(outputStream);
			oos.writeObject(object);
			oos.flush();
		}
		catch (IOException e)
		{
			throw e;
		}
		finally
		{
			if (oos != null)
			{	
				oos.close();
			}	
		}
	}
	
	/**
	 * Reads the object from an inputStream.
	 * @param inputStream the instance of InputStream
	 * @return the object
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object read(InputStream inputStream)
		throws IOException, ClassNotFoundException
	{
		Object object = null;
		ObjectInputStream ois = null;
		try
		{
			ois = new ObjectInputStream(inputStream);
			object = ois.readObject();
		}
		catch (IOException e)
		{
			throw e;
		}
		catch (ClassNotFoundException e)
		{
			throw e;
		}
		finally
		{
			if (ois != null)
			{	
				ois.close();
			}
		}
		
		return object;
	}
	
	/**
	 * Writes the object to an outputStream.
	 * @param object the object
	 * @return the instance of ByteArrayOutputStream
	 * @throws IOException
	 */
	public static ByteArrayOutputStream write(Object object)
		throws IOException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		write(baos, object);

		baos.flush();
		baos.close();
		
		return baos;
	}
	
	/**
	 * Reads the object from an outputStream.
	 * @param outputStream the instance of ByteArrayOutputStream
	 * @return the object
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object read(ByteArrayOutputStream outputStream)
		throws IOException, ClassNotFoundException
	{
		ByteArrayInputStream bais = new ByteArrayInputStream(outputStream.toByteArray());
		Object object = read(bais);

		bais.close();
		
		return object;
	}
	
	/**
	 * Gets the inputStream by a object.
	 * @param object the object
	 * @return the instance of ByteArrayInputStream
	 * @throws IOException
	 */
	public static ByteArrayInputStream getInputStream(Object object)
		throws IOException
	{
		ByteArrayOutputStream baos = write(object);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		
		return bais;
	}
	
	/**
	 * Gets the object by an inputStream.
	 * @param inputStream the instance of InputStream
	 * @return the object
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object getObject(InputStream inputStream)
		throws IOException, ClassNotFoundException
	{
		return read(inputStream);
	}
	
	/**
	 * Gets the inputStream by a text.
	 * @param text the text string
	 * @return the instance of ByteArrayInputStream
	 */
	public static ByteArrayInputStream getInputStream(String text)
	{
		ByteArrayInputStream bais = new ByteArrayInputStream(text.getBytes());
		
		return bais;
	}
	
	/**
	 * Gets the text by an inputStream.
	 * The charset is registered in EncoderContext.
	 * @param inputStream the instance of InputStream
	 * @return the text string
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	public static String getString(InputStream inputStream)
		throws IOException, UnsupportedEncodingException
	{
		return getString(inputStream, EncoderContext.getIOCharset());
	}
	
	/**
	 * Gets the text by an inputStream with the charset formatted.
	 * @param inputStream the instance of InputStream
	 * @param charset the charset string
	 * @return the text string
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	public static String getString(InputStream inputStream, String charset)
		throws IOException, UnsupportedEncodingException
	{
		StringBuffer stringBuffer = new StringBuffer();
		
		InputStreamReader inputStreamReader = null;
		try
		{
			inputStreamReader = new InputStreamReader(inputStream, charset);
			
			char[] bytes = new char[4096];
			int index = -1;
			while ((index = inputStreamReader.read(bytes)) != -1)
			{
				stringBuffer.append(new String(bytes, 0, index));
			}			
		}
		catch (UnsupportedEncodingException e)
		{
			throw e;
		}
		catch (IOException e)
		{
			throw e;
		}
		finally
		{
			if (inputStreamReader != null)
			{
				inputStreamReader.close();
			}
		}
		
		return stringBuffer.toString().trim();
	}
	
	/**
	 * Reads the text from an inputStream.
	 * The charset is registered in EncoderContext.
	 * @param inputStream the instance of InputStream
	 * @param emptyLineRemoved the flag of emptyLineRemoved
	 * @return the text string
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	public static String readString(InputStream inputStream, boolean emptyLineRemoved)
		throws IOException, UnsupportedEncodingException
	{
		return readString(inputStream, EncoderContext.getIOCharset(), emptyLineRemoved);
	}
	
	/**
	 * Reads the text from an inputStream with the charset formatted.
	 * @param inputStream the instance of InputStream
	 * @param charset the charset string
	 * @param emptyLineRemoved the flag of emptyLineRemoved
	 * @return the text string
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	public static String readString(InputStream inputStream, String charset, boolean emptyLineRemoved)
		throws IOException, UnsupportedEncodingException
	{
		StringBuffer stringBuffer = new StringBuffer();
		
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		try
		{
			inputStreamReader = new InputStreamReader(inputStream, charset);
			bufferedReader = new BufferedReader(inputStreamReader);
			
			String line = null;
			while ((line = bufferedReader.readLine()) != null)
			{
				if (emptyLineRemoved)
				{	
					if (!line.equals(""))
					{
						stringBuffer.append(line + "\n");
					}
				}
				else
				{
					stringBuffer.append(line + "\n");
				}
			}
		}
		catch (IOException e)
		{
			throw e;
		}
		finally
		{
			if (bufferedReader != null)
			{	
				bufferedReader.close();
			}
		}
		
		return stringBuffer.toString().trim();
	}
	
	/**
	 * Gets the deep clone object.
	 * @param object the origin object
	 * @return the clone object
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object deepClone(Object object)
		throws IOException, ClassNotFoundException
	{		
		/*ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(object);
		oos.flush();
		baos.flush();
		oos.close();
		baos.close();
		
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		Object cloneObject = ois.readObject();
		ois.close();
		bais.close();*/
		
		ByteArrayOutputStream baos = write(object);
		Object cloneObject = read(baos);
		
		return cloneObject;
	}
	
	public static void main(String[] args)
	{
		String[] array = {"Value1", "Value2", "Value3"};
		InputStream arrayInputStream = null;
		try
		{
			arrayInputStream = getInputStream(array);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("getInputStream() : " + arrayInputStream);
		
		String[] object = null;
		try
		{
			object = (String[]) getObject(arrayInputStream);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		System.out.println("getObject() : [" + object[0] + ", " + object[1] + ", " + object[2] + "]");
		
		String text = "Value1, Value2, Value3";
		InputStream stringInputStream = getInputStream(text);
		System.out.println("getInputStream() : " + stringInputStream);
		
		String string = null;
		try
		{
			string = getString(stringInputStream, "UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		System.out.println("getString() : " + string);
	}
}