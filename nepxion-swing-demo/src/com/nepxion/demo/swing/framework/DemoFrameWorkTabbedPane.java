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

import com.nepxion.swing.tabbedpane.*;

public class DemoFrameWorkTabbedPane
    extends JEclipseTabbedPane
{
    private static DemoFrameWorkTabbedPane frameWorkTabbedPane;

    public static DemoFrameWorkTabbedPane getInstance()
    {
        if (frameWorkTabbedPane == null)
        {
            frameWorkTabbedPane = new DemoFrameWorkTabbedPane();
        }
        return frameWorkTabbedPane;
    }

    private DemoFrameWorkTabbedPane()
    {
        addTab("FrameWork", new DemoFrameWorkPanel());
    }
}
