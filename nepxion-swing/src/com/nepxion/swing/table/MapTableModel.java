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

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class MapTableModel
	extends BasicTableModel
{
	public MapTableModel(List rowDatas, String[] columnNames)
	{
		super(rowDatas, columnNames);
	}
	
	public Object getValueAt(int row, int column)
	{
		LinkedHashMap map = (LinkedHashMap) getRow(row);
		
		int index = 0;
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
		{
			Object key = iterator.next();
			if (index == column)
			{
				return map.get(key);
			}
			index++;
		}
		
		return null;
	}
	
	public void setValueAt(Object value, int row, int column)
	{
		LinkedHashMap map = (LinkedHashMap) getRow(row);
		
		int index = 0;
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
		{
			Object key = iterator.next();
			if (index == column)
			{
				map.put(key, value);
				break;
			}
			index++;
		}
		
		fireTableDataChanged();
	}
}