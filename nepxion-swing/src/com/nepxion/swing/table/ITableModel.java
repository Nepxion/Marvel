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

import java.util.List;

import javax.swing.table.TableModel;

public interface ITableModel
	extends TableModel
{
	public List getRowDatas();
	
	public void setRowDatas(List rowDatas);
	
	public Object getRow(int row);
	
	public List getRows(int[] rows);
	
	public void addRow(Object rowData);
	
	public void addRow(Object rowData, int row);
	
	public void addRows(List rowDataList);
	
	public void addRows(List rowDataList, int row);
	
	public void updateRow(Object rowData, int row);
	
	public void deleteRow(int row);
	
	public void deleteRow(Object rowData);
	
	public void deleteRows(int[] rows);
	
	public void deleteRows(List rowDataList);
	
	public void limitRows(int limitedRowCount, boolean isFromTop);
	
	public void clearRows();
}