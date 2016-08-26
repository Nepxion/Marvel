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

public class JGrayOutlookTextureStyle
	extends JBasicOutlookTextureStyle
{
	/**
	 * The style path.
	 */
	public static final String STYLE_PATH = "skin/outlook/gray/";
	
	/**
	 * Constructs with the default.
	 */
	public JGrayOutlookTextureStyle()
	{
		super(JGrayTextureStyle.STYLE_PATH, STYLE_PATH);
		
		foreground = new Color(120, 120, 125);
		selectionForeground = new Color(59, 59, 59);
		
		borderColor = new Color(146, 151, 161);
	}
}