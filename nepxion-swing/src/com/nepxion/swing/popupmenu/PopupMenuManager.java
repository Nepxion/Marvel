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

import java.awt.Color;

import javax.swing.JPopupMenu;

import com.nepxion.swing.border.LineBorder;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;

public class PopupMenuManager
{
	/**
	 * Sets the preference style for the popup menu.
	 * @param popupMenu the instance of JPopupMenu
	 */	
	public static void setPreferenceStyle(JPopupMenu popupMenu)
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			popupMenu.setBorder(new LineBorder(new Color(89, 89, 89), 1));
		}	
	}
	
	/**
	 * Sets the preference style for the draggable popup menu.
	 * @param popupMenu the instance of JDraggablePopupMenu
	 */	
	public static void setPreferenceStyle(JDraggablePopupMenu popupMenu)
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			popupMenu.setBorder(new LineBorder(new Color(89, 89, 89), 1));
		}	
	}
	
	/**
	 * Gets the margin.
	 * @return the margin value
	 */
	public static int getMargin()
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			return 1;
		}
		else
		{
			return 2;
		}
	}
}