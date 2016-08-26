package com.nepxion.swing.tooltip.snap;

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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JToolTip;

import com.nepxion.swing.border.LineBorder;

public class JSnapToolTip
	extends JToolTip
{
	private Component snapComponent;
	private Map snapComponentMap;
	
	private double scaleRatio = 0.3;
	
	public JSnapToolTip(Component snapComponent)
	{
		this(snapComponent, 0.3);
	}
	
	public JSnapToolTip(Component snapComponent, double scaleRatio)
	{
		this.snapComponent = snapComponent;
		this.scaleRatio = scaleRatio;
		
		setBorder(new LineBorder(Color.gray));
	}
	
	public JSnapToolTip(Map snapComponentMap)
	{
		this(snapComponentMap, 0.3);
	}
	
	public JSnapToolTip(Map snapComponentMap, double scaleRatio)
	{
		this.snapComponentMap = snapComponentMap;
		this.scaleRatio = scaleRatio;
		
		setBorder(new LineBorder(Color.gray));
	}
	
	public Component getSnapComponent()
	{
		return snapComponent;
	}
	
	public void setComponent(Component snapComponent)
	{
		this.snapComponent = snapComponent;
		
		repaint();
	}
	
	public Map getSnapComponentMap()
	{
		return snapComponentMap;
	}
	
	public void setSnapComponentMap(Map snapComponentMap)
	{
		this.snapComponentMap = snapComponentMap;
		
		repaint();
	}
	
	public double getScaleRatio()
	{
		return scaleRatio;
	}
	
	public void setScaleRatio(double scaleRatio)
	{
		this.scaleRatio = scaleRatio;
		
		repaint();		
	}
	
	public Dimension getPreferredSize()
	{
		if (snapComponent != null)
		{
			return calculatePreferredSize(snapComponent);
		}
		else if (snapComponentMap != null)
		{
			String tipText = getTipText();
			Component component = (Component) snapComponentMap.get(tipText);
			
			if (component != null)
			{	
				return calculatePreferredSize(component);
			}
			else
			{
				return super.getPreferredSize();
			}
		}	
		else
		{
			return super.getPreferredSize();
		}
	}
	
	private Dimension calculatePreferredSize(Component component)
	{
		int width = component.getWidth();
		int height = component.getHeight();
		
		return new Dimension((int) (width * scaleRatio), (int) (height * scaleRatio));
	}
	
	private void updateDoubleBuffered(JComponent component, List components)
	{
		if (component.isDoubleBuffered())
		{
			components.add(component);
			component.setDoubleBuffered(false);
		}
		
		for (int i = 0; i < component.getComponentCount(); i++)
		{
			Component c = component.getComponent(i);
			
			if (c instanceof JComponent)
			{
				updateDoubleBuffered((JComponent) c, components);
			}
		}
	}
	
	private void resetDoubleBuffered(List components)
	{
		for (Iterator iterator = components.iterator(); iterator.hasNext();)
		{
			JComponent component = (JComponent) iterator.next();
			component.setDoubleBuffered(true);
		}
	}
	
	public void paintComponent(Graphics g)
	{
		if (snapComponent != null)
		{
			paintComponent(g, snapComponent);
		}	
		else if (snapComponentMap != null)
		{
			String tipText = getTipText();
			Component component = (Component) snapComponentMap.get(tipText);
			
			if (component != null)
			{	
				paintComponent(g, component);
			}
		}
	}
	
	public void paintComponent(Graphics g, Component component)
	{
		if (component instanceof JComponent)
		{
			JComponent c = (JComponent) component;
			
			Graphics2D g2d = (Graphics2D) g;
			AffineTransform at = g2d.getTransform();
			g2d.transform(AffineTransform.getScaleInstance(scaleRatio, scaleRatio));
			
			List components = new ArrayList();
			updateDoubleBuffered(c, components);
			
			c.paint(g);
			
			resetDoubleBuffered(components);
			
			g2d.setTransform(at);
		}
	}
}