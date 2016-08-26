package com.nepxion.demo.swing.border;

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

public class DemoBorderTabbedPane
    extends JEclipseTabbedPane
{
    private static DemoBorderTabbedPane borderTabbedPane;

    public static DemoBorderTabbedPane getInstance()
    {
        if (borderTabbedPane == null)
        {
            borderTabbedPane = new DemoBorderTabbedPane();
        }
        return borderTabbedPane;
    }

    private DemoBorderTabbedPane()
    {
        addTab("Title Border", new DemoTitleBorderPanel());
        addTab("Check & Radio Border", new DemoCheckAndRadioBorderPanel());
        addTab("General Border", new DemoGeneralBorderPanel());
    }
}
