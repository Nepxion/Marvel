package com.nepxion.demo.test.table;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.table.layoutable.TableCellRendererLayout;

public class AdaptiveTableDemo
	extends JPanel
{
	public PopupMenu popupMenu;
	
	public JTable table;
	
	public AdaptiveTableDemo()
	{
		popupMenu = new PopupMenu();
		
		Object[][] rows = { 
				{"0", "000000000", "0000000000000000", "000000000", "000000000", "000000000", "000000000", "000000000"}, 
				{"000000000", "000000000", "000000000", "000000000", "000000000", "000000000", "000000000", "000000000"}, 
				{"000000000", "000000000", "000000000", "000000000", "000000000", "000000000", "000000000", "000000000"},
				{"000000000", "000000000", "000000000", "000000000", "000000000", "000000000", "000000000", "000000000"}, 
				{"000000000", "000000000", "000000000", "000000000", "000000000", "000000000", "000000000", "000000000"},
				{"000000000", "000000000", "000000000", "000000000", "000000000", "000000000", "000000000", "000000000"}, 
				{"000000000", "000000000", "000000000", "000000000", "000000000", "000000000", "000000000", "000000000"},				
				{"000000000", "000000000", "000000000", "000000000", "000000000", "000000000", "000000000", "000000000"}};
		Object[] columns = {"aa", "bbbbbb", "ccc", "dddddd"};
		
		table = new JTable(rows, columns);
		table.setDefaultRenderer(Object.class, new Renderer(12));
		table.addMouseListener(new MouseListener());
		// table.getTableHeader().setReorderingAllowed(false); // 改变列次序
		// table.getTableHeader().setResizingAllowed(false); // 改变列宽度
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // 显示横向滚动条
		
		JBasicScrollPane scrollPane = new JBasicScrollPane(table);
		
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
	}
	
	
	public class Renderer
		extends DefaultTableCellRenderer
	{
		private int fontSize;
		
		public Renderer(int fontSize)
		{
			this.fontSize = fontSize;
		}
		
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		{
			DefaultTableCellRenderer c = (DefaultTableCellRenderer) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			
			c.setFont(new Font("Dialog", Font.PLAIN, fontSize));
			c.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			
			return c;
		}
	}
	
	public class PopupMenu
		extends JPopupMenu
	{
		private int i = 12;
		
		public PopupMenu()
		{
			JMenuItem a = new JMenuItem("Zoom In");
			//a.setAccelerator(KeyStroke.getKeyStroke(Character.valueOf('+'), InputEvent.CTRL_MASK));
			a.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					i++;
					table.setDefaultRenderer(Object.class, new Renderer(i));
					adaptTableCellRendererSize();
				}
			});
			add(a);
			
			JMenuItem b = new JMenuItem("Zoom Out");
			//b.setAccelerator(KeyStroke.getKeyStroke(Character.valueOf('-'), InputEvent.CTRL_MASK));
			b.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					i--;
					table.setDefaultRenderer(Object.class, new Renderer(i));
					adaptTableCellRendererSize();
				}
			});
			add(b);
		}
		
		private void adaptTableCellRendererSize()
		{
			TableCellRendererLayout layout = new TableCellRendererLayout(table);
			//layout.doLayout();
			//layout.doLayout(new int[]{10, 20});
			//layout.doLayout(new int[][]{{50},{80}});
			//layout.doLayout(new int[][]{{TableCellRendererLayout.PREFERRED},{TableCellRendererLayout.PREFERRED}});
			layout.doLayout(new int[][]{
					                   {TableCellRendererLayout.PREFERRED, 200, TableCellRendererLayout.IGNORE, 300},
					                   {200, TableCellRendererLayout.IGNORE, TableCellRendererLayout.PREFERRED, 200}
					                   },
							new int[][]{{50, 80}, {-1, -1}}
			);			
		}
	}
	
	public class MouseListener
		extends MouseAdapter
	{
		public void mouseReleased(MouseEvent e)
		{
			if (!e.isPopupTrigger())
			{
				return;
			}
			
			popupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}
	
	public static void main(String[] args)
	{
		LookAndFeelManager.setPlasticLookAndFeel();
		JFrame f = new JFrame();
		f.getContentPane().add(new AdaptiveTableDemo());
		f.setSize(1000, 300);
		f.setVisible(true);
	}
}