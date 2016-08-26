package com.nepxion.swing.searchable;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.JTree;

import com.jidesoft.swing.TreeSearchable;

public class JTreeSearchable
	extends TreeSearchable
{
	/**
	 * Constructs with the specified initial tree.
	 * @param tree the instance of JTree
	 */
	public JTreeSearchable(JTree tree)
	{
		super(tree);
	}
}