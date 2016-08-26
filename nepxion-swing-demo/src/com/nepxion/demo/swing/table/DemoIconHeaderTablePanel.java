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

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

import com.nepxion.swing.element.*;
import com.nepxion.swing.renderer.*;
import com.nepxion.swing.renderer.table.HeaderTableCellRenderer;
import com.nepxion.swing.statusbar.*;
import com.nepxion.swing.icon.*;

public class DemoIconHeaderTablePanel
    extends JPanel
{
    public DemoIconHeaderTablePanel()
    {
        Object[][] rows =
            {
            {"blue", "basketball", "hot dogs"},
            {"violet", "soccer", "pizza"},
            {"red", "football", "ravioli"},
            {"yellow", "hockey", "bananas" }
        };
        Object[] columns =
            {
            "colors", "sports", "food"};
        JTable table = new JTable(rows, columns);
        table.getTableHeader().setBackground(UIManager.getColor("Panel.background"));

        TableColumnModel model = table.getColumnModel();
        for (int i = 0; i < table.getColumnCount(); i++)
        {
            //model.getColumn(i).setHeaderRenderer(new TableHeaderCellRenderer(table.getTableHeader(), new ElementNode(columns[i] + "", IconFactory.getContextIcon("apply.png"), "")));
        }

        JScrollPane tableScrollPane = new JScrollPane(table);

        JStatusBar statusBar = new JStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel(" 表格头部可以用图片来修饰")), 400);

        setLayout(new BorderLayout());
        add(tableScrollPane, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }
}
