package com.nepxion.demo.component.panel;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoSelectionValuePanel;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.dialog.JBasicDialog;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.panel.option.JOptionButtonPanel;

public class DemoOptionPanel
	extends JPanel
{
	private DemoSelectionValuePanel selectionValuePanel;
	
	public DemoOptionPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		selectionValuePanel = new DemoSelectionValuePanel();
		
		add(new ButtonPanel());
		add(selectionValuePanel);
	}
	
	public class ButtonPanel
		extends JPanel
	{
		public ButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Button Panel"));
			
			JBasicButton yesNoApplyOptionButton = new JBasicButton("Yes & No & Apply Option Panel", IconFactory.getSwingIcon("component/button_16.png"), "Yes & No & Apply Option Panel");
			yesNoApplyOptionButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{		
	                JOptionButtonPanel optionPanel = new JOptionButtonPanel(JOptionButtonPanel.YES_NO_APPLY_OPTION)
	                {
	                    public boolean confirm()
	                    {
	                    	selectionValuePanel.setValue("Yes");
	                    	
	                    	return true;
	                    }

						public boolean cancel()
						{
							selectionValuePanel.setValue("No");
							
							return true;
						}	
						
						public boolean apply()
						{
							selectionValuePanel.setValue("Apply");
							
							return true;
						}
	                };
	                
	                JBasicDialog optionDialog = new JBasicDialog(HandleManager.getFrame(DemoOptionPanel.this), "Yes & No & Apply Option Panel", new Dimension(300, 300));
	                optionDialog.getContentPane().setLayout(new BorderLayout());
	                optionDialog.getContentPane().add(optionPanel, BorderLayout.SOUTH);
	                optionDialog.setVisible(true);
	                optionDialog.dispose();
				}
			}
			);
			add(yesNoApplyOptionButton);
			
			JBasicButton yesNoOptionButton = new JBasicButton("Yes & No Option Panel", IconFactory.getSwingIcon("component/button_16.png"), "Yes & No Option Panel");
			yesNoOptionButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{		
	                JOptionButtonPanel optionPanel = new JOptionButtonPanel(JOptionButtonPanel.YES_NO_OPTION)
	                {
	                    public boolean confirm()
	                    {
	                    	selectionValuePanel.setValue("Yes");
	                    	
	                    	return true;
	                    }

						public boolean cancel()
						{
							selectionValuePanel.setValue("No");
							
							return true;
						}	                    
	                };
	                
	                JBasicDialog optionDialog = new JBasicDialog(HandleManager.getFrame(DemoOptionPanel.this), "Yes & No Option Panel", new Dimension(300, 300));
	                optionDialog.getContentPane().setLayout(new BorderLayout());
	                optionDialog.getContentPane().add(optionPanel, BorderLayout.SOUTH);
	                optionDialog.setVisible(true);
	                optionDialog.dispose();
				}
			}
			);
			add(yesNoOptionButton);
			
			JBasicButton closeOptionButton = new JBasicButton("Close Option Panel", IconFactory.getSwingIcon("component/button_16.png"), "Close Option Panel");
			closeOptionButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{		
					JOptionButtonPanel optionPanel = new JOptionButtonPanel(JOptionButtonPanel.CLOSE_OPTION)
	                {
						public boolean close()
						{
							selectionValuePanel.setValue("Close");
							
							return true;
						}	                    
	                };
	                
	                JBasicDialog optionDialog = new JBasicDialog(HandleManager.getFrame(DemoOptionPanel.this), "Close Option Panel", new Dimension(300, 300));
	                optionDialog.getContentPane().setLayout(new BorderLayout());
	                optionDialog.getContentPane().add(optionPanel, BorderLayout.SOUTH);
	                optionDialog.setVisible(true);
	                optionDialog.dispose();
				}
			}
			);
			add(closeOptionButton);			
			
			ButtonManager.updateUI(this);
		}
	}
}