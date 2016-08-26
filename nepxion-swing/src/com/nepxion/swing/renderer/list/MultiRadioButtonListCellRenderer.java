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

import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.ListCellRenderer;

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.locale.SwingLocale;

public class MultiRadioButtonListCellRenderer
	extends MultiRadioButtonCellRendererPanel implements ListCellRenderer
{
	/**
	 * The instance of JList.
	 */
	private JList list;
	
	/**
	 * The cell height value.
	 */
	private int cellHeight = -1;
	
	/**
	 * The ignored radio button.
	 */
	private JRadioButton ignoredRadioButton;
	
	/**
	 * The contained radio button.
	 */
	private JRadioButton containedRadioButton;
	
	/**
	 * The not contained radio button.
	 */
	private JRadioButton notContainedRadioButton;
	
	/**
	 * The instance of CellRendererLabel.
	 */
	private CellRendererLabel cellLabel;
	
	/**
	 * Constructs with the specified initial list.
	 * @param list the instance of JList
	 */
	public MultiRadioButtonListCellRenderer(JList list)
	{
		this(list, -1);
	}
	
	/**
	 * Constructs with the specified initial list and cell height.
	 * @param list the instance of JList
	 * @param cellHeight the cell height value
	 */
	public MultiRadioButtonListCellRenderer(JList list, int cellHeight)
	{
		this(list, cellHeight, SwingLocale.getString("select_ignored"), SwingLocale.getString("select_contained"), SwingLocale.getString("select_not_contained"));
	}
	
	/**
	 * Constructs with the specified initial list, ignored text, contained text and not contained text.
	 * @param list the instance of JList
	 * @param ignoredText the ignored text string
	 * @param containedText the contained text string
	 * @param notContainedText the not contained text string
	 */
	public MultiRadioButtonListCellRenderer(JList list, String ignoredText, String containedText, String notContainedText)
	{
		this(list, -1, ignoredText, containedText, notContainedText);
	}
	
	/**
	 * Constructs with the specified initial list, cell height, ignored text, contained text and not contained text.
	 * @param list the instance of JList
	 * @param cellHeight the cell height value 
	 * @param ignoredText the ignored text string
	 * @param containedText the contained text string
	 * @param notContainedText the not contained text string
	 */
	public MultiRadioButtonListCellRenderer(JList list, int cellHeight, String ignoredText, String containedText, String notContainedText)
	{
		super(ignoredText, containedText, notContainedText);
		
		this.list = list;
		
		cellLabel = getLabel();
		ignoredRadioButton = getIgnoredRadioButton();
		containedRadioButton = getContainedRadioButton();
		notContainedRadioButton = getNotContainedRadioButton();
		
		list.addMouseListener(new RadioButtonListMouseListener());
		
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

		switch (elementNode.getSelectedIndex())
		{
			case IElementNode.SELECTION_INDEX_IGNORED :
			{
				ignoredRadioButton.setSelected(true);
				break;
			}
			case IElementNode.SELECTION_INDEX_CONTAINED :
			{
				containedRadioButton.setSelected(true);
				break;
			}	
			case IElementNode.SELECTION_INDEX_NOT_CONTAINED :
			{
				notContainedRadioButton.setSelected(true);
				break;
			}
			default :
			{
				ignoredRadioButton.setSelected(true);
				break;
			}
		}
		
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
	
	public class RadioButtonListMouseListener
		extends MouseAdapter
	{
		/**
		 * Invoked when the selection value is changed.
		 * @param e the instance of ListSelectionEvent
		 */
		public void mousePressed(MouseEvent e)
		{
			adaptSelection(e.getX());
		}
	}
	
	/**
	 * Adapts the selection.
	 * @param x the x value
	 */
	private void adaptSelection(int x)
	{
		int index = list.getSelectedIndex();
		if (index > -1)
		{			
			int selectedRadioIndex = getSelectedRadioIndex(x);
			if (selectedRadioIndex > -1)
			{	
				IElementNode elementNode = (IElementNode) list.getModel().getElementAt(index);
				elementNode.setSelectedIndex(selectedRadioIndex);
				Rectangle rectangle = list.getCellBounds(index, index);
				list.repaint(rectangle);
			}
		}
	}
}