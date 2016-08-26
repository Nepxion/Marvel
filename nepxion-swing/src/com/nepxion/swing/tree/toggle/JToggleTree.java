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

import java.util.Hashtable;
import java.util.Vector;

import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

import com.nepxion.swing.toggle.IToggleContentPanel;
import com.nepxion.swing.tree.JBasicTree;
import com.nepxion.swing.tree.TreeNavigator;

public class JToggleTree
	extends JBasicTree implements IToggleTree
{
	private int invokeMode = INVOKE_MODE_SELECTED;
	private TreeNavigator treeNavigator;
	
	private IToggleContentPanel toggleContentPanel;
	
	private IToggleAdapter toggleAdapter;
	
	public JToggleTree()
	{
		super();
		
		initComponents();
	}
	
	public JToggleTree(Object[] value)
	{
		super(value);
		
		initComponents();
	}
	
	public JToggleTree(Vector value)
	{
		super(value);
		
		initComponents();
	}
	
	public JToggleTree(Hashtable value)
	{
		super(value);
		
		initComponents();
	}
	
	public JToggleTree(TreeNode root)
	{
		super(root);
		
		initComponents();
	}
	
	public JToggleTree(TreeNode root, boolean asksAllowsChildren)
	{
		super(root, asksAllowsChildren);
		
		initComponents();
	}
	
	public JToggleTree(TreeModel newModel)
	{
		super(newModel);
		
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