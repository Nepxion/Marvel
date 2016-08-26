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

import javax.swing.text.JTextComponent;

import com.jidesoft.swing.TextComponentSearchable;

public class JTextComponentSearchable
	extends TextComponentSearchable
{
	/**
	 * Constructs with the specified initial text component.
	 * @param textComponent the instance of JTextComponent
	 */
	public JTextComponentSearchable(JTextComponent textComponent)
	{
		super(textComponent);
	}
}