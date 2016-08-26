package com.nepxion.demo.common;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JList;

import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.menu.JBasicMenu;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;
import com.nepxion.swing.renderer.list.ElementListCellRenderer;
import com.nepxion.swing.renderer.table.ElementTableCellRenderer;
import com.nepxion.swing.renderer.tree.ElementTreeCellRenderer;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;
import com.nepxion.swing.table.BasicTableModel;
import com.nepxion.swing.table.JBasicTable;
import com.nepxion.swing.textarea.JBasicTextArea;
import com.nepxion.swing.tree.JBasicTree;
import com.nepxion.util.data.CollectionUtil;

public class DemoComponentFactory
{
	public static JBasicTree getTree()
	{				
		JBasicTree tree = new JBasicTree(DemoDataFactory.getRootElementNode());
		tree.setCellRenderer(new ElementTreeCellRenderer(20));
		tree.expandAll();
		
		return tree;				
	}
	
	public static JBasicTable getTable()
	{		
		JBasicTable table = new JBasicTable(new ElementNodeTableModel());
		table.setAutoResizeMode(JBasicTable.AUTO_RESIZE_OFF);
		table.getColumn(3).setCellRenderer(new ElementTableCellRenderer());
		
		return table;
	}
	
	public static class ElementNodeTableModel
		extends BasicTableModel
	{		
		public ElementNodeTableModel()
		{
			super(DemoDataFactory.getComponentElementNodes(), DemoDataFactory.getComponentNameColumns());
		}	
        
        public Class getColumnClass(int column)
        {
        	if (column == 0)
        	{	
        		return Integer.class;
        	}
        	else if (column == 3)
        	{
        		return Icon.class;
        	}	
        	else if (column == 5 || column == 6)
        	{
        		return Boolean.class;
        	}
        	
        	return String.class;
        }
		
		public Object getValueAt(int row, int column)
		{
			ElementNode elementNode = (ElementNode) rowDatas.get(row);
			switch (column)
			{
				case 0 : return new Integer(elementNode.getIndex());
				case 1 : return elementNode.getName();
				case 2 : return elementNode.getText();
				case 3 : return elementNode.getIcon();
				case 4 : return elementNode.getToolTipText();
				case 5 : return Boolean.valueOf(elementNode.isSelected());
				case 6 : return Boolean.valueOf(elementNode.isEnabled());
				case 7 : return elementNode.getUserObject();
			}
			
			return null;
		}		
	}
	
	public static JList getList()
	{
		List componentElementNodes = DemoDataFactory.getComponentElementNodes();
		
		JList list = new JList(CollectionUtil.parseVector(componentElementNodes));
		list.setCellRenderer(new ElementListCellRenderer(list, BorderFactory.createEmptyBorder(0, 5, 0, 0), 22));
		
		return list;
	}
	
	public static JEclipseTabbedPane getTabbedPane()
	{
		JEclipseTabbedPane eclipseTabbedPane = new JEclipseTabbedPane();
		eclipseTabbedPane.addTab("Tab 1", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new JBasicTextArea()), "Tab 1", true);					
		eclipseTabbedPane.addTab("Tab 2", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new JBasicTextArea()), "Tab 2", false);
		eclipseTabbedPane.addTab("Tab 3", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new JBasicTextArea()), "Tab 3", true);
		eclipseTabbedPane.addTab("Tab 4", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new JBasicTextArea()), "Tab 4", false);
		eclipseTabbedPane.addTab("Tab 5", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new JBasicTextArea()), "Tab 5", true);
		eclipseTabbedPane.addTab("Tab 6", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new JBasicTextArea()), "Tab 6", false);
		eclipseTabbedPane.addTab("Tab 7", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new JBasicTextArea()), "Tab 7", true);
		eclipseTabbedPane.addTab("Tab 8", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new JBasicTextArea()), "Tab 8", false);		
		
		JBasicPopupMenu popupMenu = new JBasicPopupMenu();
		eclipseTabbedPane.setPopupMenu(popupMenu, true);
		
		return eclipseTabbedPane;
	}
	
	public static JBasicPopupMenu createPopupMenu()
	{
		JBasicPopupMenu popupMenu = new JBasicPopupMenu();
		
		JBasicMenu menu1 = new JBasicMenu("Menu");
		menu1.setIcon(IconFactory.getSwingIcon("component/menu_16.png"));
		menu1.add(new JBasicMenuItem("MenuItem", IconFactory.getSwingIcon("component/menu_16.png"), "MenuItem"));
		menu1.add(new JBasicMenuItem("MenuItem", IconFactory.getSwingIcon("component/menu_16.png"), "MenuItem"));
		popupMenu.add(menu1);
		
		JBasicMenu menu2 = new JBasicMenu("Menu");
		menu2.setIcon(IconFactory.getSwingIcon("component/popup_menu_16.png"));
		menu2.add(new JBasicMenuItem("MenuItem", IconFactory.getSwingIcon("component/popup_menu_16.png"), "MenuItem"));
		menu2.add(new JBasicMenuItem("MenuItem", IconFactory.getSwingIcon("component/popup_menu_16.png"), "MenuItem"));
		popupMenu.add(menu2);
		
		popupMenu.addSeparator();
		
		JBasicMenu menu3 = new JBasicMenu("Menu");
		menu3.setIcon(IconFactory.getSwingIcon("component/list_16.png"));
		menu3.add(new JBasicMenuItem("MenuItem", IconFactory.getSwingIcon("component/list_16.png"), "MenuItem"));
		menu3.add(new JBasicMenuItem("MenuItem", IconFactory.getSwingIcon("component/list_16.png"), "MenuItem"));
		popupMenu.add(menu3);
		
		return popupMenu;
	}		
}