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

import javax.swing.BorderFactory;
import javax.swing.UIManager;

import com.nepxion.swing.border.RaisedHeaderBorder;
import com.nepxion.swing.border.ShadowBorder;

public class JNimbusStyle
	extends AbstractStyle
{
	/**
	 * The identity value.
	 */
	public static final String ID = JNimbusStyle.class.getName();
	
	/**
	 * Constructs with the default.
	 */
	public JNimbusStyle()
	{
		gradientColor = new Color(115, 164, 209);
		selectionGradientColor = new Color(57, 105, 138);
		
		foreground = Color.white;
		selectionForeground = Color.white;
		
		background = UIManager.getColor("Panel.background");
		selectionBackground = UIManager.getColor("Panel.background");
		
		border = new ShadowBorder(new Color(167, 172, 180));
		headerBorder = new RaisedHeaderBorder(Color.white, new Color(182, 186, 194)); // new Color(167, 172, 180)
		titleBorder = BorderFactory.createEmptyBorder(2, 4, 2, 1);
		
		tabbedPaneGradientColor = new Color(57, 105, 138);
		tabbedPaneBackground = new Color(166, 202, 240);// new Color(115, 164, 209);
		
		tabbedPaneForeground = Color.black;
		tabbedPaneSelectionForeground = Color.white;
	}
}