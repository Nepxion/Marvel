package com.nepxion.swing.dialog;

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
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class DialogResizer
	extends ComponentAdapter
{
	/**
	 * The dimension value.
	 */
	private Dimension dimension;
	
	/**
	 * The minimum dimension value.
	 */
	private Dimension minimumDimension;
	
	/**
	 * The maximum dimension value.
	 */
	private Dimension maximumDimension;
	
	/**
	 * Constructs with the default.
	 */
	public DialogResizer()
	{
		this(null);
	}
	
	/**
	 * Constructs with the specified initial dimension.
	 * @param dimension the dimension value
	 */
	public DialogResizer(Dimension dimension)
	{
		this(dimension, null, null);
	}
	
	/**
	 * Constructs with the specified initial dimension, minimumDimension and maximumDimension.
	 * @param dimension the dimension value
	 * @param minimumDimension the minimum dimension value
	 * @param maximumDimension the maximum dimension value
	 */
	public DialogResizer(Dimension dimension, Dimension minimumDimension, Dimension maximumDimension)
	{
		this.dimension = dimension;
		this.minimumDimension = minimumDimension;
		this.maximumDimension = maximumDimension;
	}
	
	/**
	 * Gets the dimension.
	 * @return the instance of Dimension
	 */
	public Dimension getDimension()
	{
		return dimension;
	}
	
	/**
	 * Sets the dimension.
	 * @param dimension the instance of Dimension
	 */
	public void setDimension(Dimension dimension)
	{
		this.dimension = dimension;
	}
	
	/**
	 * Gets the minimum dimension.
	 * @return the instance of Dimension
	 */
	public Dimension getMinimumDimension()
	{
		return minimumDimension;
	}
	
	/**
	 * Sets the minimum dimension.
	 * @param minimumDimension the instance of Dimension
	 */
	public void setMinimumDimension(Dimension minimumDimension)
	{
		this.minimumDimension = minimumDimension;
	}
	
	/**
	 * Gets the maximum dimension.
	 * @return the instance of Dimension
	 */
	public Dimension getMaximumDimension()
	{
		return maximumDimension;
	}
	
	/**
	 * Sets the maximum dimension.
	 * @param maximumDimension the instance of Dimension
	 */
	public void setMaximumDimension(Dimension maximumDimension)
	{
		this.maximumDimension = maximumDimension;
	}
	
	/**
	 * Invoked when the component's size changes.
	 * @param e the instance of ComponentEvent
	 */
	public void componentResized(ComponentEvent e)
	{
		Component component = (Component) e.getSource();
		Dimension size = component.getSize();
		
		if (dimension == null)
		{
			return;
		}
		
		if (minimumDimension != null)
		{
			if (size.width < minimumDimension.width || size.height < minimumDimension.height)
			{
				if (size.width < minimumDimension.width)
				{
					dimension.width = minimumDimension.width;
				}
				if (size.height < minimumDimension.height)
				{
					dimension.height = minimumDimension.height;
				}
				component.setSize(dimension);
			}
		}
		
		if (maximumDimension != null)
		{
			if (size.width > maximumDimension.width || size.height > maximumDimension.height)
			{
				if (size.width > maximumDimension.width)
				{
					dimension.width = maximumDimension.width;
				}
				if (size.height > maximumDimension.height)
				{
					dimension.height = maximumDimension.height;
				}
				component.setSize(dimension);
			}
		}
		
		if (minimumDimension == null && maximumDimension == null)
		{
			component.setSize(dimension);
		}
	}
}