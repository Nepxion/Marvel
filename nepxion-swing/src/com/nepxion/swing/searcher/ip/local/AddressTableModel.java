package com.nepxion.swing.searcher.ip.local;

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

import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.table.BasicTableModel;
import com.nepxion.util.searcher.ip.local.IPEntity;

public class AddressTableModel
	extends BasicTableModel
{
	/**
	 * The column name array.
	 */
	public static final String[] COLUMN_NAMES = {SwingLocale.getString("ip_start"), SwingLocale.getString("ip_end"), SwingLocale.getString("address")};
	
	/**
	 * Constructs with the specified initial row data list.
	 * @param rowDatas the instance of List
	 */
	public AddressTableModel(List rowDatas)
	{
		super(rowDatas, COLUMN_NAMES);
	}
	
	/**
	 * Returns true if the cell is editable.
	 * @param row the row index value
	 * @param column the column index value
	 * @return true if the cell is editable
	 */
	public boolean isCellEditable(int row, int column)
	{
		return true;
	}
	
	/**
	 * Gets the value by a row and column.
	 * @param row the row index value
	 * @param column the column index value
	 * @return the object value
	 */
	public Object getValueAt(int row, int column)
	{
		IPEntity entity = (IPEntity) rowDatas.get(row);
		
		switch (column)
		{
			case 0 :
				return entity.getStartIP();
			case 1 :
				return entity.getEndIP();
			case 2 :
				return entity.getLocation();
		}
		
		return null;
	}
}