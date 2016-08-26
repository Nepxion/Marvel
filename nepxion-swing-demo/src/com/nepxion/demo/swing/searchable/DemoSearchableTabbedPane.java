package com.nepxion.demo.swing.searchable;

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

public class DemoSearchableTabbedPane
    extends JEclipseTabbedPane
{
    private static DemoSearchableTabbedPane searchableTabbedPane;

    public static DemoSearchableTabbedPane getInstance()
    {
        if (searchableTabbedPane == null)
        {
            searchableTabbedPane = new DemoSearchableTabbedPane();
        }
        return searchableTabbedPane;
    }

    private DemoSearchableTabbedPane()
    {
        addTab("Searchable TextArea", new DemoSearchableTextAreaPanel());
        addTab("Searchable Table", new DemoSearchableTablePanel());
        addTab("Searchable Tree", new DemoSearchableTreePanel());
        addTab("Searchable List", new DemoSearchableListPanel());
        addTab("Searchable ComboBox", new DemoSearchableComboBoxPanel());
    }
}
