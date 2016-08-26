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

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

public class DemoSortableTablePanel
    extends JPanel
{
    public static final Vector COLUMN_TITLES = new Vector(Arrays.asList(new
        Object[]
        {
        "Index", "Name", "Length", "Data", "Select",
    }));

    public DemoSortableTablePanel()
    {
//        Vector rowData = new Vector();
//        rowData.add(new UserObject(0, "a", 6.54, new Date(), true));
//        rowData.add(new UserObject(2, "b", 0.08, getDate("1997-08-10"), false));
//        rowData.add(new UserObject(1, "c", 100.87, getDate("2004-12-12"), true));
//
//        UserObjectTableModel tableModel = new UserObjectTableModel(rowData, COLUMN_TITLES);
//        SortableTableModel sortableTableModel = new SortableTableModel(tableModel);
//
//        JTable table = new JTable();
//        table.setModel(sortableTableModel);
//
//        SortButtonRenderer renderer = new SortButtonRenderer();
//        TableColumnModel model = table.getColumnModel();
//        for (int i = 0; i < table.getColumnCount(); i++)
//        {
//            model.getColumn(i).setHeaderRenderer(renderer);
//            model.getColumn(i).setPreferredWidth(90);
//        }
//
//        JTableHeader header = table.getTableHeader();
//        header.addMouseListener(new SortTableHeadListener(header, renderer));
//        header.setPreferredSize(new Dimension(1000, 22));
//        //header.setReorderingAllowed(false);
//
//        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//
//        JScrollPane tableScrollPane = new JScrollPane(table);
//
//        JStatusBar statusBar = new JStatusBar();
//        statusBar.addItem(400, new JStatusItem(new JLabel(" 第一列为表格头样式的表格")));
//
//        setLayout(new BorderLayout());
//        add(tableScrollPane, BorderLayout.CENTER);
//        add(statusBar, BorderLayout.SOUTH);
    }

    public class UserObject
    {
        public int sequence;
        public String name;
        public double length;
        public Date date;
        public boolean isSelected;

        public UserObject(int sequence, String name, double length, Date date, boolean isSelected)
        {
            this.sequence = sequence;
            this.name = name;
            this.length = length;
            this.date = date;
            this.isSelected = isSelected;
        }
    }


    public class UserObjectTableModel
        extends AbstractTableModel
    {
        private Vector dataVector;
        private Vector columnTitles;

        public UserObjectTableModel(Vector dataVector, Vector columnTitles)
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
            UserObject data = (UserObject) dataVector.get(row);
            switch (column)
            {
            case 0:
                return new Integer(data.sequence);
            case 1:
                return data.name;
            case 2:
                return new Double(data.length);
            case 3:
                return data.date;
            case 4:
                return Boolean.valueOf(data.isSelected);
            }
            return null;
        }

        public String getColumnName(int column)
        {
            return (String) columnTitles.elementAt(column);
        }

        public Class getColumnClass(int column)
        {
            switch (column)
            {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Double.class;
            case 3:
                return Date.class;
            case 4:
                return Boolean.class;
            }
            return Object.class;
        }

        public boolean isCellEditable(int row, int column)
        {
            return false;
        }

        public void setValueAt(Object value, int row, int column)
        {
            UserObject data = (UserObject) dataVector.get(row);

            fireTableDataChanged();
        }

        public synchronized void setHeads(Vector columnTitles)
        {
            this.columnTitles = columnTitles;
            fireTableStructureChanged();
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

        public void addRow(UserObject data)
        {
            if (data == null)
            {
                return;
            }
            getData().addElement(data);
            fireTableDataChanged();
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


    private Date getDate(String dateString)
    {
        Date date = null;
        try
        {
            date = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CHINA).parse(dateString);
        }
        catch (ParseException ex)
        {
            date = new Date();
        }
        return date;
    }
}
