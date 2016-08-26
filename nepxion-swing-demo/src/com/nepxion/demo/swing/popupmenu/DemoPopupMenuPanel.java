package com.nepxion.demo.swing.popupmenu;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;
import com.nepxion.swing.popupmenu.PopupMenuPainter;
import com.nepxion.swing.popupmenu.JDraggablePopupMenu;
import com.nepxion.swing.statusbar.JStatusBar;
import com.nepxion.swing.statusbar.JStatusItem;
import com.nepxion.swing.style.framework.JEclipseStyle;

public class DemoPopupMenuPanel
    extends JPanel
{
    public DemoPopupMenuPanel()
    {
        final JBasicPopupMenu popupMenu = new JBasicPopupMenu();
        PopupMenuPainter painter = new PopupMenuPainter("ABCDEFG", new JEclipseStyle());
        popupMenu.setPainter(painter);
        popupMenu.add(new JMenuItem("Action 1"));
        popupMenu.add(new JMenuItem("Action 2"));
        popupMenu.add(new JMenuItem("Action 3"));
        popupMenu.add(new JMenuItem("Action 4"));
        popupMenu.add(new JMenuItem("Action 5"));
        popupMenu.add(new JMenuItem("Action 6"));
        popupMenu.add(new JMenuItem("Action 7"));

        final JButton internalPopupMenuButton = new JButton("Internal PopupMenu (Right Click)");
        internalPopupMenuButton.addMouseListener(new MouseAdapter()
        {
            public void mouseReleased(MouseEvent e)
            {
                int x = e.getX();
                int y = e.getY();
                popupMenu.show(internalPopupMenuButton, x, y);
            }
        }
        );

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = menuBar.add(new JMenu("File"));
        menu.add(new JMenuItem("New"));
        menuBar.add(new JMenu("Edit"));
        menuBar.add(new JMenu("Help"));

//        DemoEclipseTabbedPane demoEclipseTabbedPane = new DemoEclipseTabbedPane();
//        demoEclipseTabbedPane.setPreferredSize(new Dimension(480, 320));
        final JDraggablePopupMenu draggablePopupMenu = new JDraggablePopupMenu();
        draggablePopupMenu.setJMenuBar(menuBar);
//        draggablePopupMenu.getContentPane().add(demoEclipseTabbedPane);
//        draggablePopupMenu.setDefaultFocusComponent(demoEclipseTabbedPane);

        final JButton draggablePopupMenuButton = new JButton("Draggable PopupMenu");
        draggablePopupMenuButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //draggablePopupMenu.updateUI();
                if (draggablePopupMenu.isPopupVisible())
                {
                    draggablePopupMenu.hidePopup();
                }
                else
                {
                    draggablePopupMenu.showPopup();
                }
            }
        }
        );
        draggablePopupMenu.setOwner(draggablePopupMenuButton);

        double[][] size =
            {
            {0.35, 0.3, 0.35},
            {0.1, 0.06, 0.05, 0.06, TableLayout.FILL}
        };
        TableLayout tableLayout = new TableLayout(size);
        JPanel panel = new JPanel();
        panel.setLayout(tableLayout);
        panel.add(internalPopupMenuButton, "1, 1, 1, 1");
        panel.add(draggablePopupMenuButton, "1, 3, 1, 3");

        JStatusBar statusBar = new JStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel(" È«ÆÁ×é¼þ")), 400);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }
}
