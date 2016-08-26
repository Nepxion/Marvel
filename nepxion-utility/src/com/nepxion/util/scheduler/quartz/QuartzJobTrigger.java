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

import org.quartz.SimpleTrigger;

import com.nepxion.util.time.TimeUtil;

public class QuartzJobTrigger
	extends SimpleTrigger
{
	/**
	 * Constructs with the default.
	 */
	public QuartzJobTrigger()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial name.
	 * @param name the name string
	 */
	public QuartzJobTrigger(String name)
	{
		super(name);
	}
	
	/**
	 * Constructs with the specified initial name and group.
	 * @param name the name string
	 * @param group the group string 
	 */
	public QuartzJobTrigger(String name, String group)
	{
		super(name, group);
	}
	
	/**
	 * Constructs with the specified initial name and repeat interval.
	 * @param name the name string
	 * @param repeatInterval the scheduler timer repeat interval. The scheduler timer will be activated every the repeat interval
	 */
	public QuartzJobTrigger(String name, long repeatInterval)
	{
		super(name, REPEAT_INDEFINITELY, repeatInterval);
	}
	
	/**
	 * Constructs with the specified initial name, repeat count and repeat interval.
	 * @param name the name string
	 * @param repeatCount the scheduler timer repeat count. The scheduler timer will stop if the it arrives the repeat count, but it arrives the end time first, it will also stop
	 * @param repeatInterval the scheduler timer repeat interval. The scheduler timer will be activated every the repeat interval
	 */
	public QuartzJobTrigger(String name, int repeatCount, long repeatInterval)
	{
		super(name, repeatCount, repeatInterval);
	}
	
	/**
	 * Constructs with the specified initial name and repeat interval.
	 * @param name the name string
	 * @param repeatInterval the scheduler timer repeat interval and it must be [day, hour, minute, second, milliSecond]. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, int[] repeatInterval)
	{
		super(name, REPEAT_INDEFINITELY, TimeUtil.getMillisecond(repeatInterval));
	}
	
	/**
	 * Constructs with the specified initial name, repeat count and repeat interval.
	 * @param name the name string
	 * @param repeatCount the scheduler timer repeat count. The scheduler timer will stop if the it arrives the repeat count, but it arrives the end time first, it will also stop
	 * @param repeatInterval the scheduler timer repeat interval and it must be [day, hour, minute, second, milliSecond]. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, int repeatCount, int[] repeatInterval)
	{
		super(name, repeatCount, TimeUtil.getMillisecond(repeatInterval));
	}
	
	/**
	 * Constructs with the specified initial name, group and repeat interval.
	 * @param name the name string
	 * @param group the group string
	 * @param repeatInterval the scheduler timer repeat interval. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, String group, long repeatInterval)
	{
		super(name, group, REPEAT_INDEFINITELY, repeatInterval);
	}
	
	/**
	 * Constructs with the specified initial name, group, repeat count and repeat interval.
	 * @param name the name string
	 * @param group the group string
	 * @param repeatCount the scheduler timer repeat count. The scheduler timer will stop if the it arrives the repeat count, but it arrives the end time first, it will also stop
	 * @param repeatInterval the scheduler timer repeat interval. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, String group, int repeatCount, long repeatInterval)
	{
		super(name, group, repeatCount, repeatInterval);
	}
	
	/**
	 * Constructs with the specified initial name, group and repeat interval.
	 * @param name the name string
	 * @param group the group string
	 * @param repeatInterval the scheduler timer repeat interval and it must be [day, hour, minute, second, milliSecond]. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, String group, int[] repeatInterval)
	{
		super(name, group, REPEAT_INDEFINITELY, TimeUtil.getMillisecond(repeatInterval));
	}
	
	/**
	 * Constructs with the specified initial name, group, repeat count and repeat interval.
	 * @param name the name string
	 * @param group the group string
	 * @param repeatCount the scheduler timer repeat count. The scheduler timer will stop if the it arrives the repeat count, but it arrives the end time first, it will also stop
	 * @param repeatInterval the scheduler timer repeat interval and it must be [day, hour, minute, second, milliSecond]. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, String group, int repeatCount, int[] repeatInterval)
	{
		super(name, group, repeatCount, TimeUtil.getMillisecond(repeatInterval));
	}
	
	/**
	 * Constructs with the specified initial name and start time.
	 * @param name the name string
	 * @param startTime the scheduler timer start time. If null, the scheduler timer will start at the currently time
	 */
	public QuartzJobTrigger(String name, Date startTime)
	{
		super(name, startTime);
	}
	
	/**
	 * Constructs with the specified initial name, group and start time.
	 * @param name the name string
	 * @param group the group string
	 */
	public QuartzJobTrigger(String name, String group, Date startTime)
	{
		super(name, group, startTime);
	}
	
	/**
	 * Constructs with the specified initial name, start time, end time and repeat interval.
	 * @param name the name string
	 * @param startTime the scheduler timer start time. If null, the scheduler timer will start at the currently time
	 * @param endTime the scheduler timer end time. If null, the scheduler timer will always run unless it is interrupted
	 * @param repeatInterval the scheduler timer repeat interval. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, Date startTime, Date endTime, long repeatInterval)
	{
		super(name, startTime, endTime, REPEAT_INDEFINITELY, repeatInterval);
	}
	
	/**
	 * Constructs with the specified initial name, start time, end time, repeat count and repeat interval.
	 * @param name the name string
	 * @param startTime the scheduler timer start time. If null, the scheduler timer will start at the currently time
	 * @param endTime the scheduler timer end time. If null, the scheduler timer will always run unless it is interrupted
	 * @param repeatCount the scheduler timer repeat count. The scheduler timer will stop if the it arrives the repeat count, but it arrives the end time first, it will also stop
	 * @param repeatInterval the scheduler timer repeat interval. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, Date startTime, Date endTime, int repeatCount, long repeatInterval)
	{
		super(name, startTime, endTime, repeatCount, repeatInterval);
	}
	
	/**
	 * Constructs with the specified initial name, start time, end time and repeat interval.
	 * @param name the name string
	 * @param startTime the scheduler timer start time. If null, the scheduler timer will start at the currently time
	 * @param endTime the scheduler timer end time. If null, the scheduler timer will always run unless it is interrupted
	 * @param repeatInterval the scheduler timer repeat interval and it must be [day, hour, minute, second, milliSecond]. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, Date startTime, Date endTime, int[] repeatInterval)
	{
		super(name, startTime, endTime, REPEAT_INDEFINITELY, TimeUtil.getMillisecond(repeatInterval));
	}
	
	/**
	 * Constructs with the specified initial name, start time, end time, repeat count and repeat interval.
	 * @param name the name string
	 * @param startTime the scheduler timer start time. If null, the scheduler timer will start at the currently time
	 * @param endTime the scheduler timer end time. If null, the scheduler timer will always run unless it is interrupted
	 * @param repeatCount the scheduler timer repeat count. The scheduler timer will stop if the it arrives the repeat count, but it arrives the end time first, it will also stop
	 * @param repeatInterval the scheduler timer repeat interval and it must be [day, hour, minute, second, milliSecond]. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, Date startTime, Date endTime, int repeatCount, int[] repeatInterval)
	{
		super(name, startTime, endTime, repeatCount, TimeUtil.getMillisecond(repeatInterval));
	}
	
	/**
	 * Constructs with the specified initial name, group, start time, end time and repeat interval.
	 * @param name the name string
	 * @param group the group string
	 * @param startTime the scheduler timer start time. If null, the scheduler timer will start at the currently time
	 * @param endTime the scheduler timer end time. If null, the scheduler timer will always run unless it is interrupted
	 * @param repeatInterval the scheduler timer repeat interval. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, String group, Date startTime, Date endTime, long repeatInterval)
	{
		super(name, group, startTime, endTime, REPEAT_INDEFINITELY, repeatInterval);
	}
	
	/**
	 * Constructs with the specified initial name, group, start time, end time, repeat count and repeat interval.
	 * @param name the name string
	 * @param group the group string
	 * @param startTime the scheduler timer start time. If null, the scheduler timer will start at the currently time
	 * @param endTime the scheduler timer end time. If null, the scheduler timer will always run unless it is interrupted
	 * @param repeatCount the scheduler timer repeat count. The scheduler timer will stop if the it arrives the repeat count, but it arrives the end time first, it will also stop
	 * @param repeatInterval the scheduler timer repeat interval. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, String group, Date startTime, Date endTime, int repeatCount, long repeatInterval)
	{
		super(name, group, startTime, endTime, repeatCount, repeatInterval);
	}
	
	/**
	 * Constructs with the specified initial name, group, start time, end time, repeat interval.
	 * @param name the name string
	 * @param group the group string
	 * @param startTime the scheduler timer start time. If null, the scheduler timer will start at the currently time
	 * @param endTime the scheduler timer end time. If null, the scheduler timer will always run unless it is interrupted
	 * @param repeatInterval the scheduler timer repeat interval and it must be [day, hour, minute, second, milliSecond]. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, String group, Date startTime, Date endTime, int[] repeatInterval)
	{
		super(name, group, startTime, endTime, REPEAT_INDEFINITELY, TimeUtil.getMillisecond(repeatInterval));
	}
	
	/**
	 * Constructs with the specified initial name, group, start time, end time, repeat count and repeat interval.
	 * @param name the name string
	 * @param group the group string
	 * @param startTime the scheduler timer start time. If null, the scheduler timer will start at the currently time
	 * @param endTime the scheduler timer end time. If null, the scheduler timer will always run unless it is interrupted
	 * @param repeatCount the scheduler timer repeat count. The scheduler timer will stop if the it arrives the repeat count, but it arrives the end time first, it will also stop
	 * @param repeatInterval the scheduler timer repeat interval and it must be [day, hour, minute, second, milliSecond]. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, String group, Date startTime, Date endTime, int repeatCount, int[] repeatInterval)
	{
		super(name, group, startTime, endTime, repeatCount, TimeUtil.getMillisecond(repeatInterval));
	}
	
	/**
	 * Constructs with the specified initial name, group, job name, job group, start time, end time and repeat interval.
	 * @param name the name string
	 * @param group the group string
	 * @param jobName the job name string
	 * @param jobGroup the job group name
	 * @param startTime the scheduler timer start time. If null, the scheduler timer will start at the currently time
	 * @param endTime the scheduler timer end time. If null, the scheduler timer will always run unless it is interrupted
	 * @param repeatInterval the scheduler timer repeat interval. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, String group, String jobName, String jobGroup, Date startTime, Date endTime, long repeatInterval)
	{
		super(name, group, jobName, jobGroup, startTime, endTime, REPEAT_INDEFINITELY, repeatInterval);
	}
	
	/**
	 * Constructs with the specified initial name, group, job name, job group, start time, end time, repeat count and repeat interval.
	 * @param name the name string
	 * @param group the group string
	 * @param jobName the job name string
	 * @param jobGroup the job group string
	 * @param startTime the scheduler timer start time. If null, the scheduler timer will start at the currently time
	 * @param endTime the scheduler timer end time. If null, the scheduler timer will always run unless it is interrupted
	 * @param repeatCount the scheduler timer repeat count. The scheduler timer will stop if the it arrives the repeat count, but it arrives the end time first, it will also stop
	 * @param repeatInterval the scheduler timer repeat interval. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, String group, String jobName, String jobGroup, Date startTime, Date endTime, int repeatCount, long repeatInterval)
	{
		super(name, group, jobName, jobGroup, startTime, endTime, repeatCount, repeatInterval);
	}
	
	/**
	 * Constructs with the specified initial name, group, job name, job group, start time, end time and repeat interval.
	 * @param name the name string
	 * @param group the group string
	 * @param jobName the job name string
	 * @param jobGroup the job group string
	 * @param startTime the scheduler timer start time. If null, the scheduler timer will start at the currently time
	 * @param endTime the scheduler timer end time. If null, the scheduler timer will always run unless it is interrupted
	 * @param repeatInterval the scheduler timer repeat interval and it must be [day, hour, minute, second, milliSecond]. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, String group, String jobName, String jobGroup, Date startTime, Date endTime, int[] repeatInterval)
	{
		super(name, group, jobName, jobGroup, startTime, endTime, REPEAT_INDEFINITELY, TimeUtil.getMillisecond(repeatInterval));
	}
	
	/**
	 * Constructs with the specified initial name, group, job name, job group, start time, end time, repeat count and repeat interval.
	 * @param name the name string
	 * @param group the group string
	 * @param jobName the job name string
	 * @param jobGroup the job group string
	 * @param startTime the scheduler timer start time. If null, the scheduler timer will start at the currently time
	 * @param endTime the scheduler timer end time. If null, the scheduler timer will always run unless it is interrupted
	 * @param repeatCount the scheduler timer repeat count. The scheduler timer will stop if the it arrives the repeat count, but it arrives the end time first, it will also stop
	 * @param repeatInterval the scheduler timer repeat interval and it must be [day, hour, minute, second, milliSecond]. The scheduler timer will be activated every the repeat interval 
	 */
	public QuartzJobTrigger(String name, String group, String jobName, String jobGroup, Date startTime, Date endTime, int repeatCount, int[] repeatInterval)
	{
		super(name, group, jobName, jobGroup, startTime, endTime, repeatCount, TimeUtil.getMillisecond(repeatInterval));
	}
	
	/**
	 * Sets the repeat interval for the the scheduler timer.
	 * @param repeatInterval the scheduler timer repeat interval and it must be [day, hour, minute, second, milliSecond]
	 */
	public void setRepeatInterval(int[] repeatInterval)
	{
		setRepeatInterval(TimeUtil.getMillisecond(repeatInterval));
	}
}