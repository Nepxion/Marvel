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
import com.nepxion.demo.component.selector.DemoFileSelectorPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoFileSelectorTogglePanel
	extends DemoTogglePanel
{
	public DemoFileSelectorTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("File", IconFactory.getSwingIcon("component/file_chooser_16.png"), new DemoToggleTemplate(new DemoFileSelectorPanel()), "File");		
	}
	
	public String getToggleText()
	{
		return "File";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/file_chooser_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/file_chooser_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style File Selector";
	}
}