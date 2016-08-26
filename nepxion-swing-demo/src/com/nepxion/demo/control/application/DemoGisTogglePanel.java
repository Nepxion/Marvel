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
import com.nepxion.demo.component.searcher.gis.google.geo.DemoGeoPanel;
import com.nepxion.demo.component.searcher.gis.google.loc.DemoCellPanel;
import com.nepxion.demo.component.searcher.gis.google.loc.DemoCoordinatePanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoGisTogglePanel
	extends DemoTogglePanel
{
	public DemoGisTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("模糊查询 - 谷歌地图接口", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoGeoPanel()), "模糊查询地理位置 - 谷歌地图接口");
		toggleTabbedPane.addTab("根据经纬度查询 - 谷歌移动接口", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoCoordinatePanel()), "根据经纬度查询地理位置 - 谷歌移动接口");				
		toggleTabbedPane.addTab("根据移动信息查询 - 谷歌移动接口", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoCellPanel()), "根据移动信息查询地理位置 - 谷歌移动接口");		
	}	
	
	public String getToggleText()
	{
		return "GIS";
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
		return "GIS - 谷歌接口应用";
	}
}