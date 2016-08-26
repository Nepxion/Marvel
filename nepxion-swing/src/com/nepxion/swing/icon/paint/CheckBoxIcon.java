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

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class CheckBoxIcon
	implements Icon
{
	/**
	 * The background icon.
	 */
	private Icon backgroundIcon;
	
	/**
	 * The check color.
	 */
	private Color checkColor;
	
	/**
	 * The focus color.
	 */
	private Color focusColor;
	
	/**
	 * The boolean value of selected.
	 */
	private boolean selected;
	
	/**
	 * The boolean value of focused.
	 */
	private boolean focused;
	
	/**
	 * The boolean value of innerBorder.
	 */
	private boolean innerBorder;
	
	/**
	 * Constructs with the specified initial background icon, check color, focus color, selected and focused.
	 * @param backgroundIcon the background icon
	 * @param checkColor the check color
	 * @param focusColor the focus color
	 * @param selected the boolean value of selected
	 * @param focused the boolean value of focused
	 * @param innerBorder the boolean value of innerBorder
	 */
	public CheckBoxIcon(Icon backgroundIcon, Color checkColor, Color focusColor, boolean selected, boolean focused, boolean innerBorder)
	{
		this.backgroundIcon = backgroundIcon;
		this.checkColor = checkColor;
		this.focusColor = focusColor;
		this.selected = selected;
		this.focused = focused;
		this.innerBorder = innerBorder;
	}
		
	/**
	 * Gets the background icon.
	 * @return the background icon
	 */
	public Icon getBackgroundIcon()
	{
		return backgroundIcon;
	}
	
	/**
	 * Gets the check color.
	 * @return the check color.
	 */
	public Color getCheckColor()
	{
		return checkColor;
	}
	
	/**
	 * Gets the focus color.
	 * @return the focus color
	 */
	public Color getFocusColor()
	{
		return focusColor;
	}
	
	/**
	 * Returns true if selected.
	 * @return true if selected
	 */
	public boolean isSelected()
	{
		return selected;
	}
	
	/**
	 * Returns true if focused.
	 * @return true if focused
	 */
	public boolean isFocused()
	{
		return focused;
	}
	
	/**
	 * Returns true if the inner border shown.
	 * @return true if the inner border shown
	 */
	public boolean isInnerBorder()
	{
		return innerBorder;
	}
	
	/**
	 * Gets the icon width.
	 * @return the icon width value.
	 */
	public int getIconWidth()
	{
		return backgroundIcon.getIconWidth();
	}
	
	/**
	 * Gets the icon height.
	 * @return the icon height value.
	 */
	public int getIconHeight()
	{
		return backgroundIcon.getIconHeight();
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
		if (backgroundIcon != null)
		{
			backgroundIcon.paintIcon(c, g, x, y);
		}
		
		if (selected)
		{
			g.setColor(checkColor);
			
			g.drawLine(x + 4, y + 6, x + 4, y + 8);
			g.drawLine(x + 5, y + 7, x + 5, y + 9);
			g.drawLine(x + 6, y + 8, x + 6, y + 10);
			g.drawLine(x + 7, y + 7, x + 7, y + 9);
			g.drawLine(x + 8, y + 6, x + 8, y + 8);
			g.drawLine(x + 9, y + 5, x + 9, y + 7);
			g.drawLine(x + 10, y + 4, x + 10, y + 6);
		}
		
		if (focused && innerBorder)
		{
			g.setColor(focusColor);
			g.drawRect(x + 2, y + 2, 10, 10);
		}
	}
}