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

public class JNimbusLiteButtonStyle
	extends AbstractLiteButtonStyle
{
	/**
	 * The identity value.
	 */
	public static final String ID = JNimbusLiteButtonStyle.class.getName();
	
	/**
	 * Constructs with the default.
	 */
	public JNimbusLiteButtonStyle()
	{
		rolloverBackground = new Color(238, 240, 245);
		rolloverBorderColor = new Color(141, 146, 150);
		
		selectionBackground = new Color(168, 175, 187);
		selectionBorderColor = new Color(99, 103, 111);
		
		// checkColor = new Color(90, 97, 100);
		// focusColor = new Color(189, 156, 42);
	}
}