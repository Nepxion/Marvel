package com.nepxion.swing.style.button.lite;

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

public class JBlueLiteButtonStyle
	extends AbstractLiteButtonStyle
{
	/**
	 * The identity value.
	 */
	public static final String ID = JBlueLiteButtonStyle.class.getName();
	
	/**
	 * Constructs with the default.
	 */
	public JBlueLiteButtonStyle()
	{
		rolloverBackground = new Color(224, 232, 246);
		rolloverBorderColor = new Color(152, 180, 226);
		
		selectionBackground = new Color(193, 210, 238);
		selectionBorderColor = new Color(49, 106, 197);
		
		checkColor = new Color(90, 97, 100);
		checkFocusColor = new Color(49, 106, 197);
	}
}