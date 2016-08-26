package com.nepxion.demo.component.layout.table;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.layout.table.TableLayout;

public class DemoAbsoluteTableLayoutPanel
	extends JPanel
{
	public DemoAbsoluteTableLayoutPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new RegularTableLayoutPanel());
		add(new ComplexTableLayoutPanel());
	}
	
	public class RegularTableLayoutPanel
		extends JPanel
	{
		public RegularTableLayoutPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Regular"));
			
			double[][] size = 
			{ 
				{80, 60, 70, 90}, 
				{25, 30, 35}
			};
			
			JPanel panel = new JPanel();
			panel.setLayout(new TableLayout(size));
			
			JButton[] buttons = new JButton[12];
			for (int i = 0; i < 12; i++)
			{
				buttons[i] = new JButton();
			}			
			
			buttons[0].setText("0, 0");
			buttons[1].setText("1, 0");
			buttons[2].setText("2, 0");
			buttons[3].setText("3, 0");
			buttons[4].setText("0, 1");	
			buttons[5].setText("1, 1");
			buttons[6].setText("2, 1");
			buttons[7].setText("3, 1");
			buttons[8].setText("0, 2");
			buttons[9].setText("1, 2");
			buttons[10].setText("2, 2");
			buttons[11].setText("3, 2");
			
			panel.add(buttons[0], "0, 0");
			panel.add(buttons[1], "1, 0");
			panel.add(buttons[2], "2, 0");
			panel.add(buttons[3], "3, 0");					
			panel.add(buttons[4], "0, 1");			
			panel.add(buttons[5], "1, 1");			
			panel.add(buttons[6], "2, 1");			
			panel.add(buttons[7], "3, 1");			
			panel.add(buttons[8], "0, 2");					
			panel.add(buttons[9], "1, 2");					
			panel.add(buttons[10], "2, 2");						
			panel.add(buttons[11], "3, 2");
			
			add(panel);
		}
	}
	
	public class ComplexTableLayoutPanel
		extends JPanel
	{
		public ComplexTableLayoutPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Complex"));			

			double[][] size = 
			{ 
				{80, 60, 70, 90}, 
				{25, 30, 35, 30, 25}
			};
			
			JPanel panel = new JPanel();
			panel.setLayout(new TableLayout(size));
			
			JButton[] buttons = new JButton[10];
			for (int i = 0; i < 10; i++)
			{
				buttons[i] = new JButton();
			}			
			
			buttons[0].setText("0, 0");
			buttons[1].setText("1, 0");
			buttons[2].setText("2, 0");	
			buttons[3].setText("3, 0");
			buttons[4].setText("0, 1, 3, 1");	
			buttons[5].setText("0, 2, 2, 2");	
			buttons[6].setText("3, 2, 3, 2");
			buttons[7].setText("0, 3, 0, 4");	
			buttons[8].setText("1, 3, 3, 3");
			buttons[9].setText("1, 4, 3, 4");
			
			panel.add(buttons[0], "0, 0");									
			panel.add(buttons[1], "1, 0");								
			panel.add(buttons[2], "2, 0");			
			panel.add(buttons[3], "3, 0");			
			panel.add(buttons[4], "0, 1, 3, 1");		
			panel.add(buttons[5], "0, 2, 2, 2");		
			panel.add(buttons[6], "3, 2, 3, 2");		
			panel.add(buttons[7], "0, 3, 0, 4");		
			panel.add(buttons[8], "1, 3, 3, 3");			
			panel.add(buttons[9], "1, 4, 3, 4");
			
			add(panel);
		}
	}
}