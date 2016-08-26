package com.nepxion.demo.component.chart.bar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Color;

import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.nepxion.demo.component.chart.DemoChartContext;
import com.nepxion.swing.chart.bar.CylinderBarChartFactory;
import com.nepxion.swing.color.ColorUtil;
import com.nepxion.util.data.RandomUtil;
import com.nepxion.util.scheduler.quartz.QuartzJob;

public class DemoCylinderBarChart3DSchedulerJob
	implements QuartzJob
{
	public DemoCylinderBarChart3DSchedulerJob()
	{
		
	}
	
	public void execute(JobExecutionContext context)
		throws JobExecutionException
	{
		DemoCylinderBarChart3DPanel barChartPanel = DemoChartContext.getCylinderBarChart3DPanel();
		
		CategoryPlot verticalCategoryPlot = barChartPanel.getVerticalBarChartPanel().getCategoryPlot();
		random(verticalCategoryPlot);
		
		CategoryPlot horizontalCategoryPlot = barChartPanel.getHorizontalBarChartPanel().getCategoryPlot();
		random(horizontalCategoryPlot);
	}
	
	private void random(CategoryPlot categoryPlot)
	{
		DefaultCategoryDataset categoryDataset = (DefaultCategoryDataset) categoryPlot.getDataset();
		
		int i = (int) (Math.random() * (double) categoryDataset.getRowCount());
		Comparable comparable = categoryDataset.getRowKey(i);
		int j = (int) (Math.random() * (double) categoryDataset.getColumnCount());
		Comparable comparable1 = categoryDataset.getColumnKey(j);
		if (categoryDataset.getValue(i, j) != null)
		{
			categoryDataset.setValue(RandomUtil.getRandomDouble(-100, 100), comparable, comparable1);
	
			CylinderBarChartFactory.setSectionPaint(categoryPlot, i, categoryPlot.getOrientation() == PlotOrientation.VERTICAL ? ColorUtil.getRandomColor() : Color.white, categoryPlot.getOrientation() == PlotOrientation.VERTICAL ? Color.white : ColorUtil.getRandomColor());
		}
	}
}