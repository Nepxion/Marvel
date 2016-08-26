package com.nepxion.swing.searcher.gis.google.loc;

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
import com.nepxion.util.searcher.gis.google.loc.LocEntity;
import com.nepxion.util.searcher.gis.google.loc.LocSearcher;

public class LocController
{
	/**
	 * Gets the search action.
	 * @param panel the instance of JCoordinatePanel
	 * @return the instance of JSecurityAction
	 */
	public static JSecurityAction getSearchAction(final JCoordinatePanel panel)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("query"), IconFactory.getSwingIcon("stereo_search.png"), SwingLocale.getString("geo_to_address"))
		{
			public void execute(ActionEvent e)
			{
				JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(panel), SwingLocale.getString("geo_to_address"), SwingLocale.getString("query_and_wait"))
				{
					protected void loadForeground(Object data)
						throws Exception
					{
						LocEntity entity = (LocEntity) data;						
						if (entity == null)
						{
							JBasicOptionPane.showMessageDialog(HandleManager.getFrame(panel), SwingLocale.getString("no_records"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
							
							return;
						}	
						
						LocTableModel tableModel = (LocTableModel) panel.getLocTable().getModel();
						tableModel.addRow(entity);
					}
					
					protected Object loadBackground()
						throws Exception
					{
						double latitude = 0;
						double longitude = 0;
						try
						{
							latitude = panel.getLatitude();
							longitude = panel.getLongitude();
						}
						catch (Exception e)
						{
							throw new IllegalArgumentException(SwingLocale.getString("number_not_null_or_non_number"), e);
						}
						String language = panel.getLanguage();
						
						LocSearcher searcher = new LocSearcher(language);
						LocEntity entity = searcher.search(latitude, longitude);
						
						return entity;
					}
				};
				dialog.execute();
			}
		};
		
		return action;
	}
	
	/**
	 * Gets the search action.
	 * @param panel the instance of JCellPanel
	 * @return the instance of JSecurityAction
	 */
	public static JSecurityAction getSearchAction(final JCellPanel panel)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("query"), IconFactory.getSwingIcon("stereo_search.png"), SwingLocale.getString("mobile_to_address"))
		{
			public void execute(ActionEvent e)
			{
				JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(panel), SwingLocale.getString("mobile_to_address"), SwingLocale.getString("query_and_wait"))
				{
					protected void loadForeground(Object data)
						throws Exception
					{
						LocEntity entity = (LocEntity) data;
						if (entity == null)
						{
							JBasicOptionPane.showMessageDialog(HandleManager.getFrame(panel), SwingLocale.getString("no_records"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
							
							return;
						}						
						
						LocTableModel tableModel = (LocTableModel) panel.getLocTable().getModel();
						tableModel.addRow(entity);
					}
					
					protected Object loadBackground()
						throws Exception
					{
						int cellID = 0;
						int lac = 0;
						int mcc = 0;
						int mnc = 0;
						try
						{
							cellID = panel.getCellID();
							lac = panel.getLac();
							mcc = panel.getMcc();
							mnc = panel.getMnc();
						}
						catch (Exception e)
						{
							throw new IllegalArgumentException(SwingLocale.getString("number_not_null_or_non_number"), e);
						}
						String language = panel.getLanguage();
						
						LocSearcher searcher = new LocSearcher(language);
						LocEntity entity = searcher.search(cellID, lac, mcc, mnc);
						
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
	 * @param table the instance of JLocTable
	 * @return the instance of JSecurityAction
	 */
	public static JSecurityAction getClearAction(final JLocTable table)
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
				
				LocTableModel tableModel = (LocTableModel) table.getModel();
				tableModel.clearRows();
			}
		};
		
		return action;
	}
}