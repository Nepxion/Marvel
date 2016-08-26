package com.nepxion.util.time;

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

public class TimeComparable
	implements Comparable, TimeConstants
{
	/**
	 * The date time.
	 */
	private Date dateTime;
	
	/**
	 * The format string.
	 */
	private String formatString;
	
	/**
	 * Constructs with the specified initial date time.
	 * @param dateTime the date time
	 */
	public TimeComparable(Date dateTime)
	{
		this(dateTime, DATE_TIME_FORMAT_STRING);
	}
	
	/**
	 * Constructs with the specified initial date time and format string.
	 * @param dateTime the date time
	 */
	public TimeComparable(Date dateTime, String formatString)
	{
		this.dateTime = dateTime;
		this.formatString = formatString;
	}
	
	/**
	 * Gets the date time.
	 * @return the instance of Date
	 */
	public Date getDateTime()
	{
		return dateTime;
	}
	
	/**
	 * Sets the date time.
	 * @param dateTime the instance of Date
	 */
	public void setDateTime(Date dateTime)
	{
		this.dateTime = dateTime;
	}
	
	/**
	 * Gets the format string.
	 * @return the format string
	 */
	public String getFormatString()
	{
		return formatString;
	}
	
	/**
	 * Sets the format string.
	 * @param formatString the format string
	 */
	public void setFormatString(String formatString)
	{
		this.formatString = formatString;
	}
	
	public int compareTo(Object object)
	{
		TimeComparable timeComparable = (TimeComparable) object;
		Date dateTime = timeComparable.getDateTime();
		
		return dateTime.toString().compareTo(dateTime.toString());
	}
	
	/**
	 * To string.
	 * @return the string
	 */
	public String toString()
	{		
		return TimeUtil.getDateTimeString(dateTime, formatString);
	}
}