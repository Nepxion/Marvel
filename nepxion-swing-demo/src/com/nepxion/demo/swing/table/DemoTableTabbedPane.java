package com.nepxion.demo.swing.table;

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

public class DemoTableTabbedPane
    extends JEclipseTabbedPane
{
    private static DemoTableTabbedPane tableTabbedPane;

    public static DemoTableTabbedPane getInstance()
    {
        if (tableTabbedPane == null)
        {
            tableTabbedPane = new DemoTableTabbedPane();
        }
        return tableTabbedPane;
    }

    private DemoTableTabbedPane()
    {
        addTab("Tree Table", new DemoTreeTablePanel());
        addTab("RowHeader Table", new DemoRowHeaderTablePanel());
        addTab("EditableHeader Table", new DemoEditableHeaderTablePanel());
        addTab("Sortable Table", new DemoSortableTablePanel());
        addTab("IconHeader Table", new DemoIconHeaderTablePanel());
    }
}
