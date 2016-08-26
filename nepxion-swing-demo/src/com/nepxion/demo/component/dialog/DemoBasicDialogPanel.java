package com.nepxion.demo.component.dialog;

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
import com.nepxion.swing.dialog.JBasicDialog;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;

public class DemoBasicDialogPanel
	extends JPanel
{
	private JBasicDialog basicDialog;
	
	public DemoBasicDialogPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new BasicDialogPanel());
		add(new ConfigPanel());
	}
	
	public class BasicDialogPanel
		extends JPanel
	{
		public BasicDialogPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Basic Dialog"));
			
			JBasicButton basicDialogButton = new JBasicButton("Basic Dialog", IconFactory.getSwingIcon("component/dialog_16.png"), "Basic Dialog");
			basicDialogButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (basicDialog == null)
					{	
						basicDialog = new JBasicDialog(HandleManager.getFrame(DemoBasicDialogPanel.this), "Basic Dialog", new Dimension(300, 300), true, true, true);
						basicDialog.setMinimumDimension(new Dimension(200, 200));
						basicDialog.setMaximumDimension(new Dimension(400, 400));
					}	
					basicDialog.setVisible(true);
					basicDialog.dispose();
				}
			}
			);
			add(basicDialogButton);
			
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
			
	        final JBasicCheckBox adaptableCheckBox = new JBasicCheckBox("Adapt the size while resizing the dialog", "Adapt the size while resizing the dialog", true);	
	        adaptableCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					basicDialog.setAdaptable(adaptableCheckBox.isSelected());
				}				
			}
			);	
	        add(adaptableCheckBox);	
	        
	        final JBasicCheckBox hintCheckBox = new JBasicCheckBox("Show hint while closing the dialog", "Show hint while closing the dialog", true);	
	        hintCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					basicDialog.setHint(hintCheckBox.isSelected());
				}				
			}
			);	
	        add(hintCheckBox);
	        
	        final JBasicCheckBox minimumDimensionCheckBox = new JBasicCheckBox("Set minimum dimension (width=200, height=200)", "Set minimum dimension (width=200, height=200)", true);	
	        minimumDimensionCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (minimumDimensionCheckBox.isSelected())
					{	
						basicDialog.setMinimumDimension(new Dimension(200, 200));
					}
					else
					{
						basicDialog.setMinimumDimension(null);
					}
				}				
			}
			);	
	        add(minimumDimensionCheckBox);
	        
	        final JBasicCheckBox maximumDimensionCheckBox = new JBasicCheckBox("Set maximum dimension (width=400, height=400)", "Set maximum dimension (width=400, height=400)", true);	
	        maximumDimensionCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (maximumDimensionCheckBox.isSelected())
					{	
						basicDialog.setMaximumDimension(new Dimension(400, 400));
					}
					else
					{
						basicDialog.setMaximumDimension(null);
					}
				}				
			}
			);	
	        add(maximumDimensionCheckBox);	        
		}
	}
}