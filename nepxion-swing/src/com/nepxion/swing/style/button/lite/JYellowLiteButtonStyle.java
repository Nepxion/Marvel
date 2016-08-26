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

public class JYellowLiteButtonStyle
	extends AbstractLiteButtonStyle
{
	/**
	 * The identity value.
	 */
	public static final String ID = JYellowLiteButtonStyle.class.getName();
	
	/**
	 * Constructs with the default.
	 */
	public JYellowLiteButtonStyle()
	{		
		rolloverBackground = new Color(245, 232, 184); // new Color(230, 211, 171);
		rolloverBorderColor = new Color(196, 165, 59); // new Color(196, 151, 56);

		selectionBackground = new Color(249, 224, 137); // new Color(250, 214, 138);
		selectionBorderColor = new Color(189, 156, 42); // new Color(191, 143, 41); 
		
		checkColor = new Color(90, 97, 100);
		checkFocusColor = new Color(189, 156, 42);
	}
}