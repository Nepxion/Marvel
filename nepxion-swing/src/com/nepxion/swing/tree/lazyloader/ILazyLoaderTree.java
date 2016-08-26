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
import javax.swing.tree.TreePath;

import com.nepxion.swing.tree.ITree;

public interface ILazyLoaderTree
	extends ITree
{
	public void refresh(TreeNode treeNode);
	
	public void refresh(TreePath treePath);
	
	public void search(TreePath treePath);
	
	public void search(TreeNode treeNode);
	
	public void load(TreeNode treeNode);
	
	public void load(TreePath treePath);
	
	public void load(TreeNode[] treeNodes);
	
	public void load(TreePath[] treePaths);
	
	public void loadGrandchildren(TreeNode treeNode);
	
	public void loadGrandchildren(TreePath treePath);
	
	public void loadGrandchildren(TreeNode[] treeNodes);
	
	public void loadGrandchildren(TreePath[] treePaths);
	
	public void loadAll();
	
	public void loadAll(TreeNode treeNode);
	
	public void loadAll(TreePath treePath);
	
	public void cancel(TreeNode treeNode);
	
	public void cancel(TreePath treePath);
	
	public void cancel(TreeNode[] treeNodes);
	
	public void cancel(TreePath[] treePaths);
	
	public void cancelGrandchildren(TreeNode treeNode);
	
	public void cancelGrandchildren(TreePath treePath);
	
	public void cancelGrandchildren(TreeNode[] treeNodes);
	
	public void cancelGrandchildren(TreePath[] treePaths);
	
	public void cancelAll();
	
	public void cancelAll(TreeNode treeNode);
	
	public void cancelAll(TreePath treePath);
	
	public ILazyLoader getLazyLoader();
	
	public void setLazyLoader(ILazyLoader lazyLoader);
	
	public ILazyLoaderContainer getLazyLoaderContainer();
	
	public void setLazyLoaderContainer(ILazyLoaderContainer lazyLoaderContainer);
	
	public Object getLazyLoaderLock();
}