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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class TimeUtil
	implements TimeConstants
{	
	/**
	 * Gets the current year.
	 * @return the current year
	 */
	public static int getCurrentYear()
	{
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	/**
	 * Gets the current month.
	 * @return the current month
	 */
	public static int getCurrentMonth()
	{
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}
	
	/**
	 * Gets the current day.
	 * @return the current day
	 */
	public static int getCurrentDay()
	{
		return Calendar.getInstance().get(Calendar.DATE);
	}
	
	/**
	 * Gets the current hour.
	 * @return the current hour
	 */
	public static int getCurrentHour()
	{
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * Gets the current minute.
	 * @return the current minute
	 */
	public static int getCurrentMinute()
	{
		return Calendar.getInstance().get(Calendar.MINUTE);
	}
	
	/**
	 * Gets the current second.
	 * @return the current second
	 */
	public static int getCurrentSecond()
	{
		return Calendar.getInstance().get(Calendar.SECOND);
	}
	
	/**
	 * Gets the current millisecond.
	 * @return the current millisecond
	 */
	public static int getCurrentMillisecond()
	{
		return Calendar.getInstance().get(Calendar.MILLISECOND);
	}
	
	/**
	 * Gets the current date time string with the format string "yyyy-MM-dd HH:mm:ss".
	 * @return  the current date time string
	 */
	public static String getCurrentDateTime()
	{
		return getDateTime(new Date());
	}
		
	/**
	 * Gets the date time string by a date with the format string "yyyy-MM-dd HH:mm:ss".
	 * @param date the instance of Date
	 * @return the date time string
	 */
	public static String getDateTime(Date date)
	{
		return getFormatString(date, getDateTimeFormat());
	}
	
	/**
	 * Gets the date time string by a date with the format string "yyyy-MM-dd HH:mm:ss:SSS".
	 * @param date the instance of Date
	 * @return the date time string
	 */
	public static String getMillisecondDateTime(Date date)
	{
		return getFormatString(date, getMillisecondDateTimeFormat());
	}
	
	/**
	 * Gets the date time string by a date with the format string "yyyy-MM-dd HH:mm:ss zzzz".
	 * @param date  the instance of Date
	 * @return the date time string
	 */
	public static String getTimeZoneDateTime(Date date)
	{
		return getFormatString(date, getTimeZoneDateTimeFormat());
	}
	
	/**
	 * Gets the current date string with the format string "yyyy-MM-dd".
	 * @return the current date string
	 */	
	public static String getCurrentDate()
	{
		return getDate(new Date());
	}
	
	/**
	 * Gets the date string by a date with the format string "yyyy-MM-dd".
	 * @param date the instance of Date
	 * @return the date string
	 */
	public static String getDate(Date date)
	{
		return getFormatString(date, getDateFormat());
	}
	
	/** 
	 * Gets the current time string with the format string "HH:mm:ss".
	 * @return the current time string
	 */
	public static String getCurrentTime()
	{
		return getTime(new Date());
	}
	
	/**
	 * Gets the time string by a date with the format string "HH:mm:ss".
	 * @param date the instance of Date
	 * @return the time string
	 */
	public static String getTime(Date date)
	{
		return getFormatString(date, getTimeFormat());
	}
	
	/** 
	 * Gets the current time string with the format string "HH:mm:ss:SSS".
	 * @return the current time string
	 */
	public static String getCurrentMillisecondTime()
	{
		return getMillisecondTime(new Date());
	}
	
	/**
	 * Gets the time string by a date with the format string "HH:mm:ss:SSS".
	 * @param date the instance of Date
	 * @return the time string
	 */
	public static String getMillisecondTime(Date date)
	{		
		return getFormatString(date, getMillisecondTimeFormat());
	}	
		
	/**
	 * Gets the date string by a date and dateFormat.
	 * @param date the instance of Date 
	 * @param dateFormat the instance of DateFormat
	 * @return the date string     
	 */
	public static String getFormatString(Date date, DateFormat dateFormat)
	{
		return dateFormat.format(date);
	}
	
	/**
	 * Gets the current day of the week.
	 * @return the current day of the week
	 */
	public static int getCurrentDayOfWeek()
	{
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * Gets the day of the week. 
	 * @param year the year
	 * @param month the month
	 * @param day the day
	 * @return the day of the week
	 */
	public static int getDayOfWeek(int year, int month, int day)
	{
		Calendar calendar = new GregorianCalendar(year, month - 1, day);
		
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * Gets the current week of the month.
	 * @return the current week of the month
	 */
	public static int getCurrentWeekOfMonth()
	{
		return Calendar.getInstance().get(Calendar.WEEK_OF_MONTH);
	}
	
	/**
	 * Gets a week of the month.
	 * @param year the year
	 * @param month the month
	 * @param day the day
	 * @return the week of the month
	 */
	public static int getWeekOfMonth(int year, int month, int day)
	{
		Calendar calendar = new GregorianCalendar(year, month - 1, day);
		
		return calendar.get(Calendar.WEEK_OF_MONTH);
	}
	
	/**
	 * Gets the current week of the year.
	 * @return the current week of the year
	 */
	public static int getCurrentWeekOfYear()
	{
		return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
	}
	
	/**
	 * Gets the week of the year.
	 * @param year the year
	 * @param month the month
	 * @param day the day
	 * @return the week of the year
	 */
	public static int getWeekOfYear(int year, int month, int day)
	{
		Calendar calendar = new GregorianCalendar(year, month - 1, day);
		
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}
	
	/**
	 * Parses the date string to date object with the format string "yyyy-MM-dd HH:mm:ss".
	 * @param date the date string
	 * @return the instance of Date
	 */
	public static Date parseDateTime(String date)
	{
		return parseFormatDate(date, getDateTimeFormat());
	}
	
	/**
	 * Parses the date string to date object with the format string "yyyy-MM-dd HH:mm:ss zzzz".
	 * @param date the date string
	 * @return the instance of Date
	 */
	public static Date parseTimeZoneDateTime(String date)
	{
		return parseFormatDate(date, getTimeZoneDateTimeFormat());
	}

	/**
	 * Parses the date string to date object with the format string "yyyy-MM-dd".
	 * @param date the date string
	 * @return the instance of Date
	 */	
	public static Date parseDate(String date)
	{
		return parseFormatDate(date, getDateFormat());
	}
	
	/**
	 * Parses the time string to date object with the format string "HH:mm:ss".
	 * @param time the time string
	 * @return the instance of Date
	 */		
	public static Date parseTime(String time)
	{
		return parseFormatDate(time, getTimeFormat());
	}
	
	/**
	 * Parses the data string to the date object by a dateFormat.
	 * @param dateString the date string
	 * @param dateFormat the instance of DateFormat
	 * @return the instance of Date
	 */
	public static Date parseFormatDate(String dateString, DateFormat dateFormat)
	{
		dateString = dateString.trim();
		Date date = null;
		try
		{
			date = dateFormat.parse(dateString);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		
		return date;
	}
		
	/**
	 * Gets the calendar object by a date time string.
	 * @param dateTime the date time string
	 * @return the instance of GregorianCalendar
	 */
	public static GregorianCalendar getCalendar(String dateTime)
	{
		GregorianCalendar gc = new GregorianCalendar();
		Date date = parseDateTime(dateTime);
		gc.setTime(date);
		
		return gc;
	}

	/**
	 * Gets the daylight saving time offset by a date.
	 * @param date the instance of Date
	 * @return the daylight saving time offset
	 */
	public static int getDSTOffset(Date date)
	{
		return getDSTOffset(date, TimeZone.getDefault());
	}
	
	/**
	 * Gets the daylight saving time offset by a date and timeZone.
	 * @param date the instance of Date
	 * @param timeZone the instance of TimeZone
	 * @return the daylight saving time offset
	 */
	public static int getDSTOffset(Date date, TimeZone timeZone)
	{
		if (timeZone.inDaylightTime(date))
		{
			int offset = timeZone.getOffset(date.getTime()) - timeZone.getRawOffset();
			
			return offset;
		}
		
		return 0;
	}	
	
	/**
	 * Gets the time interval String by a startMillisecond and endMillisecond with the format string "HH:mm:ss".
	 * @param startMillisecond the start millisecond
	 * @param endMillisecond the end millisecond
	 * @return the time interval String
	 */
	public static String getTimeInterval(long startMillisecond, long endMillisecond)
	{
		long second = Math.abs(startMillisecond - endMillisecond) / 1000;
		
		long hour = second / 3600;
		second = second - (hour * 3600);
		
		long minute = second / 60;
		second = second - (minute * 60);
		
		return getTimeString(hour, minute, second);
	}
	
	/**
	 * Gets the time interval String by a startMillisecond and endMillisecond with the format string "HH:mm:ss:SSS".
	 * @param startMillisecond the start millisecond
	 * @param endMillisecond the end millisecond
	 * @return the time interval String
	 */
	public static String getMillisecondTimeInterval(long startMillisecond, long endMillisecond)
	{
		long millisecond = Math.abs(startMillisecond - endMillisecond);
		
		long hour = millisecond / 3600000;
		millisecond = millisecond - (hour * 3600000);
		
		long minute = millisecond / 60000;
		millisecond = millisecond - (minute * 60000);
		
		long second = millisecond / 1000;
		millisecond = millisecond - (second * 1000);
		
		return getMillisecondTimeString(hour, minute, second, millisecond);
	}	
	
	/**
	 * Returns true if the time1 is before the time2 with the format string "yyyy-MM-dd HH:mm:ss".
	 * @param time1 the time1 string
	 * @param time2 the time2 string
	 * @return true if the time1 is before the time2
	 */
	public static boolean isTimeBefore(String time1, String time2)
	{
		return isTimeBefore(time1, time2, getDateTimeFormat());
	}
	
	/**
	 * Returns true if the time1 is before the time2 by a dateFormat.
	 * @param time1 the time1 string
	 * @param time2 the time2 string
	 * @param dateFormat the instance of DateFormat
	 * @return true if the time1 is before the time2
	 */
	public static boolean isTimeBefore(String time1, String time2, DateFormat dateFormat)
	{
		time1 = time1.trim();
		time2 = time2.trim();
		try
		{
			return dateFormat.parse(time1).before(dateFormat.parse(time2));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			
			return false;
		}
	}
	
	/**
	 * Returns true if the time is before the current time with the format string "yyyy-MM-dd HH:mm:ss".
	 * @param time  the time string
	 * @return true if the time is before the current time
	 */
	public static boolean isTimeBefore(String time)
	{
		return isTimeBefore(time, getDateTimeFormat());
	}
	
	/**
	 * Returns true if the time is before the current time by a dateFormat.
	 * @param time the time string
	 * @param dateFormat the instance of DateFormat
	 * @return true if the time is before the current time
	 */
	public static boolean isTimeBefore(String time, DateFormat dateFormat)
	{
		time = time.trim();
		try
		{
			Date currentTime = new Date();
			
			return dateFormat.parse(time).before(currentTime);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			
			return false;
		}
	}
	
	/**
	 * Returns true if the time1 is after the time2 with the format string "yyyy-MM-dd HH:mm:ss".
	 * @param time1 the time1 string
	 * @param time2 the time2 string
	 * @return true if the time1 is after the time2
	 */
	public static boolean isTimeAfter(String time1, String time2)
	{
		return isTimeAfter(time1, time2, getDateTimeFormat());
	}
	
	/**
	 * Returns true if the time1 is after the time2 by a dateFormat.
	 * @param time1 the time1 string
	 * @param time2 the time2 string
	 * @param dateFormat the instance of DateFormat
	 * @return true if the time1 is after the time2
	 */
	public static boolean isTimeAfter(String time1, String time2, DateFormat dateFormat)
	{
		time1 = time1.trim();
		time2 = time2.trim();
		try
		{
			return dateFormat.parse(time1).after(dateFormat.parse(time2));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			
			return false;
		}
	}
	
	/**
	 * Returns true if the time is after the current time with the format string "yyyy-MM-dd HH:mm:ss".
	 * @param time  the time string
	 * @return true if the time is before the current time
	 */
	public static boolean isTimeAfter(String time)
	{
		return isTimeAfter(time, getDateTimeFormat());
	}
	
	/**
	 * Returns true if the time is after the current time by a dateFormat.
	 * @param time the time string
	 * @param dateFormat the instance of DateFormat
	 * @return true if the time is after the current time
	 */
	public static boolean isTimeAfter(String time, DateFormat dateFormat)
	{
		time = time.trim();
		try
		{
			Date currentTime = new Date();
			
			return dateFormat.parse(time).after(currentTime);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			
			return false;
		}
	}	
	
	/**
	 * Gets the date millisecond of the date.
	 * @param date the instance of Date
	 * @return the millisecond of the date    
	 */
	public static long getDateMillisecond(Date date)
	{
		return date.getTime() - getTimeMillisecond(date);
	}
	
	/**
	 * Gets the time millisecond of the date.
	 * @param date the instance of Date
	 * @return the time millisecond
	 */
	public static long getTimeMillisecond(Date date)
	{
		return date.getTime() % (24 * 60 * 60 * 1000);
	}
	
	/**
	 * Gets the second by a time array.
	 * The time array must be [day, hour, minute, second].
	 * @param timeArray  the time array
	 * @return the second
	 */
	public static long getSecond(int[] timeArray)
	{
		return timeArray[0] * 24 * 60 * 60 + timeArray[1] * 60 * 60 + timeArray[2] * 60 + timeArray[3];
	}
	
	/**
	 * Gets the milliSecond by a time array.
	 * The time array must be [day, hour, minute, second, milliSecond].
	 * @param timeArray the time array
	 * @return the milliSecond
	 */
	public static long getMillisecond(int[] timeArray)
	{
		return getSecond(timeArray) * 1000 + timeArray[4];
	}
	
	/**
	 * Gets the time array by a time string and delimiter.
	 * The time string must be [day, hour, minute, second].
	 * The delimiter likes ",".
	 * @param timeString the time string
	 * @param delimiter the delimiter
	 * @return the time array
	 */
	public static int[] parseTimeArray(String timeString, String delimiter)
	{
		int[] timeArray = new int[4];
		StringTokenizer st = new StringTokenizer(timeString, delimiter);
		int i = 0;
		while (st.hasMoreTokens())
		{
			timeArray[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		
		return timeArray;
	}		
	
	/**
	 * Gets the millisecond time array.
	 * @param timeString the time string.Its format is example "day, hour, minute ,second, milliSecond"
	 * @param delimiter the time delimiter, example ", "
	 * @return the millisecond time array
	 */
	public static int[] parseMillisecondTimeArray(String timeString, String delimiter)
	{
		int[] timeArray = new int[5];
		StringTokenizer st = new StringTokenizer(timeString, delimiter);
		int i = 0;
		while (st.hasMoreTokens())
		{
			timeArray[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		
		return timeArray;
	}	
	
	/**
	 * Gets the date string with the format string "yyyy-MM-dd".
	 * @param year the year
	 * @param month the month
	 * @param day the day
	 * @return the date string
	 */
	public static String getDateString(long year, long month, long day)
	{
		String yearString = year + "";
		String monthString = null;
		String dayString = null;
		
		if (month < 10)
		{
			monthString = "0" + month;
		}
		else
		{
			monthString = "" + month;
		}
		
		if (day < 10)
		{
			dayString = "0" + day;
		}
		else
		{
			dayString = "" + day;
		}
		
		return yearString + "-" + monthString + "-" + dayString;
	}
	
	/**
	 * Gets the time string with the format string "HH:mm:ss".
	 * @param hour the hour
	 * @param minute the minute
	 * @param second the second
	 * @return the time string
	 */
	public static String getTimeString(long hour, long minute, long second)
	{
		String hourString = null;
		String minuteString = null;
		String secondString = null;
		
		if (hour < 10)
		{
			hourString = "0" + hour;
		}
		else
		{
			hourString = "" + hour;
		}
		
		if (minute < 10)
		{
			minuteString = "0" + minute;
		}
		else
		{
			minuteString = "" + minute;
		}
		
		if (second < 10)
		{
			secondString = "0" + second;
		}
		else
		{
			secondString = "" + second;
		}
		
		return hourString + ":" + minuteString + ":" + secondString;
	}
	
	/**
	 * Gets the time string with the format string "HH:mm:ss:SSS".
	 * @param hour the hour
	 * @param minute the minute
	 * @param second the second
	 * @param millisecond the millisecond
	 * @return the time string
	 */
	public static String getMillisecondTimeString(long hour, long minute, long second, long millisecond)
	{
		String hourString = null;
		String minuteString = null;
		String secondString = null;
		String millisecondString = null;
		
		if (hour < 10)
		{
			hourString = "0" + hour;
		}
		else
		{
			hourString = "" + hour;
		}
		
		if (minute < 10)
		{
			minuteString = "0" + minute;
		}
		else
		{
			minuteString = "" + minute;
		}
		
		if (second < 10)
		{
			secondString = "0" + second;
		}
		else
		{
			secondString = "" + second;
		}
		
		if (millisecond < 10)
		{
			millisecondString = "00" + millisecond;
		}
		else if (millisecond < 100)
		{
			millisecondString = "0" + millisecond;
		}	
		else 
		{
			millisecondString = "" + millisecond;
		}
		
		return hourString + ":" + minuteString + ":" + secondString + ":" + millisecondString;
	}
	
	/**
	 * Gets the date time string by a format string.
	 * @param date the instance of Date
	 * @param formatString the format string
	 * @return the date time string
	 */
	public static String getDateTimeString(Date date, String formatString)
	{
		String dateTimeString = null;
		
		if (formatString.equals(DATE_TIME_FORMAT_STRING))
		{
			dateTimeString = TimeUtil.getDateTime(date);
		}
		else if (formatString.equals(MILLISECOND_DATE_TIME_FORMAT_STRING))
		{
			dateTimeString = TimeUtil.getMillisecondDateTime(date);
		}
		else if (formatString.equals(TIME_ZONE_DATE_TIME_FORMAT_STRING))
		{
			dateTimeString = TimeUtil.getTimeZoneDateTime(date);
		}
		else if (formatString.equals(DATE_FORMAT_STRING))
		{
			dateTimeString = TimeUtil.getDate(date);
		}
		else if (formatString.equals(TIME_FORMAT_STRING))
		{
			dateTimeString = TimeUtil.getTime(date);
		}
		else if (formatString.equals(MILLISECOND_TIME_FORMAT_STRING))
		{
			dateTimeString = TimeUtil.getMillisecondTime(date);
		}
		
		if (dateTimeString == null)
		{
			dateTimeString = TimeUtil.getDateTime(date);
		}
		
		return dateTimeString;
	}
	
	/**
	 * Gets the date format object with the format string "yyyy-MM-dd HH:mm:ss".
	 * @return the instance of DateFormat
	 */		
	public synchronized static DateFormat getDateTimeFormat()
	{
		return DATE_TIME_FORMAT;
	}
	
	/**
	 * Gets the date format object with the format string "yyyy-MM-dd HH:mm:ss:SSS".
	 * @return the instance of DateFormat
	 */	
	public synchronized static DateFormat getMillisecondDateTimeFormat()
	{
		return MILLISECOND_DATE_TIME_FORMAT;
	}
	
	/**
	 * Gets the date format object with the format string "yyyy-MM-dd HH:mm:ss zzzz".
	 * @return the instance of DateFormat
	 */		
	public synchronized static DateFormat getTimeZoneDateTimeFormat()
	{
		return TIME_ZONE_DATE_TIME_FORMAT;
	}
		
	/**
	 * Gets the date format object with the format string "yyyy-MM-dd".
	 * @return the instance of DateFormat
	 */	
	public synchronized static DateFormat getDateFormat()
	{
		return DATE_FORMAT;
	}
	
	/**
	 * Gets the date format object with the format string "HH:mm:ss".
	 * @return the instance of DateFormat
	 */	
	public synchronized static DateFormat getTimeFormat()
	{
		return TIME_FORMAT;
	}	
	
	/**
	 * Gets the date format object with the format string "HH:mm:ss:SSS".
	 * @return the instance of DateFormat
	 */
	public synchronized static DateFormat getMillisecondTimeFormat()
	{
		return MILLISECOND_TIME_FORMAT;
	}
	
	/**
	 * Calculates the date time.
	 * @param dateTime the src date time
	 * @param field the calendar field
	 * @param amount the amount of the date or time to be added to the field
	 * @return the dest date
	 */
	public static Date calculateDateTime(Date dateTime, int field, int amount)
	{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);
        calendar.add(field, amount);
        
        return calendar.getTime();
	}
	
	/**
	 * Delimits to the date time list by a startDateTime, endDateTime and delimitedSecond.
	 * For example : the startDateTime is "2010-01-01 00:00:00", the endDateTime is "2010-01-01 00:02:00", the delimitedSecond is 60, so
	 * the return list is [2010-01-01 00:00:00, 2010-01-01 00:01:00, 2010-01-01 00:02:00];
	 * Another situation the startDateTime is "2010-01-01 00:00:00", the endDateTime is "2010-01-01 00:01:50", the delimitedSecond is 60,
	 * the return list is also [2010-01-01 00:00:00, 2010-01-01 00:01:00, 2010-01-01 00:02:00].
	 * @param startDateTime the start date time
	 * @param endDateTime the end date time
	 * @param delimitedSecond the delimited second
	 * @return the instance of List
	 * @throws IllegalArgumentException
	 */
	public static List delimitDateTime(Date startDateTime, Date endDateTime, int delimitedSecond)
		throws IllegalArgumentException
	{
		long interval = endDateTime.getTime() - startDateTime.getTime();
		long delimitedMillisecond = delimitedSecond * 1000;
		
		if (interval < delimitedMillisecond)
		{
			throw new IllegalArgumentException();
		}
		
		int splitCount = (int) (interval / delimitedMillisecond);
		
		List dateTimes = new ArrayList();
		dateTimes.add(startDateTime);
		
		for (int i = 0; i < splitCount; i++)
		{
			Date lastDateTime = (Date) dateTimes.get(dateTimes.size() - 1);
			Date dateTime = new Date(lastDateTime.getTime() + delimitedMillisecond);
			dateTimes.add(dateTime);
		}
		
		Date lastDateTime = (Date) dateTimes.get(dateTimes.size() - 1);
		
		if (lastDateTime.getTime() < endDateTime.getTime())
		{
			Date dateTime = new Date(lastDateTime.getTime() + delimitedMillisecond);
			dateTimes.add(dateTime);
		}
		
		return dateTimes;
	}
	
	/**
	 * Gets the rang date array.
	 * @param dateTimes the date time list
	 * @param dateTime the date time
	 * @param millisecondIgnored the boolean value whether millisecond is ignored or not
	 * @return the range date array.
	 */
	public static Date[] getRangeDateTimes(List dateTimes, Date dateTime, boolean millisecondIgnored)
	{
		for (int i = 0; i < dateTimes.size() - 1; i++)
		{
			Date dateTime1 = (Date) dateTimes.get(i);
			Date dateTime2 = (Date) dateTimes.get(i + 1);
			
			long time = dateTime.getTime();
			long time1 = dateTime1.getTime();
			long time2 = dateTime2.getTime();
			
			if (millisecondIgnored)
			{
				time1 = time1 - time1 % 1000;
				time2 = time2 - time2 % 1000;
			}
			
			if (time >= time1 && time <= time2)
			{
				return new Date[] {dateTime1, dateTime2};
			}	
		}
		
		return null;
	}
	
	public static void main(String[] args)
	{
//		System.out.println("getCurrentYear() : " + getCurrentYear());
//		System.out.println("getCurrentMonth() : " + getCurrentMonth());
//		System.out.println("getCurrentDay() : " + getCurrentDay());
//		System.out.println("getCurrentHour() : " + getCurrentHour());
//		System.out.println("getCurrentMinute() : " + getCurrentMinute());
//		System.out.println("getCurrentSecond() : " + getCurrentSecond());
//		System.out.println("getCurrentMillisecond() : " + getCurrentMillisecond());
		
//		System.out.println("getCurrentDateTime() : " + getCurrentDateTime());
//		System.out.println("getDateTime() : " + getDateTime(new Date()));
		
//		System.out.println("getCurrentDate() : " + getCurrentDate());
//		System.out.println("getDate() : " + getDate(new Date()));
		
//		System.out.println("getCurrentTime() : " + getCurrentTime());
//		System.out.println("getTime() : " + getTime(new Date()));
		
//		System.out.println("getCurrentMillisecondTime() : " + getCurrentMillisecondTime());
//		System.out.println("getMillisecondTime() : " + getMillisecondTime(new Date()));
		
//		System.out.println("getCurrentDayOfWeek() : " + getCurrentDayOfWeek());
//		System.out.println("getDayOfWeek() : " + getDayOfWeek(2010, 3, 9));
//		System.out.println("getCurrentWeekOfMonth() : " + getCurrentWeekOfMonth());
//		System.out.println("getWeekOfMonth() : " + getWeekOfMonth(2209, 4, 9));
//		System.out.println("getCurrentWeekOfYear() : " + getCurrentWeekOfYear());
//		System.out.println("getWeekOfYear() : " + getWeekOfYear(2010, 3, 9));

//		System.out.println("parseDateTime() : " + parseDateTime("2009-03-08 02:30:00"));
//		System.out.println("parseTimeZoneDateTime() : " + parseTimeZoneDateTime("2009-03-08 02:30:00 CDT"));
//		System.out.println("parseTimeZoneDateTime() : " + parseTimeZoneDateTime("2009-03-08 02:30:00 CST"));		
//		System.out.println("parseDate() : " + parseDate("2012-02-02"));
//		System.out.println("parseTime() : " + parseTime("02:02:02"));
	
//		Date date1 = parseDateTime("2000-10-29 00:59:59:111");
//		String dateString1 = getFormatString(date1, getDateFormat());
		
//		Date date2 = parseDateTime("2005-11-01 23:00:00:222");
//		String dataString2 = getFormatString(date2, getMillisecondTimeFormat());
	
//		Date date3 = parseDateTime(dateString1 + " " + dataString2);
//		System.out.println(date3);
					
//		Date date4 = parseDateTime("2000-10-29 00:59:59");
//		System.out.println("Date : " + date4);
		
//		int offset1 = getDSTOffset(date4);
//		System.out.println("Offset: " + offset1);
		
//		Date date5 = parseDateTime("2000-10-29 01:00:00");
//		System.out.println("Date : " + date5);
		
//		int offset2 = getDSTOffset(date5);
//		System.out.println("Offset: " + offset2);

//		System.out.println("getTimeInterval() : " + getTimeInterval(1000000, 2030500));
//		System.out.println("getMillisecondTimeInterval() : " + getMillisecondTimeInterval(1000000, 2030500));
		
//		System.out.println("isTimeBefore() : " + isTimeBefore("2010-01-01 01:01:00", "2010-01-01 01:01:01"));
//		System.out.println("isTimeBefore() : " + isTimeBefore("2010-01-01 01:01:02", "2010-01-01 01:01:01"));
//		System.out.println("isTimeBefore() : " + isTimeBefore("2010-01-01 01:01:01", "2010-01-01 01:01:01"));
//		System.out.println("isTimeBefore() : " + isTimeBefore("2010-01-01 01:01:01:110", "2010-01-01 01:01:01:111", getMillisecondTimeDateFormat()));
//		System.out.println("isTimeBefore() : " + isTimeBefore("2010-01-01 01:01:01:112", "2010-01-01 01:01:01:111", getMillisecondTimeDateFormat()));
//		System.out.println("isTimeBefore() : " + isTimeBefore("2010-01-01 01:01:01:111", "2010-01-01 01:01:01:111", getMillisecondTimeDateFormat()));		
//		System.out.println("isTimeBefore() : " + isTimeBefore("2010-01-01 01:01:01"));
//		System.out.println("isTimeBefore() : " + isTimeBefore("2010-01-01 01:01:01:110", getMillisecondTimeDateFormat()));
//		
//		System.out.println("isTimeAfter() : " + isTimeAfter("2010-01-01 01:01:00", "2010-01-01 01:01:01"));
//		System.out.println("isTimeAfter() : " + isTimeAfter("2010-01-01 01:01:02", "2010-01-01 01:01:01"));
//		System.out.println("isTimeAfter() : " + isTimeAfter("2010-01-01 01:01:01", "2010-01-01 01:01:01"));
//		System.out.println("isTimeAfter() : " + isTimeAfter("2010-01-01 01:01:01:110", "2010-01-01 01:01:01:111", getMillisecondTimeDateFormat()));
//		System.out.println("isTimeAfter() : " + isTimeAfter("2010-01-01 01:01:01:112", "2010-01-01 01:01:01:111", getMillisecondTimeDateFormat()));
//		System.out.println("isTimeAfter() : " + isTimeAfter("2010-01-01 01:01:01:111", "2010-01-01 01:01:01:111", getMillisecondTimeDateFormat()));		
//		System.out.println("isTimeAfter() : " + isTimeAfter("2010-01-01 01:01:01"));
//		System.out.println("isTimeAfter() : " + isTimeAfter("2010-01-01 01:01:01:110", getMillisecondTimeDateFormat()));		
		
//		System.out.println("getDateMillisecond() : " + getDateMillisecond(new Date()));
//		System.out.println("getTimeMillisecond() : " + getTimeMillisecond(new Date()));
	
//		System.out.println("getSecond() : " + getSecond(new int[] {1, 1, 1, 1}));
//		System.out.println("getMillisecond() : " + getMillisecond(new int[] {1, 1, 1, 1, 1}));
		
//		System.out.println("parseTimeArray() : " + parseTimeArray("1, 2, 3, 4", ", ")[0]);
//		System.out.println("parseMillisecondTimeArray() : " + parseMillisecondTimeArray("1| 2| 3| 4| 5", "| ")[1]);
		
//		System.out.println("getDateString() : " + getDateString(2010, 2, 3));
//		System.out.println("getTimeString() : " + getTimeString(1, 2, 3));
//		System.out.println("getMillisecondTimeString() : " + getMillisecondTimeString(1, 2, 3, 4));		
	}
}