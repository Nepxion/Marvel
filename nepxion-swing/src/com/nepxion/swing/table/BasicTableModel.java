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

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public abstract class BasicTableModel
	extends AbstractTableModel implements ITableModel
{
	protected List rowDatas;
	protected String[] columnNames;
	
	public BasicTableModel(List rowDatas, String[] columnNames)
	{
		this.rowDatas = rowDatas;
		this.columnNames = columnNames;
	}
	
	public int getRowCount()
	{
		return rowDatas.size();
	}
	
	public int getColumnCount()
	{
		return columnNames.length;
	}
	
	public String getColumnName(int column)
	{
		return (String) columnNames[column];
	}
	
	public Class getColumnClass(int column)
	{
		return super.getColumnClass(column);
	}
	
	public boolean isCellEditable(int row, int column)
	{
		return false;
	}
	
	public String[] getColumnNames()
	{
		return columnNames;
	}
	
	public synchronized void setColumnNames(String[] columnNames)
	{
		this.columnNames = columnNames;
		
		fireTableStructureChanged();
	}
	
	public List getRowDatas()
	{
		return rowDatas;
	}
	
	public synchronized void setRowDatas(List rowDatas)
	{
		this.rowDatas = rowDatas;
		
		fireTableDataChanged();
	}
	
	public Object getRow(int row)
	{
		return rowDatas.get(row);
	}
	
	public List getRows(int[] rows)
	{
		if (rows == null || rows.length == 0)
		{
			return null;
		}
		
		List rowDatas = new ArrayList();
		for (int i = 0; i < rows.length; i++)
		{
			int row = rows[i];
			Object rowData = getRow(row);
			rowDatas.add(rowData);
		}
		
		return rowDatas;
	}
	
	public void addRow(Object rowData)
	{
		rowDatas.add(rowData);
		
		fireTableDataChanged();
	}
	
	public void addRow(Object rowData, int row)
	{
		rowDatas.add(row, rowData);
		
		fireTableDataChanged();
	}
	
	public void addRows(List rowDataList)
	{
		rowDatas.addAll(rowDataList);
		
		fireTableDataChanged();
	}
	
	public void addRows(List rowDataList, int row)
	{
		rowDatas.addAll(row, rowDataList);
		
		fireTableDataChanged();
	}
	
	public void updateRow(Object rowData, int row)
	{
		rowDatas.remove(row);
		rowDatas.add(row, rowData);
		
		fireTableDataChanged();
	}
	
	public void deleteRow(int row)
	{
		rowDatas.remove(row);
		
		fireTableDataChanged();
	}
	
	public void deleteRow(Object rowData)
	{
		rowDatas.remove(rowData);
		
		fireTableDataChanged();
	}
	
	public void deleteRows(int[] rows)
	{
		List rowDataList = new ArrayList();
		for (int i = 0; i < rows.length; i++)
		{
			int row = rows[i];
			Object rowData = getRow(row);
			rowDataList.add(rowData);
		}
		deleteRows(rowDataList);
	}
	
	public void deleteRows(List rowDataList)
	{
		rowDatas.removeAll(rowDataList);
		
		fireTableDataChanged();
	}
	
	public void limitRows(int limitedRowCount, boolean isFromTop)
	{
		int rowCount = getRowCount();
		if (rowCount > limitedRowCount)
		{
			int deletedCount = rowCount - limitedRowCount;
			int[] deletedRows = new int[deletedCount];
			for (int i = 0; i < deletedCount; i++)
			{
				if (isFromTop)
				{
					deletedRows[i] = i;
				}
				else
				{
					deletedRows[i] = rowCount - i - 1;
				}
			}
			deleteRows(deletedRows);
		}
	}
	
	public void clearRows()
	{
		rowDatas.clear();
		
		fireTableDataChanged();
	}
}