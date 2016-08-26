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

public class JBorlandLiteButtonStyle
	extends AbstractLiteButtonStyle
{
	/**
	 * The identity value.
	 */
	public static final String ID = JBorlandLiteButtonStyle.class.getName();
	
	/**
	 * Constructs with the default.
	 */
	public JBorlandLiteButtonStyle()
	{
		rolloverBackground = new Color(212, 208, 200);
		rolloverBorderColor = new Color(0, 0, 0);
		
		selectionBackground = new Color(192, 192, 192);
		selectionBorderColor = new Color(0, 0, 0);
		
		checkColor = new Color(0, 0, 0);
		checkFocusColor = new Color(192, 192, 192);
	}
}