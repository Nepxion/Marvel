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

import com.nepxion.swing.tabbedpane.*;

public class DemoPopupMenuTabbedPane
    extends JEclipseTabbedPane
{
    private static DemoPopupMenuTabbedPane popupMenuTabbedPane;

    public static DemoPopupMenuTabbedPane getInstance()
    {
        if (popupMenuTabbedPane == null)
        {
            popupMenuTabbedPane = new DemoPopupMenuTabbedPane();
        }
        return popupMenuTabbedPane;
    }

    private DemoPopupMenuTabbedPane()
    {
        addTab("PopupMenu", new DemoPopupMenuPanel());
    }
}
