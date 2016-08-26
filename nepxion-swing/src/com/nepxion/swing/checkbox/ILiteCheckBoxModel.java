package com.nepxion.swing.checkbox;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

public interface ILiteCheckBoxModel
{
	/**
	 * Returns true if the check box is roll over.
	 * @return true if the check box is roll over
	 */
	public boolean isRollover();
	
	/**
	 * Sets the check box roll over.
	 * @param isRollover the boolean value of roll over
	 */
	public void setRollover(boolean rollover);
	
	/**
	 * Returns true if the check box is armed.
	 * @return true if the check box is armed.
	 */
	public boolean isArmed();
	
	/**
	 * Sets the check box armed. 
	 * @param isArmed the boolean value of armed
	 */
	public void setArmed(boolean armed);
	
	/**
	 * Returns true if the check box is pressed.
	 * @return true if the check box is pressed
	 */
	public boolean isPressed();
	
	/**
	 * Sets the check box pressed.
	 * @param isPressed the boolean value of pressed
	 */
	public void setPressed(boolean pressed);
	
	/**
	 * Returns true if the check box is selected.
	 * @return true if the check box is selected
	 */
	public boolean isSelected();
	
	/**
	 * Sets the check box selected.
	 * @param isSelected the boolean value of selected
	 */
	public void setSelected(boolean selected);
	
	/**
	 * Returns true if the check box is enabled.
	 * @return true if the check box is enabled
	 */
	public boolean isEnabled();
	
	/**
	 * Sets the check box enabled.
	 * @param isEnabled the boolean value of enabled
	 */
	public void setEnabled(boolean enabled);
}