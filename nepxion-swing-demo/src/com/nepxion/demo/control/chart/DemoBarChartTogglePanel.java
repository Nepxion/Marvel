package com.nepxion.demo.control.chart;

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
import com.nepxion.demo.component.chart.bar.DemoCylinderBarChart3DPanel;
import com.nepxion.demo.component.chart.bar.DemoRectangleBarChart3DPanel;
import com.nepxion.demo.component.chart.bar.DemoRectangleBarChartPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoBarChartTogglePanel
	extends DemoTogglePanel
{
	public DemoBarChartTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Rectangle Bar Chart 3D", IconFactory.getSwingIcon("component/chart_bar_16.png"), new DemoToggleTemplate(new DemoRectangleBarChart3DPanel()), "Rectangle Bar Chart 3D");
		toggleTabbedPane.addTab("Rectangle Bar Chart", IconFactory.getSwingIcon("component/chart_bar_16.png"), new DemoToggleTemplate(new DemoRectangleBarChartPanel()), "Rectangle Bar Chart");
		toggleTabbedPane.addTab("Cylinder Bar Chart 3D", IconFactory.getSwingIcon("component/chart_bar_16.png"), new DemoToggleTemplate(new DemoCylinderBarChart3DPanel()), "Cylinder Bar Chart 3D");		
	}
	
	public String getToggleText()
	{
		return "Bar Chart";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/chart_bar_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/chart_bar_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Bar Chart";
	}
}