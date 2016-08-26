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
import com.nepxion.demo.component.window.DemoCaptionSplashWindowPanel;
import com.nepxion.demo.component.window.DemoSplashWindowPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoWindowTogglePanel
	extends DemoTogglePanel
{
	public DemoWindowTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Splash Window", IconFactory.getSwingIcon("component/internal_frame_16.png"), new DemoToggleTemplate(new DemoSplashWindowPanel()), "Splash Window");
		toggleTabbedPane.addTab("Caption Splash Window", IconFactory.getSwingIcon("component/internal_frame_16.png"), new DemoToggleTemplate(new DemoCaptionSplashWindowPanel()), "Caption Splash Window");		
	}
	
	public String getToggleText()
	{
		return "Window";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/internal_frame_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/internal_frame_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Window";
	}
}