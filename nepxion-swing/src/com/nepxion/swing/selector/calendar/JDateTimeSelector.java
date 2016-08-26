package com.nepxion.swing.selector.calendar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.Date;

import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JCalendar;

public class JDateTimeSelector
	extends JDateSelector
{
	/**
	 * Constructs with the default.
	 */
	public JDateTimeSelector()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial date editor.
	 * @param dateEditor the instance of IDateEditor
	 */
	public JDateTimeSelector(IDateEditor dateEditor)
	{
		super(dateEditor);
	}
	
	/**
	 * Constructs with the specified initial date.
	 * @param date the instance of Date
	 */
	public JDateTimeSelector(Date date)
	{
		super(date);
	}
	
	/**
	 * Constructs with the specified initial date and date format string
	 * @param date the instance of Date
	 * @param dateFormatString the date format string
	 */
	public JDateTimeSelector(Date date, String dateFormatString)
	{
		super(date, dateFormatString);
	}
	
	/**
	 * Constructs with the specified initial date, date format string and date editor.
	 * @param date the instance of Date
	 * @param dateFormatString the date format string
	 * @param dateEditor the instance of IDateEditor
	 */
	public JDateTimeSelector(Date date, String dateFormatString, IDateEditor dateEditor)
	{
		super(date, dateFormatString, dateEditor);
	}
	
	/**
	 * Constructs with the specified initial date pattern, mask pattern and place holder.
	 * @param datePattern the date pattern string
	 * @param maskPattern the mask pattern string
	 * @param placeHolder the place holder char
	 */
	public JDateTimeSelector(String datePattern, String maskPattern, char placeHolder)
	{
		super(datePattern, maskPattern, placeHolder);
	}
	
	/**
	 * Constructs with the specified initial calendar, date, date format string and date editor.
	 * @param calendar the instance of JCalendar
	 * @param date the instance of Date
	 * @param dateFormatString the date format string
	 * @param dateEditor the instance of IDateEditor
	 */
	public JDateTimeSelector(JCalendar calendar, Date date, String dateFormatString, IDateEditor dateEditor)
	{
		super(calendar, date, dateFormatString, dateEditor);
	}
}