package com.nepxion.demo.swing.fullscreen;

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

public class DemoFullScreenTabbedPane
    extends JEclipseTabbedPane
{
    private static DemoFullScreenTabbedPane fullScreenTabbedPane;

    public static DemoFullScreenTabbedPane getInstance()
    {
        if (fullScreenTabbedPane == null)
        {
            fullScreenTabbedPane = new DemoFullScreenTabbedPane();
        }
        return fullScreenTabbedPane;
    }

    private DemoFullScreenTabbedPane()
    {
        addTab("FullScreen", new DemoFullScreenPanel());
    }
}
