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

import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;

public class LineBorder
	extends AbstractBorder implements SwingConstants
{
	/**
	 * The north thickness. 
	 */
	private int northThickness;
	
	/**
	 * The south thickness.
	 */
	private int southThickness;
	
	/**
	 * The east thickness.
	 */
	private int eastThickness;
	
	/**
	 * The west thickness.
	 */
	private int westThickness;
	
	/**
	 * The north color.
	 */
	private Color northColor;
	
	/**
	 * The south color.
	 */
	private Color southColor;
	
	/**
	 * The east color.
	 */
	private Color eastColor;
	
	/**
	 * The west color.
	 */
	private Color westColor;
	
	/**
	 * Constructs with the specified initial color.
	 * @param color the instance of Color
	 */
	public LineBorder(Color color)
	{
		this(color, 1);
	}
	
	/**
	 * Constructs with the specified initial color and thickness.
	 * @param color the instance of Color
	 * @param thickness the thickness value
	 */
	public LineBorder(Color color, int thickness)
	{
		setColor(color);
		setThickness(thickness);
	}
	
	/**
	 * Constructs with the specified initial color and insets.
	 * @param color the instance of Color
	 * @param insets the instance of Insets
	 */
	public LineBorder(Color color, Insets insets)
	{
		setColor(color);
		setThickness(insets);
	}
	
	/**
	 * Sets the color.
	 * @param color the instance of Color
	 */
	public void setColor(Color color)
	{
		northColor = color;
		southColor = color;
		eastColor = color;
		westColor = color;
	}
	
	/**
	 * Sets the color by a direction.
	 * @param color the instance of Color
	 * @param direction the direction value
	 */
	public void setColor(Color color, int direction)
	{
		switch (direction)
		{
			case NORTH :
				northColor = color;
				break;
			case SOUTH :
				southColor = color;
				break;
			case EAST :
				eastColor = color;
				break;
			case WEST :
				westColor = color;
				break;
			default :
		}
	}
	
	/**
	 * Sets the thickness.
	 * @param thickness the thickness value
	 */
	public void setThickness(int thickness)
	{
		northThickness = thickness;
		southThickness = thickness;
		eastThickness = thickness;
		westThickness = thickness;
	}
	
	/**
	 * Sets the thickness by a insets.
	 * @param insets the instance of Insets
	 */
	public void setThickness(Insets insets)
	{
		northThickness = insets.top;
		southThickness = insets.bottom;
		eastThickness = insets.right;
		westThickness = insets.left;
	}
	
	/**
	 * Sets the thickness by a direction.
	 * @param thickness the thickness value
	 * @param direction the direction value
	 */
	public void setThickness(int thickness, int direction)
	{
		switch (direction)
		{
			case NORTH :
				northThickness = thickness;
				break;
			case SOUTH :
				southThickness = thickness;
				break;
			case EAST :
				eastThickness = thickness;
				break;
			case WEST :
				westThickness = thickness;
				break;
			default :
		}
	}
	
	/**
	 * Appends by a border.
	 * @param border the instance of LineBorder
	 * @param replaced the boolean value of replaced
	 */
	public void append(LineBorder border, boolean replaced)
	{
		if (replaced)
		{
			northThickness = border.northThickness;
			southThickness = border.southThickness;
			eastThickness = border.eastThickness;
			westThickness = border.westThickness;
		}
		else
		{
			northThickness = Math.max(northThickness, border.northThickness);
			southThickness = Math.max(southThickness, border.southThickness);
			eastThickness = Math.max(eastThickness, border.eastThickness);
			westThickness = Math.max(westThickness, border.westThickness);
		}
	}
	
	/**
	 * Appends by a insets.
	 * @param insets the instance of Insets
	 * @param replaced the boolean value of replaced
	 */
	public void append(Insets insets, boolean replaced)
	{
		if (replaced)
		{
			northThickness = insets.top;
			southThickness = insets.bottom;
			eastThickness = insets.right;
			westThickness = insets.left;
		}
		else
		{
			northThickness = Math.max(northThickness, insets.top);
			southThickness = Math.max(southThickness, insets.bottom);
			eastThickness = Math.max(eastThickness, insets.right);
			westThickness = Math.max(westThickness, insets.left);
		}
	}
		
	/**
	 * Gets the border insets.
	 * @param c the instance of Component
	 * @return the instance of Insets
	 */
	public Insets getBorderInsets(Component c)
	{
		return new Insets(northThickness, westThickness, southThickness, eastThickness);
	}
	
	/**
	 * Gets the border insets.
	 * @param c the instance of Component
	 * @param insets the instance of Insets
	 * @return the instance of Insets
	 */
	public Insets getBorderInsets(Component c, Insets insets)
	{
		return new Insets(northThickness, westThickness, southThickness, eastThickness);
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
		Color oldColor = g.getColor();
		
		if (northColor != null)
		{	
			g.setColor(northColor);
			for (int i = 0; i < northThickness; i++)
			{
				g.drawLine(x, y + i, x + width - 1, y + i);
			}
		}
		
		if (southColor != null)
		{	
			g.setColor(southColor);
			for (int i = 0; i < southThickness; i++)
			{
				g.drawLine(x, y + height - i - 1, x + width - 1, y + height - i - 1);
			}
		}
		
		if (eastColor != null)
		{	
			g.setColor(eastColor);
			for (int i = 0; i < westThickness; i++)
			{
				g.drawLine(x + i, y, x + i, y + height - 1);
			}
		}
		
		if (westColor != null)
		{	
			g.setColor(westColor);
			for (int i = 0; i < eastThickness; i++)
			{
				g.drawLine(x + width - i - 1, y, x + width - i - 1, y + height - 1);
			}
		}
		
		g.setColor(oldColor);
	}
}