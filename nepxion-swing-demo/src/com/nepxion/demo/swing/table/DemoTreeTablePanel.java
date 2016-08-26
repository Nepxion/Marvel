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
import javax.swing.tree.*;

import com.nepxion.swing.statusbar.*;
import com.nepxion.swing.table.treetable.*;

public class DemoTreeTablePanel
    extends JPanel
{
    public DemoTreeTablePanel()
    {
        UserObjectTreeNode root = new UserObjectTreeNode("JTree", 1);

        UserObjectTreeNode treeNode1 = new UserObjectTreeNode("color", 2);
        UserObjectTreeNode treeNode2 = new UserObjectTreeNode("sports", 3);
        UserObjectTreeNode treeNode3 = new UserObjectTreeNode("food", 4);
        root.add(treeNode1);
        root.add(treeNode2);
        root.add(treeNode3);

        UserObjectTreeNode treeNode11 = new UserObjectTreeNode("blue", 5);
        UserObjectTreeNode treeNode12 = new UserObjectTreeNode("violet", 6);
        UserObjectTreeNode treeNode13 = new UserObjectTreeNode("red", 7);
        UserObjectTreeNode treeNode14 = new UserObjectTreeNode("yellow", 8);
        treeNode1.add(treeNode11);
        treeNode1.add(treeNode12);
        treeNode1.add(treeNode13);
        treeNode1.add(treeNode14);

        UserObjectTreeNode treeNode21 = new UserObjectTreeNode("basketball", 9);
        UserObjectTreeNode treeNode22 = new UserObjectTreeNode("soccer", 10);
        UserObjectTreeNode treeNode23 = new UserObjectTreeNode("football", 11);
        UserObjectTreeNode treeNode24 = new UserObjectTreeNode("hockey", 12);
        treeNode2.add(treeNode21);
        treeNode2.add(treeNode22);
        treeNode2.add(treeNode23);
        treeNode2.add(treeNode24);

        UserObjectTreeNode treeNode31 = new UserObjectTreeNode("hot dogs", 13);
        UserObjectTreeNode treeNode32 = new UserObjectTreeNode("pizza", 14);
        UserObjectTreeNode treeNode33 = new UserObjectTreeNode("ravioli", 15);
        UserObjectTreeNode treeNode34 = new UserObjectTreeNode("bananas", 16);
        treeNode3.add(treeNode31);
        treeNode3.add(treeNode32);
        treeNode3.add(treeNode33);
        treeNode3.add(treeNode34);

        JTreeTable treeTable = new JTreeTable(new UserObjectTreeTableModel(root));
        treeTable.getTableHeader().setBackground(UIManager.getColor("Panel.background"));
//        treeTable.setRowHeight(20);

        JScrollPane treeTableScrollPane = new JScrollPane(treeTable);

        JStatusBar statusBar = new JStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel(" ±í¸ñÊ÷")), 400);

        setLayout(new BorderLayout());
        add(treeTableScrollPane, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }

    public class UserObjectTreeTableModel
        extends AbstractTreeTableModel
    {
        protected String[] columnNames =
            {
            "name", "type"};

        protected Class[] ColumnTypes =
            {
            TreeTableModel.class,
            String.class,
            Integer.class};

        public UserObjectTreeTableModel(Object root)
        {
            super(root);
        }

        // The TreeModel interface
        public int getChildCount(Object node)
        {
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) node;
            return treeNode.getChildCount();
        }

        public Object getChild(Object node, int i)
        {
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) node;
            return treeNode.getChildAt(i);
        }

        public boolean isLeaf(Object node)
        {
            return ((UserObjectTreeNode) node).isLeaf();
        }

        //  The TreeTableNode interface.
        public int getColumnCount()
        {
            return columnNames.length;
        }

        public String getColumnName(int column)
        {
            return columnNames[column];
        }

        public Class getColumnClass(int column)
        {
            return ColumnTypes[column];
        }

        public Object getValueAt(Object node, int column)
        {
            UserObjectTreeNode userObjectTreeNode = (UserObjectTreeNode) node;
            switch (column)
            {
            case 0:
                return userObjectTreeNode.name;
            case 1:
                return new Integer(userObjectTreeNode.type);
            }
            return null;
        }
    }


    public class UserObjectTreeNode
        extends DefaultMutableTreeNode
    {
        public String name;
        public int type;

        public UserObjectTreeNode(String name, int type)
        {
            super(name);
            
            this.name = name;
            this.type = type;
        }

        public String toString()
        {
            return name;
        }
    }
}
