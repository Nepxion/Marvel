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

import javax.swing.JTable;

public class PasswordTableCellRenderer
	extends DefaultTableCellRenderer
{
	/**
	 * Constructs with the default.
	 */
	public PasswordTableCellRenderer()
	{
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
		
		if (value != null && value instanceof String)
		{
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < value.toString().trim().length(); i++)
			{
				stringBuffer.append("*");
			}
			setText(stringBuffer.toString());
		}
		
		return this;
	}
}
