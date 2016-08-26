package com.nepxion.swing.table.editableheader;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.DefaultCellEditor;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import com.nepxion.swing.textfield.JBasicTextField;

public class EditableHeaderTableColumn
	extends TableColumn
{
	protected TableCellEditor headerEditor;
	protected boolean isHeaderEditable;
	
	public EditableHeaderTableColumn()
	{
		setHeaderEditor(createDefaultHeaderEditor());
		isHeaderEditable = true;
	}
	
	public void setHeaderEditor(TableCellEditor headerEditor)
	{
		this.headerEditor = headerEditor;
	}
	
	public TableCellEditor getHeaderEditor()
	{
		return headerEditor;
	}
	
	public void setHeaderEditable(boolean isEditable)
	{
		isHeaderEditable = isEditable;
	}
	
	public boolean isHeaderEditable()
	{
		return isHeaderEditable;
	}
	
	public void copyValues(TableColumn base)
	{
		modelIndex = base.getModelIndex();
		identifier = base.getIdentifier();
		width = base.getWidth();
		minWidth = base.getMinWidth();
		setPreferredWidth(base.getPreferredWidth());
		maxWidth = base.getMaxWidth();
		headerRenderer = base.getHeaderRenderer();
		headerValue = base.getHeaderValue();
		cellRenderer = base.getCellRenderer();
		cellEditor = base.getCellEditor();
		isResizable = base.getResizable();
	}
	
	protected TableCellEditor createDefaultHeaderEditor()
	{
		return new DefaultCellEditor(new JBasicTextField());
	}
}