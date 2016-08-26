package com.nepxion.swing.menu;

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
import javax.swing.JMenu;

public class JBasicMenu
	extends JMenu
{
	/**
	 * Constructs with the default.
	 */
	public JBasicMenu()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial action.
	 * @param action the instance of Action
	 */
	public JBasicMenu(Action action)
	{
		super(action);
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string
	 */
	public JBasicMenu(String text)
	{
		super(text);
	}
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of Icon
	 */
	public JBasicMenu(Icon icon)
	{
		super();
		
		setIcon(icon);
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string 
	 * @param icon the icon of Icon
	 */
	public JBasicMenu(String text, Icon icon)
	{
		super(text);
		
		setIcon(icon);
	}
	
	/**
	 * Constructs with the specified initial text and tooltip text.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JBasicMenu(String text, String toolTipText)
	{
		super(text);
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text and selected.
	 * @param text the text string
	 * @param selected the boolean value of selected
	 */
	public JBasicMenu(String text, boolean selected)
	{
		super(text);
		
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JBasicMenu(Icon icon, String toolTipText)
	{
		super();
		
		setIcon(icon);
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial icon and selected.
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 */
	public JBasicMenu(Icon icon, boolean selected)
	{
		super();
		
		setIcon(icon);
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text, icon and tooltip text.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JBasicMenu(String text, Icon icon, String toolTipText)
	{
		super(text);
		
		setIcon(icon);
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text, icon and selected.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 */
	public JBasicMenu(String text, Icon icon, boolean selected)
	{
		super(text);
		
		setIcon(icon);
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text, tooltip text and selected.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 */
	public JBasicMenu(String text, String toolTipText, boolean selected)
	{
		super(text);
		
		setToolTipText(toolTipText);
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial icon, tooltip text and selected.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 */
	public JBasicMenu(Icon icon, String toolTipText, boolean selected)
	{
		super();
		
		setIcon(icon);
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
	public JBasicMenu(String text, Icon icon, String toolTipText, boolean selected)
	{
		super(text);
		
		setIcon(icon);
		setToolTipText(toolTipText);
		setSelected(selected);
	}
}