package com.nepxion.swing.selector.button;

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

import com.nepxion.swing.panel.option.JOptionButtonPanel;

public interface ISelectorMenuButton
{
	/**
	 * Sets the content pane.
	 * @param component the instance of Component
	 */
	public void setContentPane(Component component);
	
	/**
	 * Gets the option button panel.
	 * @return the instance of JOptionButtonPanel
	 */
	public JOptionButtonPanel getOptionButtonPanel();
	
	/**
	 * Confirms.
	 * @return true if confirmed successfully
	 */
	public boolean confirm();
	
	/**
	 * Cancels.
	 * @return true if cancelled successfully
	 */
	public boolean cancel();
}