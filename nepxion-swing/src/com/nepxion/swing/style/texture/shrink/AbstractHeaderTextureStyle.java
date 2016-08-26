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

public class AbstractHeaderTextureStyle
	extends AbstractTextureStyle implements IHeaderTextureStyle
{
	/**
	 * The resize handler image icon.
	 */
	protected ImageIcon resizeHandlerImageIcon;
	
	/**
	 * The shrink handler left image icon.
	 */
	protected ImageIcon shrinkHandlerLeftImageIcon;
	
	/**
	 * The shrink handler right image icon.
	 */
	protected ImageIcon shrinkHandlerRightImageIcon;
	
	/**
	 * The border color.
	 */
	protected Color borderColor;
	
	/**
	 * The content background.
	 */
	protected Color contentBackground;
	
	/**
	 * The separator color array.
	 */
	protected Color[] separatorColors;
	
	/**
	 * Gets the resize handler image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getResizeHandlerImageIcon()
	{
		return resizeHandlerImageIcon;
	}
	
	/**
	 * Gets the shrink hander left image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getShrinkHandlerLeftImageIcon()
	{
		return shrinkHandlerLeftImageIcon;
	}
	
	/**
	 * Gets the shrink hander right image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getShrinkHandlerRightImageIcon()
	{
		return shrinkHandlerRightImageIcon;
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
	 * Gets the content background.
	 * @return the instance of Color
	 */
	public Color getContentBackground()
	{
		return contentBackground;
	}
	
	/**
	 * Gets the separator color array.
	 * @return the color array
	 */
	public Color[] getSeparatorColors()
	{
		return separatorColors;
	}
}