package com.nepxion.util.string;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class StringUtil
{
	/**
	 * Parses to the int array by a text.
	 * @param text the text string
	 * @return the int array
	 */
	public static int[] parseIntArray(String text)
	{
		text = StringUtils.deleteWhitespace(text);
		
		String[] stringArray = text.split(",");
		int[] intArray = new int[stringArray.length];
		
		for (int i = 0; i < stringArray.length; i++)
		{
			intArray[i] = Integer.parseInt(stringArray[i]);
		}
		
		return intArray;
	}
	
	/**
	 * Parses to the two-dimensional int array by a text.
	 * @param text the text string
	 * @return the two-dimensional int array
	 */
	public static int[][] parseInt2Array(String text)
	{
		text = StringUtils.deleteWhitespace(text);
		
		List arrayList = new ArrayList();
		
		while (StringUtils.substringBetween(text, "{", "}") != null)
		{
			String subText = StringUtils.substringBetween(text, "{", "}");
			int[] intArray = parseIntArray(subText);
			arrayList.add(intArray);
			
			int index = text.indexOf("},");
			if (index < 0)
			{
				break;
			}
			
			text = text.substring(text.indexOf("},") + 1).trim();
		}
		
		int[][] int2Array = new int[arrayList.size()][];
		int i = 0;
		for (Iterator iterator = arrayList.iterator(); iterator.hasNext();)
		{
			int2Array[i] = (int[]) iterator.next();
			
			i++;
		}
		
		return int2Array;
	}
	
	/**
	 * Parses to the byte array by a text.
	 * @param text the text string
	 * @return the byte array
	 */
	public static byte[] parseByteArray(String text)
	{
		text = StringUtils.deleteWhitespace(text);
		
		String[] stringArray = text.split(",");
		byte[] byteArray = new byte[stringArray.length];
		
		for (int i = 0; i < stringArray.length; i++)
		{
			byteArray[i] = Byte.parseByte(stringArray[i]);
		}
		
		return byteArray;
	}
	
	/**
	 * Parses to the two-dimensional byte array by a text.
	 * @param text the text string
	 * @return the two-dimensional byte array
	 */
	public static byte[][] parseByte2Array(String text)
	{
		text = StringUtils.deleteWhitespace(text);
		
		List arrayList = new ArrayList();
		
		while (StringUtils.substringBetween(text, "{", "}") != null)
		{
			String subText = StringUtils.substringBetween(text, "{", "}");
			byte[] byteArray = parseByteArray(subText);
			arrayList.add(byteArray);
			
			int index = text.indexOf("},");
			if (index < 0)
			{
				break;
			}
			
			text = text.substring(text.indexOf("},") + 1).trim();
		}
		
		byte[][] byte2Array = new byte[arrayList.size()][];
		int i = 0;
		for (Iterator iterator = arrayList.iterator(); iterator.hasNext();)
		{
			byte2Array[i] = (byte[]) iterator.next();
			
			i++;
		}
		
		return byte2Array;
	}
	
	/**
	 * Parses to the short array by a text.
	 * @param text the text string
	 * @return the short array
	 */
	public static short[] parseShortArray(String text)
	{
		text = StringUtils.deleteWhitespace(text);
		
		String[] stringArray = text.split(",");
		short[] shortArray = new short[stringArray.length];
		
		for (int i = 0; i < stringArray.length; i++)
		{
			shortArray[i] = Short.parseShort(stringArray[i]);
		}
		
		return shortArray;
	}
	
	/**
	 * Parses to the two-dimensional short array by a text.
	 * @param text the text string
	 * @return the two-dimensional short array
	 */
	public static short[][] parseShort2Array(String text)
	{
		text = StringUtils.deleteWhitespace(text);
		
		List arrayList = new ArrayList();
		
		while (StringUtils.substringBetween(text, "{", "}") != null)
		{
			String subText = StringUtils.substringBetween(text, "{", "}");
			short[] shortArray = parseShortArray(subText);
			arrayList.add(shortArray);
			
			int index = text.indexOf("},");
			if (index < 0)
			{
				break;
			}
			
			text = text.substring(text.indexOf("},") + 1).trim();
		}
		
		short[][] short2Array = new short[arrayList.size()][];
		int i = 0;
		for (Iterator iterator = arrayList.iterator(); iterator.hasNext();)
		{
			short2Array[i] = (short[]) iterator.next();
			
			i++;
		}
		
		return short2Array;
	}
	
	/**
	 * Parses to the long array by a text.
	 * @param text the text string
	 * @return the long array
	 */
	public static long[] parseLongArray(String text)
	{
		text = StringUtils.deleteWhitespace(text);
		
		String[] stringArray = text.split(",");
		long[] longArray = new long[stringArray.length];
		
		for (int i = 0; i < stringArray.length; i++)
		{
			longArray[i] = Long.parseLong(stringArray[i]);
		}
		
		return longArray;
	}
	
	/**
	 * Parses to the two-dimensional long array by a text.
	 * @param text the text string
	 * @return the two-dimensional long array
	 */
	public static long[][] parseLong2Array(String text)
	{
		text = StringUtils.deleteWhitespace(text);
		
		List arrayList = new ArrayList();
		
		while (StringUtils.substringBetween(text, "{", "}") != null)
		{
			String subText = StringUtils.substringBetween(text, "{", "}");
			long[] longArray = parseLongArray(subText);
			arrayList.add(longArray);
			
			int index = text.indexOf("},");
			if (index < 0)
			{
				break;
			}
			
			text = text.substring(text.indexOf("},") + 1).trim();
		}
		
		long[][] long2Array = new long[arrayList.size()][];
		int i = 0;
		for (Iterator iterator = arrayList.iterator(); iterator.hasNext();)
		{
			long2Array[i] = (long[]) iterator.next();
			
			i++;
		}
		
		return long2Array;
	}
	
	/**
	 * Parses to the float array by a text.
	 * @param text the text string
	 * @return the float array
	 */
	public static float[] parseFloatArray(String text)
	{
		text = StringUtils.deleteWhitespace(text);
		
		String[] stringArray = text.split(",");
		float[] floatArray = new float[stringArray.length];
		
		for (int i = 0; i < stringArray.length; i++)
		{
			floatArray[i] = Float.parseFloat(stringArray[i]);
		}
		
		return floatArray;
	}
	
	/**
	 * Parses to the two-dimensional float array by a text.
	 * @param text the text string
	 * @return the two-dimensional float array
	 */
	public static float[][] parseFloat2Array(String text)
	{
		text = StringUtils.deleteWhitespace(text);
		
		List arrayList = new ArrayList();
		
		while (StringUtils.substringBetween(text, "{", "}") != null)
		{
			String subText = StringUtils.substringBetween(text, "{", "}");
			float[] floatArray = parseFloatArray(subText);
			arrayList.add(floatArray);
			
			int index = text.indexOf("},");
			if (index < 0)
			{
				break;
			}
			
			text = text.substring(text.indexOf("},") + 1).trim();
		}
		
		float[][] float2Array = new float[arrayList.size()][];
		int i = 0;
		for (Iterator iterator = arrayList.iterator(); iterator.hasNext();)
		{
			float2Array[i] = (float[]) iterator.next();
			
			i++;
		}
		
		return float2Array;
	}
	
	/**
	 * Parses to the double array by a text.
	 * @param text the text string
	 * @return the double array
	 */
	public static double[] parseDoubleArray(String text)
	{
		text = StringUtils.deleteWhitespace(text);
		
		String[] stringArray = text.split(",");
		double[] doubleArray = new double[stringArray.length];
		
		for (int i = 0; i < stringArray.length; i++)
		{
			doubleArray[i] = Double.parseDouble(stringArray[i]);
		}
		
		return doubleArray;
	}
	
	/**
	 * Parses to the two-dimensional double array by a text.
	 * @param text the text string
	 * @return the two-dimensional double array
	 */
	public static double[][] parseDouble2Array(String text)
	{
		text = StringUtils.deleteWhitespace(text);
		
		List arrayList = new ArrayList();
		
		while (StringUtils.substringBetween(text, "{", "}") != null)
		{
			String subText = StringUtils.substringBetween(text, "{", "}");
			double[] doubleArray = parseDoubleArray(subText);
			arrayList.add(doubleArray);
			
			int index = text.indexOf("},");
			if (index < 0)
			{
				break;
			}
			
			text = text.substring(text.indexOf("},") + 1).trim();
		}
		
		double[][] double2Array = new double[arrayList.size()][];
		int i = 0;
		for (Iterator iterator = arrayList.iterator(); iterator.hasNext();)
		{
			double2Array[i] = (double[]) iterator.next();
			
			i++;
		}
		
		return double2Array;
	}
}