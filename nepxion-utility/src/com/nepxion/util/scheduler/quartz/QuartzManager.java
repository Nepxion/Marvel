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

import java.util.Date;

import org.quartz.Scheduler;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;

public class QuartzManager
	implements QuartzConstants
{
	/**
	 * Starts the scheduler timer.
	 * @throws SchedulerException
	 */
	public static void start()
		throws SchedulerException
	{
		if (!QuartzContext.getScheduler().isStarted())
		{
			QuartzContext.getScheduler().start();
		}
	}
	
	/**
	 * Schedules the job by a job class and repeat interval.
	 * @param jobClass the job class
	 * @param repeatInterval the repeat interval
	 * @throws SchedulerException
	 */
	public static void scheduleJob(Class jobClass, int[] repeatInterval)
		throws SchedulerException
	{
		scheduleJob(jobClass.getName(), jobClass.getName(), jobClass.getName(), jobClass.getName(), jobClass, null, null, repeatInterval);
	}
	
	/**
	 * Schedules the job by a job name, job group, job trigger name, job trigger group, job class and repeat interval.
	 * @param jobName the job name
	 * @param jobGroup the job group
	 * @param jobTriggerName the job trigger name 
	 * @param jobTriggerGroup the job trigger group
	 * @param jobClass the job class
	 * @param repeatInterval the repeat interval
	 * @throws SchedulerException
	 */
	public static void scheduleJob(String jobName, String jobGroup, String jobTriggerName, String jobTriggerGroup, Class jobClass, int[] repeatInterval)
		throws SchedulerException
	{
		scheduleJob(jobName, jobGroup, jobTriggerName, jobTriggerGroup, jobClass, null, null, repeatInterval);
	}
	
	/**
	 * Schedules the job by a job name, job group, job trigger name, job trigger group, job class, start time, end time and repeat interval.
	 * @param jobName the job name
	 * @param jobGroup the job group
	 * @param jobTriggerName the job trigger name 
	 * @param jobTriggerGroup the job trigger group
	 * @param jobClass the job class
	 * @param startTime the start time
	 * @param endTime the end time
	 * @param repeatInterval the repeat interval
	 * @throws SchedulerException
	 */
	public static void scheduleJob(String jobName, String jobGroup, String jobTriggerName, String jobTriggerGroup, Class jobClass, Date startTime, Date endTime, int[] repeatInterval)
		throws SchedulerException
	{
		scheduleJob(jobName, jobGroup, jobTriggerName, jobTriggerGroup, jobClass, startTime, endTime, QuartzJobTrigger.REPEAT_INDEFINITELY, repeatInterval);
	}
	
	/**
	 * Schedules the job by a job name, job group, job trigger name, job trigger group, job class, start time, end time, repeat count and repeat interval.
	 * @param jobName the job name
	 * @param jobGroup the job group
	 * @param jobTriggerName the job trigger name 
	 * @param jobTriggerGroup the job trigger group
	 * @param jobClass the job class
	 * @param startTime the start time
	 * @param endTime the end time
	 * @param repeatCount the repeat count
	 * @param repeatInterval the repeat interval
	 * @throws SchedulerException
	 */
	public static void scheduleJob(String jobName, String jobGroup, String jobTriggerName, String jobTriggerGroup, Class jobClass, Date startTime, Date endTime, int repeatCount, int[] repeatInterval)
		throws SchedulerException
	{
		scheduleJob(jobName, jobGroup, jobTriggerName, jobTriggerGroup, jobClass, false, false, false, startTime, endTime, repeatCount, repeatInterval);
	}
	
	/**
	 * Schedules the job by a job name, job group, job trigger name, job trigger group, job class, volatility, durability, recover, start time, end time, repeat count and repeat interval.
	 * @param jobName the job name
	 * @param jobGroup the job group
	 * @param jobTriggerName the job trigger name 
	 * @param jobTriggerGroup the job trigger group
	 * @param jobClass the job class
	 * @param volatility the boolean value
	 * @param durability the boolean value
	 * @param recover the boolean value
	 * @param startTime the start time
	 * @param endTime the end time
	 * @param repeatCount the repeat count
	 * @param repeatInterval the repeat interval
	 * @throws SchedulerException
	 */
	public static void scheduleJob(String jobName, String jobGroup, String jobTriggerName, String jobTriggerGroup, Class jobClass, boolean volatility, boolean durability, boolean recover, Date startTime, Date endTime, int repeatCount, int[] repeatInterval)
		throws SchedulerException
	{
		QuartzJobDetail jobDetail = new QuartzJobDetail(jobName, jobGroup, jobClass, volatility, durability, recover);
		QuartzJobTrigger jobTrigger = new QuartzJobTrigger(jobTriggerName, jobTriggerGroup, jobName, jobGroup, startTime != null ? startTime : new Date(), endTime, repeatCount, repeatInterval);
		
		scheduleJob(jobDetail, jobTrigger);
	}
	
	/**
	 * Schedules the job by a job detail and job trigger.
	 * @param jobDetail the instance of QuartzJobDetail
	 * @param jobTrigger the instance of QuartzJobTrigger
	 * @throws SchedulerException
	 */
	public static void scheduleJob(QuartzJobDetail jobDetail, QuartzJobTrigger jobTrigger)
		throws SchedulerException
	{
		String jobName = jobDetail.getName();
		String jobGroup = jobDetail.getGroup();
		
		if (QuartzContext.getScheduler().getJobDetail(jobName, jobGroup) == null)
		{
			QuartzContext.getScheduler().scheduleJob(jobDetail, jobTrigger);
		}
	}
	
	/**
	 * Unschedules the job by a job class.
	 * @param jobClass the job class
	 * @throws SchedulerException
	 */
	public static void unscheduleJob(Class jobClass)
		throws SchedulerException
	{
		unscheduleJob(jobClass.getName(), jobClass.getName());
	}
	
	/**
	 * Unschedules the job by a job name and job group.
	 * @param jobName the job name
	 * @param jobGroup the job group
	 * @throws SchedulerException
	 */
	public static void unscheduleJob(String jobName, String jobGroup)
		throws SchedulerException
	{
		if (QuartzContext.getScheduler().getJobDetail(jobName, jobGroup) != null)
		{
			QuartzContext.getScheduler().unscheduleJob(jobName, jobGroup);
		}
	}
	
	/**
	 * Returns if the job is scheduled.
	 * @param jobClass the job class
	 * @return if the job is scheduled
	 * @throws SchedulerException
	 */
	public static boolean isScheduled(Class jobClass)
		throws SchedulerException
	{
		return isScheduled(jobClass.getName(), jobClass.getName());
	}
	
	/**
	 * Returns if the job is scheduled.
	 * @param jobName the job name
	 * @param jobGroup the job group
	 * @return if the job is scheduled
	 * @throws SchedulerException
	 */
	public static boolean isScheduled(String jobName, String jobGroup)
		throws SchedulerException
	{
		return QuartzContext.getScheduler().getJobDetail(jobName, jobGroup) != null;
	}
	
	/**
	 * Gets the scheduler object.
	 * @return the instance of Scheduler
	 */
	public static Scheduler getScheduler()
	{
		return QuartzContext.getScheduler();
	}
	
	/**
	 * Sets the context object.
	 * @param contextObject the context object
	 * @throws SchedulerException
	 */
	public static void setContextObject(Object contextObject)
		throws SchedulerException
	{
		SchedulerContext schedulerContext = getScheduler().getContext();

		if (schedulerContext.get(CONTEXT_OBJECT) == null)
		{
			schedulerContext.put(CONTEXT_OBJECT, contextObject);
		}
	}
	
	/**
	 * Gets the context object.
	 * @return the context object
	 * @throws SchedulerException
	 */
	public static Object getContextObject()
		throws SchedulerException
	{
		SchedulerContext schedulerContext = getScheduler().getContext();

		return schedulerContext.get(CONTEXT_OBJECT);
	}
}