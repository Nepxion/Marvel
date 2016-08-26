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

public interface ICalendarSelectorComponent
{
	/**
	 * Gets the calendar selector.
	 * @return the instance of JCalendarSelector
	 */
	public JCalendarSelector getCalendarSelector();
	
	/**
	 * Sets the calendar selector.
	 * @param calendarSelector the instance of JCalendarSelector
	 */
	public void setCalendarSelector(JCalendarSelector calendarSelector);
}