package com.nepxion.swing.searcher.ip.netease;

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
import com.nepxion.util.searcher.ip.netease.NeteaseIPEntity;
import com.nepxion.util.searcher.ip.netease.NeteaseIPSearcher;

public class NeteaseIPController
{
	/**
	 * Gets the search action.
	 * @param panel the instance of JNeteaseIPPanel
	 * @return the instance of JSecurityAction
	 */
	public static JSecurityAction getSearchAction(final JNeteaseIPPanel panel)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("query"), IconFactory.getSwingIcon("stereo_search.png"), SwingLocale.getString("ip_to_address"))
		{
			public void execute(ActionEvent e)
			{
				JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(panel), SwingLocale.getString("ip_to_address"), SwingLocale.getString("query_and_wait"))
				{
					protected void loadForeground(Object data)
						throws Exception
					{
						NeteaseIPEntity entity = (NeteaseIPEntity) data;
						if (entity == null)
						{
							JBasicOptionPane.showMessageDialog(HandleManager.getFrame(panel), SwingLocale.getString("no_records"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
							
							return;
						}						
						
						NeteaseIPTableModel tableModel = (NeteaseIPTableModel) panel.getIPTable().getModel();
						tableModel.addRow(entity);
					}
					
					protected Object loadBackground()
						throws Exception
					{
						String ip = panel.getIP();
						if (ip.equals(""))
						{
							throw new IllegalArgumentException(SwingLocale.getString("ip_not_null"));
						}
						
						NeteaseIPSearcher searcher = new NeteaseIPSearcher();
						NeteaseIPEntity entity = searcher.search(ip);
						
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
	 * @param table the instance of JNeteaseIPTable
	 * @return the instance of JSecurityAction
	 */
	public static JSecurityAction getClearAction(final JNeteaseIPTable table)
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
				
				NeteaseIPTableModel tableModel = (NeteaseIPTableModel) table.getModel();
				tableModel.clearRows();
			}
		};
		
		return action;
	}
}