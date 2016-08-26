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
import javax.swing.JSeparator;
import javax.swing.border.Border;

import com.nepxion.swing.element.IElementNode;

public class GroupComboBoxCellRenderer
	extends ElementComboBoxCellRenderer
{
	/**
	 * The separator string.
	 */
	public static final String SEPARATOR = "#Separator"; // Item的Text可能为"Separator"， 故在前面加个#， 以做特殊标志位区分
	
	/**
	 * The instance of JSeparator.
	 */
	private JSeparator separator;
	
	/**
	 * Constructs with the default.
	 */
	public GroupComboBoxCellRenderer()
	{
		super();
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
	}
	
	/**
	 * Constructs with the specified initial cell height.
	 * @param cellHeight the cell height value
	 */
	public GroupComboBoxCellRenderer(int cellHeight)
	{
		super(cellHeight);
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
	}
	
	/**
	 * Constructs with the specified initial cell icon.
	 * @param cellIcon the instance of Icon
	 */
	public GroupComboBoxCellRenderer(Icon cellIcon)
	{
		super(cellIcon);
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
	}
	
	/**
	 * Constructs with the specified initial cell border.
	 * @param cellBorder the instance of Border
	 */
	public GroupComboBoxCellRenderer(Border cellBorder)
	{
		super(cellBorder);
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
	}
	
	/**
	 * Constructs with the specified initial cell icon and cell height.
	 * @param cellIcon the instance of Icon
	 * @param cellHeight the cell height value
	 */
	public GroupComboBoxCellRenderer(Icon cellIcon, int cellHeight)
	{
		super(cellIcon, cellHeight);
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
	}
	
	/**
	 * Constructs with the specified initial cell border and cell height.
	 * @param cellBorder the instance of Border
	 * @param cellHeight the cell height
	 */
	public GroupComboBoxCellRenderer(Border cellBorder, int cellHeight)
	{
		super(cellBorder, cellHeight);
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
	}
	
	/**
	 * Constructs with the specified initial cell border and cell icon.
	 * @param cellBorder the instance of Border
	 * @param cellIcon the instance of Icon
	 */
	public GroupComboBoxCellRenderer(Border cellBorder, Icon cellIcon)
	{
		super(cellBorder, cellIcon);
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
	}
	
	/**
	 * Constructs with the specified initial cell border, cell icon and cell height.
	 * @param cellBorder the instance of Border 
	 * @param cellIcon the instance of Icon
	 * @param cellHeight the cell height value
	 */
	public GroupComboBoxCellRenderer(Border cellBorder, Icon cellIcon, int cellHeight)
	{
		super(cellBorder, cellIcon, cellHeight);
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
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
		
		if (value instanceof IElementNode)
		{
			IElementNode elementNode = (IElementNode) value;
			/*if (!elementNode.isEnabled())
			{
				setForeground(UIManager.getColor("Label.disabledForeground"));
			}*/
			
			setEnabled(elementNode.isEnabled());
		}
		
		if (value.toString().equals(SEPARATOR))
		{
			return separator;
		}
		
		return this;
	}
}