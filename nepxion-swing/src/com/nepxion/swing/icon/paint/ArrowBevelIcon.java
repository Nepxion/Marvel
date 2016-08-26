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

public class ArrowBevelIcon
	implements Icon, SwingConstants
{	
	/**
	 * The default size.
	 */
	private static final int DEFAULT_SIZE = 11;
	
	/**
	 * The first edge color.
	 */
	private Color edgeColor1;
	
	/**
	 * The second edge color.
	 */
	private Color edgeColor2;
	
	/**
	 * The fill color.
	 */
	private Color fillColor;
	
	/**
	 * The size value.
	 */
	private int size;
	
	/**
	 * The direction value.
	 */
	private int direction;
	
	/**
	 * Constructs with the specified initial direction, isRaisedView and isPressedView.
	 * @param direction the direction value
	 * @param isRaisedView the boolean value of isRaisedView
	 * @param isPressedView the boolean value of isPressedView
	 */
	public ArrowBevelIcon(int direction, boolean isRaisedView, boolean isPressedView)
	{
		// initialize(UIManager.getColor("controlDkShadow"), UIManager.getColor("controlLtHighlight"), UIManager.getColor("controlShadow"), DEFAULT_SIZE, direction);
		
		if (isRaisedView)
		{
			if (isPressedView)
			{
				initialize(UIManager.getColor("controlLtHighlight"), UIManager.getColor("controlDkShadow"), UIManager.getColor("controlShadow"), DEFAULT_SIZE, direction);
			}
			else
			{
				initialize(UIManager.getColor("controlHighlight"), UIManager.getColor("controlShadow"), UIManager.getColor("control"), DEFAULT_SIZE, direction);
			}
		}
		else
		{
			if (isPressedView)
			{
				initialize(UIManager.getColor("controlDkShadow"), UIManager.getColor("controlLtHighlight"), UIManager.getColor("controlShadow"), DEFAULT_SIZE, direction);
			}
			else
			{
				initialize(UIManager.getColor("controlShadow"), UIManager.getColor("controlHighlight"), UIManager.getColor("control"), DEFAULT_SIZE, direction);
			}
		}
	}
	
	/**
	 * Constructs with the specified initial first edge color, second edge color, fill color, size and direction.
	 * @param edgeColor1 the first edge color
	 * @param edgeColor2 the second edge color
	 * @param fillColor the fill color
	 * @param size the size value
	 * @param direction the direction value
	 */
	public ArrowBevelIcon(Color edgeColor1, Color edgeColor2, Color fillColor, int size, int direction)
	{
		initialize(edgeColor1, edgeColor2, fillColor, size, direction);
	}
	
	/**
	 * 
	 * @param edgeColor1
	 * @param edgeColor2
	 * @param fillColor
	 * @param size
	 * @param direction
	 */
	private void initialize(Color edgeColor1, Color edgeColor2, Color fillColor, int size, int direction)
	{
		this.edgeColor1 = edgeColor1;
		this.edgeColor2 = edgeColor2;
		this.fillColor = fillColor;
		this.size = size;
		this.direction = direction;
	}
		
	/**
	 * Paints the up arrow.
	 * @param g the instance of Graphics
	 * @param i the i value.
	 * @param j the j value.
	 */
	private void paintUpArrow(Graphics g, int i, int j)
	{
		g.setColor(edgeColor1);
		int x = i + (size / 2);
		g.drawLine(x, j, x, j);
		x--;
		int y = j + 1;
		int dx = 0;
		while (y + 3 < j + size)
		{
			g.setColor(edgeColor1);
			g.drawLine(x, y, x + 1, y);
			g.drawLine(x, y + 1, x + 1, y + 1);
			if (0 < dx)
			{
				g.setColor(fillColor);
				g.drawLine(x + 2, y, x + 1 + dx, y);
				g.drawLine(x + 2, y + 1, x + 1 + dx, y + 1);
			}
			g.setColor(edgeColor2);
			g.drawLine(x + dx + 2, y, x + dx + 3, y);
			g.drawLine(x + dx + 2, y + 1, x + dx + 3, y + 1);
			x -= 1;
			y += 2;
			dx += 2;
		}
		g.setColor(edgeColor1);
		g.drawLine(i, j + size - 3, i + 1, j + size - 3);
		g.setColor(edgeColor2);
		g.drawLine(i + 2, j + size - 2, i + size - 1, j + size - 2);
		g.drawLine(i, j + size - 1, i + size, j + size - 1);
	}
	
	/**
	 * Paints the down arrow.
	 * @param g the instance of Graphics
	 * @param i the i value.
	 * @param j the j value.
	 */
	private void paintDownArrow(Graphics g, int i, int j)
	{
		g.setColor(edgeColor1);
		g.drawLine(i, j, i + size - 1, j);
		g.drawLine(i, j + 1, i + size - 3, j + 1);
		g.setColor(edgeColor2);
		g.drawLine(i + size - 2, j + 1, i + size - 1, j + 1);
		int x = i + 1;
		int y = j + 2;
		int dx = size - 6;
		while (y + 1 < j + size)
		{
			g.setColor(edgeColor1);
			g.drawLine(x, y, x + 1, y);
			g.drawLine(x, y + 1, x + 1, y + 1);
			if (0 < dx)
			{
				g.setColor(fillColor);
				g.drawLine(x + 2, y, x + 1 + dx, y);
				g.drawLine(x + 2, y + 1, x + 1 + dx, y + 1);
			}
			g.setColor(edgeColor2);
			g.drawLine(x + dx + 2, y, x + dx + 3, y);
			g.drawLine(x + dx + 2, y + 1, x + dx + 3, y + 1);
			x += 1;
			y += 2;
			dx -= 2;
		}
		g.setColor(edgeColor1);
		g.drawLine(i + (size / 2), j + size - 1, i + (size / 2), j + size - 1);
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
		switch (direction)
		{
			case NORTH :
				paintUpArrow(g, x, y);
				break;
			case SOUTH :
				paintDownArrow(g, x, y);
				break;
		}
	}
}