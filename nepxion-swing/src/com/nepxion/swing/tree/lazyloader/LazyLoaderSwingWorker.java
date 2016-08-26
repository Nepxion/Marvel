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

import javax.swing.JTree;
import javax.swing.SwingUtilities;

import com.nepxion.swing.exception.ExceptionTracer;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.swingworker.JSwingWorker;

public class LazyLoaderSwingWorker
	extends JSwingWorker
{
	private ILazyLoaderTree lazyLoaderTree;
	private JLazyLoaderTreeNode lazyLoaderTreeNode;
	private LoadingTreeNode loadingTreeNode;
	
	private boolean isRecursive = false;
	private int recursionDepth = -1;
	private int recursionPathCount = -1;
	private SearchDescription searchDescription;
	
	public LazyLoaderSwingWorker(ILazyLoaderTree lazyLoaderTree, JLazyLoaderTreeNode lazyLoaderTreeNode)
	{
		this(lazyLoaderTree, lazyLoaderTreeNode, lazyLoaderTree.getLazyLoader().isRecursive(), lazyLoaderTree.getLazyLoader().getRecursionDepth(), lazyLoaderTree.getTreeNodePathCount(lazyLoaderTreeNode), lazyLoaderTree.getLazyLoader().getSearchDescription());
	}
	
	private LazyLoaderSwingWorker(ILazyLoaderTree lazyLoaderTree, JLazyLoaderTreeNode lazyLoaderTreeNode, boolean isRecursive, int recursionDepth, int recursionPathCount, SearchDescription searchDescription)
	{
		this.lazyLoaderTree = lazyLoaderTree;
		this.lazyLoaderTreeNode = lazyLoaderTreeNode;
		
		this.isRecursive = isRecursive;
		this.recursionDepth = recursionDepth;
		this.recursionPathCount = recursionPathCount;
		this.searchDescription = searchDescription;
		
		setComponent((JTree) lazyLoaderTree);
		
		loadingTreeNode = new LoadingTreeNode(this);
		
		if (lazyLoaderTree.getLazyLoader().isSynchronized())
		{
			loadingTreeNode.setAction(LoadingTreeNode.ACTION_LOADING);
		}
		else
		{
			loadingTreeNode.setAction(LoadingTreeNode.ACTION_QUEUEING);
		}
		lazyLoaderTreeNode.add(loadingTreeNode);
		lazyLoaderTreeNode.setLoading(true);
		
		lazyLoaderTree.update(lazyLoaderTreeNode);
		lazyLoaderTree.expand(lazyLoaderTreeNode);
	}
	
	protected void loadForeground(final Object data)
		throws Exception
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				if (lazyLoaderTreeNode.isNodeChild(loadingTreeNode))
				{	
					lazyLoaderTreeNode.remove(loadingTreeNode);
				}
				
				if (data instanceof Exception)
				{
					return;
				}
				
				try
				{
					lazyLoaderTree.getLazyLoader().loadForeground(data, lazyLoaderTreeNode);
				}
				catch (Exception e)
				{
					fireForegroundException(e);
					
					Exception exception = null;
					if (e.getCause() != null && e.getCause() instanceof Exception)
					{
						exception = (Exception) e.getCause();
					}
					else
					{
						exception = e;
					}
					
					ExceptionTracer.traceException(HandleManager.getFrame(LazyLoaderSwingWorker.this.getComponent()), exception);
					
					return;
				}
				
				lazyLoaderTreeNode.setLoaded(!lazyLoaderTreeNode.isLeaf());
				
				lazyLoaderTree.scrollToVisible(lazyLoaderTreeNode);
				lazyLoaderTree.update(lazyLoaderTreeNode);
				
				recursion();
			}
		}
		);
	}
	
	protected Object loadBackground()
		throws Exception
	{
		if (lazyLoaderTree.getLazyLoader().isSynchronized())
		{
			loadingTreeNode.setAction(LoadingTreeNode.ACTION_LOADING);
			
			return lazyLoaderTree.getLazyLoader().loadBackground(lazyLoaderTreeNode);
		}
		else
		{
			synchronized (lazyLoaderTree.getLazyLoaderLock())
			{
				loadingTreeNode.setAction(LoadingTreeNode.ACTION_LOADING);
				
				return lazyLoaderTree.getLazyLoader().loadBackground(lazyLoaderTreeNode);
			}
		}
	}
	
	private void recursion()
	{
		if (!isRecursive)
		{
			return;
		}
		
		for (Enumeration enumeration = lazyLoaderTreeNode.children(); enumeration.hasMoreElements();)
		{
			Object childTreeNode = enumeration.nextElement();
			if (childTreeNode instanceof JLazyLoaderTreeNode)
			{
				JLazyLoaderTreeNode childLazyLoaderTreeNode = (JLazyLoaderTreeNode) childTreeNode;
				
				if (searchDescription != null)
				{
					String searchText = searchDescription.getSearchText();
					boolean isCaseSensitive = searchDescription.isCaseSensitive();
					boolean isTextMatched = searchDescription.isTextMatched();
					if (searchText != null && !searchText.equals(""))
					{
						String treeNodeName = childLazyLoaderTreeNode.toString();
						if (!isCaseSensitive)
						{
							searchText = searchText.toLowerCase();
							treeNodeName = treeNodeName.toLowerCase();
						}
						if (isTextMatched)
						{
							if (treeNodeName.equals(searchText))
							{
								lazyLoaderTree.addSelectionTreeNode(childLazyLoaderTreeNode);
								searchDescription.getResult().add(childLazyLoaderTreeNode);
							}
						}
						else
						{
							if (treeNodeName.indexOf(searchText) > -1)
							{
								lazyLoaderTree.addSelectionTreeNode(childLazyLoaderTreeNode);
								searchDescription.getResult().add(childLazyLoaderTreeNode);
							}
						}
					}
				}
				if (recursionDepth < 0)
				{
					if (!lazyLoaderTree.getLazyLoader().isLoaded(childLazyLoaderTreeNode) && !lazyLoaderTree.getLazyLoader().isLoading(childLazyLoaderTreeNode) && !childLazyLoaderTreeNode.isLeaf())
					{
						LazyLoaderSwingWorker lazyLoaderSwingWorker = new LazyLoaderSwingWorker(lazyLoaderTree, childLazyLoaderTreeNode, isRecursive, recursionDepth, recursionPathCount, searchDescription);
						lazyLoaderSwingWorker.execute();
					}
				}
				else
				{
					int pathCount = lazyLoaderTree.getTreeNodePathCount(lazyLoaderTreeNode);
					if (pathCount - recursionPathCount < recursionDepth - 1 && !lazyLoaderTree.getLazyLoader().isLoaded(childLazyLoaderTreeNode) && !lazyLoaderTree.getLazyLoader().isLoading(childLazyLoaderTreeNode) && !childLazyLoaderTreeNode.isLeaf())
					{
						LazyLoaderSwingWorker lazyLoaderSwingWorker = new LazyLoaderSwingWorker(lazyLoaderTree, childLazyLoaderTreeNode, isRecursive, recursionDepth, recursionPathCount, searchDescription);
						lazyLoaderSwingWorker.execute();
					}
				}
			}
		}
	}
	
	public void firePendingStatusChanged()
	{
		
	}
	
	public void fireStartedStatusChanged()
	{
		lazyLoaderTreeNode.setLoading(true);
	}
	
	public void fireDoneStatusChanged()
	{
		lazyLoaderTreeNode.setLoading(false);
	}
	
	public void fireProgressValueChanged(Object value)
	{
		
	}
	
	public void fireCancelledStatusChanged()
	{
		lazyLoaderTreeNode.setLoaded(false);
		
		if (lazyLoaderTreeNode.isNodeChild(loadingTreeNode))
		{	
			lazyLoaderTreeNode.remove(loadingTreeNode);
		}
		
		lazyLoaderTree.update(lazyLoaderTreeNode);
	}
	
	public void fireForegroundException(Exception e)
	{
		fireCancelledStatusChanged();
	}
	
	public void fireBackgroundException(Exception e)
	{
		
	}
}