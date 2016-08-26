package com.nepxion.swing.config;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.ButtonGroup;

import com.nepxion.swing.buttonbar.JBasicButtonBar;
import com.nepxion.swing.toggle.JToggleActionButton;

public class JConfigButtonBar
	extends JBasicButtonBar
{
	/**
	 * The instance of ButtonGroup.
	 */
	private ButtonGroup buttonGroup;
	
	/**
	 * Constructs with the default.
	 */
	public JConfigButtonBar()
	{
		super(VERTICAL);
		
		buttonGroup = new ButtonGroup();
	}
	
	/**
	 * Gets the button group.
	 * @return the instance of ButtonGroup
	 */
	public ButtonGroup getButtonGroup()
	{
		return buttonGroup;
	}
	
	/**
	 * Adds the toggle action button.
	 * @param toggleActionButton the instance of JToggleActionButton
	 */
	public void addButton(JToggleActionButton toggleActionButton)
	{
		add(toggleActionButton);
		buttonGroup.add(toggleActionButton);
	}
	
	/**
	 * Removes the toggle action button.
	 * @param toggleActionButton the instance of JToggleActionButton
	 */
	public void removeButton(JToggleActionButton toggleActionButton)
	{
		remove(toggleActionButton);
		buttonGroup.remove(toggleActionButton);
	}
}