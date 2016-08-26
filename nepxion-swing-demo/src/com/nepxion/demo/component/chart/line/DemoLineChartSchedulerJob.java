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

import java.util.Iterator;

import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.nepxion.demo.component.chart.DemoChartContext;
import com.nepxion.util.scheduler.quartz.QuartzJob;

public class DemoLineChartSchedulerJob
	implements QuartzJob
{
	private double value = 100D;
	
	public DemoLineChartSchedulerJob()
	{
		
	}
	
	public void execute(JobExecutionContext context)
		throws JobExecutionException
	{
		DemoLineChartPanel lineChartPanel = DemoChartContext.getLineChartPanel();
		CombinedDomainXYPlot xyPlot = lineChartPanel.getCombinedDomainXYPlot();
		
		random(xyPlot);
	}
	
	private void random(CombinedDomainXYPlot xyPlot)
	{
		for (Iterator iterator = xyPlot.getSubplots().iterator(); iterator.hasNext();)
		{
			XYPlot xyplot = (XYPlot) iterator.next();
			value = value * (0.90000000000000002D + 0.20000000000000001D * Math.random());
			
			TimeSeriesCollection timeSeriesCollection = (TimeSeriesCollection) xyplot.getDataset();
			TimeSeries timeSeries = timeSeriesCollection.getSeries(0);
			if (timeSeries.getItemCount() > 100)
			{
				timeSeries.delete(0, 0);
			}
			timeSeries.add(new Millisecond(), value);
		}
	}
}