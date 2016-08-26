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
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.border.Border;

public class RoundBorder
	implements Border
{
	/**
	 * The raised etched type value.
	 */
	public static final int RAISED = 0;
	
	/**
	 * The lowered etched type value.
	 */
	public static final int LOWERED = 1;
	
	/**
	 * The etch type value.
	 */
	protected int etchType;
	
	/**
	 * The radius value.
	 */
	protected int radius;
	
	/**
	 * The highlight color.
	 */
	protected Color highlight;
	
	/**
	 * The shadow color.
	 */
	protected Color shadow;
	
	/**
	 * The boolean value of indent.
	 */
	protected boolean indent;
	
	/**
	 * Constructs with the default.
	 */
	public RoundBorder()
	{
		this(false);
	}
	
	/**
	 * Constructs with the specified initial indent.
	 * @param indent the boolean value of indent
	 */
	public RoundBorder(boolean indent)
	{
		this(LOWERED, 3, indent);
	}
	
	/**
	 * Constructs with the specified initial etch type and radius.
	 * @param etchType the etch type value
	 * @param radius the radius value
	 */
	public RoundBorder(int etchType, int radius)
	{
		this(etchType, radius, false);
	}
	
	/**
	 * Constructs with the specified initial etch type, radius and indent.
	 * @param etchType the etch type value
	 * @param radius the radius value
	 * @param indent the boolean value of indent
	 */
	public RoundBorder(int etchType, int radius, boolean indent)
	{
		this(etchType, radius, null, null, indent);
	}
	
	/**
	 * Constructs with the specified initial highlight and shadow.
	 * @param highlight the highlight color
	 * @param shadow the shadow color
	 */
	public RoundBorder(Color highlight, Color shadow)
	{
		this(highlight, shadow, false);
	}
	
	/**
	 * Constructs with the specified initial highlight, shadow and indent.
	 * @param highlight the highlight color
	 * @param shadow the shadow color
	 * @param indent the boolean value of indent
	 */
	public RoundBorder(Color highlight, Color shadow, boolean indent)
	{
		this(LOWERED, highlight, shadow, indent);
	}
	
	/**
	 * Constructs with the specified initial etch type, highlight and shadow.
	 * @param etchType the etch type value
	 * @param highlight the highlight color
	 * @param shadow the shadow color
	 */
	public RoundBorder(int etchType, Color highlight, Color shadow)
	{
		this(etchType, highlight, shadow, false);
	}
	
	/**
	 * Constructs with the specified initial etch type, highlight, shadow and indent.
	 * @param etchType the etch type value
	 * @param highlight the highlight color
	 * @param shadow the shadow color
	 * @param indent the boolean value of indent
	 */
	public RoundBorder(int etchType, Color highlight, Color shadow, boolean indent)
	{
		this(etchType, 3, highlight, shadow, indent);
	}
	
	/**
	 * Constructs with the specified initial etch type, radius, highlight and shadow.
	 * @param etchType the etch type value
	 * @param radius the radius value
	 * @param highlight the highlight color
	 * @param shadow the shadow color
	 */
	public RoundBorder(int etchType, int radius, Color highlight, Color shadow)
	{
		this(etchType, radius, highlight, shadow, false);
	}
	
	/**
	 * Constructs with the specified initial etch type, radius, highlight, shadow and indent.
	 * @param etchType the etch type value
	 * @param radius the radius value
	 * @param highlight the highlight color
	 * @param shadow the shadow color
	 * @param indent the boolean value of indent
	 */
	public RoundBorder(int etchType, int radius, Color highlight, Color shadow, boolean indent)
	{
		this.etchType = etchType;
		this.radius = radius;
		this.highlight = highlight;
		this.shadow = shadow;
		this.indent = indent;
	}
	
	/**
	 * Gets the etch type.
	 * @return the tech type value
	 */
	public int getEtchType()
	{
		return etchType;
	}
	
	/**
	 * Gets the highlight color.
	 * @param c the instance of Component
	 * @return the instance of Color
	 */
	public Color getHighlightColor(Component c)
	{
		return highlight != null ? highlight : c.getBackground().brighter();
	}
	
	/**
	 * Gets the highlight color.
	 * @return the instance of Color
	 */
	public Color getHighlightColor()
	{
		return highlight;
	}
	
	/**
	 * Gets the shadow color.
	 * @param c the instance of Component
	 * @return the instance of Color
	 */
	public Color getShadowColor(Component c)
	{
		return shadow != null ? shadow : c.getBackground().darker();
	}
	
	/**
	 * Gets the shadow color.
	 * @return the instance of Color
	 */
	public Color getShadowColor()
	{
		return shadow;
	}
	
	/**
	 * Gets the border insets.
	 * @param c the instance of Component
	 * @return the instance of Insets
	 */
	public Insets getBorderInsets(Component c)
	{
		if (indent)
		{
			int d = (int) (radius * Math.cos(Math.PI / 4) + 2);
			
			return new Insets(d, d, d, d);
		}
		else
		{
			return new Insets(2, 2, 2, 2);
		}
	}
	
	/**
	 * Gets the border insets.
	 * @param c the instance of Component
	 * @param insets the instance of Insets
	 * @return the instance of Insets
	 */
	public Insets getBorderInsets(Component c, Insets insets)
	{
		if (indent)
		{
			int d = (int) (radius * Math.cos(Math.PI / 4) + 2);
			insets.left = insets.top = insets.right = insets.bottom = d;
			
			return insets;
		}
		else
		{
			insets.left = insets.top = insets.right = insets.bottom = 2;
			
			return insets;
		}
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
		int w = width;
		int h = height;
		int r = radius;
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.translate(x, y);
		
		if (etchType == LOWERED)
		{
			g.setColor(getShadowColor(c));
			g.drawRoundRect(0, 0, w - 2, h - 2, 2 * r, 2 * r);
		}
		
		g.setColor(etchType == LOWERED ? getHighlightColor(c) : getShadowColor(c));
		g.drawLine(1, h - r - 2, 1, r + 1);
		g.drawLine(r + 1, 1, w - r - 2, 1);
		g.drawLine(r, h - 1, w - r - 1, h - 1);
		g.drawLine(w - 1, h - r - 1, w - 1, r);
		
		int ax = 1;
		int ay = 1;
		int arcSide = 2 * r;
		int startAngle = 90;
		int arcAngle = 90;
		g.drawArc(ax, ay, arcSide, arcSide, startAngle, arcAngle); // nw
		
		ax = 1;
		ay = h - 2 * r - 1;
		startAngle = 180;
		g.drawArc(ax, ay, arcSide, arcSide, startAngle, arcAngle); // sw
		
		ax = w - 2 * r - 1;
		ay = h - 2 * r - 1;
		startAngle = -90;
		g.drawArc(ax, ay, arcSide, arcSide, startAngle, arcAngle); // se
		
		ax = w - 2 * r - 1;
		ay = 1;
		startAngle = 0;
		g.drawArc(ax, ay, arcSide, arcSide, startAngle, arcAngle); // ne
		
		if (etchType == RAISED)
		{
			g.setColor(getHighlightColor(c));
			g.drawRoundRect(0, 0, w - 2, h - 2, 2 * r, 2 * r);
		}
		
		g.translate(-x, -y);
	}
}