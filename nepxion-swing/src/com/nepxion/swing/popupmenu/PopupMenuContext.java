package com.nepxion.swing.popupmenu;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

public class PopupMenuContext
	implements PopupMenuConstants
{	
	/**
	 * The title string.
	 */
	private static String title = DEFAULT_TITLE;
	
	/**
	 * Registers the title.
	 * @param title the title string
	 */
	public static void registerTitle(String title)
	{
		PopupMenuContext.title = title;
	}
	
	/**
	 * Gets the title.
	 * @return the title string
	 */
	public static String getTitle()
	{
		return title;
	}
}