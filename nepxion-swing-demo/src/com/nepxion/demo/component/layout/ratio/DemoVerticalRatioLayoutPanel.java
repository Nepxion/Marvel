package com.nepxion.demo.component.layout.ratio;

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
import com.nepxion.swing.layout.ratio.RatioLayout;

public class DemoVerticalRatioLayoutPanel
	extends JPanel
{
	public DemoVerticalRatioLayoutPanel()
	{
		setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new VerticalRatioLayoutPanel("Absolute"));
		add(new VerticalRatioLayoutPanel("Relative"));
	}
	
	public class VerticalRatioLayoutPanel
		extends JPanel
	{
		public VerticalRatioLayoutPanel(String text)
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder(text));
			
			JPanel panel = new JPanel();
			panel.setLayout(new RatioLayout(RatioLayout.VERTICAL, 5));
			panel.setPreferredSize(new Dimension(60, panel.getPreferredSize().width));
			
			JButton[] buttons = new JButton[5];
			for (int i = 0; i < 5; i++)
			{
				buttons[i] = new JButton();
				String ratio = text.equals("Relative") ? 5 * (i + 2) + "%" : 25 * (i + 2) + "";
				buttons[i].setText(ratio);
				panel.add(buttons[i], ratio);
			}
			
			add(panel);
		}
	}
}