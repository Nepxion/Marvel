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

public class DemoRowFiledLayoutPanel
	extends JPanel
{
	public DemoRowFiledLayoutPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new FiledLayoutPanel(FiledLayout.TOP, "Top"));
		add(new FiledLayoutPanel(FiledLayout.CENTER, "Center"));
		add(new FiledLayoutPanel(FiledLayout.BOTTOM, "Bottom"));
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
			panel.setLayout(new FiledLayout(FiledLayout.ROW, justification, 5));
			panel.setPreferredSize(new Dimension(panel.getPreferredSize().width, 50));
			
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