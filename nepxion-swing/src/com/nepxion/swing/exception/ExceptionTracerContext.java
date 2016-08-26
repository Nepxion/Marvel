package com.nepxion.swing.exception;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExceptionTracerContext
{
	private static Log log = LogFactory.getLog(ExceptionTracerContext.class);
	
	/**
	 * The boolean value of debug.
	 */
	private static boolean debug = false;
	
	/**
	 * Registers the debug.
	 * @param debug the boolean value of debug
	 */
	public static void register(boolean debug)
	{		
		ExceptionTracerContext.debug = debug;
		
		log.info("Exception Tracer Debug : " + debug);
	}
	
	/**
	 * Returns true if debuging.
	 * @return true if debuging
	 */
	public static boolean isDebug()
	{
		return debug;
	}
}