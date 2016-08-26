package com.nepxion.util.net.http;

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

public class HttpLogger
{
	private static Log log = LogFactory.getLog(HttpLogger.class);
	
	/**
	 * Prints the http logger info.
	 * @param httpConfigMap the instance of LinkedHashMap
	 */
	public static void info(LinkedHashMap httpConfigMap)
	{
		int index = 0;
		int size = httpConfigMap.keySet().size() - 1;
		for (Iterator iterator = httpConfigMap.keySet().iterator(); iterator.hasNext();)
		{
			String alias = (String) iterator.next();			
			HttpConfig httpConfig = (HttpConfig) httpConfigMap.get(alias);
			log.info("Alias : " + httpConfig.getAlias());
			log.info("Host : " + httpConfig.getHost());
			log.info("Port : " + httpConfig.getPort());
			log.info("Path : " + httpConfig.getPath());
			log.info("Connection TimeOut : " + httpConfig.getConnectionTimeOut());
			log.info("Response TimeOut : " + httpConfig.getResponseTimeOut());
			log.info("Buffer Size : " + httpConfig.getBufferSize());
			if (index < size)
			{	
				log.info("---------------------------------------------");
			}
			index++;
		}		
	}
}