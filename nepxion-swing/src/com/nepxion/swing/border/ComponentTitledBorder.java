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
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ComponentTitledBorder
	extends TitledBorder
{
	/**
	 * The instance of Component.
	 */
	private Component component;
	
	/**
	 * Constructs with the specified initial component.
	 * @param component the instance of Component
	 */
	public ComponentTitledBorder(Component component)
	{
		this(null, component, LEFT, TOP);
	}
	
	/**
	 * Constructs with the specified initial border.
	 * @param border the instance of Border
	 */
	public ComponentTitledBorder(Border border)
	{
		this(border, null, LEFT, TOP);
	}
	
	/**
	 * Constructs with the specified initial border and component.
	 * @param border the instance of Border
	 * @param component the instance of Component
	 */
	public ComponentTitledBorder(Border border, Component component)
	{
		this(border, component, LEFT, TOP);
	}
	
	/**
	 * Constructs with the specified initial border, component, title justification and title position.
	 * @param border the instance of Border
	 * @param component the instance of Component
	 * @param titleJustification the title justification value
	 * @param titlePosition the title position value
	 */
	public ComponentTitledBorder(Border border, Component component, int titleJustification, int titlePosition)
	{
		super(border, null, titleJustification, titlePosition, null, null);
		
		this.component = component;
		
		if (border == null)
		{
			this.border = super.getBorder();
		}
	}
	
	/**
	 * Gets the component.
	 * @return the instance of Component
	 */
	public Component getComponent()
	{
		return component;
	}
	
	/**
	 * Sets the component.
	 * @param component the instance of Component
	 */
	public void setComponent(Component component)
	{
		this.component = component;
	}
	
	/**
	 * Gets the component Rectangle by a rectangle and borderInsets.
	 * @param rect the instance of Rectangle
	 * @param insets the instance of Insets
	 * @return the instance of Rectangle
	 */
	public Rectangle getComponentRectangle(Rectangle rect, Insets insets)
	{
		Dimension dimension = component.getPreferredSize();
		Rectangle rectangle = new Rectangle(0, 0, dimension.width, dimension.height);
		switch (titlePosition)
		{
			case ABOVE_TOP :
				rectangle.y = EDGE_SPACING;
				break;
			case TOP :
			case DEFAULT_POSITION :
				rectangle.y = EDGE_SPACING + (insets.top - EDGE_SPACING - TEXT_SPACING - dimension.height) / 2;
				break;
			case BELOW_TOP :
				rectangle.y = insets.top - dimension.height - TEXT_SPACING;
				break;
			case ABOVE_BOTTOM :
				rectangle.y = rect.height - insets.bottom + TEXT_SPACING;
				break;
			case BOTTOM :
				rectangle.y = rect.height - insets.bottom + TEXT_SPACING + (insets.bottom - EDGE_SPACING - TEXT_SPACING - dimension.height) / 2;
				break;
			case BELOW_BOTTOM :
				rectangle.y = rect.height - dimension.height - EDGE_SPACING;
				break;
		}
		switch (titleJustification)
		{
			case LEFT :
			case DEFAULT_JUSTIFICATION :
				rectangle.x = TEXT_INSET_H + insets.left;
				break;
			case RIGHT :
				rectangle.x = rect.width - insets.right - TEXT_INSET_H - rectangle.width;
				break;
			case CENTER :
				rectangle.x = (rect.width - rectangle.width) / 2;
				break;
		}
		
		return rectangle;
	}
	
	/**
	 * Gets the border insets.
	 * @param c the instance of Component
	 * @return the instance of Insets
	 */
	public Insets getBorderInsets(Component c, Insets insets)
	{
		Insets borderInsets;
		if (border != null)
		{
			borderInsets = border.getBorderInsets(c);
		}
		else
		{
			borderInsets = new Insets(0, 0, 0, 0);
		}
		insets.top = EDGE_SPACING + TEXT_SPACING + borderInsets.top;
		insets.right = EDGE_SPACING + TEXT_SPACING + borderInsets.right;
		insets.bottom = EDGE_SPACING + TEXT_SPACING + borderInsets.bottom;
		insets.left = EDGE_SPACING + TEXT_SPACING + borderInsets.left;
		
		if (c == null || component == null)
		{
			return insets;
		}
		
		int height = 0;
		if (component != null)
		{
			height = component.getPreferredSize().height;
		}
		
		switch (titlePosition)
		{
			case ABOVE_TOP :
				insets.top += height + TEXT_SPACING;
				break;
			case TOP :
			case DEFAULT_POSITION :
				insets.top += Math.max(height, borderInsets.top) - borderInsets.top;
				break;
			case BELOW_TOP :
				insets.top += height + TEXT_SPACING;
				break;
			case ABOVE_BOTTOM :
				insets.bottom += height + TEXT_SPACING;
				break;
			case BOTTOM :
				insets.bottom += Math.max(height, borderInsets.bottom) - borderInsets.bottom;
				break;
			case BELOW_BOTTOM :
				insets.bottom += height + TEXT_SPACING;
				break;
		}
		
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
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
	{
		Rectangle borderRectangle = new Rectangle(x + EDGE_SPACING, y + EDGE_SPACING, width - (EDGE_SPACING * 2), height - (EDGE_SPACING * 2));
		Insets borderInsets;
		if (border != null)
		{
			borderInsets = border.getBorderInsets(c);
		}
		else
		{
			borderInsets = new Insets(0, 0, 0, 0);
		}
		
		Rectangle rectangle = new Rectangle(x, y, width, height);
		Insets insets = getBorderInsets(c);
		Rectangle componentRectangle = getComponentRectangle(rectangle, insets);
		int diff;
		switch (titlePosition)
		{
			case ABOVE_TOP :
				diff = componentRectangle.height + TEXT_SPACING;
				borderRectangle.y += diff;
				borderRectangle.height -= diff;
				break;
			case TOP :
			case DEFAULT_POSITION :
				diff = insets.top / 2 - borderInsets.top - EDGE_SPACING;
				borderRectangle.y += diff;
				borderRectangle.height -= diff;
				break;
			case BELOW_TOP :
			case ABOVE_BOTTOM :
				break;
			case BOTTOM :
				diff = insets.bottom / 2 - borderInsets.bottom - EDGE_SPACING;
				borderRectangle.height -= diff;
				break;
			case BELOW_BOTTOM :
				diff = componentRectangle.height + TEXT_SPACING;
				borderRectangle.height -= diff;
				break;
		}
		border.paintBorder(c, g, borderRectangle.x, borderRectangle.y, borderRectangle.width, borderRectangle.height);
		Color color = g.getColor();
		g.setColor(c.getBackground());
		g.fillRect(componentRectangle.x, componentRectangle.y, componentRectangle.width, componentRectangle.height);
		g.setColor(color);
		component.repaint();
	}
}