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
import java.awt.Container;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

public interface ITabbedPane
	extends SwingConstants
{
	/**
	 * Gets the tab placement.
	 * @return the tab placement value
	 */
	public int getTabPlacement();
	
	/**
	 * Sets the tab placement.
	 * @param tabPlacement the tab placement value
	 */
	public void setTabPlacement(int tabPlacement);
	
	/**
	 * Adds the tab by a title and component.
	 * @param title the title string
	 * @param component the instance of Component
	 */
	public void addTab(String title, Component component);
	
	/**
	 * Adds the tab by a title, component and tooltip text.
	 * @param title the title string
	 * @param component the instance of Component
	 * @param toolTipText the tooltip text string
	 */
	public void addTab(String title, Component component, String toolTipText);
	
	/**
	 * Adds the tab by a title, icon and component.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param component the instance of Component
	 */
	public void addTab(String title, Icon icon, Component component);
	
	/**
	 * Adds the tab by a title, component and isClosable.
	 * @param title the title string
	 * @param component the instance of Component
	 * @param isClosable the boolean value of isClosable
	 */
	public void addTab(String title, Component component, boolean isClosable);
	
	/**
	 * Adds the tab by a title, component, tooltip text and isClosable.
	 * @param title the title string
	 * @param component the instance of Component
	 * @param toolTipText the tooltip text string
	 * @param isClosable the boolean value of isClosable
	 */
	public void addTab(String title, Component component, String toolTipText, boolean isClosable);
	
	/**
	 * Adds the tab by a title, component, tooltip text and isClosable.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param component the instance of Component
	 * @param toolTipText the tooltip text string
	 */
	public void addTab(String title, Icon icon, Component component, String toolTipText);
	
	/**
	 * Adds the tab by a title, icon, component and isClosable.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param component the instance of Component
	 * @param isClosable the boolean value of isClosable
	 */
	public void addTab(String title, Icon icon, Component component, boolean isClosable);
	
	/**
	 * Adds the tab by a title, icon, component and isClosable.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param component the instance of Component
	 * @param toolTipText the tooltip text string
	 * @param isClosable the boolean value of isClosable
	 */
	public void addTab(String title, Icon icon, Component component, String toolTipText, boolean isClosable);
	
	/**
	 * Returns true if the tab shows a snap tooltip.
	 * @return true if the tab shows a snap tooltip
	 */
	public boolean isSnapToolTip();
	
	/**
	 * Sets the snap tooltip.
	 * @param isSnapToolTip the instance of isSnapToolTip
	 */
	public void setSnapToolTip(boolean isSnapToolTip);
	
	/**
	 * Gets the tab count.
	 * @return the tab count value
	 */
	public int getTabCount();
	
	/**
	 * Gets the selected index.
	 * @return the index value
	 */
	public int getSelectedIndex();
	
	/**
	 * Gets the component by an index.
	 * @param index the index value
	 * @return the instance of Component
	 */
	public Component getComponentAt(int index);
	
	/**
	 * Sets the selected component by an index.
	 * @param component the instance of Component 
	 */
	public void setSelectedComponent(Component component);
	
	/**
	 * Gets the parent.
	 * @return the instance of Container
	 */
	public Container getParent();
	
	/**
	 * Gets the selected title.
	 * @return the title string
	 */
	public String getSelectedTitle();
	
	/**
	 * Gets the title by an index.
	 * @param index the index value
	 * @return the title string
	 */
	public String getTitleAt(int index);
	
	/**
	 * Gets the tooltip text by an index.
	 * @param index the index value
	 * @return the tooltip text string
	 */
	public String getToolTipTextAt(int index);
	
	/**
	 * Gets the icon by an index.
	 * @param index the index value
	 * @return the instance of Icon
	 */
	public Icon getIcon(int index);
	
	/**
	 * return true if the tab is closable by an index.
	 * @param index the index value.
	 * @return true if the tab is closable by an index
	 */
	public boolean isTabClosableAt(int index);
	
	/**
	 * Sets the tab closable by an index.
	 * @param index the index value
	 * @param isClosable the boolean value of isClosable
	 */
	public void setTabClosableAt(int index, boolean isClosable);
	
	/**
	 * Gets the tab by an index.
	 * @param title the title string
	 * @return the instance of Component
	 */
	public Component getTabAt(String title);
	
	/**
	 * Gets the closable tab list.
	 * @return the instance of List
	 */
	public List getClosableTabs();
	
	/**
	 * Removes the tab by an index.
	 * @param index the index value
	 */
	public void removeTabAt(int index);
	
	/**
	 * Removes the reverse tab list by an index.
	 * @param index the index value
	 */
	public void removeReverseTabsAt(int index);
	
	/**
	 * Removes all tabs.
	 */
	public void removeAllTabs();
	
	/**
	 * Removes tabs by a component list.
	 * @param components the instance of List
	 */
	public void removeTabs(List components);
	
	/**
	 * Gets the popup menu.
	 * @return the instance of JPopupMenu
	 */
	public JPopupMenu getPopupMenu();
	
	/**
	 * Sets the popup menu.
	 * @param popupMenu the instance of JPopupMenu
	 * @param isClosable the boolean value of isClosable
	 */
	public void setPopupMenu(JPopupMenu popupMenu, boolean isClosable);
}