package com.nepxion.swing.chart.bar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import org.jfree.chart.event.RendererChangeEvent;

public interface IBarRenderer
{
	/**
	 * Dispatched when the mouse is over a chart. 
	 * @param row the row index
	 * @param column the column index
	 */
	public void dispatchMouseOver(int row, int column);
	
	/**
	 * Dispatched when the mouse is down a chart. 
	 * @param row the row index
	 * @param column the column index
	 */
	public void dispatchMouseDown(int row, int column);
	
	/**
	 * Notifies the listeners.
	 * @param rendererChangeEvent the instance of RendererChangeEvent
	 */
	public void notifyListeners(RendererChangeEvent rendererChangeEvent);
	
	/**
	 * Gets the selection row.
	 * @return the selection row index
	 */
	public int getSelectionRow();
	
	/**
	 * Gets the selection column.
	 * @return the selection column index
	 */
	public int getSelectionColumn();
	
	/**
	 * Gets the adapter.
	 * @return the instance of BarRendererAdapter
	 */
	public BarRendererAdapter getAdapter();
}