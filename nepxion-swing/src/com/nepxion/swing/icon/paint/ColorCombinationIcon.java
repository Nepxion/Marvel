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

public class ColorCombinationIcon
	implements Icon
{
	/**
	 * The instance of Icon.
	 */
	private Icon icon;
	
	/**
	 * The instance of ColorIcon.
	 */
	private ColorIcon colorIcon;
	
	/**
	 * The width value.
	 */
	private int width;
	
	/**
	 * The height value.
	 */
	private int height;
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of Icon
	 */
	public ColorCombinationIcon(Icon icon)
	{
		this(icon, null);
	}
	
	/**
	 * Constructs with the specified initial icon and fill color.
	 * @param icon the instance of Icon
	 * @param fillColor the fill color
	 */
	public ColorCombinationIcon(Icon icon, Color fillColor)
	{
		this(icon, fillColor, Color.gray);
	}

	/**
	 * Constructs with the specified initial icon, fill color and border color.
	 * @param icon the instance of Icon
	 * @param fillColor the fill color
	 * @param borderColor the border color
	 */
	public ColorCombinationIcon(Icon icon, Color fillColor, Color borderColor)
	{
		this(icon, fillColor, borderColor, 16, 16);
	}
	
	/**
	 * Constructs with the specified initial icon, fill color, border color, width and height.
	 * @param icon the instance of Icon
	 * @param fillColor the fill color
	 * @param borderColor the border color
	 * @param width the width value
	 * @param height the height value
	 */
	public ColorCombinationIcon(Icon icon, Color fillColor, Color borderColor, int width, int height)
	{
		this.icon = icon;
		this.width = width;
		this.height = height;
		
		colorIcon = new ColorIcon(fillColor, borderColor, 16, 4);
	}
	
	/**
	 * Gets the fill color.
	 * @return the instance of Color
	 */
	public Color getFillColor()
	{
		return colorIcon.getFillColor();
	}
	
	/**
	 * Sets the fill color.
	 * @param fillColor the instance of Color
	 */
	public void setFillColor(Color fillColor)
	{
		colorIcon.setFillColor(fillColor);
	}
	
	/**
	 * Gets the border color.
	 * @return the instance of Color
	 */
	public Color getBorderColor()
	{
		return colorIcon.getBorderColor();
	}
	
	/**
	 * Sets the border color.
	 * @param borderColor the instance of Color
	 */
	public void setBorderColor(Color borderColor)
	{
		colorIcon.setBorderColor(borderColor);
	}

	/**
	 * Gets the icon width.
	 * @return the icon width value.
	 */
	public int getIconWidth()
	{
		return width;
	}
	
	/**
	 * Gets the icon height.
	 * @return the icon height value.
	 */
	public int getIconHeight()
	{
		return height;
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
		icon.paintIcon(c, g, x, y);
		colorIcon.paintIcon(c, g, x, y + height - 4);
	}
}