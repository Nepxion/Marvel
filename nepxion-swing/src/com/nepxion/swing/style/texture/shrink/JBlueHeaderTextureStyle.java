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

import com.nepxion.swing.style.texture.basic.JBlueTextureStyle;

public class JBlueHeaderTextureStyle
	extends JBasicHeaderTextureStyle
{
	/**
	 * The style path.
	 */
	public static final String STYLE_PATH = "skin/shrink/blue/";
	
	/**
	 * Constructs with the default.
	 */
	public JBlueHeaderTextureStyle()
	{
		super(JBlueTextureStyle.STYLE_PATH, STYLE_PATH);
		
		foreground = new Color(21, 66, 139);
		selectionForeground = new Color(21, 66, 139);
		
		borderColor = new Color(141, 178, 227);
	}
}