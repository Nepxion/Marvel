package com.nepxion.swing.chart.bar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.text.NumberFormat;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.CategoryTextAnnotation;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.Layer;
import org.jfree.ui.TextAnchor;
import org.jfree.util.SortOrder;

import com.nepxion.swing.chart.JChartFactory;
import com.nepxion.swing.chart.JChartPanel;
import com.nepxion.swing.font.FontContext;

public class RectangleBarChartFactory
{
	/**
	 * Creates the category plot.
	 * @param categoryDataset the instance of CategoryDataset
	 * @param orientation the instance of PlotOrientation
	 * @param categoryAxisLabel the category axis label string
	 * @param valueAxisLabel the value axis label string
	 * @param toolTipText the tooltip text string
	 * @param legendToolTipText the legend tooltip text string
	 * @param isStacked the boolean value of isStacked
	 * @param isCategoryLabelRotated the boolean value of isCategoryLabelRotated
	 * @return the instance of CategoryPlot
	 */
	public static CategoryPlot createCategoryPlot(CategoryDataset categoryDataset, PlotOrientation orientation, String categoryAxisLabel, String valueAxisLabel, String toolTipText, String legendToolTipText, boolean isStacked, boolean isCategoryLabelRotated)
	{
		CategoryPlot categoryPlot = createCategoryPlot(categoryDataset, orientation, categoryAxisLabel, valueAxisLabel, isStacked, true, true, false);
		
		setCategoryPlotPreference(categoryPlot, orientation, toolTipText, legendToolTipText, isCategoryLabelRotated, 1.0F);
		
		return categoryPlot;
	}
	
	/**
	 * Creates the category plot.
	 * @param categoryDataset the instance of CategoryDataset
	 * @param orientation the instance of PlotOrientation
	 * @param categoryAxisLabel the category axis label string
	 * @param valueAxisLabel the value axis label string
	 * @param stacked the boolean value of isStacked
	 * @param labels the boolean value of label shown
	 * @param tooltips the boolean value of tooltip shown
	 * @param urls the boolean value of url shown
	 * @return the instance of CategoryPlot
	 */
	public static CategoryPlot createCategoryPlot(CategoryDataset categoryDataset, PlotOrientation orientation, String categoryAxisLabel, String valueAxisLabel, boolean stacked, boolean labels, boolean tooltips, boolean urls)
	{
		if (orientation == null)
		{
			throw new IllegalArgumentException("Null 'orientation' argument.");
		}
		
		CategoryAxis categoryAxis = new CategoryAxis(categoryAxisLabel);
		ValueAxis valueAxis = new NumberAxis(valueAxisLabel);
		
		BarRenderer barRenderer = null;
		if (stacked)
		{
			barRenderer = new StackedRectangleBarRenderer();
		}	
		else
		{
			barRenderer = new RectangleBarRenderer();
		}
		
		if (stacked)
		{	
			barRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
			barRenderer.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
		}
		else
		{
			if (orientation == PlotOrientation.HORIZONTAL)
			{
				barRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.CENTER_LEFT));
				barRenderer.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE9, TextAnchor.CENTER_RIGHT));
			}
			else if (orientation == PlotOrientation.VERTICAL)
			{
				barRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
				barRenderer.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER));
			}
		}
		
		if (labels)
		{
			barRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		}	
		if (tooltips)
		{
			barRenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
		}
		if (urls)
		{
			barRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
		}
		
		CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, valueAxis, barRenderer);
		categoryPlot.setOrientation(orientation);
		
		return categoryPlot;
	}
	
	/**
	 * Creates the category plot 3D.
	 * @param categoryDataset the instance of CategoryDataset
	 * @param orientation the instance of PlotOrientation
	 * @param categoryAxisLabel the category axis label string
	 * @param valueAxisLabel the value axis label string
	 * @param toolTipText the tooltip text string
	 * @param legendToolTipText the legend tooltip text string
	 * @param isStacked the boolean value of isStacked
	 * @param isCategoryLabelRotated the boolean value of isCategoryLabelRotated
	 * @return the instance of CategoryPlot
	 */
	public static CategoryPlot createCategoryPlot3D(CategoryDataset categoryDataset, PlotOrientation orientation, String categoryAxisLabel, String valueAxisLabel, String toolTipText, String legendToolTipText, boolean isStacked, boolean isCategoryLabelRotated)
	{	
		CategoryPlot categoryPlot = createCategoryPlot3D(categoryDataset, orientation, categoryAxisLabel, valueAxisLabel, isStacked, true, true, false);
	
		setCategoryPlotPreference(categoryPlot, orientation, toolTipText, legendToolTipText, isCategoryLabelRotated, 0.75F);
		
		return categoryPlot;
	}
		
	/**
	 * Creates the category plot 3D.
	 * @param categoryDataset the instance of CategoryDataset
	 * @param orientation the instance of PlotOrientation
	 * @param categoryAxisLabel the category axis label string
	 * @param valueAxisLabel the value axis label string
	 * @param stacked the boolean value of isStacked
	 * @param labels the boolean value of label shown
	 * @param tooltips the boolean value of tooltip shown
	 * @param urls the boolean value of url shown
	 * @return the instance of CategoryPlot
	 */
	public static CategoryPlot createCategoryPlot3D(CategoryDataset categoryDataset, PlotOrientation orientation, String categoryAxisLabel, String valueAxisLabel, boolean isStacked, boolean labels, boolean tooltips, boolean urls)
	{
		if (orientation == null)
		{
			throw new IllegalArgumentException("Null 'orientation' argument.");
		}
		CategoryAxis categoryAxis = new CategoryAxis3D(categoryAxisLabel);
		ValueAxis valueAxis = new NumberAxis3D(valueAxisLabel);
		
		BarRenderer3D barRenderer3D = null;
		if (isStacked)
		{	
			barRenderer3D = new StackedRectangleBarRenderer3D();
		}
		else
		{
			barRenderer3D = new RectangleBarRenderer3D();
		}
		
		if (isStacked)
		{	
			barRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
			barRenderer3D.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
		}
		else
		{
			if (orientation == PlotOrientation.HORIZONTAL)
			{
				barRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.BOTTOM_LEFT));
				barRenderer3D.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE9, TextAnchor.CENTER_LEFT));
				barRenderer3D.setItemLabelAnchorOffset(20D);
			}
			else if (orientation == PlotOrientation.VERTICAL)
			{
				barRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
				barRenderer3D.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.BASELINE_CENTER));
				barRenderer3D.setItemLabelAnchorOffset(12D);
			}
		}
		
		if (labels)
		{
			barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		}	
		if (tooltips)
		{
			barRenderer3D.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
		}
		if (urls)
		{
			barRenderer3D.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
		}
		
		CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, valueAxis, barRenderer3D);
		categoryPlot.setOrientation(orientation);
		
		return categoryPlot;
	}
	
	/**
	 * Sets the category plot preference.
	 * @param categoryPlot the instance of CategoryPlot
	 * @param orientation the instance of PlotOrientation
	 * @param toolTipText the tooltip text string
	 * @param legendToolTipText the legend tooltip text string
	 * @param isCategoryLabelRotated the boolean value of isCategoryLabelRotated
	 * @param foregroundAlpha the foreground alpha value
	 */
	public static void setCategoryPlotPreference(CategoryPlot categoryPlot, PlotOrientation orientation, String toolTipText, String legendToolTipText, boolean isCategoryLabelRotated, float foregroundAlpha)
	{
		// CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
		// CategoryLabelPositions categoryLabelPositions = categoryAxis.getCategoryLabelPositions();
		// CategoryLabelPosition categorylabelposition = new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.CENTER_LEFT, TextAnchor.CENTER_LEFT, 0.0D, CategoryLabelWidthType.RANGE, 0.3F);
		// categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.replaceLeftPosition(categoryLabelPositions, categorylabelposition));
		// categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.4D));
		// categoryAxis.setCategoryMargin(0.0D);
		
		BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
		
		barRenderer.setBaseItemLabelsVisible(true);
		barRenderer.setMaximumBarWidth(0.05D);
		barRenderer.setDrawBarOutline(true);
		// barRenderer3D.setBaseOutlineStroke(new BasicStroke(0.3F));	
		barRenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{1} : " + toolTipText + " [{2}]", NumberFormat.getNumberInstance()));
		barRenderer.setLegendItemToolTipGenerator(new StandardCategorySeriesLabelGenerator(legendToolTipText + " - {0}"));
		
		// if (orientation == PlotOrientation.HORIZONTAL)
		// {
		categoryPlot.setRowRenderingOrder(SortOrder.DESCENDING);
		categoryPlot.setColumnRenderingOrder(SortOrder.DESCENDING);
		//}		

		// NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
		// numberAxis.setUpperMargin(0.1D);
		// numberAxis.setNumberFormatOverride(NumberFormat.getPercentInstance());

		if (isCategoryLabelRotated)
		{	
			categoryPlot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.toRadians(30D)));
		}
		categoryPlot.getDomainAxis().setUpperMargin(0.03D);
		categoryPlot.getDomainAxis().setLowerMargin(0.03D);
		categoryPlot.getRangeAxis().setUpperMargin(0.10000000000000001D);
		categoryPlot.setForegroundAlpha(foregroundAlpha);
		categoryPlot.setRangePannable(true);
		categoryPlot.setDomainGridlinesVisible(true);
		categoryPlot.setBackgroundPaint(new Color(128, 128, 128, 30));
	}
	
	/**
	 * Gets the section paint.
	 * @param categoryPlot the instance of categoryPlot
	 * @param index the index value
	 * @return the instance of Paint
	 */
	public static Paint getSectionPaint(CategoryPlot categoryPlot, int index)
	{
		BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
		
		return barRenderer.getSeriesPaint(index);
	}
	
	/**
	 * Sets the section paint.
	 * @param categoryPlot the instance of CategoryPlot
	 * @param is3D the boolean value of is3D
	 */
	public static void setSectionPaint(CategoryPlot categoryPlot, boolean is3D)
	{	
		for (int i = 0; i < categoryPlot.getDataset().getRowCount(); i++)
		{
			setSectionPaint(categoryPlot, is3D, i, i);
		}	
	}
	
	/**
	 * Sets the section paint.
	 * @param categoryPlot the instance of CategoryPlot
	 * @param is3D the boolean value of is3D
	 * @param seriesIndex the series index value
	 * @param colorIndex the color index value
	 */
	public static void setSectionPaint(CategoryPlot categoryPlot, boolean is3D, int seriesIndex, int colorIndex)
	{				
		Paint paint = null;
		if (is3D)
		{	
			paint = JChartFactory.getPaint(colorIndex);
		}
		else
		{
			paint = JChartFactory.getGradientPaint(colorIndex);
		}
		setSectionPaint(categoryPlot, seriesIndex, paint);
	}
	
	/**
	 * Sets the section paint. 
	 * @param categoryPlot the instance of CategoryPlot
	 * @param index the index value
	 * @param paint the instance of Paint
	 */
	public static void setSectionPaint(CategoryPlot categoryPlot, int index, Paint paint)
	{
		BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
		barRenderer.setSeriesPaint(index, paint);
	}
	
	/**
	 * Sets the section paint. 
	 * @param categoryPlot the instance of CategoryPlot
	 * @param index the index value
	 * @param color1 the instance of Color
	 * @param color2 the instance of Color
	 */
	public static void setSectionPaint(CategoryPlot categoryPlot, int index, Color color1, Color color2)
	{
		BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
		barRenderer.setSeriesPaint(index, new GradientPaint(0.0F, 0.0F, color1, 0.0F, 0.0F, color2));
	}
	
	/**
	 * Sets the value marker.
	 * @param categoryPlot the instance of CategoryPlot 
	 * @param category the instance of Comparable
	 * @param text the text string
	 * @param value the value
	 */
	public static void setValueMarker(CategoryPlot categoryPlot, Comparable category, String text, double value)
	{
		setValueMarker(categoryPlot, category, text, value, new Color(221, 221, 221));
	}
	
	/**
	 * Sets the value marker.
	 * @param categoryPlot the instance of CategoryPlot 
	 * @param category the instance of Comparable
	 * @param text the text string
	 * @param value the value
	 * @param paint the instance of Paint
	 */
	public static void setValueMarker(CategoryPlot categoryPlot, Comparable category, String text, double value, Paint paint)
	{
		setValueMarker(categoryPlot, category, text, value, paint, Color.gray);
	}
	
	/**
	 * Sets the value marker.
	 * @param categoryPlot the instance of CategoryPlot 
	 * @param category the instance of Comparable
	 * @param text the text string
	 * @param value the value
	 * @param paint the instance of Paint
	 * @param outlinePaint the instance of Paint
	 */
	public static void setValueMarker(CategoryPlot categoryPlot, Comparable category, String text, double value, Paint paint, Paint outlinePaint)
	{
		ValueMarker valueMarker = new ValueMarker(value, paint, new BasicStroke(1.0F), outlinePaint, new BasicStroke(1.0F), 0.75F);
		categoryPlot.addRangeMarker(valueMarker, Layer.BACKGROUND);
		
		CategoryTextAnnotation categoryTextAnnotation = new CategoryTextAnnotation(text, category, value + 0.01D);
		categoryTextAnnotation.setCategoryAnchor(CategoryAnchor.START);
		categoryTextAnnotation.setFont(FontContext.getChartLabelFont());
		categoryTextAnnotation.setTextAnchor(TextAnchor.BOTTOM_LEFT);
		categoryPlot.addAnnotation(categoryTextAnnotation);
	}
	
	/**
	 * Gets the category plot selection index array.
	 * @param chartPanel the instance of JChartPanel
	 * @return the category plot selection index array 
	 */
	public static int[] getCategoryPlotSelectionIndexes(JChartPanel chartPanel)
	{
		JFreeChart chart = chartPanel.getChart();	
	
		return getCategoryPlotSelectionIndexes(chart);
	}
	
	/**
	 * Gets the category plot selection index array.
	 * @param chart the instance of JFreeChart
	 * @return the category plot selection index array
	 */
	public static int[] getCategoryPlotSelectionIndexes(JFreeChart chart)
	{
		CategoryItemRenderer itemRenderer = chart.getCategoryPlot().getRenderer();
		
		if (itemRenderer instanceof IBarRenderer)
		{
			IBarRenderer chartRenderer = (IBarRenderer) itemRenderer;
			
			int selectionRow = chartRenderer.getSelectionRow();
			int selectionColumn = chartRenderer.getSelectionColumn();
			
			return new int[] {selectionRow, selectionColumn};
		}	
		
		return null;
	}	
}