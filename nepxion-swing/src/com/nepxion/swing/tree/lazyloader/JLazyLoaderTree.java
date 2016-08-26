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

import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import com.nepxion.swing.tree.JBasicTree;

public class JLazyLoaderTree
	extends JBasicTree implements ILazyLoaderTree, TreeWillExpandListener
{
	private byte[] lazyLoaderLock = new byte[0];
	
	private ILazyLoader lazyLoader;
	private ILazyLoaderContainer lazyLoaderContainer;
	
	public JLazyLoaderTree()
	{
		addTreeWillExpandListener(this);
	}
	
	public void treeWillExpand(TreeExpansionEvent event)
		throws ExpandVetoException
	{
		load(event.getPath());
	}
	
	public void treeWillCollapse(TreeExpansionEvent event)
		throws ExpandVetoException
	{
		
	}
	
	public void load(TreeNode treeNode)
	{
		LazyLoaderTreeManager.load(this, treeNode);
	}
	
	public void load(TreePath treePath)
	{
		LazyLoaderTreeManager.load(this, treePath);
	}
	
	public void load(TreeNode[] treeNodes)
	{
		LazyLoaderTreeManager.load(this, treeNodes);
	}
	
	public void load(TreePath[] treePaths)
	{
		LazyLoaderTreeManager.load(this, treePaths);
	}
	
	public void loadGrandchildren(TreeNode treeNode)
	{
		LazyLoaderTreeManager.loadGrandchildren(this, treeNode);
	}
	
	public void loadGrandchildren(TreePath treePath)
	{
		LazyLoaderTreeManager.loadGrandchildren(this, treePath);
	}
	
	public void loadGrandchildren(TreeNode[] treeNodes)
	{
		LazyLoaderTreeManager.loadGrandchildren(this, treeNodes);
	}
	
	public void loadGrandchildren(TreePath[] treePaths)
	{
		LazyLoaderTreeManager.loadGrandchildren(this, treePaths);
	}
	
	public void loadAll()
	{
		LazyLoaderTreeManager.loadAll(this);
	}
	
	public void loadAll(TreeNode treeNode)
	{
		LazyLoaderTreeManager.loadAll(this, treeNode);
	}
	
	public void loadAll(TreePath treePath)
	{
		LazyLoaderTreeManager.loadAll(this, treePath);
	}
	
	public void cancel(TreeNode treeNode)
	{
		LazyLoaderTreeManager.cancel(this, treeNode);
	}
	
	public void cancel(TreePath treePath)
	{
		LazyLoaderTreeManager.cancel(this, treePath);
	}
	
	public void cancel(TreeNode[] treeNodes)
	{
		LazyLoaderTreeManager.cancel(this, treeNodes);
	}
	
	public void cancel(TreePath[] treePaths)
	{
		LazyLoaderTreeManager.cancel(this, treePaths);
	}
	
	public void cancelGrandchildren(TreeNode treeNode)
	{
		LazyLoaderTreeManager.cancelGrandchildren(this, treeNode);
	}
	
	public void cancelGrandchildren(TreePath treePath)
	{
		LazyLoaderTreeManager.cancelGrandchildren(this, treePath);
	}
	
	public void cancelGrandchildren(TreeNode[] treeNodes)
	{
		LazyLoaderTreeManager.cancelGrandchildren(this, treeNodes);
	}
	
	public void cancelGrandchildren(TreePath[] treePaths)
	{
		LazyLoaderTreeManager.cancelGrandchildren(this, treePaths);
	}
	
	public void cancelAll()
	{
		LazyLoaderTreeManager.cancelAll(this);
	}
	
	public void cancelAll(TreeNode treeNode)
	{
		LazyLoaderTreeManager.cancelAll(this, treeNode);
	}
	
	public void cancelAll(TreePath treePath)
	{
		LazyLoaderTreeManager.cancelAll(this, treePath);
	}
	
	public void refresh(TreeNode treeNode)
	{
		LazyLoaderTreeManager.refresh(this, treeNode);
	}
	
	public void refresh(TreePath treePath)
	{
		LazyLoaderTreeManager.refresh(this, treePath);
	}
	
	public void search(TreePath treePath)
	{
		LazyLoaderTreeManager.search(this, treePath);
	}
	
	public void search(TreeNode treeNode)
	{
		LazyLoaderTreeManager.search(this, treeNode);
	}
	
	public ILazyLoader getLazyLoader()
	{
		return lazyLoader;
	}
	
	public void setLazyLoader(ILazyLoader lazyLoader)
	{
		this.lazyLoader = lazyLoader;
	}
	
	public ILazyLoaderContainer getLazyLoaderContainer()
	{
		return lazyLoaderContainer;
	}
	
	public void setLazyLoaderContainer(ILazyLoaderContainer lazyLoaderContainer)
	{
		this.lazyLoaderContainer = lazyLoaderContainer;
	}
	
	public Object getLazyLoaderLock()
	{
		return lazyLoaderLock;
	}
}