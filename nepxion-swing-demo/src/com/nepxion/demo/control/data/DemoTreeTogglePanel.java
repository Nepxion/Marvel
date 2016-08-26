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
import com.nepxion.demo.component.tree.DemoCheckBoxTreePanel;
import com.nepxion.demo.component.tree.DemoElementTreePanel;
import com.nepxion.demo.component.tree.DemoLazyLoaderCheckBoxTreePanel;
import com.nepxion.demo.component.tree.DemoLazyLoaderTreePanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoTreeTogglePanel
	extends DemoTogglePanel
{
	public DemoTreeTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Element Tree", IconFactory.getSwingIcon("component/tree_16.png"), new DemoToggleTemplate(new DemoElementTreePanel()), "Element Tree");				
		toggleTabbedPane.addTab("CheckBox Tree", IconFactory.getSwingIcon("component/tree_16.png"), new DemoToggleTemplate(new DemoCheckBoxTreePanel()), "CheckBox Tree");
		toggleTabbedPane.addTab("LazyLoader Tree", IconFactory.getSwingIcon("component/tree_16.png"), new DemoToggleTemplate(new DemoLazyLoaderTreePanel()), "LazyLoader Tree");
		toggleTabbedPane.addTab("LazyLoader CheckBox Tree", IconFactory.getSwingIcon("component/tree_16.png"), new DemoToggleTemplate(new DemoLazyLoaderCheckBoxTreePanel()), "LazyLoader CheckBox Tree");		
	}
	
	public String getToggleText()
	{
		return "Tree";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/tree_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/tree_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Tree";
	}
}