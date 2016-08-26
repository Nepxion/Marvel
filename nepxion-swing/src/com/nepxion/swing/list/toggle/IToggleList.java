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

import com.nepxion.swing.list.IList;
import com.nepxion.swing.toggle.IToggleContentPanel;

public interface IToggleList
	extends IList
{
	/**
	 * The toggle mode of selected.
	 * The toggle function will be triggered by selected. 
	 */
	public static final int TOGGLE_MODE_SELECTED = 0;
	
	/**
	 * The toggle mode of clicked.
	 * The toggle function will be triggered by clicked. 
	 */
	public static final int TOGGLE_MODE_CLICKED = 1;
	
	/**
	 * The toggle mode of double-clicked.
	 * The toggle function will be triggered by double-clicked. 
	 */
	public static final int TOGGLE_MODE_DOUBLE_CLICKED = 2;
	
	/**
	 * Gets the toggle mode.
	 * @return the toggle mode value
	 */
	public int getToggleMode();
	
	/**
	 * Sets the toggle mode.
	 * @param toggleMode the toggle mode value
	 */
	public void setToggleMode(int toggleMode);
	
	/**
	 * Gets the toggle content panel.
	 * @return the instance of IToggleContentPanel
	 */
	public IToggleContentPanel getToggleContentPanel();
	
	/**
	 * Sets the toggle content panel.
	 * @param toggleContentPanel the instance of IToggleContentPanel
	 */
	public void setToggleContentPanel(IToggleContentPanel toggleContentPanel);
	
	/**
	 * Gets the toggle adapter.
	 * @return the instance of IToggleAdapter
	 */
	public IToggleAdapter getToggleAdapter();
	
	/**
	 * Sets the toggle adapter.
	 * @param toggleAdapter the instance of IToggleAdapter
	 */
	public void setToggleAdapter(IToggleAdapter toggleAdapter);
}