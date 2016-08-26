package com.nepxion.swing.editor.table;

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
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.nepxion.swing.selector.button.JClassicSelectorMenuButton;
import com.nepxion.swing.selector.checkbox.JCheckBoxSelectorBar;

public class CheckBoxTableCellEditor
	extends AbstractCellEditor implements TableCellEditor
{
	/**
	 * The instance of JCheckBoxSelectorBar.
	 */
	private JCheckBoxSelectorBar checkBoxSelectorBar;
	
	/**
	 * Constructs with the specified initial all element nodes.
	 * @param allElementNodes the instance of List
	 */
	public CheckBoxTableCellEditor(List allElementNodes)
	{
		checkBoxSelectorBar = new JCheckBoxSelectorBar(allElementNodes, true);

		JClassicSelectorMenuButton menuButton = (JClassicSelectorMenuButton) checkBoxSelectorBar.getMenuButton();
		menuButton.setShowArrow(false);
	}
	
	/**
	 * Constructs with the specified initial check box selector bar.
	 * @param checkBoxSelectorBar the instance of JCheckBoxSelectorBar
	 */
	public CheckBoxTableCellEditor(JCheckBoxSelectorBar checkBoxSelectorBar)
	{
		this.checkBoxSelectorBar = checkBoxSelectorBar;
	}
	
	/**
	 * Returns true if the cell is editable.
	 * @param e the instance of EventObject
	 */
	public boolean isCellEditable(EventObject e)
	{
		if (e instanceof MouseEvent)
		{
			MouseEvent mouseEvent = (MouseEvent) e;
			
			return mouseEvent.getClickCount() >= 2;
		}
		
		return true;
	}
	
	/**
	 * Gets the cell editor value.
	 * @param the cell editor value
	 */
	public Object getCellEditorValue()
	{
		return checkBoxSelectorBar.getValue();
	}
	
	/**
	 * Gets the table cell editor component.
	 * @param table the instance of JTable
	 * @param value the value object
	 * @param isSelected the boolean of isSelected
	 * @param row the row index value
	 * @param column the column index value
	 */
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
	{
		checkBoxSelectorBar.setValue(value);
		
		return checkBoxSelectorBar;
	}
}