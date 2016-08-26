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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class JDockableTabbedPane
	extends JEclipseTabbedPane
{
	/**
	 * The vertical tab placement value.
	 */
	private int verticalTabPlacement = TOP;
	
	/**
	 * The horizontal tab placement value.
	 */
	private int horizontalTabPlacement = TOP;
	
	/**
	 * The toggle size menu item.
	 */
	private JBasicMenuItem toggleSizeMenuItem;
	
	/**
	 * The toggle layout menu item.
	 */
	private JBasicMenuItem toggleLayoutMenuItem;
	
	/**
	 * The instance of JDockableSplitPane.
	 */
	private JDockableSplitPane splitPane;
	
	/**
	 * Constructs with the default.
	 */
	public JDockableTabbedPane()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial tab placement.
	 * @param tabPlacement the tab placement value
	 */
	public JDockableTabbedPane(int tabPlacement)
	{
		super(tabPlacement);
	}
	
	/**
	 * Constructs with the specified initial tab placement and tab layout policy.
	 * @param tabPlacement the tab placement value
	 * @param tabLayoutPolicy the tab layout policy
	 */
	public JDockableTabbedPane(int tabPlacement, int tabLayoutPolicy)
	{
		super(tabPlacement, tabLayoutPolicy);
	}
	
	/**
	 * Sets the popup menu.
	 * @param isClosable the boolean value of isClosable
	 */
	public void setPopupMenu(JPopupMenu popupMenu, boolean isClosable)
	{
		super.setPopupMenu(popupMenu, isClosable);
		
		if (popupMenu.getComponentCount() != 0)
		{
			popupMenu.add(new JPopupMenu.Separator());
		}
		
		toggleSizeMenuItem = new JBasicMenuItem(SwingLocale.getString("toggle_tabbedpane_size"), IconFactory.getSwingIcon("toggle_size.png"), SwingLocale.getString("toggle_tabbedpane_size"));
		toggleSizeMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				initialize();
				
				splitPane.toggleView(JDockableTabbedPane.this);
			}
		}
		);
		popupMenu.add(toggleSizeMenuItem);
		
		toggleLayoutMenuItem = new JBasicMenuItem(SwingLocale.getString("toggle_tabbedpane_layou"), IconFactory.getSwingIcon("toggle_layout.png"), SwingLocale.getString("toggle_tabbedpane_layou"));
		toggleLayoutMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				initialize();
				
				splitPane.toggleLayout();
			}
		}
		);
		popupMenu.add(toggleLayoutMenuItem);
	}
	
	/**
	 * Invoked when the mouse button has been clicked (pressed and released) on a component.
	 * @param e the instance of MouseEvent
	 */
	public void mouseClicked(MouseEvent e)
	{
		super.mouseClicked(e);
		
		// If the popup menu is disabled, the mouse clicking will be blocked at the same time. 
		if (getPopupMenu() != null && e.getClickCount() > 1)
		{
			initialize();
			
			splitPane.toggleView(JDockableTabbedPane.this);
		}
	}
	
	/**
	 * Initializes.
	 */
	private void initialize()
	{
		if (splitPane == null)
		{
			splitPane = (JDockableSplitPane) getParent();
		}
	}
	
	/**
	 * Gets the vertical tab placement.
	 * @return the vertical tab placement value
	 */
	public int getVerticalTabPlacement()
	{
		return verticalTabPlacement;
	}
	
	/**
	 * Sets the vertical tab placement.
	 * @param verticalTabPlacement the vertical tab placement value
	 */
	public void setVerticalTabPlacement(int verticalTabPlacement)
	{
		this.verticalTabPlacement = verticalTabPlacement;
	}
	
	/**
	 * Gets the horizontal tab placement.
	 * @return the horizontal tab placement value
	 */
	public int getHorizontalTabPlacement()
	{
		return horizontalTabPlacement;
	}
	
	/**
	 * Sets the horizontal tab placement.
	 * @param horizontalTabPlacement the horizontal tab placement value
	 */
	public void setHorizontalTabPlacement(int horizontalTabPlacement)
	{
		this.horizontalTabPlacement = horizontalTabPlacement;
	}
}