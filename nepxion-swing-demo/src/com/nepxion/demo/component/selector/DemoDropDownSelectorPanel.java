package com.nepxion.demo.component.selector;

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
import com.nepxion.swing.dialog.JBasicDialog;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.selector.dropdown.component.JTreeDropDownSelector;
import com.nepxion.swing.tree.JBasicTree;

public class DemoDropDownSelectorPanel
	extends JPanel
{
	public DemoDropDownSelectorPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new TreeDropDownSelectorPanel());
		add(new TableDropDownSelectorPanel());
		add(new ListDropDownSelectorPanel());
	}
	
	public class TreeDropDownSelectorPanel
		extends JPanel
	{
		public TreeDropDownSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Tree DropDown Selector"));
			
			JBasicButton popupMenuStyleButton = new JBasicButton("PopupMenu Style", IconFactory.getSwingIcon("component/tree_16.png"), "PopupMenu Style");
			popupMenuStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JBasicTree tree = new JBasicTree();
					JTreeDropDownSelector dropDownSelector = new JTreeDropDownSelector(tree, false)
					{
						public boolean confirm()
						{
							return true;
						}
						
						public boolean cancel()
						{
							return true;
						}
					};
					dropDownSelector.getDropDownPane().getPopupMenu().setPopupMenuHeight(300);
					
					JBasicDialog dialog = new JBasicDialog(HandleManager.getFrame(DemoDropDownSelectorPanel.this), "Tree PopupMenu DropDown Selector", new Dimension(400, 55), true, true, true);
					dialog.getContentPane().add(dropDownSelector);
					dialog.setVisible(true);
					dialog.dispose();
				}
			}
			);
			add(popupMenuStyleButton);
			
			JBasicButton draggablePopupMenuStyleButton = new JBasicButton("DraggablePopupMenu Style", IconFactory.getSwingIcon("component/tree_16.png"), "DraggablePopupMenu Style");
			draggablePopupMenuStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JBasicTree tree = new JBasicTree();
					JTreeDropDownSelector dropDownSelector = new JTreeDropDownSelector(tree, true)
					{
						public boolean confirm()
						{
							return true;
						}
						
						public boolean cancel()
						{
							return true;
						}
					};
					dropDownSelector.getDropDownPane().getPopupMenu().setPopupMenuHeight(300);
					
					JBasicDialog dialog = new JBasicDialog(HandleManager.getFrame(DemoDropDownSelectorPanel.this), "Tree Draggable PopupMenu DropDown Selector", new Dimension(400, 55), true, true, true);
					dialog.getContentPane().add(dropDownSelector);
					dialog.setVisible(true);
					dialog.dispose();
				}
			}
			);
			add(draggablePopupMenuStyleButton);
			
			ButtonManager.updateUI(this);
		}
	}
	
	public class TableDropDownSelectorPanel
		extends JPanel
	{
		public TableDropDownSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Table DropDown Selector"));
			
			JBasicButton popupMenuStyleButton = new JBasicButton("PopupMenu Style", IconFactory.getSwingIcon("component/table_16.png"), "PopupMenu Style");
			popupMenuStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JBasicTree tree = new JBasicTree();
					JTreeDropDownSelector dropDownSelector = new JTreeDropDownSelector(tree, false)
					{
						public boolean confirm()
						{
							return true;
						}
						
						public boolean cancel()
						{
							return true;
						}
					};
					dropDownSelector.getDropDownPane().getPopupMenu().setPopupMenuHeight(300);
					
					JBasicDialog dialog = new JBasicDialog(HandleManager.getFrame(DemoDropDownSelectorPanel.this), "Table PopupMenu DropDown Selector", new Dimension(400, 55), true, true, true);
					dialog.getContentPane().add(dropDownSelector);
					dialog.setVisible(true);
					dialog.dispose();
				}
			}
			);
			add(popupMenuStyleButton);
			
			JBasicButton draggablePopupMenuStyleButton = new JBasicButton("DraggablePopupMenu Style", IconFactory.getSwingIcon("component/table_16.png"), "DraggablePopupMenu Style");
			draggablePopupMenuStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JBasicTree tree = new JBasicTree();
					JTreeDropDownSelector dropDownSelector = new JTreeDropDownSelector(tree, true)
					{
						public boolean confirm()
						{
							return true;
						}
						
						public boolean cancel()
						{
							return true;
						}
					};
					dropDownSelector.getDropDownPane().getPopupMenu().setPopupMenuHeight(300);
					
					JBasicDialog dialog = new JBasicDialog(HandleManager.getFrame(DemoDropDownSelectorPanel.this), "Table Draggable PopupMenu DropDown Selector", new Dimension(400, 55), true, true, true);
					dialog.getContentPane().add(dropDownSelector);
					dialog.setVisible(true);
					dialog.dispose();
				}
			}
			);
			add(draggablePopupMenuStyleButton);
			
			ButtonManager.updateUI(this);
		}
	}
	
	public class ListDropDownSelectorPanel
		extends JPanel
	{
		public ListDropDownSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("List DropDown Selector"));
			
			JBasicButton popupMenuStyleButton = new JBasicButton("PopupMenu Style", IconFactory.getSwingIcon("component/list_16.png"), "PopupMenu Style");
			popupMenuStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JBasicTree tree = new JBasicTree();
					JTreeDropDownSelector dropDownSelector = new JTreeDropDownSelector(tree, false)
					{
						public boolean confirm()
						{
							return true;
						}
						
						public boolean cancel()
						{
							return true;
						}
					};
					dropDownSelector.getDropDownPane().getPopupMenu().setPopupMenuHeight(300);
					
					JBasicDialog dialog = new JBasicDialog(HandleManager.getFrame(DemoDropDownSelectorPanel.this), "List PopupMenu DropDown Selector", new Dimension(400, 55), true, true, true);
					dialog.getContentPane().add(dropDownSelector);
					dialog.setVisible(true);
					dialog.dispose();
				}
			}
			);
			add(popupMenuStyleButton);
			
			JBasicButton draggablePopupMenuStyleButton = new JBasicButton("DraggablePopupMenu Style", IconFactory.getSwingIcon("component/list_16.png"), "DraggablePopupMenu Style");
			draggablePopupMenuStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JBasicTree tree = new JBasicTree();
					JTreeDropDownSelector dropDownSelector = new JTreeDropDownSelector(tree, true)
					{
						public boolean confirm()
						{
							return true;
						}
						
						public boolean cancel()
						{
							return true;
						}
					};
					dropDownSelector.getDropDownPane().getPopupMenu().setPopupMenuHeight(300);
					
					JBasicDialog dialog = new JBasicDialog(HandleManager.getFrame(DemoDropDownSelectorPanel.this), "List Draggable PopupMenu DropDown Selector", new Dimension(400, 55), true, true, true);
					dialog.getContentPane().add(dropDownSelector);
					dialog.setVisible(true);
					dialog.dispose();
				}
			}
			);
			add(draggablePopupMenuStyleButton);
			
			ButtonManager.updateUI(this);
		}
	}
}