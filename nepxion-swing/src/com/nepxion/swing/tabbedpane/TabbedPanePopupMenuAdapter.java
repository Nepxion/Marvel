package com.nepxion.swing.tabbedpane;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPopupMenu;

import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.selector.checkbox.JCheckBoxSelector;

public class TabbedPanePopupMenuAdapter
{
	/**
	 * The close menu item.
	 */
	private JBasicMenuItem closeMenuItem;
	
	/**
	 * The close all menu item.
	 */
	private JBasicMenuItem closeAllMenuItem;
	
	/**
	 * The close others menu item.
	 */
	private JBasicMenuItem closeOthersMenuItem;
	
	/**
	 * The close selected menu item.
	 */
	private JBasicMenuItem closeSelectedMenuItem;
	
	/**
	 * The instance of JCheckBoxSelector.
	 */
	private JCheckBoxSelector checkBoxSelector;
	
	/**
	 * The instance of ITabbedPane.
	 */
	private ITabbedPane tabbedPane;
	
	/**
	 * Constructs with the specified initial tabbed pane and popup menu.
	 * @param tabbedPane the instance of ITabbedPane
	 * @param popupMenu the instance of JPopupMenu
	 */
	public TabbedPanePopupMenuAdapter(final ITabbedPane tabbedPane, JPopupMenu popupMenu)
	{
		this.tabbedPane = tabbedPane;
		
		closeMenuItem = new JBasicMenuItem(IconFactory.getSwingIcon("item_close.png"));
		closeMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int selectedIndex = tabbedPane.getSelectedIndex();
				tabbedPane.removeTabAt(selectedIndex);
			}
		}
		);
		popupMenu.add(closeMenuItem);
		
		closeAllMenuItem = new JBasicMenuItem(SwingLocale.getString("close_all"), IconFactory.getSwingIcon("item_close_all.png"), SwingLocale.getString("close_all"));
		closeAllMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame((Component) tabbedPane), SwingLocale.getString("confirm_to_close_all_tabs"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
				if (selectedValue != JBasicOptionPane.YES_OPTION)
				{
					return;
				}
				
				tabbedPane.removeAllTabs();
			}
		}
		);
		popupMenu.add(closeAllMenuItem);
		
		closeOthersMenuItem = new JBasicMenuItem(IconFactory.getBlankIcon());
		closeOthersMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame((Component) tabbedPane), SwingLocale.getString("confirm_to_close_others_tabs"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
				if (selectedValue != JBasicOptionPane.YES_OPTION)
				{
					return;
				}
				
				int selectedIndex = tabbedPane.getSelectedIndex();
				tabbedPane.removeReverseTabsAt(selectedIndex);
			}
		}
		);
		popupMenu.add(closeOthersMenuItem);
		
		closeSelectedMenuItem = new JBasicMenuItem(SwingLocale.getString("close_selected"), IconFactory.getBlankIcon(), SwingLocale.getString("close_selected"));
		closeSelectedMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				TabbedPaneManager.showCloseDialog(tabbedPane, checkBoxSelector);
			}
		}
		);
		popupMenu.add(closeSelectedMenuItem);
	}
	
	/**
	 * Adapts the closable item by a selected index.
	 * @param selectedIndex the selected index value
	 */
	public void adaptClosableItem(int selectedIndex)
	{
		String text = tabbedPane.getTitleAt(selectedIndex);
		boolean isTabClosable = tabbedPane.isTabClosableAt(selectedIndex);
		closeMenuItem.setEnabled(isTabClosable);
		
		closeMenuItem.setText(SwingLocale.getString("close") + " " + SwingLocale.getString("quotation_left") + text + SwingLocale.getString("quotation_right"));
		closeMenuItem.setToolTipText(SwingLocale.getString("close") + " " + SwingLocale.getString("quotation_left") + text + SwingLocale.getString("quotation_right"));
		closeOthersMenuItem.setText(SwingLocale.getString("close_all_except") + " " + SwingLocale.getString("quotation_left") + text + SwingLocale.getString("quotation_right"));
		closeOthersMenuItem.setToolTipText(SwingLocale.getString("close_all_except") + " " + SwingLocale.getString("quotation_left") + text + SwingLocale.getString("quotation_right"));
	}
}