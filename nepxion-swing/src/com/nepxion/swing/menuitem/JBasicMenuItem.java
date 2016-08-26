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
import javax.swing.JMenuItem;

public class JBasicMenuItem
	extends JMenuItem
{
	/**
	 * Constructs with the default.
	 */
	public JBasicMenuItem()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial action.
	 * @param action the instance of Action
	 */
	public JBasicMenuItem(Action action)
	{
		super(action);
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string
	 */
	public JBasicMenuItem(String text)
	{
		super(text);
	}
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of Icon
	 */
	public JBasicMenuItem(Icon icon)
	{
		super(icon);
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string 
	 * @param icon the icon of Icon
	 */
	public JBasicMenuItem(String text, Icon icon)
	{
		super(text, icon);
	}
	
	/**
	 * Constructs with the specified initial text and tooltip text.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JBasicMenuItem(String text, String toolTipText)
	{
		super(text);
		
		setToolTipText(toolTipText);
	}
		
	/**
	 * Constructs with the specified initial text and selected.
	 * @param text the text string
	 * @param selected the boolean value of selected
	 */
	public JBasicMenuItem(String text, boolean selected)
	{
		super(text);
		
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JBasicMenuItem(Icon icon, String toolTipText)
	{
		super(icon);
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial icon and selected.
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 */
	public JBasicMenuItem(Icon icon, boolean selected)
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
	public JBasicMenuItem(String text, Icon icon, String toolTipText)
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
	public JBasicMenuItem(String text, Icon icon, boolean selected)
	{
		super(text, icon);
		
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text, tooltip text and selected.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 */
	public JBasicMenuItem(String text, String toolTipText, boolean selected)
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
	public JBasicMenuItem(Icon icon, String toolTipText, boolean selected)
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
	public JBasicMenuItem(String text, Icon icon, String toolTipText, boolean selected)
	{
		super(text, icon);
		
		setToolTipText(toolTipText);
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text and mnemonic.
	 * @param text the text string
	 * @param mnemonic the mnemonic int value
	 */
	public JBasicMenuItem(String text, int mnemonic)
	{
		super(text, mnemonic);
	}
	
	/**
	 * Constructs with the specified initial text and mnemonic.
	 * @param text the text string
	 * @param mnemonic the mnemonic char value
	 */
	public JBasicMenuItem(String text, char mnemonic)
	{
		super(text);
		
		setMnemonic(mnemonic);
	}
	
	/**
	 * Constructs with the specified initial text, icon and mnemonic.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param mnemonic the mnemonic int value
	 */
	public JBasicMenuItem(String text, Icon icon, int mnemonic)
	{
		super(text, mnemonic);
		
		setIcon(icon);
	}
	
	/**
	 * Constructs with the specified initial text, icon and mnemonic.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param mnemonic the mnemonic char value
	 */
	public JBasicMenuItem(String text, Icon icon, char mnemonic)
	{
		super(text, icon);
		
		setMnemonic(mnemonic);
	}
	
	/**
	 * Constructs with the specified initial text, tooltip text and mnemonic.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 * @param mnemonic the mnemonic int value
	 */
	public JBasicMenuItem(String text, String toolTipText, int mnemonic)
	{
		super(text, mnemonic);
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text, tooltip text and mnemonic.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 * @param mnemonic the mnemonic char value
	 */
	public JBasicMenuItem(String text, String toolTipText, char mnemonic)
	{
		super(text);
		
		setToolTipText(toolTipText);
		setMnemonic(mnemonic);
	}
	
	/**
	 * Constructs with the specified initial text, selected and mnemonic.
	 * @param text the text string
	 * @param selected the boolean value of selected
	 * @param mnemonic the mnemonic int value
	 */
	public JBasicMenuItem(String text, boolean selected, int mnemonic)
	{
		super(text, mnemonic);
		
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text, selected and mnemonic.
	 * @param text the text string
	 * @param selected the boolean value of selected
	 * @param mnemonic the mnemonic char value
	 */
	public JBasicMenuItem(String text, boolean selected, char mnemonic)
	{
		super(text);
		
		setSelected(selected);
		setMnemonic(mnemonic);
	}
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text and mnemonic.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param mnemonic the mnemonic int value
	 */
	public JBasicMenuItem(String text, Icon icon, String toolTipText, int mnemonic)
	{
		super(text, mnemonic);
		
		setIcon(icon);
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text and mnemonic.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param mnemonic the mnemonic char value
	 */
	public JBasicMenuItem(String text, Icon icon, String toolTipText, char mnemonic)
	{
		super(text, icon);
		
		setToolTipText(toolTipText);
		setMnemonic(mnemonic);
	}
	
	/**
	 * Constructs with the specified initial text, icon, selected and mnemonic.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 * @param mnemonic the mnemonic int value
	 */
	public JBasicMenuItem(String text, Icon icon, boolean selected, int mnemonic)
	{
		super(text, mnemonic);
		
		setIcon(icon);
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text, icon, selected and mnemonic.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 * @param mnemonic the mnemonic char value
	 */
	public JBasicMenuItem(String text, Icon icon, boolean selected, char mnemonic)
	{
		super(text, icon);
		
		setSelected(selected);
		setMnemonic(mnemonic);
	}
	
	/**
	 * Constructs with the specified initial text, tooltip text, selected and mnemonic.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 * @param mnemonic the mnemonic int value
	 */
	public JBasicMenuItem(String text, String toolTipText, boolean selected, int mnemonic)
	{
		super(text, mnemonic);
		
		setToolTipText(toolTipText);
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text, tooltip text, selected and mnemonic.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 * @param mnemonic the mnemonic char value
	 */
	public JBasicMenuItem(String text, String toolTipText, boolean selected, char mnemonic)
	{
		super(text);
		
		setToolTipText(toolTipText);
		setSelected(selected);
		setMnemonic(mnemonic);
	}
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text, selected and mnemonic.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 * @param mnemonic the mnemonic int value
	 */
	public JBasicMenuItem(String text, Icon icon, String toolTipText, boolean selected, int mnemonic)
	{
		super(text, mnemonic);
		
		setIcon(icon);
		setToolTipText(toolTipText);
		setSelected(selected);
	}	
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text, selected and mnemonic.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 * @param mnemonic the mnemonic char value
	 */
	public JBasicMenuItem(String text, Icon icon, String toolTipText, boolean selected, char mnemonic)
	{
		super(text);
		
		setIcon(icon);
		setToolTipText(toolTipText);
		setSelected(selected);
		setMnemonic(mnemonic);
	}
}