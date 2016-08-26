package com.nepxion.demo.component.chart;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.demo.component.chart.bar.DemoCylinderBarChart3DPanel;
import com.nepxion.demo.component.chart.bar.DemoRectangleBarChart3DPanel;
import com.nepxion.demo.component.chart.bar.DemoRectangleBarChartPanel;
import com.nepxion.demo.component.chart.line.DemoLineChartPanel;
import com.nepxion.demo.component.chart.pie.DemoPieChartPanel;

public class DemoChartContext
{
	private static DemoRectangleBarChart3DPanel rectangleBarChart3DPanel;
	private static DemoRectangleBarChartPanel rectangleBarChartPanel;
	private static DemoCylinderBarChart3DPanel cylinderBarChart3DPanel;
	private static DemoPieChartPanel pieChartPanel;
	private static DemoLineChartPanel lineChartPanel;
	
	public static void registerRectangleBarChart3DPanel(DemoRectangleBarChart3DPanel customRectangleBarChart3DPanel)
	{
		rectangleBarChart3DPanel = customRectangleBarChart3DPanel;
	}
	
	public static void registerRectangleBarChartPanel(DemoRectangleBarChartPanel customRectangleBarChartPanel)
	{
		rectangleBarChartPanel = customRectangleBarChartPanel;
	}
	
	public static void registerCylinderBarChart3DPanel(DemoCylinderBarChart3DPanel customCylinderBarChart3DPanel)
	{
		cylinderBarChart3DPanel = customCylinderBarChart3DPanel;
	}
	
	public static void registerPieChartPanel(DemoPieChartPanel customPieChartPanel)
	{
		pieChartPanel = customPieChartPanel;
	}
	
	public static void registerLineChartPanel(DemoLineChartPanel customLineChartPanel)
	{
		lineChartPanel = customLineChartPanel;
	}
	
	public static DemoRectangleBarChart3DPanel getRectangleBarChart3DPanel()
	{
		return rectangleBarChart3DPanel;
	}
	
	public static DemoRectangleBarChartPanel getRectangleBarChartPanel()
	{
		return rectangleBarChartPanel;
	}
	
	public static DemoCylinderBarChart3DPanel getCylinderBarChart3DPanel()
	{
		return cylinderBarChart3DPanel;
	}
	
	public static DemoPieChartPanel getPieChartPanel()
	{
		return pieChartPanel;
	}
	
	public static DemoLineChartPanel getLineChartPanel()
	{
		return lineChartPanel;
	}
}