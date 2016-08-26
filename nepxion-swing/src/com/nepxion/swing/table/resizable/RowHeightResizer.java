package com.nepxion.swing.table.resizable;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.event.MouseInputAdapter;

import com.nepxion.swing.locale.SwingLocale;

public class RowHeightResizer
	extends MouseInputAdapter
{
	private JTable table;
	private boolean active;
	private boolean rowSelectionAllowed;
	private int row;
	private int startY;
	private int startHeight;
	
	private static final int PIXELS = 5;
	private Cursor lastCursor;
	private static Cursor resizeCursor = Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);
	
	private int minimumHeight = -1;
	private int maximumHeight = -1;
	
	public RowHeightResizer(JTable table)
	{
		this(table, -1, -1);
	}
    
	/**
	 * Class constructor sets the reference to this table and adds mouse listeners to this component.
	 * @param table <code>javax.swing.JTable</code> reference for this instance.
	 */
	public RowHeightResizer(JTable table, int minimumHeight, int maximumHeight)
	{
		this.table = table;
		this.table.addMouseListener(this);
		this.table.addMouseMotionListener(this);
		this.row = -1;
		
		if (minimumHeight > maximumHeight)
		{	
			throw new IllegalArgumentException(SwingLocale.getString("maximum_height_not_less_than_minimum_height"));
		}
		
		this.minimumHeight = minimumHeight;
		this.maximumHeight = maximumHeight;
	}
	
	/**
	 * Checks for <code>null</code> table reference, returns and does nothing if true; otherwise, the mouse listeners are removed.
	 */
	public void done()
	{
		if (this.table == null)
		{	
			return;
		}
		
		this.table.removeMouseListener(this);
		this.table.removeMouseMotionListener(this);
	}
	
	/**
	 * Detects mouse movements.
	 * @param e <code>java.awt.event.MouseEvent</code>
	 */
	public void mouseMoved(MouseEvent e)
	{
		Point p = e.getPoint();
		
		if (this.isMouseOverRowMargin(p))
		{
			if (this.lastCursor == null)
			{
				this.lastCursor = this.table.getCursor();
			}
			this.table.setCursor(resizeCursor);
		}
		else
		{
			this.table.setCursor(this.lastCursor);
		}
	}
	
	/**
	 * Detects mouse-pressed events.
	 * @param e <code>java.awt.event.MouseEvent</code> reference of this event.
	 */
	public void mousePressed(MouseEvent e)
	{
		Point p = e.getPoint();
		
		if (this.isMouseOverRowMargin(p))
		{
			this.active = true;
			this.startY = p.y;
			this.startHeight = table.getRowHeight(row);
			this.rowSelectionAllowed = this.table.getRowSelectionAllowed();
			this.table.setRowSelectionAllowed(false);
		}
	}
	
	/**
	 * Detects dragged event for this mouse event.
	 * @param e <code>java.awt.event.MouseEvent</code> reference of this event.
	 */
	public void mouseDragged(MouseEvent e)
	{
		if (!active)
		{
			return;
		}
		
		int height = startHeight + e.getY() - startY;
		height = Math.max(1, height);
		this.table.setRowHeight(row, height);
	}
	
	/**
	 * Detects mouse released event.
	 * @param e <code>java.awt.event.MouseEvent</code> reference of this event.
	 */
	public void mouseReleased(MouseEvent e)
	{
		if (!active)
		{
			return;
		}
		
		if (minimumHeight != -1 && maximumHeight != -1)
		{	
			if (table.getRowHeight(row) <  minimumHeight)
			{
				table.setRowHeight(row, minimumHeight);
			}	
			else if (table.getRowHeight(row) >  maximumHeight)
			{
				table.setRowHeight(row, maximumHeight);
			}
		}
		
		this.table.setRowSelectionAllowed(this.rowSelectionAllowed);
		this.active = false;
		this.row = -1;	
	}
	
	/**
	 * Indicates whether mouse is over the row margin.
	 * @param p <code>java.util.Point</code> location of this row margin.
	 * @return boolean value indicating whether this mouse is over the row margin.
	 */
	private boolean isMouseOverRowMargin(Point p)
	{
		if (!table.isEnabled())
		{
			return false;
		}
		
		this.row = table.rowAtPoint(p);
		int column = table.columnAtPoint(p);
		
		if (row == -1 || column == -1)
		{
			return false;
		}
		
		Rectangle r = table.getCellRect(row, column, true);
		
		if (p.y >= r.y + r.height - PIXELS)
		{
			return true;
		}
		
		return false;
	}
}