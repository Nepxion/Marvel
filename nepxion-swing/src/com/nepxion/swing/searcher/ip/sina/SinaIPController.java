package com.nepxion.swing.searcher.ip.sina;

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
import com.nepxion.util.searcher.ip.sina.SinaIPEntity;
import com.nepxion.util.searcher.ip.sina.SinaIPSearcher;

public class SinaIPController
{
	/**
	 * Gets the search action.
	 * @param panel the instance of JSinaIPPanel
	 * @return the instance of JSecurityAction
	 */
	public static JSecurityAction getSearchAction(final JSinaIPPanel panel)
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
						SinaIPEntity entity = (SinaIPEntity) data;
						if (entity == null)
						{
							JBasicOptionPane.showMessageDialog(HandleManager.getFrame(panel), SwingLocale.getString("no_records"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
							
							return;
						}						
						
						SinaIPTableModel tableModel = (SinaIPTableModel) panel.getIPTable().getModel();
						tableModel.addRow(entity);
					}
					
					protected Object loadBackground()
						throws Exception
					{
						String ip = panel.getIP();
						
						SinaIPSearcher searcher = new SinaIPSearcher();
						SinaIPEntity entity = null;
						if (ip.equals(""))
						{
							entity = searcher.search();
						}
						else
						{
							entity = searcher.search(ip);
						}
						
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
	 * @param table the instance of JSinaIPTable
	 * @return the instance of JSecurityAction
	 */
	public static JSecurityAction getClearAction(final JSinaIPTable table)
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
				
				SinaIPTableModel tableModel = (SinaIPTableModel) table.getModel();
				tableModel.clearRows();
			}
		};
		
		return action;
	}
}