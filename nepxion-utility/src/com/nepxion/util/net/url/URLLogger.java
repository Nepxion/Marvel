package com.nepxion.util.net.url;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.Iterator;
import java.util.LinkedHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class URLLogger
{
	private static Log log = LogFactory.getLog(URLLogger.class);
	
	/**
	 * Prints the url logger info.
	 * @param urlConfigMap the instance of LinkedHashMap
	 */
	public static void info(LinkedHashMap urlConfigMap)
	{
		int index = 0;
		int size = urlConfigMap.keySet().size() - 1;
		for (Iterator iterator = urlConfigMap.keySet().iterator(); iterator.hasNext();)
		{
			String alias = (String) iterator.next();			
			URLConfig urlConfig = (URLConfig) urlConfigMap.get(alias);
			log.info("Alias : " + urlConfig.getAlias());
			log.info("Host : " + urlConfig.getHost());
			log.info("Port : " + urlConfig.getPort());
			log.info("Path : " + urlConfig.getPath());
			if (index < size)
			{	
				log.info("---------------------------------------------");
			}
			index++;
		}		
	}
}