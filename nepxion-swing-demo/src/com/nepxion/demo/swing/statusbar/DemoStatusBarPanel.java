package com.nepxion.demo.swing.statusbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.*;
import javax.swing.*;

import com.nepxion.swing.statusbar.*;
import com.nepxion.swing.button.*;
import com.nepxion.swing.icon.*;
import com.nepxion.swing.popupmenu.*;

public class DemoStatusBarPanel
    extends JPanel
{
    public DemoStatusBarPanel()
    {
        JStatusBar statusBar0 = new JStatusBar();
        statusBar0.addItem(new JStatusItem(new JLabel(" ×´Ì¬1")), 200);

        JBasicPopupMenu popupMenu1 = new JBasicPopupMenu();
        popupMenu1.add(new JMenuItem("save", IconFactory.getContextIcon("save.png")));
        popupMenu1.add(new JMenuItem("save all", IconFactory.getContextIcon("save_all.png")));
        JBasicMenuButton menuButton1 = new JBasicMenuButton(IconFactory.getContextIcon("save.png"));
        menuButton1.setPopupMenu(popupMenu1);

        JBasicSplitButton menuButton2 = new JBasicSplitButton(IconFactory.getContextIcon("save.png"));
        JBasicPopupMenu popupMenu2 = new JBasicPopupMenu();
        popupMenu2.add(new JMenuItem("±£´æ", IconFactory.getContextIcon("save.png")));
        popupMenu2.add(new JMenuItem("±£´æÈ«²¿", IconFactory.getContextIcon("save_all.png")));
        menuButton2.setPopupMenu(popupMenu2);

        JStatusItem item = new JStatusItem();
        item.add(menuButton1);
        item.add(menuButton2);
        ButtonManager.updateUI(item, new Dimension(50, 16));
        statusBar0.addItem(item, 300);

        JStatusBar statusBar = new JStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel(" ×´Ì¬À¸")), 400);

        setLayout(new BorderLayout());
        add(statusBar0, BorderLayout.NORTH);
        add(statusBar, BorderLayout.SOUTH);
    }
}
