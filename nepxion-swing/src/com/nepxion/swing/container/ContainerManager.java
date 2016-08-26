package com.nepxion.swing.container;

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

import javax.swing.JComponent;

public class ContainerManager
{
	/**
	 * Adds the component to a container.
	 * The container will remove all child components before adding a new component.
	 * @param container the container
	 * @param addedComponent the added component
	 */
	public static void add(JComponent container, Component addedComponent)
	{
		add(container, addedComponent, null);
	}
	
	/**
	 * Adds the component to a container.
	 * The container will remove all child components before adding a new component.
	 * @param container the container
	 * @param addedComponent the added component
	 * @param constraints constraints the constraints object
	 */
	public static void add(JComponent container, Component addedComponent, Object constraints)
	{
		add(container, addedComponent, null, constraints);
	}
	
	/**
	 * Adds the component to a container.
	 * The container will remove the specified component before adding a new component.
	 * @param container the container
	 * @param addedComponent the added component
	 * @param removedComponent the removed component
	 */
	public static void add(JComponent container, Component addedComponent, Component removedComponent)
	{
		add(container, addedComponent, removedComponent, null);
	}
	
	/**
	 * Adds the component to a container.
	 * The container will remove the specified component before adding a new component.
	 * @param container the container
	 * @param addedComponent the added component
	 * @param removedComponent the removed component
	 * @param constraints constraints the constraints object
	 */
	public static void add(JComponent container, Component addedComponent, Component removedComponent, Object constraints)
	{
		if (removedComponent != null)
		{
			container.remove(removedComponent);			
		}	
		else
		{
			container.removeAll();
		}
		if (constraints != null)
		{	
			container.add(addedComponent, constraints);
		}
		else
		{
			container.add(addedComponent);
		}
		update(container);			
	}	
	
	/**
	 * Updates the container.
	 * @param container the container
	 */
	public static void update(JComponent container)
	{
		container.revalidate();
		container.repaint();		
	}
}