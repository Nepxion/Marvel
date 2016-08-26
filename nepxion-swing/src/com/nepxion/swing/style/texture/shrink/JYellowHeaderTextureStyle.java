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

import com.nepxion.swing.style.texture.basic.JYellowTextureStyle;

public class JYellowHeaderTextureStyle
	extends JBasicHeaderTextureStyle
{
	/**
	 * The style path.
	 */
	public static final String STYLE_PATH = "skin/shrink/yellow/";
	
	/**
	 * Constructs with the default.
	 */
	public JYellowHeaderTextureStyle()
	{
		super(JYellowTextureStyle.STYLE_PATH, STYLE_PATH);
		
		foreground = new Color(109, 85, 2);
		selectionForeground = new Color(109, 85, 2);
		
		borderColor = new Color(255, 215, 75);
	}
}