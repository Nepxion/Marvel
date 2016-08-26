package com.nepxion.demo.control.application;

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
import com.nepxion.demo.component.searcher.zone.local.DemoZonePanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoZoneTogglePanel
	extends DemoTogglePanel
{
	public DemoZoneTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("区号查询  - 本地接口", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoZonePanel()), "区号查询  - 本地接口");		
	}
	
	public String getToggleText()
	{
		return "Zone";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/application_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/application_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Zone - 本地接口应用";
	}
}