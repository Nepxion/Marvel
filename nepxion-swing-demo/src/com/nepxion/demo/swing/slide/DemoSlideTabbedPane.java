package com.nepxion.demo.swing.slide;

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

public class DemoSlideTabbedPane
    extends JEclipseTabbedPane
{
    private static DemoSlideTabbedPane slideTabbedPane;

    public static DemoSlideTabbedPane getInstance()
    {
        if (slideTabbedPane == null)
        {
            slideTabbedPane = new DemoSlideTabbedPane();
        }
        return slideTabbedPane;
    }

    private DemoSlideTabbedPane()
    {
        addTab("Range Slide", new DemoRangeSlidePanel());
    }
}
