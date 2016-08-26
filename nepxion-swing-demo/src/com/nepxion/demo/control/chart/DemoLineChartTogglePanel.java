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
import com.nepxion.demo.component.chart.line.DemoLineChartPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoLineChartTogglePanel
	extends DemoTogglePanel
{
	public DemoLineChartTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Line Chart", IconFactory.getSwingIcon("component/chart_line_16.png"), new DemoToggleTemplate(new DemoLineChartPanel()), "Line Chart");		
	}
	
	public String getToggleText()
	{
		return "Line Chart";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/chart_line_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/chart_line_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Line Chart";
	}
}