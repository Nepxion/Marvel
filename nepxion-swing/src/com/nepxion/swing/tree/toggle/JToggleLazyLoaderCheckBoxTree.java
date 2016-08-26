package com.nepxion.swing.tree.toggle;

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

import com.nepxion.swing.toggle.IToggleContentPanel;
import com.nepxion.swing.tree.TreeNavigator;
import com.nepxion.swing.tree.lazyloader.JLazyLoaderCheckBoxTree;

public class JToggleLazyLoaderCheckBoxTree
	extends JLazyLoaderCheckBoxTree	implements IToggleTree
{
	private int invokeMode = INVOKE_MODE_SELECTED;
	private TreeNavigator treeNavigator;
	
	private IToggleContentPanel toggleContentPanel;
	
	private IToggleAdapter toggleAdapter;
	
	public JToggleLazyLoaderCheckBoxTree()
	{
		super();
		
		initComponents();
	}
	
	private void initComponents()
	{
		treeNavigator = new TreeNavigator(this);
	}
	
	public int getInvokeMode()
	{
		return invokeMode;
	}
	
	public void setInvokeMode(int invokeMode)
	{
		this.invokeMode = invokeMode;
	}
	
	public TreeNavigator getTreeNavigator()
	{
		return treeNavigator;
	}
	
	public void setTreeNavigator(TreeNavigator treeNavigator)
	{
		this.treeNavigator = treeNavigator;
	}
	
	public IToggleContentPanel getToggleContentPanel()
	{
		return toggleContentPanel;
	}
	
	public void setToggleContentPanel(IToggleContentPanel toggleContentPanel)
	{
		this.toggleContentPanel = toggleContentPanel;
	}
	
	public IToggleAdapter getToggleAdapter()
	{
		return toggleAdapter;
	}
	
	public void setToggleAdapter(IToggleAdapter toggleAdapter)
	{
		this.toggleAdapter = toggleAdapter;
	}
	
	public void executeSelection(TreeNode oldSelectionTreeNode, TreeNode newSelectionTreeNode)
	{
		if (invokeMode == INVOKE_MODE_SELECTED)
		{
			toggleAdapter.invoke(oldSelectionTreeNode, newSelectionTreeNode);
		}
	}
	
	public void executeClicked(TreeNode treeNode)
	{
		if (invokeMode == INVOKE_MODE_CLICKED)
		{
			toggleAdapter.invoke(null, treeNode);
		}
	}
	
	public void executeDoubleClicked(TreeNode treeNode)
	{
		if (invokeMode == INVOKE_MODE_DOUBLE_CLICKED)
		{
			toggleAdapter.invoke(null, treeNode);
		}
	}
}