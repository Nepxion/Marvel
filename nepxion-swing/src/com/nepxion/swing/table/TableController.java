package com.nepxion.swing.table;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JTable;

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.thread.dialog.JThreadDialog;

public class TableController
{
	public static void add(JTable table, ITableAdapter tableAdapter)
	{
		if (!tableAdapter.addRowPermitted())
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("table") + SwingLocale.getString("add_record_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}	
		
		Object rowData = tableAdapter.addRow();
		if (rowData == null)
		{
			return;
		}
		
		ITableModel tableModel = TableManager.getModel(table);
		tableModel.addRow(rowData);
	}
	
	public static void modify(JTable table, ITableAdapter tableAdapter)
	{
		boolean isSingleSelection = isSingleSelection(table, SwingLocale.getString("modify") + SwingLocale.getString("record"));
		if (!isSingleSelection)
		{
			return;
		}
		
		int selectedRow = table.getSelectedRow();
		if (!tableAdapter.modifyRowPermitted(selectedRow))
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("table_row_selection") + SwingLocale.getString("modify_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		int selectedRowIndex = ((ITable) table).getRowIndexToModel(selectedRow);
		Object rowData = tableAdapter.modifyRow(selectedRowIndex);
		if (rowData == null)
		{
			return;
		}
		
		ITableModel tableModel = TableManager.getModel(table);		
		tableModel.updateRow(rowData, selectedRowIndex);
	}
	
	public static void delete(final JTable table, final ITableAdapter tableAdapter)
	{
		boolean isMultiSelection = isMultiSelection(table, SwingLocale.getString("delete") + SwingLocale.getString("record"));
		if (!isMultiSelection)
		{
			return;
		}
		
		int[] selectedRows = table.getSelectedRows();
		if (selectedRows.length == 1)
		{
			int selectedRow = selectedRows[0];
			if (!tableAdapter.deleteRowPermitted(selectedRow))
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("table_row_selection") + SwingLocale.getString("delete_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
				
				return;
			}
			
			int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(table), SwingLocale.getString("confirm_to_delete_selected_records"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
			if (selectedValue != JBasicOptionPane.YES_OPTION)
			{
				return;
			}
			
			final int selectedRowIndex = ((ITable) table).getRowIndexToModel(selectedRow);
			
			JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(table), SwingLocale.getString("delete"), SwingLocale.getString("delete_and_wait"))
			{
				protected void loadForeground(Object data)
					throws Exception
				{
					Boolean flag = (Boolean) data;
					
					if (flag.booleanValue())
					{
						ITableModel tableModel = TableManager.getModel(table);
						tableModel.deleteRow(selectedRowIndex);
						
						JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("delete_record_success"), SwingLocale.getString("information"), JBasicOptionPane.INFORMATION_MESSAGE);
					}	
				}
				
				protected Object loadBackground()
					throws Exception
				{
					return Boolean.valueOf(tableAdapter.deleteRow(selectedRowIndex));
				}
			};
			dialog.execute();
		}
		else
		{
			if (!tableAdapter.deleteRowsPermitted(selectedRows))
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("table_row_selection") + SwingLocale.getString("delete_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
				
				return;
			}
			
			int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(table), SwingLocale.getString("confirm_to_delete_selected_records"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
			if (selectedValue != JBasicOptionPane.YES_OPTION)
			{
				return;
			}
			
			final int[] selectedRowIndexes = ((ITable) table).getRowIndexesToModel(selectedRows);
			
			JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(table), SwingLocale.getString("delete"), SwingLocale.getString("delete_and_wait"))
			{
				protected void loadForeground(Object data)
					throws Exception
				{
					Boolean flag = (Boolean) data;
					
					if (flag.booleanValue())
					{
						ITableModel tableModel = TableManager.getModel(table);			
						tableModel.deleteRows(selectedRowIndexes);
						
						JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("delete_record_success"), SwingLocale.getString("information"), JBasicOptionPane.INFORMATION_MESSAGE);
					}	
				}
				
				protected Object loadBackground()
					throws Exception
				{
					return Boolean.valueOf(tableAdapter.deleteRows(selectedRowIndexes));
				}
			};
			dialog.execute();
		}
	}
	
	public static void refresh(final JTable table, final ITableAdapter tableAdapter)
	{
		if (!tableAdapter.refreshPermitted())
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("table") + SwingLocale.getString("refresh_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		if (table.getRowCount() == 0)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("no_refresh_records"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(table), SwingLocale.getString("confirm_to_refresh"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
		if (selectedValue != JBasicOptionPane.YES_OPTION)
		{
			return;
		}
		
		JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(table), SwingLocale.getString("refresh"), SwingLocale.getString("refresh_and_wait"))
		{
			protected void loadForeground(Object data)
				throws Exception
			{
				List rowDatas = (List) data;
				
				setRowDatas(table, rowDatas);
				
				// JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("refresh_record_success"), SwingLocale.getString("information"), JBasicOptionPane.INFORMATION_MESSAGE);
			}
			
			protected Object loadBackground()
				throws Exception
			{
				List rowDatas = tableAdapter.refresh();

				return rowDatas;
			}
		};
		dialog.execute();
	}
	
	public static void clear(final JTable table, final ITableAdapter tableAdapter)
	{
		if (!tableAdapter.clearPermitted())
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("table") + SwingLocale.getString("clear_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		if (table.getRowCount() == 0)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("no_clear_records"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(table), SwingLocale.getString("confirm_to_clear"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
		if (selectedValue != JBasicOptionPane.YES_OPTION)
		{
			return;
		}
		
		JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(table), SwingLocale.getString("clear"), SwingLocale.getString("clear_and_wait"))
		{
			protected void loadForeground(Object data)
				throws Exception
			{
				Boolean flag = (Boolean) data;
				
				if (flag.booleanValue())
				{
					ITableModel tableModel = TableManager.getModel(table);
					tableModel.clearRows();
				}	
			}
			
			protected Object loadBackground()
				throws Exception
			{
				return Boolean.valueOf(tableAdapter.clear());
			}
		};
		dialog.execute();
	}
	
	public static void save(final JTable table, final ITableAdapter tableAdapter)
	{
		if (!tableAdapter.savePermitted())
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("table") + SwingLocale.getString("save_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		if (table.getRowCount() == 0)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("no_save_records"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(table), SwingLocale.getString("confirm_to_save"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
		if (selectedValue != JBasicOptionPane.YES_OPTION)
		{
			return;
		}
		
		JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(table), SwingLocale.getString("save"), SwingLocale.getString("save_and_wait"))
		{
			protected void loadForeground(Object data)
				throws Exception
			{
				List rowDatas = (List) data;
				
				setRowDatas(table, rowDatas);
				
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("save_record_success"), SwingLocale.getString("information"), JBasicOptionPane.INFORMATION_MESSAGE);
			}
			
			protected Object loadBackground()
				throws Exception
			{
				List rowDatas = tableAdapter.save();

				return rowDatas;
			}
		};
		dialog.execute();
	}
	
	public static void setRowDatas(JTable table, List rowDatas)
	{		
		ITableModel tableModel = TableManager.getModel(table);
		tableModel.setRowDatas(rowDatas);
	}
	
	public static boolean isSingleSelection(JTable table, String operationName)
	{
		int[] selectedRows = table.getSelectedRows();
		if (selectedRows == null || selectedRows.length == 0)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("select_records_to") + " " + SwingLocale.getString("quotation_left") + operationName + SwingLocale.getString("quotation_right"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		
		if (selectedRows.length != 1)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("select_one_node_to") + " " + SwingLocale.getString("quotation_left") + operationName + SwingLocale.getString("quotation_right"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		
		return true;
	}
	
	public static boolean isMultiSelection(JTable table, String operationName)
	{
		int[] selectedRows = table.getSelectedRows();
		if (selectedRows == null || selectedRows.length == 0)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("select_records_to") + " " + SwingLocale.getString("quotation_left") + operationName + SwingLocale.getString("quotation_right"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		
		return true;
	}
	
	public static JSecurityAction getAddAction(final JTable table, final ITableAdapter tableAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("add"), IconFactory.getSwingIcon("stereo/add_16.png"), SwingLocale.getString("add") + SwingLocale.getString("record"))
		{
			public void execute(ActionEvent e)
			{
				add(table, tableAdapter);
			}
		};
		KeyStrokeManager.registerComponent(table, action, KeyEvent.VK_N, KeyEvent.CTRL_MASK);
		
		return action;
	}
	
	public static JSecurityAction getModifyAction(final JTable table, final ITableAdapter tableAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("modify"), IconFactory.getSwingIcon("stereo/confirm_16.png"), SwingLocale.getString("modify") + SwingLocale.getString("record"))
		{
			public void execute(ActionEvent e)
			{
				modify(table, tableAdapter);
			}
		};
		KeyStrokeManager.registerComponent(table, action, KeyEvent.VK_I, KeyEvent.CTRL_MASK);
		
		return action;
	}
	
	public static JSecurityAction getDeleteAction(final JTable table, final ITableAdapter tableAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("delete"), IconFactory.getSwingIcon("stereo/delete_16.png"), SwingLocale.getString("delete") + SwingLocale.getString("record"))
		{
			public void execute(ActionEvent e)
			{
				delete(table, tableAdapter);
			}
		};
		KeyStrokeManager.registerComponent(table, action, KeyEvent.VK_DELETE);
		
		return action;
	}
	
	public static JSecurityAction getRefreshAction(final JTable table, final ITableAdapter tableAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("refresh"), IconFactory.getSwingIcon("stereo/refresh_16.png"), SwingLocale.getString("refresh") + SwingLocale.getString("record"))
		{
			public void execute(ActionEvent e)
			{
				refresh(table, tableAdapter);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getClearAction(final JTable table, final ITableAdapter tableAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("clear"), IconFactory.getSwingIcon("stereo/delete_16.png"), SwingLocale.getString("clear") + SwingLocale.getString("record"))
		{
			public void execute(ActionEvent e)
			{
				clear(table, tableAdapter);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getSaveAction(final JTable table, final ITableAdapter tableAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("save"), IconFactory.getSwingIcon("solid_save.png"), SwingLocale.getString("save") + SwingLocale.getString("record"))
		{
			public void execute(ActionEvent e)
			{
				save(table, tableAdapter);
			}
		};
		
		return action;
	}	
}