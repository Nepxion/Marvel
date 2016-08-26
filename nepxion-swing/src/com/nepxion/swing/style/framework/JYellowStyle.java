package com.nepxion.swing.style.framework;

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

public class JYellowStyle
	extends JLiteStyle
{
	/**
	 * The identity value.
	 */
	public static final String ID = JYellowStyle.class.getName();
	
	/**
	 * Constructs with the default.
	 */
	public JYellowStyle()
	{
		setSelectionGradientColor(new Color(249, 224, 137));
	}
}