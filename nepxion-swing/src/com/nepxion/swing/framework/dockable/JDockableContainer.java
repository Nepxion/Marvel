package com.nepxion.swing.framework.dockable;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Component;

import com.nepxion.swing.container.JContainer;

public class JDockableContainer
	extends JContainer
{
	/**
	 * The content pane.
	 */
	private Component contentPane;
	
	/**
	 * Constructs with the default.
	 */
	public JDockableContainer()
	{
	}
	
	/**
	 * Sets the content pane.
	 * @param contentPane the instance of Component
	 */
	public void setContentPane(Component contentPane)
	{
		this.contentPane = contentPane;
		
		setLayout(new BorderLayout());
		setDockComponent(contentPane);
	}
	
	/**
	 * Gets the content pane.
	 * @return the instance of Component
	 */
	public Component getContentPane()
	{
		return getComponent(0);
	}
	
	/**
	 * Sets the dock component.
	 * @param component the instance of Component
	 */
	protected void setDockComponent(Component component)
	{
		addComponent(component, BorderLayout.CENTER);
	}
	
	/**
	 * Docks the component.
	 * @param component the instance of Component
	 */
	protected void dock(Component component)
	{
		setDockComponent(component != null ? component : contentPane);
	}
}