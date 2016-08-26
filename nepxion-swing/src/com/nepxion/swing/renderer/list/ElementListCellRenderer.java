package com.nepxion.swing.renderer.list;

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

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.border.Border;

import com.nepxion.swing.element.IElementNode;

public class ElementListCellRenderer
	extends DefaultListCellRenderer
{	
	/**
	 * The instance JList.
	 */
	private JList list;
	
	/**
	 * The cell border.
	 */
	private Border cellBorder;
	
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
	public ElementListCellRenderer()
	{
		this((Border) null);
	}
	
	/**
	 * Constructs with the specified initial cell height.
	 * @param cellHeight the cell height value
	 */
	public ElementListCellRenderer(int cellHeight)
	{
		this((Border) null, cellHeight);
	}
	
	/**
	 * Constructs with the specified initial cell icon.
	 * @param cellIcon the instance of Icon
	 */
	public ElementListCellRenderer(Icon cellIcon)
	{
		this((Border) null, cellIcon);
	}
	
	/**
	 * Constructs with the specified initial cell border.
	 * @param cellBorder the instance of Border
	 */
	public ElementListCellRenderer(Border cellBorder)
	{
		this(cellBorder, null);
	}
	
	/**
	 * Constructs with the specified initial list.
	 * @param list the instance of JList
	 */
	public ElementListCellRenderer(JList list)
	{
		this(list, (Border) null);
	}
	
	/**
	 * Constructs with the specified initial cell icon and cell height.
	 * @param cellIcon the instance of Icon
	 * @param cellHeight the cell height value
	 */
	public ElementListCellRenderer(Icon cellIcon, int cellHeight)
	{
		this((Border) null, cellIcon, cellHeight);
	}
	
	/**
	 * Constructs with the specified initial cell border and cell height.
	 * @param cellBorder the instance of Border
	 * @param cellHeight the cell height value
	 */
	public ElementListCellRenderer(Border cellBorder, int cellHeight)
	{
		this(cellBorder, null, cellHeight);
	}
	
	/**
	 * Constructs with the specified initial cell border and cell icon.
	 * @param cellBorder the instance of Border
	 * @param cellIcon the instance of Icon
	 */
	public ElementListCellRenderer(Border cellBorder, Icon cellIcon)
	{
		this(cellBorder, cellIcon, -1);
	}
	
	/**
	 * Constructs with the specified initial list and cell height.
	 * @param list the instance of JList
	 * @param cellHeight the cell height value
	 */
	public ElementListCellRenderer(JList list, int cellHeight)
	{
		this(list, (Border) null, cellHeight);
	}
	
	/**
	 * Constructs with the specified initial list and cell icon.
	 * @param list the instance of JList
	 * @param cellIcon the instance of Icon
	 */
	public ElementListCellRenderer(JList list, Icon cellIcon)
	{
		this(list, null, cellIcon);
	}
	
	/**
	 * Constructs with the specified initial list and cell border.
	 * @param list the instance of JList
	 * @param cellBorder the instance of Border
	 */
	public ElementListCellRenderer(JList list, Border cellBorder)
	{
		this(list, cellBorder, null);
	}
	
	/**
	 * Constructs with the specified initial cell border, cell icon and cell height.
	 * @param cellBorder the instance of Border
	 * @param cellIcon the instance of Icon
	 * @param cellHeight the cell height value
	 */
	public ElementListCellRenderer(Border cellBorder, Icon cellIcon, int cellHeight)
	{
		this(null, cellBorder, cellIcon, cellHeight);
	}
	
	/**
	 * Constructs with the specified initial list, cell icon and cell height.
	 * @param list the instance of JList
	 * @param cellIcon the instance of Icon
	 * @param cellHeight the cell height value
	 */
	public ElementListCellRenderer(JList list, Icon cellIcon, int cellHeight)
	{
		this(list, null, cellIcon, cellHeight);
	}
	
	/**
	 * Constructs with the specified initial list, cell border and cell height.
	 * @param list the instance of JList
	 * @param cellBorder the instance of Border
	 * @param cellHeight the cell height value
	 */
	public ElementListCellRenderer(JList list, Border cellBorder, int cellHeight)
	{
		this(list, cellBorder, null, cellHeight);
	}
	
	/**
	 * Constructs with the specified initial list, cell border and cell icon.
	 * @param list the instance of JList
	 * @param cellBorder the instance of Border
	 * @param cellIcon the instance of Icon
	 */
	public ElementListCellRenderer(JList list, Border cellBorder, Icon cellIcon)
	{
		this(list, cellBorder, cellIcon, -1);
	}
	
	/**
	 * Constructs with the specified initial list, cell border, cell icon and cell height.
	 * @param list the instance of JList
	 * @param cellBorder the instance of Border
	 * @param cellIcon the instance of Icon
	 * @param cellHeight the cell height value
	 */
	public ElementListCellRenderer(JList list, Border cellBorder, Icon cellIcon, int cellHeight)
	{
		this.list = list;
		this.cellIcon = cellIcon;
		
		setCellBorder(cellBorder);
		setCellHeight(cellHeight);
		setOpaque(true);
	}
	
	/**
	 * Gets the list.
	 * @return the instance of JList
	 */
	public JList getList()
	{
		return list;
	}
	
	/**
	 * Sets the list.
	 * @param list the instance of JList
	 */
	public void setList(JList list)
	{
		this.list = list;
	}
	
	/**
	 * Gets the cell border.
	 * @return the instance of Border
	 */
	public Border getCellBorder()
	{
		return cellBorder;
	}
	
	/**
	 * Sets the cell border.
	 * @param cellBorder the instance of Border
	 */
	public void setCellBorder(Border cellBorder)
	{
		this.cellBorder = cellBorder;
	}
	
	/**
	 * Gets the cell icon.
	 * @return the instance of Icon
	 */
	public Icon getCellIcon()
	{
		return cellIcon;
	}
	
	/**
	 * Sets the cell icon.
	 * @param cellIcon the instance of Icon
	 */
	public void setCellIcon(Icon cellIcon)
	{
		this.cellIcon = cellIcon;
	}
	
	/**
	 * Gets the cell height.
	 * @return the cell height value
	 */
	public int getCellHeight()
	{
		return cellHeight;
	}
	
	/**
	 * Sets the cell height.
	 * @param cellHeight the cell height value
	 */
	public void setCellHeight(int cellHeight)
	{
		this.cellHeight = cellHeight;
		
		if (list != null && cellHeight > 0)
		{
			list.setFixedCellHeight(cellHeight);
		}
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
		
		if (cellHeight > 0 && list.getFixedCellHeight() != cellHeight)
		{
			list.setFixedCellHeight(cellHeight);
		}
		
		if (value instanceof IElementNode)
		{
			IElementNode elementNode = (IElementNode) value;
			setText(elementNode.getText());
			if (cellIcon != null)
			{
				setIcon(cellIcon);
			}
			else
			{
				setIcon(elementNode.getIcon());
			}
			setToolTipText(elementNode.getToolTipText());
		}
		else if (value instanceof Icon)
		{
			setIcon((Icon) value);
		}
		else
		{
			if (value != null)
			{	
				setText(value.toString());
				setToolTipText(value.toString());
			}
			if (cellIcon != null)
			{
				setIcon(cellIcon);
			}
		}
		
		if (cellBorder != null)
		{	
			setBorder(BorderFactory.createCompoundBorder(super.getBorder(), cellBorder));
		}
		
		return this;
	}
}