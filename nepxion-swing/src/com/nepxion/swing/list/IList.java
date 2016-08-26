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

import java.util.Vector;

import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

public interface IList
{
	/**
	 * The single selection mode value.
	 */
	public static final int SINGLE_SELECTION = ListSelectionModel.SINGLE_SELECTION;
	
	/**
	 * The interval selection mode value.
	 */
	public static final int SINGLE_INTERVAL_SELECTION = ListSelectionModel.SINGLE_INTERVAL_SELECTION;
	
	/**
	 * The multiple interval selection mode value.
	 */
	public static final int MULTIPLE_INTERVAL_SELECTION = ListSelectionModel.MULTIPLE_INTERVAL_SELECTION;
	
	/**
	 * Gets the list model.
	 * @return the instance of ListModel
	 */
	public ListModel getModel();
	
	/**
	 * Sets the list model.
	 * @param listModel the instance of ListModel
	 */
	public void setModel(ListModel listModel);
	
	/**
	 * Gets the selection mode.
	 * @return the selection mode value
	 */
	public int getSelectionMode();
	
	/**
	 * Sets the selection mode.
	 * @param mode the selection mode value
	 */
	public void setSelectionMode(int mode);
	
	/**
	 * Gets the list data.
	 * @return the instance of Vector
	 */
	public Vector getListData();
	
	/**
	 * Sets the list data.
	 * @param listData the list data array.
	 */
	public void setListData(Object[] listData);
	
	/**
	 * Sets the list data.
	 * @param listData the instance of Vector
	 */
	public void setListData(Vector listData);
	
	/**
	 * Gets the selected index array.
	 * @return the selected index array
	 */
	public int[] getSelectedIndexes();
	
	/**
	 * Executes the selection.
	 * @param oldSelectedRow the old selected row index value
	 * @param newSelectedRow the new selected row index value
	 */
	public void executeSelection(int oldSelectedRow, int newSelectedRow);
	
	/**
	 * Executes the mouse clicked event when a row selected.
	 * @param selectedRow the selected row index value
	 */
	public void executeClicked(int selectedRow);
	
	/**
	 * Executes the mouse double-clicked event when a row selected.
	 * @param selectedRow the selected row index value
	 */
	public void executeDoubleClicked(int selectedRow);
	
	/**
	 * Executes the popup menu shown when a row selected.
	 * @param selectedRow the selected row index value
	 * @param x the x value
	 * @param y the y value
	 */
	public void executePopupMenu(int selectedRow, int x, int y);
	
	/**
	 * Executes the popup menu shown.
	 * @param x the x value
	 * @param y the y value
	 */
	public void executePopupMenu(int x, int y);
}