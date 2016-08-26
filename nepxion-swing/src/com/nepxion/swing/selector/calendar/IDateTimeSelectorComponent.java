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

public interface IDateTimeSelectorComponent
{
	/**
	 * Gets the date time selector.
	 * @return the instance of JDateTimeSelector
	 */
	public JDateTimeSelector getDateTimeSelector();
	
	/**
	 * Sets the date time selector.
	 * @param dateTimeSelector the instance of JDateTimeSelector
	 */
	public void setDateTimeSelector(JDateTimeSelector dateTimeSelector);
}