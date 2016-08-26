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

import javax.swing.JButton;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class ButtonAncestorListener
	implements AncestorListener
{
	/**
	 * Invoked when the ancestor has been added.
	 * @param e the instance of AncestorEvent
	 */
	public void ancestorAdded(AncestorEvent e)
	{
		JButton defaultButton = (JButton) e.getComponent();
		JRootPane rootPane = SwingUtilities.getRootPane(defaultButton);
		if (rootPane != null)
		{
			rootPane.setDefaultButton(defaultButton);
		}
	}
	
	/**
	 * Invoked when the ancestor has been removed.
	 * @param e the instance of AncestorEvent
	 */
	public void ancestorRemoved(AncestorEvent event)
	{
	}
	
	/**
	 * Invoked when the ancestor has been moved.
	 * @param e the instance of AncestorEvent
	 */
	public void ancestorMoved(AncestorEvent event)
	{
	}
}