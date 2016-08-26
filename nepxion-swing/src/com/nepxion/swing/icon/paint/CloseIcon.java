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
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.UIManager;

public class CloseIcon
	implements Icon
{
	/**
	 * The instance of Rectangle.
	 */
	private Rectangle rectangle = new Rectangle(0, 0, 15, 15);
	
	/**
	 * The boolean value of isPressed.
	 */
	private boolean isPressed = false;
	
	/**
	 * The boolean value of isDrawBorder.
	 */
	private boolean isDrawBorder = true;
	
	/**
	 * The boolean value of isDrawCenter.
	 */
	private boolean isDrawCenter = true;
	
	/**
	 * Constructs with the default.
	 */
	public CloseIcon()
	{
		this(true, true);
	}
	
	/**
	 * Constructs with the specified initial isDrawBorder and isDrawCenter.
	 * @param isDrawBorder the boolean value of isDrawBorder
	 * @param isDrawCenter the boolean value of isDrawCenter
	 */
	public CloseIcon(boolean isDrawBorder, boolean isDrawCenter)
	{
		this.isDrawBorder = isDrawBorder;
		this.isDrawCenter = isDrawCenter;
	}
	
	/**
	 * Gets the bounds.
	 * @return the instance of Rectangle
	 */
	public Rectangle getBounds()
	{
		return rectangle;
	}
	
	/**
	 * Sets the bounds.
	 * @param rectangle the instance of Rectangle
	 */
	public void setBounds(Rectangle rectangle)
	{
		this.rectangle = rectangle;
	}
		
	/**
	 * Returns true if pressed.
	 * @return true if pressed
	 */
	public boolean isPressed()
	{
		return isPressed;
	}
	
	/**
	 * Sets the pressed. 
	 * @param isPressed the boolean value of isPressed
	 */
	public void setPressed(boolean isPressed)
	{
		this.isPressed = isPressed;
	}
	
	/**
	 * Returns true if drawing border.
	 * @return the boolean value of isDrawBorder
	 */
	public boolean isDrawBorder()
	{
		return isDrawBorder;
	}
	
	/**
	 * Sets the drawing border.
	 * @param isDrawBorder the boolean value of isDrawBorder
	 */
	public void setDrawBorder(boolean isDrawBorder)
	{
		this.isDrawBorder = isDrawBorder;
	}
	
	/**
	 * Returns true if drawing center.
	 * @return the boolean value of isDrawCenter
	 */
	public boolean isDrawCenter()
	{
		return isDrawCenter;
	}
	
	/**
	 * Sets the drawing center.
	 * @param isDrawCenter the boolean value of isDrawCenter
	 */
	public void setDrawCenter(boolean isDrawCenter)
	{
		this.isDrawCenter = isDrawCenter;
	}
	
	/**
	 * Gets the icon width.
	 * @return the icon width value.
	 */
	public int getIconWidth()
	{
		return rectangle.width;
	}
	
	/**
	 * Gets the icon height.
	 * @return the icon height value.
	 */
	public int getIconHeight()
	{
		return rectangle.height;
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
		rectangle.x = x;
		rectangle.y = y;
		Color color = g.getColor();
		
		// draw border
		if (isDrawBorder)
		{
			if (isPressed)
			{
				// g.setColor(UIManager.getColor("TabbedPane.shadow"));
				g.setColor(new Color(148, 145, 140));
				g.drawLine(x, y, x, y + rectangle.height);
				g.drawLine(x, y, x + rectangle.width, y);
				
				// g.setColor(UIManager.getColor("TabbedPane.highlight"));
				g.setColor(Color.white);
				g.drawLine(x, y + rectangle.height, x + rectangle.width, y + rectangle.height);
				g.drawLine(x + rectangle.width, y, x + rectangle.width, y + rectangle.height);
			}
			else
			{
				// g.setColor(UIManager.getColor("TabbedPane.highlight"));
				g.setColor(Color.white);
				g.drawLine(x, y, x, y + rectangle.height);
				g.drawLine(x, y, x + rectangle.width, y);
				
				// g.setColor(UIManager.getColor("TabbedPane.shadow"));
				g.setColor(new Color(148, 145, 140));
				g.drawLine(x, y + rectangle.height, x + rectangle.width, y + rectangle.height);
				g.drawLine(x + rectangle.width, y, x + rectangle.width, y + rectangle.height);
			}
		}
		
		g.setColor(UIManager.getColor("TabbedPane.foreground"));
		// draw X
		// left top
		g.drawRect(x + 4, y + 4, 1, 1);
		g.drawRect(x + 5, y + 5, 1, 1);
		g.drawRect(x + 5, y + 9, 1, 1);
		g.drawRect(x + 4, y + 10, 1, 1);
		// center
		if (isDrawCenter)
		{
			g.drawRect(x + 6, y + 6, 1, 1);
			g.drawRect(x + 8, y + 6, 1, 1);
			g.drawRect(x + 6, y + 8, 1, 1);
			g.drawRect(x + 8, y + 8, 1, 1);
		}
		// right top
		g.drawRect(x + 10, y + 4, 1, 1);
		g.drawRect(x + 9, y + 5, 1, 1);
		// right bottom
		g.drawRect(x + 9, y + 9, 1, 1);
		g.drawRect(x + 10, y + 10, 1, 1);
		g.setColor(color);
	}
}