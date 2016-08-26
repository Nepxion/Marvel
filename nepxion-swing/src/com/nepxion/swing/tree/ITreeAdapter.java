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

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public interface ITreeAdapter
{
	public boolean addTreeNodePermitted(DefaultMutableTreeNode parentTreeNode);
	
	public DefaultMutableTreeNode addTreeNode(DefaultMutableTreeNode parentTreeNode);
	
	
	public boolean modifyTreeNodePermitted(DefaultMutableTreeNode treeNode);
	
	public Object modifyTreeNode(DefaultMutableTreeNode treeNode);
	
	
	public boolean deleteTreeNodePermitted(DefaultMutableTreeNode treeNode);
	
	public boolean deleteTreeNode(DefaultMutableTreeNode treeNode);
	
	
	public boolean deleteTreeNodesPermitted(TreeNode[] treeNodes);
	
	public boolean deleteTreeNodes(TreeNode[] treeNodes);
	
	
	public boolean renameTreeNodePermitted(DefaultMutableTreeNode treeNode);
	
	public boolean renameTreeNode(DefaultMutableTreeNode treeNode, String text);
	
	
	public boolean moveUpTreeNodePermitted(DefaultMutableTreeNode treeNode);
	
	public boolean moveUpTreeNode(DefaultMutableTreeNode treeNode);
	
	
	public boolean moveDownTreeNodePermitted(DefaultMutableTreeNode treeNode);
	
	public boolean moveDownTreeNode(DefaultMutableTreeNode treeNode);
}