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

import java.util.Enumeration;

import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import com.nepxion.swing.tree.TreeManager;

public class LazyLoaderTreeManager
	extends TreeManager
{
	public static void load(ILazyLoaderTree lazyLoaderTree, TreeNode treeNode)
	{
		ILazyLoader lazyLoader = lazyLoaderTree.getLazyLoader();
		if (lazyLoader == null)
		{
			throw new IllegalArgumentException("LazyLoader can't be null");
		}
		
		if (treeNode == null || !(treeNode instanceof JLazyLoaderTreeNode))
		{
			return;
		}
		
		JLazyLoaderTreeNode lazyLoaderTreeNode = (JLazyLoaderTreeNode) treeNode;
		if (lazyLoader.isLoaded(lazyLoaderTreeNode) || lazyLoader.isLoading(lazyLoaderTreeNode) || lazyLoaderTreeNode.isLeaf())
		{
			return;
		}
		
		LazyLoaderSwingWorker lazyLoaderSwingWorker = new LazyLoaderSwingWorker(lazyLoaderTree, lazyLoaderTreeNode);
		lazyLoaderSwingWorker.execute();
	}
	
	public static void load(ILazyLoaderTree lazyLoaderTree, TreePath treePath)
	{
		TreeNode treeNode = lazyLoaderTree.getTreeNode(treePath);
		load(lazyLoaderTree, treeNode);
	}
	
	public static void load(ILazyLoaderTree lazyLoaderTree, TreeNode[] treeNodes)
	{
		for (int i = 0; i < treeNodes.length; i++)
		{
			TreeNode treeNode = treeNodes[i];
			load(lazyLoaderTree, treeNode);
		}
	}
	
	public static void load(ILazyLoaderTree lazyLoaderTree, TreePath[] treePaths)
	{
		for (int i = 0; i < treePaths.length; i++)
		{
			TreePath treePath = treePaths[i];
			load(lazyLoaderTree, treePath);
		}
	}
	
	public static void loadGrandchildren(ILazyLoaderTree lazyLoaderTree, TreeNode treeNode)
	{
		for (Enumeration enumeration = treeNode.children(); enumeration.hasMoreElements();)
		{
			TreeNode childTreeNode = (TreeNode) enumeration.nextElement();
			load(lazyLoaderTree, childTreeNode);
		}
		load(lazyLoaderTree, treeNode);
	}
	
	public static void loadGrandchildren(ILazyLoaderTree lazyLoaderTree, TreePath treePath)
	{
		TreeNode treeNode = lazyLoaderTree.getTreeNode(treePath);
		loadGrandchildren(lazyLoaderTree, treeNode);
	}
	
	public static void loadGrandchildren(ILazyLoaderTree lazyLoaderTree, TreeNode[] treeNodes)
	{
		for (int i = 0; i < treeNodes.length; i++)
		{
			TreeNode treeNode = treeNodes[i];
			loadGrandchildren(lazyLoaderTree, treeNode);
		}
	}
	
	public static void loadGrandchildren(ILazyLoaderTree lazyLoaderTree, TreePath[] treePaths)
	{
		for (int i = 0; i < treePaths.length; i++)
		{
			TreePath treePath = treePaths[i];
			loadGrandchildren(lazyLoaderTree, treePath);
		}
	}
	
	public static void loadAll(ILazyLoaderTree lazyLoaderTree)
	{
		TreeNode root = (TreeNode) lazyLoaderTree.getModel().getRoot();
		loadAll(lazyLoaderTree, root);
	}
	
	public static void loadAll(ILazyLoaderTree lazyLoaderTree, TreeNode treeNode)
	{
		for (Enumeration enumeration = treeNode.children(); enumeration.hasMoreElements();)
		{
			TreeNode childTreeNode = (TreeNode) enumeration.nextElement();
			loadAll(lazyLoaderTree, childTreeNode);
		}
		load(lazyLoaderTree, treeNode);
	}
	
	public static void loadAll(ILazyLoaderTree lazyLoaderTree, TreePath treePath)
	{
		TreeNode treeNode = lazyLoaderTree.getTreeNode(treePath);
		loadAll(lazyLoaderTree, treeNode);
	}
	
	public static void cancel(ILazyLoaderTree lazyLoaderTree, TreeNode treeNode)
	{
		for (Enumeration enumeration = treeNode.children(); enumeration.hasMoreElements();)
		{
			TreeNode childTreeNode = (TreeNode) enumeration.nextElement();
			cancel(lazyLoaderTree, childTreeNode);
		}
		
		if (treeNode instanceof LoadingTreeNode)
		{
			LoadingTreeNode loadingTreeNode = (LoadingTreeNode) treeNode;
			if (loadingTreeNode.getSwingWorker() != null)
			{
				loadingTreeNode.getSwingWorker().cancel(true);
			}
		}
	}
	
	public static void cancel(ILazyLoaderTree lazyLoaderTree, TreePath treePath)
	{
		TreeNode treeNode = lazyLoaderTree.getTreeNode(treePath);
		cancel(lazyLoaderTree, treeNode);
	}
	
	public static void cancel(ILazyLoaderTree lazyLoaderTree, TreeNode[] treeNodes)
	{
		for (int i = 0; i < treeNodes.length; i++)
		{
			TreeNode treeNode = treeNodes[i];
			cancel(lazyLoaderTree, treeNode);
		}
	}
	
	public static void cancel(ILazyLoaderTree lazyLoaderTree, TreePath[] treePaths)
	{
		for (int i = 0; i < treePaths.length; i++)
		{
			TreePath treePath = treePaths[i];
			cancel(lazyLoaderTree, treePath);
		}
	}
	
	public static void cancelGrandchildren(ILazyLoaderTree lazyLoaderTree, TreeNode treeNode)
	{
		for (Enumeration enumeration = treeNode.children(); enumeration.hasMoreElements();)
		{
			TreeNode childTreeNode = (TreeNode) enumeration.nextElement();
			cancel(lazyLoaderTree, childTreeNode);
		}
		cancel(lazyLoaderTree, treeNode);
	}
	
	public static void cancelGrandchildren(ILazyLoaderTree lazyLoaderTree, TreePath treePath)
	{
		TreeNode treeNode = lazyLoaderTree.getTreeNode(treePath);
		cancelGrandchildren(lazyLoaderTree, treeNode);
	}
	
	public static void cancelGrandchildren(ILazyLoaderTree lazyLoaderTree, TreeNode[] treeNodes)
	{
		for (int i = 0; i < treeNodes.length; i++)
		{
			TreeNode treeNode = treeNodes[i];
			cancelGrandchildren(lazyLoaderTree, treeNode);
		}
	}
	
	public static void cancelGrandchildren(ILazyLoaderTree lazyLoaderTree, TreePath[] treePaths)
	{
		for (int i = 0; i < treePaths.length; i++)
		{
			TreePath treePath = treePaths[i];
			cancelGrandchildren(lazyLoaderTree, treePath);
		}
	}
	
	public static void cancelAll(ILazyLoaderTree lazyLoaderTree)
	{
		TreeNode root = (TreeNode) lazyLoaderTree.getModel().getRoot();
		cancel(lazyLoaderTree, root);
	}
	
	public static void cancelAll(ILazyLoaderTree lazyLoaderTree, TreeNode treeNode)
	{
		for (Enumeration enumeration = treeNode.children(); enumeration.hasMoreElements();)
		{
			TreeNode childTreeNode = (TreeNode) enumeration.nextElement();
			cancelAll(lazyLoaderTree, childTreeNode);
		}
		cancelAll(lazyLoaderTree, treeNode);
	}
	
	public static void cancelAll(ILazyLoaderTree lazyLoaderTree, TreePath treePath)
	{
		TreeNode treeNode = lazyLoaderTree.getTreeNode(treePath);
		cancelAll(lazyLoaderTree, treeNode);
	}
	
	public static void refresh(ILazyLoaderTree lazyLoaderTree, TreeNode treeNode)
	{
		ILazyLoader lazyLoader = lazyLoaderTree.getLazyLoader();
		if (lazyLoader == null)
		{
			throw new IllegalArgumentException("LazyLoader can't be null");
		}
		
		if (treeNode == null || !(treeNode instanceof JLazyLoaderTreeNode))
		{
			return;
		}
		
		JLazyLoaderTreeNode lazyLoaderTreeNode = (JLazyLoaderTreeNode) treeNode;
		if (lazyLoader.isLoading(lazyLoaderTreeNode))
		{
			return;
		}
		
		if (lazyLoaderTreeNode.getChildCount() > 0)
		{
			lazyLoaderTreeNode.removeAllChildren();
		}
		lazyLoaderTreeNode.setLoaded(false);
		lazyLoaderTreeNode.setLeaf(false);
		
		LazyLoaderSwingWorker lazyLoaderSwingWorker = new LazyLoaderSwingWorker(lazyLoaderTree, lazyLoaderTreeNode);
		lazyLoaderSwingWorker.execute();
	}
	
	public static void refresh(ILazyLoaderTree lazyLoaderTree, TreePath treePath)
	{
		TreeNode treeNode = lazyLoaderTree.getTreeNode(treePath);
		refresh(lazyLoaderTree, treeNode);
	}
	
	public static void search(ILazyLoaderTree lazyLoaderTree, TreePath treePath)
	{
		TreeNode treeNode = lazyLoaderTree.getTreeNode(treePath);
		search(lazyLoaderTree, treeNode);
	}
	
	public static void search(ILazyLoaderTree lazyLoaderTree, TreeNode treeNode)
	{
		TreePath treePath = lazyLoaderTree.getTreePath(treeNode);
		if (treeNode.getChildCount() > 0)
		{
			lazyLoaderTree.expand(treePath);
			for (Enumeration enumeration = treeNode.children(); enumeration.hasMoreElements();)
			{
				TreeNode childTreeNode = (TreeNode) enumeration.nextElement();
				search(lazyLoaderTree, childTreeNode);
			}
		}
		else
		{
			load(lazyLoaderTree, treeNode);
		}
	}
}