package com.nepxion.swing.icon;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

public class IconContext
	implements IconConstants
{
	/**
	 * the context icon folder string.
	 */
	private static String iconFolder = "";
	
	/**
	 * Registers the context icon folder.
	 * @param iconFolder the context icon folder string.
	 */
	public static void registerIconFolder(String iconFolder)
	{
		IconContext.iconFolder = iconFolder;
	}
	
	/**
	 * Gets the context icon folder.
	 * @return  the context icon folder string. 
	 */
	public static String getIconFolder()
	{
		return iconFolder;
	}
}