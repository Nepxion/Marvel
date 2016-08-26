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

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleEdge;

public class CylinderBarRenderer3D
	extends RectangleBarRenderer3D
{
	/**
	 * Constructs with the default.
	 */
	public CylinderBarRenderer3D()
	{
	}
	
	/**
	 * Constructs with the specified initial x offset and y offset.
	 * @param xOffset the x offset value
	 * @param yOffset the y offset value
	 */
	public CylinderBarRenderer3D(double xOffset, double yOffset)
	{
		super(xOffset, yOffset);
	}
	
	/**
	 * Draws the item for the chart.
	 * @param graphics2D the instance of Graphics2D
	 * @param categoryItemRendererState the instance of CategoryItemRendererState
	 * @param rectangle2D the instance of Rectangle2D
	 * @param categoryPlot the instance of CategoryPlot
	 * @param categoryAxis the instance of CategoryAxis
	 * @param valueAxis the instance of ValueAxis
	 * @param categoryDataset the instance of CategoryDataset
	 * @param i the i value
	 * @param j the j value
	 * @param k the k value
	 */
	public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int i, int j, int k)
	{
		Number number = categoryDataset.getValue(i, j);
		if (number == null)
		{
			return;
		}
		
		double d = number.doubleValue();
		Rectangle2D.Double double1 = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY() + getYOffset(), rectangle2D.getWidth() - getXOffset(), rectangle2D.getHeight() - getYOffset());
		PlotOrientation plotOrientation = categoryPlot.getOrientation();
		double d1 = calculateBarW0(categoryPlot, plotOrientation, double1, categoryAxis, categoryItemRendererState, i, j);
		double ad[] = calculateBarL0L1(d);
		if (ad == null)
		{
			return;
		}
		
		RectangleEdge rectangleEdge = categoryPlot.getRangeAxisEdge();
		float f = (float) valueAxis.valueToJava2D(ad[0], double1, rectangleEdge);
		float f1 = (float) valueAxis.valueToJava2D(ad[1], double1, rectangleEdge);
		float f2 = Math.min(f, f1);
		float f3 = Math.abs(f1 - f);
		GeneralPath generalPath = new GeneralPath();
		Ellipse2D.Double double2 = null;
		if (plotOrientation == PlotOrientation.HORIZONTAL)
		{
			generalPath.moveTo((float) ((double) f2 + getXOffset() / 2D), (float) d1);
			generalPath.lineTo((float) ((double) (f2 + f3) + getXOffset() / 2D), (float) d1);
			Arc2D.Double double3 = new Arc2D.Double(f2 + f3, d1, getXOffset(), categoryItemRendererState.getBarWidth(), 90D, 180D, 0);
			generalPath.append(double3, true);
			generalPath.lineTo((float) ((double) f2 + getXOffset() / 2D), (float) (d1 + categoryItemRendererState.getBarWidth()));
			double3 = new Arc2D.Double(f2, d1, getXOffset(), categoryItemRendererState.getBarWidth(), 270D, -180D, 0);
			generalPath.append(double3, true);
			generalPath.closePath();
			double2 = new Ellipse2D.Double(f2 + f3, d1, getXOffset(), categoryItemRendererState.getBarWidth());
		}
		else
		{
			generalPath.moveTo((float) d1, (float) ((double) f2 - getYOffset() / 2D));
			generalPath.lineTo((float) d1, (float) ((double) (f2 + f3) - getYOffset() / 2D));
			Arc2D.Double double4 = new Arc2D.Double(d1, (double) (f2 + f3) - getYOffset(), categoryItemRendererState.getBarWidth(), getYOffset(), 180D, 180D, 0);
			generalPath.append(double4, true);
			generalPath.lineTo((float) (d1 + categoryItemRendererState.getBarWidth()), (float) ((double) f2 - getYOffset() / 2D));
			double4 = new Arc2D.Double(d1, (double) f2 - getYOffset(), categoryItemRendererState.getBarWidth(), getYOffset(), 0.0D, -180D, 0);
			generalPath.append(double4, true);
			generalPath.closePath();
			double2 = new Ellipse2D.Double(d1, (double) f2 - getYOffset(), categoryItemRendererState.getBarWidth(), getYOffset());
		}
		Object itemPaint = getItemPaint(i, j);
		if (getGradientPaintTransformer() != null && (itemPaint instanceof GradientPaint))
		{
			GradientPaint gradientpaint = (GradientPaint) itemPaint;
			itemPaint = getGradientPaintTransformer().transform(gradientpaint, generalPath);
		}
		graphics2D.setPaint((Paint) itemPaint);
		graphics2D.fill(generalPath);
		if (itemPaint instanceof GradientPaint)
		{
			graphics2D.setPaint(((GradientPaint) itemPaint).getColor2());
		}
		if (double2 != null)
		{
			graphics2D.fill(double2);
		}
		if (isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3D)
		{
			graphics2D.setStroke(getItemOutlineStroke(i, j));
			graphics2D.setPaint(getItemOutlinePaint(i, j));
			graphics2D.draw(generalPath);
			if (double2 != null)
			{
				graphics2D.draw(double2);
			}
		}
		CategoryItemLabelGenerator categoryItemLabelGenerator = getItemLabelGenerator(i, j);
		if (categoryItemLabelGenerator != null && isItemLabelVisible(i, j))
		{
			drawItemLabel(graphics2D, categoryDataset, i, j, categoryPlot, categoryItemLabelGenerator, generalPath.getBounds2D(), d < 0.0D);
		}
		if (categoryItemRendererState.getInfo() != null)
		{
			EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
			if (entityCollection != null)
			{
				String toolTip = null;
				CategoryToolTipGenerator categoryToolTipGenerator = getToolTipGenerator(i, j);
				if (categoryToolTipGenerator != null)
				{
					toolTip = categoryToolTipGenerator.generateToolTip(categoryDataset, i, j);
				}
				String url = null;
				if (getItemURLGenerator(i, j) != null)
				{
					url = getItemURLGenerator(i, j).generateURL(categoryDataset, i, j);
				}
				CategoryItemEntity categoryItemEntity = new CategoryItemEntity(generalPath.getBounds2D(), toolTip, url, categoryDataset, categoryDataset.getRowKey(i), categoryDataset.getColumnKey(j));
				entityCollection.add(categoryItemEntity);
			}
		}
	}
}