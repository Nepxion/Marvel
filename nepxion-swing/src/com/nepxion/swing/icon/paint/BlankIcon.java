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

public class BlankIcon
	implements Icon
{
	/**
	 * The instance of Color.
	 */
	private Color color;
	
	/**
	 * The width value.
	 */
	private int width = 16;
	
	/**
	 * The height value.
	 */
	private int height = 16;
	
	/**
	 * Constructs with the default.
	 */
	public BlankIcon()
	{
		this(null);
	}
	
	/**
	 * Constructs with the specified initial color.
	 * @param color the instance of Color
	 */
	public BlankIcon(Color color)
	{
		this(color, 16, 16);
	}
	
	/**
	 * Constructs with the specified initial width and height.
	 * @param width the width value
	 * @param height the height value
	 */
	public BlankIcon(int width, int height)
	{
		this(null, width, height);
	}
	
	/**
	 * Constructs with the specified initial color, width and height.
	 * @param color the instance of Color
	 * @param width the width value
	 * @param height the height value
	 */
	public BlankIcon(Color color, int width, int height)
	{
		this.color = color;
		this.width = width;
		this.height = height;
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
		if (color != null)
		{
			g.setColor(color);
			g.drawRect(x, y, width - 1, height - 1);
		}
	}
}