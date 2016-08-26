package com.nepxion.demo.test.table;

import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class DemoTable
{
	public static void main(String[] args)
	{		
		String[][] rowDatas = new String[][] { {"A", "B", "C", "D"}, {"E", "F", "G", "H"}, {"I", "J", "K", "L"}};
		String[] columNames = new String[] {"Colum1", "Colum2", "Colum3", "Colum4"};
		
		TableModel tableModel = new DefaultTableModel(rowDatas, columNames);
		JTable table = new JTable(tableModel);
		
		ButtonHeaderRenderer headerRenderer = new ButtonHeaderRenderer();
		ButtonHeaderListener headerListener = new ButtonHeaderListener(table.getTableHeader(), headerRenderer);
		table.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
		table.getTableHeader().addMouseListener(headerListener);
		JScrollPane scrollPane = new JScrollPane(table);
		
		JFrame frame = new JFrame();
		frame.getContentPane().add(scrollPane);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static class ButtonHeaderRenderer
		extends JButton
		implements TableCellRenderer
	{
		private int pressedColumn = -1;
		
		public ButtonHeaderRenderer()
		{
			setMargin(new Insets(0, 0, 0, 0));
		}
		
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		{
			setText((value == null) ? "" : value.toString());
			boolean isPressed = (column == pressedColumn);
			getModel().setPressed(isPressed);
			getModel().setArmed(isPressed);
			
			return this;
		}
		
		public void setPressedColumn(int pressedColumn)
		{
			this.pressedColumn = pressedColumn;
		}
	}
	
	public static class ButtonHeaderListener
		extends MouseAdapter
	{
		private JTableHeader header;
		
		private ButtonHeaderRenderer renderer;
		
		public ButtonHeaderListener(JTableHeader header, ButtonHeaderRenderer renderer)
		{
			this.header = header;
			this.renderer = renderer;
		}
		
		public void mousePressed(MouseEvent e)
		{
			int col = header.columnAtPoint(e.getPoint());
			renderer.setPressedColumn(col);
			header.repaint();
		}
		
		public void mouseReleased(MouseEvent e)
		{
			renderer.setPressedColumn(-1);
			header.repaint();
		}
	}
}
