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

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;

import com.nepxion.swing.element.IElementNode;

public class RowHeaderTableCellRenderer
	extends DefaultListCellRenderer
{
	/**
	 * The instance of JTableHeader
	 */
	private JTableHeader header;
	
	/**
	 * Constructs with the specified initial table
	 * @param table the instance of JTable
	 */	
	public RowHeaderTableCellRenderer(JTable table)
	{
		header = table.getTableHeader();
		setOpaque(true);
		setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		// setHorizontalAlignment(CENTER);
		setForeground(header.getForeground());
		setBackground(header.getBackground());
		setFont(header.getFont());
	}
	
	/**
	 * Gets the list cell renderer component.
	 * @param list the instance of JList
	 * @param value the value object
	 * @param index the index value
	 * @param isSelected the boolean of isSelected
	 * @param cellHasFocus the boolean of cellHasFocus
	 */
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		
		IElementNode elementNode = (IElementNode) value;
		setText(elementNode.getText());
		setIcon(elementNode.getIcon());
		setToolTipText(elementNode.getToolTipText());
		
		return this;
	}
}