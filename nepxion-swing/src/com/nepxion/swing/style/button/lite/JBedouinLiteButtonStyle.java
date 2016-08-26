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

public class JBedouinLiteButtonStyle
	extends AbstractLiteButtonStyle
{
	/**
	 * The identity value.
	 */
	public static final String ID = JBedouinLiteButtonStyle.class.getName();
	
	/**
	 * Constructs with the default.
	 */
	public JBedouinLiteButtonStyle()
	{
		rolloverBackground = new Color(166, 173, 176, 180);
		rolloverBorderColor = new Color(128, 128, 128, 225);
		
		selectionBackground = new Color(166, 173, 176);
		selectionBorderColor = Color.gray;
		
		checkColor = new Color(90, 97, 100);
		checkFocusColor = new Color(128, 128, 128, 150); // new Color(234, 182, 71);
	}
}