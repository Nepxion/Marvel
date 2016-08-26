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
import com.nepxion.demo.component.selector.DemoCheckBoxSelectorPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoCheckBoxSelectorTogglePanel
	extends DemoTogglePanel
{
	public DemoCheckBoxSelectorTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("CheckBox", IconFactory.getSwingIcon("component/check_box_16.png"), new DemoToggleTemplate(new DemoCheckBoxSelectorPanel()), "CheckBox");		
	}
	
	public String getToggleText()
	{
		return "CheckBox";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/check_box_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/check_box_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style CheckBox Selector";
	}
}