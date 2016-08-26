package com.nepxion.swing.renderer.table;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Component;
import java.util.Date;

import javax.swing.JTable;

import com.nepxion.util.time.TimeUtil;

public class DateTimeTableCellRenderer
	extends DefaultTableCellRenderer
{
	private String formatString;
	
	/**
	 * Constructs with the default.
	 */
	public DateTimeTableCellRenderer()
	{
		setOpaque(true);
	}
	
	/**
	 * Constructs with the specified initial format string.
	 * @param formatString the data time format string
	 */	
	public DateTimeTableCellRenderer(String formatString)
	{
		this.formatString = formatString;
		
		setOpaque(true);
	}
	
	/**
	 * Gets the table cell renderer component.
	 * @param table the instance of JTable
	 * @param value the value object
	 * @param isSelected the boolean value of isSelected
	 * @param hasFocus the boolean value of hasFocus
	 * @param row the row index value
	 * @param column the column index value
	 */
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		if (value instanceof Date)
		{
			Date date = (Date) value;
			String text = TimeUtil.getDateTimeString(date, formatString);
			
			setText(text);
		}
		
		return this;
	}
}