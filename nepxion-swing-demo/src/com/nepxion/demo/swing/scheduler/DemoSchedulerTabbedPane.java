package com.nepxion.demo.swing.scheduler;

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

public class DemoSchedulerTabbedPane
    extends JEclipseTabbedPane
{
    private static DemoSchedulerTabbedPane schedulerTabbedPane;

    public static DemoSchedulerTabbedPane getInstance()
    {
        if (schedulerTabbedPane == null)
        {
            schedulerTabbedPane = new DemoSchedulerTabbedPane();
        }
        return schedulerTabbedPane;
    }

    private DemoSchedulerTabbedPane()
    {
        addTab("TabbedPane", new DemoSchedulerPanel());
    }
}
