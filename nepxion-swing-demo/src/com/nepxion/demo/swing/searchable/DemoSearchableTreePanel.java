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

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.text.*;

import com.nepxion.swing.layout.table.*;
import com.nepxion.swing.searchable.*;
import com.nepxion.swing.statusbar.*;

public class DemoSearchableTreePanel
    extends JPanel
{
    public DemoSearchableTreePanel()
    {
        double[][] size =
            {
            {TableLayout.FILL},
            {0.5, 0.5}
        };
        TableLayout tableLayout = new TableLayout(size);
        JPanel panel = new JPanel();
        panel.setLayout(tableLayout);
        panel.add(createTree(), "0, 0");
        panel.add(createTreeContainer(), "0, 1");

        JStatusBar statusBar = new JStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel(" 请拷贝大量文字到TextArea。按CTRL+F呼出查询框")), 400);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }

    private JScrollPane createTree()
    {
        JTree tree = new JTree()
        {
            public TreePath getNextMatch(String prefix, int startingRow, Position.Bias bias)
            {
                return null;
            }
        };

        JSearchableFactory.installSearchable(tree);
        return new JScrollPane(tree);
    }

    private JSearchableContainer createTreeContainer()
    {
        JTree tree = new JTree()
        {
            public TreePath getNextMatch(String prefix, int startingRow, Position.Bias bias)
            {
                return null;
            }
        };

        JSearchableContainer container = new JSearchableContainer();
        container.add(new JScrollPane(tree));

        JSearchableFactory.installSearchableBar(tree, container);
        return container;
    }
}
