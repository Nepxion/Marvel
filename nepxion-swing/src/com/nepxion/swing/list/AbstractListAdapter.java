package com.nepxion.swing.list;

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

public abstract class AbstractListAdapter
	implements IListAdapter	        
{
	/**
	 * Constructs with the default.
	 */
	public AbstractListAdapter()
	{
		
	}
	
	/**
	 * Returns true if adding a row is permitted.
	 * @return true if adding a row is permitted
	 */
	public boolean addRowPermitted()
	{
		return true;
	}
	
	/**
	 * Adds a row.
	 * The added row object is usually a data object (java bean).
	 * @return the added row object
	 */
	public Object addRow()
	{
		return null;
	}
	
	/**
	 * Returns true if modifying the row is permitted.
	 * @param selectedRow the selected row index value
	 * @return true if modifying the row is permitted
	 */
	public boolean modifyRowPermitted(int selectedRow)
	{
		return true;
	}
	
	/**
	 * Modifies the row.
	 * The modified row object is usually a data object (java bean) which is needed to modify.
	 * @param selectedRow the selected row index value
	 * @return the modified row object
	 */
	public Object modifyRow(int selectedRow)
	{
		return null;
	}
	
	/**
	 * Returns true if deleting the row is permitted.
	 * @param selectedRow the selected row index value
	 * @return true if deleting the row is permitted
	 */
	public boolean deleteRowPermitted(int selectedRow)
	{
		return true;
	}
	
	/**
	 * Deletes the row.
	 * @param selectedRow the selected row index value
	 * @return true if deleting the row successfully
	 */
	public boolean deleteRow(int selectedRow)
	{
		return true;
	}
	
	/**
	 * Returns true if deleting the rows is permitted.
	 * @param selectedRows the selected row index array
	 * @return true if deleting the rows is permitted 
	 */
	public boolean deleteRowsPermitted(int[] selectedRows)
	{
		return true;
	}
	
	/**
	 * Deletes the rows.
	 * @param selectedRows the selected row index array
	 * @return true if deleting the rows successfully 
	 */
	public boolean deleteRows(int[] selectedRows)
	{
		return true;
	}
	
	/**
	 * Returns true if refreshing the list data is permitted.
	 * @return true if refreshing the list data is permitted
	 */
	public boolean refreshPermitted()
	{
		return true;
	}
	
	/**
	 * Refreshes the list data.
	 * @return the new list data which is need to refresh into JList.
	 */
	public List refresh()
	{
		return null;
	}
	
	/**
	 * Returns true if clearing the list data is permitted.
	 * @return true if clearing the list data is permitted
	 */
	public boolean clearPermitted()
	{
		return true;
	}
	
	/**
	 * Clears the list.
	 * @return true if clearing the list data successfully 
	 */
	public boolean clear()
	{
		return true;
	}
	
	/**
	 * Returns true is saving the list data is permitted.
	 * @return true if saving the list data successfully 
	 */
	public boolean savePermitted()
	{
		return true;
	}
	
	/**
	 * Saves the the list data.
	 * @return the new list data which is need to save into JList.
	 */
	public List save()
	{
		return null;
	}
}