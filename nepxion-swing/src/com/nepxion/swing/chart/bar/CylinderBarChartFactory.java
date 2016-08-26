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

import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.ui.TextAnchor;

public class CylinderBarChartFactory
	extends RectangleBarChartFactory
{
	/**
	 * Creates the category plot 3D.
	 * @param categoryDataset the instance of CategoryDataset
	 * @param orientation the instance of PlotOrientation
	 * @param categoryAxisLabel the category axis label string
	 * @param valueAxisLabel the value axis label string
	 * @param toolTipText the tooltip text string
	 * @param legendToolTipText the legend tooltip text string
	 * @param isCategoryLabelRotated the boolean value of isCategoryLabelRotated
	 * @return the instance of CategoryPlot
	 */
	public static CategoryPlot createCategoryPlot3D(CategoryDataset categoryDataset, PlotOrientation orientation, String categoryAxisLabel, String valueAxisLabel, String toolTipText, String legendToolTipText, boolean isCategoryLabelRotated)
	{
		CategoryPlot categoryPlot = createCategoryPlot3D(categoryDataset, orientation, categoryAxisLabel, valueAxisLabel, true, true, false);
		
		setCategoryPlotPreference(categoryPlot, orientation, toolTipText, legendToolTipText, isCategoryLabelRotated, 0.75F);
		
		return categoryPlot;
	}
	
	/**
	 * Creates the category plot 3D.
	 * @param categoryDataset the instance of CategoryDataset
	 * @param orientation the instance of PlotOrientation
	 * @param categoryAxisLabel the category axis label string
	 * @param valueAxisLabel the value axis label string
	 * @param labels the boolean value of label shown
	 * @param tooltips the boolean value of tooltip shown
	 * @param urls the boolean value of url shown
	 * @return the instance of CategoryPlot
	 */
	public static CategoryPlot createCategoryPlot3D(CategoryDataset categoryDataset, PlotOrientation orientation, String categoryAxisLabel, String valueAxisLabel, boolean labels, boolean tooltips, boolean urls)
	{
		if (orientation == null)
		{
			throw new IllegalArgumentException("Null 'orientation' argument.");
		}
		CategoryAxis categoryAxis = new CategoryAxis3D(categoryAxisLabel);
		ValueAxis valueAxis = new NumberAxis3D(valueAxisLabel);
		
		BarRenderer3D cylinderBarRenderer3D = new CylinderBarRenderer3D();
		if (orientation == PlotOrientation.HORIZONTAL)
		{
			cylinderBarRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.CENTER));
			cylinderBarRenderer3D.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE9, TextAnchor.CENTER_LEFT));
			cylinderBarRenderer3D.setItemLabelAnchorOffset(20D);
		}
		else if (orientation == PlotOrientation.VERTICAL)
		{
			cylinderBarRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
			cylinderBarRenderer3D.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER));
			cylinderBarRenderer3D.setItemLabelAnchorOffset(5D);
		}
		
		if (labels)
		{
			cylinderBarRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		}
		if (tooltips)
		{
			cylinderBarRenderer3D.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
		}
		if (urls)
		{
			cylinderBarRenderer3D.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
		}
		cylinderBarRenderer3D.setGradientPaintTransformer(new StandardGradientPaintTransformer(orientation == PlotOrientation.VERTICAL ? GradientPaintTransformType.CENTER_HORIZONTAL : GradientPaintTransformType.CENTER_VERTICAL));
		
		CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, valueAxis, cylinderBarRenderer3D);
		categoryPlot.setOrientation(orientation);
		
		return categoryPlot;
	}
}