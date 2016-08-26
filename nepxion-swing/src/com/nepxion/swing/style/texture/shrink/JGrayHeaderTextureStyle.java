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

import com.nepxion.swing.style.texture.basic.JGrayTextureStyle;

public class JGrayHeaderTextureStyle
	extends JBasicHeaderTextureStyle
{
	/**
	 * The style path.
	 */
	public static final String STYLE_PATH = "skin/shrink/gray/";
	
	/**
	 * Constructs with the default.
	 */
	public JGrayHeaderTextureStyle()
	{
		super(JGrayTextureStyle.STYLE_PATH, STYLE_PATH);
		
		foreground = new Color(59, 59, 59);
		selectionForeground = new Color(59, 59, 59);
		
		borderColor = new Color(161, 169, 179);
	}
}