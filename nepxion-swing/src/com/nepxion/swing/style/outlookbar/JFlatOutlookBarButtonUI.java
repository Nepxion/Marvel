package com.nepxion.swing.style.outlookbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

public class JFlatOutlookBarButtonUI
	extends BasicButtonUI
{
	/**
	 * The indent value.
	 */
	private int indent = 0;
	
	/**
	 * Constructs with the default.
	 */
	public JFlatOutlookBarButtonUI()
	{
		
	}
	
	/**
	 * Gets the indent.
	 * @return the indent value
	 */
	public int getIndent()
	{
		return indent;
	}
	
	/**
	 * Sets the indent.
	 * @param indent the indent value
	 */
	public void setIndent(int indent)
	{
		this.indent = indent;
	}
	
	/**
	 * Paints the text.
	 * @param g the instance of Graphics
	 * @param c the instance of JComponent
	 * @param textRect the instance of Rectangle
	 * @param text the text string
	 */
	protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text)
	{
		Rectangle rect = new Rectangle(textRect.x + indent, textRect.y, textRect.width, textRect.height);
		
		super.paintText(g, c, rect, text);
	}
	
	/**
	 * Paints the icon.
	 * @param g the instance of Graphics
	 * @param c the instance of JComponent
	 * @param iconRect the instance of Rectangle
	 */
	protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect)
	{
		Rectangle rect = new Rectangle(iconRect.x + indent, iconRect.y, iconRect.width, iconRect.height);
		
		super.paintIcon(g, c, rect);
	}
}