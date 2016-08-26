package com.nepxion.swing.tree.lazyloader;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.tree.TreeNode;

public abstract class AbstractLazyLoaderAdapter
	implements ILazyLoaderAdapter
{
	public AbstractLazyLoaderAdapter()
	{
		
	}
	
	public boolean loadPermitted(TreeNode[] treeNodes)
	{
		return true;
	}
	
	public boolean load(TreeNode[] treeNodes)
	{
		return true;
	}
	
	public boolean loadGrandchildren(TreeNode[] treeNodes)
	{
		return true;
	}	
	
	public boolean loadAll()
	{
		return true;
	}	
	
	
	public boolean cancelPermitted(TreeNode[] treeNodes)
	{
		return true;
	}	
	
	public boolean cancel(TreeNode[] treeNodes)
	{
		return true;
	}	
	
	public boolean cancelGrandchildren(TreeNode[] treeNodes)
	{
		return true;
	}	
	
	public boolean cancelAll()
	{
		return true;
	}	
	
	
	public boolean refreshPermitted(TreeNode treeNode)
	{
		return true;
	}	
	
	public boolean refresh(TreeNode treeNode)
	{
		return true;
	}	
}