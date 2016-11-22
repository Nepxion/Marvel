package com.nepxion.demo;

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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import org.dom4j.DocumentException;

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.demo.component.ribbon.DemoRibbonBar;
import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.activex.ActiveXManager;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.framework.ribbon.JRibbonContainer;
import com.nepxion.swing.framework.ribbon.JRibbonHierarchy;
import com.nepxion.swing.framework.ribbon.JRibbonTabbedPane;
import com.nepxion.swing.framework.ribbon.action.JRibbonAction;
import com.nepxion.swing.framework.ribbon.xml.Dom4JRibbonConstants;
import com.nepxion.swing.framework.ribbon.xml.Dom4JRibbonParser;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.listener.SelectionListener;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;
import com.nepxion.swing.renderer.combobox.ElementComboBoxCellRenderer;
import com.nepxion.swing.style.framework.IStyle;
import com.nepxion.swing.style.framework.JRibbonStyle;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;
import com.nepxion.util.data.CollectionUtil;
import com.nepxion.util.io.FileContext;

public class DemoRibbonNavigatorBar
	extends JRibbonTabbedPane
{		
	public DemoRibbonNavigatorBar(JRibbonHierarchy ribbonHierarchy)
	{
		super(ribbonHierarchy);
		
		initHeader();
		initBody();
	}
	
	private void initHeader()
	{
		// setTabShape(JEclipseTabbedPane.SHAPE_ECLIPSE3X, new JRibbonStyle());		
		setTabShape(JEclipseTabbedPane.SHAPE_ROUNDED_VSNET, new JRibbonStyle());
		
		setTitle("Nepxion Swing Repository");
		setTitleFont(new Font("微软雅黑", Font.PLAIN, 12));
		setTitleColor(Color.darkGray);
		
		setNavigatorIcon(IconFactory.getSwingIcon("ribbon/navigator_nepxion.png"));
		setNavigatorToolTipText("Nepxion Studio");
		
		JPopupMenu navigatorPopupMenu = new JBasicPopupMenu();
		navigatorPopupMenu.add(new JBasicMenuItem(getChangeStyleAction()));
		navigatorPopupMenu.addSeparator();
		navigatorPopupMenu.add(new JBasicMenuItem(getChangeTitleAction()));
		navigatorPopupMenu.add(new JBasicMenuItem(getChangeNavigatorAction()));
		navigatorPopupMenu.add(new JBasicMenuItem(getTrailingFlagComponentAction()));
		navigatorPopupMenu.addSeparator();
		navigatorPopupMenu.add(new JBasicMenuItem(getAddToShortcutBarAction()));
		navigatorPopupMenu.add(new JBasicMenuItem(getRemoveFromShortcutBarAction()));
		navigatorPopupMenu.addSeparator();
		navigatorPopupMenu.add(new JBasicMenuItem(getAddToShortcutMenuAction()));
		navigatorPopupMenu.add(new JBasicMenuItem(getRemoveFromShortcutMenuAction()));
		setNavigatorPopupMenu(navigatorPopupMenu);
		
		JLabel trailingFlagLabel = new JLabel(IconFactory.getSwingIcon("logo.png"));
		trailingFlagLabel.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				try
				{
					ActiveXManager.callWeb(null, "https://github.com/Nepxion/");
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
		);
		setTrailingFlagComponent(trailingFlagLabel);
	}
	
	private void initBody()
	{		
		JRibbonContainer ribbonContainer = getRibbonContainer();
		
		String content = FileContext.getContent(Dom4JRibbonConstants.CONFIG_FILE_PATH);
		
		Dom4JRibbonParser ribbonParser = new Dom4JRibbonParser(ribbonContainer, this);
		ribbonParser.setContextIcon(false);
		
		try
		{
			ribbonParser.parse(content);
		}
		catch (DocumentException e)
		{
			e.printStackTrace();
		}
		
		addTab("Ribbon - Coding", null, new DemoRibbonBar(ribbonContainer), "Ribbon Control");
		
		setFacade(JRibbonAction.SHOW_LARGE, JRibbonAction.SHOW_LARGE);
	}
	
	// Test for JRibbon Framework
	private JSecurityAction getChangeStyleAction()
	{
		JSecurityAction action = new JSecurityAction("更改选项卡风格", IconFactory.getSwingIcon("stereo/edit_16.png"), "更改选项卡风格")
		{
			public void execute(ActionEvent e)
			{
				JPanel panel = new JPanel();
				panel.setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
				panel.setBorder(BorderManager.createComplexTitledBorder("更改选项卡风格"));
				
				List tabShapeElementNodes = DemoDataFactory.getTabShapeElementNodes();
				
				final JBasicComboBox tabShapeComboBox = new JBasicComboBox(CollectionUtil.parseVector(tabShapeElementNodes));
				tabShapeComboBox.setRenderer(new ElementComboBoxCellRenderer());
				tabShapeComboBox.addItemListener(new SelectionListener()
				{
					public void itemSelectionStateChanged(ItemEvent e)
					{
						ElementNode elementNode = (ElementNode) tabShapeComboBox.getSelectedItem();
						setTabShape(elementNode.getIndex());
					}
				}
				);
				panel.add(tabShapeComboBox);
				
				List styleElementNodes = DemoDataFactory.getStyleElementNodes();
				
				final JBasicComboBox styleComboBox = new JBasicComboBox(CollectionUtil.parseVector(styleElementNodes));
				styleComboBox.setRenderer(new ElementComboBoxCellRenderer());
				styleComboBox.addItemListener(new SelectionListener()
				{
					public void itemSelectionStateChanged(ItemEvent e)
					{
						ElementNode elementNode = (ElementNode) styleComboBox.getSelectedItem();
						setTabShape((IStyle) elementNode.getUserObject());
					}
				}
				);
				panel.add(styleComboBox);
				
				JBasicOptionPane.showDialog(HandleManager.getFrame(DemoRibbonNavigatorBar.this), panel, "", null, new Object[] {SwingLocale.getString("close")}, true);
			}			
		};
		
		return action;
	}
	
	private JSecurityAction getChangeTitleAction()
	{
		JSecurityAction action = new JSecurityAction("更改标题内容", IconFactory.getSwingIcon("stereo/edit_16.png"), "更改标题内容")
		{
			public void execute(ActionEvent e)
			{
				String value = JBasicOptionPane.showInputDialog(null);
				if (value != null)
				{
					setTitle(value.trim());
				}	
			}			
		};
		
		return action;
	}
	
	private JSecurityAction getChangeNavigatorAction()
	{
		JSecurityAction action = new JSecurityAction("更改导航图标", IconFactory.getSwingIcon("stereo/edit_16.png"), "更改导航图标")
		{
			public void execute(ActionEvent e)
			{
				Icon navigatorIcon = getNavigatorIcon();
				if (navigatorIcon == IconFactory.getSwingIcon("ribbon/navigator.png"))
				{	
					setNavigatorIcon(IconFactory.getSwingIcon("ribbon/navigator_nepxion.png"));
				}
				else
				{
					setNavigatorIcon(IconFactory.getSwingIcon("ribbon/navigator.png"));
				}
			}			
		};
		
		return action;
	}
	
	private JSecurityAction getTrailingFlagComponentAction()
	{
		JSecurityAction action = new JSecurityAction("更改旗标组件", IconFactory.getSwingIcon("stereo/edit_16.png"), "更改旗标组件")
		{
			public void execute(ActionEvent e)
			{
				Component getTrailingFlagComponent = getTrailingFlagComponent();
				
				if (getTrailingFlagComponent instanceof JLabel)
				{
					JClassicButton trailingFlagButton = new JClassicButton(IconFactory.getSwingIcon("logo.png"));
					trailingFlagButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							try
							{
								ActiveXManager.callWeb(null, "http://code.google.com/p/nepxion/");
							}
							catch (Exception ex)
							{
								ex.printStackTrace();
							}
						}
					}
					);
					setTrailingFlagComponent(trailingFlagButton);
				}
				else
				{
					JLabel trailingFlagLabel = new JLabel(IconFactory.getSwingIcon("logo.png"));
					trailingFlagLabel.addMouseListener(new MouseAdapter()
					{
						public void mousePressed(MouseEvent e)
						{
							try
							{
								ActiveXManager.callWeb(null, "http://code.google.com/p/nepxion/");
							}
							catch (Exception ex)
							{
								ex.printStackTrace();
							}
						}
					}
					);
					setTrailingFlagComponent(trailingFlagLabel);
				}
			}			
		};
		
		return action;
	}
	
	int shortcutButtonIndex = 0;
	private JSecurityAction getAddToShortcutBarAction()
	{
		JSecurityAction action = new JSecurityAction("添加快速访问按钮", IconFactory.getSwingIcon("stereo/add_16.png"), "添加快速访问按钮")
		{
			public void execute(ActionEvent e)
			{
				if (shortcutButtonIndex % 3 == 0)
				{	
					addShortcutAction(getShowDialogAction("Maximize", IconFactory.getSwingIcon("ribbon/maximize.png"), "Maximize"));
				}
				else if (shortcutButtonIndex % 3 == 1)
				{	
					addShortcutAction(getShowDialogAction("Restore", IconFactory.getSwingIcon("ribbon/restore.png"), "Restore"));
				}
				else if (shortcutButtonIndex % 3 == 2)
				{	
					addShortcutAction(getShowDialogAction("Minimize", IconFactory.getSwingIcon("ribbon/minimize.png"), "Minimize"));
				}
				shortcutButtonIndex++;
			}			
		};
		
		return action;
	}
	
	private JSecurityAction getRemoveFromShortcutBarAction()
	{
		JSecurityAction action = new JSecurityAction("删除快速访问按钮", IconFactory.getSwingIcon("stereo/delete_16.png"), "删除快速访问按钮")
		{
			public void execute(ActionEvent e)
			{
				int size = getShortcutActionList().size();
				
				removeShortcutAction(size - 1);
			}			
		};
		
		return action;
	}
	
	int shortcutMenuIndex = 0;
	private JSecurityAction getAddToShortcutMenuAction()
	{
		JSecurityAction action = new JSecurityAction("添加快速访问菜单", IconFactory.getSwingIcon("stereo/add_16.png"), "添加快速访问菜单")
		{
			public void execute(ActionEvent e)
			{
				JPopupMenu dropDownPopupMenu = getDropDownPopupMenu();
				if (shortcutMenuIndex % 3 == 0)
				{	
					dropDownPopupMenu.addSeparator();
					dropDownPopupMenu.add(new JBasicMenuItem(getShowDialogAction("Maximize", IconFactory.getSwingIcon("ribbon/maximize.png"), "Maximize")));
				}
				else if (shortcutMenuIndex % 3 == 1)
				{	
					dropDownPopupMenu.add(new JBasicMenuItem(getShowDialogAction("Restore", IconFactory.getSwingIcon("ribbon/restore.png"), "Restore")));
				}
				else if (shortcutMenuIndex % 3 == 2)
				{	
					dropDownPopupMenu.add(new JBasicMenuItem(getShowDialogAction("Minimize", IconFactory.getSwingIcon("ribbon/minimize.png"), "Minimize")));
				}
				shortcutMenuIndex++;
			}			
		};
		
		return action;
	}
	
	private JSecurityAction getRemoveFromShortcutMenuAction()
	{
		JSecurityAction action = new JSecurityAction("删除快速访问菜单", IconFactory.getSwingIcon("stereo/delete_16.png"), "删除快速访问菜单")
		{
			public void execute(ActionEvent e)
			{
				JPopupMenu dropDownPopupMenu = getDropDownPopupMenu();
				
				int size = dropDownPopupMenu.getComponentCount();
				
				dropDownPopupMenu.remove(size - 1);
			}			
		};
		
		return action;
	}
	
	private JSecurityAction getShowDialogAction(final String text, Icon icon, String toolTipText)
	{
		JSecurityAction action = new JSecurityAction(text, icon, toolTipText)
		{
			public void execute(ActionEvent e)
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame(DemoRibbonNavigatorBar.this), text);
			}			
		};
		
		return action;
	}
}