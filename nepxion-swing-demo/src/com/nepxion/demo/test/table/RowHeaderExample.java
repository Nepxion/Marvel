package com.nepxion.demo.test.table;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.nepxion.swing.lookandfeel.LookAndFeelManager;

public class RowHeaderExample
	extends JFrame
{
	
	public RowHeaderExample()
	{
		super("Row Header Example");
		setSize(300, 150);
		
		ListModel lm = new AbstractListModel()
		{
			String headers[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
			
			public int getSize()
			{
				return headers.length;
			}
			
			public Object getElementAt(int index)
			{
				return headers[index];
			}
		};
		
		DefaultTableModel dm = new DefaultTableModel(lm.getSize(), 10);
		JTable table = new JTable(dm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JList rowHeader = new JList(lm);
		rowHeader.setFixedCellWidth(50);
		
		rowHeader.setFixedCellHeight(table.getRowHeight() + table.getRowMargin());
		// + table.getIntercellSpacing().height);
		rowHeader.setCellRenderer(new RowHeaderRenderer(table));
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setRowHeaderView(rowHeader);
		getContentPane().add(scroll, BorderLayout.CENTER);
	}
	
	class RowHeaderRenderer
		extends JLabel
		implements ListCellRenderer
	{
		
		RowHeaderRenderer(JTable table)
		{
			JTableHeader header = table.getTableHeader();
			setOpaque(true);
			setBorder(UIManager.getBorder("TableHeader.cellBorder"));
			setHorizontalAlignment(CENTER);
			setForeground(header.getForeground());
			setBackground(header.getBackground());
			setFont(header.getFont());
		}
		
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
		{
			setText((value == null) ? "" : value.toString());
			return this;
		}
	}
	
	public static void main(String[] args)
	{
		LookAndFeelManager.setAcidLookAndFeel();
		RowHeaderExample frame = new RowHeaderExample();
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