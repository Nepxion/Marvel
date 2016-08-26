package com.nepxion.swing.selector.calendar.editor;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.toedter.calendar.JTextFieldDateEditor;

public class JTextFieldDateTimeEditor
	extends JTextFieldDateEditor
{
	/**
	 * Constructs with the default.
	 */
	public JTextFieldDateTimeEditor()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial date pattern, mask pattern and place holder.
	 * @param datePattern the date pattern string
	 * @param maskPattern the mask pattern string
	 * @param placeHolder the place holder char
	 */
	public JTextFieldDateTimeEditor(String datePattern, String maskPattern, char placeHolder)
	{
		super(datePattern, maskPattern, placeHolder);
	}
	
	/**
	 * Constructs with the specified initial show mask, date pattern, mask pattern and place holder.
	 * @param showMask the boolean value of showMask
	 * @param datePattern the date pattern string
	 * @param maskPattern the mask pattern string
	 * @param placeHolder the place holder char
	 */
	public JTextFieldDateTimeEditor(boolean showMask, String datePattern, String maskPattern, char placeHolder)
	{
		super(showMask, datePattern, maskPattern, placeHolder);
	}
}