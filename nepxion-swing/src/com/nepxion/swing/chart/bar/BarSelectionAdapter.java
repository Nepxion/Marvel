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

import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;

public class BarSelectionAdapter
	implements ChartMouseListener
{
	/**
	 * The instance of IBarRenderer.
	 */
	private IBarRenderer chartRenderer;
	
	/**
	 * Constructs with the default.
	 */
	public BarSelectionAdapter()
	{
		
	}
	
	/**
	 * Invoked when the mouse moves on a chart.
	 * @param e the instance of ChartMouseEvent
	 */
	public void chartMouseMoved(ChartMouseEvent e)
	{
		adaptSelection(e, true);
	}
	
	/**
	 * Invoked when the mouse button has been clicked (pressed and released) on a chart.
	 * @param e the instance of ChartMouseEvent
	 */
	public void chartMouseClicked(ChartMouseEvent e)
	{
		adaptSelection(e, false);
	}
	
	/**
	 * Adapts the selections.
	 * @param e the instance of ChartMouseEvent
	 * @param isMouseOver the boolean value of isMouseOver
	 */
	private void adaptSelection(ChartMouseEvent e, boolean isMouseOver)
	{
		JFreeChart chart = e.getChart();
		ChartEntity chartEntity = e.getEntity();
		
		if (chartEntity instanceof CategoryItemEntity)
		{
			CategoryItemEntity categoryItemEntity = (CategoryItemEntity) chartEntity;
			CategoryDataset categoryDataset = categoryItemEntity.getDataset();
			CategoryPlot categoryPlot = chart.getCategoryPlot();
			
			Comparable rowKey = categoryItemEntity.getRowKey();
			Comparable columnKey = categoryItemEntity.getColumnKey();
			
			int rowIndex = categoryDataset.getRowIndex(rowKey);
			int columnIndex = categoryDataset.getColumnIndex(columnKey);
			
			chartRenderer = (IBarRenderer) categoryPlot.getRenderer();
			if (isMouseOver)
			{
				chartRenderer.dispatchMouseOver(rowIndex, columnIndex);
				
			}
			else
			{
				chartRenderer.dispatchMouseDown(rowIndex, columnIndex);
			}
		}
		else
		{
			if (chartRenderer != null)
			{
				if (isMouseOver)
				{
					chartRenderer.dispatchMouseOver(-1, -1);					
				}
				else
				{
					chartRenderer.dispatchMouseDown(-1, -1);
				}
			}
		}
	}
}