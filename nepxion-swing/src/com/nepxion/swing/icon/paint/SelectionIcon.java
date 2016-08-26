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

public class SelectionIcon
	implements Icon
{
	/**
	 * The boolean value of selected.
	 */
	private boolean selected;
	
	/**
	 * Constructs with the specified initial selected.
	 * @param selected the boolean value of selected
	 */
	public SelectionIcon(boolean selected)
	{
		this.selected = selected;
	}
	
	/**
	 * Gets the icon width.
	 * @return the icon width value.
	 */
	public int getIconWidth()
	{
		return 15;
	}
	
	/**
	 * Gets the icon height.
	 * @return the icon height value.
	 */
	public int getIconHeight()
	{
		return 15;
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
		if (!selected)
		{
			return;
		}
		
		g.setColor(Color.black);
		
		g.drawLine(x + 4, y + 6, x + 4, y + 8);
		g.drawLine(x + 5, y + 7, x + 5, y + 9);
		g.drawLine(x + 6, y + 8, x + 6, y + 10);
		g.drawLine(x + 7, y + 7, x + 7, y + 9);
		g.drawLine(x + 8, y + 6, x + 8, y + 8);
		g.drawLine(x + 9, y + 5, x + 9, y + 7);
		g.drawLine(x + 10, y + 4, x + 10, y + 6);
	}
}