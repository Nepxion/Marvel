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
import com.nepxion.demo.component.thread.DemoThreadContainerPanel;
import com.nepxion.demo.component.thread.DemoThreadDialoglPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoThreadTogglePanel
	extends DemoTogglePanel
{
	public DemoThreadTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Thread Container", IconFactory.getSwingIcon("component/thread_16.png"), new DemoToggleTemplate(new DemoThreadContainerPanel()), "Thread Container");
		toggleTabbedPane.addTab("Thread Dialog", IconFactory.getSwingIcon("component/thread_16.png"), new DemoToggleTemplate(new DemoThreadDialoglPanel()), "Thread Dialog");		
	}
	
	public String getToggleText()
	{
		return "Thread";
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
		return "Multi-style Thread";
	}
}