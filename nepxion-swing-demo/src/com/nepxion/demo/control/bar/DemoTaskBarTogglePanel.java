package com.nepxion.demo.control.bar;

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
import com.nepxion.demo.component.taskbar.DemoTaskBarPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoTaskBarTogglePanel
	extends DemoTogglePanel
{
	public DemoTaskBarTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("TaskBar", IconFactory.getSwingIcon("component/tool_bar_16.png"), new DemoToggleTemplate(new DemoTaskBarPanel()), "TaskBar");
	}
	
	public String getToggleText()
	{
		return "TaskBar";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/tool_bar_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/tool_bar_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style TaskBar";
	}
}