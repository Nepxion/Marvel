package com.nepxion.swing.tray;

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
import java.awt.event.ActionListener;

import com.jeans.trayicon.TrayIconPopup;
import com.jeans.trayicon.TrayIconPopupSeparator;
import com.jeans.trayicon.TrayIconPopupSimpleItem;
import com.nepxion.swing.locale.SwingLocale;

public class AwtTrayIconPopupMenu
	extends TrayIconPopup implements ITrayIconPopupMenu
{
	/**
	 * The instance of JTray.
	 */
	private JTray tray;
	
	/**
	 * The restore menu item.
	 */
	private TrayIconPopupSimpleItem restoreMenuItem;
	
	/**
	 * Constructs with the specified initial tray.
	 * @param tray the instance of JTray
	 */
	public AwtTrayIconPopupMenu(JTray tray)
	{
		this.tray = tray;
		
		initPopupMenu();
	}
	
	/**
	 * Initializes the popup menu.
	 */
	private void initPopupMenu()
	{
		restoreMenuItem = new TrayIconPopupSimpleItem(SwingLocale.getString("show_and_hide_window"));
		// restoreMenuItem.setDefault(true);
		restoreMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tray.restore();
			}
		}
		);
		addMenuItem(restoreMenuItem);
		
		addMenuItem(new TrayIconPopupSeparator());
		
		TrayIconPopupSimpleItem aboutMenuItem = new TrayIconPopupSimpleItem(SwingLocale.getString("about_system"));
		aboutMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tray.about();
			}
		}
		);
		addMenuItem(aboutMenuItem);
		
		addMenuItem(new TrayIconPopupSeparator());
		
		TrayIconPopupSimpleItem exitMenuItem = new TrayIconPopupSimpleItem(SwingLocale.getString("exit"));
		exitMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tray.exit();
			}
		}
		);
		addMenuItem(exitMenuItem);
	}
	
	/**
	 * Restores the popup menu.
	 * @param flag the boolean value of flag
	 */
	public void restore(boolean flag)
	{
	}
}