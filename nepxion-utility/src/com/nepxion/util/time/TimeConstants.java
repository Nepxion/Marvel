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

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public interface TimeConstants
{
	/**
	 * The date time format string.
	 */
	public static final String DATE_TIME_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * The millisecond date time format string.
	 */
	public static final String MILLISECOND_DATE_TIME_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss:SSS";
	
	/**
	 * The time zone date time format string.
	 */
	public static final String TIME_ZONE_DATE_TIME_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss zzzz";
	
	/**
	 * The date format string.
	 */
	public static final String DATE_FORMAT_STRING = "yyyy-MM-dd";
	
	/**
	 * The time format string.
	 */
	public static final String TIME_FORMAT_STRING = "HH:mm:ss";
	
	/**
	 * The millisecond time format string.
	 */
	public static final String MILLISECOND_TIME_FORMAT_STRING = "HH:mm:ss:SSS";
	
	/**
	 * The date time format.
	 */
	public static final DateFormat DATE_TIME_FORMAT = new SimpleDateFormat(DATE_TIME_FORMAT_STRING);
	
	/**
	 * The millisecond date time format.
	 */
	public static final DateFormat MILLISECOND_DATE_TIME_FORMAT = new SimpleDateFormat(MILLISECOND_DATE_TIME_FORMAT_STRING);
	
	/**
	 * The time zone date time format.
	 */
	public static final DateFormat TIME_ZONE_DATE_TIME_FORMAT = new SimpleDateFormat(TIME_ZONE_DATE_TIME_FORMAT_STRING);
	
	/**
	 * The date format.
	 */
	public static final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_STRING);
	
	/**
	 * The time format.
	 */
	public static final DateFormat TIME_FORMAT = new SimpleDateFormat(TIME_FORMAT_STRING);
	
	/**
	 * The millisecond time format.
	 */
	public static final DateFormat MILLISECOND_TIME_FORMAT = new SimpleDateFormat(MILLISECOND_TIME_FORMAT_STRING);
}