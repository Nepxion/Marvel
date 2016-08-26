package com.nepxion.demo.component.tabbedpane;

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
import com.nepxion.swing.checkbox.JBasicCheckBox;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.tabbedpane.JBasicTabbedPane;

public class DemoBasicTabbedPanePanel
	extends JPanel
{	
	public DemoBasicTabbedPanePanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new BasicTabbedPanePanel());
	}
	
	public class BasicTabbedPanePanel
		extends JPanel
	{
		public BasicTabbedPanePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Basic TabbedPane"));
			
			final JBasicTabbedPane basicTabbedPane = new JBasicTabbedPane()
			{
			    public void removeTabAt(int index)
			    {
			        String title = getTitleAt(index);
			        if (isHint(index))
			        {
			            int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(DemoBasicTabbedPanePanel.this), "'" + title + "' is modified, sure to close it?", "Close", JBasicOptionPane.YES_NO_OPTION);
			            if (selectedValue != JBasicOptionPane.YES_OPTION)
			            {
			                return;
			            }
			            
			            super.removeTabAt(index);
			        }
			        else
			        {
			        	super.removeTabAt(index);
			        }
			    }				
			};		
			
			basicTabbedPane.addTab("Tab 1", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new ConfigPanel(basicTabbedPane)), "Tab 1", true);					
			basicTabbedPane.addTab("Tab 2", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new ConfigPanel(basicTabbedPane)), "Tab 2", false);
			basicTabbedPane.addTab("Tab 3", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new ConfigPanel(basicTabbedPane)), "Tab 3", true);
			basicTabbedPane.addTab("Tab 4", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new ConfigPanel(basicTabbedPane)), "Tab 4", false);
			basicTabbedPane.addTab("Tab 5", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new ConfigPanel(basicTabbedPane)), "Tab 5", true);
			basicTabbedPane.addTab("Tab 6", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new ConfigPanel(basicTabbedPane)), "Tab 6", false);
			basicTabbedPane.addTab("Tab 7", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new ConfigPanel(basicTabbedPane)), "Tab 7", true);
			basicTabbedPane.addTab("Tab 8", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new ConfigPanel(basicTabbedPane)), "Tab 8", false);
			basicTabbedPane.setDrawCenter(0, true);
			
			
			JBasicPopupMenu popupMenu = new JBasicPopupMenu();
			basicTabbedPane.setPopupMenu(popupMenu, true);			
			add(basicTabbedPane);			
		}
	}
	
	public class ConfigPanel
		extends JPanel
	{
		public ConfigPanel(final JBasicTabbedPane basicTabbedPane)
		{
			setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			
			final JBasicCheckBox closableCheckBox = new JBasicCheckBox("Show Close Button", "Show Close Button", true);
			closableCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					basicTabbedPane.setTabClosableAt(basicTabbedPane.getSelectedIndex(), closableCheckBox.isSelected());
				}				
			}
			);			
			add(closableCheckBox);	
			
			final JBasicCheckBox drawCenterCheckBox = new JBasicCheckBox("Close Button - Draw Center", "Close Button - Draw Center", true);
			drawCenterCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					basicTabbedPane.setDrawCenter(basicTabbedPane.getSelectedIndex(), drawCenterCheckBox.isSelected());
				}				
			}
			);				
			add(drawCenterCheckBox);	
			
			final JBasicCheckBox drawBorderCheckBox = new JBasicCheckBox("Close Button - Draw Border", "Close Button - Draw Border", true);
			drawBorderCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					basicTabbedPane.setDrawBorder(basicTabbedPane.getSelectedIndex(), drawBorderCheckBox.isSelected());
				}				
			}
			);				
			add(drawBorderCheckBox);		
			
			final JBasicCheckBox hintCheckBox = new JBasicCheckBox("Show hint while closing the tab", "Show hint while closing the tab", false);
			hintCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					basicTabbedPane.setHint(basicTabbedPane.getSelectedIndex(), hintCheckBox.isSelected());
				}				
			}
			);			
			add(hintCheckBox);		
		}
	}
}