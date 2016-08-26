package com.nepxion.swing.framework.dockable;

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
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.nepxion.swing.framework.JFrameWorkWindow;
import com.nepxion.swing.fullscreen.FullScreenRegister;
import com.nepxion.swing.fullscreen.FullScreenSupport;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menu.JBasicMenu;
import com.nepxion.swing.menuitem.JBasicCheckBoxMenuItem;

public class DockableManager
{
	/**
	 * Gets the dockable tabbed pane by a dockable container, title and tabbed pane name.
	 * @param dockableContainer the instance of JDockableContainer
	 * @param title the title string
	 * @param tabbedPaneName the tabbed pane name string
	 * @return the instance of JDockableTabbedPane
	 */
	public static JDockableTabbedPane getDockableTabbedPane(JDockableContainer dockableContainer, String title, String tabbedPaneName)
	{
		List tabbedPanes = getDockableTabbedPanes(dockableContainer, title);
		if (tabbedPanes == null)
		{
			return null;
		}
		for (Iterator iterator = tabbedPanes.iterator(); iterator.hasNext();)
		{
			JDockableTabbedPane tabbedPane = (JDockableTabbedPane) iterator.next();
			if (tabbedPane.getName().equals(tabbedPaneName))
			{
				return tabbedPane;
			}
		}
		
		return null;
	}
	
	/**
	 * Gets the dockable tabbed pane list by a dockable container and title.
	 * @param dockableContainer the instance of JDockableContainer
	 * @param title the title string
	 * @return the instance of List
	 */
	public static List getDockableTabbedPanes(JDockableContainer dockableContainer, String title)
	{
		JDockableView dockableView = getDockableView(dockableContainer, title);
		if (dockableView == null)
		{
			return null;
		}
		
		Component contentPane = dockableView.getContentPane();
		if (contentPane instanceof JDockableSplitPane)
		{
			JDockableSplitPane dockableSplitPane = (JDockableSplitPane) contentPane;
			
			return dockableSplitPane.getTabbedPanes();
		}
		else if (contentPane instanceof JDockableTabbedPane)
		{
			List tabbedPanes = new ArrayList();
			tabbedPanes.add(contentPane);
			
			return tabbedPanes;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Gets the dockable view by a dockable container and title.
	 * The title should be exclusive.
	 * @param dockableContainer the instance of JDockableContainer
	 * @param title the title string
	 * @return the instance of JDockableView
	 */
	public static JDockableView getDockableView(JDockableContainer dockableContainer, String title)
	{
		Component contentPane = dockableContainer.getContentPane();
		if (contentPane instanceof JDockable) // The dockable is null when maximized
		{
			JDockable dockable = (JDockable) contentPane;
			
			return DockableManager.getDockableView(dockable, title);
		}
		else if (contentPane instanceof JDockableView)
		{
			JDockableView dockableView = (JDockableView) contentPane;
			if (dockableView.getTitle().equals(title))
			{
				return dockableView;
			}
		}
		
		return null;
	}
	
	/**
	 * Gets the dockable view by a dockable and title.
	 * The title should be exclusive.
	 * @param dockable the instance of JDockable
	 * @param title the title string
	 * @return the instance of JDockableView
	 */
	public static JDockableView getDockableView(JDockable dockable, String title)
	{
		for (int i = 0; i < dockable.getPaneCount(); i++)
		{
			Component component = dockable.getPaneAt(i);
			if (component instanceof JDockableView)
			{
				JDockableView dockableView = (JDockableView) component;
				if (dockableView.getTitle().equals(title))
				{
					return dockableView;
				}
			}
			else if (component instanceof JDockable)
			{
				JDockable childDockable = (JDockable) component;
				JDockableView dockableView = getDockableView(childDockable, title);
				if (dockableView != null)
				{
					return dockableView;
				}
				else
				{
					continue;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Gets the dockable view list by a dockable container.
	 * @param dockableContainer the instance of JDockableContainer
	 * @return the instance of List
	 */
	public static List getDockableViews(JDockableContainer dockableContainer)
	{
		List dockableViews = new ArrayList();
		Component component = dockableContainer.getContentPane();
		if (component instanceof JDockable) // The dockable is null when maximized
		{
			JDockable dockable = (JDockable) component;
			DockableManager.putDockableViews(dockable, dockableViews);
		}
		else if (component instanceof JDockableView)
		{
			JDockableView dockableView = (JDockableView) component;
			dockableViews.add(dockableView);
		}
		
		return dockableViews;
	}
	
	/**
	 * Gets the dockable view list by a dockable.
	 * @param dockable the instance of JDockable
	 * @return the instance of List
	 */
	public static List getDockableViews(JDockable dockable)
	{
		List dockableViews = new ArrayList();
		putDockableViews(dockable, dockableViews);
		
		return dockableViews;
	}
	
	/**
	 * Puts the dockable view to the list by a dockable. 
	 * @param dockable the instance of JDockable
	 * @param dockableViews the instance of List
	 */
	private static void putDockableViews(JDockable dockable, List dockableViews)
	{
		for (int i = 0; i < dockable.getPaneCount(); i++)
		{
			Component component = dockable.getPaneAt(i);
			if (component instanceof JDockableView)
			{
				JDockableView dockableView = (JDockableView) component;
				dockableViews.add(dockableView);
			}
			else if (component instanceof JDockable)
			{
				JDockable childDockable = (JDockable) component;
				putDockableViews(childDockable, dockableViews);
			}
		}
	}
	
	/**
	 * Gets the dockable by a inner component.
	 * @param component the inner component
	 * @return the instance of JDockable
	 */
	public static JDockable getDockable(Component component)
	{
		Container container = component.getParent();
		if (container == null)
		{
			return null;
		}
		
		if (container instanceof JDockable)
		{
			return (JDockable) container;
		}
		else
		{
			return getDockable(container);
		}
	}

	/**
	 * Gets the dockable container by a inner component.
	 * @param component the inner component
	 * @return the instance of JDockableContainer
	 */
	public static JDockableContainer getDockableContainer(Component component)
	{
		Container container = component.getParent();
		if (container == null)
		{
			return null;
		}
		
		if (container instanceof JDockableContainer)
		{
			return (JDockableContainer) container;
		}
		else
		{
			return getDockableContainer(container);
		}
	}
	
	/**
	 * Gets the dockable view by a framework window and title.
	 * @param frameWorkWindow the instance of JFrameWorkWindow
	 * @param title the title string
	 * @return the instance of JDockableView
	 */
	public static JDockableView getDockableView(JFrameWorkWindow frameWorkWindow, String title)
	{
		if (frameWorkWindow == null)
		{
			return null;
		}
		
		JDockableHierarchy dockableHierarchy = (JDockableHierarchy) frameWorkWindow.getHierarchy();
		
		return getDockableView(dockableHierarchy, title);
	}
	
	/**
	 * Gets the dockable view by a dockable hierarchy and title.
	 * @param dockableHierarchy the instance of JDockableHierarchy
	 * @param title the title string
	 * @return the instance of JDockableView
	 */
	public static JDockableView getDockableView(JDockableHierarchy dockableHierarchy, String title)
	{
		if (dockableHierarchy == null)
		{
			return null;
		}
		
		JDockableContainer dockableContainer = dockableHierarchy.getDockableContainer();
		Component component = dockableContainer.getContentPane();
		
		if (component instanceof JDockable)
		{
			JDockable dockable = (JDockable) component;
			
			return DockableManager.getDockableView(dockable, title);
		}
		
		return null;
	}
	
	/**
	 * Gets the toggle menu by a dockable hierarchy.
	 * @param dockableHierarchy the instance of JDockableHierarchy
	 * @return the instance of JBasicMenu
	 */
	public static JBasicMenu getToggleMenu(final JDockableHierarchy dockableHierarchy)
	{
		JBasicMenu toggleMenu = new JBasicMenu(SwingLocale.getString("view"), SwingLocale.getString("view") + "(V)");
		toggleMenu.setMnemonic('V');
		
		final JBasicCheckBoxMenuItem toolBarToggleMenuItem = new JBasicCheckBoxMenuItem(SwingLocale.getString("toolbar"), SwingLocale.getString("toolbar"), true);
		toolBarToggleMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Component toolBar = dockableHierarchy.getToolBar();
				toolBar.setVisible(!toolBar.isVisible());
			}
		}
		);
		toggleMenu.add(toolBarToggleMenuItem);
		
		final JBasicCheckBoxMenuItem statusBarToggleMenuItem = new JBasicCheckBoxMenuItem(SwingLocale.getString("statusbar"), SwingLocale.getString("statusbar"), true);
		statusBarToggleMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Component statusBar = dockableHierarchy.getStatusBar();
				statusBar.setVisible(!statusBar.isVisible());
			}
		}
		);
		toggleMenu.add(statusBarToggleMenuItem);
		
		toggleMenu.addSeparator();
		
		List dockableViews = dockableHierarchy.getDockableViews();
		for (Iterator iterator = dockableViews.iterator(); iterator.hasNext();)
		{
			final JDockableView dockableView = (JDockableView) iterator.next();
			final JBasicCheckBoxMenuItem dockableViewToggleMenuItem = new JBasicCheckBoxMenuItem(dockableView.getTitle(), dockableView.getTitle(), true);
			dockableView.registerForeignButton(dockableViewToggleMenuItem);
			dockableViewToggleMenuItem.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					dockableView.setVisible(!dockableView.isVisible());
				}
			}
			);
			toggleMenu.add(dockableViewToggleMenuItem);
		}
		
		toggleMenu.addSeparator();
		
		JBasicCheckBoxMenuItem screenToggleMenuItem = new JBasicCheckBoxMenuItem(SwingLocale.getString("fullscreen"), SwingLocale.getString("fullscreen"));
		// JBasicMenuItem screenToggleMenuItem = new JBasicMenuItem(FullScreenConstants.TEXT_MAXIMIZE, FullScreenConstants.ICON_MAXIMIZE, FullScreenConstants.TEXT_MAXIMIZE);
		KeyStrokeManager.registerButton(screenToggleMenuItem, KeyEvent.VK_F12, 'F');
		toggleMenu.add(screenToggleMenuItem);
		
		FullScreenSupport fullScreenSupport = new FullScreenSupport(dockableHierarchy);
		FullScreenRegister fullScreenRegister = new FullScreenRegister(fullScreenSupport);
		fullScreenRegister.register(dockableHierarchy.getMenuBar());
		fullScreenRegister.register(dockableHierarchy.getToolBar());
		fullScreenRegister.register(screenToggleMenuItem);
		
		return toggleMenu;
	}	
}