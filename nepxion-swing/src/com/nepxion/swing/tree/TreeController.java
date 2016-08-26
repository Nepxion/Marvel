package com.nepxion.swing.tree;

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
import java.awt.event.KeyEvent;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public class TreeController
{
	public static void add(JTree tree, ITreeAdapter treeAdapter)
	{
		boolean isSingleSelection = isSingleSelection(tree, SwingLocale.getString("add") + SwingLocale.getString("node"));
		if (!isSingleSelection)
		{
			return;
		}
		
		DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) TreeManager.getSelectionTreeNode(tree);
		if (!treeAdapter.addTreeNodePermitted(treeNode))
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(tree), SwingLocale.getString("node") + " " + SwingLocale.getString("quotation_left") + treeNode.toString() + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("add_node_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}	
		
		DefaultMutableTreeNode newTreeNode = treeAdapter.addTreeNode(treeNode);
		if (newTreeNode != null)
		{
			TreeManager.addTreeNode(tree, treeNode, newTreeNode);
		}
	}
	
	public static void modify(JTree tree, ITreeAdapter treeAdapter)
	{
		boolean isSingleSelection = isSingleSelection(tree, SwingLocale.getString("modify") + SwingLocale.getString("node"));
		if (!isSingleSelection)
		{
			return;
		}
		
		DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) TreeManager.getSelectionTreeNode(tree);
		
		if (!treeAdapter.modifyTreeNodePermitted(treeNode))
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(tree), SwingLocale.getString("node") + " " + SwingLocale.getString("quotation_left") + treeNode.toString() + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("modify_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		treeAdapter.modifyTreeNode(treeNode);
	}
	
	public static void delete(JTree tree, ITreeAdapter treeAdapter)
	{
		boolean isMultiSelection = isMultiSelection(tree, SwingLocale.getString("delete") + SwingLocale.getString("node"));
		if (!isMultiSelection)
		{
			return;
		}
		
		TreeNode[] treeNodes = TreeManager.getSelectionTreeNodes(tree);
		if (treeNodes.length == 1)
		{
			DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) TreeManager.getSelectionTreeNode(tree);
			if (!treeAdapter.deleteTreeNodePermitted(treeNode))
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame(tree), SwingLocale.getString("node") + " " + SwingLocale.getString("quotation_left") + treeNode.toString() + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("delete_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
				
				return;
			}
			
			int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(tree), SwingLocale.getString("confirm_to_delete_node") + " " + SwingLocale.getString("quotation_left") + treeNode.toString() + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("interrogation"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
			if (selectedValue != JBasicOptionPane.YES_OPTION)
			{
				return;
			}
			
			boolean flag = treeAdapter.deleteTreeNode(treeNode);
			
			if (flag)
			{
				TreeManager.deleteTreeNode(tree, treeNode);
			}
		}
		else
		{
			if (!treeAdapter.deleteTreeNodesPermitted(treeNodes))
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame(tree), SwingLocale.getString("node_selection") + SwingLocale.getString("delete_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
				
				return;
			}
			
			int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(tree), SwingLocale.getString("confirm_to_delete_selected_nodes"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
			if (selectedValue != JBasicOptionPane.YES_OPTION)
			{
				return;
			}
			
			boolean flag = treeAdapter.deleteTreeNodes(treeNodes);
			
			if (flag)
			{
				TreeManager.deleteTreeNodes(tree, treeNodes);
			}
		}
	}
	
	public static void rename(JTree tree, ITreeAdapter treeAdapter)
	{
		boolean isSingleSelection = isSingleSelection(tree, SwingLocale.getString("rename") + SwingLocale.getString("node"));
		if (!isSingleSelection)
		{
			return;
		}
		
		ElementNode treeNode = (ElementNode) TreeManager.getSelectionTreeNode(tree);
		if (!treeAdapter.renameTreeNodePermitted(treeNode))
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(tree), SwingLocale.getString("node") + " " + SwingLocale.getString("quotation_left") + treeNode.toString() + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("rename_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}		
		
		Object selectedValue = JBasicOptionPane.showInputDialog(HandleManager.getFrame(tree), SwingLocale.getString("rename") + SwingLocale.getString("node"), SwingLocale.getString("rename") + SwingLocale.getString("node"), JBasicOptionPane.PLAIN_MESSAGE, IconFactory.getSwingIcon("banner/edit.png"), null, treeNode.toString(), true);
		if (selectedValue == null || selectedValue.toString().trim().equals(""))
		{
			return;
		}
		
		boolean flag = treeAdapter.renameTreeNode(treeNode, selectedValue.toString().trim());
		
		if (flag)
		{
			TreeManager.setText(tree, treeNode, selectedValue.toString().trim());
		}
	}
	
	public static void moveUp(JTree tree, ITreeAdapter treeAdapter)
	{
		boolean isSingleSelection = isSingleSelection(tree, SwingLocale.getString("move_up") + SwingLocale.getString("node"));
		if (!isSingleSelection)
		{
			return;
		}
		
		DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) TreeManager.getSelectionTreeNode(tree);
		
		if (!treeAdapter.moveUpTreeNodePermitted(treeNode))
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(tree), SwingLocale.getString("node") + " " + SwingLocale.getString("quotation_left") + treeNode.toString() + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("move_up_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		boolean flag = treeAdapter.moveUpTreeNode(treeNode);
		
		if (flag)
		{
			TreeManager.moveUpTreeNode(tree, treeNode);
		}
	}
	
	public static void moveDown(JTree tree, ITreeAdapter treeAdapter)
	{
		boolean isSingleSelection = isSingleSelection(tree, SwingLocale.getString("move_down") + SwingLocale.getString("node"));
		if (!isSingleSelection)
		{
			return;
		}
		
		DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) TreeManager.getSelectionTreeNode(tree);
		
		if (!treeAdapter.moveDownTreeNodePermitted(treeNode))
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(tree), SwingLocale.getString("node") + " " + SwingLocale.getString("quotation_left") + treeNode.toString() + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("move_down_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		boolean flag = treeAdapter.moveDownTreeNode(treeNode);
		
		if (flag)
		{
			TreeManager.moveDownTreeNode(tree, treeNode);
		}
	}
	
	public static void expand(JTree tree)
	{
		boolean isMultiSelection = isMultiSelection(tree, SwingLocale.getString("expand") + SwingLocale.getString("children_nodes"));
		if (!isMultiSelection)
		{
			return;
		}
		
		TreePath[] treePaths = tree.getSelectionPaths();
		
		TreeManager.expand(tree, treePaths);
	}
	
	public static void expandGrandchildren(JTree tree)
	{
		boolean isMultiSelection = isMultiSelection(tree, SwingLocale.getString("expand") + SwingLocale.getString("grandchildren_nodes"));
		if (!isMultiSelection)
		{
			return;
		}
		
		TreePath[] treePaths = tree.getSelectionPaths();
		
		TreeManager.expandChildren(tree, treePaths);
	}
	
	public static void expandAll(JTree tree)
	{
		TreeManager.expandAll(tree);
	}
	
	public static void collapse(JTree tree)
	{
		boolean isMultiSelection = isMultiSelection(tree, SwingLocale.getString("collapse") + SwingLocale.getString("children_nodes"));
		if (!isMultiSelection)
		{
			return;
		}
		
		TreePath[] treePaths = tree.getSelectionPaths();
		
		TreeManager.collapse(tree, treePaths);
	}
	
	public static void collapseGrandchildren(JTree tree)
	{
		boolean isMultiSelection = isMultiSelection(tree, SwingLocale.getString("collapse") + SwingLocale.getString("grandchildren_nodes"));
		if (!isMultiSelection)
		{
			return;
		}
		
		TreePath[] treePaths = tree.getSelectionPaths();
		
		TreeManager.collapseChildren(tree, treePaths);
	}
	
	public static void collapseAll(JTree tree)
	{
		TreeManager.collapseAll(tree);
	}
	
	public static boolean isSingleSelection(JTree tree, String operationName)
	{
		TreePath[] treePaths = tree.getSelectionPaths();
		if (treePaths == null)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(tree), SwingLocale.getString("select_nodes_to") + " " + SwingLocale.getString("quotation_left") + operationName + SwingLocale.getString("quotation_right"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		
		if (treePaths.length != 1)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(tree), SwingLocale.getString("select_one_node_to") + " " + SwingLocale.getString("quotation_left") + operationName + SwingLocale.getString("quotation_right"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		
		return true;
	}
	
	public static boolean isMultiSelection(JTree tree, String operationName)
	{
		TreePath[] treePaths = tree.getSelectionPaths();
		if (treePaths == null)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(tree), SwingLocale.getString("select_nodes_to") + " " + SwingLocale.getString("quotation_left") + operationName + SwingLocale.getString("quotation_right"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		
		return true;
	}
	
	public static JSecurityAction getAddAction(final JTree tree, final ITreeAdapter treeAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("add"), IconFactory.getSwingIcon("stereo/add_16.png"), SwingLocale.getString("add") + SwingLocale.getString("node"))
		{
			public void execute(ActionEvent e)
			{
				add(tree, treeAdapter);
			}
		};
		KeyStrokeManager.registerComponent(tree, action, KeyEvent.VK_N, KeyEvent.CTRL_MASK);
		
		return action;
	}
	
	public static JSecurityAction getModifyAction(final JTree tree, final ITreeAdapter treeAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("modify"), IconFactory.getSwingIcon("stereo/confirm_16.png"), SwingLocale.getString("modify") + SwingLocale.getString("node"))
		{
			public void execute(ActionEvent e)
			{
				modify(tree, treeAdapter);
			}
		};
		KeyStrokeManager.registerComponent(tree, action, KeyEvent.VK_I, KeyEvent.CTRL_MASK);
		
		return action;
	}
	
	public static JSecurityAction getDeleteAction(final JTree tree, final ITreeAdapter treeAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("delete"), IconFactory.getSwingIcon("stereo/delete_16.png"), SwingLocale.getString("delete") + SwingLocale.getString("node"))
		{
			public void execute(ActionEvent e)
			{
				delete(tree, treeAdapter);
			}
		};
		KeyStrokeManager.registerComponent(tree, action, KeyEvent.VK_DELETE);
		
		return action;
	}
	
	public static JSecurityAction getRenameAction(final JTree tree, final ITreeAdapter treeAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("rename"), IconFactory.getSwingIcon("stereo/calendar_16.png"), SwingLocale.getString("rename") + SwingLocale.getString("node"))
		{
			public void execute(ActionEvent e)
			{
				rename(tree, treeAdapter);
			}
		};
		KeyStrokeManager.registerComponent(tree, action, KeyEvent.VK_R, KeyEvent.CTRL_MASK);
		
		return action;
	}
	
	public static JSecurityAction getMoveUpAction(final JTree tree, final ITreeAdapter treeAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("move_up"), IconFactory.getSwingIcon("stereo/arrow_up_16.png"), SwingLocale.getString("move_up") + SwingLocale.getString("node"))
		{
			public void execute(ActionEvent e)
			{
				moveUp(tree, treeAdapter);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getMoveDownAction(final JTree tree, final ITreeAdapter treeAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("move_down"), IconFactory.getSwingIcon("stereo/arrow_down_16.png"), SwingLocale.getString("move_down") + SwingLocale.getString("node"))
		{
			public void execute(ActionEvent e)
			{
				moveDown(tree, treeAdapter);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getExpandAction(final JTree tree)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("expand"), IconFactory.getSwingIcon("stereo/arrow_down_16.png"), SwingLocale.getString("expand") + SwingLocale.getString("children_nodes"))
		{
			public void execute(ActionEvent e)
			{
				expand(tree);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getExpandGrandchildrenAction(final JTree tree)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("expand") + SwingLocale.getString("grandchildren_nodes"), IconFactory.getBlankIcon(), SwingLocale.getString("expand") + SwingLocale.getString("grandchildren_nodes"))
		{
			public void execute(ActionEvent e)
			{
				expandGrandchildren(tree);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getExpandAllAction(final JTree tree)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("expand") + SwingLocale.getString("all_nodes"), IconFactory.getBlankIcon(), SwingLocale.getString("expand") + SwingLocale.getString("all_nodes"))
		{
			public void execute(ActionEvent e)
			{
				expandAll(tree);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getCollapseAction(final JTree tree)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("collapse"), IconFactory.getSwingIcon("stereo/arrow_up_16.png"), SwingLocale.getString("collapse") + SwingLocale.getString("children_nodes"))
		{
			public void execute(ActionEvent e)
			{
				collapse(tree);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getCollapseGrandchildrenAction(final JTree tree)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("collapse") + SwingLocale.getString("grandchildren_nodes"), IconFactory.getBlankIcon(), SwingLocale.getString("collapse") + SwingLocale.getString("grandchildren_nodes"))
		{
			public void execute(ActionEvent e)
			{
				collapseGrandchildren(tree);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getCollapseAllAction(final JTree tree)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("collapse") + SwingLocale.getString("all_nodes"), IconFactory.getBlankIcon(), SwingLocale.getString("collapse") + SwingLocale.getString("all_nodes"))
		{
			public void execute(ActionEvent e)
			{
				collapseAll(tree);
			}
		};
		
		return action;
	}
}