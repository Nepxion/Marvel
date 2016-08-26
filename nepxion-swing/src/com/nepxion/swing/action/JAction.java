package com.nepxion.swing.action;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;

public abstract class JAction
	extends AbstractAction
{	
	/**
	 * The string of text.
	 */
	public static final String TEXT = "text";
	
	/**
	 * The string of icon.
	 */
	public static final String ICON = "icon";
	
	/**
	 * The value of showing small for text or icon.
	 */
	public static final int SHOW_SMALL = 0;
	
	/**
	 * The value of showing large for text or icon.
	 */
	public static final int SHOW_LARGE = 1;
	
	/**
	 * The value of showing no for text or icon.
	 */
	public static final int SHOW_NO = 2;
	
	/**
	 * The action name string.
	 */
	private String name;
	
	/**
	 * The small text.
	 */
	private String smallText;
	
	/**
	 * The large text.
	 */
	private String largeText;
	
	/**
	 * The small icon.
	 */
	private Icon smallIcon;
	
	/**
	 * The large icon.
	 */
	private Icon largeIcon;
	
	/**
	 * The source object.
	 * When the action isn't been triggered by AbstractButton, mouseEvent.getSource() will be null.
	 * So you can register the source instead of mouseEvent.getSource().
	 */
	private Object source;
	
	/**
	 * Constructs with the default.
	 */
	public JAction()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string
	 */
	public JAction(String text)
	{
		super(text);
	}
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of Icon
	 */
	public JAction(Icon icon)
	{
		super(null, icon);
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string
	 * @param icon the instance of Icon
	 */
	public JAction(String text, Icon icon)
	{
		super(text, icon);
	}
	
	/**
	 * Constructs with the specified initial text and tooltip text.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JAction(String text, String toolTipText)
	{
		super(text);
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JAction(Icon icon, String toolTipText)
	{
		super(null, icon);
		
		setToolTipText(toolTipText);
	}

	/**
	 * Constructs with the specified initial text, icon and tooltip text.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JAction(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial name, text and tooltip text.
	 * @param name the name string
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JAction(String name, String text, String toolTipText)
	{
		super(text);
		
		setName(name);
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial name, text, icon and tooltip text.
	 * @param name the name string
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JAction(String name, String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		setName(name);
		setToolTipText(toolTipText);
	}
	
	/**
	 * Gets the name.
	 * @return the name string
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Sets the name.
	 * @param name the name string
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Gets the text.
	 * @return the text string
	 */
	public String getText()
	{
		return (String) getValue(Action.NAME);
	}
	
	/**
	 * Sets the text.
	 * @param text the text string
	 */
	public void setText(String text)
	{
		putValue(Action.NAME, text);
	}
	
	/**
	 * Gets the small text.
	 * @return the small text
	 */
	public String getSmallText()
	{
		return smallText;
	}

	/**
	 * Sets the small text.
	 * @param smallText the small text
	 */
	public void setSmallText(String smallText)
	{
		this.smallText = smallText;
	}

	/**
	 * Gets the large text.
	 * @return the large text
	 */
	public String getLargeText()
	{
		return largeText;
	}

	/**
	 * Sets the large icon.
	 * @param largeIcon the large icon
	 */
	public void setLargeText(String largeText)
	{
		this.largeText = largeText;
	}
	
	/**
	 * Shows the text by a show value.
	 * @param showValue the show value
	 */
	public void showText(int showValue)
	{		
		switch (showValue)
		{
			case SHOW_SMALL : 
			{
				setText(smallText);
				break;
			}
			case SHOW_LARGE : 
			{
				setText(largeText);
				break;
			}
			case SHOW_NO : 
			{
				setText(null);
				break;
			}
		}
	}
	
	/**
	 * Gets the tooltip text.
	 * @return the tooltip text string
	 */
	public String getToolTipText()
	{
		return (String) getValue(Action.SHORT_DESCRIPTION);
	}
	
	/**
	 * Sets the tooltip text.
	 * @param toolTipText the tooltip text string
	 */
	public void setToolTipText(String toolTipText)
	{
		putValue(Action.SHORT_DESCRIPTION, toolTipText);
	}
	
	/**
	 * Gets the icon.
	 * @return the instance of Icon
	 */
	public Icon getIcon()
	{
		return (Icon) getValue(Action.SMALL_ICON);
	}
	
	/**
	 * Sets the icon.
	 * @param icon the instance of Icon.
	 */
	public void setIcon(Icon icon)
	{
		putValue(Action.SMALL_ICON, icon);
	}
	
	/**
	 * Gets the small icon.
	 * @return the small icon
	 */
	public Icon getSmallIcon()
	{
		return smallIcon;
	}

	/**
	 * Sets the small icon.
	 * @param smallIcon the small icon
	 */
	public void setSmallIcon(Icon smallIcon)
	{
		this.smallIcon = smallIcon;
	}

	/**
	 * Gets the large icon.
	 * @return the large icon
	 */
	public Icon getLargeIcon()
	{
		return largeIcon;
	}

	/**
	 * Sets the large icon.
	 * @param largeIcon the large icon
	 */
	public void setLargeIcon(Icon largeIcon)
	{
		this.largeIcon = largeIcon;
	}
	
	/**
	 * Shows the text by a show value.
	 * @param showValue the show value
	 */
	public void showIcon(int showValue)
	{		
		switch (showValue)
		{
			case SHOW_SMALL : 
			{
				setIcon(smallIcon);
				break;
			}
			case SHOW_LARGE : 
			{
				setIcon(largeIcon);
				break;
			}
			case SHOW_NO : 
			{
				setIcon(null);
				break;
			}
		}
	}
	
	/**
	 * Gets the source object.
	 * @return the source object
	 */
	public Object getSource()
	{
		return source;
	}

	/**
	 * Sets the source object.
	 * @param source the source object
	 */
	public void setSource(Object source)
	{
		this.source = source;
	}
	
	/**
	 * To string.
	 * @return the string
	 */
	public String toString()
	{
		return getValue(Action.NAME).toString();
	}
}