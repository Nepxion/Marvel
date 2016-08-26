package com.nepxion.demo.component.chart.pie;

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
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.nepxion.demo.component.chart.DemoChartContext;
import com.nepxion.demo.component.chart.DemoChartSchedulerToolBar;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.chart.JChartFactory;
import com.nepxion.swing.chart.JChartPanel;
import com.nepxion.swing.chart.pie.PieChartFactory;
import com.nepxion.swing.chart.pie.PiePlotRotator;
import com.nepxion.swing.chart.pie.PieSelectionAdapter;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.layout.table.TableLayout;

public class DemoPieChartPanel
	extends JPanel
{
	private PiePlot cpuPiePiePlot3D;
	private PiePlot memoryPiePlot3D;
	private PiePlot diskPiePlot3D;
	
	private PiePlot cpuPiePiePlot;
	private PiePlot memoryPiePlot;
	private PiePlot diskPiePlot;
	
	public DemoPieChartPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new PieChartPanel());		
	}
	
	public class PieChartPanel
		extends JPanel
	{
		public PieChartPanel()
		{
			double[][] size = 
			{ 
				{TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}, 
				{TableLayout.PREFERRED, 250, 250}
			};
			setLayout(new TableLayout(size));
			setBorder(BorderManager.createComplexTitledBorder("���������ʵʱͳ��ͼ"));

			add(new DemoChartSchedulerToolBar(DemoPieChartSchedulerJob.class), "0, 0, 2, 0");
			add(new CPUPieChart3DPanel(), "0, 1");
			add(new MemoryPieChart3DPanel(), "1, 1");
			add(new DiskPieChart3DPanel(), "2, 1");
			add(new CPUPieChartPanel(), "0, 2");
			add(new MemoryPieChartPanel(), "1, 2");
			add(new DiskPieChartPanel(), "2, 2");
			
			DemoChartContext.registerPieChartPanel(DemoPieChartPanel.this);
		}
	}
	
	public class CPUPieChart3DPanel
		extends JPanel
	{
		public CPUPieChart3DPanel()
		{
			setLayout(new BorderLayout());
			
			DefaultPieDataset cpuPieDataset = new DefaultPieDataset();
			cpuPieDataset.setValue("����", 20D);
			cpuPieDataset.setValue("ռ��", 80D);
			
			cpuPiePiePlot3D = PieChartFactory.createPiePlot3D(cpuPieDataset, "���������ָ��", "Ŀ¼", true);
			cpuPiePiePlot3D.setSectionPaint("����", Color.green);
			cpuPiePiePlot3D.setSectionPaint("ռ��", Color.red);
			
			JFreeChart chart = JChartFactory.createChart("CPUռ����ʵʱͳ��ͼ", "Nepxion Studio Statistics", cpuPiePiePlot3D);
			
			JChartPanel chartPanel = JChartFactory.createChartPanel(chart);
			chartPanel.addChartMouseListener(new PieSelectionAdapter());
			chartPanel.setBorder(BorderManager.createScrollPaneBorder());
			
			PiePlotRotator rotator = new PiePlotRotator(chartPanel, true);
			rotator.start();
			
			add(chartPanel, BorderLayout.CENTER);
		}
	}
	
	public class MemoryPieChart3DPanel
		extends JPanel
	{
		public MemoryPieChart3DPanel()
		{
			setLayout(new BorderLayout());
			
			DefaultPieDataset memoryPieDataset = new DefaultPieDataset();
			
			memoryPieDataset.setValue("����", 60D);
			memoryPieDataset.setValue("ռ��", 40D);
			
			memoryPiePlot3D = PieChartFactory.createPiePlot3D(memoryPieDataset, "�ڴ�ռ����ʵʱͳ��ͼ", "Ŀ¼", true);
			memoryPiePlot3D.setSectionPaint("����", Color.green);
			memoryPiePlot3D.setSectionPaint("ռ��", Color.red);
			
			JFreeChart chart = JChartFactory.createChart("�ڴ�ռ����ʵʱͳ��ͼ", "Nepxion Studio Statistics", memoryPiePlot3D);
			
			JChartPanel chartPanel = JChartFactory.createChartPanel(chart);
			chartPanel.addChartMouseListener(new PieSelectionAdapter());
			chartPanel.setBorder(BorderManager.createScrollPaneBorder());
			
			PiePlotRotator rotator = new PiePlotRotator(chartPanel, true);
			rotator.start();
			
			chartPanel.setBorder(BorderManager.createScrollPaneBorder());
			add(chartPanel, BorderLayout.CENTER);
		}
	}
	
	public class DiskPieChart3DPanel
		extends JPanel
	{
		public DiskPieChart3DPanel()
		{
			setLayout(new BorderLayout());
			
			DefaultPieDataset diskPieDataset = new DefaultPieDataset();
			
			diskPieDataset.setValue("����", 30D);
			diskPieDataset.setValue("ռ��", 25D);
			diskPieDataset.setValue("Ԥռ", 20D);
			diskPieDataset.setValue("Ԥ��", 15D);
			diskPieDataset.setValue("�ѻ�", 7D);
			diskPieDataset.setValue("����", 3D);
	        
			diskPiePlot3D = PieChartFactory.createPiePlot3D(diskPieDataset, "����ռ����ʵʱͳ��ͼ", "Ŀ¼", true);
			diskPiePlot3D.setSectionPaint("����", Color.green);
			diskPiePlot3D.setSectionPaint("ռ��", Color.red);
			diskPiePlot3D.setSectionPaint("Ԥռ", Color.pink);
			diskPiePlot3D.setSectionPaint("Ԥ��", Color.orange);
			diskPiePlot3D.setSectionPaint("�ѻ�", Color.gray);
			diskPiePlot3D.setSectionPaint("����", Color.white);
			
			JFreeChart chart = JChartFactory.createChart("����ռ����ʵʱͳ��ͼ", "Nepxion Studio Statistics", diskPiePlot3D);
			
			JChartPanel chartPanel = JChartFactory.createChartPanel(chart);
			chartPanel.addChartMouseListener(new PieSelectionAdapter());
			chartPanel.setBorder(BorderManager.createScrollPaneBorder());
			
			PiePlotRotator rotator = new PiePlotRotator(chartPanel, true);
			rotator.start();
			
			chartPanel.setBorder(BorderManager.createScrollPaneBorder());
			add(chartPanel, BorderLayout.CENTER);
		}
	}
	
	public class CPUPieChartPanel
		extends JPanel
	{
		public CPUPieChartPanel()
		{
			setLayout(new BorderLayout());
			
			DefaultPieDataset cpuPieDataset = new DefaultPieDataset();
			
			cpuPieDataset.setValue("����", 20D);
			cpuPieDataset.setValue("ռ��", 80D);
			
			cpuPiePiePlot = PieChartFactory.createPiePlot(cpuPieDataset, "CPUռ����ʵʱͳ��ͼ", "Ŀ¼", true);
			cpuPiePiePlot.setSectionPaint("����", Color.green);
			cpuPiePiePlot.setSectionPaint("ռ��", Color.red);
			
			JFreeChart chart = JChartFactory.createChart("CPUռ����ʵʱͳ��ͼ", "Nepxion Studio Statistics", cpuPiePiePlot);
			
			JChartPanel chartPanel = JChartFactory.createChartPanel(chart);
			chartPanel.addChartMouseListener(new PieSelectionAdapter());
			chartPanel.setBorder(BorderManager.createScrollPaneBorder());
			
			PiePlotRotator rotator = new PiePlotRotator(chartPanel, true);
			rotator.start();
			
			add(chartPanel, BorderLayout.CENTER);
		}
	}
	
	public class MemoryPieChartPanel
		extends JPanel
	{
		public MemoryPieChartPanel()
		{
			setLayout(new BorderLayout());
			
			DefaultPieDataset memoryPieDataset = new DefaultPieDataset();
			
			memoryPieDataset.setValue("����", 60D);
			memoryPieDataset.setValue("ռ��", 40D);
			
			memoryPiePlot = PieChartFactory.createPiePlot(memoryPieDataset, "�ڴ�ռ����ʵʱͳ��ͼ", "Ŀ¼", true);
			memoryPiePlot.setSectionPaint("����", Color.green);
			memoryPiePlot.setSectionPaint("ռ��", Color.red);
			
			JFreeChart chart = JChartFactory.createChart("�ڴ�ռ����ʵʱͳ��ͼ", "Nepxion Studio Statistics", memoryPiePlot);
			
			JChartPanel chartPanel = JChartFactory.createChartPanel(chart);
			chartPanel.addChartMouseListener(new PieSelectionAdapter());
			chartPanel.setBorder(BorderManager.createScrollPaneBorder());
			
			PiePlotRotator rotator = new PiePlotRotator(chartPanel, true);
			rotator.start();
			
			chartPanel.setBorder(BorderManager.createScrollPaneBorder());
			add(chartPanel, BorderLayout.CENTER);
		}
	}
	
	public class DiskPieChartPanel
		extends JPanel
	{
		public DiskPieChartPanel()
		{
			setLayout(new BorderLayout());
			
			DefaultPieDataset diskPieDataset = new DefaultPieDataset();
			
			diskPieDataset.setValue("����", 30D);
			diskPieDataset.setValue("ռ��", 25D);
			diskPieDataset.setValue("Ԥռ", 20D);
			diskPieDataset.setValue("Ԥ��", 15D);
			diskPieDataset.setValue("�ѻ�", 7D);
			diskPieDataset.setValue("����", 3D);
			
			diskPiePlot = PieChartFactory.createPiePlot(diskPieDataset, "����ռ����ʵʱͳ��ͼ", "Ŀ¼", true);
			diskPiePlot.setSectionPaint("����", Color.green);
			diskPiePlot.setSectionPaint("ռ��", Color.red);
			diskPiePlot.setSectionPaint("Ԥռ", Color.pink);
			diskPiePlot.setSectionPaint("Ԥ��", Color.orange);
			diskPiePlot.setSectionPaint("�ѻ�", Color.gray);
			diskPiePlot.setSectionPaint("����", Color.white);
			
			JFreeChart chart = JChartFactory.createChart("����ռ����ʵʱͳ��ͼ", "Nepxion Studio Statistics", diskPiePlot);
			
			JChartPanel chartPanel = JChartFactory.createChartPanel(chart);
			chartPanel.addChartMouseListener(new PieSelectionAdapter());
			chartPanel.setBorder(BorderManager.createScrollPaneBorder());
			
			PiePlotRotator rotator = new PiePlotRotator(chartPanel, true);
			rotator.start();
			
			chartPanel.setBorder(BorderManager.createScrollPaneBorder());
			add(chartPanel, BorderLayout.CENTER);
		}
	}
	
	public PiePlot getCPUPiePlot3D()
	{
		return cpuPiePiePlot3D;
	}
	
	public PiePlot getMemoryPiePlot3D()
	{
		return memoryPiePlot3D;
	}
	
	public PiePlot getDiskPiePlot3D()
	{
		return diskPiePlot3D;
	}	
	
	public PiePlot getCPUPiePlot()
	{
		return cpuPiePiePlot;
	}
	
	public PiePlot getMemoryPiePlot()
	{
		return memoryPiePlot;
	}
	
	public PiePlot getDiskPiePlot()
	{
		return diskPiePlot;
	}
}