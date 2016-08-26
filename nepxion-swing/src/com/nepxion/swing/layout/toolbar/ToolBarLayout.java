package com.nepxion.swing.layout.toolbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

public class ToolBarLayout
	implements LayoutManager
{
	/**
	 * The x axis value.
	 */
	public static final int X_AXIS = 0;
	
	/**
	 * The x axis value.
	 */
	public static final int Y_AXIS = 1;
	
	/**
	 * The axis value.
	 */
	private int axis;
	
	/**
	 * Constructs with the default.
	 */
	public ToolBarLayout()
	{
		this(X_AXIS);
	}
	
	/**
	 * Constructs with the specified initial axis.
	 * @param axis the axis value
	 */
	public ToolBarLayout(int axis)
	{
		this.axis = axis;
	}
	
	/**
	 * Adds the layout component.
	 * @param name the name string
	 * @param component the instance of Component
	 */
	public void addLayoutComponent(String name, Component component)
	{
		
	}
	
	/**
	 * Removes the layout component.
	 * @param component the instance of Component
	 */
	public void removeLayoutComponent(Component component)
	{
		
	}
	
	/**
	 * Calculates the preferred size dimensions for the specified container.
	 * @param parent the instance of Container
	 */
	public Dimension preferredLayoutSize(Container parent)
	{
		Dimension size = new Dimension();
		Insets insets = parent.getInsets();
		
		if (axis == X_AXIS)
		{
			size.width += insets.left + insets.right;
		}
		else if (axis == Y_AXIS)
		{
			size.height += insets.top + insets.bottom;
		}
		
		for (int i = 0; i < parent.getComponents().length; i++)
		{
			Component component = parent.getComponent(i);
			Dimension dimension = component.getPreferredSize();
			component.setVisible(true);
			if (axis == X_AXIS)
			{
				size.width += dimension.width;
				size.height = Math.max(size.height, dimension.height);
			}
			else if (axis == Y_AXIS)
			{
				size.width += Math.max(size.width, dimension.width);
				size.height = dimension.height;
			}
		}
		
		if (axis == X_AXIS)
		{
			size.height += insets.top + insets.bottom;
		}
		else if (axis == Y_AXIS)
		{
			size.width += insets.left + insets.right;
		}
		
		return size;
	}
	
	/**
	 * Calculates the minimum size dimensions for the specified container.
	 * @param parent the instance of Container
	 */
	public Dimension minimumLayoutSize(Container parent)
	{
		return new Dimension(0, 0);
	}
	
	/**
	 * Lays out the specified container.
	 * @param parent the instance of Container
	 */
	public void layoutContainer(Container parent)
	{
		Dimension size = calculatesSize(parent);
		
		Insets insets = parent.getInsets();
		int x = insets.left;
		int y = insets.top;
		int width = insets.left + insets.right;
		int height = insets.top + insets.bottom;
		
		for (int i = 0; i < parent.getComponentCount(); i++)
		{
			Component component = parent.getComponent(i);
			Dimension dimension = component.getPreferredSize();
			component.setSize(dimension);
			if (axis == X_AXIS)
			{
				component.setLocation(x, y + (size.height - dimension.height) / 2);
				
				x += dimension.width;
				width += dimension.width;
			}
			else if (axis == Y_AXIS)
			{
				component.setLocation(x + (size.width - dimension.width) / 2, y);
				
				y += dimension.height;
				height += dimension.height;
			}
		}
		
		int lastButtonIndex = 0;
		
		if (axis == X_AXIS)
		{
			int parentWidth = parent.getSize().width;
			while (width > parentWidth)
			{
				lastButtonIndex++;
				int index = parent.getComponentCount() - lastButtonIndex;
				
				if (index > -1)
				{
					Component component = parent.getComponent(index);
					component.setVisible(false);
					width -= component.getSize().width;
				}
				else
				{
					break;
				}
			}
		}
		else if (axis == Y_AXIS)
		{
			int parentHeight = parent.getSize().height;
			while (height > parentHeight)
			{
				lastButtonIndex++;
				int index = parent.getComponentCount() - lastButtonIndex;
				
				if (index > -1)
				{
					Component component = parent.getComponent(index);
					component.setVisible(false);
					height -= component.getSize().height;
				}
				else
				{
					break;
				}
			}
		}
	}
	
	/**
	 * Calculates the size for the specified container.
	 * @param parent the instance of Container
	 * @return the instance of Dimension
	 */
	private Dimension calculatesSize(Container parent)
	{
		Dimension size = new Dimension();
		size.width = 0;
		size.height = 0;
		
		for (int i = 0; i < parent.getComponents().length; i++)
		{
			Component component = parent.getComponent(i);
			Dimension dimension = component.getPreferredSize();
			if (axis == X_AXIS)
			{
				size.width += dimension.width;
				size.height = Math.max(size.height, dimension.height);
			}
			else if (axis == Y_AXIS)
			{
				size.width += Math.max(size.width, dimension.width);
				size.height = dimension.height;
			}
		}
		
		return size;
	}
}