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

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public interface ITree
{
	public static final int SINGLE_TREE_SELECTION = TreeSelectionModel.SINGLE_TREE_SELECTION;
	public static final int CONTIGUOUS_TREE_SELECTION = TreeSelectionModel.CONTIGUOUS_TREE_SELECTION;
	public static final int DISCONTIGUOUS_TREE_SELECTION = TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION;
	
	public TreeModel getModel();
	
	public void setModel(TreeModel treeModel);
	
	public void scrollToVisible(TreeNode treeNode);
	
	public int getSelectionMode();
	
	public void setSelectionMode(int mode);
	
	public TreeNode getSelectionTreeNode();
	
	public void setSelectionTreeNode(TreeNode treeNode);
	
	public void setSelectionTreeNode(TreePath treePath);
	
	public void addSelectionTreeNode(TreeNode treeNode);
	
	public void addSelectionTreeNode(TreePath treePath);
	
	public TreeNode[] getSelectionTreeNodes();
	
	public void addSelectionTreeNodes(TreeNode[] treeNodes);
	
	public void addSelectionTreeNodes(TreePath[] treePaths);
	
	public void clearSelection();
	
	public int getTreeNodePathCount(TreeNode treeNode);
	
	public int getTreeNodePathCount(TreePath treePath);
	
	public TreeNode getTreeNode(TreePath treePath);
	
	public TreePath getTreePath(TreeNode treeNode);
	
	public TreeNode[] getTreeNodes(TreeNode treeNode, int depth);
	
	public TreeNode[] getTreeNodes(TreePath[] treePaths);
	
	public TreePath[] getTreePaths(TreeNode[] treeNodes);
	
	public TreeNode getChildTreeNode(TreeNode treeNode, String childTreeNodeName);
	
	public TreeNode[] getChildTreeNodes(TreeNode treeNode);
	
	public int getChildTreeNodeIndex(TreeNode treeNode, TreeNode childTreeNode);
	
	public void recursionTreeNodes(TreeNode treeNode, String treeNodeName, List treeNodes);
	
	public void addTreeNode(DefaultMutableTreeNode treeNode, DefaultMutableTreeNode childTreeNode);
	
	public void deleteTreeNode(DefaultMutableTreeNode treeNode);
	
	public void deleteTreeNodes(DefaultMutableTreeNode[] treeNodes);
	
	public void moveUpTreeNode(DefaultMutableTreeNode treeNode);
	
	public void moveDownTreeNode(DefaultMutableTreeNode treeNode);
	
	public void expand(TreeNode treeNode);
	
	public void expand(TreePath treePath);
	
	public void expand(TreeNode[] treeNodes);
	
	public void expand(TreePath[] treePaths);
	
	public void expandChildren(TreeNode treeNode);
	
	public void expandChildren(TreePath treePath);
	
	public void expandChildren(TreeNode[] treeNodes);
	
	public void expandChildren(TreePath[] treePaths);
	
	public void expandAll();
	
	public void expandAll(TreeNode treeNode);
	
	public void expandAll(TreePath treePath);
	
	public void collapse(TreeNode treeNode);
	
	public void collapse(TreePath treePath);
	
	public void collapse(TreeNode[] treeNodes);
	
	public void collapse(TreePath[] treePaths);
	
	public void collapseChildren(TreeNode treeNode);
	
	public void collapseChildren(TreePath treePath);
	
	public void collapseChildren(TreeNode[] treeNodes);
	
	public void collapseChildren(TreePath[] treePaths);
	
	public void collapseAll();
	
	public void collapseAll(TreeNode treeNode);
	
	public void collapseAll(TreePath treePath);
	
	public void update(TreeNode treeNode);
	
	public void executeSelection(TreeNode oldSelectionTreeNode, TreeNode newSelectionTreeNode);
	
	public void executeClicked(TreeNode treeNode);
	
	public void executeDoubleClicked(TreeNode treeNode);
	
	public void executePopupMenu(TreeNode treeNode, int treePathCount, int x, int y);
	
	public void executePopupMenu(int x, int y);
}