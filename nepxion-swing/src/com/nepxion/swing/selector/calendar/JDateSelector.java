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

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import com.nepxion.swing.font.FontContext;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.popupmenu.PopupMenuManager;
import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class JDateSelector
	extends JDateChooser
{
	/**
	 * Constructs with the default.
	 */
	public JDateSelector()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial date editor.
	 * @param dateEditor the instance of IDateEditor
	 */
	public JDateSelector(IDateEditor dateEditor)
	{
		super(dateEditor);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial date.
	 * @param date the instance of Date
	 */
	public JDateSelector(Date date)
	{
		super(date);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial date and date format string.
	 * @param date the instance of Date
	 * @param dateFormatString the date format string
	 */
	public JDateSelector(Date date, String dateFormatString)
	{
		super(date, dateFormatString);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial date, date format string and date editor.
	 * @param date the instance of Date
	 * @param dateFormatString the date format string
	 * @param dateEditor the instance of IDateEditor
	 */
	public JDateSelector(Date date, String dateFormatString, IDateEditor dateEditor)
	{
		super(date, dateFormatString, dateEditor);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial date pattern, mask pattern and place holder.
	 * @param datePattern the date pattern string
	 * @param maskPattern the mask pattern string
	 * @param placeHolder the place holder char
	 */
	public JDateSelector(String datePattern, String maskPattern, char placeHolder)
	{
		super(datePattern, maskPattern, placeHolder);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial calendar, date, date format string and date editor.
	 * @param calendar the instance of JCalendar
	 * @param date the instance of Date
	 * @param dateFormatString the date format string
	 * @param dateEditor the instance of IDateEditor
	 */
	public JDateSelector(JCalendar calendar, Date date, String dateFormatString, IDateEditor dateEditor)
	{
		super(calendar, date, dateFormatString, dateEditor);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		setFont(FontContext.getFont());
		
		JButton calendarButton = getCalendarButton();
		
		Icon calendarIcon = IconFactory.getSwingIcon("date.png");
		calendarButton.setIcon(calendarIcon);
		calendarButton.setToolTipText(SwingLocale.getString("select_date_time"));
		
		CalendarManager.setPreferenceStyle(calendarButton);
		
		JSpinner spinner = (JSpinner) getJCalendar().getYearChooser().getSpinner();
		CalendarManager.setPreferenceStyle(spinner);
		
		JComboBox comboBox = (JComboBox) getJCalendar().getMonthChooser().getComboBox();
		CalendarManager.setPreferenceStyle(comboBox);
		
		PopupMenuManager.setPreferenceStyle(popup);
	}
}