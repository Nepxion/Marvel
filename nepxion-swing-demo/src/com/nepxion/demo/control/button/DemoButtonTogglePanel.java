package com.nepxion.demo.control.button;

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
import com.nepxion.demo.component.button.DemoButtonPanel;
import com.nepxion.demo.component.button.DemoMenuButtonPanel;
import com.nepxion.demo.component.button.DemoSelectorMenuButtonPanel;
import com.nepxion.demo.component.button.DemoSplitButtonPanel;
import com.nepxion.demo.component.button.DemoToggleButtonPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoButtonTogglePanel
	extends DemoTogglePanel
{
	public DemoButtonTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Button", IconFactory.getSwingIcon("component/button_16.png"), new DemoToggleTemplate(new DemoButtonPanel()), "Button");
		toggleTabbedPane.addTab("ToggleButton", IconFactory.getSwingIcon("component/toggle_button_16.png"), new DemoToggleTemplate(new DemoToggleButtonPanel()), "ToggleButton");
		toggleTabbedPane.addTab("MenuButton", IconFactory.getSwingIcon("component/menu_16.png"), new DemoToggleTemplate(new DemoMenuButtonPanel()), "MenuButton");
		toggleTabbedPane.addTab("SplitButton", IconFactory.getSwingIcon("component/popup_menu_16.png"), new DemoToggleTemplate(new DemoSplitButtonPanel()), "SplitButton");
		toggleTabbedPane.addTab("SelectorMenuButton", IconFactory.getSwingIcon("component/popup_menu_16.png"), new DemoToggleTemplate(new DemoSelectorMenuButtonPanel()), "SelectorMenuButton");		
	}
	
	public String getToggleText()
	{
		return "Button";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/button_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/button_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Button ToggleButton MenuButton & SplitButton";
	}
}