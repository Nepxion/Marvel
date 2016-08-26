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

import com.nepxion.swing.chart.ChartConstants;

public class BarRendererAdapter
	implements ChartConstants
{
	/**
	 * The mouse over row index value.
	 */
	private int mouseOverRow = -1;
	
	/**
	 * The mouse over column index value.
	 */
	private int mouseOverColumn = -1;
	
	/**
	 * The mouse down row index value.
	 */
	private int mouseDownRow = -1;
	
	/**
	 * The mouse down column index value.
	 */
	private int mouseDownColumn = -1;
	
	/**
	 * Constructs with the default.
	 */
	public BarRendererAdapter()
	{

	}
	
	/**
	 * Dispatched when the mouse is over a chart. 
	 * @param row the row index
	 * @param column the column index
	 */
	public void dispatchMouseOver(int row, int column)
	{
		if (mouseOverRow == row && mouseOverColumn == column)
		{
			return;
		}
		
		mouseOverRow = row;
		mouseOverColumn = column;		
	}
	
	/**
	 * Dispatched when the mouse is down a chart. 
	 * @param row the row index
	 * @param column the column index
	 */
	public void dispatchMouseDown(int row, int column)
	{
		if (mouseDownRow == row && mouseDownColumn == column)
		{
			return;
		}
		
		mouseDownRow = row;
		mouseDownColumn = column;
	}
	
	/**
	 * Gets the item outline stroke by a row and column.
	 * @param row the row index
	 * @param column the column index
	 * @return the instance of Stroke
	 */
	public Stroke getItemOutlineStroke(int row, int column)
	{
		if (row == mouseDownRow && column == mouseDownColumn)
		{
			return MOUSE_DOWN_STROKE;
		}
		
		if (row == mouseOverRow && column == mouseOverColumn)
		{
			return MOUSE_OVER_STROKE;
		}
		
		return null;
	}
	
	/**
	 * Gets the item outline paint by a row and column.
	 * @param row the row index
	 * @param column the column index
	 * @return the instance of Paint
	 */
	public Paint getItemOutlinePaint(int row, int column)
	{
		if (row == mouseDownRow && column == mouseDownColumn)
		{
			return MOUSE_DOWN_PAINT;
		}
		
		if (row == mouseOverRow && column == mouseOverColumn)
		{
			return MOUSE_OVER_PAINT;
		}
		
		return null;
	}
	
	/**
	 * Gets the selection row.
	 * @return the selection row index
	 */
	public int getSelectionRow()
	{
		return mouseDownRow;
	}
	
	/**
	 * Gets the selection column.
	 * @return the selection column index
	 */
	public int getSelectionColumn()
	{
		return mouseDownColumn;
	}
}