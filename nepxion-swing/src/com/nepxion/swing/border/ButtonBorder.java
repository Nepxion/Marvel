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

import javax.swing.UIManager;
import javax.swing.border.Border;

public class ButtonBorder
	implements Border
{
	/**
	 * The border raised value.
	 */
	public static final int BORDER_RAISED = 0;
	
	/**
	 * The border lowered value.
	 */
	public static final int BORDER_LOWERED = 1;
	
	/**
	 * The brighter color.
	 */
	private Color brighter = UIManager.getColor("Button.background").brighter();
	
	/**
	 * The darker color.
	 */
	private Color darker = UIManager.getColor("Button.background").darker();
	
	/**
	 * The top color.
	 */
	private Color topColor;
	
	/**
	 * The left color.
	 */
	private Color leftColor;
	
	/**
	 * The bottom color.
	 */
	private Color bottomColor;
	
	/**
	 * The right color.
	 */
	private Color rightColor;
	
	/**
	 * Constructs with the specified initial border type.
	 * @param borderType the border type
	 */
	public ButtonBorder(int borderType)
	{
		switch (borderType)
		{
			case BORDER_RAISED :
			{	
				topColor = brighter;
				leftColor = brighter;
				bottomColor = darker;
				rightColor = darker;
				break;
			}
			case BORDER_LOWERED :
			{
				topColor = darker;
				leftColor = darker;
				bottomColor = brighter;
				rightColor = brighter;
				break;
			}
		}
	}
	
	/**
	 * Constructs with the specified initial top color, left color, bottom color and right color.
	 * @param topColor the top color
	 * @param leftColor the left color
	 * @param bottomColor the bottom color
	 * @param rightColor the right color
	 */
	public ButtonBorder(Color topColor, Color leftColor, Color bottomColor, Color rightColor)
	{
		this.topColor = topColor;
		this.leftColor = leftColor;
		this.bottomColor = bottomColor;
		this.rightColor = rightColor;
	}
	
	/**
	 * Gets the border insets.
	 * @param c the instance of Component
	 * @return the instance of Insets
	 */
	public Insets getBorderInsets(Component c)
	{
		return new Insets(topColor == null ? 0 : 1, leftColor == null ? 0 : 1, bottomColor == null ? 0 : 1, rightColor == null ? 0 : 1);
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
		if (bottomColor != null)
		{
			g.setColor(bottomColor);
			g.drawLine(x, y + height - 1, x + width - 1, y + height - 1);
		}
		
		if (rightColor != null)
		{
			g.setColor(rightColor);
			g.drawLine(x + width - 1, y, x + width - 1, y + height - 1);
		}
		
		if (topColor != null)
		{
			g.setColor(topColor);
			g.drawLine(x, y, x + width - 1, y);
		}
		
		if (leftColor != null)
		{
			g.setColor(leftColor);
			g.drawLine(x, y, x, y + height - 1);
		}
	}
}