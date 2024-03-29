package com.nepxion.swing.label;

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
import javax.swing.JLabel;
import javax.swing.plaf.UIResource;

public class JBasicLabel
	extends JLabel implements UIResource
{
	/**
	 * Constructs with the default.
	 */
	public JBasicLabel()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string
	 */
	public JBasicLabel(String text)
	{
		super(text);
	}
	
	/**
	 * Constructs with the specified initial text and toolTipText.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JBasicLabel(String text, String toolTipText)
	{
		super(text);
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text and horizontal alignment.
	 * @param text the text string
	 * @param horizontalAlignment the horizontal alignment value
	 */
	public JBasicLabel(String text, int horizontalAlignment)
	{
		super(text, horizontalAlignment);
	}
	
	/**
	 * Constructs with the specified initial text, tooltip text and horizontal alignment.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 * @param horizontalAlignment the horizontal alignment value
	 */
	public JBasicLabel(String text, String toolTipText, int horizontalAlignment)
	{
		super(text, horizontalAlignment);
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text and horizontal alignment.
	 * @param icon the instance of Icon
	 */
	public JBasicLabel(Icon icon)
	{
		super(icon);
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JBasicLabel(Icon icon, String toolTipText)
	{
		super(icon);
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial icon and horizontal alignment.
	 * @param icon the instance of Icon
	 * @param horizontalAlignment the horizontal alignment value
	 */
	public JBasicLabel(Icon icon, int horizontalAlignment)
	{
		super(icon, horizontalAlignment);
	}
	
	/**
	 * Constructs with the specified initial text, tooltip text and horizontal alignment.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param horizontalAlignment the horizontal alignment value
	 */
	public JBasicLabel(Icon icon, String toolTipText, int horizontalAlignment)
	{
		super(icon, horizontalAlignment);
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text, icon and horizontal alignment.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param horizontalAlignment the horizontal alignment value
	 */
	public JBasicLabel(String text, Icon icon, int horizontalAlignment)
	{
		super(text, icon, horizontalAlignment);
	}
	
	/**
	 * Constructs with the specified initial text, icon and horizontal alignment.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JBasicLabel(String text, Icon icon, String toolTipText)
	{
		super(text);
		
		setIcon(icon);
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text and horizontal alignment.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text
	 * @param horizontalAlignment the horizontal alignment value
	 */
	public JBasicLabel(String text, Icon icon, String toolTipText, int horizontalAlignment)
	{
		super(text, icon, horizontalAlignment);
		
		setToolTipText(toolTipText);
	}
}