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

import javax.swing.Icon;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;

public interface FullScreenConstants
{
	/**
	 * The maximize text string.
	 */
	public static final String TEXT_MAXIMIZE = SwingLocale.getString("maximize");
	
	/**
	 * The minimize text string.
	 */
	public static final String TEXT_MINIMIZE = SwingLocale.getString("minimize");
	
	/**
	 * The restore text string.
	 */
	public static final String TEXT_RESTORE = SwingLocale.getString("restore");
	
	/**
	 * The close text string.
	 */
	public static final String TEXT_CLOSE = SwingLocale.getString("close");
	
	/**
	 * The maximize icon.
	 */
	public static final Icon ICON_MAXIMIZE = IconFactory.getSwingIcon("maximize.png");
	
	/**
	 * The maximize to restore icon.
	 */
	public static final Icon ICON_MAXIMIZE_RESTORE = IconFactory.getSwingIcon("maximize_restore.png");
	
	/**
	 * The minimize icon.
	 */
	public static final Icon ICON_MINIMIZE = IconFactory.getSwingIcon("minimize.png");
	
	/**
	 * The minimize to restore icon.
	 */
	public static final Icon ICON_MINIMIZE_RESTORE = IconFactory.getSwingIcon("minimize_restore.png");
	
	/**
	 * The close icon.
	 */
	public static final Icon ICON_CLOSE = IconFactory.getSwingIcon("close.png");
	
	/**
	 * The window title string.
	 */
	public static final String WINDOW_TITLE = "Application";
	
	/**
	 * The window icon.
	 */
	public static final String WINDOW_ICON = "view.png";
}