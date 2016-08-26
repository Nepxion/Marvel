package com.nepxion.swing.table.rowheader;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.Vector;

import javax.swing.JList;

import com.nepxion.swing.renderer.table.RowHeaderTableCellRenderer;
import com.nepxion.swing.table.JBasicTable;

public class JRowHeaderTable
	extends JBasicTable
{
	private JList rowHeader;
	
	public JRowHeaderTable()
	{

	}
	
	public void setRowHeaderSize(int cellWidth, int cellHeight)
	{
		/*rowHeader.setFixedCellWidth(25);*/
		rowHeader.setFixedCellWidth(cellWidth);
		rowHeader.setFixedCellHeight(cellHeight /* + getRowMargin() + table.getIntercellSpacing().height*/);
		setRowHeight(cellHeight);		
	}
	
	public void setRowHeaderData(Vector rowHeaderData)
	{
		RowHeaderListModel rowHeaderListModel = new RowHeaderListModel(rowHeaderData);
		rowHeader = new JList(rowHeaderListModel);
		rowHeader.setCellRenderer(new RowHeaderTableCellRenderer(this));
	}
	
	public Vector getRowHeaderData()
	{
		return ((RowHeaderListModel) rowHeader.getModel()).getRowHeaderData();
	}
	
	public JList getRowHeader()
	{
		return rowHeader;
	}
}