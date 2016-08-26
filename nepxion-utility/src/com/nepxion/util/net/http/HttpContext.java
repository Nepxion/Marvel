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

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpContext
	implements HttpConstants
{
	private static Log log = LogFactory.getLog(HttpContext.class);
	
	/**
	 * The instance of LinkedHashMap.
	 */
	private static LinkedHashMap httpConfigMap;
	
	/**
	 * Registers the http config by the default config file path.
	 * @throws Exception
	 */
	public static void register()
		throws Exception
	{
		register(CONFIG_FILE_PATH);
	}
	
	/**
	 * Registers the http config by a config file path.
	 * @param filePath the config file path
	 * @throws Exception
	 */
	public static void register(String filePath)
		throws Exception
	{
		log.info("----- Http Context Initialization Start -----");
		
		httpConfigMap = new LinkedHashMap();
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
		
		log.info("------ Http Context Initialization End ------");
	}
	
	/**
	 * Registers the http config by a properties object.
	 * @param properties the instance of Properties
	 * @throws Exception
	 */
	public static void register(Properties properties)
		throws Exception
	{
		log.info("----- Http Context Initialization Start -----");
		
		try
		{
			parseConfig(properties);
		}
		catch (Exception e)
		{
			log.fatal(e);
			
			throw e;
		}
		
		log.info("------ Http Context Initialization End ------");
	}
	
	/**
	 * Registers the http config by an url.
	 * @param codeBase the instance of URL
	 * @throws Exception
	 */
	public static void register(URL codeBase)
		throws Exception
	{
		log.info("----- Http Context Initialization Start -----");
		
		httpConfigMap = new LinkedHashMap();
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
		
		log.info("------ Http Context Initialization End ------");
	}
	
	/**
	 * Gets the default http config.
	 * @return the instance of HttpConfig
	 */
	public static HttpConfig getDefaultConfig()
	{
		return getConfig(DEFAULT_ALIAS);
	}
	
	/**
	 * Gets the http config by an alias.
	 * @param alias the alias string
	 * @return the instance of HttpConfig
	 */
	public static HttpConfig getConfig(String alias)
	{
		HttpConfig httpConfig = (HttpConfig) httpConfigMap.get(alias);
		if (httpConfig == null)
		{
			throw new IllegalArgumentException("Http Config for " + alias + " hasn't been found");
		}
		
		return httpConfig;
	}
	
	/**
	 * Parses the properties to http config map.
	 * @param properties the instance of Properties
	 * @throws Exception
	 */
	private static void parseConfig(Properties properties)
		throws Exception
	{
		parseConfig(properties, null);
	}
	
	/**
	 * Parses the properties to http config map with an url.
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
			HttpConfig config = createConfig(configProperties, url);
			httpConfigMap.put(config.getAlias(), config);
		}
		
		HttpLogger.info(httpConfigMap);
	}
	
	/**
	 * Creates the http config by a configProperties and url.
	 * @param properties the instance of Properties
	 * @param url the instance of URL
	 * @return the instance of HttpConfig
	 */
	private static HttpConfig createConfig(Properties properties, URL url)
	{
		HttpConfig httpConfig = new HttpConfig();
		
		httpConfig.setAlias(properties.getProperty(ALIAS));
		if (!properties.getProperty(HOST).equals(""))
		{
			httpConfig.setHost(properties.getProperty(HOST));
		}
		else
		{
			if (url != null)
			{
				httpConfig.setHost(url.getHost());
			}
		}
		if (!properties.getProperty(PORT).equals(""))
		{
			httpConfig.setPort(Integer.parseInt(properties.getProperty(PORT)));
		}
		else
		{
			if (url != null)
			{
				httpConfig.setPort(url.getPort());
			}
		}
		httpConfig.setPath(properties.getProperty(PATH));
		
		httpConfig.setConnectionTimeOut(Integer.parseInt(properties.getProperty(CONNECTION_TIMEOUT)));
		httpConfig.setResponseTimeOut(Integer.parseInt(properties.getProperty(RESPONSE_TIMEOUT)));
		httpConfig.setBufferSize(Integer.parseInt(properties.getProperty(BUFFER_SIZE)));
		
		return httpConfig;
	}
}