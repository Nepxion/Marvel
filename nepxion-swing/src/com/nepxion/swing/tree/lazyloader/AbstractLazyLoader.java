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

public abstract class AbstractLazyLoader
	implements ILazyLoader
{
	private boolean isSynchronized = false;
	private boolean isRecursive = false;
	private int recursionDepth = -1;
	
	private SearchDescription searchDescription;
	
	public AbstractLazyLoader()
	{
		this(false);
	}
	
	public AbstractLazyLoader(boolean isSynchronized)
	{
		this.isSynchronized = isSynchronized;
	}
	
	public boolean isLoaded(JLazyLoaderTreeNode lazyLoaderTreeNode)
	{
		return lazyLoaderTreeNode.isLoaded();
	}
	
	public boolean isLoading(JLazyLoaderTreeNode lazyLoaderTreeNode)
	{
		return lazyLoaderTreeNode.isLoading();
	}
	
	public boolean isLeaf(JLazyLoaderTreeNode lazyLoaderTreeNode)
	{
		return lazyLoaderTreeNode.isLeaf();
	}
	
	public boolean isSynchronized()
	{
		return isSynchronized;
	}
	
	public void setSynchronized(boolean isSynchronized)
	{
		this.isSynchronized = isSynchronized;
	}
	
	public boolean isRecursive()
	{
		return isRecursive;
	}
	
	public void setRecursive(boolean isRecursive)
	{
		this.isRecursive = isRecursive;
	}
	
	public int getRecursionDepth()
	{
		return recursionDepth;
	}
	
	public void setRecursionDepth(int recursionDepth)
	{
		this.recursionDepth = recursionDepth;
	}
	
	public SearchDescription getSearchDescription()
	{
		return searchDescription;
	}
	
	public void setSearchDescription(SearchDescription searchDescription)
	{
		this.searchDescription = searchDescription;
	}
}