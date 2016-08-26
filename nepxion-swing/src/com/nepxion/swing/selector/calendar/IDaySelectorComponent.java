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

public interface IDaySelectorComponent
{
	/**
	 * Gets the day selector.
	 * @return the instance of JDaySelector
	 */
	public JDaySelector getDaySelector();
	
	/**
	 * Sets the day selector.
	 * @param daySelector the instance of JDaySelector
	 */
	public void setDaySelector(JDaySelector daySelector);
}