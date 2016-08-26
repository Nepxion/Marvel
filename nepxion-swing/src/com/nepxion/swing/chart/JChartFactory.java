package com.nepxion.swing.chart;

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
import java.awt.RenderingHints;

import org.jfree.chart.ChartColor;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.Range;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.UnitType;

import com.nepxion.swing.color.ColorUtil;
import com.nepxion.swing.font.FontContext;

public class JChartFactory
{
	/**
	 * The default chart paint list.
	 */
	public static final Paint[] CHART_PAINT_LIST = ChartColor.createDefaultPaintArray();
	
	/**
	 * Creates the chart pane by a chart.
	 * @param chart the instance of JFreeChart
	 * @return the instance of JChartPanel
	 */
	public static JChartPanel createChartPanel(JFreeChart chart)
	{
		JChartPanel chartPanel = new JChartPanel(chart);
		
		return chartPanel;
	}
	
	/**
	 * Creates the chart by a title, sub title and plot.
	 * @param title the title string
	 * @param subTitle the sub title string
	 * @param plot the instance of Plot
	 * @return the instance of JFreeChart
	 */
	public static JFreeChart createChart(String title, String subTitle, Plot plot)
	{
		JFreeChart chart = new JFreeChart(plot);
		
		chart.setTitle(new TextTitle(title));
		chart.addSubtitle(new TextTitle(subTitle));
		
		setChartPreference(chart);
		
		return chart;
	}
	
	/**
	 * Sets the chart preference.
	 * @param chart the instance of JFreeChart
	 */
	public static void setChartPreference(JFreeChart chart)
	{
		chart.setBackgroundPaint(Color.white);
		
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setBackgroundPaint(new Color(128, 128, 128, 30));
		legendTitle.setMargin(new RectangleInsets(UnitType.ABSOLUTE, 5.0D, 5D, 5.0D, 5D));
		legendTitle.setPosition(RectangleEdge.BOTTOM);
		
		// Font
		chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
		
		TextTitle textTitle = chart.getTitle();
		if (textTitle != null)
		{
			textTitle.setFont(FontContext.getChartTitleFont());
		}
		
		for (int i = 0; i < chart.getSubtitleCount(); i++)
		{
			Title subTitle = chart.getSubtitle(i);
			if (subTitle instanceof TextTitle)
			{
				TextTitle subTextTitle = (TextTitle) subTitle;
				subTextTitle.setFont(FontContext.getChartSubTitleFont());
			}
		}
		
		if (legendTitle != null)
		{
			legendTitle.setItemFont(FontContext.getChartLabelFont());
		}
		
		Plot plot = chart.getPlot();
		if (plot != null)
		{
			if (plot instanceof PiePlot)
			{
				PiePlot piePlot = (PiePlot) plot;
				piePlot.setLabelFont(FontContext.getChartLabelFont());
				piePlot.setNoDataMessageFont(FontContext.getChartLabelFont());
			}
			else if (plot instanceof CategoryPlot)
			{
				CategoryPlot categoryPlot = (CategoryPlot) plot;
				for (int i = 0; i < categoryPlot.getDomainAxisCount(); i++)
				{
					CategoryAxis domainAxis = categoryPlot.getDomainAxis(i);
					if (domainAxis != null)
					{
						domainAxis.setLabelFont(FontContext.getChartLabelFont());
						domainAxis.setTickLabelFont(FontContext.getChartTickLabelFont());
					}
				}
				
				for (int i = 0; i < categoryPlot.getRangeAxisCount(); i++)
				{
					ValueAxis rangeAxis = categoryPlot.getRangeAxis(i);
					if (rangeAxis != null)
					{
						rangeAxis.setLabelFont(FontContext.getChartLabelFont());
						rangeAxis.setTickLabelFont(FontContext.getChartTickLabelFont());
					}
				}
			}
			else if (plot instanceof XYPlot)
			{
				XYPlot xyPlot = (XYPlot) plot;
				for (int i = 0; i < xyPlot.getDomainAxisCount(); i++)
				{
					ValueAxis domainAxis = xyPlot.getDomainAxis(i);
					if (domainAxis != null)
					{
						domainAxis.setLabelFont(FontContext.getChartLabelFont());
						domainAxis.setTickLabelFont(FontContext.getChartTickLabelFont());
					}
				}
				
				for (int i = 0; i < xyPlot.getRangeAxisCount(); i++)
				{
					ValueAxis rangeAxis = xyPlot.getRangeAxis(i);
					if (rangeAxis != null)
					{
						rangeAxis.setLabelFont(FontContext.getChartLabelFont());
						rangeAxis.setTickLabelFont(FontContext.getChartTickLabelFont());
					}
				}
			}
		}
	}
	
	/**
	 * Fixes the range for the chart.
	 * @param rangeAxis the instance of ValueAxis
	 * @param lowerFixedPercent the lower fixed percent
	 * @param upperFixedPercent the upper fixed percent
	 */
	public static void fixRange(ValueAxis rangeAxis, double lowerFixedPercent, double upperFixedPercent)
	{
		Range range = rangeAxis.getRange();
		
		double lowerFixedValue = range.getLowerBound() * (1 + lowerFixedPercent);
		double upperFixedValue = range.getUpperBound() * (1 + upperFixedPercent);
		
		rangeAxis.setRange(new Range(lowerFixedValue, upperFixedValue));
	}
	
	/**
	 * Gets the paint by an index.
	 * @param index the index value
	 * @return the instance of Paint
	 */
	public static Paint getPaint(int index)
	{
		Paint[] chartPaintList = CHART_PAINT_LIST;
		
		Paint paint = null;
		switch (index)
		{
			case 0 : 
			{
				paint = Color.red; break;
			}
			case 1 : 
			{
				paint = Color.green; break;
			}
			case 2 :
			{
				paint = Color.blue; break;			
			}
			default :
			{
				if (index < chartPaintList.length)
				{
					paint = (Paint) chartPaintList[index];
				}
				else
				{
					paint = ColorUtil.getRandomColor();
				}
			}	
		}
		
		return paint;
	}
	
	/**
	 * Gets the gradient paint by an index.
	 * The boolean value of isAsc is true.
	 * @param index the index value
	 * @return the instance of Paint
	 */
	public static Paint getGradientPaint(int index)
	{
		return getGradientPaint(index, true);
	}
	
	/**
	 * Gets the gradient paint by an index.
	 * If the boolean value of isAsc is true, it will be gradient painted ascending, otherwise descending.
	 * @param index the index value
	 * @param isAsc the boolean value of isAsc
	 * @return
	 */
	public static Paint getGradientPaint(int index, boolean isAsc)
	{
		Color color1 = (Color) getPaint(index);
		
		Color color2 = null;
		if (color1 == Color.red)
		{
			color2 = new Color(64, 0, 0);
		}	
		else if (color1 == Color.green)
		{
			color2 = new Color(0, 64, 0);
		}
		else if (color1 == Color.blue)
		{
			color2 = new Color(0, 0, 64);
		}
		else
		{
			color2 = new Color(0, 0, 0);
		}
		
		GradientPaint paint = new GradientPaint(0.0F, 0.0F, isAsc ? color2 : color1, 0.0F, 0.0F, isAsc ? color1 : color2);
		
		return paint;
	}
}