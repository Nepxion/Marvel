package com.nepxion.demo.component.layout.filed;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.layout.filed.FiledLayout;

public class DemoColumnFiledLayoutPanel
	extends JPanel
{
	public DemoColumnFiledLayoutPanel()
	{
		setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new FiledLayoutPanel(FiledLayout.LEFT, "Left"));
		add(new FiledLayoutPanel(FiledLayout.CENTER, "Center"));
		add(new FiledLayoutPanel(FiledLayout.RIGHT, "Right"));
		add(new FiledLayoutPanel(FiledLayout.FULL, "Full"));
	}
	
	public class FiledLayoutPanel
		extends JPanel
	{
		public FiledLayoutPanel(int justification, String text)
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder(text));			
			
			JPanel panel = new JPanel();			
			panel.setLayout(new FiledLayout(FiledLayout.COLUMN, justification, 5));
			panel.setPreferredSize(new Dimension(80, panel.getPreferredSize().height));
			
			JButton[] buttons = new JButton[5];
			for (int i = 0; i < 5; i++)
			{
				buttons[i] = new JButton();
				buttons[i].setText(i + "");
				panel.add(buttons[i]);
			}					
			
			add(panel);
		}
	}
}