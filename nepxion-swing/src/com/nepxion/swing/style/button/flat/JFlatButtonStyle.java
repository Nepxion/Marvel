package com.nepxion.swing.style.button.flat;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.UIManager;

public class JFlatButtonStyle
	extends AbstractFlatButtonStyle
{
	/**
	 * The identity value.
	 */
	public static final String ID = JFlatButtonStyle.class.getName();
	
	/**
	 * Constructs with the default.
	 */
	public JFlatButtonStyle()
	{
		brightColor = UIManager.getColor("Button.background").brighter();
		darkColor = UIManager.getColor("Button.background").darker();
	}
}