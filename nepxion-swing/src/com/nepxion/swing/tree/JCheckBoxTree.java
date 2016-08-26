package com.nepxion.swing.tree;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.Position;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import com.jidesoft.swing.CheckBoxTree;
import com.jidesoft.swing.CheckBoxTreeSelectionModel;
import com.nepxion.swing.searchable.JSearchableFactory;

public class JCheckBoxTree
	extends CheckBoxTree implements ITree, MouseListener, TreeSelectionListener
{
	public JCheckBoxTree()
	{
		super();
		
		initComponents();
	}
	
	public JCheckBoxTree(Object[] value)
	{
		super(value);
		
		initComponents();
	}
	
	public JCheckBoxTree(Vector value)
	{
		super(value);
		
		initComponents();
	}
	
	public JCheckBoxTree(Hashtable value)
	{
		super(value);
		
		initComponents();
	}
	
	public JCheckBoxTree(TreeNode root)
	{
		super(root);
		
		initComponents();
	}
	
	public JCheckBoxTree(TreeNode root, boolean asksAllowsChildren)
	{
		super(root, asksAllowsChildren);
		
		initComponents();
	}
	
	public JCheckBoxTree(TreeModel newModel)
	{
		super(newModel);
		
		initComponents();
	}
	
	private void initComponents()
	{
		TreeManager.setPreferenceStyle(this);
		
		setRowHeight(20);
		
		addMouseListener(this);
		addTreeSelectionListener(this);
		
		JSearchableFactory.installSearchable(this);
	}
	
	public TreePath getNextMatch(String prefix, int startingRow, Position.Bias bias)
	{
		return null;
	}
	
	public void scrollToVisible(TreeNode treeNode)
	{
		TreeManager.scrollToVisible(this, treeNode);
	}
	
	public int getSelectionMode()
	{
		return TreeManager.getSelectionMode(this);
	}
	
	public void setSelectionMode(int mode)
	{
		TreeManager.setSelectionMode(this, mode);
	}
	
	public TreeNode getSelectionTreeNode()
	{
		return TreeManager.getSelectionTreeNode(this);
	}
	
	public void setSelectionTreeNode(TreeNode treeNode)
	{
		TreeManager.setSelectionTreeNode(this, treeNode);
	}
	
	public void setSelectionTreeNode(TreePath treePath)
	{
		TreeManager.setSelectionTreeNode(this, treePath);
	}
	
	public void addSelectionTreeNode(TreeNode treeNode)
	{
		TreeManager.addSelectionTreeNode(this, treeNode);
	}
	
	public void addSelectionTreeNode(TreePath treePath)
	{
		TreeManager.addSelectionTreeNode(this, treePath);
	}
	
	public TreeNode[] getSelectionTreeNodes()
	{
		return TreeManager.getSelectionTreeNodes(this);
	}
	
	public void addSelectionTreeNodes(TreeNode[] treeNodes)
	{
		TreeManager.addSelectionTreeNodes(this, treeNodes);
	}
	
	public void addSelectionTreeNodes(TreePath[] treePaths)
	{
		TreeManager.addSelectionTreeNodes(this, treePaths);
	}
	
	public int getTreeNodePathCount(TreeNode treeNode)
	{
		return TreeManager.getTreeNodePathCount(treeNode);
	}
	
	public int getTreeNodePathCount(TreePath treePath)
	{
		return TreeManager.getTreeNodePathCount(treePath);
	}
	
	public TreeNode getTreeNode(TreePath treePath)
	{
		return TreeManager.getTreeNode(treePath);
	}
	
	public TreePath getTreePath(TreeNode treeNode)
	{
		return TreeManager.getTreePath(treeNode);
	}
	
	public TreeNode[] getTreeNodes(TreeNode treeNode, int depth)
	{
		return TreeManager.getTreeNodes(treeNode, depth);
	}
	
	public TreeNode[] getTreeNodes(TreePath[] treePaths)
	{
		return TreeManager.getTreeNodes(treePaths);
	}
	
	public TreePath[] getTreePaths(TreeNode[] treeNodes)
	{
		return TreeManager.getTreePaths(treeNodes);
	}
	
	public TreeNode getChildTreeNode(TreeNode treeNode, String childTreeNodeName)
	{
		return TreeManager.getChildTreeNode(treeNode, childTreeNodeName);
	}
	
	public TreeNode[] getChildTreeNodes(TreeNode treeNode)
	{
		return TreeManager.getChildTreeNodes(treeNode);
	}
	
	public int getChildTreeNodeIndex(TreeNode treeNode, TreeNode childTreeNode)
	{
		return TreeManager.getChildTreeNodeIndex(treeNode, childTreeNode);
	}
	
	public void recursionTreeNodes(TreeNode treeNode, String treeNodeName, List treeNodes)
	{
		TreeManager.recursionTreeNodes(treeNode, treeNodeName, treeNodes);
	}
	
	public void addTreeNode(DefaultMutableTreeNode treeNode, DefaultMutableTreeNode childTreeNode)
	{
		TreeManager.addTreeNode(this, treeNode, childTreeNode);
	}
	
	public void deleteTreeNode(DefaultMutableTreeNode treeNode)
	{
		TreeManager.deleteTreeNode(this, treeNode);
	}
	
	public void deleteTreeNodes(DefaultMutableTreeNode[] treeNodes)
	{
		TreeManager.deleteTreeNodes(this, treeNodes);
	}
	
	public void moveUpTreeNode(DefaultMutableTreeNode treeNode)
	{
		TreeManager.moveUpTreeNode(this, treeNode);
	}
	
	public void moveDownTreeNode(DefaultMutableTreeNode treeNode)
	{
		TreeManager.moveDownTreeNode(this, treeNode);
	}
	
	public void expand(TreeNode treeNode)
	{
		TreeManager.expand(this, treeNode);
	}
	
	public void expand(TreePath treePath)
	{
		TreeManager.expand(this, treePath);
	}
	
	public void expand(TreeNode[] treeNodes)
	{
		TreeManager.expand(this, treeNodes);
	}
	
	public void expand(TreePath[] treePaths)
	{
		TreeManager.expand(this, treePaths);
	}
	
	public void expandChildren(TreeNode treeNode)
	{
		TreeManager.expandChildren(this, treeNode);
	}
	
	public void expandChildren(TreePath treePath)
	{
		TreeManager.expandChildren(this, treePath);
	}
	
	public void expandChildren(TreeNode[] treeNodes)
	{
		TreeManager.expandChildren(this, treeNodes);
	}
	
	public void expandChildren(TreePath[] treePaths)
	{
		TreeManager.expandChildren(this, treePaths);
	}
	
	public void expandAll()
	{
		TreeManager.expandAll(this);
	}
	
	public void expandAll(TreeNode treeNode)
	{
		TreeManager.expandAll(this, treeNode);
	}
	
	public void expandAll(TreePath treePath)
	{
		TreeManager.expandAll(this, treePath);
	}
	
	public void collapse(TreeNode treeNode)
	{
		TreeManager.collapse(this, treeNode);
	}
	
	public void collapse(TreePath treePath)
	{
		TreeManager.collapse(this, treePath);
	}
	
	public void collapse(TreeNode[] treeNodes)
	{
		TreeManager.collapse(this, treeNodes);
	}
	
	public void collapse(TreePath[] treePaths)
	{
		TreeManager.collapse(this, treePaths);
	}
	
	public void collapseChildren(TreeNode treeNode)
	{
		TreeManager.collapseChildren(this, treeNode);
	}
	
	public void collapseChildren(TreePath treePath)
	{
		TreeManager.collapseChildren(this, treePath);
	}
	
	public void collapseChildren(TreeNode[] treeNodes)
	{
		TreeManager.collapseChildren(this, treeNodes);
	}
	
	public void collapseChildren(TreePath[] treePaths)
	{
		TreeManager.collapseChildren(this, treePaths);
	}
	
	public void collapseAll()
	{
		TreeManager.collapseAll(this);
	}
	
	public void collapseAll(TreeNode treeNode)
	{
		TreeManager.collapseAll(this, treeNode);
	}
	
	public void collapseAll(TreePath treePath)
	{
		TreeManager.collapseAll(this, treePath);
	}
	
	public List getCheckBoxSelectionLeafTreeNodes()
	{
		CheckBoxTreeSelectionModel checkBoxTreeSelectionModel = getCheckBoxTreeSelectionModel();
		if (checkBoxTreeSelectionModel == null)
		{
			return null;
		}	
		
		TreePath[] selectionTreePaths = checkBoxTreeSelectionModel.getSelectionPaths();
		if (selectionTreePaths == null)
		{
			return null;
		}	
		
		List selectionTreeNodes = new ArrayList();
		for (int i = 0; i < selectionTreePaths.length; i++)
		{
			TreePath selectionTreePath = selectionTreePaths[i];
			TreeNode treeNode = getTreeNode(selectionTreePath);
			recursionTreeNode(selectionTreeNodes, treeNode);
		}
		
		return selectionTreeNodes;
	}
	
	private void recursionTreeNode(List selectionTreeNodes, TreeNode treeNode)
	{
		if (treeNode.getChildCount() == 0)
		{
			selectionTreeNodes.add(treeNode);
		}	
		else
		{
			for (int i = 0; i < treeNode.getChildCount(); i++)
			{
				TreeNode childTreeNode = treeNode.getChildAt(i);
				
				recursionTreeNode(selectionTreeNodes, childTreeNode);
			}	
		}
	}
	
	public List getCheckBoxSelectionTreeNodes()
	{
		CheckBoxTreeSelectionModel checkBoxTreeSelectionModel = getCheckBoxTreeSelectionModel();
		if (checkBoxTreeSelectionModel == null)
		{
			return null;
		}	
		
		TreePath[] selectionTreePaths = checkBoxTreeSelectionModel.getSelectionPaths();
		if (selectionTreePaths == null)
		{
			return null;
		}	
		
		List selectionTreeNodes = new ArrayList();
		for (int i = 0; i < selectionTreePaths.length; i++)
		{
			TreePath selectionTreePath = selectionTreePaths[i];
			TreeNode treeNode = getTreeNode(selectionTreePath);
			selectionTreeNodes.add(treeNode);
		}
		
		return selectionTreeNodes;
	}
	
	public void setCheckBoxSelectionTreeNodes(TreeNode[] treeNodes)
	{
		TreePath[] treePaths = getTreePaths(treeNodes);
		
		setCheckBoxSelectionTreeNodes(treePaths);
	}
	
	public void setCheckBoxSelectionTreeNodes(TreePath[] treePaths)
	{
		CheckBoxTreeSelectionModel checkBoxTreeSelectionModel = getCheckBoxTreeSelectionModel();
		if (checkBoxTreeSelectionModel == null)
		{
			return;
		}
		
		checkBoxTreeSelectionModel.setSelectionPaths(treePaths);
	}
	
	public void update(TreeNode treeNode)
	{
		TreeManager.update(this, treeNode);
	}
	
	public void valueChanged(TreeSelectionEvent e)
	{
		TreePath oldSelectionPath = e.getOldLeadSelectionPath();
		TreePath newSelectionPath = e.getNewLeadSelectionPath();
		
		TreeNode oldSelectionTreeNode = TreeManager.getTreeNode(oldSelectionPath);
		TreeNode newSelectionTreeNode = TreeManager.getTreeNode(newSelectionPath);
		
		executeSelection(oldSelectionTreeNode, newSelectionTreeNode);
	}
	
	public void executeSelection(TreeNode oldSelectionTreeNode, TreeNode newSelectionTreeNode)
	{
		
	}
	
	public void mouseClicked(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();
		
		TreePath treePath = getPathForLocation(x, y);
		if (treePath != null)
		{
			addSelectionPath(treePath);
			TreeNode treeNode = getTreeNode(treePath);
			
			executeClicked(treeNode, e);
		}
	}
	
	public void executeClicked(TreeNode treeNode, MouseEvent e)
	{
		if (e.getClickCount() > 1)
		{
			executeDoubleClicked(treeNode);
		}
		else
		{
			executeClicked(treeNode);
		}
	}
	
	public void executeClicked(TreeNode treeNode)
	{
		
	}
	
	public void executeDoubleClicked(TreeNode treeNode)
	{
		
	}
	
	public void mouseEntered(MouseEvent e)
	{
		
	}
	
	public void mouseExited(MouseEvent e)
	{
		
	}
	
	public void mousePressed(MouseEvent e)
	{
		
	}
	
	public void mouseReleased(MouseEvent e)
	{
		if (!e.isPopupTrigger())
		{
			return;
		}
		
		int x = e.getX();
		int y = e.getY();
		
		TreePath treePath = getPathForLocation(x, y);
		if (treePath != null)
		{
			addSelectionPath(treePath);
			TreeNode treeNode = getTreeNode(treePath);
			int treePathCount = treePath.getPathCount();
			
			executePopupMenu(treeNode, treePathCount, x, y);
		}
		else
		{
			executePopupMenu(x, y);
		}
	}
	
	public void executePopupMenu(TreeNode treeNode, int treePathCount, int x, int y)
	{
		
	}
	
	public void executePopupMenu(int x, int y)
	{
		
	}
}