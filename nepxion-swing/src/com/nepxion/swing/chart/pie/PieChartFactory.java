package com.nepxion.swing.chart.pie;

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
import java.awt.Paint;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.Rotation;

import com.nepxion.swing.chart.JChartFactory;
import com.nepxion.swing.chart.JChartPanel;
import com.nepxion.swing.locale.SwingLocale;

public class PieChartFactory
{
	/**
	 * Creates the pie plot.
	 * @param pieDataset the instance of PieDataset
	 * @param toolTipText the tooltip text string
	 * @param legendToolTipText the legend tooltip text string
	 * @param isParticularLabel the boolean value of isParticularLabel
	 * @return the instance of PiePlot
	 */
	public static PiePlot createPiePlot(PieDataset pieDataset, String toolTipText, String legendToolTipText, boolean isParticularLabel)
	{
		PiePlot piePlot = createPiePlot(pieDataset, false, false, false);
		
		setPiePlotPreference(piePlot, toolTipText, legendToolTipText, isParticularLabel);
		
		return piePlot;
	}
	
	/**
	 * Creates the pie plot.
	 * @param pieDataset the instance of PieDataset
	 * @param labels the boolean value of label shown
	 * @param tooltips the boolean value of tooltip shown
	 * @param urls the boolean value of url shown
	 * @return the instance of PiePlot
	 */
	public static PiePlot createPiePlot(PieDataset pieDataset, boolean labels, boolean tooltips, boolean urls)
	{
		PiePlot piePlot = new PieChartPlot(pieDataset);
		
		if (labels)
		{
			piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator());
		}
		if (tooltips)
		{
			piePlot.setToolTipGenerator(new StandardPieToolTipGenerator());
		}
		if (urls)
		{
			piePlot.setURLGenerator(new StandardPieURLGenerator());
		}
		
		return piePlot;
	}
	
	/**
	 * Creates the pie plot 3D.
	 * @param pieDataset the instance of PieDataset
	 * @param toolTipText the tooltip text string
	 * @param legendToolTipText the legend tooltip text string
	 * @param isParticularLabel the boolean value of isParticularLabel
	 * @return the instance of PiePlot
	 */
	public static PiePlot createPiePlot3D(PieDataset pieDataset, String toolTipText, String legendToolTipText, boolean isParticularLabel)
	{
		PiePlot piePlot = createPiePlot3D(pieDataset, false, false, false);
		
		setPiePlotPreference(piePlot, toolTipText, legendToolTipText, isParticularLabel);
		
		return piePlot;
	}
	
	/**
	 * Creates the pie plot 3D.
	 * @param pieDataset the instance of PieDataset
	 * @param labels the boolean value of label shown
	 * @param tooltips the boolean value of tooltip shown
	 * @param urls the boolean value of url shown
	 * @return the instance of PiePlot
	 */
	public static PiePlot createPiePlot3D(PieDataset pieDataset, boolean labels, boolean tooltips, boolean urls)
	{
		PiePlot piePlot = new PieChartPlot3D(pieDataset);

		if (labels)
		{
			piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator());
		}
		if (tooltips)
		{
			piePlot.setToolTipGenerator(new StandardPieToolTipGenerator());
		}
		if (urls)
		{
			piePlot.setURLGenerator(new StandardPieURLGenerator());
		}
		
		return piePlot;
	}
	
	/**
	 * Sets the pie plot preference.
	 * @param piePlot the instance of PiePlot
	 * @param toolTipText the tooltip text string
	 * @param legendToolTipText the legend tooltip text string
	 * @param isParticularLabel the boolean value of isParticularLabel
	 */
	public static void setPiePlotPreference(PiePlot piePlot, String toolTipText, String legendToolTipText, boolean isParticularLabel)
	{
		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator(isParticularLabel ? "{0} : {2}, {1}" : "{1}", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
		piePlot.setToolTipGenerator(new StandardPieToolTipGenerator("{0} : " + toolTipText + " [{1}], " + SwingLocale.getString("percent") + " [{2}], " + SwingLocale.getString("total") + " [{3}]", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
		piePlot.setLegendLabelToolTipGenerator(new StandardPieSectionLabelGenerator(legendToolTipText + " - {0}"));
		
		piePlot.setInsets(new RectangleInsets(4.0, 8.0, 0.0, 8.0)); // 4.0, 8.0, 4.0, 8.0
		piePlot.setDirection(Rotation.ANTICLOCKWISE);
		piePlot.setStartAngle(270D);
		piePlot.setForegroundAlpha(0.75F);
		piePlot.setSimpleLabels(false);
		piePlot.setBackgroundPaint(new GradientPaint(0.0F, 0.0F, Color.gray, 0.0F, 0.0F, new Color(251, 251, 251), true));
	}
	
	/**
	 * Gets the pie plot selection key.
	 * @param chartPanel the instance of JChartPanel
	 * @return the pie plot selection key.
	 */
	public static Comparable getPiePlotSelectionKey(JChartPanel chartPanel)
	{
		JFreeChart chart = chartPanel.getChart();	
	
		return getPiePlotSelectionKey(chart);
	}
	
	/**
	 * Gets the pir plot selection key.
	 * @param chart the instance of JFreeChart
	 * @return the pie plot selection key.
	 */
	public static Comparable getPiePlotSelectionKey(JFreeChart chart)
	{
		Plot plot = chart.getPlot();
		
		if (plot instanceof IPieChartPlot)
		{
			IPieChartPlot pieChartPlot = (IPieChartPlot) plot;
			
			Comparable key = pieChartPlot.getSelectionKey();
			
			return key;
		}	
		
		return null;
	}
	
	/**
	 * Sets the section paint.
	 * @param piePlot the instance of PiePlot
	 */
	public static void setSectionPaint(PiePlot piePlot)
	{	
		int colorIndex = 0;
		
		for (Iterator iterator = piePlot.getDataset().getKeys().iterator(); iterator.hasNext();)
		{
			Comparable key = (Comparable) iterator.next();
			
			setSectionPaint(piePlot, key, colorIndex);
		
			colorIndex++;
		}	
	}
	
	/**
	 * Sets the section paint.
	 * @param piePlot the instance of PiePlot
	 * @param key the instance of Comparable
	 * @param colorIndex the color index value
	 */
	public static void setSectionPaint(PiePlot piePlot, Comparable key, int colorIndex)
	{				
		Paint paint = JChartFactory.getPaint(colorIndex);

		piePlot.setSectionPaint(key, paint);
	}
}