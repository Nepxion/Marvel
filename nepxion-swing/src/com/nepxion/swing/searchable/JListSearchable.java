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

import javax.swing.JList;

import com.jidesoft.swing.ListSearchable;

public class JListSearchable
	extends ListSearchable
{
	/**
	 * Constructs with the specified initial list.
	 * @param list the instance of JList
	 */
	public JListSearchable(JList list)
	{
		super(list);
	}
}