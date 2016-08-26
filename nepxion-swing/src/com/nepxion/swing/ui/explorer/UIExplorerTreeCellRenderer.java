package com.nepxion.swing.ui.explorer;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.nepxion.swing.icon.IconFactory;

public class UIExplorerTreeCellRenderer
	extends DefaultTreeCellRenderer
{
	/**
	 * 
	 */
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row, boolean hasFocus)
	{
		super.getTreeCellRendererComponent(tree, value, isSelected, expanded, leaf, row, hasFocus);
		
		UIExplorerTreeNode treeNode = (UIExplorerTreeNode) value;
		String treeNodeName = treeNode.getKey().toString();
		String iconName = null;
		if (treeNodeName.equals(UIExplorerConstants.ROOT_NAME))
		{
			iconName = "theme/ui/explorer/tree_root.png";
		}
		else if (treeNodeName.equals(UIExplorerConstants.ALL_NAME))
		{
			if (expanded)
			{
				iconName = "theme/ui/explorer/catalog_all_tree_open.png";
			}
			else
			{
				iconName = "theme/ui/explorer/catalog_all_tree_closed.png";
			}
		}
		else if (treeNodeName.equals(UIExplorerConstants.COMPONENT_NAME))
		{
			if (expanded)
			{
				iconName = "theme/ui/explorer/catalog_component_tree_open.png";
			}
			else
			{
				iconName = "theme/ui/explorer/catalog_component_tree_closed.png";
			}
		}
		else if (treeNodeName.equals(UIExplorerConstants.TYPE_NAME))
		{
			if (expanded)
			{
				iconName = "theme/ui/explorer/catalog_type_tree_open.png";
			}
			else
			{
				iconName = "theme/ui/explorer/catalog_type_tree_closed.png";
			}
		}
		else
		{
			String parentTreeNodeName = treeNode.getParent().toString();
			if (parentTreeNodeName.equals(UIExplorerConstants.ALL_NAME))
			{
				iconName = "theme/ui/explorer/catalog_all_tree_leaf.png";
			}
			else if (parentTreeNodeName.equals(UIExplorerConstants.COMPONENT_NAME))
			{
				iconName = "theme/ui/explorer/catalog_component_tree_leaf.png";
			}
			else if (parentTreeNodeName.equals(UIExplorerConstants.TYPE_NAME))
			{
				iconName = "theme/ui/explorer/catalog_type_tree_leaf.png";
			}
		}
		
		setIcon(IconFactory.getSwingIcon(iconName));
		tree.setRowHeight(20);
		
		return this;
	}
}