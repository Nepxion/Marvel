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

import com.nepxion.swing.tabbedpane.*;

public class DemoStatusBarTabbedPane
    extends JEclipseTabbedPane
{
    private static DemoStatusBarTabbedPane statusBarTabbedPane;

    public static DemoStatusBarTabbedPane getInstance()
    {
        if (statusBarTabbedPane == null)
        {
            statusBarTabbedPane = new DemoStatusBarTabbedPane();
        }
        return statusBarTabbedPane;
    }

    private DemoStatusBarTabbedPane()
    {
        addTab("StatusBar", new DemoStatusBarPanel());
    }
}
