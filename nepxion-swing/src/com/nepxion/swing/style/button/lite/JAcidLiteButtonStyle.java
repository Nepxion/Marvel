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

public class JAcidLiteButtonStyle
	extends AbstractLiteButtonStyle
{
	/**
	 * The identity value.
	 */
	public static final String ID = JAcidLiteButtonStyle.class.getName();
	
	/**
	 * Constructs with the default.
	 */
	public JAcidLiteButtonStyle()
	{
		rolloverBackground = new Color(225, 226, 163, 180);
		rolloverBorderColor = new Color(157, 159, 74, 225);
		
		selectionBackground = new Color(225, 226, 163);
		selectionBorderColor = new Color(157, 159, 74);
		
		checkColor = new Color(85, 109, 54);
		checkFocusColor = new Color(157, 159, 74, 150); // new Color(225, 152, 88);
	}
}