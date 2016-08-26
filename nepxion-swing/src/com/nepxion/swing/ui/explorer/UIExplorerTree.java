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

import java.util.Iterator;
import java.util.Map;

import javax.swing.tree.TreeSelectionModel;

import com.nepxion.swing.tree.JBasicTree;

public class UIExplorerTree
	extends JBasicTree
{
	/**
	 * 
	 */
	private UIExplorerTreeModel treeModel;
	
	/**
	 * 
	 */
	public UIExplorerTree()
	{
		UIExplorerTreeNode allTreeNode = new UIExplorerTreeNode(UIExplorerConstants.ALL_NAME, UIExplorerParser.parseAllMap());
		
		UIExplorerTreeNode componentTreeNode = new UIExplorerTreeNode(UIExplorerConstants.COMPONENT_NAME);
		parseComponent(componentTreeNode, UIExplorerParser.parseComponentMap());
		
		UIExplorerTreeNode typeTreeNode = new UIExplorerTreeNode(UIExplorerConstants.TYPE_NAME);
		parseType(typeTreeNode, UIExplorerParser.parseTypeMap());
		
		UIExplorerTreeNode rootTreeNode = new UIExplorerTreeNode(UIExplorerConstants.ROOT_NAME);
		rootTreeNode.add(allTreeNode);
		rootTreeNode.add(componentTreeNode);
		rootTreeNode.add(typeTreeNode);
		
		treeModel = new UIExplorerTreeModel(rootTreeNode);
		
		setModel(treeModel);
		setCellRenderer(new UIExplorerTreeCellRenderer());
		addTreeSelectionListener(new UIExplorerTreeSelectionListener());
		getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		putClientProperty("JTree.lineStyle", "Angled");
	}
	
	/**
	 * 
	 * @param parentTreeNode
	 * @param map
	 */
	private void parseComponent(UIExplorerTreeNode parentTreeNode, Map map)
	{
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
		{
			Object key = iterator.next();
			Object value = (Map) map.get(key);
			UIExplorerTreeNode treeNode = new UIExplorerTreeNode(key, value);
			parentTreeNode.add(treeNode);
		}
	}
	
	/**
	 * 
	 * @param parentTreeNode
	 * @param map
	 */
	private void parseType(UIExplorerTreeNode parentTreeNode, Map map)
	{
		for (int i = 0; i < UIExplorerConstants.CLASS_TYPE_NAMES.length; i++)
		{
			String key = UIExplorerConstants.CLASS_TYPE_NAMES[i];
			Object value = map.get(key);
			UIExplorerTreeNode treeNode = new UIExplorerTreeNode(key, value);
			parentTreeNode.add(treeNode);
		}
	}
}