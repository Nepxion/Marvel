package com.nepxion.demo.swing.completion;

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

public class DemoCompletionTabbedPane
    extends JEclipseTabbedPane
{
    private static DemoCompletionTabbedPane completionTabbedPane;

    public static DemoCompletionTabbedPane getInstance()
    {
        if (completionTabbedPane == null)
        {
            completionTabbedPane = new DemoCompletionTabbedPane();
        }
        return completionTabbedPane;
    }

    private DemoCompletionTabbedPane()
    {
        addTab("Completion", new DemoCompletionPanel());
    }
}
