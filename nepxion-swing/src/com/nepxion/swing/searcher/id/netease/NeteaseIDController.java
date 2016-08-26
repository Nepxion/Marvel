package com.nepxion.swing.searcher.id.netease;

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

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.thread.dialog.JThreadDialog;
import com.nepxion.util.searcher.id.netease.NeteaseIDEntity;
import com.nepxion.util.searcher.id.netease.NeteaseIDSearcher;

public class NeteaseIDController
{
	/**
	 * Gets the search action.
	 * @param panel the instance of JNeteaseIDPanel
	 * @return the instance of JSecurityAction
	 */
	public static JSecurityAction getSearchAction(final JNeteaseIDPanel panel)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("query"), IconFactory.getSwingIcon("stereo_search.png"), SwingLocale.getString("id_code_to_info"))
		{
			public void execute(ActionEvent e)
			{
				JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(panel), SwingLocale.getString("id_code_to_info"), SwingLocale.getString("query_and_wait"))
				{
					protected void loadForeground(Object data)
						throws Exception
					{
						NeteaseIDEntity entity = (NeteaseIDEntity) data;						
						if (entity == null)
						{
							JBasicOptionPane.showMessageDialog(HandleManager.getFrame(panel), SwingLocale.getString("no_records"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
							
							return;
						}
						
						NeteaseIDTableModel tableModel = (NeteaseIDTableModel) panel.getIDTable().getModel();
						tableModel.addRow(entity);
					}
					
					protected Object loadBackground()
						throws Exception
					{
						String id = panel.getID();
						if (id.equals(""))
						{
							throw new IllegalArgumentException(SwingLocale.getString("id_code_not_null"));
						}
						
						if (id.length() != 15 && id.length() != 18)
						{
							throw new IllegalArgumentException(SwingLocale.getString("id_code_length_15_or_18"));
						}
						
						NeteaseIDSearcher searcher = new NeteaseIDSearcher();
						NeteaseIDEntity entity = searcher.search(id);
						
						return entity;
					}
				};
				dialog.execute();
			}
		};
		
		return action;
	}
	
	/**
	 * Gets the clear action.
	 * @param table the instance of JNeteaseIDTable
	 * @return the instance of JSecurityAction
	 */
	public static JSecurityAction getClearAction(final JNeteaseIDTable table)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("clear"), IconFactory.getSwingIcon("stereo/delete_16.png"), SwingLocale.getString("clear_query_result"))
		{
			public void execute(ActionEvent e)
			{
				int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(table), SwingLocale.getString("confirm_to_clear_query_result"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
				if (selectedValue != JBasicOptionPane.YES_OPTION)
				{
					return;
				}
				
				NeteaseIDTableModel tableModel = (NeteaseIDTableModel) table.getModel();
				tableModel.clearRows();
			}
		};
		
		return action;
	}
}