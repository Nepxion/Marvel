package com.nepxion.demo.swing.tree;

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

public class DemoTreeTabbedPane
    extends JEclipseTabbedPane
{
    private static DemoTreeTabbedPane treeTabbedPane;

    public static DemoTreeTabbedPane getInstance()
    {
        if (treeTabbedPane == null)
        {
            treeTabbedPane = new DemoTreeTabbedPane();
        }
        return treeTabbedPane;
    }

    private DemoTreeTabbedPane()
    {
        addTab("DropDownTree", new DemoDropDownTreePanel());
        //addTab("XMLTree", new DemoTreePanel());
    }
}
