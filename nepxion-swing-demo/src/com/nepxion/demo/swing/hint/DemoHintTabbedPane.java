package com.nepxion.demo.swing.hint;

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

public class DemoHintTabbedPane
    extends JEclipseTabbedPane
{
    private static DemoHintTabbedPane dialogTabbedPane;

    public static DemoHintTabbedPane getInstance()
    {
        if (dialogTabbedPane == null)
        {
            dialogTabbedPane = new DemoHintTabbedPane();
        }
        return dialogTabbedPane;
    }

    private DemoHintTabbedPane()
    {
        addTab("Hint", new DemoHintPanel());
    }
}
