package com.nepxion.swing.ui.explorer;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Color;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import com.nepxion.swing.locale.SwingLocale;

public class UIExplorerTableModel
	extends AbstractTableModel
{
	/**
	 * 
	 */
	protected Map rowDatas;
	
	/**
	 * 
	 */
	protected Object[] rowKeys;
	
	/**
	 * 
	 */
	protected String[] columnNames;
	
	/**
	 * 
	 * @param rowDatas
	 */
	public UIExplorerTableModel(Map rowDatas)
	{
		this(rowDatas, new String[] {SwingLocale.getString("ui_key"), SwingLocale.getString("ui_value"), SwingLocale.getString("ui_hint")});
	}
	
	/**
	 * 
	 * @param rowDatas
	 * @param columnNames
	 */
	public UIExplorerTableModel(Map rowDatas, String[] columnNames)
	{
		this.rowDatas = rowDatas;
		this.rowKeys = rowDatas.keySet().toArray();
		this.columnNames = columnNames;
	}
	
	/**
	 * 
	 */
	public int getRowCount()
	{
		return rowDatas.size();
	}
	
	/**
	 * 
	 */
	public int getColumnCount()
	{
		return columnNames.length;
	}
	
	/**
	 * 
	 */
	public String getColumnName(int column)
	{
		return columnNames[column];
	}
	
	/**
	 * 
	 */
	public Class getColumnClass(int column)
	{
		return Object.class;
	}
	
	/**
	 * 
	 */
	public boolean isCellEditable(int row, int column)
	{
		if (column == 2)
		{
			return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	public String[] getColumnNames()
	{
		return columnNames;
	}
	
	/**
	 * 
	 * @param columnNames
	 */
	public synchronized void setColumnNames(String[] columnNames)
	{
		this.columnNames = columnNames;
		
		fireTableStructureChanged();
	}
	
	/**
	 * 
	 * @return
	 */
	public Map getRowDatas()
	{
		return rowDatas;
	}
	
	/**
	 * 
	 * @param rowDatas
	 */
	public synchronized void setRowData(Map rowDatas)
	{
		this.rowDatas = rowDatas;
		this.rowKeys = rowDatas.keySet().toArray();
		
		fireTableDataChanged();
	}
	
	/**
	 * 
	 */
	public Object getValueAt(int row, int column)
	{	
		Object key = rowKeys[row];
		Object value = rowDatas.get(key);
		switch (column)
		{
			case 0 :
				return key;
			case 1 :
				if (value instanceof Color)
				{
					Color color = (Color) value;
					
					return color.toString().substring(0, color.toString().length() - 1) + ",a=" + color.getAlpha() + "]";
				}
				
				return value;
			case 2 :
				return value;
		}
		
		return null;
	}
}