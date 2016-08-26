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

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.border.Border;

import com.l2fprod.common.swing.JTaskPaneGroup;
import com.nepxion.swing.font.FontContext;

public class JTaskGroup
	extends JTaskPaneGroup
{
	/**
	 * Constructs with the default.
	 */
	public JTaskGroup()
	{
	}
	
	/**
	 * Constructs with the specified initial title.
	 * @param title the title string
	 */
	public JTaskGroup(String title)
	{
		this(title, (String) null);
	}
	
	/**
	 * Constructs with the specified initial title and tooltip text.
	 * @param title the title string
	 * @param toolTipText the tooltip text string
	 */
	public JTaskGroup(String title, String toolTipText)
	{
		this(title, null, toolTipText);
	}
	
	/**
	 * Constructs with the specified initial title and icon.
	 * @param title the title string
	 * @param icon the instance of Icon
	 */
	public JTaskGroup(String title, Icon icon)
	{
		this(title, icon, null);
	}
	
	/**
	 * Constructs with the specified initial title, icon and tooltip text.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JTaskGroup(String title, Icon icon, String toolTipText)
	{
		this(title, icon, toolTipText, FontContext.getFont());
	}
	
	/**
	 * Constructs with the specified initial title, icon, tooltip text and font.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param font the instance of Font
	 */
	public JTaskGroup(String title, Icon icon, String toolTipText, Font font)
	{
		if (title != null)
		{
			setTitle(title);
		}
		
		if (icon != null)
		{
			setIcon(icon);
		}
		
		if (toolTipText != null)
		{
			setToolTipText(toolTipText);
		}
		
		if (font != null)
		{
			setFont(font);
		}
	}
	
	/**
	 * Sets the content pane border.
	 * @param border the instance of Border
	 */
	public void setContentPaneBorder(Border border)
	{
		JComponent component = (JComponent) getContentPane();
		component.setBorder(BorderFactory.createCompoundBorder(component.getBorder(), border));
	}
}