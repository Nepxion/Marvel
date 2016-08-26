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
import javax.swing.border.AbstractBorder;

public class RaisedHeaderBorder
	extends AbstractBorder
{
	/**
	 * The instance of Insets.
	 */
	private Insets insets = new Insets(1, 1, 1, 0);
	
	/**
	 * The highlight color.
	 */
	private Color highlightColor;
	
	/**
	 * The shadow color.
	 */
	private Color shadowColor;
	
	/**
	 * Constructs with the default.
	 */
	public RaisedHeaderBorder()
	{
		this(null);
	}
	
	/**
	 * Constructs with the specified initial highlight color.
	 * @param highlightColor the highlight color
	 */
	public RaisedHeaderBorder(Color highlightColor)
	{
		this(highlightColor, null);
	}
	
	/**
	 * Constructs with the specified initial highlight color and shadow color.
	 * @param highlightColor the highlight color
	 * @param shadowColor the shadow color
	 */
	public RaisedHeaderBorder(Color highlightColor, Color shadowColor)
	{
		this.highlightColor = highlightColor;
		this.shadowColor = shadowColor;
	}
	
	/**
	 * Gets the border insets.
	 * @param c the instance of Component
	 * @return the instance of Insets
	 */
	public Insets getBorderInsets(Component c)
	{
		return insets;
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
		if (highlightColor == null)
		{
			highlightColor = UIManager.getColor("controlLtHighlight");
		}
		
		if (shadowColor == null)
		{
			shadowColor = UIManager.getColor("controlShadow");
		}
		
		g.translate(x, y);
		g.setColor(highlightColor);
		g.fillRect(0, 0, w, 1);
		g.fillRect(0, 1, 1, h - 1);
		g.setColor(shadowColor);
		g.fillRect(0, h - 1, w, 1);
		g.translate(-x, -y);
	}
}