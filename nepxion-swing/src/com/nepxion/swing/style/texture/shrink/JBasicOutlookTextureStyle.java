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

import com.nepxion.swing.icon.IconFactory;

public class JBasicOutlookTextureStyle
	extends AbstractOutlookTextureStyle
{
	/**
	 * Constructs with the specified initial basic style path and extension style path.
	 * @param basicStylePath the basic style path string
	 * @param extensionStylePath the extension style path string
	 */
	public JBasicOutlookTextureStyle(String basicStylePath, String extensionStylePath)
	{
		backgroundImageIcon = IconFactory.getSwingIcon(extensionStylePath + "background.png");
		selectionBackgroundImageIcon = IconFactory.getSwingIcon(basicStylePath + "background.png");
		
		backgroundLeftImageIcon = null;
		selectionBackgroundLeftImageIcon = IconFactory.getSwingIcon(basicStylePath + "background_left.png");
		
		backgroundRightImageIcon = null;
		selectionBackgroundRightImageIcon = IconFactory.getSwingIcon(basicStylePath + "background_right.png");
		
		height = backgroundImageIcon.getIconHeight();
		
		handlerImageIcon = IconFactory.getSwingIcon(extensionStylePath + "handler.png");
		SelectionHandlerImageIcon = IconFactory.getSwingIcon(extensionStylePath + "handler_selection.png");
		
		scrollBorderColor = new Color(223, 224, 225);
	}
}