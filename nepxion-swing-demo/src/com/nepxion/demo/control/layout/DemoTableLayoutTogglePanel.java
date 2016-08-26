package com.nepxion.demo.control.layout;

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
import com.nepxion.demo.component.layout.table.DemoAbsoluteTableLayoutPanel;
import com.nepxion.demo.component.layout.table.DemoFillTableLayoutPanel;
import com.nepxion.demo.component.layout.table.DemoMinimumTableLayoutPanel;
import com.nepxion.demo.component.layout.table.DemoMixedTableLayoutPanel;
import com.nepxion.demo.component.layout.table.DemoPreferredTableLayoutPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoTableLayoutTogglePanel
	extends DemoTogglePanel
{
	public DemoTableLayoutTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Absolute Mode", IconFactory.getSwingIcon("component/layout_16.png"), new DemoToggleTemplate(new DemoAbsoluteTableLayoutPanel()), "Absolute Mode");
		toggleTabbedPane.addTab("Preferred Mode", IconFactory.getSwingIcon("component/layout_16.png"), new DemoToggleTemplate(new DemoPreferredTableLayoutPanel()), "Preferred Mode");			
		toggleTabbedPane.addTab("Minimum Mode", IconFactory.getSwingIcon("component/layout_16.png"), new DemoToggleTemplate(new DemoMinimumTableLayoutPanel()), "Minimum Mode");
		toggleTabbedPane.addTab("Fill Mode", IconFactory.getSwingIcon("component/layout_16.png"), new DemoToggleTemplate(new DemoFillTableLayoutPanel()), "Fill Mode");	
		toggleTabbedPane.addTab("Mixed Mode", IconFactory.getSwingIcon("component/layout_16.png"), new DemoToggleTemplate(new DemoMixedTableLayoutPanel()), "Mixed Mode");				
	}
	
	public String getToggleText()
	{
		return "Table Layout";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/layout_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/layout_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Table Layout";
	}
}