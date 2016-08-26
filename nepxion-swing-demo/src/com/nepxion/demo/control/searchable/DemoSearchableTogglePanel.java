package com.nepxion.demo.control.searchable;

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
import com.nepxion.demo.component.searchable.DemoSearchableComboBoxPanel;
import com.nepxion.demo.component.searchable.DemoSearchableListPanel;
import com.nepxion.demo.component.searchable.DemoSearchableTablePanel;
import com.nepxion.demo.component.searchable.DemoSearchableTextAreaPanel;
import com.nepxion.demo.component.searchable.DemoSearchableTreePanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoSearchableTogglePanel
	extends DemoTogglePanel
{
	public DemoSearchableTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("ComobBox", IconFactory.getSwingIcon("component/combo_box_16.png"), new DemoToggleTemplate(new DemoSearchableComboBoxPanel()), "Searchable ComobBox");				
		toggleTabbedPane.addTab("Table", IconFactory.getSwingIcon("component/table_16.png"), new DemoToggleTemplate(new DemoSearchableTablePanel()), "Searchable Table");
		toggleTabbedPane.addTab("Tree", IconFactory.getSwingIcon("component/tree_16.png"), new DemoToggleTemplate(new DemoSearchableTreePanel()), "Searchable Tree");
		toggleTabbedPane.addTab("List", IconFactory.getSwingIcon("component/list_16.png"), new DemoToggleTemplate(new DemoSearchableListPanel()), "Searchable List");
		toggleTabbedPane.addTab("TextArea", IconFactory.getSwingIcon("component/text_area_16.png"), new DemoToggleTemplate(new DemoSearchableTextAreaPanel()), "Searchable TextArea");
	}
	
	public String getToggleText()
	{
		return "Searchable";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/combo_box_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/combo_box_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Searchable Component";
	}
}