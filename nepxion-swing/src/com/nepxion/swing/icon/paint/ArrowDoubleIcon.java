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

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.SwingConstants;

public class ArrowDoubleIcon
	implements Icon, SwingConstants
{
	/**
	 * The first arrow icon.
	 */
	private ArrowIcon arrowIcon1;
	
	/**
	 * The second arrow icon.
	 */
	private ArrowIcon arrowIcon2;
	
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
	public ArrowDoubleIcon(int size, int direction)
	{
		this.size = size;
		
		arrowIcon1 = new ArrowIcon(size / 2, direction);
		arrowIcon2 = new ArrowIcon(size / 2, direction);
	}
	
	/**
	 * Gets the icon width.
	 * @return the icon width value.
	 */
	public int getIconWidth()
	{
		if (direction == NORTH || direction == SOUTH)
		{
			return size / 2;
		}
		else
		{
			return size;
		}
	}
	
	/**
	 * Gets the icon height.
	 * @return the icon height value.
	 */
	public int getIconHeight()
	{
		if (direction == NORTH || direction == SOUTH)
		{
			return size;
		}
		else
		{
			return size / 2;
		}
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
		if (arrowIcon1 != null)
		{
			arrowIcon1.paintIcon(c, g, x, y);
		}
		if (arrowIcon2 != null)
		{
			if (direction == NORTH || direction == SOUTH)
			{
				arrowIcon2.paintIcon(c, g, x, y + size / 2);
			}
			else
			{
				arrowIcon2.paintIcon(c, g, x + size / 2, y);
			}
		}
	}
}