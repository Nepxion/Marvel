package com.nepxion.demo.swing.selector;

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

public class DemoSelectorTabbedPane
    extends JEclipseTabbedPane
{
    private static DemoSelectorTabbedPane selectorTabbedPane;

    public static DemoSelectorTabbedPane getInstance()
    {
        if (selectorTabbedPane == null)
        {
            selectorTabbedPane = new DemoSelectorTabbedPane();
        }
        return selectorTabbedPane;
    }

    private DemoSelectorTabbedPane()
    {
        addTab("Common Selector", new DemoCommonSelectorPanel());
    }
}
