package com.nepxion.demo.control.container;

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
import com.nepxion.demo.component.tabbedpane.DemoBasicTabbedPanePanel;
import com.nepxion.demo.component.tabbedpane.DemoEclipseTabbedPanePanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoTabbedPaneTogglePanel
	extends DemoTogglePanel
{
	public DemoTabbedPaneTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Basic TabbedPane", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new DemoToggleTemplate(new DemoBasicTabbedPanePanel()), "Basic TabbedPane");
		toggleTabbedPane.addTab("Eclipse TabbedPane", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new DemoToggleTemplate(new DemoEclipseTabbedPanePanel()), "Eclipse TabbedPane");		
	}
	
	public String getToggleText()
	{
		return "TabbedPane";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/tabbed_pane_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/tabbed_pane_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style TabbedPane";
	}
}