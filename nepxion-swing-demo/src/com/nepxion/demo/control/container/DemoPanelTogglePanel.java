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
import com.nepxion.demo.component.panel.DemoBannerPanel;
import com.nepxion.demo.component.panel.DemoOptionPanel;
import com.nepxion.demo.component.panel.DemoDecorationPanel;
import com.nepxion.demo.component.panel.DemoIPPropertyPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoPanelTogglePanel
	extends DemoTogglePanel
{
	public DemoPanelTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Decoration Panel", IconFactory.getSwingIcon("component/panel_16.png"), new DemoToggleTemplate(new DemoDecorationPanel()), "Decoration Panel");
		toggleTabbedPane.addTab("Option Panel", IconFactory.getSwingIcon("component/panel_16.png"), new DemoToggleTemplate(new DemoOptionPanel()), "Option Panel");		
		toggleTabbedPane.addTab("Banner Panel", IconFactory.getSwingIcon("component/panel_16.png"), new DemoToggleTemplate(new DemoBannerPanel()), "Banner Panel");
		toggleTabbedPane.addTab("IP Property Panel", IconFactory.getSwingIcon("component/panel_16.png"), new DemoToggleTemplate(new DemoIPPropertyPanel()), "IP Property Panel");		
	}
	
	public String getToggleText()
	{
		return "Panel";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/panel_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/panel_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Panel";
	}
}