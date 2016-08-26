package com.nepxion.swing.shrinkbar;

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
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.renderer.list.ElementListCellRenderer;

public class ShrinkListCellRenderer
	extends ElementListCellRenderer
{
	/**
	 * Constructs with the default.
	 */
	public ShrinkListCellRenderer()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial cell height.
	 * @param cellHeight the cell height value
	 */
	public ShrinkListCellRenderer(int cellHeight)
	{
		super(cellHeight);
	}
	
	/**
	 * Constructs with the specified initial cell icon.
	 * @param cellIcon the instance of Icon
	 */
	public ShrinkListCellRenderer(Icon cellIcon)
	{
		super(cellIcon);
	}
	
	/**
	 * Constructs with the specified initial cell border.
	 * @param cellBorder the instance of Border
	 */
	public ShrinkListCellRenderer(Border cellBorder)
	{
		super(cellBorder);
	}
	
	/**
	 * Constructs with the specified initial list.
	 * @param list the instance of JList
	 */
	public ShrinkListCellRenderer(JList list)
	{
		super(list);
	}
	
	/**
	 * Constructs with the specified initial cell icon and cell height.
	 * @param cellIcon the instance of Icon
	 * @param cellHeight the cell height value
	 */
	public ShrinkListCellRenderer(Icon cellIcon, int cellHeight)
	{
		super(cellIcon, cellHeight);
	}
	
	/**
	 * Constructs with the specified initial cell border and cell height.
	 * @param cellBorder the instance of Border
	 * @param cellHeight the cell height value
	 */
	public ShrinkListCellRenderer(Border cellBorder, int cellHeight)
	{
		super(cellBorder, cellHeight);
	}
	
	/**
	 * Constructs with the specified initial cell border and cell icon.
	 * @param cellBorder the instance of Border
	 * @param cellIcon the instance of Icon
	 */
	public ShrinkListCellRenderer(Border cellBorder, Icon cellIcon)
	{
		super(cellBorder, cellIcon);
	}
	
	/**
	 * Constructs with the specified initial list and cell height.
	 * @param list the instance of JList
	 * @param cellHeight the cell height value
	 */
	public ShrinkListCellRenderer(JList list, int cellHeight)
	{
		super(list, cellHeight);
	}
	
	/**
	 * Constructs with the specified initial list and cell icon.
	 * @param list the instance of JList
	 * @param cellIcon the instance of Icon
	 */
	public ShrinkListCellRenderer(JList list, Icon cellIcon)
	{
		super(list, cellIcon);
	}
	
	/**
	 * Constructs with the specified initial list and cell border.
	 * @param list the instance of JList
	 * @param cellBorder the instance of Border
	 */
	public ShrinkListCellRenderer(JList list, Border cellBorder)
	{
		super(list, cellBorder);
	}
	
	/**
	 * Constructs with the specified initial cell border, cell icon and cell height.
	 * @param cellBorder the instance of Border
	 * @param cellIcon the instance of Icon
	 * @param cellHeight the cell height value
	 */
	public ShrinkListCellRenderer(Border cellBorder, Icon cellIcon, int cellHeight)
	{
		super(cellBorder, cellIcon, cellHeight);
	}
	
	/**
	 * Constructs with the specified initial list, cell icon and cell height.
	 * @param list the instance of JList
	 * @param cellIcon the instance of Icon
	 * @param cellHeight the cell height value
	 */
	public ShrinkListCellRenderer(JList list, Icon cellIcon, int cellHeight)
	{
		super(list, cellIcon, cellHeight);
	}
	
	/**
	 * Constructs with the specified initial list, cell border and cell height.
	 * @param list the instance of JList
	 * @param cellBorder the instance of Border
	 * @param cellHeight the cell height value
	 */
	public ShrinkListCellRenderer(JList list, Border cellBorder, int cellHeight)
	{
		super(list, cellBorder, cellHeight);
	}
	
	/**
	 * Constructs with the specified initial list, cell border and cell icon.
	 * @param list the instance of JList
	 * @param cellBorder the instance of Border
	 * @param cellIcon the instance of Icon
	 */
	public ShrinkListCellRenderer(JList list, Border cellBorder, Icon cellIcon)
	{
		super(list, cellBorder, cellIcon);
	}
	
	/**
	 * Constructs with the specified initial list, cell border, cell icon and cell height.
	 * @param list the instance of JList
	 * @param cellBorder the instance of Border
	 * @param cellIcon the instance of Icon
	 * @param cellHeight the cell height value
	 */
	public ShrinkListCellRenderer(JList list, Border cellBorder, Icon cellIcon, int cellHeight)
	{
		super(list, cellBorder, cellIcon, cellHeight);
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
		
		BasicShrinkBar shrinkBar = (BasicShrinkBar) HandleManager.getComponent(list, BasicShrinkBar.class);
		if (shrinkBar != null && shrinkBar.isShrinkable())
		{
			if (shrinkBar.isShrinked())
			{
				setText(null);
				setBorder(null);
				setHorizontalAlignment(SwingConstants.CENTER);
			}
			else
			{
				setHorizontalAlignment(SwingConstants.LEADING);
			}
		}
		
		return this;
	}
}