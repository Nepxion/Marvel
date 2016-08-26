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

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class URLContext
	implements URLConstants
{
	private static Log log = LogFactory.getLog(URLContext.class);
	
	/**
	 * The instance of LinkedHashMap.
	 */
	private static LinkedHashMap urlConfigMap;
	
	/**
	 * Registers the url config by the default config file path.
	 * @throws Exception
	 */
	public static void register()
		throws Exception
	{
		register(CONFIG_FILE_PATH);
	}
	
	/**
	 * Registers the url config by a config file path.
	 * @param filePath the config file path
	 * @throws Exception
	 */
	public static void register(String filePath)
		throws Exception
	{
		log.info("----- URL Context Initialization Start -----");
		
		urlConfigMap = new LinkedHashMap();
		Properties properties = new Properties();
		
		InputStream inputStream = null;
		try
		{
			inputStream = new FileInputStream(filePath);
			properties.load(inputStream);
			
			parseConfig(properties);
		}
		catch (Exception e)
		{
			log.fatal(e);
			
			throw e;
		}
		finally
		{
			if (inputStream != null)
			{
				inputStream.close();
			}	
		}
		
		log.info("------ URL Context Initialization End ------");
	}
	
	/**
	 * Registers the url config by a properties object.
	 * @param properties the instance of Properties
	 * @throws Exception
	 */
	public static void register(Properties properties)
		throws Exception
	{
		log.info("----- URL Context Initialization Start -----");
		
		try
		{
			parseConfig(properties);
		}
		catch (Exception e)
		{
			log.fatal(e);
			
			throw e;
		}
		
		log.info("------ URL Context Initialization End ------");
	}
	
	/**
	 * Registers the url config by an url.
	 * @param codeBase the instance of URL
	 * @throws Exception
	 */
	public static void register(URL codeBase)
		throws Exception
	{
		log.info("----- URL Context Initialization Start -----");
		
		urlConfigMap = new LinkedHashMap();
		Properties properties = new Properties();
		try
		{
			URL url = new URL(codeBase + CONFIG_FILE_PATH);
			properties.load(url.openStream());
			
			parseConfig(properties, url);
		}
		catch (Exception e)
		{
			log.fatal(e);
			
			throw e;
		}
		
		log.info("------ URL Context Initialization End ------");
	}
	
	/**
	 * Gets the url config by an alias.
	 * @param alias the alias string
	 * @return the instance of URLConfig
	 */
	public static URLConfig getConfig(String alias)
	{
		URLConfig urlConfig = (URLConfig) urlConfigMap.get(alias);
		if (urlConfig == null)
		{
			throw new IllegalArgumentException("URL Config for " + alias + " hasn't been found");
		}
		
		return urlConfig;
	}
	
	/**
	 * Parses the properties to url config map.
	 * @param properties the instance of Properties
	 * @throws Exception
	 */
	private static void parseConfig(Properties properties)
		throws Exception
	{
		parseConfig(properties, null);
	}
	
	/**
	 * Parses the properties to url config map with an url.
	 * @param properties the instance of Properties
	 * @param url the instance of URL
	 * @throws Exception
	 */
	private static void parseConfig(Properties properties, URL url)
		throws Exception
	{
		HashMap propertiesMap = new HashMap();
		for (Iterator iterator = properties.keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			String value = properties.getProperty(key);
			
			if (key.startsWith(PREFIX))
			{
				int index = key.indexOf(DOT);
				if (index == -1)
				{
					throw new Exception("Property " + key + " must be of the format " + PREFIX + "*" + DOT + "*");
				}
				String prefix = key.substring(0, index);
				String name = key.substring(index + 1);
				Properties configProperties = (Properties) propertiesMap.get(prefix);
				if (configProperties == null)
				{
					configProperties = new Properties();
					propertiesMap.put(prefix, configProperties);
				}
				configProperties.put(name, value);
			}
		}
		
		for (Iterator iterator = propertiesMap.keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			Properties configProperties = (Properties) propertiesMap.get(key);
			URLConfig config = createConfig(configProperties, url);
			urlConfigMap.put(config.getAlias(), config);
		}
		
		URLLogger.info(urlConfigMap);
	}
	
	/**
	 * Creates the url config by a configProperties and url.
	 * @param properties the instance of Properties
	 * @param url the instance of URL
	 * @return the instance of URLConfig
	 */
	private static URLConfig createConfig(Properties properties, URL url)
	{
		URLConfig urlConfig = new URLConfig();
		
		urlConfig.setAlias(properties.getProperty(ALIAS));
		if (!properties.getProperty(HOST).equals(""))
		{
			urlConfig.setHost(properties.getProperty(HOST));
		}
		else
		{
			if (url != null)
			{
				urlConfig.setHost(url.getHost());
			}
		}
		if (!properties.getProperty(PORT).equals(""))
		{
			urlConfig.setPort(Integer.parseInt(properties.getProperty(PORT)));
		}
		else
		{
			if (url != null)
			{
				urlConfig.setPort(url.getPort());
			}
		}
		urlConfig.setPath(properties.getProperty(PATH));
		
		return urlConfig;
	}
}