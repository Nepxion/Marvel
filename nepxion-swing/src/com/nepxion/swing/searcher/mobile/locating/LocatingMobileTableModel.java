package com.nepxion.swing.searcher.mobile.locating;

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
import com.nepxion.util.searcher.mobile.locating.LocatingMobileEntity;

public class LocatingMobileTableModel
	extends BasicTableModel
{
	/**
	 * The column name array.
	 */
	public static final String[] COLUMN_NAMES = {SwingLocale.getString("mobile"), SwingLocale.getString("province"), SwingLocale.getString("city"), SwingLocale.getString("area_code"), SwingLocale.getString("postal_code"), SwingLocale.getString("corp"), SwingLocale.getString("card")};
	
	/**
	 * Constructs with the specified initial row data list.
	 * @param rowDatas the instance of List
	 */
	public LocatingMobileTableModel(List rowDatas)
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
		LocatingMobileEntity entity = (LocatingMobileEntity) rowDatas.get(row);
		
		switch (column)
		{
			case 0 :
				return entity.getMobile();
			case 1 :
				return entity.getProvince();
			case 2 :
				return entity.getCity();
			case 3 :
				return entity.getAreaCode();
			case 4 :
				return entity.getPostCode();
			case 5 :
				return entity.getCorp();
			case 6 :
				return entity.getCard();
		}
		
		return null;
	}
	
	/**
	 * Sets the value by a row and column
	 * @param value the object value
	 * @param row the row index value
	 * @param column the column index value
	 */
	public void setValueAt(Object value, int row, int column)
	{
		LocatingMobileEntity entity = (LocatingMobileEntity) rowDatas.get(row);
		
		switch (column)
		{
			case 0 :
				entity.setMobile(value.toString());
				break;
			case 1 :
				entity.setProvince(value.toString());
				break;
			case 2 :
				entity.setCity(value.toString());
				break;
			case 3 :
				entity.setAreaCode(value.toString());
				break;
			case 4 :
				entity.setPostCode(value.toString());
				break;
			case 5 :
				entity.setCorp(value.toString());
				break;
			case 6 :
				entity.setCard(value.toString());
				break;
		}
		
		fireTableDataChanged();
	}
}