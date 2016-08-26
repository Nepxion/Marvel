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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import com.nepxion.swing.menuitem.JBasicCheckBoxMenuItem;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.selector.dropdown.IDropDownPopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownDraggablePopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownPane;
import com.nepxion.swing.selector.dropdown.JDropDownPopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownSelector;

public abstract class JTableDropDownSelector
	extends JDropDownSelector
{
	private JTable table;
	
	private JBasicPopupMenu popupMenu;
	private JBasicCheckBoxMenuItem showPathMenuItem;
	private JBasicCheckBoxMenuItem showRootMenuItem;
	
	private String text;
	
	public JTableDropDownSelector(JTable table)
	{
		this(table, true);
	}
	
	public JTableDropDownSelector(JTable table, boolean isDraggablePopupMenu)
	{
		this.table = table;
		// this.table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_TREE_SELECTION);
		
		IDropDownPopupMenu dropDownPopupMenu = null;
		if (isDraggablePopupMenu)
		{
			dropDownPopupMenu = new JDropDownDraggablePopupMenu();
		}
		else
		{
			dropDownPopupMenu = new JDropDownPopupMenu();
		}
		DropDownPane dropDownPane = new DropDownPane(dropDownPopupMenu, table);
		setDropDownPane(dropDownPane);
		
		// popupMenu = new JInternalPopupMenu();
		// showRootMenuItem = new JBasicCheckBoxMenuItem("显示根节点", "显示根节点",
		// true);
		// showRootMenuItem.addActionListener(new ActionListener()
		// {
		// public void actionPerformed(ActionEvent evt)
		// {
		// adaptText();
		// }
		// }
		// );
		// popupMenu.add(showRootMenuItem);
		//        
		// showPathMenuItem = new JBasicCheckBoxMenuItem("显示节点路径", "显示节点路径",
		// true);
		// showPathMenuItem.addActionListener(new ActionListener()
		// {
		// public void actionPerformed(ActionEvent evt)
		// {
		// adaptText();
		// }
		// }
		// );
		// popupMenu.add(showPathMenuItem);
		
		getTextField().addMouseListener(new TextFieldMouseListener());
	}
	
	public class DropDownPane
		extends JDropDownPane
	{
		public DropDownPane(IDropDownPopupMenu popupMenu, JTable table)
		{
			super(popupMenu, new JBasicScrollPane(table));
		}
		
		public boolean confirm()
		{
			return JTableDropDownSelector.this.doConfirm();
		}
		
		public boolean cancel()
		{
			return JTableDropDownSelector.this.doCancel();
		}
	}
	
	public class TextFieldMouseListener
		extends MouseAdapter
	{
		public void mouseReleased(MouseEvent e)
		{
			if (!e.isPopupTrigger())
			{
				return;
			}
			
			popupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}
	
	public JTable getTable()
	{
		return table;
	}
	
	// public TreeNode getSelectedTreeNode()
	// {
	// return treeNode;
	// }
	
	public boolean doConfirm()
	{
		// TreePath treePath = tree.getSelectionPath();
		// if (treePath == null)
		// {
		// return false;
		// }
		// Object selectedComponent = treePath.getLastPathComponent();
		// if (selectedComponent == null)
		// {
		// return false;
		// }
		// treeNode = (TreeNode) selectedComponent;
		
		boolean returnValue = confirm();
		if (returnValue)
		{
			adaptText();
		}
		
		return returnValue;
	}
	
	private void adaptText()
	{
		// text = (treeNode != null ? treeNode.toString() : null);
		//    	
		// if (showPathMenuItem.isSelected())
		// {
		// recursion(treeNode);
		// }
		// if (text != null)
		// {
		// getTextField().setText(text);
		// }
	}
	
	public boolean doCancel()
	{
		// treeNode = null;
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