package com.nepxion.demo.control.thread;

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
import com.nepxion.demo.component.timer.DemoTimerLabelPanel;
import com.nepxion.demo.component.timer.DemoTimerProgressBarPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoTimerTogglePanel
	extends DemoTogglePanel
{
	public DemoTimerTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Timer Label", IconFactory.getSwingIcon("component/thread_16.png"), new DemoToggleTemplate(new DemoTimerLabelPanel()), "Timer Label");
		toggleTabbedPane.addTab("Timer ProgressBar", IconFactory.getSwingIcon("component/thread_16.png"), new DemoToggleTemplate(new DemoTimerProgressBarPanel()), "Timer ProgressBar");		
	}
	
	public String getToggleText()
	{
		return "Timer";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/thread_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/thread_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Timer";
	}
}