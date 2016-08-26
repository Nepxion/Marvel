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
import com.nepxion.demo.component.selector.DemoRadioButtonSelectorPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoRadioButtonSelectorTogglePanel
	extends DemoTogglePanel
{
	public DemoRadioButtonSelectorTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("RadioButton", IconFactory.getSwingIcon("component/radio_button_16.png"), new DemoToggleTemplate(new DemoRadioButtonSelectorPanel()), "RadioButton");		
	}
	
	public String getToggleText()
	{
		return "RadioButton";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/radio_button_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/radio_button_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style RadioButton Selector";
	}
}