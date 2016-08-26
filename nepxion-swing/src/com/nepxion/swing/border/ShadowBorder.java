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

public class ShadowBorder
	extends AbstractBorder
{
	/**
	 * The instance of Insets.
	 */
	private Insets insets = new Insets(1, 1, 3, 3);
	
	/**
	 * The shadow color.
	 */
	private Color shadowColor;
	
	/**
	 * Constructs with the default.
	 */
	public ShadowBorder()
	{
		this(null);
	}
	
	/**
	 * Constructs with the specified initial shadow color.
	 * @param shadowColor the shadow color
	 */
	public ShadowBorder(Color shadowColor)
	{
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
		if (shadowColor == null)
		{
			shadowColor = UIManager.getColor("controlShadow");
		}
		
		if (shadowColor == null)
		{
			shadowColor = Color.gray;
		}
		
		Color lightShadowColor = new Color(shadowColor.getRed(), shadowColor.getGreen(), shadowColor.getBlue(), 170);
		Color lighterShadowColor = new Color(shadowColor.getRed(), shadowColor.getGreen(), shadowColor.getBlue(), 70);
		
		g.translate(x, y);
		
		g.setColor(shadowColor);
		g.fillRect(0, 0, w - 3, 1);
		g.fillRect(0, 0, 1, h - 3);
		g.fillRect(w - 3, 1, 1, h - 3);
		g.fillRect(1, h - 3, w - 3, 1);
		
		// Shadow line 1
		g.setColor(lightShadowColor);
		g.fillRect(w - 3, 0, 1, 1);
		g.fillRect(0, h - 3, 1, 1);
		g.fillRect(w - 2, 1, 1, h - 3);
		g.fillRect(1, h - 2, w - 3, 1);
		
		// Shadow line2
		g.setColor(lighterShadowColor);
		g.fillRect(w - 2, 0, 1, 1);
		g.fillRect(0, h - 2, 1, 1);
		g.fillRect(w - 2, h - 2, 1, 1);
		g.fillRect(w - 1, 1, 1, h - 2);
		g.fillRect(1, h - 1, w - 2, 1);
		g.translate(-x, -y);
	}
}