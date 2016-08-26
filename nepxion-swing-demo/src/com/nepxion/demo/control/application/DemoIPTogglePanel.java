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
import com.nepxion.demo.component.searcher.ip.local.DemoIPPanel;
import com.nepxion.demo.component.searcher.ip.local.DemoAddressPanel;
import com.nepxion.demo.component.searcher.ip.netease.DemoNeteaseIPPanel;
import com.nepxion.demo.component.searcher.ip.sina.DemoSinaIPPanel;
import com.nepxion.demo.component.searcher.ip.tencent.DemoTencentIPPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoIPTogglePanel
	extends DemoTogglePanel
{
	public DemoIPTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("模糊查询 - 本地接口", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoAddressPanel()), "模糊查询地理位置 - 本地接口");
		toggleTabbedPane.addTab("根据IP地址查询 - 本地接口", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoIPPanel()), "根据IP地址查询地理位置 - 本地接口");
		toggleTabbedPane.addTab("根据IP地址查询 - 网易接口", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoNeteaseIPPanel()), "根据IP地址查询地理位置 - 网易接口");
		toggleTabbedPane.addTab("根据IP地址查询 - 新浪接口", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoSinaIPPanel()), "根据IP地址查询地理位置 - 新浪接口");
		toggleTabbedPane.addTab("本地IP地址查询 - 腾讯接口", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoTencentIPPanel()), "本地IP地址查询地理位置 - 腾讯接口");		
	}	
	
	public String getToggleText()
	{
		return "IP";
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
		return "IP - 本地接口，网易接口，新浪接口，腾讯接口应用";
	}
}