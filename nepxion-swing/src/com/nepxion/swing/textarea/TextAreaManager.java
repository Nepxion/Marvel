package com.nepxion.swing.textarea;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.JTextArea;

import com.nepxion.swing.color.ColorUtil;

public class TextAreaManager
{
	/**
	 * Sets the label style for the text area.
	 * @param textArea the instance of JTextArea
	 */
	public static void setLabelStyle(JTextArea textArea)
	{
		textArea.setBorder(null);
		textArea.setBackground(ColorUtil.getUIManagerColor("Panel.background"));
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFocusable(false);
	}
}