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
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.nepxion.swing.element.IElementNode;

public class CheckBoxListCellRenderer
	extends CheckBoxCellRendererPanel implements ListCellRenderer
{
	/**
	 * The instance JList.
	 */
	private JList list;
	
	/**
	 * The cell height value.
	 */
	private int cellHeight = -1;
	
	/**
	 * The instance of JCheckBox.
	 */
	private JCheckBox checkBox;
	
	/**
	 * The instance of CellRendererLabel.
	 */
	private CellRendererLabel cellLabel;
	
	/**
	 * Constructs with the specified initial list.
	 * @param list the instance of JList
	 */
	public CheckBoxListCellRenderer(JList list)
	{
		this(list, -1);
	}
	
	/**
	 * Constructs with the specified initial list and cell height.
	 * @param list the instance of JList
	 * @param cellHeight the cell height value
	 */
	public CheckBoxListCellRenderer(JList list, int cellHeight)
	{
		this.list = list;
		
		checkBox = getCheckBox();
		cellLabel = getLabel();
		
		list.addListSelectionListener(new CheckBoxListSelectionListener());
		list.addMouseListener(new CheckBoxListMouseListener());
		
		setCellHeight(cellHeight);
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
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus)
	{
		IElementNode elementNode = (IElementNode) value;
		checkBox.setSelected(elementNode.isSelected());
		cellLabel.setText(elementNode.getText());
		cellLabel.setIcon(elementNode.getIcon());
		cellLabel.setToolTipText(elementNode.getToolTipText());
		cellLabel.setSelected(isSelected);
		cellLabel.setFont(list.getFont());
		cellLabel.setFocus(hasFocus);
		cellLabel.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
		cellLabel.setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
		
		setToolTipText(elementNode.getToolTipText());
		
		return this;
	}
	
	public class CheckBoxListSelectionListener
		implements ListSelectionListener
	{
		/**
		 * Invoked when the selection value is changed.
		 * @param e the instance of ListSelectionEvent
		 */
		public void valueChanged(ListSelectionEvent e)
		{
			adaptSelection();
		}
	}
	
	public class CheckBoxListMouseListener
		extends MouseAdapter
	{
	    /**
	     * Invoked when the mouse button has been pressed on a component.
	     * @param e the instance of MouseEvent
	     */
		public void mousePressed(MouseEvent e)
		{
			adaptSelection();
		}
	}
	
	/**
	 * Adapts the selection.
	 */
	private void adaptSelection()
	{
		int[] indexes = list.getSelectedIndices();
		if (indexes.length > 1)
		{
			boolean selected = false;
			for (int i = 0; i < indexes.length; i++)
			{
				int index = indexes[i];
				IElementNode elementNode = (IElementNode) list.getModel().getElementAt(index);
				if (i == 0)
				{
					selected = elementNode.isSelected();
				}
				elementNode.setSelected(selected);
				Rectangle rectangle = list.getCellBounds(index, index);
				list.repaint(rectangle);
			}
		}
		else
		{
			int index = list.getSelectedIndex();
			if (index > -1)
			{
				IElementNode elementNode = (IElementNode) list.getModel().getElementAt(index);
				elementNode.setSelected(!elementNode.isSelected());
				Rectangle rectangle = list.getCellBounds(index, index);
				list.repaint(rectangle);
			}
		}
	}
}