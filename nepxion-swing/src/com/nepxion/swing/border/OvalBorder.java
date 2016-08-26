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
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class OvalBorder
	implements Border
{
	/**
	 * The width value.
	 */
	private int width = 6;
	
	/**
	 * The height value.
	 */
	private int height = 6;
	
	/**
	 * The top color.
	 */
	private Color topColor = Color.white;
	
	/**
	 * The bottom color.
	 */
	private Color bottomColor = Color.gray;
	
	/**
	 * Constructs with the default.
	 */
	public OvalBorder()
	{
		this.width = 6;
		this.height = 6;
	}
	
	/**
	 * Constructs with the specified initial width and height.
	 * @param width the width value
	 * @param height the height value
	 */
	public OvalBorder(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Constructs with the specified initial width, height, top color and bottom color.
	 * @param width the width value
	 * @param height the height value
	 * @param topColor the top color
	 * @param bottomColor the bottom color
	 */
	public OvalBorder(int width, int height, Color topColor, Color bottomColor)
	{
		this.width = width;
		this.height = height;
		this.topColor = topColor;
		this.bottomColor = bottomColor;
	}
	
	/**
	 * Gets the border insets.
	 * @param c the instance of Component
	 * @return the instance of Insets
	 */
	public Insets getBorderInsets(Component c)
	{
		return new Insets(height, width, height, width);
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
	public void paintBorder(Component c, Graphics g, int x, int y, int w, int h)
	{
		w--;
		h--;
		
		g.setColor(topColor);
		g.drawLine(x, y + h - height, x, y + height);
		g.drawArc(x, y, 2 * width, 2 * height, 180, -90);
		g.drawLine(x + width, y, x + w - width, y);
		g.drawArc(x + w - 2 * width, y, 2 * width, 2 * height, 90, -90);
		
		g.setColor(bottomColor);
		g.drawLine(x + w, y + height, x + w, y + h - height);
		g.drawArc(x + w - 2 * width, y + h - 2 * height, 2 * width, 2 * height, 0, -90);
		g.drawLine(x + width, y + h, x + w - width, y + h);
		g.drawArc(x, y + h - 2 * height, 2 * width, 2 * height, -90, -90);
	}
}