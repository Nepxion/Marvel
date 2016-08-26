package com.nepxion.demo.component.layout.border;

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
import com.nepxion.swing.layout.border.XBorderLayout;
import com.nepxion.swing.layout.filed.FiledLayout;

public class DemoXBorderLayoutPanel
	extends JPanel
{
	public DemoXBorderLayoutPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new BorderLayoutPanel());
	}
	
	public class BorderLayoutPanel
		extends JPanel
	{
		public BorderLayoutPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("XBorder"));
			
			JPanel panel = new JPanel();
			panel.setLayout(new XBorderLayout(5, 10));
			panel.setMaximumSize(new Dimension(250, 250));
			
			JButton northButton = new JButton("North");
			panel.add(northButton, XBorderLayout.BEFORE_FIRST_LINE);
			
			JButton southButton = new JButton("South");
			panel.add(southButton, XBorderLayout.AFTER_LAST_LINE);
			
			JButton westButton = new JButton("West");
			panel.add(westButton, XBorderLayout.BEFORE_LINE_BEGINS);
			
			JButton eastButton = new JButton("East");
			panel.add(eastButton, XBorderLayout.AFTER_LINE_ENDS);
			
			JButton centerButton = new JButton("Center");
			panel.add(centerButton, XBorderLayout.CENTER);
			
			add(panel);
		}
	}
}