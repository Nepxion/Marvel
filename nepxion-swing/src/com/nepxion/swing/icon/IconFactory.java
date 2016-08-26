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

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class IconFactory
	implements IconConstants
{
	/**
	 * The map of the icon cache pool.
	 */
	private static Map iconPool = new HashMap();
	
	/**
	 * Gets the icon in swing icon folder by an icon name.
	 * The icon name must not be included the folder string.
	 * For example : property.png, config.gif
	 * @param iconName the icon name string
	 * @return the instance of ImageIcon
	 */
	public static ImageIcon getSwingIcon(String iconName)
	{
		return getIcon(SWING_ICON_FOLDER + iconName);
	}
	
	/**
	 * Gets the icon by an icon name in context icon folder which is registered in IconContext. 
	 * The icon name must not be included the folder string.
	 * For example : property.png, config.gif
	 * @return the instance of ImageIcon
	 */
	public static ImageIcon getContextIcon(String iconName)
	{
		return getIcon(IconContext.getIconFolder() + iconName);
	}
	
	/**
	 * Gets the blank icon.
	 * @return the instance of ImageIcon
	 */
	public static ImageIcon getBlankIcon()
	{
		return getIcon(SWING_BLANK_ICON);
	}
	
	/**
	 * Gets the icon by an icon full path.
	 * If the icon is not existed, the blank icon will be returned.
	 * @param iconFullPath the icon full path string
	 * @return the instance of ImageIcon
	 */
	public static ImageIcon getIcon(String iconFullPath)
	{
		Object iconObject = iconPool.get(iconFullPath);
		if (iconObject != null)
		{
			return (ImageIcon) iconObject;
		}
		else
		{
			ImageIcon icon = createIcon(iconFullPath);
			if (icon == null)
			{
				Object blankIconObject = iconPool.get(SWING_BLANK_ICON);
				if (blankIconObject != null)
				{
					return (ImageIcon) blankIconObject;
				}
				else
				{
					iconFullPath = SWING_BLANK_ICON;
					icon = createIcon(iconFullPath);
				}
			}
			iconPool.put(iconFullPath, icon);
			
			return icon;
		}
	}
	
	/**
	 * Creates the icon by an icon full path.
	 * @param iconFullPath  the icon full path string
	 * @return the instance of ImageIcon 
	 */
	private static ImageIcon createIcon(String iconFullPath)
	{
		URL iconURL = IconFactory.class.getClassLoader().getResource(iconFullPath);
		if (iconURL != null)
		{
			return new ImageIcon(iconURL);
		}
		
		return null;
	}
}