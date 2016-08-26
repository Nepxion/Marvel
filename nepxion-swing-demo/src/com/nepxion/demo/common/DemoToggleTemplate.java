package com.nepxion.demo.common;

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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.button.JBasicToggleButton;
import com.nepxion.swing.container.JContainer;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.memorybar.JMemoryProgressBar;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.textarea.JBasicTextArea;
import com.nepxion.util.io.FileUtil;

public class DemoToggleTemplate
	extends JContainer
{
	private JComponent viewComponent;
	private JBasicScrollPane codeScrollPane;
	private JBasicTextArea codeTextArea;
	private ToggleButtonPanel toggleButtonPanel;
	
	private String codeContent;
	
	public DemoToggleTemplate(JComponent viewComponent)
	{
		this.viewComponent = viewComponent;
			
		codeTextArea = new JBasicTextArea();
		codeTextArea.setTabSize(2);
						
		codeScrollPane = new JBasicScrollPane();
		codeScrollPane.getViewport().add(codeTextArea);
		
		toggleButtonPanel = new ToggleButtonPanel();
		
		setLayout(new BorderLayout());
		add(viewComponent, BorderLayout.CENTER);
		add(toggleButtonPanel, BorderLayout.SOUTH);				
	}
	
	public class ToggleButtonPanel
		extends JPanel
	{
		public ToggleButtonPanel()
		{			
			final JMemoryProgressBar memoryProgressBar = new JMemoryProgressBar();
			DimensionManager.setDimension(memoryProgressBar, new Dimension(120, 25));
			memoryProgressBar.start();
			
			JBasicButton memoryGCButton = new JBasicButton(IconFactory.getSwingIcon("gc.png"), "Garbage Collector");
			memoryGCButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{					
					memoryProgressBar.gc();
				}
			}
			);
			
			JBasicToggleButton viewToggleButton = new JBasicToggleButton("View", IconFactory.getSwingIcon("component/view.png"), "View", true);
			viewToggleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{					
					addComponent(viewComponent, codeScrollPane, BorderLayout.CENTER);
				}
			}
			);
			JBasicToggleButton codeToggleButton = new JBasicToggleButton("Code", IconFactory.getSwingIcon("component/java.png"), "Code");		
			codeToggleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{					
					addComponent(codeScrollPane, viewComponent, BorderLayout.CENTER);
					
					if (codeContent == null)
					{
						String projectFolderName = "nepxion-swing-demo";
						String codePath = FileUtil.getResourcePath(viewComponent.getClass(), projectFolderName);
						
						try
						{
							codeContent = FileUtil.readString(codePath, "GBK", false);
						}
						catch (FileNotFoundException ex)
						{
							ex.printStackTrace();
						}
						catch (UnsupportedEncodingException ex)
						{
							ex.printStackTrace();
						}
						catch (IOException ex)
						{
							ex.printStackTrace();
						}						
						codeTextArea.setText(codeContent);
						codeTextArea.moveCaretPosition(0);
					}					
				}
			}
			);
			
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderFactory.createEmptyBorder(2, 0, 3, 3)); // 2, 0, 1, 1
			add(memoryProgressBar);
			add(memoryGCButton);
			add(Box.createHorizontalGlue());
			add(viewToggleButton);			
			add(Box.createHorizontalStrut(3));
			add(codeToggleButton);
			
			ButtonManager.updateUI(this, new Dimension(75, 25), new ButtonGroup());
			
			memoryGCButton.setDimension(new Dimension(25, 25));
		}
	}
}