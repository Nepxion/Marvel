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

import com.nepxion.swing.table.editableheader.*;
import com.nepxion.swing.layout.table.*;
import com.nepxion.swing.renderer.*;
import com.nepxion.swing.renderer.table.ComboBoxTableCellRenderer;
import com.nepxion.swing.statusbar.*;

public class DemoEditableHeaderTablePanel
    extends JPanel
{
    public DemoEditableHeaderTablePanel()
    {
        TextFieldHeaderTablePanel textFieldHeaderTablePanel = new TextFieldHeaderTablePanel();
        ComboBoxHeaderTablePanel comboBoxHeaderTablePanel = new ComboBoxHeaderTablePanel();

        double[][] size =
            {
            {TableLayout.FILL},
            {0.5, 0.5}
        };
        TableLayout tableLayout = new TableLayout(size);
        JPanel panel = new JPanel();
        panel.setLayout(tableLayout);
        panel.add(textFieldHeaderTablePanel, "0, 0, 0, 0");
        panel.add(comboBoxHeaderTablePanel, "0, 1, 0, 1");

        JStatusBar statusBar = new JStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel(" 表格头可编辑的表格")), 400);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }

    public class TextFieldHeaderTablePanel
        extends JScrollPane
    {
        public TextFieldHeaderTablePanel()
        {
            Object[][] rows =
                {
                {"blue", "basketball", "hot dogs"},
                {"violet", "soccer", "pizza"},
                {"red", "football", "ravioli"},
                {"yellow", "hockey", "bananas"}
            };
            Object[] columns =
                {
                "colors", "sports", "food"};
            JTable table = new JTable(rows, columns);
            table.getTableHeader().setBackground(UIManager.getColor("Panel.background"));

            TableColumnModel columnModel = table.getColumnModel();
            table.setTableHeader(new EditableHeader(columnModel));
            getViewport().add(table);
        }
    }


    public class ComboBoxHeaderTablePanel
        extends JScrollPane
    {
        public ComboBoxHeaderTablePanel()
        {
            Object[][] rows =
                {
                {"blue", "basketball", "hot dogs"},
                {"violet", "soccer", "pizza"},
                {"red", "football", "ravioli"},
                {"yellow", "hockey", "bananas"}
            };
            Object[] columns =
                {
                "colors", "sports", "food"};

            JTable table = new JTable(rows, columns);
            table.getTableHeader().setBackground(UIManager.getColor("Panel.background"));

            TableColumnModel columnModel = table.getColumnModel();
            table.setTableHeader(new EditableHeader(columnModel));

            String[] items0 =
                {
                "sports", "new sports"};
            ComboBoxTableCellRenderer renderer = new ComboBoxTableCellRenderer(items0);
            renderer.setPreferredSize(new Dimension(table.getPreferredSize().width, 20));

            EditableHeaderTableColumn column0 = (EditableHeaderTableColumn) table.getColumnModel().getColumn(1);
            column0.setHeaderValue(items0[0]);
            column0.setHeaderRenderer(renderer);
            JComboBox comboBox0 = new JComboBox(items0);
            comboBox0.setRequestFocusEnabled(false);
            column0.setHeaderEditor(new DefaultCellEditor(comboBox0));

            String[] items1 =
                {
                "food", "new food"};
            EditableHeaderTableColumn column1 = (EditableHeaderTableColumn) table.getColumnModel().getColumn(2);
            column1.setHeaderValue(items1[0]);
            JComboBox comboBox1 = new JComboBox(items1);
            column1.setHeaderEditor(new DefaultCellEditor(comboBox1));

            getViewport().add(table);
        }
    }
}
