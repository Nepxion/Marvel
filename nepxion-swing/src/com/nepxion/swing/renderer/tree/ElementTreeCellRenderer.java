package com.nepxion.swing.renderer.tree;

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

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tree.animation.AnimationImageObserver;

public class ElementTreeCellRenderer
	extends DefaultTreeCellRenderer
{
	/**
	 * The tree theme of classic.
	 */
	public static final String TREE_THEME_CLASSIC = "theme/tree/classic/";
	
	/**
	 * The tree theme of plastic.
	 */
	public static final String TREE_THEME_PLASTIC = "theme/tree/plastic/";
	
	/**
	 * The tree theme of lunix.
	 */
	public static final String TREE_THEME_LUNIX = "theme/tree/lunix/";
	
	/**
	 * The tree theme of windows.
	 */
	public static final String TREE_THEME_WINDOWS = "theme/tree/windows/";
	
	/**
	 * The tree theme of nimbus.
	 */
	public static final String TREE_THEME_NIMBUS = "theme/tree/nimbus/";
	
	/**
	 * The tree theme of help.
	 */
	public static final String TREE_THEME_HELP = "theme/tree/help/";
	
	/**
	 * The tree theme string.
	 */
	private String treeTheme;
	
	/**
	 * The tree row height.
	 */
	private int rowHeight;
	
	/**
	 * Constructs with the default.
	 */
	public ElementTreeCellRenderer()
	{
		this(-1);
	}
	
	/**
	 * Constructs with the specified initial row height.
	 * @param rowHeight the row height value
	 */
	public ElementTreeCellRenderer(int rowHeight)
	{
		this(TREE_THEME_PLASTIC, rowHeight);
	}
	
	/**
	 * Constructs with the specified initial tree theme.
	 * @param treeTheme the tree theme string
	 */
	public ElementTreeCellRenderer(String treeTheme)
	{
		this(treeTheme, -1);
	}
	
	/**
	 * Constructs with the specified initial tree theme and row height.
	 * @param treeTheme the tree theme string
	 * @param rowHeight the row height value
	 */
	public ElementTreeCellRenderer(String treeTheme, int rowHeight)
	{
		this.treeTheme = treeTheme;
		this.rowHeight = rowHeight;
	}
	
	/**
	 * Gets the tree theme.
	 * @return the tree theme value
	 */
	public String getTreeTheme()
	{
		return treeTheme;
	}
	
	/**
	 * Sets the tree theme.
	 * @param treeTheme the tree theme value
	 */
	public void setTreeTheme(String treeTheme)
	{
		this.treeTheme = treeTheme;
	}
	
	/**
	 * Gets the tree cell renderer component.
	 * @param tree the instance of JTree
	 * @param value the value object
	 * @param isSelected the boolean value of isSelected
	 * @param expanded the boolean value of expanded
	 * @param leaf the boolean value of leaf
	 * @param row row the row index value
	 * @param hasFocus hasFocus the boolean value of hasFocus
	 */
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row, boolean hasFocus)
	{
		super.getTreeCellRendererComponent(tree, value, isSelected, expanded, leaf, row, hasFocus);
		
		if (rowHeight > 0 && tree.getRowHeight() != rowHeight)
		{
			tree.setRowHeight(rowHeight);
		}
		DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) value;
		if (treeNode instanceof IElementNode)
		{
			IElementNode element = (IElementNode) treeNode;
			setFacade(tree, element, treeNode, expanded);
		}
		else
		{
			adaptIcon(treeNode, expanded);
		}
		
		return this;
	}
	
	/**
	 * Sets the facade.
	 * @param tree the instance of JTree
	 * @param element the element of IElementNode
	 * @param treeNode the instance of DefaultMutableTreeNode
	 * @param expanded the boolean value of expanded
	 */
	private void setFacade(JTree tree, IElementNode element, DefaultMutableTreeNode treeNode, boolean expanded)
	{
		setText(element.getText());
		setToolTipText(element.getToolTipText());
		// tree.setToolTipText(element.getToolTipText());
		
		if (element.getIcon() != null)
		{
			if (element.getIcon() instanceof ImageIcon && element.isAnimation())
			{
				ImageIcon imageIcon = (ImageIcon) element.getIcon();
				imageIcon.setImageObserver(new AnimationImageObserver(tree, treeNode));
			}
			setIcon(element.getIcon());
		}
		else
		{
			adaptIcon(treeNode, expanded);
		}
	}
	
	/**
	 * Adapts the icon.
	 * @param treeNode the instance of DefaultMutableTreeNode
	 * @param expanded the boolean value of expanded
	 */
	private void adaptIcon(DefaultMutableTreeNode treeNode, boolean expanded)
	{
		String iconName = null;
		if (treeNode.isRoot())
		{
			iconName = treeTheme + "tree_root.png";
		}
		else if (treeNode.isLeaf())
		{
			iconName = treeTheme + "tree_leaf.png";
		}
		else
		{
			if (expanded)
			{
				iconName = treeTheme + "tree_open.png";
			}
			else
			{
				iconName = treeTheme + "tree_closed.png";
			}
		}
		setIcon(IconFactory.getSwingIcon(iconName));
	}
}