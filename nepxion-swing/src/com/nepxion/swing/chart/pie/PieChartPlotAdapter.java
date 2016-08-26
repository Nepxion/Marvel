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

import java.awt.Paint;
import java.awt.Stroke;

import com.nepxion.swing.chart.ChartConstants;

public class PieChartPlotAdapter
	implements ChartConstants
{
	/**
	 * The mouse over key value.
	 */
	private Comparable mouseOverKey;
	
	/**
	 * The mouse down key value.
	 */
	private Comparable mouseDownKey;
		
	/**
	 * Constructs with the default.
	 */
	public PieChartPlotAdapter()
	{

	}
	
	/**
	 * Dispatched when the mouse is over a chart.
	 * @param key the instance of Comparable
	 */
	public void dispatchMouseOver(Comparable key)
	{
		if (mouseOverKey != null && mouseOverKey.equals(key))
		{
			return;
		}
		
		mouseOverKey = key;
	}
	
	/**
	 * Dispatched when the mouse is down a chart.
	 * @param key the instance of Comparable
	 */
	public void dispatchMouseDown(Comparable key)
	{
		if (mouseDownKey != null && mouseDownKey.equals(key))
		{
			return;
		}
		
		mouseDownKey = key;
	}
	
	/**
	 * Gets the section outline stroke.
	 * @param key the instance of Comparable
	 * @return the instance of Stroke
	 */
	public Stroke getSectionOutlineStroke(Comparable key)
	{
		if (mouseDownKey != null && mouseDownKey.equals(key))
		{
			return MOUSE_DOWN_STROKE;
		}
		
		if (mouseOverKey != null && mouseOverKey.equals(key))
		{
			return MOUSE_OVER_STROKE;
		}
		
		return null;
	}
	
	/**
	 * Gets the section outline paint.
	 * @param key the instance of Comparable
	 * @return the instance of Paint
	 */
	public Paint getSectionOutlinePaint(Comparable key)
	{
		if (mouseDownKey != null && mouseDownKey.equals(key))
		{
			return MOUSE_DOWN_PAINT;
		}
		
		if (mouseOverKey != null && mouseOverKey.equals(key))
		{
			return MOUSE_OVER_PAINT;
		}
		
		return null;
	}
	
	/**
	 * Gets the explode percent.
	 * @param key the instance of Comparable
	 * @return the explode percent value
	 */
	public Double getExplodePercent(Comparable key)
	{
		if (mouseDownKey != null && mouseDownKey.equals(key))
		{
			return MOUSE_DOWN_EXPLODE_PERCENT;
		}
		
		if (mouseOverKey != null && mouseOverKey.equals(key))
		{
			return MOUSE_OVER_EXPLODE_PERCENT;
		}
		
		return null;
	}
	
	/**
	 * Gets the selection key.
	 * @return the instance of Comparable
	 */
	public Comparable getSelectionKey()
	{
		return mouseDownKey;
	}
}