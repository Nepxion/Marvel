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

public interface ITextureStyle
{	
	/**
	 * Gets the background image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getBackgroundImageIcon();
	
	/**
	 * Gets the selection background image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getSelectionBackgroundImageIcon();
	
	/**
	 * Gets the background left image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getBackgroundLeftImageIcon();
	
	/**
	 * Gets the selection background left image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getSelectionBackgroundLeftImageIcon();
	
	/**
	 * Gets the background right image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getBackgroundRightImageIcon();
	
	/**
	 * Gets the selection background right image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getSelectionBackgroundRightImageIcon();
	
	/**
	 * Gets the foreground.
	 * @return the instance of Color
	 */
	public Color getForeground();
	
	/**
	 * Gets the selection foreground.
	 * @return the instance of Color
	 */
	public Color getSelectionForeground();
	
	/**
	 * Gets the height.
	 * @return the height value
	 */
	public int getHeight();
}