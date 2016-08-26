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

import javax.swing.JTable;

import com.jidesoft.swing.TableSearchable;

public class JTableSearchable
	extends TableSearchable
{
	/**
	 * Constructs with the specified initial table.
	 * @param table the instance of JTable
	 */
	public JTableSearchable(JTable table)
	{
		super(table);
	}
}