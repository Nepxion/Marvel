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

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.nepxion.demo.component.chart.DemoChartContext;
import com.nepxion.demo.component.chart.DemoChartSchedulerToolBar;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.chart.JChartFactory;
import com.nepxion.swing.chart.JChartPanel;
import com.nepxion.swing.chart.bar.BarSelectionAdapter;
import com.nepxion.swing.chart.bar.RectangleBarChartFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.layout.table.TableLayout;

public class DemoRectangleBarChart3DPanel
	extends JPanel
{
	private BarChartPanel verticalBarChartPanel;
	private BarChartPanel horizontalBarChartPanel;
	
	public DemoRectangleBarChart3DPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new ChartPanel());
	}
	
	public class ChartPanel
		extends JPanel
	{
		public ChartPanel()
		{
			double[][] size = 
			{ 
				{TableLayout.FILL, TableLayout.FILL}, 
				{TableLayout.PREFERRED, 500}
			};
			setLayout(new TableLayout(size));
			setBorder(BorderManager.createComplexTitledBorder("计算机性能实时统计图"));
			
			verticalBarChartPanel = new BarChartPanel(PlotOrientation.VERTICAL);
			horizontalBarChartPanel = new BarChartPanel(PlotOrientation.HORIZONTAL); 
			add(new DemoChartSchedulerToolBar(DemoRectangleBarChart3DSchedulerJob.class), "0, 0, 1, 0");
			add(verticalBarChartPanel, "0, 1");
			add(horizontalBarChartPanel, "1, 1");
			
			DemoChartContext.registerRectangleBarChart3DPanel(DemoRectangleBarChart3DPanel.this);
		}
	}
	
	public class BarChartPanel
		extends JPanel
	{
		private CategoryPlot categoryPlot;
		
		public BarChartPanel(PlotOrientation plotOrientation)
		{
			setLayout(new BorderLayout());
			
			DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
			categoryDataset.addValue(80D, "计算机 A", "CPU");
			categoryDataset.addValue(-30D, "计算机 B", "CPU");
			categoryDataset.addValue(45D, "计算机 C", "CPU");
			categoryDataset.addValue(50D, "计算机 D", "CPU");
			
			categoryDataset.addValue(70D, "计算机 A", "内存");
			categoryDataset.addValue(50D, "计算机 B", "内存");
			categoryDataset.addValue(-65D, "计算机 C", "内存");
			categoryDataset.addValue(45D, "计算机 D", "内存");

			categoryDataset.addValue(60D, "计算机 A", "磁盘");
			categoryDataset.addValue(10D, "计算机 B", "磁盘");
			categoryDataset.addValue(25D, "计算机 C", "磁盘");
			categoryDataset.addValue(-15D, "计算机 D", "磁盘");
			
			categoryPlot = RectangleBarChartFactory.createCategoryPlot3D(categoryDataset, plotOrientation, "目录", "值", "计算机性能指标", "目录", false, false);
			RectangleBarChartFactory.setSectionPaint(categoryPlot, 0, Color.red);
			RectangleBarChartFactory.setSectionPaint(categoryPlot, 1, Color.green);
			RectangleBarChartFactory.setSectionPaint(categoryPlot, 2, Color.yellow);
			RectangleBarChartFactory.setSectionPaint(categoryPlot, 3, Color.blue);
			
			RectangleBarChartFactory.setValueMarker(categoryPlot, "CPU", "CPU阀值 80%", 80D);
			RectangleBarChartFactory.setValueMarker(categoryPlot, "内存", "内存阀值 60%", 60D);
			RectangleBarChartFactory.setValueMarker(categoryPlot, "磁盘", "磁盘阀值 40%", 40D);
			
			JFreeChart chart = JChartFactory.createChart("计算机性能实时统计图", "Nepxion Studio Statistics", categoryPlot);
			
			JChartPanel chartPanel = JChartFactory.createChartPanel(chart);
			chartPanel.addChartMouseListener(new BarSelectionAdapter());
			chartPanel.setBorder(BorderManager.createScrollPaneBorder());
			
			add(chartPanel, BorderLayout.CENTER);
		}
		
		public CategoryPlot getCategoryPlot()
		{
			return categoryPlot;
		}
	}
	
	public BarChartPanel getVerticalBarChartPanel()
	{
		return verticalBarChartPanel;
	}
	
	public BarChartPanel getHorizontalBarChartPanel()
	{
		return horizontalBarChartPanel;
	}	
}