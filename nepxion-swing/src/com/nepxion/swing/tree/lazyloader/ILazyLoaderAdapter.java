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

public interface ILazyLoaderAdapter
{
	public boolean loadPermitted(TreeNode[] treeNodes);
	
	public boolean load(TreeNode[] treeNodes);
	
	public boolean loadGrandchildren(TreeNode[] treeNodes);
	
	public boolean loadAll();
	
	
	public boolean cancelPermitted(TreeNode[] treeNodes);
	
	public boolean cancel(TreeNode[] treeNodes);
	
	public boolean cancelGrandchildren(TreeNode[] treeNodes);
	
	public boolean cancelAll();
	
	
	public boolean refreshPermitted(TreeNode treeNode);
	
	public boolean refresh(TreeNode treeNode);
}