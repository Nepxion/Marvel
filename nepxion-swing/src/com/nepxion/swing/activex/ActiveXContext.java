package com.nepxion.swing.activex;

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

public class ActiveXContext
	implements ActiveXConstants
{
	private static Log log = LogFactory.getLog(ActiveXContext.class);
	
	/**
	 * The strategy of activeX invoking.
	 * The value is STRATEGY_APPLICATION or STRATEGY_APPLET
	 */
	private static int strategy = STRATEGY_APPLICATION;
	
	/**
	 * Registers the strategy.
	 * @param strategy the strategy value
	 */
	public static void registerStrategy(int strategy)
	{
		log.info("----- ActiveX Context Initialization Start -----");
		
		ActiveXContext.strategy = strategy;
		
		if (strategy == STRATEGY_APPLICATION)
		{
			log.info("ActiveX Invoker Strategy : Application");
		}
		else if (strategy == STRATEGY_APPLET)
		{
			log.info("ActiveX Invoker Strategy : Applet");
		}
		else
		{
			log.info("ActiveX Invoker Strategy : Unknown");
		}
		
		log.info("------ ActiveX Context Initialization End ------");
	}
	
	/**
	 * Gets the strategy.
	 * @return the strategy value
	 */
	public static int getStrategy()
	{
		return strategy;
	}
}