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

public abstract class AbstractTreeAdapter
	implements ITreeAdapter
{
	/**
	 * Constructs with the default.
	 */
	public AbstractTreeAdapter()
	{
		
	}
	
	public boolean addTreeNodePermitted(DefaultMutableTreeNode parentTreeNode)
	{
		return true;
	}
	
	public DefaultMutableTreeNode addTreeNode(DefaultMutableTreeNode parentTreeNode)
	{
		return null;
	}
	
	
	public boolean modifyTreeNodePermitted(DefaultMutableTreeNode treeNode)
	{
		return true;
	}
	
	public Object modifyTreeNode(DefaultMutableTreeNode treeNode)
	{
		return null;
	}
	
	
	public boolean deleteTreeNodePermitted(DefaultMutableTreeNode treeNode)
	{
		return true;
	}
	
	public boolean deleteTreeNode(DefaultMutableTreeNode treeNode)
	{
		return true;
	}	
	
	
	public boolean deleteTreeNodesPermitted(TreeNode[] treeNodes)
	{
		return true;
	}	
	
	public boolean deleteTreeNodes(TreeNode[] treeNodes)
	{
		return true;
	}	
	
	
	public boolean renameTreeNodePermitted(DefaultMutableTreeNode treeNode)
	{
		return true;
	}	
	
	public boolean renameTreeNode(DefaultMutableTreeNode treeNode, String text)
	{
		return true;
	}	
	
	
	public boolean moveUpTreeNodePermitted(DefaultMutableTreeNode treeNode)
	{
		return true;
	}	
	
	public boolean moveUpTreeNode(DefaultMutableTreeNode treeNode)
	{
		return true;
	}	
	
	
	public boolean moveDownTreeNodePermitted(DefaultMutableTreeNode treeNode)
	{
		return true;
	}	
	
	public boolean moveDownTreeNode(DefaultMutableTreeNode treeNode)
	{
		return true;
	}	
}