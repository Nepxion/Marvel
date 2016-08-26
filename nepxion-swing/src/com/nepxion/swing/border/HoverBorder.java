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
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.border.Border;

public class HoverBorder
	implements Border
{
	/**
	 * The last component size value.
	 */
	private Dimension lastComponentSize;
	
	/**
	 * The thickness value.
	 */
	private int thickness;
	
	/**
	 * The instance of Insets.
	 */
	private Insets insets;
	
	/**
	 * The instance of Color.
	 */
	private Color color;
	
	/**
	 * The instance of Color.
	 */
	private Color color2;
	
	/**
	 * Constructs with the specified initial color and thickness.
	 * @param color the instance of Color
	 * @param thickness the thickness value
	 */
	public HoverBorder(Color color, int thickness)
	{
		this.color = color;
		if (color == null)
		{
			this.color = color = Color.gray;
		}
		color2 = new Color(210, 210, 210, 0);
		
		this.thickness = thickness;
	}
	
	/**
	 * Gets the border insets.
	 * @param c the instance of Component
	 * @return the instance of Insets
	 */
	public Insets getBorderInsets(Component c)
	{
		Dimension currentComponent = c.getSize();
		
		if (currentComponent.equals(lastComponentSize))
		{
			return insets;
		}
		
		insets = new Insets(thickness, thickness, thickness, thickness);
		lastComponentSize = currentComponent;
		
		return insets;
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
		Graphics2D g2d = (Graphics2D) g.create();
		
		// Paint top
		GradientPaint gp = new GradientPaint(x, y, color, x, y + thickness, color2);
		g2d.setPaint(gp);
		g2d.fillRect(x, y, width, thickness);
		
		// Paint bottom
		gp = new GradientPaint(x, y + height - thickness - 1, color2, x, y + height, color);
		g2d.setPaint(gp);
		g2d.fillRect(x, y + height - thickness - 1, width, thickness);
		
		// Paint left
		gp = new GradientPaint(x, y, color, x + thickness, y, color2);
		g2d.setPaint(gp);
		g2d.fillRect(x, y, thickness, height);
		
		// Paint right
		gp = new GradientPaint(x + width - thickness - 1, y, color2, x + width, y, color);
		g2d.setPaint(gp);
		g2d.fillRect(x + width - thickness - 1, y, thickness, height);
		
		// Paint outside
		g2d.setPaint(color);
		g2d.drawRect(x, y, width - 1, height - 1);
		g2d.dispose();
	}
}