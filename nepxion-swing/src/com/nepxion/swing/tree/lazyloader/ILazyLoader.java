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

public interface ILazyLoader
{
	public void loadForeground(Object data, JLazyLoaderTreeNode lazyLoaderTreeNode) // 装载前端数据，例如界面更新
		throws Exception;
	
	public Object loadBackground(JLazyLoaderTreeNode lazyLoaderTreeNode) // 装载后端数据，例如读取数据库
		throws Exception;
		
	public boolean isLoaded(JLazyLoaderTreeNode lazyLoaderTreeNode); // 判断是否已经装载过
	
	public boolean isLoading(JLazyLoaderTreeNode lazyLoaderTreeNode); // 判断是否正在装载
	
	public boolean isLeaf(JLazyLoaderTreeNode lazyLoaderTreeNode); // 判断是否可装载
	
	public boolean isSynchronized(); // 判断是否为同步装载模式
	
	public void setSynchronized(boolean isSynchronized); // 设置是否为同步装载模式
	
	public boolean isRecursive(); // 判断是否为递归装载
	
	public void setRecursive(boolean isRecursive); // 设置是否为递归装载
	
	public int getRecursionDepth(); // 获得递归深度
	
	public void setRecursionDepth(int recursionDepth); // 设置递归深度
	
	public SearchDescription getSearchDescription(); // 获得描述搜索的对象
	
	public void setSearchDescription(SearchDescription searchDescription); // 获得描述搜索的对象
}