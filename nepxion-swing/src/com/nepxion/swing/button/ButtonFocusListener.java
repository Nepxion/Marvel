package com.nepxion.swing.button;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.RootPaneContainer;

public class ButtonFocusListener
	extends FocusAdapter
{
	/**
	 * The instance of RootPaneContainer.
	 */
	private RootPaneContainer container;
	
	/**
	 * The instance of JComponent.
	 */
	private JComponent component;
	
	/**
	 * Constructs with the specified initial container.
	 * @param container the instance of RootPaneContainer
	 */
	public ButtonFocusListener(RootPaneContainer container)
	{
		this.container = container;
	}
	
	/**
	 * Constructs with the specified initial component.
	 * @param container the instance of JComponent
	 */
	public ButtonFocusListener(JComponent component)
	{
		this.component = component;
	}
	
	/**
	 * Invoked when a component gains the keyboard focus.
	 * @param e the instance of FocusEvent
	 */
	public void focusGained(FocusEvent e)
	{
		JButton button = (JButton) e.getSource();
		
		JRootPane rootPane = null;
		if (container != null)
		{
			rootPane = container.getRootPane();
		}
		else if (component != null)
		{
			rootPane = component.getRootPane();
		}
		
		if (rootPane != null)
		{
			rootPane.setDefaultButton(button);
		}
	}
}