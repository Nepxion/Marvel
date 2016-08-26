package com.nepxion.demo.swing.framework;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.button.JBasicMenuButton;
import com.nepxion.swing.framework.JFrameWorkStatusBar;
import com.nepxion.swing.framework.JFrameWorkThread;
import com.nepxion.swing.framework.dockable.DockableManager;
import com.nepxion.swing.framework.dockable.JDockable;
import com.nepxion.swing.framework.dockable.JDockableHierarchy;
import com.nepxion.swing.framework.dockable.JDockableSplitPane;
import com.nepxion.swing.framework.dockable.JDockableTabbedPane;
import com.nepxion.swing.framework.dockable.JDockableView;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;
import com.nepxion.swing.statusbar.JStatusBar;
import com.nepxion.swing.statusbar.JStatusItem;

public class DemoFrameWorkInitializer
{
    private JDockableHierarchy dockableHierarchy;

    public DemoFrameWorkInitializer(JDockableHierarchy dockableHierarchy)
    {
        this.dockableHierarchy = dockableHierarchy;
    }

    public void initializer()
    {
        initContentPane();
        initMenuBar();
        initToolBar();
        initStatusBar();
    }

    private void initContentPane()
    {
        JDockableView dockableView = new JDockableView("Docking Panel1", IconFactory.getContextIcon("apply.png"), "", true, new JTextArea());
        JDockableView dockableView1 = new JDockableView("Docking Panel2", IconFactory.getContextIcon("apply.png"), "", true, new JTextArea());
        JDockableView dockableView2 = new JDockableView("Docking Panel3", IconFactory.getContextIcon("apply.png"), "", true, new JTextArea());
        JDockableView dockableView3 = new JDockableView("Docking Panel4", IconFactory.getContextIcon("apply.png"), "", true, new JTextArea());

        // 构造dockableView4
        JDockableSplitPane splitPane = new JDockableSplitPane();
        splitPane.setOrientation(JDockableSplitPane.VERTICAL_SPLIT);

        JDockableTabbedPane tabbedPane1 = new JDockableTabbedPane();
        tabbedPane1.setTabPlacement(JDockableTabbedPane.TOP);
        tabbedPane1.addTab("TextArea1", new JTextArea());

        JDockableTabbedPane tabbedPane2 = new JDockableTabbedPane();
        tabbedPane2.setTabPlacement(JDockableTabbedPane.BOTTOM);
        tabbedPane2.setVerticalTabPlacement(JDockableTabbedPane.BOTTOM);

        tabbedPane2.addTab("TextArea2", new JTextArea(), true);
        tabbedPane2.addTab("TextArea3", new JTextArea());
        tabbedPane2.addTab("TextArea4", new JTextArea(), true);

        splitPane.add(tabbedPane1);
        splitPane.add(tabbedPane2);
        ////////////////////////

        JDockableView dockableView4 = new JDockableView("Docking Panel5", IconFactory.getContextIcon("apply.png"), "", true, splitPane);
        //JDockableView dockableView5 = new JDockableView("Docking Panel6", IconFactory.getContextIcon("apply.png"), "", true, new DemoBarScrollPanePanel());

        // JDockable布局说明, 实现两种布局效果
        // 1.dockable.add(xxx) 由系统平均分配尺寸，同时在伸缩的时候，实现平均自填充
        // 2.dockable.add(xxx, JDockable.yyy)
        //   JDockable.FLEXIBLE 实现固定大小，其大小通过setPaneSize(index, size);
        //   JDockable.VARY 实现自填充，不需要设置大小
        JDockable dockable = new JDockable();
        dockable.setOrientation(JDockable.VERTICAL_SPLIT);
        dockable.add(dockableView, JDockable.FLEXIBLE);
        dockable.add(dockableView1, JDockable.FLEXIBLE);
        dockable.add(dockableView2, JDockable.VARY);
        dockable.setDividerLocation(0, 150);
        dockable.setDividerLocation(1, 80);

        JDockable dockable2 = new JDockable();
        dockable2.setOrientation(JDockable.VERTICAL_SPLIT);
        dockable2.add(dockableView3);
        dockable2.add(dockableView4);

        JDockable dockable1 = new JDockable();
        dockable1.setOrientation(JDockable.HORIZONTAL_SPLIT);
        dockable1.add(dockable, JDockable.FLEXIBLE);
        //dockable1.add(dockableView5, JDockable.VARY);
        dockable1.add(dockable2, JDockable.FLEXIBLE);
        dockable1.setDividerLocation(0, 200);
        dockable1.setDividerLocation(2, 300);

        dockableHierarchy.getDockableContainer().setContentPane(dockable1);
    }

    private void initMenuBar()
    {
    	JMenuBar menuBar = dockableHierarchy.getMenuBar();
        JMenu menu = new JMenu("文件");
        JMenuItem menuItem = new JMenuItem("线程");
        menuItem.addActionListener(new ApplyAction());
        menu.add(menuItem);
        menuBar.add(menu);

        menuBar.add(DockableManager.getToggleMenu(dockableHierarchy));
    }

    private void initToolBar()
    {
    	JToolBar toolBar = dockableHierarchy.getToolBar();
        JBasicButton button = new JBasicButton("线程");
        button.addActionListener(new ApplyAction());
        toolBar.add(button);

        ButtonManager.updateUI(toolBar, new Dimension(60, 30));
    }

    private void initStatusBar()
    {
        JFrameWorkStatusBar statusBar = dockableHierarchy.getStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel("AAA")), 120, JStatusBar.LEFT);
        statusBar.addItem(new JStatusItem(new JLabel("BBB")), 60, JStatusBar.LEFT);

        JBasicPopupMenu popupMenu1 = new JBasicPopupMenu();
        popupMenu1.add(new JMenuItem("save", IconFactory.getContextIcon("save.png")));
        popupMenu1.add(new JMenuItem("save all", IconFactory.getContextIcon("save_all.png")));
        JBasicMenuButton menuButton1 = new JBasicMenuButton(IconFactory.getContextIcon("save.png"));
        menuButton1.setPopupMenu(popupMenu1);
        menuButton1.setDimension(new Dimension(50, 16));
        statusBar.addItem(new JStatusItem(menuButton1), 50, JStatusBar.RIGHT);

        statusBar.addItem(new JStatusItem(new JLabel("CCC")), 80, JStatusBar.RIGHT);
    }

    public class ApplyAction
        extends AbstractAction
    {
        public void actionPerformed(ActionEvent e)
        {
            final AbstractButton c = (AbstractButton) e.getSource();
            JTextArea t = new JTextArea();
            JBasicOptionPane.showDialog(Frame.getFrames()[0], t, "测试");

            JFrameWorkThread thread = new JFrameWorkThread(dockableHierarchy, e)
            {
                public void execute()
                {
                    for (int i = 0; i < 1000000000; i++)
                    {
                    }
                }
            };
            thread.start();
        }
    }
}
