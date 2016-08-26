package com.nepxion.swing.chart.line;

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
import java.awt.GradientPaint;
import java.text.DateFormat;
import java.text.NumberFormat;

import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYSeriesLabelGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;

import com.nepxion.swing.locale.SwingLocale;

public class LineChartFactory
{
	/**
	 * Creates the time xyPlot.
	 * @param title the title string 
	 * @param legendToolTipText the legend tooltip text string
	 * @param isShapesVisible the boolean value of isShapesVisible
	 * @return the instance of XYPlot
	 */
	public static XYPlot createTimeXYPlot(String title, String legendToolTipText, boolean isShapesVisible)
	{
		TimeSeries timeSeries = new TimeSeries(title);
		TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(timeSeries);
		
		NumberAxis numberAxis = new NumberAxis(title);
		
		XYLineAndShapeRenderer xyLineAndShapeRenderer = new XYLineAndShapeRenderer();
		
		XYPlot xyPlot = new XYPlot(timeSeriesCollection, null, numberAxis, xyLineAndShapeRenderer);
		
		setXYPlotPreference(xyPlot, legendToolTipText, isShapesVisible);
		
		return xyPlot;
	}
	
	/**
	 * Creates the combined domain xyPlot.
	 * @param title the title string
	 * @return the instance of CombinedDomainXYPlot
	 */
	public static CombinedDomainXYPlot createCombinedDomainXYPlot(String title)
	{
		DateAxis dateAxis = new DateAxis(title);
		CombinedDomainXYPlot combinedDomainXYPlot = new CombinedDomainXYPlot(dateAxis);
		
		return combinedDomainXYPlot;
	}
	
	/**
	 * Sets the xyPlot preference.
	 * @param xyPlot the instance of XYPlot
	 * @param legendToolTipText the legend tooltip text string 
	 * @param isShapesVisible the boolean value of isShapesVisible
	 */
	public static void setXYPlotPreference(XYPlot xyPlot, String legendToolTipText, boolean isShapesVisible)
	{
		xyPlot.setBackgroundPaint(new GradientPaint(0.0F, 0.0F, Color.gray, 0.0F, 0.0F, new Color(251, 251, 251), true));
		xyPlot.setDomainGridlinePaint(Color.white);
		xyPlot.setRangeGridlinePaint(Color.white);
		xyPlot.setAxisOffset(new RectangleInsets(0.0D, 0.0D, 5.0D, 0.0D));
		
		NumberAxis numberAxis = (NumberAxis) xyPlot.getRangeAxis();
		numberAxis.setAutoRangeIncludesZero(true);
		
		XYLineAndShapeRenderer xyLineAndShapeRenderer = (XYLineAndShapeRenderer) xyPlot.getRenderer();
		xyLineAndShapeRenderer.setBaseShapesVisible(isShapesVisible);
		xyLineAndShapeRenderer.setSeriesFillPaint(0, Color.white);
		xyLineAndShapeRenderer.setUseFillPaint(true);
		xyLineAndShapeRenderer.setLegendItemToolTipGenerator(new StandardXYSeriesLabelGenerator(legendToolTipText + " - {0}"));
		xyLineAndShapeRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0} : " + SwingLocale.getString("time") + " [{1}], " + SwingLocale.getString("value") + " [{2}]", DateFormat.getDateTimeInstance(), NumberFormat.getNumberInstance()));
	}
}