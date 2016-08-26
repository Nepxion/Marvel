package com.nepxion.swing.icon.paint;

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

import javax.swing.Icon;

public class GeoCellIcon
	implements Icon
{
	/**
	 * The shape of point.
	 */
	public static final int SHAPE_POINT = 0;
	
	/**
	 * The shape of line.
	 */
	public static final int SHAPE_LINE = 1;
	
	/**
	 * The shape of polygon.
	 */
	public static final int SHAPE_POLYGON = 2;
	
	/**
	 * The shape value.
	 */
	private int shape;
	
	/**
	 * The shape icon.
	 */
	private Color color;
	
	/**
	 * Constructs with the specified initial shape and color.
	 * @param shape the shape value
	 * @param color the shape icon
	 */
	public GeoCellIcon(int shape, Color color)
	{
		this.shape = shape;
		this.color = color;
	}
	
	/**
	 * Paints the point.
	 * @param c the instance of Component
	 * @param g the instance of Graphics
	 */
	private void paintPoint(Component c, Graphics g)
	{
		Dimension size = c.getSize();
		int x = (int) size.getWidth() / 2;
		int y = (int) size.getHeight() / 2;
		g.setColor(color);
		g.fillRect(x - 2, y - 2, 4, 4);
		
		g.setColor(Color.black);
		g.drawLine(x - 2, y - 2, x + 2, y - 2);
		g.drawLine(x - 2, y + 2, x + 2, y + 2);
		g.drawLine(x - 2, y - 2, x - 2, y + 2);
		g.drawLine(x + 2, y - 2, x + 2, y + 2);
	}
	
	/**
	 * Paints the line.
	 * @param c the instance of Component
	 * @param g the instance of Graphics
	 */
	private void paintLine(Component c, Graphics g)
	{
		Dimension size = c.getSize();
		int x = (int) size.getWidth() / 2;
		int y = (int) size.getHeight() / 2;
		g.setColor(color);
		
		g.drawLine(x - 2, y - 2, x + 1, y + 1);
		g.drawLine(x - 2, y - 2, x - 5, y + 5);
		g.drawLine(x + 1, y + 1, x + 4, y - 6);
	}
	
	/**
	 * Paints the polygon.
	 * @param c the instance of Component
	 * @param g the instance of Graphics
	 */
	private void paintPolygon(Component c, Graphics g)
	{
		Dimension size = c.getSize();
		int x = (int) size.getWidth() / 2;
		int y = (int) size.getHeight() / 2;
		g.setColor(color);
		g.fillRect(x - 5, y - 5, 10, 10);
		
		g.setColor(Color.black);
		g.drawLine(x - 5, y - 5, x + 5, y - 5);
		g.drawLine(x - 5, y + 5, x + 5, y + 5);
		g.drawLine(x - 5, y - 5, x - 5, y + 5);
		g.drawLine(x + 5, y - 5, x + 5, y + 5);
	}
	
	/**
	 * Gets the icon width.
	 * @return the icon width value.
	 */
	public int getIconWidth()
	{
		switch (shape)
		{
			case SHAPE_POINT :
				return 4;
			case SHAPE_LINE :
				return 10;
			case SHAPE_POLYGON :
				return 10;
		}
		
		return 0;
	}
	
	/**
	 * Gets the icon height.
	 * @return the icon height value.
	 */
	public int getIconHeight()
	{
		switch (shape)
		{
			case SHAPE_POINT :
				return 4;
			case SHAPE_LINE :
				return 10;
			case SHAPE_POLYGON :
				return 10;
		}
		
		return 0;
	}
	
	/**
	 * Paints the icon.
	 * @param c the instance of Component
	 * @param g the instance of Graphics
	 * @param x the x value
	 * @param y the y value
	 */
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		switch (shape)
		{
			case SHAPE_POINT :
				paintPoint(c, g);
				break;
			case SHAPE_LINE :
				paintLine(c, g);
				break;
			case SHAPE_POLYGON :
				paintPolygon(c, g);
				break;
		}
	}
}