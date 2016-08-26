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

import javax.swing.JTree;
import javax.swing.tree.TreeNode;

public class TreeNavigator
{
	private JTree tree;
	
	private String url;
	private String delimiter = "||";
	
	private boolean rootInclusive = true;
	
	public TreeNavigator(JTree tree)
	{
		this.tree = tree;
	}
	
	public String getDelimiter()
	{
		return delimiter;
	}
	
	public void setDelimiter(String delimiter)
	{
		this.delimiter = delimiter;
	}
	
	public boolean isRootInclusive()
	{
		return rootInclusive;
	}
	
	public void setRootInclusive(boolean rootInclusive)
	{
		this.rootInclusive = rootInclusive;
	}
	
	public String getURL(TreeNode treeNode)
	{
		url = treeNode.toString();
		recursion(treeNode);
		
		return url;
	}
	
	private void recursion(TreeNode treeNode)
	{
		if (treeNode == null)
		{
			return;
		}
		
		TreeNode parentTreeNode = treeNode.getParent();
		if (parentTreeNode != null)
		{
			if (rootInclusive)
			{
				url = parentTreeNode.toString() + " " + delimiter + " " + url;
				recursion(parentTreeNode);
			}
			else
			{
				if (parentTreeNode != tree.getModel().getRoot())
				{
					url = parentTreeNode.toString() + " " + delimiter + " " + url;
					recursion(parentTreeNode);
				}
			}
		}
	}
}