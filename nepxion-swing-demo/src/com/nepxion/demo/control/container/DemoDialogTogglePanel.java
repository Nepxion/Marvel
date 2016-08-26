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
import com.nepxion.demo.component.dialog.DemoCaptionSplashDialogPanel;
import com.nepxion.demo.component.dialog.DemoExceptionDialogPanel;
import com.nepxion.demo.component.dialog.DemoBasicDialogPanel;
import com.nepxion.demo.component.dialog.DemoSplashDialogPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoDialogTogglePanel
	extends DemoTogglePanel
{
	public DemoDialogTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Basic Dialog", IconFactory.getSwingIcon("component/dialog_16.png"), new DemoToggleTemplate(new DemoBasicDialogPanel()), "Basic Dialog");
		toggleTabbedPane.addTab("Exception Dialog", IconFactory.getSwingIcon("component/dialog_16.png"), new DemoToggleTemplate(new DemoExceptionDialogPanel()), "Exception Dialog");
		toggleTabbedPane.addTab("Splash Dialog", IconFactory.getSwingIcon("component/dialog_16.png"), new DemoToggleTemplate(new DemoSplashDialogPanel()), "Splash Dialog");
		toggleTabbedPane.addTab("Caption Splash Dialog", IconFactory.getSwingIcon("component/dialog_16.png"), new DemoToggleTemplate(new DemoCaptionSplashDialogPanel()), "Caption Splash Dialog");		
	}
	
	public String getToggleText()
	{
		return "Dialog";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/dialog_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/dialog_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Dialog";
	}
}