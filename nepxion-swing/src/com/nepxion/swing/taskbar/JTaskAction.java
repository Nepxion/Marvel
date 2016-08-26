package com.nepxion.swing.taskbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.Icon;

import com.nepxion.swing.action.JSecurityAction;

public abstract class JTaskAction
	extends JSecurityAction
{
	/**
	 * Constructs with the default.
	 */
	public JTaskAction()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string
	 */
	public JTaskAction(String text)
	{
		super(text);
	}
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of Icon
	 */
	public JTaskAction(Icon icon)
	{
		super(icon);
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string
	 * @param icon the instance of Icon
	 */
	public JTaskAction(String text, Icon icon)
	{
		super(text, icon);
	}
	
	/**
	 * Constructs with the specified initial text and tooltip text.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JTaskAction(String text, String toolTipText)
	{
		super(text, toolTipText);
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JTaskAction(Icon icon, String toolTipText)
	{
		super(icon, toolTipText);
	}

	/**
	 * Constructs with the specified initial text, icon and tooltip text.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JTaskAction(String text, Icon icon, String toolTipText)
	{
		super(text, icon, toolTipText);
	}
	
	/**
	 * Constructs with the specified initial name, text and tooltip text.
	 * @param name the name string
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JTaskAction(String name, String text, String toolTipText)
	{
		super(name, text, toolTipText);
	}
	
	/**
	 * Constructs with the specified initial name, text, icon and tooltip text.
	 * @param name the name string
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JTaskAction(String name, String text, Icon icon, String toolTipText)
	{
		super(name, text, icon, toolTipText);
	}
}