package com.nepxion.util.scheduler.quartz;

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

public class QuartzContext
	implements QuartzConstants
{
	private static Log log = LogFactory.getLog(QuartzContext.class);
	
	/**
	 * The instance of QuartzSchedulerFactory.
	 */
	private static QuartzSchedulerFactory factory;
	
	/**
	 * The instance of Scheduler.
	 */
	private static Scheduler scheduler;
	
	/**
	 * Registers the quartz scheduler by the default config file path.
	 * @throws SchedulerException
	 */
	public static void register()
		throws SchedulerException
	{
		register(CONFIG_FILE_PATH);
	}
	
	/**
	 * Registers the quartz scheduler by a config file path.
	 * @param filePath the config file path
	 * @throws SchedulerException
	 */
	public static void register(String filePath)
		throws SchedulerException
	{
		log.info("--- Quartz Scheduler Initialization Start ---");
		
		try
		{
			factory = new QuartzSchedulerFactory(filePath);
			scheduler = factory.getScheduler();
		}
		catch (SchedulerException e)
		{
			log.fatal(e);
			
			throw e;
		}
		
		System.setProperty("org.terracotta.quartz.skipUpdateCheck", "true");
		
		log.info("---- Quartz Scheduler Initialization End ----");
	}
	
	/**
	 * Registers the quartz scheduler by a properties object.
	 * @param properties the instance of Properties
	 * @throws SchedulerException
	 */
	public static void register(Properties properties)
		throws SchedulerException
	{
		log.info("--- Quartz Scheduler Initialization Start ---");
		
		try
		{
			factory = new QuartzSchedulerFactory(properties);
			scheduler = factory.getScheduler();
		}
		catch (SchedulerException e)
		{
			log.fatal(e);
			
			throw e;
		}
		
		System.setProperty("org.terracotta.quartz.skipUpdateCheck", "true");
		
		log.info("---- Quartz Scheduler Initialization End ----");
	}
	
	/**
	 * Registers the quartz scheduler by an url.
	 * @param codeBase the instance of URL
	 * @throws Exception
	 */
	public static void register(URL codeBase)
		throws Exception
	{
		Properties properties = new Properties();
		
		try
		{
			URL url = new URL(codeBase + CONFIG_FILE_PATH);
			properties.load(url.openStream());
			
			register(properties);
		}
		catch (Exception e)
		{
			log.fatal(e);
			
			throw e;
		}
	}
	
	/**
	 * Gets the quartz scheduler factory object.
	 * @return the instance of QuartzSchedulerFactory
	 */
	public static QuartzSchedulerFactory getFactory()
	{
		return factory;
	}
	
	/**
	 * Gets the quartz scheduler object.
	 * @return the instance of Scheduler
	 */
	public static Scheduler getScheduler()
	{
		return scheduler;
	}
}