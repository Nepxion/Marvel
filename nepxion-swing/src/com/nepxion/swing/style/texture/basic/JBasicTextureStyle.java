package com.nepxion.swing.style.texture.basic;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.style.texture.AbstractTextureStyle;

public class JBasicTextureStyle
	extends AbstractTextureStyle
{
	/**
	 * Constructs with the specified initial style path.
	 * @param stylePath the style path string.
	 */
	public JBasicTextureStyle(String stylePath)
	{
		backgroundImageIcon = IconFactory.getSwingIcon(stylePath + "background.png");
		selectionBackgroundImageIcon = IconFactory.getSwingIcon(stylePath + "background.png");
		
		backgroundLeftImageIcon = IconFactory.getSwingIcon(stylePath + "background_left.png");
		selectionBackgroundLeftImageIcon = IconFactory.getSwingIcon(stylePath + "background_left.png");
		
		backgroundRightImageIcon = IconFactory.getSwingIcon(stylePath + "background_right.png");
		selectionBackgroundRightImageIcon = IconFactory.getSwingIcon(stylePath + "background_right.png");
		
		height = backgroundImageIcon.getIconHeight();
	}
}