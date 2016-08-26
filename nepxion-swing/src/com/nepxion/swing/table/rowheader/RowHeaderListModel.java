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

import javax.swing.AbstractListModel;

public class RowHeaderListModel
	extends AbstractListModel
{
	private Vector rowHeaderData;
	
	public RowHeaderListModel(Vector rowHeaderData)
	{
		this.rowHeaderData = rowHeaderData;
	}
	
	public int getSize()
	{
		return rowHeaderData.size();
	}
	
	public Object getElementAt(int index)
	{
		return rowHeaderData.get(index);
	}
	
	public Vector getRowHeaderData()
	{
		return rowHeaderData;
	}
}