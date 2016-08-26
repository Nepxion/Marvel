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

import javax.swing.JToggleButton;

public class BasicToggleButtonModel
	extends JToggleButton.ToggleButtonModel	implements IButtonModel
{
	/**
	 * The boolean value of isMenuDropDown.
	 */
	private boolean isMenuDropDown;
	
	/**
	 * The boolean value of isActionButtonPressed.
	 */
	private boolean isActionButtonPressed;
	
	/**
	 * Constructs with the default.
	 */
	public BasicToggleButtonModel()
	{
		super();
	}
	
	/**
	 * Returns true if the menu drops down.
	 * The value is only used in MenuButton or SplitButton.
	 * @return true if the menu drops down
	 */
	public boolean isMenuDropDown()
	{
		return isMenuDropDown;
	}
	/**
	 * Sets the menu dropped down.
	 * @param isMenuDropDown the boolean value of isMenuDropDown
	 */
	public void setMenuDropDown(boolean isMenuDropDown)
	{
		this.isMenuDropDown = isMenuDropDown;
	}
	
	/**
	 * Returns true if the action button is pressed.
	 * @return true if the action button is pressed
	 */
	public boolean isActionButtonPressed()
	{
		return isActionButtonPressed;
	}
	
	/**
	 * Sets the action button pressed.
	 * @param the boolean value of isActionButtonPressed
	 */
	public void setActionButtonPressed(boolean isActionButtonPressed)
	{
		this.isActionButtonPressed = isActionButtonPressed;
	}
}