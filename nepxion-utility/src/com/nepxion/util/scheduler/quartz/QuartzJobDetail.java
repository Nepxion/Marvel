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

import org.quartz.JobDetail;

public class QuartzJobDetail
	extends JobDetail
{
	/**
	 * Constructs with the default.
	 */
	public QuartzJobDetail()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial name and job class.
	 * @param name the name string
	 * @param jobClass the job class
	 */
	public QuartzJobDetail(String name, Class jobClass)
	{
		super(name, jobClass);
	}
	
	/**
	 * Constructs with the specified initial name, group and job class.
	 * @param name the name string
	 * @param group the group string
	 * @param jobClass the job class
	 */
	public QuartzJobDetail(String name, String group, Class jobClass)
	{
		super(name, group, jobClass);
	}
	
	/**
	 * Constructs with the specified initial name, group, job class, volatility, durability and recover.
	 * @param name the name string
	 * @param group the group string
	 * @param jobClass the job class
	 * @param volatility the boolean value
	 * @param durability the boolean value
	 * @param recover the boolean value
	 */
	public QuartzJobDetail(String name, String group, Class jobClass, boolean volatility, boolean durability, boolean recover)
	{
		super(name, group, jobClass, volatility, durability, recover);
	}
}