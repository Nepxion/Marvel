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

import javax.swing.Icon;
import javax.swing.JTable;

import com.nepxion.swing.element.IElementNode;

public class ElementTableCellRenderer
	extends DefaultTableCellRenderer
{
	/**
	 * The cell icon.
	 */
	private Icon cellIcon;
	
	/**
	 * The cell height value.
	 */
	private int cellHeight = -1;
	
	/**
	 * Constructs with the default.
	 */
	public ElementTableCellRenderer()
	{
		this(null);
	}
	
	/**
	 * Constructs with the specified initial cell height.
	 * @param cellHeight the cell height value
	 */
	public ElementTableCellRenderer(int cellHeight)
	{
		this(null, cellHeight);
	}
	
	/**
	 * Constructs with the specified initial cell icon.
	 * @param cellIcon the instance of Icon
	 */
	public ElementTableCellRenderer(Icon cellIcon)
	{
		this(cellIcon, -1);
	}
	
	/**
	 * Constructs with the specified initial cell icon and cell height.
	 * @param cellIcon the instance of Icon
	 * @param cellHeight the cell height value
	 */
	public ElementTableCellRenderer(Icon cellIcon, int cellHeight)
	{
		this.cellIcon = cellIcon;
		this.cellHeight = cellHeight;
		
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
		
		if (cellHeight > 0 && table.getRowHeight() != cellHeight)
		{
			table.setRowHeight(cellHeight);
		}
		if (value instanceof IElementNode)
		{
			IElementNode elementNode = (IElementNode) value;
			setText(elementNode.getText());
			setIcon(elementNode.getIcon());
			setToolTipText(elementNode.getToolTipText());
		}
		else if (value instanceof Icon)
		{
			setText("");
			setIcon((Icon) value);
		}
		else
		{
			setText("");
			if (cellIcon != null)
			{
				setIcon(cellIcon);
			}
		}
		
		return this;
	}
}