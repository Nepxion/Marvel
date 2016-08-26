package com.nepxion.demo.component.dockable;

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
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.nepxion.demo.DemoController;
import com.nepxion.demo.common.DemoComponentFactory;
import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.swing.framework.JFrameWorkStatusBar;
import com.nepxion.swing.framework.dockable.DockableManager;
import com.nepxion.swing.framework.dockable.JDockable;
import com.nepxion.swing.framework.dockable.JDockableHierarchy;
import com.nepxion.swing.framework.dockable.JDockableView;
import com.nepxion.swing.gradient.JBackgroundPainter;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.menu.JBasicMenu;
import com.nepxion.swing.menubar.JBasicMenuBar;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.selector.checkbox.JCheckBoxListPanel;
import com.nepxion.swing.selector.radiobutton.JRadioButtonListPanel;
import com.nepxion.swing.style.texture.ITextureStyle;
import com.nepxion.swing.style.texture.basic.JBlueTextureStyle;
import com.nepxion.swing.textarea.JBasicTextArea;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class DemoDockableFrameWorkPanel
	extends JPanel
{
	public DemoDockableFrameWorkPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new DockableHierarchy());
	}
	
	public class DockableHierarchy
		extends JDockableHierarchy
	{
		public static final String TREE_TITLE = "Tree View";
		public static final String TABLE_TITLE = "Table View";
		public static final String TEXT_AREA_TITLE = "TextArea View";
		public static final String TABBED_PANE_TITLE = "TabbedPane View";
		public static final String LIST_TITLE = "List View";
		public static final String CHECK_BOX_SELECTOR_TITLE = "CheckBox Selector View";
		public static final String RADIO_BUTTON_SELECTOR_TITLE = "RadioButton Selector View";
		
		public DockableHierarchy()
		{
			initContentPane();
			initMenuBar();
			initToolBar();
			initStatusBar();
		}
		
		private void initContentPane()
		{
			JDockableView treeView = new JDockableView(TREE_TITLE, IconFactory.getSwingIcon("component/tree_16.png"), TREE_TITLE, new JBasicScrollPane(DemoComponentFactory.getTree()));
			JDockableView tableView = new JDockableView(TABLE_TITLE, IconFactory.getSwingIcon("component/table_16.png"), TABLE_TITLE, new JBasicScrollPane(DemoComponentFactory.getTable()));
			JDockableView textAreaView = new JDockableView(TEXT_AREA_TITLE, IconFactory.getSwingIcon("component/text_area_16.png"), TEXT_AREA_TITLE, new JBasicScrollPane(new JBasicTextArea("TextArea View")));
			
			JDockable leftDockable = new JDockable();
			leftDockable.setOrientation(JDockable.VERTICAL_SPLIT);
			leftDockable.add(treeView, JDockable.FLEXIBLE);
			leftDockable.add(tableView, JDockable.FLEXIBLE);
			leftDockable.add(textAreaView, JDockable.VARY);
			leftDockable.setDividerLocation(0, 150);
			leftDockable.setDividerLocation(1, 200);
			
			JDockableView tabbedPaneView = new JDockableView(TABBED_PANE_TITLE, IconFactory.getSwingIcon("component/tabbed_pane_16.png"), TABBED_PANE_TITLE, DemoComponentFactory.getTabbedPane());
			
			JDockableView listView = new JDockableView(LIST_TITLE, IconFactory.getSwingIcon("component/list_16.png"), LIST_TITLE, new JBasicScrollPane(DemoComponentFactory.getList()));
			JDockableView checkBoxSelectorView = new JDockableView(CHECK_BOX_SELECTOR_TITLE, IconFactory.getSwingIcon("component/check_box_16.png"), CHECK_BOX_SELECTOR_TITLE, new JCheckBoxListPanel(DemoDataFactory.getComponentElementNodes()));
			JDockableView radioButtonSelectorView = new JDockableView(RADIO_BUTTON_SELECTOR_TITLE, IconFactory.getSwingIcon("component/radio_button_16.png"), RADIO_BUTTON_SELECTOR_TITLE, new JRadioButtonListPanel(DemoDataFactory.getComponentElementNodes()));
			
			JDockable rightDockable = new JDockable();
			rightDockable.setOrientation(JDockable.VERTICAL_SPLIT);
			rightDockable.add(listView);
			rightDockable.add(checkBoxSelectorView);
			rightDockable.add(radioButtonSelectorView);
			
//	        JDockableSplitPane splitPane = new JDockableSplitPane();
//	        splitPane.setOrientation(JDockableSplitPane.VERTICAL_SPLIT);

//	        JDockableTabbedPane tabbedPane1 = new JDockableTabbedPane();
//	        tabbedPane1.setTabPlacement(JDockableTabbedPane.TOP);
//	        tabbedPane1.addTab("TextArea1", new JTextArea());

//	        JDockableTabbedPane tabbedPane2 = new JDockableTabbedPane();
//	        tabbedPane2.setTabPlacement(JDockableTabbedPane.BOTTOM);
//	        tabbedPane2.setVerticalTabPlacement(JDockableTabbedPane.BOTTOM);

//	        tabbedPane2.addTab("TextArea2", new JTextArea(), true);
//	        tabbedPane2.addTab("TextArea3", new JTextArea());
//	        tabbedPane2.addTab("TextArea4", new JTextArea(), true);

//	        splitPane.add(tabbedPane1);
//	        splitPane.add(tabbedPane2);

//	        JDockableView dockableView4 = new JDockableView("Docking Panel5", IconFactory.getContextIcon("apply.png"), splitPane);			
			
			JDockable dockable = new JDockable();
			dockable.setOrientation(JDockable.HORIZONTAL_SPLIT);
			dockable.add(leftDockable, JDockable.FLEXIBLE);
			dockable.add(tabbedPaneView, JDockable.VARY);
			dockable.add(rightDockable, JDockable.FLEXIBLE);
			dockable.setDividerLocation(0, 200);
			dockable.setDividerLocation(2, 300);
			
			getDockableContainer().setContentPane(dockable);
		}
		
		private void initMenuBar()
		{
			JBasicMenuBar menuBar = getMenuBar();
			
			JBasicMenu menu = DockableManager.getToggleMenu(this);
			((JMenuItem) menu.getMenuComponent(1)).doClick();
			menuBar.add(menu);
			
			JBasicMenu helpMenu = new JBasicMenu("Help", "°ïÖú(H)");
			helpMenu.setMnemonic('H');
			menuBar.add(helpMenu);
			
			JBasicMenuItem aboutMenuItem = new JBasicMenuItem(DemoController.getAboutAction());
			KeyStrokeManager.registerButton(aboutMenuItem, KeyEvent.VK_F1, 'U');
			helpMenu.add(aboutMenuItem);
		}
		
		private void initToolBar()
		{
			JBasicToolBar toolBar = getToolBar();
		}
		
		private void initStatusBar()
		{
			JFrameWorkStatusBar statusBar = getStatusBar();
		}
		
		protected void paintMenuBarBackground(Component component, Graphics g)
		{
			ITextureStyle textureStyle = new JBlueTextureStyle();
			
			JBackgroundPainter.paintBackground(component, g, textureStyle);
		}
		
		protected int getMenuBarBackgroundHeight()
		{
			ITextureStyle textureStyle = new JBlueTextureStyle();
			
			return textureStyle.getHeight();
		}
	}
}