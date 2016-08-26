package com.nepxion.swing.toolbar;

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
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JToolBar;

public class JBasicToolBar
	extends JToolBar
{
	/**
	 * The boolean value of isBorderVisible.
	 */
	private boolean isBorderVisible;
	
	/**
	 * Constructs with the default.
	 */
	public JBasicToolBar()
	{		
		setFloatable(false);
		setBorderVisible(false);
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
			setBorder(BorderFactory.createEmptyBorder(0, 5, 1, 0));
		}
		else
		{
			setBorder(BorderFactory.createEmptyBorder(0, 0, 1, 0));
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
			int height = getHeight();
			g.setColor(Color.white);
			g.drawLine(1, 2, 1, height - 3);
			g.setColor(Color.gray);
			g.drawLine(2, 2, 2, height - 3);
		}
	}
}