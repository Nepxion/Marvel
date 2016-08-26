package com.nepxion.swing.editor.table;

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
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.nepxion.swing.selector.calendar.JDateTimeSelector;
import com.toedter.calendar.IDateEditor;

public class DateTimeTableCellEditor
	extends AbstractCellEditor implements TableCellEditor
{
	/**
	 * The instance of JDateTimeSelector.
	 */
	private JDateTimeSelector dateTimeSelector;
	
	/**
	 * Constructs with the specified initial format string and date editor.
	 * @param formatString the format string
	 * @param dateEditor the instance of IDateEditor
	 */
	public DateTimeTableCellEditor(String formatString, IDateEditor dateEditor)
	{
		dateTimeSelector = new JDateTimeSelector(null, formatString, dateEditor);
	}
	
	/**
	 * Constructs with the specified initial date time selector.
	 * @param dateTimeSelector the instance of JDateTimeSelector
	 */
	public DateTimeTableCellEditor(JDateTimeSelector dateTimeSelector)
	{
		this.dateTimeSelector = dateTimeSelector;
	}
	
	/**
	 * Returns true if the cell is editable.
	 * @param e the instance of EventObject
	 */
	public boolean isCellEditable(EventObject e)
	{
		if (e instanceof MouseEvent)
		{
			MouseEvent mouseEvent = (MouseEvent) e;
			
			return mouseEvent.getClickCount() >= 2;
		}
		
		return true;
	}
	
	/**
	 * Gets the cell editor value.
	 * @param the cell editor value
	 */
	public Object getCellEditorValue()
	{
		return dateTimeSelector.getDate();
	}
	
	/**
	 * Gets the table cell editor component.
	 * @param table the instance of JTable
	 * @param value the value object
	 * @param isSelected the boolean of isSelected
	 * @param row the row index value
	 * @param column the column index value
	 */
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
	{
		dateTimeSelector.setDate((Date) value);
		
		return dateTimeSelector;
	}
}