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
import com.nepxion.demo.component.layout.box.DemoColumnXBoxLayoutPanel;
import com.nepxion.demo.component.layout.box.DemoRowXBoxLayoutPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoXBoxLayoutTogglePanel
	extends DemoTogglePanel
{
	public DemoXBoxLayoutTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Row Mode", IconFactory.getSwingIcon("component/layout_16.png"), new DemoToggleTemplate(new DemoRowXBoxLayoutPanel()), "Row Mode");				
		toggleTabbedPane.addTab("Column Mode", IconFactory.getSwingIcon("component/layout_16.png"), new DemoToggleTemplate(new DemoColumnXBoxLayoutPanel()), "Column Mode");		
	}
	
	public String getToggleText()
	{
		return "XBox Layout";
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
		return "Multi-style XBox Layout";
	}
}