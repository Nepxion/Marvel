package com.nepxion.demo.control.menu;

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

import com.nepxion.demo.common.DemoTogglePanel;
import com.nepxion.demo.common.DemoToggleTemplate;
import com.nepxion.demo.component.popupmenu.DemoPopupMenuPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoPopupMenuTogglePanel
	extends DemoTogglePanel
{
	public DemoPopupMenuTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("PopupMenu", IconFactory.getSwingIcon("component/popup_menu_16.png"), new DemoToggleTemplate(new DemoPopupMenuPanel()), "PopupMenu");				
	}
	
	public String getToggleText()
	{
		return "PopupMenu";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/popup_menu_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/popup_menu_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style PopupMenu";
	}
}