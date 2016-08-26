package com.nepxion.swing.gradient;

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
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;

import com.jidesoft.swing.JideSwingUtilities;

public class JGradientPainter
{
	/**
	 * Fast gradient fills for the graphics 2D.
	 * It is recommended to gradient paint
	 * @param g2d the instance of Graphics2D
	 * @param shape the instance of Shape
	 * @param startColor the start color
	 * @param endColor the end color
	 * @param isVertical the boolean value of isVertical
	 */
	public static void fastFill(Graphics2D g2d, Shape shape, Color startColor, Color endColor, boolean isVertical)
	{
		JideSwingUtilities.fillGradient(g2d, shape, startColor, endColor, isVertical);
	}
	
	/**
	 * Fills gradient for the graphics 2D.
	 * @param g2d the instance of Graphics2D
	 * @param shape the instance of Shape
	 * @param startColor the start color
	 * @param endColor the end color
	 * @param isVertical the boolean value of isVertical
	 */
	public static void fill(Graphics2D g2d, Shape shape, Color startColor, Color endColor, boolean isVertical)
	{
		Rectangle rect = shape.getBounds();
		GradientPaint paint = null;
		if (isVertical)
		{
			paint = new GradientPaint(rect.x, rect.y, startColor, rect.x, rect.y + rect.height, endColor, true); // turn cyclic to true will be faster
		}
		else
		{
			paint = new GradientPaint(rect.x, rect.y, startColor, rect.x + rect.width, rect.y, endColor, true); // turn cyclic to true will be faster
		}		
		Paint oldPaint = g2d.getPaint();
		g2d.setPaint(paint);
		g2d.fill(shape);
		g2d.setPaint(oldPaint);
	}
}