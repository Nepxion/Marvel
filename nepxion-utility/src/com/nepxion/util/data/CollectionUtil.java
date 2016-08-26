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

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class CollectionUtil
{
	/**
	 * Parses the array to the list.
	 * @param array the array 
	 * @return the instance of List
	 */
	public static List parseList(Object[] array)
	{
		return Arrays.asList(array);
	}
	
	/**
	 * Parses the list to the array.
	 * @param list the instance of List 
	 * @return the array 
	 */	
	public static Object[] parseArray(List list)
	{
		return list.toArray();
	}	
	
	/**
	 * Parses the array to the vector.
	 * @param array the array
	 * @return the instance of Vector
	 */
	public static Vector parseVector(Object[] array)
	{
		return new Vector(Arrays.asList(array));
	}
	
	/**
	 * Parses the list to the vector.
	 * @param list the instance of List
	 * @return the instance of Vector
	 */	
	public static Vector parseVector(List list)
	{
		return new Vector(list);
	}
	
	/**
	 * Parses the vector to array.
	 * @param vector the instance of Vector
	 * @return the array
	 */		
	public static Object[] parseArray(Vector vector)
	{
		return vector.toArray();
	}
}