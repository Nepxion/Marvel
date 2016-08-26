package com.nepxion.util.database.pool.proxool;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.logicalcobwebs.proxool.ProxoolException;
import org.logicalcobwebs.proxool.configuration.PropertyConfigurator;

public class ProxoolContext
	implements ProxoolConstants
{
	private static Log log = LogFactory.getLog(ProxoolContext.class);
	
	/**
	 * Registers the proxool by the default config file path.
	 * @throws ProxoolException
	 */
	public static void register()
		throws ProxoolException
	{
		register(CONFIG_FILE_PATH);
	}
	
	/**
	 * Registers the proxool by a config file path.
	 * @param filePath the config file path
	 * @throws ProxoolException
	 */
	public static void register(String filePath)
		throws ProxoolException
	{
		log.info("---- Proxool Context Initialization Start ---");
		
		try
		{
			PropertyConfigurator.configure(filePath);
		}
		catch (ProxoolException e)
		{
			log.fatal(e);
			
			throw e;
		}
		
		log.info("----- Proxool Context Initialization End ----");
	}
	
	/**
	 * Registers the proxool by a properties object.
	 * @param properties the instance of Properties
	 * @throws ProxoolException
	 */
	public static void register(Properties properties)
		throws ProxoolException
	{
		log.info("---- Proxool Context Initialization Start ---");
		
		try
		{
			PropertyConfigurator.configure(properties);
		}
		catch (ProxoolException e)
		{
			log.fatal(e);
			
			throw e;
		}
		
		log.info("---- Proxool Context Initialization Start ---");
	}
	
	/**
	 * Registers the proxool by an url.
	 * @param codeBase the instance of URL
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ProxoolException
	 */
	public static void register(URL codeBase)
		throws MalformedURLException, IOException, ProxoolException
	{
		Properties properties = new Properties();

		try
		{
			URL url = new URL(codeBase + CONFIG_FILE_PATH);
			properties.load(url.openStream());
			
			register(properties);
		}
		catch (MalformedURLException e)
		{
			log.fatal(e);
			
			throw e;
		}
		catch (IOException e)
		{
			log.fatal(e);
			
			throw e;
		}
		catch (ProxoolException e)
		{
			log.fatal(e);
			
			throw e;
		}
	}
}