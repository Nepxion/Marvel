package com.nepxion.util.data;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.Random;

public class RandomUtil
{
	/**
	 * The char list for A-Z.
	 */
	public static final String CHAR_LIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	/**
	 * Gets the random char in A-Z.
	 * @return the random char
	 */
	public static char getRandomChar()
	{
		char[] chars = CHAR_LIST.toCharArray();
		Random random = new Random();
		int randomIndex = random.nextInt(chars.length);
		
		return chars[randomIndex];
	}
	
	/**
	 * Gets the random number of int type within the min and max int value.
	 * @param min the min int value 
	 * @param max the max int value
	 * @return the random number of int type
	 */
	public static int getRandomInt(int min, int max)
	{
		Random random = new Random();
		
		return random.nextInt(max - min + 1) + min;
	}
	
	/**
	 * Gets the random number of double type within the min and max int value.
	 * @param min the min int value 
	 * @param max the max int value
	 * @return the random number of double type
	 */
	public static double getRandomDouble(int min, int max)
	{
		return Math.random() * (max - min) + min;
	}
}