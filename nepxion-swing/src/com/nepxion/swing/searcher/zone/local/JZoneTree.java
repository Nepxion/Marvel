package com.nepxion.swing.searcher.zone.local;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.tree.DefaultTreeModel;

import org.dom4j.DocumentException;

import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.renderer.tree.ElementTreeCellRenderer;
import com.nepxion.swing.tree.JBasicTree;
import com.nepxion.swing.tree.xml.Dom4JTreeParser;
import com.nepxion.util.io.FileContext;
import com.nepxion.util.searcher.zone.local.ZoneConstants;

public class JZoneTree
	extends JBasicTree implements ZoneConstants
{
	/**
	 * Constructs with the default.
	 */
	public JZoneTree()
	{
		this(FileContext.getContent(CONFIG_FILE_PATH));
	}
	
	/**
	 * Constructs with the specified initial content.
	 * @param content the content string
	 */
	public JZoneTree(String content)
	{
		Dom4JTreeParser parser = new Dom4JTreeParser();
		parser.setNameTag("code");
		parser.setTextTag("name");
		
		ElementNode root = null;
		try
		{
			root = parser.parse(content);
		}
		catch (DocumentException e)
		{
			e.printStackTrace();
		}
		DefaultTreeModel treeModel = new DefaultTreeModel(root);
		setModel(treeModel);
		setCellRenderer(new ElementTreeCellRenderer(ElementTreeCellRenderer.TREE_THEME_NIMBUS, 20));
		setSelectionMode(JBasicTree.SINGLE_TREE_SELECTION);
	}
}