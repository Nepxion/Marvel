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
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

import com.nepxion.swing.element.*;
import com.nepxion.swing.table.rowheader.*;
import com.nepxion.swing.statusbar.*;
import com.nepxion.swing.icon.*;

public class DemoRowHeaderTablePanel
    extends JPanel
{
    public static Vector COLUMN_TITLES = new Vector(Arrays.asList(new Object[]
        {"column1", "column2", "column3", "column4"}));

    private JRowHeaderTable rowHeaderTable;

    public DemoRowHeaderTablePanel()
    {
        Vector rowData = new Vector();
        rowData.add(new UserObject("blue", "violet", "red", "yellow"));
        rowData.add(new UserObject("basketball", "soccer", "football", "hockey"));
        rowData.add(new UserObject("hot dogs", "pizza", "ravioli", "bananas"));

        Vector rowHeaderData = new Vector();
//        rowHeaderData.add(new ElementNode("colors", IconFactory.getContextIcon("apply.png"), ""));
//        rowHeaderData.add(new ElementNode("sports", IconFactory.getContextIcon("apply.png"), ""));
//        rowHeaderData.add(new ElementNode("food", IconFactory.getContextIcon("apply.png"), ""));

        rowHeaderTable = new JRowHeaderTable();
        rowHeaderTable.setModel(new UserObjectTreeTableModel(rowData, COLUMN_TITLES));
        rowHeaderTable.setRowHeaderData(rowHeaderData);
        rowHeaderTable.setRowHeaderSize(80, 20);

        /*TableColumnModel model = rowHeaderTable.getColumnModel();
        for (int i = 0; i < rowHeaderTable.getColumnCount(); i++)
        {
            model.getColumn(i).setHeaderRenderer(new TableHeaderCellRenderer(getTableHeader(), new ElementNode(COLUMN_TITLES.get(i) + "", IconFactory.getCustomIcon("apply.png"))));
        }*/

        JScrollPane tableScrollPane = new JScrollPane(rowHeaderTable);
        tableScrollPane.setRowHeaderView(rowHeaderTable.getRowHeader());

        JStatusBar statusBar = new JStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel(" 第一列为表格头样式的表格")), 400);

        setLayout(new BorderLayout());
        add(tableScrollPane, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }

    public class UserObject
    {
        public String column0;
        public String column1;
        public String column2;
        public String column3;

        public UserObject(String column0, String column1, String column2, String column3)
        {
            this.column0 = column0;
            this.column1 = column1;
            this.column2 = column2;
            this.column3 = column3;
        }
    }


    public class UserObjectTreeTableModel
        extends AbstractTableModel
    {
        private Vector dataVector;
        private Vector columnTitles;

        public UserObjectTreeTableModel(Vector dataVector, Vector columnTitles)
        {
            this.dataVector = dataVector;
            this.columnTitles = columnTitles;
        }

        public int getRowCount()
        {
            return dataVector.size();
        }

        public int getColumnCount()
        {
            return columnTitles.size();
        }

        public Object getValueAt(int row, int column)
        {
            UserObject userObject = (UserObject) dataVector.get(row);
            if (dataVector != null)
            {
                switch (column)
                {
                case 0:
                    return userObject.column0;
                case 1:
                    return userObject.column1;
                case 2:
                    return userObject.column2;
                case 3:
                    return userObject.column3;
                }
            }
            return null;
        }

        public String getColumnName(int column)
        {
            return (String) columnTitles.get(column);
        }

        public Class getColumnClass(int column)
        {
            return Integer.class;
        }

        public boolean isCellEditable(int row, int column)
        {
            return false;
        }

        public void setValueAt(Object value, int row, int column)
        {
            /*fireTableDataChanged();*/
        }

        public synchronized void setHeads(Vector columnTitles)
        {
            this.columnTitles = columnTitles;
            fireTableStructureChanged();
        }

        public Vector getHeader()
        {
            return columnTitles;
        }

        public synchronized void setData(Vector dataVector)
        {
            this.dataVector = dataVector;
            fireTableDataChanged();
        }

        public Vector getData()
        {
            return dataVector;
        }

        public void deleteRow(int row)
        {
            if (row == -1 || row == getData().size())
            {
                return;
            }
            getData().removeElementAt(row);
            fireTableDataChanged();
        }
    }
}
