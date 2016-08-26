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
import com.nepxion.swing.toggle.ITogglePanel;
import com.nepxion.swing.toggle.JThreadTogglePanel;

public abstract class AbstractToggleAdapter
	implements IToggleAdapter
{
	private IToggleTree toggleTree;
	
	public AbstractToggleAdapter(IToggleTree toggleTree)
	{
		this.toggleTree = toggleTree;
		this.toggleTree.setToggleAdapter(this);
	}
	
	public void invoke(TreeNode oldSelectionTreeNode, TreeNode newSelectionTreeNode)
	{
		if (newSelectionTreeNode == null)
		{
			return;
		}
		
		IToggleContentPanel toggleContentPanel = toggleTree.getToggleContentPanel();
		if (toggleContentPanel == null)
		{
			return;
		}
		
		ITogglePanel togglePanel = getTogglePanel(newSelectionTreeNode);
		if (togglePanel == null)
		{
			return;
		}
		
		if (togglePanel.getToggleText() == null)
		{
			String text = newSelectionTreeNode.toString();
			togglePanel.setToggleText(text);
		}
		
		if (togglePanel.getToggleDescription() == null)
		{
			String description = toggleTree.getTreeNavigator().getURL(newSelectionTreeNode);
			togglePanel.setToggleDescription(description);
		}
		
		toggleContentPanel.toggle(togglePanel);
		
		if (togglePanel instanceof JThreadTogglePanel)
		{
			JThreadTogglePanel threadTogglePanel = (JThreadTogglePanel) togglePanel;
			threadTogglePanel.execute();
		}
	}
	
	public IToggleTree getToggleTree()
	{
		return toggleTree;
	}
	
	public abstract ITogglePanel getTogglePanel(TreeNode treeNode);
}