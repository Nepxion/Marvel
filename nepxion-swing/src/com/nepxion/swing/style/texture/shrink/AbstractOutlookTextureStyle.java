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

import com.nepxion.swing.style.texture.AbstractTextureStyle;

public class AbstractOutlookTextureStyle
	extends AbstractTextureStyle implements IOutlookTextureStyle
{
	/**
	 * The handler image icon.
	 */
	protected ImageIcon handlerImageIcon;
	
	/**
	 * The selection handler image icon.
	 */
	protected ImageIcon SelectionHandlerImageIcon;
	
	/**
	 * The border color.
	 */
	protected Color borderColor;
	
	/**
	 * The scroll border color.
	 */
	protected Color scrollBorderColor;

	/**
	 * Gets the handler image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getHandlerImageIcon()
	{
		return handlerImageIcon;
	}
	
	/**
	 * Gets the selection handler image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getSelectionHandlerImageIcon()
	{
		return SelectionHandlerImageIcon;
	}
	
	/**
	 * Gets the border color.
	 * @return the instance of Color
	 */
	public Color getBorderColor()
	{
		return borderColor;
	}
	
	/**
	 * Gets the scroll border color.
	 * @return the instance of Color
	 */
	public Color getScrollBorderColor()
	{
		return scrollBorderColor;
	}
}