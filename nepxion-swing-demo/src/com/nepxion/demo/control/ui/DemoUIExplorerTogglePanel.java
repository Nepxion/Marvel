package com.nepxion.demo.control.ui;

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
import com.nepxion.demo.common.DemoToggleTemplate;
import com.nepxion.demo.component.ui.explorer.DemoUIExplorerPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoUIExplorerTogglePanel
	extends DemoTogglePanel
{
	public DemoUIExplorerTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("UI Explorer", IconFactory.getSwingIcon("component/ui_16.png"), new DemoToggleTemplate(new DemoUIExplorerPanel()), "UI Explorer");		
	}
	
	public String getToggleText()
	{
		return "UI Explorer";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/ui_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/ui_32.png");
	}
	
	public String getToggleDescription()
	{
		return "UI Explorer";
	}
}