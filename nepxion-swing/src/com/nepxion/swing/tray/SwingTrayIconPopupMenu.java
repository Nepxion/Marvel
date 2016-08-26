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

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jeans.trayicon.SwingTrayPopup;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.PopupMenuPainter;

public class SwingTrayIconPopupMenu
	extends SwingTrayPopup implements ITrayIconPopupMenu
{
	/**
	 * The instance of JTray.
	 */
	private JTray tray;
	
	/**
	 * The restore menu item.
	 */
	private JBasicMenuItem restoreMenuItem;
	
	/**
	 * The instance of PopupMenuPainter.
	 */
	public PopupMenuPainter painter;
	
	/**
	 * The popup menu title string.
	 */
	private String title;
	
	/**
	 * Constructs with the specified initial tray and title.
	 * @param tray the instance of JTray
	 * @param title the popup menu title string
	 */
	public SwingTrayIconPopupMenu(JTray tray, String title)
	{
		this.tray = tray;
		this.title = title;
		
		initPopupMenu();
	}
	
	/**
	 * Initializes the popup menu.
	 */
	private void initPopupMenu()
	{
		restoreMenuItem = new JBasicMenuItem(SwingLocale.getString("hide_window"), IconFactory.getSwingIcon("tray_hidden.png"), SwingLocale.getString("hide_window"));
		restoreMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tray.restore();
			}
		}
		);
		add(restoreMenuItem);
		
		addSeparator();
		
		JBasicMenuItem aboutMenuItem = new JBasicMenuItem(SwingLocale.getString("about_system"), IconFactory.getSwingIcon("about.png"), SwingLocale.getString("about_system"));
		aboutMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tray.about();
			}
		}
		);
		add(aboutMenuItem);
		
		addSeparator();
		
		JBasicMenuItem exitMenuItem = new JBasicMenuItem(SwingLocale.getString("exit"), IconFactory.getBlankIcon(), SwingLocale.getString("exit"));
		exitMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tray.exit();
			}
		}
		);
		add(exitMenuItem);
		
		PopupMenuPainter painter = new PopupMenuPainter(title);
		setPainter(painter);
	}
	
	/**
	 * Gets the painter.
	 * @return the instance of PopupMenuPainter
	 */
	public PopupMenuPainter getPainter()
	{
		return painter;
	}
	
	/**
	 * Sets the painter.
	 * @param painter the instance of PopupMenuPainter
	 */
	public void setPainter(PopupMenuPainter painter)
	{
		this.painter = painter;
		this.painter.setPopupMenu(this);
	}
	
	/**
	 * Gets the insets.
	 * @return the instance of Insets.
	 */
	public Insets getInsets()
	{
		Insets insets = super.getInsets();
		
		if (painter != null)
		{
			return painter.getInsets((Insets) insets.clone());
		}
		else
		{
			return insets;
		}
	}
	
	/**
	 * Paints the component.
	 * @param g the instance of Graphics
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if (painter != null)
		{
			painter.paintComponent(g);
		}
	}
	
	/**
	 * Restores the popup menu.
	 * @param flag the boolean value of flag
	 */
	public void restore(boolean flag)
	{
		String text = SwingLocale.getString("hide_window");
		String icon = "tray_hidden.png";
		if (!flag)
		{
			text = SwingLocale.getString("show_window");
			icon = "tray_show.png";
		}
		restoreMenuItem.setText(text);
		restoreMenuItem.setIcon(IconFactory.getSwingIcon(icon));
	}
}