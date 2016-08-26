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

import javax.swing.Icon;

public class CombinationIcon
	implements Icon
{
	/**
	 * The small icon.
	 */
	private Icon smallIcon;
	
	/**
	 * The small icon x value.
	 */
	private int smallIconX = -1;
	
	/**
	 * The small icon y value.
	 */
	private int smallIconY = -1;
	
	/**
	 * The large icon.
	 */
	private Icon largeIcon;
	
	/**
	 * The large icon x value.
	 */
	private int largeIconX = -1;
	
	/**
	 * The large icon y value.
	 */
	private int largeIconY = -1;
	
	/**
	 * The x offset value.
	 */
	private int xOffset;
	
	/**
	 * The y offset value.
	 */
	private int yOffset;
	

	/**
	 * Constructs with the specified initial small icon, large icon, x offset and y offset.
	 * The small icon will be painted at the center of the large icon.
	 * @param smallIcon the small icon
	 * @param largeIcon the large icon
	 * @param xOffset the x offset value
	 * @param yOffset the y offset value
	 */
	public CombinationIcon(Icon smallIcon, Icon largeIcon, int xOffset, int yOffset)
	{
		this.smallIcon = smallIcon;
		this.largeIcon = largeIcon;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	/**
	 * Constructs with the specified initial small icon, small icon x position, small icon y position, large icon, large icon x position and large icon y position.
	 * The icon x position and y position are the started positions of painting.
	 * @param smallIcon the small icon
	 * @param smallIconX the small icon x position
	 * @param smallIconY the small icon y position
	 * @param largeIcon the large icon
	 * @param largeIconX the large icon x position
	 * @param largeIconY the large icon y position
	 */
	public CombinationIcon(Icon smallIcon, int smallIconX, int smallIconY, Icon largeIcon, int largeIconX, int largeIconY)
	{
		this.smallIcon = smallIcon;
		this.smallIconX = smallIconX;
		this.smallIconY = smallIconY;
		
		this.largeIcon = largeIcon;
		this.largeIconX = largeIconX;
		this.largeIconY = largeIconY;
	}
	
	/**
	 * Gets the small icon.
	 * @return the instance of Icon
	 */
	public Icon getSmallIcon()
	{
		return smallIcon;
	}

	/**
	 * Gets the small icon.
	 * @param smallIcon the instance of Icon
	 */
	public void setSmallIcon(Icon smallIcon)
	{
		this.smallIcon = smallIcon;
	}

	/**
	 * Gets the large icon.
	 * @return the instance of Icon
	 */
	public Icon getLargeIcon()
	{
		return largeIcon;
	}

	/**
	 * Sets the large icon.
	 * @param largeIcon the instance of Icon
	 */
	public void setLargeIcon(Icon largeIcon)
	{
		this.largeIcon = largeIcon;
	}
		
	/**
	 * Gets the icon width.
	 * @return the icon width value.
	 */
	public int getIconWidth()
	{
		return largeIcon.getIconWidth();
	}
	
	/**
	 * Gets the icon height.
	 * @return the icon height value.
	 */
	public int getIconHeight()
	{
		return largeIcon.getIconHeight();
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
		if (largeIcon != null && smallIcon != null)
		{	
			if (smallIconX == -1 || smallIconY == -1 || largeIconX == -1 || largeIconY == -1)
			{	
				largeIcon.paintIcon(c, g, x, y);
				smallIcon.paintIcon(c, g, x + getIconWidth() / 2 - smallIcon.getIconWidth() / 2 + xOffset, y + getIconHeight() / 2 - smallIcon.getIconHeight() / 2 + yOffset);
			}
			else
			{
				largeIcon.paintIcon(c, g, x + largeIconX, y + largeIconY);
				smallIcon.paintIcon(c, g, x + smallIconX, y + smallIconY);
			}
		}
	}
}