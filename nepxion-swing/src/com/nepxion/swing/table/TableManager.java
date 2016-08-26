package com.nepxion.swing.table;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.nepxion.swing.lookandfeel.LookAndFeelManager;

public class TableManager
{
	public static void setPreferenceStyle(JTable table)
	{
		// JTableHeader tableHeader = table.getTableHeader();
		// tableHeader.setPreferredSize(new Dimension(tableHeader.getPreferredSize().width, 18));
		// tableHeader.setBackground(UIManager.getColor("Panel.background"));
		// tableHeader.setReorderingAllowed(false);
		
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{	
			table.setRowHeight(25);
		}
		else
		{
			table.setRowHeight(20);
		}
	}
	
	public static int getSelectionMode(JTable table)
	{
		return table.getSelectionModel().getSelectionMode();
	}
	
	public static void setSelectionMode(JTable table, int mode)
	{
		table.getSelectionModel().setSelectionMode(mode);
	}
	
	public static ITableModel getModel(JTable table)
	{
		ITableModel model = null;
		
		TableModel tableModel = table.getModel();
		if (tableModel instanceof ITableModel)
		{
			model = (ITableModel) tableModel;
		}
		
		return model;
	} 
}