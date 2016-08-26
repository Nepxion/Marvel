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

public class JLiteStyle
	extends AbstractStyle
{
	/**
	 * The identity value.
	 */
	public static final String ID = JLiteStyle.class.getName();
	
	/**
	 * Constructs with the default.
	 */
	public JLiteStyle()
	{
		gradientColor = UIManager.getColor("Panel.background");
		selectionGradientColor = UIManager.getColor("InternalFrame.activeTitleBackground") != null ? UIManager.getColor("InternalFrame.activeTitleBackground") : UIManager.getColor("Table.selectionBackground");
		
		foreground = Color.white;
		selectionForeground = Color.white;
		
		background = UIManager.getColor("Panel.background");
		selectionBackground = UIManager.getColor("Panel.background");
		
		border = new ShadowBorder();
		headerBorder = new RaisedHeaderBorder();
		titleBorder = BorderFactory.createEmptyBorder(2, 4, 2, 1);
		
		tabbedPaneGradientColor = selectionGradientColor.darker();
		tabbedPaneBackground = new Color(selectionGradientColor.getRed(), selectionGradientColor.getGreen(), selectionGradientColor.getBlue(), 225);
		
		tabbedPaneForeground = Color.black;
		tabbedPaneSelectionForeground = Color.white;
	}
	
	/**
	 * Sets the selection gradient color.
	 * @param color the instance of Color
	 */
	public void setSelectionGradientColor(Color color)
	{
		selectionGradientColor = color;
		
		tabbedPaneGradientColor = selectionGradientColor.darker();
		tabbedPaneBackground = new Color(selectionGradientColor.getRed(), selectionGradientColor.getGreen(), selectionGradientColor.getBlue(), 225);
	}
}