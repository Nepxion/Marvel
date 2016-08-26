package com.nepxion.swing.border;

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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.border.Border;

public class BalloonBorder
	implements Border
{
	/**
	 * The last component size value.
	 */
	private Dimension lastComponentSize;
	
	/**
	 * The instance of Insets.
	 */
	private Insets insets = new Insets(0, 0, 0, 0);
	
	/**
	 * The fill color.
	 */
	private Color fillColor;
	
	/**
	 * the offset value.
	 */
	private int offset;

	/**
	 * Constructs with the specified initial fill color and offset.
	 * @param fillColor the fill color which is used to fill the balloon (currently only the triangular tip)
	 * @param offset the offset which is number of pixels between component and balloon body
	 */
	public BalloonBorder(Color fillColor, int offset)
	{
		this.fillColor = fillColor;
		this.offset = offset;
	}
	
	/**
	 * Gets the border insets.
	 * @param c the instance of Component
	 * @return the instance of Insets
	 */
	public Insets getBorderInsets(Component c)
	{
		Dimension currentComponent = c.getSize();
		
		if (currentComponent.equals(lastComponentSize))
		{
			return insets;
		}
		
		insets = new Insets(1, 1, offset + 1, 1);
		lastComponentSize = currentComponent;
		
		return insets;
	}
	
	/**
	 * Returns true if the border is opaque.
	 */
	public boolean isBorderOpaque()
	{
		return true;
	}
	
	/**
	 * Paints the border.
	 * @param c the instance of Component
	 * @param g the instance of Graphics
	 * @param x the x value
	 * @param y the y value
	 * @param width the width value
	 * @param height the height value
	 */
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
	{
		width -= insets.left + insets.right;
		height -= insets.top + insets.bottom;
		
		Point startPoint = new Point();
		Point endPoint = new Point();
		
		startPoint.x = x;
		startPoint.y = y;
		endPoint.x = x + width + 1;
		endPoint.y = y;
		g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		
		startPoint.setLocation(endPoint);
		endPoint.x = x + width + 1;
		endPoint.y = y + height + 1;
		g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		
		startPoint.setLocation(endPoint);
		endPoint.x = x + offset * 2;
		endPoint.y = y + height + 1;
		g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		
		startPoint.setLocation(endPoint);
		endPoint.x = x + offset;
		endPoint.y = y + height + offset + 1;
		g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		
		startPoint.setLocation(endPoint);
		endPoint.x = x + offset;
		endPoint.y = y + height + 1;
		g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		
		startPoint.setLocation(endPoint);
		endPoint.x = x;
		endPoint.y = y + height + 1;
		g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		
		startPoint.setLocation(endPoint);
		endPoint.x = x;
		endPoint.y = y;
		g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		
		int[] xPoints = {x + offset + 1, x + offset * 2 /*-1?*/, x + offset + 1};
		int[] yPoints = {y + height + 1, y + height + 1, y + height + offset /*-1?*/};
		g.setColor(fillColor);
		g.fillPolygon(xPoints, yPoints, 3);
	}
}