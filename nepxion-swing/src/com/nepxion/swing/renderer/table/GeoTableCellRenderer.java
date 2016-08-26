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

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.icon.paint.GeoCellIcon;

public class GeoTableCellRenderer
	extends DefaultTableCellRenderer
{
	/**
	 * Constructs with the default.
	 */
	public GeoTableCellRenderer()
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
		
		IElementNode elementNode = (IElementNode) value;
		Color color = (Color) elementNode.getUserObject();
		setIcon(new GeoCellIcon(elementNode.getIndex(), color));
		
		return this;
	}
}