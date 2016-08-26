package com.nepxion.demo;

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

import com.nepxion.swing.framework.ribbon.JRibbonContainer;
import com.nepxion.swing.framework.ribbon.JRibbonHierarchy;
import com.nepxion.swing.framework.ribbon.JRibbonTweenPanel;
import com.nepxion.swing.style.framework.JRibbonStyle;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoRibbonWorkspaceBar
{
	public DemoRibbonWorkspaceBar(JRibbonHierarchy ribbonHierarchy)
	{
		JRibbonContainer ribbonContainer = ribbonHierarchy.getRibbonContainer();
		
		// The container is displayed as JEclipseTabbedPane
		JEclipseTabbedPane tabbedPane = new JEclipseTabbedPane();
		tabbedPane.setSnapToolTip(true);
		// tabbedPane.setTabShape(JEclipseTabbedPane.SHAPE_ECLIPSE3X, new JRibbonStyle());		
		tabbedPane.setTabShape(JEclipseTabbedPane.SHAPE_ROUNDED_VSNET, new JRibbonStyle());
		
		// The container is displayed as JBasicTabbedPane
		// JBasicTabbedPane tabbedPane = new JBasicTabbedPane();
		
		tabbedPane.setTabPlacement(JEclipseTabbedPane.BOTTOM);
		ribbonContainer.setTabbedPane(tabbedPane);
		
		// The container is displayed as JRibbonTweenPanel
		JRibbonTweenPanel panel = new JRibbonTweenPanel();
		panel.setTitleColor(Color.black);
		// panel.setTitleFont(new Font("Calibri", Font.BOLD, 14));
		ribbonContainer.setPanel(panel);
	}
}