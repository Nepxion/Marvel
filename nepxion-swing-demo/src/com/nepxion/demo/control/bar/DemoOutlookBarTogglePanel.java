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
import com.nepxion.demo.component.outlookbar.DemoOutlookBarPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoOutlookBarTogglePanel
	extends DemoTogglePanel
{
	public DemoOutlookBarTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("OutlookBar", IconFactory.getSwingIcon("component/tool_bar_16.png"), new DemoToggleTemplate(new DemoOutlookBarPanel()), "OutlookBar");		
	}
	
	public String getToggleText()
	{
		return "OutlookBar";
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
		return "Multi-style OutlookBar";
	}
}