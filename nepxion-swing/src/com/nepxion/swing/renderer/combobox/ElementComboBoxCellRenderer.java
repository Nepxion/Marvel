package com.nepxion.swing.renderer.combobox;

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
import javax.swing.JList;
import javax.swing.border.Border;

import com.nepxion.swing.renderer.list.ElementListCellRenderer;

public class ElementComboBoxCellRenderer
	extends ElementListCellRenderer
{
	/**
	 * Constructs with the default.
	 */
	public ElementComboBoxCellRenderer()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial cell height.
	 * @param cellHeight the cell height value
	 */
	public ElementComboBoxCellRenderer(int cellHeight)
	{
		super(cellHeight);
	}
	
	/**
	 * Constructs with the specified initial cell icon.
	 * @param cellIcon the instance of Icon
	 */
	public ElementComboBoxCellRenderer(Icon cellIcon)
	{
		super(cellIcon);
	}
	
	/**
	 * Constructs with the specified initial cell border.
	 * @param cellBorder the instance of Border
	 */
	public ElementComboBoxCellRenderer(Border cellBorder)
	{
		super(cellBorder);
	}
	
	/**
	 * Constructs with the specified initial cell icon and cell height.
	 * @param cellIcon the instance of Icon
	 * @param cellHeight the cell height value
	 */
	public ElementComboBoxCellRenderer(Icon cellIcon, int cellHeight)
	{
		super(cellIcon, cellHeight);
	}
	
	/**
	 * Constructs with the specified initial cell border and cell height.
	 * @param cellBorder the instance of Border
	 * @param cellHeight the cell height
	 */
	public ElementComboBoxCellRenderer(Border cellBorder, int cellHeight)
	{
		super(cellBorder, cellHeight);
	}
	
	/**
	 * Constructs with the specified initial cell border and cell icon.
	 * @param cellBorder the instance of Border
	 * @param cellIcon the instance of Icon
	 */
	public ElementComboBoxCellRenderer(Border cellBorder, Icon cellIcon)
	{
		super(cellBorder, cellIcon);
	}
	
	/**
	 * Constructs with the specified initial cell border, cell icon and cell height.
	 * @param cellBorder the instance of Border 
	 * @param cellIcon the instance of Icon
	 * @param cellHeight the cell height value
	 */
	public ElementComboBoxCellRenderer(Border cellBorder, Icon cellIcon, int cellHeight)
	{
		super(cellBorder, cellIcon, cellHeight);
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
		
		if (value != null)
		{
			list.setToolTipText(value.toString());
		}
		
		return this;
	}
}