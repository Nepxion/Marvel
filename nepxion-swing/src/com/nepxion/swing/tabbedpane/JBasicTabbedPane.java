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
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JToolTip;
import javax.swing.SwingUtilities;

import com.nepxion.swing.icon.paint.CloseIcon;
import com.nepxion.swing.icon.paint.CloseTabIcon;
import com.nepxion.swing.tooltip.snap.JSnapToolTip;

public class JBasicTabbedPane
	extends JTabbedPane implements ITabbedPane, MouseListener
{
	/**
	 * The instance of JPopupMenu.
	 */
	private JPopupMenu popupMenu;
	
	/**
	 * The instance of TabbedPanePopupMenuAdapter.
	 */
	private TabbedPanePopupMenuAdapter popupMenuAdapter;
	
	/**
	 * The instace of CloseIcon.
	 */
	private CloseIcon closeIcon;
	
	/**
	 * The boolean value of isDrawBorder.
	 */
	private boolean isDrawBorder = true;
	
	/**
	 * The boolean value of isDrawCenter.
	 */	
	private boolean isDrawCenter = true;
	
	/**
	 * The boolean value of isHint.
	 */	
	private boolean isHint = false;
	
	/**
	 * The boolean value of isSnapToolTip.
	 */	
	private boolean isSnapToolTip = false;
	
	/**
	 * The instance of Map.
	 */
	private Map snapComponentMap;
	
	/**
	 * Constructs with the default.
	 */
	public JBasicTabbedPane()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial tab placement.
	 * @param tabPlacement the tab placement value
	 */
	public JBasicTabbedPane(int tabPlacement)
	{
		super(tabPlacement);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial tab placement and tab layout policy.
	 * @param tabPlacement the tab placement value
	 * @param tabLayoutPolicy the tab layout policy value
	 */
	public JBasicTabbedPane(int tabPlacement, int tabLayoutPolicy)
	{
		super(tabPlacement, tabLayoutPolicy);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		TabbedPaneManager.setPreferenceStyle(this);
		
		addMouseListener(this);
	}
	
	/**
	 * Adds the tab by a title and component.
	 * @param title the title string
	 * @param component the instance of Component
	 */
	public void addTab(String title, Component component)
	{
		addTab(title, component, null);
	}
	
	/**
	 * Adds the tab by a title, component and tooltip text.
	 * @param title the title string
	 * @param component the instance of Component
	 * @param toolTipText the tooltip text string
	 */
	public void addTab(String title, Component component, String toolTipText)
	{
		addTab(title, null, component, toolTipText);
	}
	
	/**
	 * Adds the tab by a title, icon and component.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param component the instance of Component
	 */
	public void addTab(String title, Icon icon, Component component)
	{
		addTab(title, icon, component, null);
	}
	
	/**
	 * Adds the tab by a title, component and isClosable.
	 * @param title the title string
	 * @param component the instance of Component
	 * @param isClosable the boolean value of isClosable
	 */
	public void addTab(String title, Component component, boolean isClosable)
	{
		addTab(title, null, component, isClosable);
	}
	
	/**
	 * Adds the tab by a title, component, tooltip text and isClosable.
	 * @param title the title string
	 * @param component the instance of Component
	 * @param toolTipText the tooltip text string
	 * @param isClosable the boolean value of isClosable
	 */
	public void addTab(String title, Component component, String toolTipText, boolean isClosable)
	{
		addTab(title, null, component, toolTipText, isClosable);
	}
	
	/**
	 * Adds the tab by a title, icon, component and tooltip text.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param component the instance of Component
	 * @param toolTipText the tooltip text string
	 */
	public void addTab(String title, Icon icon, Component component, String toolTipText)
	{
		addTab(title, icon, component, toolTipText, false);
	}
	
	/**
	 * Adds the tab by a title, icon, component and isClosable.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param component the instance of Component
	 * @param isClosable the boolean value of isClosable
	 */
	public void addTab(String title, Icon icon, Component component, boolean isClosable)
	{
		addTab(title, icon, component, null, isClosable);
	}
	
	/**
	 * Adds the tab by a title, icon, component, tooltip text and isClosable.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param component the instance of Component
	 * @param toolTipText the tooltip text string
	 * @param isClosable the boolean value of isClosable
	 */
	public void addTab(String title, Icon icon, Component component, String toolTipText, boolean isClosable)
	{
		if (isClosable)
		{
			super.addTab(title, new CloseTabIcon(icon, isDrawBorder, isDrawCenter, isHint), component, toolTipText);
		}
		else
		{
			super.addTab(title, icon, component, toolTipText);
		}
	}
	
	/**
	 * Insets the tab by a title, icon, component, tooltip text and index.
	 * @param title the tile string
	 * @param icon the instance of Icon
	 * @param component the instance of Component
	 * @param toolTipText the tooltip text.
	 * @param index the index value
	 */
	public void insertTab(String title, Icon icon, Component component, String toolTipText, int index)
	{
		if (snapComponentMap != null)
		{	
			toolTipText = "tab" + component.hashCode();
			snapComponentMap.put(toolTipText, component);
		}
		
		super.insertTab(title, icon, component, toolTipText, index);
	}
	
	/**
	 * Creates the tool tip.
	 * @return the instance of JToolTip
	 */
	public JToolTip createToolTip()
	{		
		if (snapComponentMap != null)
		{	
			JSnapToolTip snapTooltip = new JSnapToolTip(snapComponentMap);
			snapTooltip.setComponent(this);
			
			return snapTooltip;
		}
		
		return super.createToolTip();
	}
	
	/**
	 * Returns true if the tab shows a snap tooltip.
	 * @return true if the tab shows a snap tooltip
	 */
	public boolean isSnapToolTip()
	{
		return isSnapToolTip;
	}
	
	/**
	 * Sets the snap tooltip.
	 * @param isSnapToolTip the instance of isSnapToolTip
	 */
	public void setSnapToolTip(boolean isSnapToolTip)
	{
		this.isSnapToolTip = isSnapToolTip;
		
		if (isSnapToolTip)
		{
			snapComponentMap = new HashMap();
		}
		else
		{
			snapComponentMap = null;
		}
	}	
	
	/**
	 * Gets the close icon by an index.
	 * @param index the index value
	 * @return the instance of CloseIcon
	 */
	public CloseIcon getCloseIcon(int index)
	{
		CloseTabIcon closeTabIcon = getCloseTabIcon(index);
		if (closeTabIcon != null)
		{
			return closeTabIcon.getCloseIcon();
		}
		
		return null;
	}
	
	/**
	 * Gets the close tab icon by an index.
	 * @param index the index value
	 * @return the instance of CloseTabIcon
	 */
	public CloseTabIcon getCloseTabIcon(int index)
	{
		Icon icon = getIconAt(index);
		if (icon instanceof CloseTabIcon)
		{
			return ((CloseTabIcon) icon);
		}
		
		return null;
	}
	
	/**
	 * Returns true if the tab is drawing border of the close icon.
	 * @return true if the tab is drawing border of the close icon
	 */
	public boolean isDrawBorder()
	{		
		return isDrawBorder;
	}
	
	/**
	 * Sets the drawing border of the close icon.
	 * @param isDrawBorder the boolean value of isDrawBorder
	 */
	public void setDrawBorder(boolean isDrawBorder)
	{
		this.isDrawBorder = isDrawBorder;
	}
	
	/**
	 * Returns true if the tab is drawing border of the close icon by an index.
	 * @param index the index value
	 * @return true if the tab is drawing border of the close icon by an index
	 */
	public boolean isDrawBorder(int index)
	{
		CloseIcon closeIcon = getCloseIcon(index);
		if (closeIcon != null)
		{
			return closeIcon.isDrawBorder();
		}
		
		return false;
	}
	
	/**
	 * Sets the drawing border of the close icon by an index.
	 * @param index the index value
	 * @param isDrawBorder the boolean value of isDrawBorder
	 */
	public void setDrawBorder(int index, boolean isDrawBorder)
	{
		CloseIcon closeIcon = getCloseIcon(index);
		if (closeIcon != null)
		{
			closeIcon.setDrawBorder(isDrawBorder);
			repaint();
		}
	}
	
	/**
	 * Returns true if the tab is drawing center of the close icon.
	 * @return true if the tab is drawing center of the close icon
	 */
	public boolean isDrawCenter()
	{
		return isDrawCenter;
	}
	
	/**
	 * Sets the drawing center of the close icon.
	 * @param isDrawCenter the boolean value of isDrawCenter
	 */
	public void setDrawCenter(boolean isDrawCenter)
	{
		this.isDrawCenter = isDrawCenter;
	}
	
	/**
	 * Returns true if the tab is drawing center of the close icon by an index.
	 * @param index the index value
	 * @return true if the tab is drawing center of the close icon by an index
	 */
	public boolean isDrawCenter(int index)
	{
		CloseIcon closeIcon = getCloseIcon(index);
		if (closeIcon != null)
		{
			return closeIcon.isDrawCenter();
		}
		
		return false;
	}
	
	/**
	 * Sets the drawing center of the close icon by an index.
	 * @param index the index value
	 * @param isDrawCenter the boolean value of isDrawCenter
	 */
	public void setDrawCenter(int index, boolean isDrawCenter)
	{
		CloseIcon closeIcon = getCloseIcon(index);
		if (closeIcon != null)
		{
			closeIcon.setDrawCenter(isDrawCenter);
			repaint();
		}
	}
	
	/**
	 * Returns true if the tab shows the hint dialog when closing the tab.
	 * @return true if the tab shows the hint dialog when closing the tab
	 */
	public boolean isHint()
	{		
		return isHint;
	}
	
	/**
	 * Sets the hint.
	 * @param isHint the boolean value of isHint
	 */
	public void setHint(boolean isHint)
	{
		this.isHint = isHint;
	}
	
	/**
	 * Returns true if the tab shows the hint dialog when closing the tab by an index
	 * @param index the index value
	 * @return true if the tab shows the hint dialog when closing the tab by an index
	 */
	public boolean isHint(int index)
	{
		CloseTabIcon closeTabIcon = getCloseTabIcon(index);
		if (closeTabIcon != null)
		{
			return closeTabIcon.isHint();
		}
		
		return false;
	}
	
	/**
	 * Sets the hint by an index.
	 * @param index the index value
	 * @param isHint the boolean value of isHint
	 */
	public void setHint(int index, boolean isHint)
	{
		CloseTabIcon closeTabIcon = getCloseTabIcon(index);
		if (closeTabIcon != null)
		{
			closeTabIcon.setHint(isHint);
			repaint();
		}
	}
	
	/**
	 * Gets the selected title.
	 * @return the title string
	 */
	public String getSelectedTitle()
	{
		int index = getSelectedIndex();
		if (index == -1)
		{
			return null;
		}
		
		return getTitleAt(index);
	}
	
	/**
	 * Gets the icon by an index.
	 * @param index the index value
	 * @return the instance of Icon
	 */
	public Icon getIcon(int index)
	{
		CloseTabIcon closeTabIcon = getCloseTabIcon(index);
		if (closeTabIcon != null)
		{
			return closeTabIcon.getIcon();
		}
		else
		{
			return getIconAt(index);
		}
	}
	
	/**
	 * return true if the tab is closable by an index.
	 * @param index the index value.
	 * @return true if the tab is closable by an index
	 */
	public boolean isTabClosableAt(int index)
	{
		CloseIcon closeIcon = getCloseIcon(index);
		
		return closeIcon != null;
	}
	
	/**
	 * Sets the tab closable by an index.
	 * @param index the index value
	 * @param isClosable the boolean value of isClosable
	 */
	public void setTabClosableAt(int index, boolean isClosable)
	{
		if (isClosable)
		{
			CloseTabIcon closeTabIcon = getCloseTabIcon(index);
			if (closeTabIcon == null)
			{
				setIconAt(index, new CloseTabIcon(getIconAt(index), isDrawBorder, isDrawCenter, isHint));
			}
		}
		else
		{
			CloseTabIcon closeTabIcon = getCloseTabIcon(index);
			if (closeTabIcon != null)
			{
				setIconAt(index, closeTabIcon.getIcon());
			}
		}
	}
	
	/**
	 * Gets the tab by an index.
	 * @param title the title string
	 * @return the instance of Component
	 */
	public Component getTabAt(String title)
	{
		for (int i = 0; i < getTabCount(); i++)
		{
			if (getTitleAt(i).equals(title))
			{
				return getComponentAt(i);
			}
		}
		
		return null;
	}
	
	/**
	 * Gets the closable tab list.
	 * @return the instance of List
	 */
	public List getClosableTabs()
	{
		List components = new ArrayList();
		for (int i = 0; i < getTabCount(); i++)
		{
			if (isTabClosableAt(i))
			{
				Component component = getComponentAt(i);
				components.add(component);
			}
		}
		
		return components;
	}
	
	/**
	 * Removes the tab by an index.
	 * @param index the index value
	 */
	public void removeTabAt(int index)
	{
		if (snapComponentMap != null)
		{	
			Component component = getComponentAt(index);
			snapComponentMap.remove("tab" + component.hashCode());
		}
		
		super.removeTabAt(index);
	}
	
	/**
	 * Removes the tab by an index.
	 * @param index the index value
	 */
	public void removeTabAt(String title)
	{
		for (int i = 0; i < getTabCount(); i++)
		{
			if (getTitleAt(i).equals(title))
			{
				removeTabAt(i);
				
				break;
			}
		}
	}
	
	/**
	 * Removes tabs by a component list.
	 * @param components the instance of List
	 */
	public void removeTabs(List closedComponents)
	{
		for (int i = 0; i < closedComponents.size(); i++)
		{
			Component closedComponent = (Component) closedComponents.get(i);
			
			super.removeTabAt(indexOfComponent(closedComponent));
		}
	}
	
	/**
	 * Removes the reverse tab list by an index.
	 * @param index the index value
	 */
	public void removeReverseTabsAt(int index)
	{
		List closedComponents = new ArrayList();
		for (int i = 0; i < getTabCount(); i++)
		{
			if (i != index && isTabClosableAt(i))
			{
				Component component = getComponentAt(i);
				closedComponents.add(component);
			}
		}
		removeTabs(closedComponents);
	}
	
	/**
	 * Removes all tabs.
	 */
	public void removeAllTabs()
	{
		List components = new ArrayList();
		for (int i = 0; i < getTabCount(); i++)
		{
			if (isTabClosableAt(i))
			{
				Component component = getComponentAt(i);
				components.add(component);
			}
		}
		removeTabs(components);
	}
	
	/**
	 * Gets the popup menu.
	 * @return the instance of JPopupMenu
	 */
	public JPopupMenu getPopupMenu()
	{
		return popupMenu;
	}
	
	/**
	 * Sets the popup menu.
	 * @param popupMenu the instance of JPopupMenu
	 * @param isClosable the boolean value of isClosable
	 */
	public void setPopupMenu(JPopupMenu popupMenu, boolean isClosable)
	{
		this.popupMenu = popupMenu;
		
		if (isClosable)
		{
			popupMenuAdapter = new TabbedPanePopupMenuAdapter(this, popupMenu);
		}
	}
	
    /**
     * Invoked when the mouse button has been clicked (pressed and released) on a component.
     * @param e the instance of MouseEvent
     */
	public void mouseClicked(MouseEvent e)
	{
		if (!SwingUtilities.isLeftMouseButton(e))
		{
			return;
		}
		
		int index = indexAtLocation(e.getX(), e.getY());
		if (index < 0)
		{
			return;
		}
		
		CloseTabIcon closeTabIcon = getCloseTabIcon(index);
		if (closeTabIcon != null)
		{
			Rectangle rect = closeTabIcon.getBounds();
			if (rect.contains(e.getX(), e.getY()))
			{
				removeTabAt(index);
			}
		}
	}
	
    /**
     * Invoked when the mouse button has been pressed on a component.
     * @param e the instance of MouseEvent
     */
	public void mousePressed(MouseEvent e)
	{
		if (!SwingUtilities.isLeftMouseButton(e))
		{
			return;
		}
		
		int index = indexAtLocation(e.getX(), e.getY());
		if (index < 0)
		{
			return;
		}
		
		CloseTabIcon closeTabIcon = getCloseTabIcon(index);
		if (closeTabIcon != null)
		{
			Rectangle rect = closeTabIcon.getBounds();
			if (rect.contains(e.getX(), e.getY()))
			{
				closeIcon = closeTabIcon.getCloseIcon();
				closeIcon.setPressed(true);
				repaint();
			}
		}
	}
	
    /**
     * Invoked when the mouse button has been released on a component.
     * @param e the instance of MouseEvent
     */
	public void mouseReleased(MouseEvent e)
	{
		if (closeIcon != null)
		{
			if (!SwingUtilities.isLeftMouseButton(e))
			{
				return;
			}
			
			closeIcon.setPressed(false);
			repaint();
			
			closeIcon = null;
		}
		
		if (popupMenu != null)
		{
			int index = indexAtLocation(e.getX(), e.getY());
			if (index < 0)
			{
				return;
			}
			
			if (!e.isPopupTrigger())
			{
				return;
			}
			
			setSelectedIndex(index);
			
			if (popupMenuAdapter != null)
			{
				popupMenuAdapter.adaptClosableItem(index);
			}			
			
			popupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}
	
    /**
     * Invoked when the mouse enters a component.
     * @param e the instance of MouseEvent
     */
	public void mouseEntered(MouseEvent e)
	{
	}
	
    /**
     * Invoked when the mouse exits a component.
     * @param e the instance of MouseEvent
     */
	public void mouseExited(MouseEvent e)
	{
	}
}