package com.nepxion.demo.component.optionpane;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public class DemoOptionPanePanel
	extends JPanel
{
	public DemoOptionPanePanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new OptionPanePanel());
	}
	
	public class OptionPanePanel
		extends JPanel
	{
		public OptionPanePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("OptionPane"));
			
			JBasicButton optionPaneButton = new JBasicButton("OptionPane", IconFactory.getSwingIcon("component/option_pane_16.png"), "OptionPane");
			optionPaneButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
//	                JColorPane colorPane = new JColorPane();
//	                int selectedValue = JBasicOptionPane.showDialog(HandleManager.getFrame(DemoOptionPanePanel.this), colorPane, "Color Selector", IconFactory.getSwingIcon("component/color_chooser_32.png"));
//	                if (selectedValue != 0)
//	                {
//	                    return;
//	                }
				}
			}
			);
			add(optionPaneButton);
			
			ButtonManager.updateUI(this);
		}
	}
}