package com.nepxion.swing.panel;

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
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.UIManager;

import com.nepxion.swing.gradient.JGradientPainter;

public class JGradientPanel
	extends JPanel
{
	private Color gradientColor;
	
	public JGradientPanel(Color background)
	{
		this(background, null);
	}
	
	public JGradientPanel(LayoutManager layoutManager, Color background)
	{
		this(layoutManager, background, null);
	}
	
	public JGradientPanel(Color background, Color gradientColor)
	{
		setBackground(background);
		
		this.gradientColor = gradientColor;
	}
	
	public JGradientPanel(LayoutManager layoutManager, Color background, Color gradientColor)
	{
		super(layoutManager);
		
		setBackground(background);
		
		this.gradientColor = gradientColor;
	}
	
	public void setGradientColor(Color gradientColor)
	{
		this.gradientColor = gradientColor;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if (isOpaque())
		{
			if (gradientColor == null)
			{
				gradientColor = UIManager.getColor("Panel.background");
			}
			Rectangle rectangle = new Rectangle(0, 0, getWidth(), getHeight());
			JGradientPainter.fastFill((Graphics2D) g, rectangle, gradientColor, getBackground(), false);
		}
	}
}