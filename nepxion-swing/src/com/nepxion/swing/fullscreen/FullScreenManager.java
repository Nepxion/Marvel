package com.nepxion.swing.fullscreen;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.menuitem.JBasicMenuItem;

public class FullScreenManager
	implements FullScreenConstants
{
	/**
	 * Creates the maximize button.
	 * @param isTextVisible the boolean value of isTextVisible
	 * @return the instance of JBasicButton
	 */
	public static JBasicButton createMaximizeButton(boolean isTextVisible)
	{
		JBasicButton button = null;
		if (isTextVisible)
		{
			button = new JBasicButton(TEXT_MAXIMIZE, ICON_MAXIMIZE, TEXT_MAXIMIZE);
		}
		else
		{
			button = new JBasicButton(ICON_MAXIMIZE, TEXT_MAXIMIZE);
		}
		
		return button;
	}
	
	/**
	 * Creates the minimize button.
	 * @param isTextVisible the boolean value of isTextVisible
	 * @return the instance of JBasicButton
	 */
	public static JBasicButton createMinimizeButton(boolean isTextVisible)
	{
		JBasicButton button = null;
		if (isTextVisible)
		{
			button = new JBasicButton(TEXT_MINIMIZE, ICON_MINIMIZE, TEXT_MINIMIZE);
		}
		else
		{
			button = new JBasicButton(ICON_MINIMIZE, TEXT_MINIMIZE);
		}
		
		return button;
	}
	
	/**
	 * Creates the close button.
	 * @param isTextVisible the boolean value of isTextVisible
	 * @return the instance of JBasicButton
	 */
	public static JBasicButton createCloseButton(boolean isTextVisible)
	{
		JBasicButton button = null;
		if (isTextVisible)
		{
			button = new JBasicButton(TEXT_CLOSE, ICON_CLOSE, TEXT_CLOSE);
		}
		else
		{
			button = new JBasicButton(ICON_CLOSE, TEXT_CLOSE);
		}
		
		return button;
	}
	
	/**
	 * Creates the maximize menu item.
	 * @return the instance of JBasicMenuItem
	 */
	public static JBasicMenuItem createMaximizeMenuItem()
	{
		JBasicMenuItem menuItem = new JBasicMenuItem(TEXT_MAXIMIZE, ICON_MAXIMIZE, TEXT_MAXIMIZE);
		
		return menuItem;
	}
	
	/**
	 * Creates the minimize menu item.
	 * @return the instance of JBasicMenuItem
	 */
	public static JBasicMenuItem createMinimizeMenuItem()
	{
		JBasicMenuItem menuItem = new JBasicMenuItem(TEXT_MINIMIZE, ICON_MINIMIZE, TEXT_MINIMIZE);
		
		return menuItem;
	}
	
	/**
	 * Creates the close menu item.
	 * @return the instance of JBasicMenuItem
	 */
	public static JBasicMenuItem createCloseMenuItem()
	{
		JBasicMenuItem menuItem = new JBasicMenuItem(TEXT_CLOSE, ICON_CLOSE, TEXT_CLOSE);
		
		return menuItem;
	}
}