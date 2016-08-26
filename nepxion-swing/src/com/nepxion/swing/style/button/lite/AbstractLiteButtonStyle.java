package com.nepxion.swing.style.button.lite;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Color;

public abstract class AbstractLiteButtonStyle
	implements ILiteButtonStyle
{
	/**
	 * The roll over background.
	 */
	protected Color rolloverBackground;
	
	/**
	 * The roll over border color.
	 */	
	protected Color rolloverBorderColor;
	
	/**
	 * The selection background.
	 */	
	protected Color selectionBackground;
	
	/**
	 * The selection border color.
	 */	
	protected Color selectionBorderColor;
	
	/**
	 * The check color.
	 */	
	protected Color checkColor;
	
	/**
	 * The check focus color.
	 */	
	protected Color checkFocusColor;
	
	/**
	 * Gets the roll over background.
	 * @return the instance of Color
	 */
	public Color getRolloverBackground()
	{
		return rolloverBackground;
	}
	
	/**
	 * Gets the roll over border color.
	 * @return the instance of Color
	 */
	public Color getRolloverBorderColor()
	{
		return rolloverBorderColor;
	}
	
	/**
	 * Gets the selection background.
	 * @return the instance of Color
	 */
	public Color getSelectionBackground()
	{
		return selectionBackground;
	}
	
	/**
	 * Gets the selection border color.
	 * @return the instance of Color
	 */
	public Color getSelectionBorderColor()
	{
		return selectionBorderColor;
	}
	
	/**
	 * Gets the check color.
	 * @return the instance of Color
	 */
	public Color getCheckColor()
	{
		return checkColor;
	}
	
	/**
	 * Gets the check focus color.
	 * @return the instance of Color
	 */
	public Color getCheckFocusColor()
	{
		return checkFocusColor;
	}
}