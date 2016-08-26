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

import javax.swing.text.JTextComponent;

import com.jidesoft.hints.FileIntelliHints;

public class FileIntelliHint
	extends FileIntelliHints
{
	/**
	 * Constructs with the specified initial text component.
	 * @param textComponent the instance of JTextComponent
	 */
	public FileIntelliHint(JTextComponent textComponent)
	{
		super(textComponent);
	}
}