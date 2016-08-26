package com.nepxion.demo.control.container;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.Icon;

import com.nepxion.demo.common.DemoTogglePanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoSplitPaneTogglePanel
	extends DemoTogglePanel
{
	public DemoSplitPaneTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();	
	}
	
	public String getToggleText()
	{
		return "SplitPane";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/split_pane_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/split_pane_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style SplitPane";
	}
}