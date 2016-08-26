package com.nepxion.swing.button;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

public interface IToggleButton
{
	/**
	 * Returns true if the button is grouped.
	 * If true, the toggle button will be added to a ButtonGroup automatically.
	 * @return true if the button is grouped
	 */
	public boolean isGrouped();
	
	/**
	 * Sets the button grouped.
	 * @param isGrouped the boolean value of isGrouped
	 */
	public void setGrouped(boolean isGrouped);
}