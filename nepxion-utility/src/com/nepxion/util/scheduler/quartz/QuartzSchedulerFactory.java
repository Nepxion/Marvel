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

import java.util.Properties;

import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzSchedulerFactory
	extends StdSchedulerFactory
{
	/**
	 * Constructs with the default.
	 */
	public QuartzSchedulerFactory()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial file path.
	 * @param filePath the file path
	 * @throws SchedulerException
	 */
	public QuartzSchedulerFactory(String filePath)
		throws SchedulerException
	{
		super(filePath);
	}
	
	/**
	 * Constructs with the specified initial properties.
	 * @param properties the instance of Properties
	 * @throws SchedulerException
	 */
	public QuartzSchedulerFactory(Properties properties)
		throws SchedulerException
	{
		super(properties);
	}
}