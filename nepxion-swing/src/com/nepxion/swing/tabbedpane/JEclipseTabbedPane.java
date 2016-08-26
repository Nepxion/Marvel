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

import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.JToolTip;
import javax.swing.border.Border;

import com.jidesoft.swing.JideTabbedPane;
import com.nepxion.swing.style.framework.IStyle;
import com.nepxion.swing.style.framework.StyleManager;
import com.nepxion.swing.tooltip.snap.JSnapToolTip;

public class JEclipseTabbedPane
	extends JideTabbedPane implements ITabbedPane, MouseListener
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
	 * The instance of Border.
	 */
	private Border border;
	
	/**
	 * The instance of IStyle.
	 */
	private IStyle tabStyle;
	
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
	public JEclipseTabbedPane()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial tab placement.
	 * @param tabPlacement the tab placement value
	 */
	public JEclipseTabbedPane(int tabPlacement)
	{
		super(tabPlacement);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial tab placement and tab layout policy.
	 * @param tabPlacement the tab placement value
	 * @param tabLayoutPolicy the tab layout policy value
	 */
	public JEclipseTabbedPane(int tabPlacement, int tabLayoutPolicy)
	{
		super(tabPlacement, tabLayoutPolicy);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{		
		border = getBorder();
		
		setShowTabBorder(false);
		
		setUseDefaultShowIconsOnTab(false);
		
		setShowCloseButton(true);
		setShowCloseButtonOnTab(true);
		setShowCloseButtonOnSelectedTab(true);
		
		setRightClickSelect(true);
		
		setTabShape(SHAPE_ECLIPSE3X);
		
		addMouseListener(this);
	}
	
	/**
	 * Sets the tab shape.
	 * @param tabShape the tab shape value
	 */
	public void setTabShape(int tabShape)
	{
		super.setTabShape(tabShape);
		
		setTabStyle(tabShape, tabStyle != null ? tabStyle : StyleManager.getStyle());
	}
	
	/**
	 * Sets the tab style.
	 * @param tabShape the tab shape value
	 * @param tabStyle the instance of IStyle
	 */
	public void setTabShape(int tabShape, IStyle tabStyle)
	{
		super.setTabShape(tabShape);
		
		setTabStyle(tabShape, tabStyle);
	}
	
	/**
	 * Sets the tab shape.
	 * @param tabStyle the instance of IStyle
	 */
	public void setTabShape(IStyle tabStyle)
	{
		int tabShape = getTabShape();
		
		super.setTabShape(tabShape);
		
		setTabStyle(tabShape, tabStyle);
	}
	
	/**
	 * Sets the tab style.
	 * @param tabShape the tab shape value
	 * @param tabStyle the instance of IStyle
	 */
	protected void setTabStyle(int tabShape, IStyle tabStyle)
	{		
		this.tabStyle = tabStyle;
		
		if (tabShape != SHAPE_DEFAULT && tabShape != SHAPE_ECLIPSE3X)
		{
			setBasicTabStyle(tabShape, tabStyle);
		}
		else
		{
			setEclipseTabStyle(tabShape, tabStyle);	
		}
	}
	
	/**
	 * Sets the basic tab style.
	 * @param tabShape the tab shape value
	 * @param tabStyle the instance of IStyle
	 */
	protected void setBasicTabStyle(int tabShape, IStyle tabStyle)
	{
		setTabColorProvider(tabStyle);
		
		setContentBorderInsets(new Insets(3, 3, 3, 3));
		
		setBorder(BorderFactory.createEmptyBorder());
	}
	
	/**
	 * Sets the eclipse tab style.
	 * @param tabShape the tab shape value
	 * @param tabStyle the instance of IStyle
	 */
	protected void setEclipseTabStyle(int tabShape, IStyle tabStyle)
	{
		setTabColorProvider((IStyle) null);
		
		setEclipseTabGradientColor(tabStyle.getTabbedPaneGradientColor());
		setEclipseTabBackground(tabStyle.getTabbedPaneBackground());
		setEclipseTabForeground(tabStyle.getTabbedPaneForeground());
		setEclipseTabSelectionForeground(tabStyle.getTabbedPaneSelectionForeground());
		
		setContentBorderInsets(new Insets(3, 2, 2, 2));
		
		setBorder(border);
	}
	
	/**
	 * Sets the tab color provider.
	 * @param tabStyle the instance of IStyle
	 */
	public void setTabColorProvider(final IStyle tabStyle)
	{
		GradientColorProvider tabColorProvider = null;
		if (tabStyle != null)
		{
			tabColorProvider = new GradientColorProvider()
			{
				public Color getTopBackgroundAt(int selectedIndex)
				{
					return tabStyle.getTabbedPaneGradientColor();
				}
				
				public Color getBackgroundAt(int selectedIndex)
				{
					return tabStyle.getTabbedPaneBackground();
				}
				
				public Color getForegroudAt(int selectedIndex)
				{
					if (getSelectedIndex() == selectedIndex)
					{
						return tabStyle.getTabbedPaneSelectionForeground();
					}
					else
					{
						return tabStyle.getTabbedPaneForeground();
					}
				}
				
				public float getGradientRatio(int selectedIndex)
				{
					return 0.0F;
				}
				
			};
		}
		
		setTabColorProvider(tabColorProvider);
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
		super.addTab(title, icon, component, toolTipText);
		
		setTabClosableAt(indexOfComponent(component), isClosable);
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
		return getIconAt(index);
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
	public void removeTabs(List components)
	{
		for (int i = 0; i < components.size(); i++)
		{
			Component closedComponent = (Component) components.get(i);
			removeTabAt(indexOfComponent(closedComponent));
		}
	}
	
	/**
	 * Removes the reverse tab list by an index.
	 * @param index the index value
	 */
	public void removeReverseTabsAt(int index)
	{
		List components = new ArrayList();
		for (int i = 0; i < getTabCount(); i++)
		{
			if (i != index && isTabClosableAt(i))
			{
				Component component = getComponentAt(i);
				components.add(component);
			}
		}
		removeTabs(components);
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
	}
	
    /**
     * Invoked when the mouse button has been pressed on a component.
     * @param e the instance of MouseEvent
     */
	public void mousePressed(MouseEvent e)
	{
		requestFocus();
	}
	
    /**
     * Invoked when the mouse button has been released on a component.
     * @param e the instance of MouseEvent
     */
	public void mouseReleased(MouseEvent e)
	{
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