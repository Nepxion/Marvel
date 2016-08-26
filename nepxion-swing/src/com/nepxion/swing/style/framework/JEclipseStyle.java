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

public class JEclipseStyle
	extends AbstractStyle
{
	/**
	 * The identity value.
	 */
	public static final String ID = JEclipseStyle.class.getName();
	
	/**
	 * Constructs with the default.
	 */
	public JEclipseStyle()
	{
		gradientColor = new Color(157, 167, 195);
		selectionGradientColor = new Color(157, 167, 195);
		
		foreground = Color.white;
		selectionForeground = Color.white;
		
		background = UIManager.getColor("Panel.background");
		selectionBackground = UIManager.getColor("Panel.background");
		
		border = new ShadowBorder();
		headerBorder = new RaisedHeaderBorder();
		titleBorder = BorderFactory.createEmptyBorder(2, 4, 2, 1);
		
		tabbedPaneGradientColor = new Color(242, 244, 247);
		tabbedPaneBackground = new Color(157, 167, 195);
		
		tabbedPaneForeground = Color.black;
		tabbedPaneSelectionForeground = Color.black;
	}
}