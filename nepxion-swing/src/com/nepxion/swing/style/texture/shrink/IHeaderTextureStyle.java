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

public interface IHeaderTextureStyle
	extends ITextureStyle
{
	/**
	 * Gets the resize handler image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getResizeHandlerImageIcon();
	
	/**
	 * Gets the shrink hander left image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getShrinkHandlerLeftImageIcon();
	
	/**
	 * Gets the shrink hander right image icon.
	 * @return the instance of ImageIcon
	 */
	public ImageIcon getShrinkHandlerRightImageIcon();
	
	/**
	 * Gets the border color.
	 * @return the instance of Color
	 */
	public Color getBorderColor();
	
	/**
	 * Gets the content background.
	 * @return the instance of Color
	 */
	public Color getContentBackground();
	
	/**
	 * Gets the separator color array.
	 * @return the color array
	 */
	public Color[] getSeparatorColors();
}