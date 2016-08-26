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

public interface IDateSelectorComponent
{
	/**
	 * Gets the date selector.
	 * @return the instance of JDateSelector
	 */
	public JDateSelector getDateSelector();
	
	/**
	 * Sets the date selector.
	 * @param dateSelector the instance of JDateSelector
	 */
	public void setDateSelector(JDateSelector dateSelector);
}