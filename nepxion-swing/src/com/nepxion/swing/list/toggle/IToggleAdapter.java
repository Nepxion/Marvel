package com.nepxion.swing.list.toggle;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

public interface IToggleAdapter
{
	/**
	 * Toggles the selection. 
	 * @param oldSelectedRow the old selected row index value
	 * @param newSelectedRow the new selected row index value
	 */
	public void toggle(int oldSelectedRow, int newSelectedRow);
}