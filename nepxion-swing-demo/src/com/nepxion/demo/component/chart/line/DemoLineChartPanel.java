package com.nepxion.demo.component.chart.line;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.XYPlot;

import com.nepxion.demo.component.chart.DemoChartContext;
import com.nepxion.demo.component.chart.DemoChartSchedulerToolBar;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.chart.JChartFactory;
import com.nepxion.swing.chart.JChartPanel;
import com.nepxion.swing.chart.line.LineChartFactory;
import com.nepxion.swing.layout.filed.FiledLayout;

public class DemoLineChartPanel
	extends JPanel
{
	private CombinedDomainXYPlot combinedDomainXYPlot;
	
	public DemoLineChartPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new CombinedLineChartPanel());
	}
	
	public class CombinedLineChartPanel
		extends JPanel
	{
		public CombinedLineChartPanel()
		{
			setLayout(new BorderLayout());
			setBorder(BorderManager.createComplexTitledBorder("计算机性能实时统计图"));
			
			XYPlot xyPlot1 = LineChartFactory.createTimeXYPlot("CPU", "计算机性能指标", true);
			XYPlot xyPlot2 = LineChartFactory.createTimeXYPlot("内存", "计算机性能指标", true);
			XYPlot xyPlot3 = LineChartFactory.createTimeXYPlot("磁盘", "计算机性能指标", true);
			
			combinedDomainXYPlot = LineChartFactory.createCombinedDomainXYPlot("时间轴");
			combinedDomainXYPlot.add(xyPlot1);
			combinedDomainXYPlot.add(xyPlot2);
			combinedDomainXYPlot.add(xyPlot3);
			
			JFreeChart chart = JChartFactory.createChart("计算机性能实时统计图", "Nepxion Studio Statistics", combinedDomainXYPlot);
			
			JChartPanel chartPanel = JChartFactory.createChartPanel(chart);
			chartPanel.setBorder(BorderManager.createScrollPaneBorder());
			
			add(chartPanel, BorderLayout.CENTER);
			add(new DemoChartSchedulerToolBar(DemoLineChartSchedulerJob.class), BorderLayout.NORTH);
			
			DemoChartContext.registerLineChartPanel(DemoLineChartPanel.this);
		}
	}
	
	public CombinedDomainXYPlot getCombinedDomainXYPlot()
	{
		return combinedDomainXYPlot;
	}
}