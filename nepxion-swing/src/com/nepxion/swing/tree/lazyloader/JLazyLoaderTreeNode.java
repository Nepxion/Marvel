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

import javax.swing.Icon;

import com.nepxion.swing.element.ElementNode;

public class JLazyLoaderTreeNode
	extends ElementNode
{	
	private boolean isLoaded = false;
	private boolean isLoading = false;

	private boolean isLeaf = false;
	
	public JLazyLoaderTreeNode()
	{
		super();
	}
	
	
	public JLazyLoaderTreeNode(String text, Icon icon, String toolTipText)
	{
		super(text, icon, toolTipText);
	}	
	
	
	public JLazyLoaderTreeNode(String text, Icon icon, String toolTipText, boolean selected)
	{
		super(text, icon, toolTipText, selected);
	}		
	
	public JLazyLoaderTreeNode(String text, Icon icon, String toolTipText, Object userObject)
	{
		super(text, icon, toolTipText, userObject);
	}	

	public JLazyLoaderTreeNode(int index, String text, Icon icon, String toolTipText)
	{
		super(index, text, icon, toolTipText);
	}	

	public JLazyLoaderTreeNode(String name, String text, Icon icon, String toolTipText)
	{
		super(name, text, icon, toolTipText);
	}
	
		
	public JLazyLoaderTreeNode(String text, Icon icon, String toolTipText, boolean selected, boolean enabled)
	{
		super(text, icon, toolTipText, selected, enabled);
	}			

	public JLazyLoaderTreeNode(String text, Icon icon, String toolTipText, Object userObject, boolean selected)
	{
		super(text, icon, toolTipText, userObject, selected);
	}		

	public JLazyLoaderTreeNode(String name, String text, Icon icon, String toolTipText, boolean selected)
	{
		super(name, text, icon, toolTipText, selected);
	}	
	
	public JLazyLoaderTreeNode(int index, String text, Icon icon, String toolTipText, boolean selected)
	{
		super(index, text, icon, toolTipText, selected);
	}		
	
	public JLazyLoaderTreeNode(String name, String text, Icon icon, String toolTipText, Object userObject)
	{
		super(name, text, icon, toolTipText, userObject);
	}

	public JLazyLoaderTreeNode(int index, String text, Icon icon, String toolTipText, Object userObject)
	{
		super(index, text, icon, toolTipText, userObject);
	}	

	public JLazyLoaderTreeNode(int index, String name, String text, Icon icon, String toolTipText)
	{
		super(index, name, text, icon, toolTipText);
	}	
	

	public JLazyLoaderTreeNode(String text, Icon icon, String toolTipText, Object userObject, boolean selected, boolean enabled)
	{
		super(text, icon, toolTipText, userObject, selected, enabled);
	}
	
	public JLazyLoaderTreeNode(String name, String text, Icon icon, String toolTipText, boolean selected, boolean enabled)
	{
		super(name, text, icon, toolTipText, selected, enabled);
	}	
	
	public JLazyLoaderTreeNode(int index, String text, Icon icon, String toolTipText, boolean selected, boolean enabled)
	{
		super(index, text, icon, toolTipText, selected, enabled);
	}	
	
	public JLazyLoaderTreeNode(String name, String text, Icon icon, String toolTipText, Object userObject, boolean selected)
	{
		super(name, text, icon, toolTipText, userObject, selected);
	}	
	
	public JLazyLoaderTreeNode(int index, String text, Icon icon, String toolTipText, Object userObject, boolean selected)
	{
		super(index, text, icon, toolTipText, userObject, selected);
	}	
	
	public JLazyLoaderTreeNode(int index, String name, String text, Icon icon, String toolTipText, boolean selected)
	{
		super(index, name, text, icon, toolTipText, selected);
	}	
	
	public JLazyLoaderTreeNode(int index, String name, String text, Icon icon, String toolTipText, Object userObject)
	{
		super(index, name, text, icon, toolTipText, userObject);
	}
	
	
	public JLazyLoaderTreeNode(String name, String text, Icon icon, String toolTipText, Object userObject, boolean selected, boolean enabled)
	{
		super(name, text, icon, toolTipText, userObject, selected, enabled);
	}
	
	public JLazyLoaderTreeNode(int index, String text, Icon icon, String toolTipText, Object userObject, boolean selected, boolean enabled)
	{
		super(index, text, icon, toolTipText, userObject, selected, enabled);
	}
	
	public JLazyLoaderTreeNode(int index, String name, String text, Icon icon, String toolTipText, boolean selected, boolean enabled)
	{
		super(index, name, text, icon, toolTipText, selected, enabled);
	}
	
	public JLazyLoaderTreeNode(int index, String name, String text, Icon icon, String toolTipText, Object userObject, boolean selected)
	{
		super(index, name, text, icon, toolTipText, userObject, selected);
	}
	
	
	public JLazyLoaderTreeNode(int index, String name, String text, Icon icon, String toolTipText, Object userObject, boolean selected, boolean enabled)
	{
		super(index, name, text, icon, toolTipText, userObject, selected, enabled);
	}	
	
	
	public JLazyLoaderTreeNode(Object userObject)
	{
		super(userObject);
	}
	
	public JLazyLoaderTreeNode(Object userObject, boolean allowsChildren)
	{
		super(userObject, allowsChildren);
	}
	
	public boolean isLoaded()
	{
		return isLoaded;
	}
	
	public void setLoaded(boolean isLoaded)
	{
		this.isLoaded = isLoaded;
	}
	
	public boolean isLoading()
	{
		return isLoading;
	}
	
	public void setLoading(boolean isLoading)
	{
		this.isLoading = isLoading;
	}
	
	public void setLeaf(boolean isLeaf)
	{
		this.isLeaf = isLeaf;
	}
	
	public boolean isLeaf() 
	{
		return isLeaf;
	}
}