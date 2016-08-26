package com.nepxion.swing.style.texture;

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

import javax.swing.ImageIcon;

public abstract class AbstractTextureStyle
	implements ITextureStyle
{
	/**
	 * The background image icon.
	 */
	protected ImageIcon backgroundImageIcon;
	
	/**
	 * The selection background image icon.
	 */
	protected ImageIcon selectionBackgroundImageIcon;
	
	/**
	 * The background left image icon.
	 */
	protected ImageIcon backgroundLeftImageIcon;
	
	/**
	 * The selection background left image icon.
	 */
	protected ImageIcon selectionBackgroundLeftImageIcon;
	
	/**
	 * The background right image icon.
	 */
	protected ImageIcon backgroundRightImageIcon;
	
	/**
	 * The selection background right image icon.
	 */
	protected ImageIcon selectionBackgroundRightImageIcon;
	
	/**
	 * The foreground.
	 */
	protected Color foreground;
	
	/**
	 * The selection foreground.
	 */
	protected Color selectionForeground;
	
	/**
	 * The height value.
	 */
	protected int height;
	
	/**
	 * Gets the background image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getBackgroundImageIcon()
	{
		return backgroundImageIcon;
	}
	
	/**
	 * Gets the selection background image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getSelectionBackgroundImageIcon()
	{
		return selectionBackgroundImageIcon;
	}
	
	/**
	 * Gets the background left image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getBackgroundLeftImageIcon()
	{
		return backgroundLeftImageIcon;
	}
	
	/**
	 * Gets the selection background left image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getSelectionBackgroundLeftImageIcon()
	{
		return selectionBackgroundLeftImageIcon;
	}
	
	/**
	 * Gets the background right image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getBackgroundRightImageIcon()
	{
		return backgroundRightImageIcon;
	}
	
	/**
	 * Gets the selection background right image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getSelectionBackgroundRightImageIcon()
	{
		return selectionBackgroundRightImageIcon;
	}
	
	/**
	 * Gets the foreground.
	 * @return the instance of Color
	 */
	public Color getForeground()
	{
		return foreground;
	}
	
	/**
	 * Gets the selection foreground.
	 * @return the instance of Color
	 */
	public Color getSelectionForeground()
	{
		return selectionForeground;
	}
	
	/**
	 * Gets the height.
	 * @return the height value
	 */
	public int getHeight()
	{
		return height;
	}
}