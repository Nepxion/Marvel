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

import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.nepxion.demo.component.chart.DemoChartContext;
import com.nepxion.swing.color.ColorUtil;
import com.nepxion.util.scheduler.quartz.QuartzJob;

public class DemoPieChartSchedulerJob
	implements QuartzJob
{
	public DemoPieChartSchedulerJob()
	{
		
	}
	
	public void execute(JobExecutionContext context)
		throws JobExecutionException
	{
		DemoPieChartPanel pieChartPanel = DemoChartContext.getPieChartPanel();
		
		PiePlot cpuPiePlot3D = pieChartPanel.getCPUPiePlot3D();
		random(cpuPiePlot3D);
		
		PiePlot memoryPiePlot3D = pieChartPanel.getMemoryPiePlot3D();
		random(memoryPiePlot3D);
		
		PiePlot diskPiePlot3D = pieChartPanel.getDiskPiePlot3D();
		random(diskPiePlot3D);
		
		PiePlot cpuPiePlot = pieChartPanel.getCPUPiePlot();
		random(cpuPiePlot);
		
		PiePlot memoryPiePlot = pieChartPanel.getMemoryPiePlot();
		random(memoryPiePlot);
		
		PiePlot diskPiePlot = pieChartPanel.getDiskPiePlot();
		random(diskPiePlot);
	}
	
	private void random(PiePlot piePlot)
	{
		DefaultPieDataset pieDataset = (DefaultPieDataset) piePlot.getDataset();
		
		int i = (int) (Math.random() * (double) pieDataset.getItemCount());
		Comparable comparable = pieDataset.getKey(i);
		pieDataset.setValue(comparable, Math.random() * 10D);
		
		piePlot.setSectionPaint(comparable, ColorUtil.getRandomColor());
		piePlot.setExplodePercent(comparable, Math.random() * 0.1D);
	}
}