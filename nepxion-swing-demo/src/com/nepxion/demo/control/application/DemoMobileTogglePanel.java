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
import com.nepxion.demo.component.searcher.mobile.locating.DemoLocatingMobilePanel;
import com.nepxion.demo.component.searcher.mobile.netease.DemoNeteaseMobilePanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoMobileTogglePanel
	extends DemoTogglePanel
{
	public DemoMobileTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("手机归属地查询  - 手机之家接口", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoLocatingMobilePanel()), "手机归属地查询 - 手机之家接口");
		toggleTabbedPane.addTab("手机归属地查询  - 网易接口", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoNeteaseMobilePanel()), "手机归属地查询  - 网易接口");		
	}
	
	public String getToggleText()
	{
		return "Mobile";
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
		return "Mobile - 手机之家接口，网易接口应用";
	}
}