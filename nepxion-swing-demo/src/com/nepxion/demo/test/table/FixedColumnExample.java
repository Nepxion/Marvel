package com.nepxion.demo.test.table;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.AbstractTableModel;

public class FixedColumnExample
	extends JFrame
{
	Object[][] data;
	
	Object[] column;
	
	JTable fixedTable, table;
	
	public FixedColumnExample()
	{
		super("Fixed Column Example");
		setSize(400, 150);
		
		data = new Object[][] { {"1", "11", "A", "", "", "", "", ""}, {"2", "22", "", "B", "", "", "", ""}, {"3", "33", "", "", "C", "", "", ""}, {"4", "44", "", "", "", "D", "", ""}, {"5", "55", "", "", "", "", "E", ""}, {"6", "66", "", "", "", "", "", "F"}};
		column = new Object[] {"Status", "a", "b", "c", "d", "e", "f"};
		
		AbstractTableModel fixedModel = new AbstractTableModel()
		{
			public int getColumnCount()
			{
				return 1;
			}
			
			public int getRowCount()
			{
				return data.length;
			}
			
			public String getColumnName(int col)
			{
				return (String) column[col];
			}
			
			public Object getValueAt(int row, int col)
			{
				return data[row][col];
			}
		};
		AbstractTableModel model = new AbstractTableModel()
		{
			public int getColumnCount()
			{
				return column.length - 1;
			}
			
			public int getRowCount()
			{
				return data.length;
			}
			
			public String getColumnName(int col)
			{
				return (String) column[col + 1];
			}
			
			public Object getValueAt(int row, int col)
			{
				return data[row][col + 1];
			}
			
			public void setValueAt(Object obj, int row, int col)
			{
				data[row][col + 2] = obj;
			}
			
			public boolean CellEditable(int row, int col)
			{
				return true;
			}
		};
		
		fixedTable = new JTable(fixedModel)
		{
			public void valueChanged(ListSelectionEvent e)
			{
				super.valueChanged(e);
				checkSelection(true);
			}
		};
		table = new JTable(model)
		{
			public void valueChanged(ListSelectionEvent e)
			{
				super.valueChanged(e);
				checkSelection(false);
			}
		};
		fixedTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		fixedTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scroll = new JScrollPane(table);
		JViewport viewport = new JViewport();
		viewport.setView(fixedTable);
		viewport.setPreferredSize(fixedTable.getPreferredSize());
		scroll.setRowHeaderView(viewport);
		scroll.setCorner(JScrollPane.UPPER_LEFT_CORNER, fixedTable.getTableHeader());
		
		getContentPane().add(scroll, BorderLayout.CENTER);
	}
	
	private void checkSelection(boolean isFixedTable)
	{
		int fixedSelectedIndex = fixedTable.getSelectedRow();
		int selectedIndex = table.getSelectedRow();
		if (fixedSelectedIndex != selectedIndex)
		{
			if (isFixedTable)
			{
				table.setRowSelectionInterval(fixedSelectedIndex, fixedSelectedIndex);
			}
			else
			{
				fixedTable.setRowSelectionInterval(selectedIndex, selectedIndex);
			}
		}
	}
	
	public static void main(String[] args)
	{
		FixedColumnExample frame = new FixedColumnExample();
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		frame.setVisible(true);
	}
}