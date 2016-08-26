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

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.checkbox.JBasicCheckBox;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.label.JBasicLabel;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.listener.SelectionListener;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;
import com.nepxion.swing.renderer.combobox.ElementComboBoxCellRenderer;
import com.nepxion.swing.style.framework.IStyle;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;
import com.nepxion.util.data.CollectionUtil;

public class DemoEclipseTabbedPanePanel
	extends JPanel
{	
	private JEclipseTabbedPane eclipseTabbedPane;
	
	public DemoEclipseTabbedPanePanel()
	{
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new EclipseTabbedPanePanel(), BorderLayout.CENTER);
		add(new PublicConfigPanel(), BorderLayout.SOUTH);
	}
	
	public class EclipseTabbedPanePanel
		extends JPanel
	{
		public EclipseTabbedPanePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Eclipse TabbedPane"));
			
			eclipseTabbedPane = new JEclipseTabbedPane()
			{			    
			    public void removeTabAt(int index)
			    {
			        String title = getTitleAt(index);
			        int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(DemoEclipseTabbedPanePanel.this), "'" + title + "' is modified, sure to close it?", "Close", JBasicOptionPane.YES_NO_OPTION);
			        if (selectedValue != JBasicOptionPane.YES_OPTION)
			        {
			            return;
			        }
			        
			        super.removeTabAt(index);
			    }			    
			};	
			
			eclipseTabbedPane.addTab("Tab 1", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new PrivateConfigPanel(), "Tab 1", true);					
			eclipseTabbedPane.addTab("Tab 2", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new PrivateConfigPanel(), "Tab 2", false);
			eclipseTabbedPane.addTab("Tab 3", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new PrivateConfigPanel(), "Tab 3", true);
			eclipseTabbedPane.addTab("Tab 4", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new PrivateConfigPanel(), "Tab 4", false);
			eclipseTabbedPane.addTab("Tab 5", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new PrivateConfigPanel(), "Tab 5", true);
			eclipseTabbedPane.addTab("Tab 6", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new PrivateConfigPanel(), "Tab 6", false);
			eclipseTabbedPane.addTab("Tab 7", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new PrivateConfigPanel(), "Tab 7", true);
			eclipseTabbedPane.addTab("Tab 8", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new PrivateConfigPanel(), "Tab 8", false);
			
			JBasicPopupMenu popupMenu = new JBasicPopupMenu();
			eclipseTabbedPane.setPopupMenu(popupMenu, true);			
			add(eclipseTabbedPane);	

	        /*eclipseTabbedPane.setTabPlacement(JEclipseTabbedPane.TOP);
	        eclipseTabbedPane.setShowTabButtons(true);
	        eclipseTabbedPane.setShowCloseButton(true);
	        eclipseTabbedPane.setShowCloseButtonOnTab(true);
	        eclipseTabbedPane.setHideOneTab(true);
	        eclipseTabbedPane.setTabEditingAllowed(true);
	        eclipseTabbedPane.setTabClosableAt(2, false);	
			eclipseTabbedPane.setShowTabBorder(false);*/
		}
	}
	
	public class PublicConfigPanel
		extends JPanel
	{		
		public PublicConfigPanel()
		{
			setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
			setBorder(BorderManager.createComplexTitledBorder("Public Configuration"));
			
			List tabShapeElementNodes = DemoDataFactory.getTabShapeElementNodes();
			
			final JBasicComboBox tabShapeComboBox = new JBasicComboBox(CollectionUtil.parseVector(tabShapeElementNodes));
			tabShapeComboBox.setRenderer(new ElementComboBoxCellRenderer());
			tabShapeComboBox.addItemListener(new SelectionListener()
			{
				public void itemSelectionStateChanged(ItemEvent e)
				{
					ElementNode elementNode = (ElementNode) tabShapeComboBox.getSelectedItem();
					eclipseTabbedPane.setTabShape(elementNode.getIndex());
				}
			}
			);
			add(tabShapeComboBox);
			
			List styleElementNodes = DemoDataFactory.getStyleElementNodes();
			
			final JBasicComboBox styleComboBox = new JBasicComboBox(CollectionUtil.parseVector(styleElementNodes));
			styleComboBox.setRenderer(new ElementComboBoxCellRenderer());
			styleComboBox.addItemListener(new SelectionListener()
			{
				public void itemSelectionStateChanged(ItemEvent e)
				{
					ElementNode elementNode = (ElementNode) styleComboBox.getSelectedItem();
					eclipseTabbedPane.setTabShape((IStyle) elementNode.getUserObject());
				}
			}
			);
			add(styleComboBox);
	        
	        final JBasicCheckBox showTabAreaCheckBox = new JBasicCheckBox("Show Tab Area", "Show Tab Area", true);	
	        showTabAreaCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					eclipseTabbedPane.setShowTabArea(showTabAreaCheckBox.isSelected());
				}				
			}
			);	
	        add(showTabAreaCheckBox);	        
	        
	        final JBasicCheckBox hideTabAreaCheckBox = new JBasicCheckBox("Show Tab Area If More Than One Tabs Shown", "Show Tab Area If More Than One Tabs Shown", false);	
	        hideTabAreaCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					eclipseTabbedPane.setHideOneTab(hideTabAreaCheckBox.isSelected());
				}				
			}
			);	
	        add(hideTabAreaCheckBox);	
	        
	        final JBasicCheckBox showTabContentCheckBox = new JBasicCheckBox("Show Tab Content", "Show Tab Content", true);	
	        showTabContentCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					eclipseTabbedPane.setShowTabContent(showTabContentCheckBox.isSelected());
				}				
			}
			);	
	        add(showTabContentCheckBox);
	        
	        final JBasicCheckBox showTabBorderCheckBox = new JBasicCheckBox("Show Tab Border (Only supports Eclipse3X Shape, VSNet Shape (Rounded Corner) and VSNet Shape)", "Show Tab Border", false);	
	        showTabBorderCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					eclipseTabbedPane.setShowTabBorder(showTabBorderCheckBox.isSelected());
				}				
			}
			);	
	        add(showTabBorderCheckBox);
						
	        final JBasicCheckBox showTabButtonsCheckBox = new JBasicCheckBox("Show Tab Buttons", "Show Tab Buttons", false);	
	        showTabButtonsCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					eclipseTabbedPane.setShowTabButtons(showTabButtonsCheckBox.isSelected());
				}				
			}
			);	
	        add(showTabButtonsCheckBox);	
			
			final JBasicCheckBox showBoldFontCheckBox = new JBasicCheckBox("Show Bold Font In Selection Tab", "Show Bold Font In Selection Tab", false);
			showBoldFontCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					eclipseTabbedPane.setBoldActiveTab(showBoldFontCheckBox.isSelected());
				}				
			}
			);			
			add(showBoldFontCheckBox);	
			
			final JBasicCheckBox showTabLeadingComponentCheckBox = new JBasicCheckBox("Show Tab Leading Component", "Show Tab Leading Component", false);
			showTabLeadingComponentCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
	                if (showTabLeadingComponentCheckBox.isSelected())
					{	             
	                	JBasicLabel trailingLabel = new JBasicLabel(IconFactory.getSwingIcon("logo.png"), "Nepxion Studio");
						eclipseTabbedPane.setTabLeadingComponent(trailingLabel);
					}
					else
					{
						eclipseTabbedPane.setTabLeadingComponent(null);
					}
				}				
			}
			);			
			add(showTabLeadingComponentCheckBox);	
			
			final JBasicCheckBox showTabTrailingComponentCheckBox = new JBasicCheckBox("Show Tab Trailing Component", "Show Tab Trailing Component", false);
			showTabTrailingComponentCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
	                if (showTabTrailingComponentCheckBox.isSelected())
					{	             
	                	JBasicLabel trailingLabel = new JBasicLabel(IconFactory.getSwingIcon("logo.png"), "Nepxion Studio");
						eclipseTabbedPane.setTabTrailingComponent(trailingLabel);
					}
					else
					{
						eclipseTabbedPane.setTabTrailingComponent(null);
					}
				}				
			}
			);			
			add(showTabTrailingComponentCheckBox);		
			
	        final JBasicCheckBox allowEditingTabTitleCheckBox = new JBasicCheckBox("Allow Editing Tab Title", "Allow Editing Tab Title", false);
	        allowEditingTabTitleCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					eclipseTabbedPane.setTabEditingAllowed(allowEditingTabTitleCheckBox.isSelected());
				}
			}
	        );
	        add(allowEditingTabTitleCheckBox);

//	        final JCheckBox allowDuplicateTabNames = new JCheckBox("Allow Duplicate Tab Names");
//	        allowDuplicateTabNames.setSelected(_tabbedPane.isTabEditingAllowed());
//	        allowDuplicateTabNames.addItemListener(new ItemListener() {
//	            public void itemStateChanged(ItemEvent e) {
//	                _allowDuplicateTabNames = allowDuplicateTabNames.isSelected();
//	            }
//	        }
//	        );			
		}
	}
	
	public class PrivateConfigPanel
		extends JPanel
	{		
		public PrivateConfigPanel()
		{
			setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
			setBorder(BorderManager.createComplexTitledBorder("Private Configuration"));	
	        
			final JBasicCheckBox showCloseButtonCheckBox = new JBasicCheckBox("Show Close Button", "Show Close Button", true);
			showCloseButtonCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					eclipseTabbedPane.setTabClosableAt(eclipseTabbedPane.getSelectedIndex(), showCloseButtonCheckBox.isSelected());
				}				
			}
			);			
			add(showCloseButtonCheckBox);	
		}
	}
}