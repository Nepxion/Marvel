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

public interface IYearSelectorComponent
{
	/**
	 * Gets the year selector.
	 * @return the instance of JYearSelector
	 */
	public JYearSelector getYearSelector();
	
	/**
	 * Sets the year selector.
	 * @param yearSelector the instance of JYearSelector
	 */
	public void setYearSelector(JYearSelector yearSelector);
}