package com.nepxion.swing.icon.paint;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.Icon;

import com.nepxion.swing.lookandfeel.LookAndFeelManager;

public class CloseTabIcon
	implements Icon
{
	/**
	 * The x value.
	 */
	private int x;
	
	/**
	 * The y value.
	 */
	private int y;
	
	/**
	 * The width value.
	 */
	private int width;
	
	/**
	 * The height value.
	 */
	private int height;
	
	/**
	 * The boolean value of isHint.
	 */
	private boolean isHint = false;
	
	/**
	 * The close icon.
	 */
	private CloseIcon closeIcon;
	
	/**
	 * The icon.
	 */
	private Icon icon;
	
	/**
	 * Constructs with the specified initial icon.
	 * The icon is a user icon.
	 * @param icon the instance of icon
	 */
	public CloseTabIcon(Icon icon)
	{
		this(icon, true, true, false);
	}
	
	/**
	 * Constructs with the specified initial icon, isDrawBorder, isDrawCenter, isHint.
	 * The icon is a user icon.
	 * @param icon the instance of icon
	 * @param isDrawBorder the boolean value of isDrawBorder
	 * @param isDrawCenter the boolean value of isDrawCenter
	 * @param isHint the boolean value of isHint
	 */
	public CloseTabIcon(Icon icon, boolean isDrawBorder, boolean isDrawCenter, boolean isHint)
	{
		this.icon = icon;
		this.closeIcon = new CloseIcon(isDrawBorder, isDrawCenter);
		this.isHint = isHint;
		
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			width = closeIcon.getIconWidth() + 4;
			height = closeIcon.getIconHeight();
		}
		else
		{
			width = closeIcon.getIconWidth() + 4;
			height = closeIcon.getIconHeight() + 2;
		}
	}
	
	/**
	 * Gets the close icon.
	 * @return the instance of CloseIcon
	 */
	public CloseIcon getCloseIcon()
	{
		return closeIcon;
	}
	
	/**
	 * Gets the icon.
	 * @return the instance of Icon
	 */
	public Icon getIcon()
	{
		return icon;
	}
	
	/**
	 * Returns true if hint.
	 * @return true if hint
	 */
	public boolean isHint()
	{
		return isHint;
	}
	
	/**
	 * Sets the hint.
	 * @param isHint the boolean value of isHint
	 */
	public void setHint(boolean isHint)
	{
		this.isHint = isHint;
	}
	
	/**
	 * Gets the bounds.
	 * @return the instance of Rectangle
	 */
	public Rectangle getBounds()
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			return new Rectangle(x + 4, y, closeIcon.getIconWidth(), closeIcon.getIconHeight());
		}
		else
		{
			return new Rectangle(x, y, closeIcon.getIconWidth(), closeIcon.getIconHeight());
		}
	}
	
	/**
	 * Gets the icon width.
	 * @return the icon width value.
	 */
	public int getIconWidth()
	{
		return width + (icon != null ? icon.getIconWidth() : 0);
	}
	
	/**
	 * Gets the icon height.
	 * @return the icon height value.
	 */
	public int getIconHeight()
	{
		return height;
	}
	
	/**
	 * Paints the icon.
	 * @param c the instance of Component
	 * @param g the instance of Graphics
	 * @param x the x value
	 * @param y the y value
	 */
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		this.x = x;
		this.y = y;
		
		if (closeIcon != null)
		{
			if (LookAndFeelManager.isNimbusLookAndFeel())
			{
				closeIcon.paintIcon(c, g, x + 4, y);
			}
			else
			{
				closeIcon.paintIcon(c, g, x, y);
			}
		}
		
		if (icon != null)
		{
			if (LookAndFeelManager.isNimbusLookAndFeel())
			{
				icon.paintIcon(c, g, x + width + 4, y);
			}
			else
			{
				icon.paintIcon(c, g, x + width, y);
			}
		}
	}
}