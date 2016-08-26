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

import com.nepxion.swing.icon.IconFactory;

public class JBasicHeaderTextureStyle
	extends AbstractHeaderTextureStyle
{
	/**
	 * Constructs with the specified initial basic style path and extension style path.
	 * @param basicStylePath the basic style path string
	 * @param extensionStylePath the extension style path string
	 */
	public JBasicHeaderTextureStyle(String basicStylePath, String extensionStylePath)
	{
		backgroundImageIcon = IconFactory.getSwingIcon(basicStylePath + "background.png");
		selectionBackgroundImageIcon = IconFactory.getSwingIcon(basicStylePath + "background.png");
		
		backgroundLeftImageIcon = IconFactory.getSwingIcon(basicStylePath + "background_left.png");
		selectionBackgroundLeftImageIcon = IconFactory.getSwingIcon(basicStylePath + "background_left.png");
		
		backgroundRightImageIcon = IconFactory.getSwingIcon(basicStylePath + "background_right.png");
		selectionBackgroundRightImageIcon = IconFactory.getSwingIcon(basicStylePath + "background_right.png");
		
		height = backgroundImageIcon.getIconHeight();
		
		resizeHandlerImageIcon = IconFactory.getSwingIcon(extensionStylePath + "resize_handler.png");
		shrinkHandlerLeftImageIcon = IconFactory.getSwingIcon(extensionStylePath + "shrink_handler_left.png");
		shrinkHandlerRightImageIcon = IconFactory.getSwingIcon(extensionStylePath + "shrink_handler_right.png");
	}
}