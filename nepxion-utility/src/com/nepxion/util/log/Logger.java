package com.nepxion.util.log;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.util.exception.ExceptionUtil;
import com.nepxion.util.time.TimeUtil;

public class Logger
{		
	/**
	 * Prints the log info with the currently time.
	 * @param message the message object
	 */
	public static void print(Object message)
	{
		System.out.println(TimeUtil.getCurrentTime() + " : " + message);
	}
	
	/**
	 * Prints the log info for exception with the currently time.
	 * @param e the instance of Exception
	 */
	public static void print(Exception e)
	{		
		System.out.print(TimeUtil.getCurrentTime() + " : ");
		System.err.println(ExceptionUtil.getText(e));
	}	
}