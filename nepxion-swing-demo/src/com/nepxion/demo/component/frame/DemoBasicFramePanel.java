package com.nepxion.demo.component.frame;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.checkbox.JBasicCheckBox;
import com.nepxion.swing.frame.JBasicFrame;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;

public class DemoBasicFramePanel
	extends JPanel
{
	private JBasicFrame basicFrame;
	
	public DemoBasicFramePanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new BasicFramePanel());
		add(new ConfigPanel());
	}
	
	public class BasicFramePanel
		extends JPanel
	{
		public BasicFramePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Basic Frame"));
			
			JBasicButton frameButton = new JBasicButton("Basic Frame", IconFactory.getSwingIcon("component/dialog_16.png"), "Basic Frame");
			frameButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (basicFrame == null)
					{	
						basicFrame = new JBasicFrame("Basic Frame", IconFactory.getSwingIcon("tray_java.png"), new Dimension(300, 300), true, false);
					}	
					basicFrame.setVisible(true);
				}
			}
			);
			add(frameButton);
			
			ButtonManager.updateUI(this);
		}
	}
	
	public class ConfigPanel
		extends JPanel
	{
		public ConfigPanel()
		{
			setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
			setBorder(BorderManager.createComplexTitledBorder("Configuration"));
	        
	        final JBasicCheckBox hintCheckBox = new JBasicCheckBox("Show hint while closing the dialog", "Show hint while closing the dialog", true);	
	        hintCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					basicFrame.setHint(hintCheckBox.isSelected());
				}				
			}
			);	
	        add(hintCheckBox);   
	        
	        final JBasicCheckBox destroyCheckBox = new JBasicCheckBox("Destroy VM while closing the dialog", "Destroy VM while closing the dialog", false);	
	        destroyCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					basicFrame.setDestroy(destroyCheckBox.isSelected());
				}				
			}
			);	
	        add(destroyCheckBox);	        
		}
	}
}