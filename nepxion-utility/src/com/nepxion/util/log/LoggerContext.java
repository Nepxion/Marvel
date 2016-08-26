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

import java.net.URL;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class LoggerContext
	implements LoggerConstants
{	
	/**
	 * Registers the logger by the default config file path.
	 * @throws Exception
	 */
	public static void register()
		throws Exception
	{
		register(CONFIG_FILE_PATH);
	}
	
	/**
	 * Registers the logger by a config file path.
	 * @param filePath the config file path 
	 * @throws Exception
	 */
	public static void register(String filePath)
		throws Exception
	{		
		PropertyConfigurator.configure(filePath);
	}
	
	/**
	 * Registers the logger by a properties object.
	 * @param properties the instance of Properties
	 * @throws Exception
	 */
	public static void register(Properties properties)
		throws Exception
	{
		PropertyConfigurator.configure(properties);
	}
	
	/**
	 * Registers the logger by an url.
	 * @param codeBase the instance of URL
	 * @throws Exception
	 */
	public static void register(URL codeBase)
		throws Exception
	{
		Properties properties = new Properties();

		URL url = new URL(codeBase + CONFIG_FILE_PATH);
		properties.load(url.openStream());
	
		register(properties);
	}
}