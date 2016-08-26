package com.nepxion.swing.menubar;

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

import javax.swing.BorderFactory;
import javax.swing.JMenuBar;

public class JBasicMenuBar
	extends JMenuBar
{
	/**
	 * The boolean value of isBorderVisible.
	 */
	private boolean isBorderVisible;
	
	/**
	 * Constructs with the default.
	 */
	public JBasicMenuBar()
	{
		setBorderVisible(false);
		setPreferredSize(new Dimension(getPreferredSize().width, 25));
	}
	
	/**
	 * Sets the border visible.
	 * @param isBorderVisible the boolean value of isBorderVisible
	 */
	public void setBorderVisible(boolean isBorderVisible)
	{
		this.isBorderVisible = isBorderVisible;
		
		if (isBorderVisible)
		{
			setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
		}
		else
		{
			setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		}
		
		repaint();
	}
	
	/**
	 * Paints the graphics.
	 * @param g the instance of Graphics
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		
		if (isBorderVisible)
		{
			int h = getHeight();
			g.setColor(Color.white);
			g.drawLine(1, 2, 1, h - 5);
			g.setColor(Color.gray);
			g.drawLine(2, 2, 2, h - 5);
		}
	}
}