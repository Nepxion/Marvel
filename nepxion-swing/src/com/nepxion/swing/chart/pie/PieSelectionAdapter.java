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

import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.PieSectionEntity;

import com.nepxion.swing.chart.ChartConstants;

public class PieSelectionAdapter
	implements ChartMouseListener, ChartConstants
{		
	/**
	 * The instance of IPieChartPlot.
	 */
	private IPieChartPlot piePlot;
	
	/**
	 * Constructs with the default.
	 */
	public PieSelectionAdapter()
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
		
		if (chartEntity instanceof PieSectionEntity)
		{
			piePlot = (IPieChartPlot) chart.getPlot();
			
			PieSectionEntity pieSectionEntity = (PieSectionEntity) chartEntity;
			
			Comparable key = pieSectionEntity.getSectionKey();
			
			if (isMouseOver)
			{
				piePlot.dispatchMouseOver(key);
			}
			else
			{
				piePlot.dispatchMouseDown(key);
			}
		}
		else
		{
			if (piePlot != null)
			{	
				if (isMouseOver)
				{
					piePlot.dispatchMouseOver(null);
				}
				else
				{
					piePlot.dispatchMouseDown(null);
				}
			}
		}
	}
}