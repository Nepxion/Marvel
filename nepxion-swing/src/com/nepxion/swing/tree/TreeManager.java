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

import java.util.Enumeration;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import com.nepxion.swing.element.ElementNode;

public class TreeManager
{
	public static void setPreferenceStyle(JTree tree)
	{
		tree.putClientProperty("JTree.lineStyle", "Angled");
	}
	
	public static void scrollToVisible(JTree tree, TreeNode treeNode)
	{
		TreePath treePath = TreeManager.getTreePath(treeNode);
		tree.scrollPathToVisible(treePath);
	}
	
	public static int getSelectionMode(JTree tree)
	{
		return tree.getSelectionModel().getSelectionMode();
	}
	
	public static void setSelectionMode(JTree tree, int mode)
	{
		tree.getSelectionModel().setSelectionMode(mode);
	}
	
	public static TreeNode getSelectionTreeNode(JTree tree)
	{
		TreePath treePath = tree.getSelectionPath();
		
		return getTreeNode(treePath);
	}
	
	public static void setSelectionTreeNode(JTree tree, TreeNode treeNode)
	{
		TreePath treePath = getTreePath(treeNode);
		setSelectionTreeNode(tree, treePath);
	}
	
	public static void setSelectionTreeNode(JTree tree, TreePath treePath)
	{
		tree.setSelectionPath(treePath);
	}
	
	public static void addSelectionTreeNode(JTree tree, TreeNode treeNode)
	{
		TreePath treePath = getTreePath(treeNode);
		addSelectionTreeNode(tree, treePath);
	}
	
	public static void addSelectionTreeNode(JTree tree, TreePath treePath)
	{
		tree.addSelectionPath(treePath);
	}
	
	public static TreeNode[] getSelectionTreeNodes(JTree tree)
	{
		TreePath[] treePaths = tree.getSelectionPaths();
		if (treePaths == null)
		{
			return null;
		}
		
		TreeNode[] treeNodes = new TreeNode[treePaths.length];
		for (int i = 0; i < treePaths.length; i++)
		{
			treeNodes[i] = getTreeNode(treePaths[i]);
		}
		
		return treeNodes;
	}
	
	public static void addSelectionTreeNodes(JTree tree, TreeNode[] treeNodes)
	{
		for (int i = 0; i < treeNodes.length; i++)
		{
			TreeNode treeNode = treeNodes[i];
			addSelectionTreeNode(tree, treeNode);
		}
	}
	
	public static void addSelectionTreeNodes(JTree tree, TreePath[] treePaths)
	{
		for (int i = 0; i < treePaths.length; i++)
		{
			TreePath treePath = treePaths[i];
			addSelectionTreeNode(tree, treePath);
		}
	}
	
	public static int getTreeNodePathCount(TreeNode treeNode)
	{
		TreePath treePath = getTreePath(treeNode);
		
		return getTreeNodePathCount(treePath);
	}
	
	public static int getTreeNodePathCount(TreePath treePath)
	{
		int pathCount = treePath.getPathCount();
		
		return pathCount;
	}
	
	public static TreeNode getTreeNode(TreePath treePath)
	{
		if (treePath == null)
		{
			return null;
		}
		
		Object component = treePath.getLastPathComponent();
		if (component == null)
		{
			return null;
		}
		
		return (TreeNode) component;
	}
	
	public static TreePath getTreePath(TreeNode treeNode)
	{
		TreeNode[] treeNodes = getTreeNodes(treeNode, 0);
		
		return new TreePath(treeNodes);
	}
		
	public static TreeNode[] getTreeNodes(TreeNode treeNode, int depth)
	{
		TreeNode[] treeNodes;
		
		if (treeNode == null)
		{
			if (depth == 0)
			{
				return null;
			}
			else
			{
				treeNodes = new TreeNode[depth];
			}
		}
		else
		{
			depth++;
			treeNodes = getTreeNodes(treeNode.getParent(), depth);
			treeNodes[treeNodes.length - depth] = treeNode;
		}
		
		return treeNodes;
	}
	
	public static TreeNode[] getTreeNodes(TreePath[] treePaths)
	{
		TreeNode[] treeNodes = new TreeNode[treePaths.length];
		for (int i = 0; i < treePaths.length; i++)
		{
			treeNodes[i] = getTreeNode(treePaths[i]);
		}
		
		return treeNodes;
	}
	
	public static TreePath[] getTreePaths(TreeNode[] treeNodes)
	{
		TreePath[] treePaths = new TreePath[treeNodes.length];
		
		for (int i = 0; i < treeNodes.length; i++)
		{
			treePaths[i] = getTreePath(treeNodes[i]);
		}	
		
		return treePaths;
	}
	
	public static TreeNode getChildTreeNode(TreeNode treeNode, String childTreeNodeName)
	{
		for (int i = 0; i < treeNode.getChildCount(); i++)
		{
			TreeNode childTreeNode = treeNode.getChildAt(i);
			if (childTreeNode.toString().equals(childTreeNodeName))
			{
				return childTreeNode;
			}
		}
		
		return null;
	}
	
	public static TreeNode[] getChildTreeNodes(TreeNode treeNode)
	{
		TreeNode[] treeNodes = new TreeNode[treeNode.getChildCount()];
		for (int i = 0; i < treeNode.getChildCount(); i++)
		{
			treeNodes[i] = treeNode.getChildAt(i);
		}
		
		return treeNodes;
	}
	
	public static int getChildTreeNodeIndex(TreeNode treeNode, TreeNode childTreeNode)
	{
		if (treeNode == null)
		{
			return -1;
		}	
		for (int i = 0; i < treeNode.getChildCount(); i++)
		{
			if (treeNode.getChildAt(i) == childTreeNode)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public static boolean isAncestorTreeNode(TreeNode ancestorTreeNode, TreeNode treeNode)
	{		
		if (ancestorTreeNode == null || treeNode == null)
		{
			return false;
		}	
		
		TreeNode parentTreeNode = treeNode.getParent();
		if (parentTreeNode != null && parentTreeNode == ancestorTreeNode)
		{
			return true;
		}
		
		return isAncestorTreeNode(ancestorTreeNode, parentTreeNode);
	}
	
	public static void recursionTreeNodes(TreeNode treeNode, String treeNodeName, List treeNodes)
	{
		for (int i = 0; i < treeNode.getChildCount(); i++)
		{
			TreeNode childTreeNode = treeNode.getChildAt(i);
			if (childTreeNode.toString().equals(treeNodeName))
			{
				treeNodes.add(childTreeNode);
			}
			else
			{
				recursionTreeNodes(childTreeNode, treeNodeName, treeNodes);
			}
		}
	}
	
	public static void addTreeNode(JTree tree, DefaultMutableTreeNode treeNode, DefaultMutableTreeNode childTreeNode)
	{
		treeNode.add(childTreeNode);
		
		update(tree, treeNode);
		expand(tree, treeNode);
		setSelectionTreeNode(tree, childTreeNode);
	}
	
	public static void deleteTreeNode(JTree tree, DefaultMutableTreeNode treeNode)
	{
		DefaultMutableTreeNode parentTreeNode = (DefaultMutableTreeNode) treeNode.getParent();
		DefaultMutableTreeNode selectedTreeNode = null;
		if (treeNode.getNextNode() != null && treeNode.getNextNode().getParent() == parentTreeNode)
		{
			selectedTreeNode = treeNode.getNextNode();
		}
		else
		{
			try
			{
				selectedTreeNode = treeNode.getPreviousNode();
			}
			catch (Exception e)
			{
				selectedTreeNode = (DefaultMutableTreeNode) treeNode.getParent();
			}
		}
		treeNode.removeFromParent();
		
		update(tree, parentTreeNode);
		if (selectedTreeNode != null)
		{
			setSelectionTreeNode(tree, selectedTreeNode);
		}
	}
	
	public static void deleteTreeNodes(JTree tree, TreeNode[] treeNodes)
	{
		for (int i = 0; i < treeNodes.length; i++)
		{
			DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) treeNodes[i];
			DefaultMutableTreeNode parentTreeNode = (DefaultMutableTreeNode) treeNode.getParent();
			treeNode.removeFromParent();
			
			update(tree, parentTreeNode);
		}
	}
	
	public static void moveUpTreeNode(JTree tree, DefaultMutableTreeNode treeNode)
	{
		DefaultMutableTreeNode parentTreeNode = (DefaultMutableTreeNode) treeNode.getParent();
		int index = getChildTreeNodeIndex(parentTreeNode, treeNode);
		if (index > 0)
		{
			parentTreeNode.insert(treeNode, index - 1);
			
			update(tree, parentTreeNode);
			expand(tree, parentTreeNode);
			setSelectionTreeNode(tree, treeNode);
		}
	}
	
	public static void moveDownTreeNode(JTree tree, DefaultMutableTreeNode treeNode)
	{
		DefaultMutableTreeNode parentTreeNode = (DefaultMutableTreeNode) treeNode.getParent();
		int index = getChildTreeNodeIndex(parentTreeNode, treeNode);
		if (index < parentTreeNode.getChildCount() - 1)
		{
			parentTreeNode.insert(treeNode, index + 1);
			
			update(tree, parentTreeNode);
			expand(tree, parentTreeNode);
			setSelectionTreeNode(tree, treeNode);
		}
	}
	
	public static void expand(JTree tree, TreeNode treeNode)
	{
		TreePath treePath = getTreePath(treeNode);
		expand(tree, treePath);
	}
	
	public static void expand(JTree tree, TreePath treePath)
	{
		tree.expandPath(treePath);
		tree.scrollPathToVisible(treePath);
	}
	
	public static void expand(JTree tree, TreeNode[] treeNodes)
	{
		for (int i = 0; i < treeNodes.length; i++)
		{
			TreeNode treeNode = treeNodes[i];
			expand(tree, treeNode);
		}
	}
	
	public static void expand(JTree tree, TreePath[] treePaths)
	{
		for (int i = 0; i < treePaths.length; i++)
		{
			TreePath treePath = treePaths[i];
			expand(tree, treePath);
		}
	}
	
	public static void expandChildren(JTree tree, TreeNode treeNode)
	{
		TreePath treePath = getTreePath(treeNode);
		expandChildren(tree, treePath);
	}
	
	public static void expandChildren(JTree tree, TreePath treePath)
	{
		TreeNode treeNode = getTreeNode(treePath);
		for (Enumeration enumeration = treeNode.children(); enumeration.hasMoreElements();)
		{
			TreeNode childTreeNode = (TreeNode) enumeration.nextElement();
			TreePath childTreePath = treePath.pathByAddingChild(childTreeNode);
			expand(tree, childTreePath);
		}
		expand(tree, treePath);
	}
	
	public static void expandChildren(JTree tree, TreeNode[] treeNodes)
	{
		for (int i = 0; i < treeNodes.length; i++)
		{
			TreeNode treeNode = treeNodes[i];
			expandChildren(tree, treeNode);
		}
	}
	
	public static void expandChildren(JTree tree, TreePath[] treePaths)
	{
		for (int i = 0; i < treePaths.length; i++)
		{
			TreePath treePath = treePaths[i];
			expandChildren(tree, treePath);
		}
	}
	
	public static void expandAll(JTree tree)
	{
		TreeNode root = (TreeNode) tree.getModel().getRoot();
		expandAll(tree, new TreePath(root));
	}
	
	public static void expandAll(JTree tree, TreeNode treeNode)
	{
		expandAll(tree, new TreePath(treeNode));
	}
	
	public static void expandAll(JTree tree, TreePath treePath)
	{
		TreeNode treeNode = getTreeNode(treePath);
		for (Enumeration enumeration = treeNode.children(); enumeration.hasMoreElements();)
		{
			TreeNode childTreeNode = (TreeNode) enumeration.nextElement();
			TreePath childTreePath = treePath.pathByAddingChild(childTreeNode);
			expandAll(tree, childTreePath);
		}
		expand(tree, treePath);
	}
	
	public static void collapse(JTree tree, TreeNode treeNode)
	{
		TreePath treePath = getTreePath(treeNode);
		collapse(tree, treePath);
	}
	
	public static void collapse(JTree tree, TreePath treePath)
	{
		tree.collapsePath(treePath);
		tree.scrollPathToVisible(treePath);
	}
	
	public static void collapse(JTree tree, TreeNode[] treeNodes)
	{
		for (int i = 0; i < treeNodes.length; i++)
		{
			TreeNode treeNode = treeNodes[i];
			collapse(tree, treeNode);
		}
	}
	
	public static void collapse(JTree tree, TreePath[] treePaths)
	{
		for (int i = 0; i < treePaths.length; i++)
		{
			TreePath treePath = treePaths[i];
			collapse(tree, treePath);
		}
	}
	
	public static void collapseChildren(JTree tree, TreeNode treeNode)
	{
		TreePath treePath = getTreePath(treeNode);
		collapseChildren(tree, treePath);
	}
	
	public static void collapseChildren(JTree tree, TreePath treePath)
	{
		TreeNode treeNode = getTreeNode(treePath);
		for (Enumeration enumeration = treeNode.children(); enumeration.hasMoreElements();)
		{
			TreeNode childTreeNode = (TreeNode) enumeration.nextElement();
			TreePath childTreePath = treePath.pathByAddingChild(childTreeNode);
			collapse(tree, childTreePath);
		}
		// collapse(tree, treePath);
	}
	
	public static void collapseChildren(JTree tree, TreeNode[] treeNodes)
	{
		for (int i = 0; i < treeNodes.length; i++)
		{
			TreeNode treeNode = treeNodes[i];
			collapseChildren(tree, treeNode);
		}
	}
	
	public static void collapseChildren(JTree tree, TreePath[] treePaths)
	{
		for (int i = 0; i < treePaths.length; i++)
		{
			TreePath treePath = treePaths[i];
			collapseChildren(tree, treePath);
		}
	}
	
	public static void collapseAll(JTree tree)
	{
		TreeNode root = (TreeNode) tree.getModel().getRoot();
		collapseAll(tree, new TreePath(root));
	}
	
	public static void collapseAll(JTree tree, TreeNode treeNode)
	{
		collapseAll(tree, new TreePath(treeNode));
	}
	
	public static void collapseAll(JTree tree, TreePath treePath)
	{
		TreeNode treeNode = getTreeNode(treePath);
		for (Enumeration enumeration = treeNode.children(); enumeration.hasMoreElements();)
		{
			TreeNode childTreeNode = (TreeNode) enumeration.nextElement();
			TreePath childTreePath = treePath.pathByAddingChild(childTreeNode);
			collapseAll(tree, childTreePath);
		}
		collapse(tree, treePath);
	}
	
	public static void update(JTree tree, TreeNode treeNode)
	{
		DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
		treeModel.nodeStructureChanged(treeNode);
	}
	
	public static void setIndex(JTree tree, ElementNode treeNode, int index)
	{
		treeNode.setIndex(index);
		update(tree, treeNode);
	}
	
	public static void setText(JTree tree, ElementNode treeNode, String text)
	{
		treeNode.setText(text);
		update(tree, treeNode);
	}
	
	public static void setIcon(JTree tree, ElementNode treeNode, Icon icon)
	{
		treeNode.setIcon(icon);
		update(tree, treeNode);
	}
	
	public static void setToolTipText(JTree tree, ElementNode treeNode, String toolTipText)
	{
		treeNode.setToolTipText(toolTipText);
		update(tree, treeNode);
	}
	
	public static void setAnimation(JTree tree, ElementNode treeNode, boolean animation)
	{
		treeNode.setAnimation(animation);
		update(tree, treeNode);
	}
	
	public static void setUserObject(JTree tree, ElementNode treeNode, Object userObject)
	{
		treeNode.setUserObject(userObject);
		update(tree, treeNode);
	}
}