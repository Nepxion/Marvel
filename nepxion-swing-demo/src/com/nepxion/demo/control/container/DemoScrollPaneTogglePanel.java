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
import com.nepxion.demo.component.scrollpane.DemoAutoScrollPanePanel;
import com.nepxion.demo.component.scrollpane.DemoCornerScrollPanePanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoScrollPaneTogglePanel
	extends DemoTogglePanel
{
	public DemoScrollPaneTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Corner ScrollPane", IconFactory.getSwingIcon("component/scroll_pane_16.png"), new DemoToggleTemplate(new DemoCornerScrollPanePanel()), "Corner ScrollPane");
		toggleTabbedPane.addTab("Auto ScrollPane", IconFactory.getSwingIcon("component/scroll_pane_16.png"), new DemoToggleTemplate(new DemoAutoScrollPanePanel()), "Auto ScrollPane");		
	}
	
	public String getToggleText()
	{
		return "ScrollPane";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/scroll_pane_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/scroll_pane_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style ScrollPane";
	}
}