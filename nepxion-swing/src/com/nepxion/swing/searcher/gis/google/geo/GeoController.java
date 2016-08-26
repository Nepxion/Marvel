package com.nepxion.swing.searcher.gis.google.geo;

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
import java.util.List;

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.thread.dialog.JThreadDialog;
import com.nepxion.util.searcher.gis.google.geo.GeoSearcher;

public class GeoController
{
	/**
	 * Gets the search action.
	 * @param panel the instance of JGeoPanel
	 * @return the instance of JSecurityAction
	 */
	public static JSecurityAction getSearchAction(final JGeoPanel panel)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("query"), IconFactory.getSwingIcon("stereo_search.png"), SwingLocale.getString("address_to_geo"))
		{
			public void execute(ActionEvent e)
			{
				JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(panel), SwingLocale.getString("address_to_geo"), SwingLocale.getString("query_and_wait"))
				{
					protected void loadForeground(Object data)
						throws Exception
					{
						List entityList = (List) data;						
						if (entityList == null || entityList.isEmpty())
						{
							JBasicOptionPane.showMessageDialog(HandleManager.getFrame(panel), SwingLocale.getString("no_records"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
							
							return;
						}	
						
						GeoTableModel tableModel = (GeoTableModel) panel.getGeoTable().getModel();
						tableModel.setRowDatas(entityList);
					}
					
					protected Object loadBackground()
						throws Exception
					{
						String address = panel.getAddress();
						if (address.equals(""))
						{
							throw new IllegalArgumentException(SwingLocale.getString("address_description"));
						}
						
						GeoSearcher searcher = new GeoSearcher();
						List entityList = searcher.search(address);
						
						return entityList;
					}
				};
				dialog.execute();
			}
		};
		
		return action;
	}
	
	/**
	 * Gets the clear action.
	 * @param table the instance of JGeoTable
	 * @return the instance of JSecurityAction
	 */
	public static JSecurityAction getClearAction(final JGeoTable table)
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
				
				GeoTableModel tableModel = (GeoTableModel) table.getModel();
				tableModel.clearRows();
			}
		};
		
		return action;
	}
}