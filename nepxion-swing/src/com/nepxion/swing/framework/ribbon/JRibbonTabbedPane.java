package com.nepxion.swing.framework.ribbon;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.plaf.UIResource;

import com.nepxion.swing.action.JAction;
import com.nepxion.swing.container.ContainerManager;
import com.nepxion.swing.container.JContainer;
import com.nepxion.swing.font.FontManager;
import com.nepxion.swing.gradient.JGradientPainter;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.icon.paint.CombinationIcon;
import com.nepxion.swing.label.JBasicLabel;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menuitem.JBasicCheckBoxMenuItem;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;
import com.nepxion.swing.style.framework.IStyle;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;
import com.nepxion.swing.tabbedpane.TabbedPaneManager;

public class JRibbonTabbedPane
	extends JEclipseTabbedPane
{
	/**
	 * The button style of normal.
	 */
	public static final int BUTTON_STYLE_NORMAL = 0;
	
	/**
	 * The button style of hover.
	 */
	public static final int BUTTON_STYLE_HOVER = 1;
	
	/**
	 * The button style of selected.
	 */
	public static final int BUTTON_STYLE_SELECTED = 2;
	
	/**
	 * The button style string.
	 */
	public static final String BUTTON_STYLE = "buttonStyle";
		
	/**
	 * The title string.
	 */
	private String title = "";
	
	/**
	 * The title font.
	 */
	private Font titleFont = new Font("Dialog", Font.PLAIN, 12);
	
	/**
	 * The title color.
	 */
	private Color titleColor = Color.black;
	
	/**
	 * The navigator icon.
	 */
	private Icon navigatorIcon = IconFactory.getSwingIcon("ribbon/navigator.png");
		
	/**
	 * The navigator background icon.
	 */
	private Icon navigatorBackgroundIcon = IconFactory.getSwingIcon("ribbon/navigator_bg.png");
	
	/**
	 * The navigator background hover icon.
	 */
	private Icon navigatorBackgroundHoverIcon = IconFactory.getSwingIcon("ribbon/navigator_bg_hover.png");

	/**
	 * The navigator background selected icon.
	 */
	private Icon navigatorBackgroundSelectedIcon = IconFactory.getSwingIcon("ribbon/navigator_bg_selected.png");
	
	/**
	 * The navigator combination icon.
	 */
	private CombinationIcon navigatorCombinationIcon = new CombinationIcon(navigatorIcon, navigatorBackgroundIcon, -1, 0);
	
	/**
	 * The navigator tooltip text string.
	 */
	private String navigatorToolTipText = "";
	
	/**
	 * The navigator popup menu.
	 */
	private JPopupMenu navigatorPopupMenu;
	
	/**
	 * The navigator label.
	 */
	private JBasicLabel navigatorLabel;
		
	/**
	 * The dropdown shortcut action.
	 */
	private DropDownShortcutAction dropDownShortcutAction;
	
	/**
	 * The dropdown popup menu.
	 */
	private JPopupMenu dropDownPopupMenu;
	
	/**
	 * The toggle text button group.
	 */
	private ButtonGroup toggleTextButtonGroup;
	
	/**
	 * The toggle icon button group.
	 */
	private ButtonGroup toggleIconButtonGroup;
	
	/**
	 * The tab leading flag container.
	 */
	private TabFlagContainer tabLeadingFlagContainer;
	
	/**
	 * The tab trailing flag container. 
	 */
	private TabFlagContainer tabTrailingFlagContainer;
	
	/**
	 * The toggle height action.
	 */
	private ToggleHeightAction toggleHeightAction;
	
	/**
	 * The shortcut action list.
	 */
	private List shortcutActionList = new ArrayList();
	
	/**
	 * The boolean value of isMinimum.
	 */
	private boolean isMinimum = false;
	
	/**
	 * The ribbon hierarchy.
	 */
	private JRibbonHierarchy ribbonHierarchy;
	
	/**
	 * Constructs with the default.
	 * @param ribbonHierarchy
	 */
	public JRibbonTabbedPane(JRibbonHierarchy ribbonHierarchy)
	{
		this.ribbonHierarchy = ribbonHierarchy;
		
		initNavigator();
		initPopupMenu();
		initListener();
		initStyle();
		
		ribbonHierarchy.getNavigatorContainer().add(this);
	}

	/**
	 * Initializes the navigator.
	 */
	private void initNavigator()
	{
		navigatorLabel = new JBasicLabel(navigatorCombinationIcon, navigatorToolTipText);
		navigatorLabel.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				CombinationIcon combinationIcon = (CombinationIcon) navigatorLabel.getIcon();
				combinationIcon.setLargeIcon(navigatorBackgroundHoverIcon);
				
				navigatorLabel.repaint();
			}
			
			public void mousePressed(MouseEvent e)
			{
				CombinationIcon combinationIcon = (CombinationIcon) navigatorLabel.getIcon();
				combinationIcon.setLargeIcon(navigatorBackgroundSelectedIcon);
				
				navigatorLabel.repaint();
				
				if (navigatorPopupMenu != null)
				{
					navigatorPopupMenu.show(navigatorLabel, 0, navigatorLabel.getHeight());
				}
			}
			
			public void mouseExited(MouseEvent e)
			{
				CombinationIcon combinationIcon = (CombinationIcon) navigatorLabel.getIcon();
				combinationIcon.setLargeIcon(navigatorBackgroundIcon);
				
				navigatorLabel.repaint();
			}
		}
		);
		
		tabLeadingFlagContainer = new TabFlagContainer();
		tabLeadingFlagContainer.add(navigatorLabel, BorderLayout.CENTER);
		setTabLeadingComponent(tabLeadingFlagContainer);
		
		tabTrailingFlagContainer = new TabFlagContainer();
		setTabTrailingComponent(tabTrailingFlagContainer);
		
		toggleHeightAction = new ToggleHeightAction();
		addShortcutAction(toggleHeightAction);
		
		CloseRibbonAction closeRibbonAction = new CloseRibbonAction();
		addShortcutAction(closeRibbonAction);
		
		dropDownShortcutAction = new DropDownShortcutAction();
	}
	
	/**
	 * Initializes the popup menu.
	 */
	private void initPopupMenu()
	{
		dropDownPopupMenu = new JBasicPopupMenu();
		
		toggleTextButtonGroup = new ButtonGroup();
		
		JBasicCheckBoxMenuItem toggleLargTextMenuItem = new JBasicCheckBoxMenuItem(new ToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_large_text"), IconFactory.getSwingIcon("component/label_16.png"), SwingLocale.getString("config_navigatorbar_show_large_text"), JAction.TEXT, JAction.SHOW_LARGE));
		dropDownPopupMenu.add(toggleLargTextMenuItem);
		toggleTextButtonGroup.add(toggleLargTextMenuItem);
		
		JBasicCheckBoxMenuItem toggleSmallTextMenuItem = new JBasicCheckBoxMenuItem(new ToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_small_text"), IconFactory.getSwingIcon("component/label_multi_16.png"), SwingLocale.getString("config_navigatorbar_show_small_text"), JAction.TEXT, JAction.SHOW_SMALL));
		dropDownPopupMenu.add(toggleSmallTextMenuItem);
		toggleTextButtonGroup.add(toggleSmallTextMenuItem);
		
		JBasicCheckBoxMenuItem toggleNoTextMenuItem = new JBasicCheckBoxMenuItem(new ToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_no_text"), IconFactory.getBlankIcon(), SwingLocale.getString("config_navigatorbar_show_no_text"), JAction.TEXT, JAction.SHOW_NO));
		dropDownPopupMenu.add(toggleNoTextMenuItem);
		toggleTextButtonGroup.add(toggleNoTextMenuItem);
		
		dropDownPopupMenu.addSeparator();
		
		toggleIconButtonGroup = new ButtonGroup();
		
		JBasicCheckBoxMenuItem toggleLargIconMenuItem = new JBasicCheckBoxMenuItem(new ToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_large_icon"), IconFactory.getSwingIcon("rectangle_single.png"), SwingLocale.getString("config_navigatorbar_show_large_icon"), JAction.ICON, JAction.SHOW_LARGE));
		dropDownPopupMenu.add(toggleLargIconMenuItem);
		toggleIconButtonGroup.add(toggleLargIconMenuItem);
		
		JBasicCheckBoxMenuItem toggleSmallIconMenuItem = new JBasicCheckBoxMenuItem(new ToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_small_icon"), IconFactory.getSwingIcon("rectangle_multi.png"), SwingLocale.getString("config_navigatorbar_show_small_icon"), JAction.ICON, JAction.SHOW_SMALL));
		dropDownPopupMenu.add(toggleSmallIconMenuItem);
		toggleIconButtonGroup.add(toggleSmallIconMenuItem);
		
		JBasicCheckBoxMenuItem toggleNoIconMenuItem = new JBasicCheckBoxMenuItem(new ToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_no_icon"), IconFactory.getBlankIcon(), SwingLocale.getString("config_navigatorbar_show_no_icon"), JAction.ICON, JAction.SHOW_NO));
		dropDownPopupMenu.add(toggleNoIconMenuItem);
		toggleIconButtonGroup.add(toggleNoIconMenuItem);
	}
	
	/**
	 * Initializes the listener.
	 */
	private void initListener()
	{
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				JAction shortcutAction = getShortcutAction(e);
				
				updateShortcutBar(e, shortcutAction, BUTTON_STYLE_SELECTED);
				
				if (shortcutAction != null)
				{
					if (shortcutAction.getSource() == null)
					{
						shortcutAction.setSource(JRibbonTabbedPane.this);
					}	
					shortcutAction.actionPerformed(null);
				}
			}
			
			public void mouseReleased(MouseEvent e)
			{
				JAction shortcutAction = getShortcutAction(e);
				
				updateShortcutBar(e, shortcutAction, BUTTON_STYLE_HOVER);
			}
			
			public void mouseExited(MouseEvent e)
			{
				updateShortcutBar(e, null, BUTTON_STYLE_NORMAL);
			}
			
			public void mouseClicked(MouseEvent e)
			{
				int index = indexAtLocation(e.getX(), e.getY());
				if (index < 0)
				{
					return;
				}
				
				if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() > 1)
				{
					toggleHeightAction.actionPerformed(null);
				}
			}
		}
		);
		addMouseMotionListener(new MouseAdapter()
		{
			public void mouseMoved(MouseEvent e)
			{
				JAction shortcutAction = getShortcutAction(e);
				if (shortcutAction != null)
				{
					updateShortcutBar(e, shortcutAction, BUTTON_STYLE_HOVER);
				}
				else
				{
					updateShortcutBar(e, null, BUTTON_STYLE_NORMAL);
				}
			}
		}
		);
	}
		
	/**
	 * Initializes the style.
	 */
	private void initStyle()
	{
		setTabShape(SHAPE_ROUNDED_VSNET, RibbonManager.getStyle());
	}
	
	/**
	 * Sets the tab placement.
	 * The tab placement only supports TOP in JRibbonTabbedPane.
	 * @param tabPlacement the tab placement value
	 */
	public void setTabPlacement(int tabPlacement)
	{
		if (tabPlacement != TOP)
		{
			throw new IllegalArgumentException("The tab placement only supports TOP");
		}
		
		super.setTabPlacement(tabPlacement);
	}
	
	/**
	 * Sets the basic tab style.
	 * @param tabShape the tab shape value
	 * @param tabStyle the instance of IStyle
	 */
	protected void setBasicTabStyle(int tabShape, IStyle tabStyle)
	{
		super.setBasicTabStyle(tabShape, tabStyle);
		
		if (tabLeadingFlagContainer != null)
		{	
			tabLeadingFlagContainer.setBorder(BorderFactory.createEmptyBorder(6, 3, 10, 2));
		}	
	}
	
	/**
	 * Sets the eclipse tab style.
	 * @param tabShape the tab shape value
	 * @param tabStyle the instance of IStyle
	 */
	protected void setEclipseTabStyle(int tabShape, IStyle tabStyle)
	{
		super.setEclipseTabStyle(tabShape, tabStyle);
		
		if (tabLeadingFlagContainer != null)
		{	
			tabLeadingFlagContainer.setBorder(BorderFactory.createEmptyBorder(5, 2, 10, 2));
		}		
	}
	
	/**
	 * Gets the title.
	 * @return the title string
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Sets the title
	 * @param title the title string
	 */
	public void setTitle(String title)
	{
		this.title = title;
		
		repaint();
	}
	
	/**
	 * Gets the title font.
	 * @return the title font
	 */
	public Font getTitleFont()
	{
		return titleFont;
	}
	
	/**
	 * Sets the title font.
	 * @param titleFont the title font
	 */
	public void setTitleFont(Font titleFont)
	{
		this.titleFont = titleFont;
		
		repaint();
	}
	
	/**
	 * Gets the title color.
	 * @return the title color
	 */
	public Color getTitleColor()
	{
		return titleColor;
	}
	
	/**
	 * Sets the title color.
	 * @param titleColor the title color
	 */
	public void setTitleColor(Color titleColor)
	{
		this.titleColor = titleColor;
		
		repaint();
	}
	
	/**
	 * Gets the navigator icon.
	 * @return the navigator icon
	 */
	public Icon getNavigatorIcon()
	{
		return navigatorIcon;
	}
	
	/**
	 * Sets the navigator icon.
	 * @param navigatorIcon
	 */
	public void setNavigatorIcon(Icon navigatorIcon)
	{
		this.navigatorIcon = navigatorIcon;
		
		CombinationIcon combinationIcon = (CombinationIcon) navigatorLabel.getIcon();
		combinationIcon.setSmallIcon(navigatorIcon);
		
		navigatorLabel.repaint();
	}
	
	/**
	 * Gets the navigator tooltip text.
	 * @return the navigator tooltip text string
	 */
	public String getNavigatorToolTipText()
	{
		return navigatorToolTipText;
	}
	
	/**
	 * Sets the navigator tooltip text.
	 * @param navigatorToolTipText the navigator tooltip text string
	 */
	public void setNavigatorToolTipText(String navigatorToolTipText)
	{
		this.navigatorToolTipText = navigatorToolTipText;
		
		navigatorLabel.setToolTipText(navigatorToolTipText);
	}
	
	/**
	 * Gets the navigator popup menu.
	 * @return the navigator popup menu
	 */
	public JPopupMenu getNavigatorPopupMenu()
	{
		return navigatorPopupMenu;
	}
	
	/**
	 * Sets the navigator popup menu.
	 * @param navigatorPopupMenu the navigator popup menu
	 */
	public void setNavigatorPopupMenu(JPopupMenu navigatorPopupMenu)
	{
		this.navigatorPopupMenu = navigatorPopupMenu;
	}
	
	/**
	 * Gets the dropdown popup menu.
	 * @return the dropdown popup menu
	 */
	public JPopupMenu getDropDownPopupMenu()
	{
		return dropDownPopupMenu;
	}
	
	/**
	 * Sets the dropdown popup menu.
	 * @param dropDownPopupMenu the dropdown popup menu
	 */
	public void setDropDownPopupMenu(JPopupMenu dropDownPopupMenu)
	{
		this.dropDownPopupMenu = dropDownPopupMenu;
	}
	
	/**
	 * Gets the trailing flag component.
	 * @return the trailing flag component
	 */
	public Component getTrailingFlagComponent()
	{
		if (tabTrailingFlagContainer.getComponentCount() == 0)
		{
			return null;
		}	
			
		return tabTrailingFlagContainer.getComponent(0);
	}
	
	/**
	 * Sets the trailing flag component.
	 * @param trailingFlagComponent the trailing flag component
	 */
	public void setTrailingFlagComponent(Component trailingFlagComponent)
	{				
		tabTrailingFlagContainer.addComponent(trailingFlagComponent, BorderLayout.CENTER);
		tabTrailingFlagContainer.setPreferredSize(new Dimension(tabTrailingFlagContainer.getPreferredSize().width, 53));
	}
	
	/**
	 * Gets the shortcut action list.
	 * @return the shortcut action list
	 */
	public List getShortcutActionList()
	{
		return shortcutActionList;
	}
	
	/**
	 * Sets the shortcut action list.
	 * @param shortcutActionList  the shortcut action list
	 */
	public void setShortcutActionList(List shortcutActionList)
	{
		this.shortcutActionList = shortcutActionList;
		
		repaint();
	}
	
	/**
	 * Adds the shortcut action.
	 * @param shortcutAction the shortcut action
	 */
	public void addShortcutAction(JAction shortcutAction)
	{
		shortcutActionList.add(shortcutAction);
		
		repaint();
	}
	
	/**
	 * Adds the shortcut action with the index.
	 * @param index the index value
	 * @param shortcutAction the shortcut action
	 */
	public void addShortcutAction(int index, JAction shortcutAction)
	{
		shortcutActionList.add(index, shortcutAction);
		
		repaint();
	}
	
	/**
	 * Adds the shortcut action list.
	 * @param shortcutActions the added shortcut action list
	 */
	public void addShortcutActions(List shortcutActions)
	{
		shortcutActionList.addAll(shortcutActions);
		
		repaint();
	}
	
	/**
	 * Adds the shortcut action list.
	 * @param index the index value
	 * @param shortcutActions the added shortcut action list
	 */
	public void addShortcutActions(int index, List shortcutActions)
	{
		shortcutActionList.addAll(index, shortcutActions);
		
		repaint();
	}
	
	/**
	 * Removes the shortcut action.
	 * @param shortcutAction the shortcut action
	 */
	public void removeShortcutAction(JAction shortcutAction)
	{
		shortcutActionList.remove(shortcutAction);
		
		repaint();
	}
	
	/**
	 * Removes the shortcut action with the index.
	 * @param index the index value
	 */
	public void removeShortcutAction(int index)
	{
		shortcutActionList.remove(index);
		
		repaint();
	}
	
	/**
	 * Removes the shortcut action list.
	 * @param shortcutActions the removed shortcut action list
	 */
	public void removeShortcutActions(List shortcutActions)
	{
		shortcutActionList.removeAll(shortcutActions);
		
		repaint();
	}
	
	/**
	 * Gets the shortcut action button.
	 * @param e the instance of MouseEvent
	 * @return the instance of JAction
	 */
	private JAction getShortcutAction(MouseEvent e)
	{		
		int x = e.getX();
		int y = e.getY();
		
		if (shortcutActionList != null && !shortcutActionList.isEmpty())
		{
			for (Iterator iterator = shortcutActionList.iterator(); iterator.hasNext();)
			{
				JAction shortcutAction = (JAction) iterator.next();
				
				int startX = ((Integer) shortcutAction.getValue("startX")).intValue();
				int startY = ((Integer) shortcutAction.getValue("startY")).intValue();
				
				int endX = ((Integer) shortcutAction.getValue("endX")).intValue();
				int endY = ((Integer) shortcutAction.getValue("endY")).intValue();
				
				if (x >= startX && x <= endX && y >= startY && y <= endY)
				{
					return shortcutAction;
				}
			}
		}
		
		int startX = ((Integer) dropDownShortcutAction.getValue("startX")).intValue();
		int startY = ((Integer) dropDownShortcutAction.getValue("startY")).intValue();
		
		int endX = ((Integer) dropDownShortcutAction.getValue("endX")).intValue();
		int endY = ((Integer) dropDownShortcutAction.getValue("endY")).intValue();
		
		if (x >= startX && x <= endX && y >= startY && y <= endY)
		{
			return dropDownShortcutAction;
		}
		
		return null;
	}
	
	/**
	 * Gets the ribbon hierarchy.
	 * @return the instance of JRibbonHierarchy
	 */
	public JRibbonHierarchy getRibbonHierarchy()
	{
		return ribbonHierarchy;
	}
	
	/**
	 * Gets the ribbon container.
	 * @return the instance of JRibbonContainer
	 */
	public JRibbonContainer getRibbonContainer()
	{
		return ribbonHierarchy.getRibbonContainer();
	}
	
	/**
	 * Toggles the height for the ribbon tabbed pane.
	 * It will show or hide the content of tabbed pane.
	 */
	private void toggleHeight()
	{
		int tabHeight = TabbedPaneManager.getTabHeight(this);
		int contentHeight = TabbedPaneManager.getMaxPreferredContentHeight(this);
		
		if (!isMinimum)
		{
			setPreferredSize(new Dimension(getSize().width, tabHeight));	
		}
		else
		{
			setPreferredSize(new Dimension(getSize().width, tabHeight + contentHeight));	
		}
		
		ContainerManager.update(this);
		
		isMinimum = !isMinimum;
	}
	
	/**
	 * Toggles the facade by a show type and show value.
	 * The show type values are "text" and "icon".
	 * The show value values are SHOW_SMALL, SHOW_LARGE and SHOW_NO. (See JAction definition).
	 * For example, if the showType is "icon" and the showValue is SHOW_LARGE, the component will display the icon as a large style.
	 * @param showType the show type
	 * @param showValue the show value
	 */
	private void toggleFacade(String showType, int showValue)
	{
		for (int i = 0; i < getTabCount(); i++)
		{
			JRibbonBar ribbonBar = (JRibbonBar) getComponentAt(i);
			ribbonBar.toggleFacade(showType, showValue);
		}
		
		if (!isMinimum)
		{	
			setPreferredSize(null);
			ContainerManager.update(this);
		}
	}
	
	/**
	 * Sets the facade.
	 * @param textShowValue the text show value
	 * @param iconShowValue the icon show value
	 */
	public void setFacade(int textShowValue, int iconShowValue)
	{
		for (Enumeration enumeration = toggleTextButtonGroup.getElements(); enumeration.hasMoreElements();)
		{
			AbstractButton button = (AbstractButton) enumeration.nextElement();
			ToggleFacadeAction action = (ToggleFacadeAction) button.getAction();
			if (action.getShowValue() == textShowValue)
			{
				button.doClick();
				
				break;
			}
		}
		
		for (Enumeration enumeration = toggleIconButtonGroup.getElements(); enumeration.hasMoreElements();)
		{
			AbstractButton button = (AbstractButton) enumeration.nextElement();
			ToggleFacadeAction action = (ToggleFacadeAction) button.getAction();
			if (action.getShowValue() == iconShowValue)
			{
				button.doClick();
				
				break;
			}
		}
	}
	
	/**
	 * Updates the shortcut bar.
	 * @param e the instance of MouseEvent
	 * @param shortcutAction the shortcut action
	 * @param buttonStyle the button style
	 */
	private void updateShortcutBar(MouseEvent e, JAction shortcutAction, int buttonStyle)
	{
		if (shortcutActionList != null && !shortcutActionList.isEmpty())
		{
			for (Iterator iterator = shortcutActionList.iterator(); iterator.hasNext();)
			{
				JAction action = (JAction) iterator.next();
				switch (buttonStyle)
				{
					case BUTTON_STYLE_NORMAL :
					{
						action.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_NORMAL));
						break;
					}
					case BUTTON_STYLE_HOVER :
					{
						if (action == shortcutAction)
						{
							action.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_HOVER));
						}
						else
						{
							action.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_NORMAL));
						}
						break;
					}
					case BUTTON_STYLE_SELECTED :
					{
						if (action == shortcutAction)
						{
							action.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_SELECTED));
						}
						else
						{
							action.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_NORMAL));
						}
						break;
					}
				}
			}
		}
		
		if (shortcutAction == dropDownShortcutAction)
		{
			switch (buttonStyle)
			{
				case BUTTON_STYLE_NORMAL :
				{
					shortcutAction.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_NORMAL));
					break;
				}
				case BUTTON_STYLE_HOVER :
				{
					shortcutAction.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_HOVER));
					break;
				}
				case BUTTON_STYLE_SELECTED :
				{
					shortcutAction.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_SELECTED));
					break;
				}
			}
		}
		else
		{
			dropDownShortcutAction.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_NORMAL));
		}
		
		updateShortcutBar();
	}
	
	/**
	 * Updates the shortcut bar.
	 */
	private void updateShortcutBar()
	{
		if (shortcutActionList == null || shortcutActionList.isEmpty())
		{
			return;
		}
		
		JAction firstShortcutAction = (JAction) shortcutActionList.get(0);
		JAction lastShortcutAction = dropDownShortcutAction;
		
		int startX = ((Integer) firstShortcutAction.getValue("startX")).intValue();
		int startY = ((Integer) firstShortcutAction.getValue("startY")).intValue();
		
		int endX = ((Integer) lastShortcutAction.getValue("endX")).intValue();
		int endY = ((Integer) lastShortcutAction.getValue("endY")).intValue();
		
		paintImmediately(startX, startY, endX - startX, endY - startY);
	}
	
	/**
	 * Paints the component.
	 * @param g the instance of Graphics
	 */
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		Color color = g2d.getColor();
		Font font = g2d.getFont();
		
		paintBackground(g2d);
		paintTitle(g2d);
		paintShortcutBar(g2d);
		
		g2d.setColor(color);
		g2d.setFont(font);
		
		super.paintComponent(g);
	}
	
	/**
	 * Paints the background.
	 * @param g2d the instance of Graphics2D
	 */
	private void paintBackground(Graphics2D g2d)
	{
		int width = getWidth();
		
		JGradientPainter.fastFill(g2d, new Rectangle(0, 1, width, 4), new Color(226, 235, 244), new Color(220, 234, 236), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 5, width, 4), new Color(213, 229, 250), new Color(216, 231, 250), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 9, width, 19), new Color(202, 222, 247), new Color(227, 239, 253), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 28, width, 1), new Color(219, 244, 254), new Color(219, 244, 254), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 29, width, 1), new Color(176, 207, 247), new Color(176, 207, 247), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 30, width, 1), new Color(219, 232, 249), new Color(219, 232, 249), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 31, width, 23), new Color(191, 219, 255), new Color(186, 215, 253), true);
	}
	
	/**
	 * Paint the title.
	 * @param g2d the instance of Graphics2D
	 */
	private void paintTitle(Graphics2D g2d)
	{
		g2d.setColor(titleColor);
		g2d.setFont(titleFont);
		
		int width = getWidth();
		int height = 28;
		
		if (width > 400)
		{	
			FontManager.drawCenterString(g2d, title, width, height, 0, 0);
		}
	}
	
	/**
	 * Paints the shortcut bar.
	 * @param g2d the instance of Graphics2D
	 */
	private void paintShortcutBar(Graphics2D g2d)
	{
		int x = 47;
		int y = 4;
		
		int buttonWidth = 22;
		int buttonCount = (shortcutActionList != null ? shortcutActionList.size() : 0);
		
		int width = buttonWidth * buttonCount + 1;
		
		g2d.drawImage(IconFactory.getSwingIcon("ribbon/toolbar_bg_left.png").getImage(), x - 14, y, null);
		g2d.drawImage(IconFactory.getSwingIcon("ribbon/toolbar_bg_right.png").getImage(), x + width, y, null);
		
		JGradientPainter.fastFill(g2d, new Rectangle(x, y, width, 1), new Color(246, 249, 252), new Color(240, 245, 252), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 1, width, 1), new Color(186, 204, 226), new Color(191, 208, 229), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 2, width, 1), new Color(222, 231, 244), new Color(216, 227, 241), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 3, width, 1), new Color(230, 238, 249), new Color(230, 238, 249), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 4, width, 1), new Color(219, 231, 247), new Color(219, 231, 247), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 5, width, 1), new Color(216, 229, 245), new Color(216, 229, 245), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 6, width, 1), new Color(213, 226, 244), new Color(213, 226, 244), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 7, width, 1), new Color(210, 224, 242), new Color(210, 224, 242), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 8, width, 1), new Color(206, 222, 241), new Color(206, 222, 241), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 9, width, 1), new Color(204, 220, 239), new Color(204, 220, 239), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 10, width, 1), new Color(202, 218, 238), new Color(202, 218, 238), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 11, width, 1), new Color(200, 216, 238), new Color(200, 216, 238), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 12, width, 1), new Color(199, 215, 237), new Color(199, 215, 237), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 13, width, 1), new Color(196, 214, 237), new Color(196, 214, 237), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 14, width, 1), new Color(196, 214, 236), new Color(196, 214, 236), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 15, width, 1), new Color(195, 213, 236), new Color(195, 213, 236), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 16, width, 1), new Color(196, 214, 237), new Color(196, 214, 237), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 17, width, 1), new Color(196, 213, 237), new Color(196, 213, 237), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 18, width, 1), new Color(197, 214, 237), new Color(197, 214, 237), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 19, width, 1), new Color(199, 215, 237), new Color(199, 215, 237), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 20, width, 1), new Color(201, 216, 238), new Color(201, 216, 238), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 21, width, 1), new Color(201, 217, 238), new Color(197, 214, 235), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 22, width, 1), new Color(154, 179, 213), new Color(162, 185, 217), false);
		
		if (buttonCount > 0)
		{
			x += 1;
			y += 1;
			
			for (Iterator iterator = shortcutActionList.iterator(); iterator.hasNext();)
			{
				JAction shortcutAction = (JAction) iterator.next();
				
				Integer buttonStyle = (Integer) shortcutAction.getValue(BUTTON_STYLE);
				if (buttonStyle != null)
				{
					switch (buttonStyle.intValue())
					{
						case BUTTON_STYLE_NORMAL :
						{
							break;
						}
						case BUTTON_STYLE_HOVER :
						{
							g2d.drawImage(IconFactory.getSwingIcon("ribbon/button_bg_hover.png").getImage(), x, y, null);
							break;
						}
						case BUTTON_STYLE_SELECTED :
						{
							g2d.drawImage(IconFactory.getSwingIcon("ribbon/button_bg_selected.png").getImage(), x, y, null);
							break;
						}
					}
				}
				
				Icon shortcutIcon = shortcutAction.getIcon();
				if (shortcutIcon instanceof ImageIcon)
				{
					ImageIcon shortcutImageIcon = (ImageIcon) shortcutIcon;
					g2d.drawImage(shortcutImageIcon.getImage(), x + 22 / 2 - shortcutIcon.getIconWidth() / 2, y + 22 / 2 - shortcutIcon.getIconHeight() / 2, null);
				}
				
				shortcutAction.putValue("startX", Integer.valueOf(x));
				shortcutAction.putValue("startY", Integer.valueOf(y));
				
				x += buttonWidth;
				
				shortcutAction.putValue("endX", Integer.valueOf(x));
				shortcutAction.putValue("endY", Integer.valueOf(y + 22));
			}
		}
		
		Integer buttonStyle = (Integer) dropDownShortcutAction.getValue(BUTTON_STYLE);
		if (buttonStyle != null)
		{
			switch (buttonStyle.intValue())
			{
				case BUTTON_STYLE_NORMAL :
				{
					break;
				}
				case BUTTON_STYLE_HOVER :
				{
					g2d.drawImage(IconFactory.getSwingIcon("ribbon/button_bg_hover_micro.png").getImage(), x + 12, y, null);
					break;
				}
				case BUTTON_STYLE_SELECTED :
				{
					g2d.drawImage(IconFactory.getSwingIcon("ribbon/button_bg_selected_micro.png").getImage(), x + 12, y, null);
					break;
				}
			}
		}
		
		g2d.drawImage(IconFactory.getSwingIcon("ribbon/arrow.png").getImage(), x + 12, y, null);
		
		dropDownShortcutAction.putValue("startX", Integer.valueOf(x + 12));
		dropDownShortcutAction.putValue("startY", Integer.valueOf(y));
		
		dropDownShortcutAction.putValue("endX", Integer.valueOf(x + 12 + 13));
		dropDownShortcutAction.putValue("endY", Integer.valueOf(y + 22));
	}
	
	public class CloseRibbonAction
		extends JAction
	{
		/**
		 * Constructs with the default.
		 */
		public CloseRibbonAction()
		{
			super(SwingLocale.getString("close_panel"), IconFactory.getSwingIcon("ribbon/close.png"), SwingLocale.getString("close_panel"));
		}
		
		/**
		 * Invoked when an action occurs.
		 * @param e the instance of ActionEvent
		 */
		public void actionPerformed(ActionEvent e)
		{
			JRibbonContainer ribbonContainer = getRibbonContainer();
			ribbonContainer.closeRibbonComponent();
		}
	}
	
	public class ToggleHeightAction
		extends JAction
	{
		/**
		 * Constructs with the default.
		 */
		public ToggleHeightAction()
		{
			super(SwingLocale.getString("toggle_navigatorbar_visibility"), IconFactory.getSwingIcon("ribbon/toggle_up.png"), SwingLocale.getString("toggle_navigatorbar_visibility"));
		}
		
		/**
		 * Invoked when an action occurs.
		 * @param e the instance of ActionEvent
		 */
		public void actionPerformed(ActionEvent e)
		{
			toggleHeight();
			
			if (isMinimum)
			{	
				setIcon(IconFactory.getSwingIcon("ribbon/toggle_down.png"));
			}
			else
			{
				setIcon(IconFactory.getSwingIcon("ribbon/toggle_up.png"));
			}
			
			updateShortcutBar();
		}
	}
	
	public class ToggleFacadeAction
		extends JAction
	{
		/**
		 * The show type.
		 */
		private String showType;
		
		/**
		 * The show value.
		 */
		private int showValue;
		
		/**
		 * Constructs with the specified initial text, icon, tooltip text, ribbon navigator bar, show type and show value.
		 * @param text the text string
		 * @param icon the instance of Icon
		 * @param toolTipText the tooltip text string
		 * @param ribbonNavigatorBar the instance of JRibbonNavigatorBar
		 * @param showType the show type
		 * @param showValue the show value
		 */
		public ToggleFacadeAction(String text, Icon icon, String toolTipText, String showType, int showValue)
		{
			super(text, icon, toolTipText);
			
			this.showType = showType;
			this.showValue = showValue;
		}
		
		/**
		 * Gets the show type.
		 * @return the show type value
		 */
		public String getShowType()
		{
			return showType;
		}
		
		/**
		 * Sets the show type.
		 * @param showType the show type
		 */
		public void setShowType(String showType)
		{
			this.showType = showType;
		}
		
		/**
		 * Gets the show value.
		 * @return the show value
		 */
		public int getShowValue()
		{
			return showValue;
		}
		
		/**
		 * Sets the show value.
		 * @param showValue the show value
		 */
		public void setShowValue(int showValue)
		{
			this.showValue = showValue;
		}
		
		/**
		 * Invoked when an action occurs.
		 * @param e the instance of ActionEvent
		 */
		public void actionPerformed(ActionEvent e)
		{
			toggleFacade(showType, showValue);
		}
	}
	
	public class DropDownShortcutAction
		extends JAction
	{
		/**
		 * Constructs with the default
		 */
		public DropDownShortcutAction()
		{
			super(SwingLocale.getString("ribbon_shortcut"), IconFactory.getSwingIcon("ribbon/arrow.png"), SwingLocale.getString("ribbon_shortcut"));
		}
		
		/**
		 * Invoked when an action occurs.
		 * @param e the instance of ActionEvent
		 */
		public void actionPerformed(ActionEvent e)
		{
			if (dropDownPopupMenu != null)
			{
				int startX = ((Integer) dropDownShortcutAction.getValue("startX")).intValue();
				int endY = ((Integer) dropDownShortcutAction.getValue("endY")).intValue();
				
				dropDownPopupMenu.show(JRibbonTabbedPane.this, startX, endY);
			}
		}
	}
	
	public class TabFlagContainer
		extends JContainer implements UIResource
	{
		/**
		 * Constructs with the default.
		 */
		public TabFlagContainer()
		{
			setLayout(new BorderLayout());
			setOpaque(false);
		}
	}
}