package com.nepxion.swing.selector.locale;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

public interface ILocaleSelectorComponent
{
	/**
	 * Gets the locale selector.
	 * @return the instance of JLocaleSelector
	 */
	public JLocaleSelector getLocaleSelector();
	
	/**
	 * Sets the locale selector.
	 * @param localeSelector the instance of JLocaleSelector
	 */
	public void setLocaleSelector(JLocaleSelector localeSelector);
}