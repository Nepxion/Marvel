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

public class JEclipseLiteButtonStyle
	extends AbstractLiteButtonStyle
{
	/**
	 * The identity value.
	 */
	public static final String ID = JEclipseLiteButtonStyle.class.getName();
	
	/**
	 * Constructs with the default.
	 */
	public JEclipseLiteButtonStyle()
	{
		rolloverBackground = new Color(182, 189, 210, 150); // new Color(212, 213, 216);
		rolloverBorderColor = new Color(51, 71, 125, 225); // new Color(59, 105, 160);

		selectionBackground = new Color(182, 189, 210);
		selectionBorderColor = new Color(51, 71, 125); // new Color(10, 36, 106);
		
		checkColor = new Color(59, 172, 58);
		checkFocusColor = new Color(245, 165, 16);
	}
}