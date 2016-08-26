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

public class JAlloyLiteButtonStyle
	extends AbstractLiteButtonStyle
{
	/**
	 * The identity value.
	 */
	public static final String ID = JAlloyLiteButtonStyle.class.getName();
	
	/**
	 * Constructs with the default.
	 */
	public JAlloyLiteButtonStyle()
	{
		rolloverBackground = new Color(193, 210, 238, 150);
		rolloverBorderColor = new Color(49, 106, 197, 225);
		
		selectionBackground = new Color(193, 210, 238);
		selectionBorderColor = new Color(49, 106, 197);
		
		checkColor = new Color(49, 106, 197); // new Color(80, 110, 153);
		checkFocusColor = new Color(49, 106, 197, 150); // new Color(255, 207, 50);
	}
}