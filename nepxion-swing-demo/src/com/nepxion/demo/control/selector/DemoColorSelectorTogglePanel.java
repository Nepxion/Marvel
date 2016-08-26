package com.nepxion.demo.control.selector;

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
import com.nepxion.demo.component.selector.DemoColorSelectorPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoColorSelectorTogglePanel
	extends DemoTogglePanel
{
	public DemoColorSelectorTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Color", IconFactory.getSwingIcon("component/color_chooser_16.png"), new DemoToggleTemplate(new DemoColorSelectorPanel()), "Color");
	}
	
	public String getToggleText()
	{
		return "Color";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/color_chooser_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/color_chooser_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Color Selector";
	}
}