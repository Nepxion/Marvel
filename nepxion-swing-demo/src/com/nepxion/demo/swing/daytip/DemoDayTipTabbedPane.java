package com.nepxion.demo.swing.daytip;

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

public class DemoDayTipTabbedPane
    extends JEclipseTabbedPane
{
    private static DemoDayTipTabbedPane dayTipTabbedPane;

    public static DemoDayTipTabbedPane getInstance()
    {
        if (dayTipTabbedPane == null)
        {
            dayTipTabbedPane = new DemoDayTipTabbedPane();
        }
        return dayTipTabbedPane;
    }

    private DemoDayTipTabbedPane()
    {
        addTab("DayTip", new DemoDayTipPanel());
    }
}
