package com.nepxion.swing.menuitem;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBoxMenuItem;

public class JBasicCheckBoxMenuItem
	extends JCheckBoxMenuItem
{
	/**
	 * Constructs with the default.
	 */
	public JBasicCheckBoxMenuItem()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial action.
	 * @param action the instance of Action
	 */
	public JBasicCheckBoxMenuItem(Action action)
	{
		super(action);
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string
	 */
	public JBasicCheckBoxMenuItem(String text)
	{
		super(text);
	}
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of Icon
	 */
	public JBasicCheckBoxMenuItem(Icon icon)
	{
		super(icon);
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string 
	 * @param icon the icon of Icon
	 */
	public JBasicCheckBoxMenuItem(String text, Icon icon)
	{
		super(text, icon);
	}
	
	/**
	 * Constructs with the specified initial text and tooltip text.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JBasicCheckBoxMenuItem(String text, String toolTipText)
	{
		super(text);
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text and selected.
	 * @param text the text string
	 * @param selected the boolean value of selected
	 */
	public JBasicCheckBoxMenuItem(String text, boolean selected)
	{
		super(text, selected);
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JBasicCheckBoxMenuItem(Icon icon, String toolTipText)
	{
		super(icon);
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial icon and selected.
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 */
	public JBasicCheckBoxMenuItem(Icon icon, boolean selected)
	{
		super(icon);
		
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text, icon and tooltip text.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JBasicCheckBoxMenuItem(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text, icon and selected.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 */
	public JBasicCheckBoxMenuItem(String text, Icon icon, boolean selected)
	{
		super(text, icon, selected);
	}
	
	/**
	 * Constructs with the specified initial text, tooltip text and selected.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 */
	public JBasicCheckBoxMenuItem(String text, String toolTipText, boolean selected)
	{
		super(text, selected);
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial icon, tooltip text and selected.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 */
	public JBasicCheckBoxMenuItem(Icon icon, String toolTipText, boolean selected)
	{
		super(icon);
		
		setToolTipText(toolTipText);
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text and selected.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 */
	public JBasicCheckBoxMenuItem(String text, Icon icon, String toolTipText, boolean selected)
	{
		super(text, icon, selected);
		
		setToolTipText(toolTipText);
	}
}