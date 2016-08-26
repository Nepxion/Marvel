package com.nepxion.cots.twaver.graph;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.cots.twaver.locale.TLocale;
import com.nepxion.swing.menu.JBasicMenu;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;

public class TGraphPopupMenu
	extends JBasicPopupMenu
{
	private JBasicMenuItem addMenuItem;
	private JBasicMenuItem deleteMenuItem;
	private JBasicMenuItem clearMenuItem;
	private JBasicMenuItem refreshMenuItem;
	private JBasicMenuItem renameMenuItem;
	private JBasicMenuItem saveMenuItem;
	private JBasicMenuItem propertyMenuItem;
	private JBasicMenu configMenu;
	
	private TGraph graph;
	
	public TGraphPopupMenu(TGraph graph)
	{
		this.graph = graph;
	}
	
	public JBasicMenuItem getAddMenuItem()
	{
		if (addMenuItem == null)
		{
			addMenuItem = new JBasicMenuItem(TGraphController.getAddAction(graph));
		}
		
		return addMenuItem;
	}
	
	public JBasicMenuItem getDeleteMenuItem()
	{
		if (deleteMenuItem == null)
		{
			deleteMenuItem = new JBasicMenuItem(TGraphController.getDeleteAction(graph));
		}
		
		return deleteMenuItem;
	}
	
	public JBasicMenuItem getClearMenuItem()
	{
		if (clearMenuItem == null)
		{
			clearMenuItem = new JBasicMenuItem(TGraphController.getClearAction(graph));
		}
		
		return clearMenuItem;
	}
	
	public JBasicMenuItem getRefreshMenuItem()
	{
		if (refreshMenuItem == null)
		{
			refreshMenuItem = new JBasicMenuItem(TGraphController.getRefreshAction(graph));
		}
		
		return refreshMenuItem;
	}
	
	public JBasicMenuItem getRenameMenuItem()
	{
		if (renameMenuItem == null)
		{
			renameMenuItem = new JBasicMenuItem(TGraphController.getRenameAction(graph));
		}
		
		return renameMenuItem;
	}
	
	public JBasicMenuItem getSaveMenuItem()
	{
		if (saveMenuItem == null)
		{
			saveMenuItem = new JBasicMenuItem(TGraphController.getSaveAction(graph));
		}
		
		return saveMenuItem;
	}
	
	public JBasicMenuItem getPropertyMenuItem()
	{
		if (propertyMenuItem == null)
		{
			propertyMenuItem = new JBasicMenuItem(TGraphController.getPropertyAction(graph));
		}
		
		return propertyMenuItem;
	}
	
	public JBasicMenu getConfigMenu()
	{
		if (configMenu == null)
		{
			configMenu = new JBasicMenu(TLocale.getString("config"), TIconFactory.getContextIcon("config.png"), TLocale.getString("config"));
		}
		
		return configMenu;
	}
}