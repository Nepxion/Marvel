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
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ComboBoxTableCellRenderer
	extends JComboBox implements TableCellRenderer
{
	/**
	 * Constructs with the specified initial combo box model.
	 * @param aModel the instance of ComboBoxModel
	 */
	public ComboBoxTableCellRenderer(ComboBoxModel model)
	{
		super(model);
	}
	
	/**
	 * Constructs with the specified initial items.
	 * @param items the object array
	 */
	public ComboBoxTableCellRenderer(final Object items[])
	{
		super(items);
	}
	
	/**
	 * Constructs with the specified initial items.
	 * @param items the instance of Vector
	 */
	public ComboBoxTableCellRenderer(Vector items)
	{
		super(items);
	}
	
	/**
	 * Constructs with the default.
	 */
	public ComboBoxTableCellRenderer()
	{
		super();
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
		setSelectedItem(value);
		
		return this;
	}
}