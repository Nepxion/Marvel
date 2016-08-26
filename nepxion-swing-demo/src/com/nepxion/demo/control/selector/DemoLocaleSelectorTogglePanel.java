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
import com.nepxion.demo.component.selector.DemoLocaleSelectorPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoLocaleSelectorTogglePanel
	extends DemoTogglePanel
{
	public DemoLocaleSelectorTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Locale", IconFactory.getSwingIcon("component/locale_16.png"), new DemoToggleTemplate(new DemoLocaleSelectorPanel()), "Locale");		
	}
	
	public String getToggleText()
	{
		return "Locale";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/locale_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/locale_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Locale Selector";
	}
}