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

import com.nepxion.swing.style.texture.basic.JGreenTextureStyle;

public class JGreenHeaderTextureStyle
	extends JBasicHeaderTextureStyle
{
	/**
	 * The style path.
	 */
	public static final String STYLE_PATH = "skin/shrink/green/";
	
	/**
	 * Constructs with the default.
	 */
	public JGreenHeaderTextureStyle()
	{
		super(JGreenTextureStyle.STYLE_PATH, STYLE_PATH);
		
		foreground = Color.white;
		selectionForeground = Color.white;
		
		borderColor = new Color(93, 166, 49);
	}
}