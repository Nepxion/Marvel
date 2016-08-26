package com.nepxion.demo.component.layout.box;

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
import com.nepxion.swing.layout.box.XBoxLayout;
import com.nepxion.swing.layout.filed.FiledLayout;

public class DemoColumnXBoxLayoutPanel
	extends JPanel
{
	public DemoColumnXBoxLayoutPanel()
	{
		setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new BoxLayoutPanel());
	}
	
	public class BoxLayoutPanel
		extends JPanel
	{
		public BoxLayoutPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Column"));
			
			JPanel panel = new JPanel();
			panel.setLayout(new XBoxLayout(panel, XBoxLayout.Y_AXIS, 5));
			panel.setPreferredSize(new Dimension(100, panel.getPreferredSize().height));
			
			JButton fixButton = new JButton("Fix (H:80)");
			fixButton.setPreferredSize(new Dimension(100, 80));
			fixButton.setMinimumSize(new Dimension(0, 0));
			panel.add(fixButton, XBoxLayout.FIX);
			
			JButton flexButton = new JButton("Flex (H:240)");
			flexButton.setPreferredSize(new Dimension(100, 240));
			flexButton.setMinimumSize(new Dimension(0, 0));
			panel.add(flexButton, XBoxLayout.FLEXIBLE);
			
			JButton varyButton = new JButton("Vary (H:120)");
			varyButton.setPreferredSize(new Dimension(100, 120));
			varyButton.setMinimumSize(new Dimension(0, 0));
			panel.add(varyButton, XBoxLayout.VARY);
			
			add(panel);
		}
	}
}