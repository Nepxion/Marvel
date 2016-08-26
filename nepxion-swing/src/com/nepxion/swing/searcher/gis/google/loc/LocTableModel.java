package com.nepxion.swing.searcher.gis.google.loc;

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
import com.nepxion.util.searcher.gis.google.loc.LocEntity;

public class LocTableModel
	extends BasicTableModel
{
	/**
	 * The column name array.
	 */
	public static final String[] COLUMN_NAMES = {SwingLocale.getString("latitude"), SwingLocale.getString("longitude"), SwingLocale.getString("country"), SwingLocale.getString("country_code"), SwingLocale.getString("region"), SwingLocale.getString("city"), SwingLocale.getString("street"), SwingLocale.getString("street_number"), SwingLocale.getString("postal_code")};
	
	/**
	 * Constructs with the specified initial row data list.
	 * @param rowDatas the instance of List
	 */
	public LocTableModel(List rowDatas)
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
		LocEntity entity = (LocEntity) rowDatas.get(row);
		switch (column)
		{
			case 0 :
				return entity.getLatitude() + "";
			case 1 :
				return entity.getLongitude() + "";
			case 2 :
				return entity.getCountry();
			case 3 :
				return entity.getCountryCode();
			case 4 :
				return entity.getRegion();
			case 5 :
				return entity.getCity();
			case 6 :
				return entity.getStreet();
			case 7 :
				return entity.getStreetNumber();
			case 8 :
				return entity.getPostalCode();
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
		LocEntity entity = (LocEntity) rowDatas.get(row);
		
		switch (column)
		{
			case 0 :
				entity.setLongitude(Double.parseDouble(value.toString()));
				break;
			case 1 :
				entity.setLatitude(Double.parseDouble(value.toString()));
				break;
			case 2 :
				entity.setCountry(value.toString());
				break;
			case 3 :
				entity.setCountryCode(value.toString());
				break;
			case 4 :
				entity.setRegion(value.toString());
				break;
			case 5 :
				entity.setCity(value.toString());
				break;
			case 6 :
				entity.setStreet(value.toString());
				break;
			case 7 :
				entity.setStreetNumber(value.toString());
				break;
			case 8 :
				entity.setPostalCode(value.toString());
				break;
		}
		
		fireTableDataChanged();
	}
}