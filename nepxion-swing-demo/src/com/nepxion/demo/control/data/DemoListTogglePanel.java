package com.nepxion.demo.control.data;

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
import com.nepxion.demo.component.list.DemoCheckBoxListPanel;
import com.nepxion.demo.component.list.DemoElementListPanel;
import com.nepxion.demo.component.list.DemoRadioButtonListPanel;
import com.nepxion.demo.component.list.DemoTabbedListPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoListTogglePanel
	extends DemoTogglePanel
{
	public DemoListTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Element List", IconFactory.getSwingIcon("component/list_16.png"), new DemoToggleTemplate(new DemoElementListPanel()), "Element List");		
		toggleTabbedPane.addTab("CheckBox List", IconFactory.getSwingIcon("component/list_16.png"), new DemoToggleTemplate(new DemoCheckBoxListPanel()), "CheckBox List");
		toggleTabbedPane.addTab("RadioButton List", IconFactory.getSwingIcon("component/list_16.png"), new DemoToggleTemplate(new DemoRadioButtonListPanel()), "RadioButton List");		
		toggleTabbedPane.addTab("Tab List", IconFactory.getSwingIcon("component/list_16.png"), new DemoToggleTemplate(new DemoTabbedListPanel()), "Tab List");		
	}
	
	public String getToggleText()
	{
		return "List";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/list_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/list_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style List";
	}
}