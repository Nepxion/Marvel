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
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ArrowIcon
	implements Icon, SwingConstants
{
	/**
	 * The shadow color.
	 */
	private Color shadow = UIManager.getColor("controlShadow");
	
	/**
	 * The dark shadow color.
	 */
	private Color darkShadow = Color.black;
	
	/**
	 * The size value.
	 */
	private int size;
	
	/**
	 * The direction value.
	 */
	private int direction;
	
	/**
	 * Constructs with the specified initial size and direction.
	 * @param size the size value
	 * @param direction the direction value
	 */
	public ArrowIcon(int size, int direction)
	{
		this.size = size;
		this.direction = direction;
	}
	
	/**
	 * Gets the icon width.
	 * @return the icon width value.
	 */
	public int getIconWidth()
	{
		return size;
	}
	
	/**
	 * Gets the icon height.
	 * @return the icon height value.
	 */
	public int getIconHeight()
	{
		return size;
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
		boolean isEnabled = c.isEnabled();
		Color oldColor = g.getColor();
		int mid, i, j;
		
		j = 0;
		size = Math.max(size, 2);
		mid = (size / 2) - 1;
		
		g.translate(x, y);
		if (isEnabled)
		{
			g.setColor(darkShadow);
		}
		else
		{
			g.setColor(shadow);
		}
		
		switch (direction)
		{
			case NORTH :
				for (i = 0; i < size; i++)
				{
					g.drawLine(mid - i, i, mid + i, i);
				}
				break;
			case SOUTH :
				j = 0;
				for (i = size - 1; i >= 0; i--)
				{
					g.drawLine(mid - i, j, mid + i, j);
					j++;
				}
				break;
			case WEST :
				for (i = 0; i < size; i++)
				{
					g.drawLine(i, mid - i, i, mid + i);
				}
				break;
			case EAST :
				j = 0;
				for (i = size - 1; i >= 0; i--)
				{
					g.drawLine(j, mid - i, j, mid + i);
					j++;
				}
				break;
		}
		g.translate(-x, -y);
		g.setColor(oldColor);
	}
}