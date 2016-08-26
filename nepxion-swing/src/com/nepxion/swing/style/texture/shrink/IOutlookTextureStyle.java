package com.nepxion.swing.style.texture.shrink;

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

import com.nepxion.swing.style.texture.ITextureStyle;

public interface IOutlookTextureStyle
	extends ITextureStyle
{
	/**
	 * Gets the handler image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getHandlerImageIcon();
	
	/**
	 * Gets the selection handler image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getSelectionHandlerImageIcon();
	
	/**
	 * Gets the border color.
	 * @return the instance of Color
	 */
	public Color getBorderColor();
	
	/**
	 * Gets the scroll border color.
	 * @return the instance of Color
	 */
	public Color getScrollBorderColor();
}