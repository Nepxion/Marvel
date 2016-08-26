package com.nepxion.swing.selector.dropdown.component;

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

import javax.swing.JTree;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menuitem.JBasicCheckBoxMenuItem;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.selector.dropdown.IDropDownPopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownDraggablePopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownPane;
import com.nepxion.swing.selector.dropdown.JDropDownPopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownSelector;
import com.nepxion.swing.textcomponent.TextPopupMenuAdapter;

public abstract class JTreeDropDownSelector
	extends JDropDownSelector
{
	private JTree tree;
	
	private TreeNode treeNode;
	
	private String text;
	private String delimiter = "||";
	
	private JBasicCheckBoxMenuItem showRootMenuItem;
	private JBasicCheckBoxMenuItem showPathMenuItem;
	
	public JTreeDropDownSelector(JTree tree)
	{
		this(tree, true);
	}
	
	public JTreeDropDownSelector(JTree tree, boolean isDraggablePopupMenu)
	{
		this.tree = tree;
		this.tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		IDropDownPopupMenu dropDownPopupMenu = null;
		if (isDraggablePopupMenu)
		{
			dropDownPopupMenu = new JDropDownDraggablePopupMenu();
		}
		else
		{
			dropDownPopupMenu = new JDropDownPopupMenu();
		}
		DropDownPane dropDownPane = new DropDownPane(dropDownPopupMenu, tree);
		setDropDownPane(dropDownPane);
		
		TextPopupMenuAdapter popupMenuAdapter = getTextField().getPopupMenuAdapter();
		JBasicPopupMenu popoupMenu = popupMenuAdapter.getPopupMenu();
		
		popoupMenu.addSeparator();
		
		showRootMenuItem = new JBasicCheckBoxMenuItem(SwingLocale.getString("show_tree_root"), SwingLocale.getString("show_tree_root"), true);
		showRootMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				adaptText();
			}
		}
		);
		popoupMenu.add(showRootMenuItem);
		
		showPathMenuItem = new JBasicCheckBoxMenuItem(SwingLocale.getString("show_tree_path"), SwingLocale.getString("show_tree_path"), true);
		showPathMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				adaptText();
			}
		}
		);
		popoupMenu.add(showPathMenuItem);
	}
	
	public class DropDownPane
		extends JDropDownPane
	{
		public DropDownPane(IDropDownPopupMenu popupMenu, JTree tree)
		{
			super(popupMenu, new JBasicScrollPane(tree));
		}
		
		public boolean confirm()
		{
			return JTreeDropDownSelector.this.doConfirm();
		}
		
		public boolean cancel()
		{
			return JTreeDropDownSelector.this.doCancel();
		}
	}
	
	private void recursion(TreeNode treeNode)
	{
		if (treeNode == null)
		{
			text = null;
			
			return;
		}
		
		TreeNode parentTreeNode = treeNode.getParent();
		if (parentTreeNode != null)
		{
			if (showRootMenuItem.isSelected())
			{
				text = parentTreeNode.toString() + " " + delimiter + " " + text;
				recursion(parentTreeNode);
			}
			else
			{
				if (parentTreeNode != tree.getModel().getRoot())
				{
					text = parentTreeNode.toString() + " " + delimiter + " " + text;
					recursion(parentTreeNode);
				}
			}
		}
	}
	
	public JTree getTree()
	{
		return tree;
	}
	
	public TreeNode getSelectedTreeNode()
	{
		return treeNode;
	}
	
	public String getDelimiter()
	{
		return delimiter;
	}
	
	public void setDelimiter(String delimiter)
	{
		this.delimiter = delimiter;
	}
	
	public boolean isShowRoot()
	{
		return showRootMenuItem.isSelected();
	}
	
	public void setShowRoot(boolean isShowRoot)
	{
		showRootMenuItem.setSelected(isShowRoot);
	}
	
	public boolean isShowPath()
	{
		return showPathMenuItem.isSelected();
	}
	
	public void setShowPath(boolean isShowPath)
	{
		showPathMenuItem.setSelected(isShowPath);
	}
	
	public boolean doConfirm()
	{
		TreePath treePath = tree.getSelectionPath();
		if (treePath == null)
		{
			return false;
		}
		
		Object selectedComponent = treePath.getLastPathComponent();
		if (selectedComponent == null)
		{
			return false;
		}
		
		/*if (treeNode == selectedComponent)
		{
			return true;
		}*/	
		
		boolean returnValue = confirm();
		if (returnValue)
		{
			treeNode = (TreeNode) selectedComponent;

			adaptText();
		}
		
		return returnValue;
	}
	
	private void adaptText()
	{
		text = (treeNode != null ? treeNode.toString() : null);
		
		if (showPathMenuItem.isSelected())
		{
			recursion(treeNode);
		}
		if (text != null)
		{
			getTextField().setText(text);
		}
	}
	
	public boolean doCancel()
	{		
		return cancel();
	}
	
	/**
	 * Returns true if it is confirmed.
	 * @return true if it is confirmed
	 */
	public abstract boolean confirm();
	
	/**
	 * Returns true if it is cancelled.
	 * @return true if it is cancelled.
	 */
	public abstract boolean cancel();
}