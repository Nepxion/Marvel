package com.nepxion.swing.textfield;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.JTextField;

import com.nepxion.swing.color.ColorUtil;

public class TextFieldManager
{	
	/**
	 * Sets the label style for the text field.
	 * @param scrollPane the instance of JTextField
	 */
	public static void setLabelStyle(JTextField textField)
	{
		textField.setBorder(null);
		textField.setBackground(ColorUtil.getUIManagerColor("Panel.background"));
		textField.setOpaque(false);
		textField.setEditable(false);
		textField.setFocusable(false);
	}
}