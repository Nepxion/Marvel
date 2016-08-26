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

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.nepxion.swing.searcher.zone.local.JZoneSelectorPanel;
import com.nepxion.swing.selector.button.JClassicSelectorMenuButton;

public class ZoneTableCellEditor
	extends AbstractCellEditor implements TableCellEditor
{
	/**
	 * The instance of JZoneSelectorPanel.
	 */
	private JZoneSelectorPanel zoneSelectorPanel;
	
	/**
	 * Constructs with the default.
	 */
	public ZoneTableCellEditor()
	{
		zoneSelectorPanel = new JZoneSelectorPanel(true);
		
		JClassicSelectorMenuButton menuButton = (JClassicSelectorMenuButton) zoneSelectorPanel.getMenuButton();
		menuButton.setShowArrow(false);
	}
	
	/**
	 * Constructs with the specified initial maximum length.
	 * @param maximumLength the maximum length value
	 */
	public ZoneTableCellEditor(int maximumLength)
	{
		zoneSelectorPanel = new JZoneSelectorPanel(maximumLength, true);
		
		JClassicSelectorMenuButton menuButton = (JClassicSelectorMenuButton) zoneSelectorPanel.getMenuButton();
		menuButton.setShowArrow(false);
	}
	
	/**
	 * Constructs with the specified initial zone selector panel.
	 * @param zoneSelectorPanel
	 */
	public ZoneTableCellEditor(JZoneSelectorPanel zoneSelectorPanel)
	{
		this.zoneSelectorPanel = zoneSelectorPanel;
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
		return zoneSelectorPanel.getValue();
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
		zoneSelectorPanel.setValue(value);
		
		return zoneSelectorPanel;
	}
}