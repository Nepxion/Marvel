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

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JSpinner;

import com.nepxion.swing.font.FontContext;
import com.toedter.calendar.JCalendar;

public class JCalendarSelector
	extends JCalendar
{
	/**
	 * Constructs with the default.
	 */
	public JCalendarSelector()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial date.
	 * @param date the instance of Date
	 */
	public JCalendarSelector(Date date)
	{
		super(date);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial calendar.
	 * @param calendar the instance of Calendar
	 */
	public JCalendarSelector(Calendar calendar)
	{
		super(calendar);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial locale.
	 * @param locale the instance of Locale
	 */
	public JCalendarSelector(Locale locale)
	{
		super(locale);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial date and locale.
	 * @param date the instance of Date
	 * @param locale the instance of Locale
	 */
	public JCalendarSelector(Date date, Locale locale)
	{
		super(date, locale);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial date and month spinner.
	 * @param date the instance of Date
	 * @param monthSpinner the boolean value of monthSpinner
	 */
	public JCalendarSelector(Date date, boolean monthSpinner)
	{
		super(date, monthSpinner);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial locale and month spinner.
	 * @param locale the instance of Locale
	 * @param monthSpinner the boolean value of monthSpinner
	 */
	public JCalendarSelector(Locale locale, boolean monthSpinner)
	{
		super(locale, monthSpinner);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial month spinner.
	 * @param monthSpinner the boolean value of monthSpinner
	 */
	public JCalendarSelector(boolean monthSpinner)
	{
		super(monthSpinner);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial date, locale, month spinner and week of year visible.
	 * @param date the instance of Date
	 * @param locale the instance of Locale
	 * @param monthSpinner the boolean value of monthSpinner
	 * @param weekOfYearVisible the boolean value of weekOfYearVisible
	 */
	public JCalendarSelector(Date date, Locale locale, boolean monthSpinner, boolean weekOfYearVisible)
	{
		super(date, locale, monthSpinner, weekOfYearVisible);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		setFont(FontContext.getFont());
				
		JSpinner spinner = (JSpinner) getYearChooser().getSpinner();
		CalendarManager.setPreferenceStyle(spinner);
		
		JComboBox comboBox = (JComboBox) getMonthChooser().getComboBox();
		CalendarManager.setPreferenceStyle(comboBox);
	}
}