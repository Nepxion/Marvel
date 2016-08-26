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

import javax.swing.JComboBox;

import com.jidesoft.swing.ComboBoxSearchable;

public class JComboBoxSearchable
	extends ComboBoxSearchable
{
	/**
	 * Constructs with the specified initial combo box.
	 * @param comboBox the instance of JComboBox
	 */
	public JComboBoxSearchable(JComboBox comboBox)
	{
		super(comboBox);
	}
}