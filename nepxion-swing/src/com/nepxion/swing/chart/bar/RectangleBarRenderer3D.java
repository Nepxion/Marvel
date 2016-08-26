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

import java.awt.Paint;
import java.awt.Stroke;

import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.renderer.category.BarRenderer3D;

public class RectangleBarRenderer3D
	extends BarRenderer3D implements IBarRenderer
{
	/**
	 * The instance of BarRendererAdapter.
	 */
	private BarRendererAdapter adapter;
	
	/**
	 * Constructs with the default.
	 */
	public RectangleBarRenderer3D()
	{
		super();
		
		adapter = new BarRendererAdapter();
	}
	
	/**
	 * Constructs with the specified initial x offset and y offset.
	 * @param xOffset the x offset value
	 * @param yOffset the y offset value
	 */
	public RectangleBarRenderer3D(double xOffset, double yOffset)
	{
		super(xOffset, yOffset);
		
		adapter = new BarRendererAdapter();
	}
	
	/**
	 * Dispatched when the mouse is over a chart. 
	 * @param row the row index
	 * @param column the column index
	 */
	public void dispatchMouseOver(int row, int column)
	{
		adapter.dispatchMouseOver(row, column);
		
		notifyListeners(new RendererChangeEvent(this));
	}
	
	/**
	 * Dispatched when the mouse is down a chart. 
	 * @param row the row index
	 * @param column the column index
	 */
	public void dispatchMouseDown(int row, int column)
	{
		adapter.dispatchMouseDown(row, column);
		
		notifyListeners(new RendererChangeEvent(this));
	}
	
	/**
	 * Gets the item outline stroke by a row and column.
	 * @param row the row index
	 * @param column the column index
	 * @return the instance of Stroke
	 */
	public Stroke getItemOutlineStroke(int row, int column)
	{
		Stroke stroke = adapter.getItemOutlineStroke(row, column);
		if (stroke != null)
		{
			return stroke;
		}
		
		return super.getItemOutlineStroke(row, column);
	}
	
	/**
	 * Gets the item outline paint by a row and column.
	 * @param row the row index
	 * @param column the column index
	 * @return the instance of Paint
	 */
	public Paint getItemOutlinePaint(int row, int column)
	{
		Paint paint = adapter.getItemOutlinePaint(row, column);
		if (paint != null)
		{
			return paint;
		}
		
		return super.getItemOutlinePaint(row, column);
	}
	
	/**
	 * Gets the selection row.
	 * @return the selection row index
	 */
	public int getSelectionRow()
	{
		return adapter.getSelectionRow();
	}
	
	/**
	 * Gets the selection column.
	 * @return the selection column index
	 */
	public int getSelectionColumn()
	{
		return adapter.getSelectionColumn();
	}
	
	/**
	 * Gets the adapter.
	 * @return the instance of BarRendererAdapter
	 */
	public BarRendererAdapter getAdapter()
	{
		return adapter;
	}
}