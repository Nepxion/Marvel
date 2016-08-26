package com.nepxion.swing.chart.pie;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

public interface IPieChartPlot
{
	/**
	 * Dispatched when the mouse is over a chart.
	 * @param key the instance of Comparable
	 */
	public void dispatchMouseOver(Comparable key);
	
	/**
	 * Dispatched when the mouse is down a chart.
	 * @param key the instance of Comparable
	 */
	public void dispatchMouseDown(Comparable key);
	
	/**
	 * Updates the selection data.
	 */
	public void updateSelectionData();
	
	/**
	 * Updates the selection ui.
	 */
	public void updateSelectionUI();
	
	/**
	 * Gets the selection key.
	 * @return the instance of Comparable
	 */
	public Comparable getSelectionKey();
	
	/**
	 * Gets the adapter.
	 * @return the instance of PieChartPlotAdapter
	 */
	public PieChartPlotAdapter getAdapter();
}