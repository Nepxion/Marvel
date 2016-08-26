package com.nepxion.swing.table.columnconfig;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.selector.checkbox.JCheckBoxListPanel;

public class JColumnConfigListPanel
	extends JCheckBoxListPanel
{
	private JTable table;
	
	public JColumnConfigListPanel(JTable table)
	{
		this.table = table;
		
		retrieveList();
		
		setPreferredSize(new Dimension(300, 300));
	}
	
	public void updateListFacade()
	{
		List allElementNodes = getAllElementNodes();
		
		for (Iterator iterator = allElementNodes.iterator(); iterator.hasNext();)
		{
			ElementNode elementNode = (ElementNode) iterator.next();
			
			TableColumn tableColumn = (TableColumn) elementNode.getUserObject();
			
			boolean retrieveColumn = retrieveColumn(tableColumn);
			elementNode.setSelected(retrieveColumn);
		}
		
		updateSelection();
	}
	
	public void updateTableFacade()
	{
		TableColumnModel tableColumnModel = table.getColumnModel();
		
		List tableColumns = new ArrayList();
		
		for (int i = 0; i < table.getColumnCount(); i++)
		{
			TableColumn tableColumn = tableColumnModel.getColumn(i);
			
			tableColumns.add(tableColumn);
		}
		
		for (Iterator iterator = tableColumns.iterator(); iterator.hasNext();)
		{
			TableColumn tableColumn = (TableColumn) iterator.next();
			
			table.removeColumn(tableColumn);
		}
		
		List selectedElementNodes = getSelectedElementNodes();
		
		for (Iterator iterator = selectedElementNodes.iterator(); iterator.hasNext();)
		{
			ElementNode elementNode = (ElementNode) iterator.next();
			
			TableColumn tableColumn = (TableColumn) elementNode.getUserObject();
			
			table.addColumn(tableColumn);
		}
	}
	
	public void retrieveList()
	{
		List allElementNodes = new ArrayList();
		
		TableColumnModel tableColumnModel = table.getColumnModel();
		
		for (int i = 0; i < table.getColumnCount(); i++)
		{
			TableColumn tableColumn = tableColumnModel.getColumn(i);
			Object identifier = tableColumn.getIdentifier();
			
			ElementNode elementNode = new ElementNode(identifier.toString(), IconFactory.getSwingIcon("element.png"), identifier.toString(), tableColumn, true);
			allElementNodes.add(elementNode);
		}
		
		setAllElementNodes(allElementNodes);
	}
	
	private boolean retrieveColumn(TableColumn tableColumn)
	{
		TableColumnModel tableColumnModel = table.getColumnModel();
		
		for (int i = 0; i < table.getColumnCount(); i++)
		{
			if (tableColumnModel.getColumn(i) == tableColumn)
			{
				return true;
			}
		}
		
		return false;
	}
}