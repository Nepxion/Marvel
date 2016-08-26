package com.nepxion.swing.hint;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.List;

import javax.swing.text.JTextComponent;

import com.jidesoft.hints.ListDataIntelliHints;

public class ListIntelliHint
	extends ListDataIntelliHints
{
	/**
	 * Constructs with the specified initial text component and completion list.
	 * @param textComponent the instance of JTextComponent
	 * @param list the instance of List
	 */
	public ListIntelliHint(JTextComponent textComponent, List completionList)
	{
		super(textComponent, completionList);
	}
	
	/**
	 * Constructs with the specified initial text component and completion object array.
	 * @param textComponent the instance of JTextComponent
	 * @param completionList the completion object array
	 */
	public ListIntelliHint(JTextComponent textComponent, Object[] completionList)
	{
		super(textComponent, completionList);
	}
}