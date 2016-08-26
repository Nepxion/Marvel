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
import java.awt.Graphics;

import javax.swing.Icon;

public class ColorIcon
	implements Icon
{
	/**
	 * The fill color.
	 */
	private Color fillColor;
	
	/**
	 * The border color.
	 */
	private Color borderColor;
	
	/**
	 * The width value.
	 */
	private int width;
	
	/**
	 * The height value.
	 */
	private int height;
	
	/**
	 * Constructs with the specified initial fill color, width and height.
	 * @param fillColor the fill color
	 * @param width the width value
	 * @param height the height value
	 */
	public ColorIcon(Color fillColor, int width, int height)
	{
		this(fillColor, Color.gray, width, height);
	}
	
	/**
	 * Constructs with the specified initial fill color, border color, width and height.
	 * @param fillColor the fill color
	 * @param borderColor the border color
	 * @param width the width value
	 * @param height the height value
	 */
	public ColorIcon(Color fillColor, Color borderColor, int width, int height)
	{
		this.fillColor = fillColor;
		this.borderColor = borderColor;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Gets the fill color.
	 * @return the instance of Color
	 */
	public Color getFillColor()
	{
		return fillColor;
	}
	
	/**
	 * Sets the fill color.
	 * @param fillColor the instance of Color
	 */
	public void setFillColor(Color fillColor)
	{
		this.fillColor = fillColor;
	}
	
	/**
	 * Gets the border color.
	 * @return the instance of Color
	 */
	public Color getBorderColor()
	{
		return borderColor;
	}
	
	/**
	 * Sets the border color.
	 * @param borderColor the instance of Color
	 */
	public void setBorderColor(Color borderColor)
	{
		this.borderColor = borderColor;
	}
	
	/**
	 * Gets the icon width.
	 * @return the icon width value.
	 */
	public int getIconWidth()
	{
		return width;
	}
	
	/**
	 * Gets the icon height.
	 * @return the icon height value.
	 */
	public int getIconHeight()
	{
		return height;
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
		if (borderColor != null)
		{	
			g.setColor(borderColor);
			g.drawRect(x, y, width - 1, height - 1);
		}
		
		if (fillColor != null)
		{			
			g.setColor(fillColor);
			g.fillRect(x + 1, y + 1, width - 2, height - 2);
		}
	}
}