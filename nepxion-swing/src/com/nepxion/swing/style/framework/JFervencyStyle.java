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

import com.nepxion.swing.border.RaisedHeaderBorder;

public class JFervencyStyle
	extends AbstractStyle
{
	/**
	 * The identity value.
	 */
	public static final String ID = JFervencyStyle.class.getName();
	
	/**
	 * Constructs with the default.
	 */
	public JFervencyStyle()
	{
		gradientColor = new Color(76, 60, 24);
		selectionGradientColor = Color.black;
		
		foreground = Color.white;
		selectionForeground = Color.white;
		
		background = new Color(252, 198, 82);
		selectionBackground = new Color(252, 198, 82);
		
		border = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(-1, 2, 2, 2), BorderFactory.createLineBorder(Color.gray)); // 2, 2, 2, 2
		headerBorder = new RaisedHeaderBorder(Color.gray, Color.gray.brighter());
		titleBorder = BorderFactory.createEmptyBorder(2, 4, 2, 1);
		
		tabbedPaneGradientColor = Color.black;
		tabbedPaneBackground = new Color(252, 198, 82).darker();
		
		tabbedPaneForeground = Color.black;
		tabbedPaneSelectionForeground = Color.white;
	}
}