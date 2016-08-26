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

import java.awt.Component;
import java.awt.Insets;

import javax.swing.UIManager;

import com.jidesoft.popup.JidePopup;

public class JDraggablePopupMenu
	extends JidePopup
{
	/**
	 * Constructs with the default.
	 */
	public JDraggablePopupMenu()
	{
		setResizable(true);
		setMovable(true);
		setBackground(UIManager.getColor("Panel.background"));
		
		PopupMenuManager.setPreferenceStyle(this);
	}
	
	/**
	 * Shows the popup menu.
	 * @param insets the instance of Insets
	 * @param owner the instance of Component
	 */
	public void showPopup(Insets insets, Component owner)
	{
		setDefaultFocusComponent(getContentPane());
		
		super.showPopup(insets, owner);
	}
	
	/**
	 * Updates the ui.
	 */
	public void updateUI()
	{
		super.updateUI();
		
		setBackground(UIManager.getColor("Panel.background"));
	}
}