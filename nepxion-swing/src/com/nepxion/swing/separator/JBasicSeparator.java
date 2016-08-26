package com.nepxion.swing.separator;

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
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.SwingConstants;

import com.nepxion.swing.dimension.DimensionManager;

public class JBasicSeparator
	extends JComponent implements SwingConstants
{
	/**
	 * The raised style value.
	 */
	public static final String RAISED_STYLE = "RaisedStyle";
	
	/**
	 * The lowered style value.
	 */
	public static final String LOWERED_STYLE = "LoweredStyle";
	
	/**
	 * The default thickness value.
	 */
	public static final int DEFAULT_THICKNESS = 10;
	
	/**
	 * The bright color.
	 */
	protected Color brightColor = Color.white;

	/**
	 * The dark color.
	 */
	protected Color darkColor = Color.gray;
	
	/**
	 * The orientation value.
	 */
	private int orientation;
	
	/**
	 * The style value.
	 */
	private String style;
	
	/**
	 * The length value.
	 */
	private int length;
	
	/**
	 * Constructs with the default.
	 */
	public JBasicSeparator()
	{
		this(22);
	}
	
	/**
	 * Constructs with the specified initial length.
	 * @param length the length value.
	 */
	public JBasicSeparator(int length)
	{
		this(LOWERED_STYLE, length);
	}
	
	/**
	 * Constructs with the specified initial style and length.
	 * @param style the style string
	 * @param length the length value
	 */
	public JBasicSeparator(String style, int length)
	{
		this(VERTICAL, style, length);
	}
	
	/**
	 * Constructs with the specified initial orientation, style and length.
	 * @param orientation the orientation value
	 * @param style the style string
	 * @param length the length value
	 */
	public JBasicSeparator(int orientation, String style, int length)
	{
		this.orientation = orientation;
		this.style = style;
		
		setLength(length);
	}
	
	/**
	 * Gets the orientation.
	 * @return the orientation value
	 */
	public int getOrientation()
	{
		return orientation;
	}
	
	/**
	 * Sets the orientation
	 * @param orientation the orientation value
	 */
	public void setOrientation(int orientation)
	{
		this.orientation = orientation;
		
		repaint();
	}
	
	/**
	 * Gets the length.
	 * @return the length value
	 */
	public int getLength()
	{
		return length;
	}
	
	/**
	 * Sets the length.
	 * @param length the length value
	 */
	public void setLength(int length)
	{
		this.length = length;
		
		Dimension dimension = new Dimension();
		if (orientation == VERTICAL)
		{
			dimension.width = DEFAULT_THICKNESS;
			dimension.height = length;
		}
		else if (orientation == HORIZONTAL)
		{
			dimension.width = length;
			dimension.height = DEFAULT_THICKNESS;
		}
		
		DimensionManager.setDimension(this, dimension);
	}
	
	/**
	 * Sets the bright color.
	 * @param brightColor the instance of Color
	 */
	public void setBrightColor(Color brightColor)
	{
		this.brightColor = brightColor;
	}

	/**
	 * Sets the dark color.
	 * @param darkColor the instance of Color
	 */
	public void setDarkColor(Color darkColor)
	{
		this.darkColor = darkColor;
	}
	
	/**
	 * Paints the graphics.
	 * @param g the instance of Graphics
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		
		int w = getWidth();
		int h = getHeight();
		
		if (style.equals(RAISED_STYLE))
		{
			g.setColor(brightColor);
		}
		else if (style.equals(LOWERED_STYLE))
		{
			g.setColor(darkColor);
		}
		if (orientation == VERTICAL)
		{
			g.drawLine(w / 2 - 1, 0, w / 2 - 1, h);
		}
		else if (orientation == HORIZONTAL)
		{
			g.drawLine(0, h / 2 - 1, w, h / 2 - 1);
		}
		
		if (style.equals(LOWERED_STYLE))
		{
			g.setColor(brightColor);
		}
		else if (style.equals(RAISED_STYLE))
		{
			g.setColor(darkColor);
		}
		if (orientation == VERTICAL)
		{
			g.drawLine(w / 2, 0, w / 2, h);
		}
		else if (orientation == HORIZONTAL)
		{
			g.drawLine(0, h / 2, w, h / 2);
		}
	}
}