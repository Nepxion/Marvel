package com.nepxion.swing.style.button.flat;

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

import com.nepxion.swing.button.IButtonModel;
import com.nepxion.swing.style.button.IButtonStyle;

public class FlatSplitButtonUI
	extends FlatMenuButtonUI
{
	/**
	 * The identity value.
	 */
	public static final String ID = FlatSplitButtonUI.class.getName();
	
	/**
	 * Constructs with the default.
	 */
	public FlatSplitButtonUI()
	{
		this(new JFlatButtonStyle());
	}
	
	/**
	 * Constructs with the specified initial button style.
	 * @param buttonStyle the instance of IButtonStyle
	 */
	public FlatSplitButtonUI(IButtonStyle buttonStyle)
	{
		super(buttonStyle);
	}
	
	/**
	 * Paints the menu drop down ui.
	 * @param buttonModel the instance of IButtonModel
	 * @param g the instance of Graphics
	 * @param c the instance of JComponent
	 */
	public void paintMenuDropDown(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		g.setColor(brightColor);
		g.drawLine(0, 0, c.getWidth() - 12, 0); // top
		g.drawLine(0, 0, 0, c.getHeight() - 1); // left
		g.drawLine(c.getWidth() - 12, c.getHeight() - 1, c.getWidth() - 1, c.getHeight() - 1); // bottom
		g.drawLine(c.getWidth() - 1, 0, c.getWidth() - 1, c.getHeight() - 1); // right
		
		g.setColor(darkColor);
		g.drawLine(0, c.getHeight() - 1, c.getWidth() - 12, c.getHeight() - 1); // bottom
		g.drawLine(c.getWidth() - 12, -1, c.getWidth() - 12, c.getHeight() - 2); // center
		g.drawLine(c.getWidth() - 12, 0, c.getWidth() - 2, 0); // top
		g.drawLine(c.getWidth() - 11, -1, c.getWidth() - 11, c.getHeight() - 2); // center
	}
	
	/**
	 * Paints the pressed ui.
	 * @param buttonModel the instance of IButtonModel
	 * @param g the instance of Graphics
	 * @param c the instance of JComponent
	 */
	public void paintPressed(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		g.setColor(darkColor);
		g.drawLine(0, 0, c.getWidth() - 1, 0); // top
		g.drawLine(0, 0, 0, c.getHeight() - 1); // left
		g.drawLine(c.getWidth() - 11, -1, c.getWidth() - 11, c.getHeight() - 2); // center
		
		g.setColor(brightColor);
		g.drawLine(0, c.getHeight() - 1, c.getWidth() - 1, c.getHeight() - 1); // bottom
		g.drawLine(c.getWidth() - 1, 0, c.getWidth() - 1, c.getHeight() - 1); // right
		g.drawLine(c.getWidth() - 12, -1, c.getWidth() - 12, c.getHeight() - 2); // center
	}
	
	/**
	 * Paints the selected ui.
	 * @param buttonModel the instance of IButtonModel
	 * @param g the instance of Graphics
	 * @param c the instance of JComponent
	 */
	public void paintSelected(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		paintPressed(buttonModel, g, c);
	}
	
	/**
	 * Paints the roll over ui.
	 * @param buttonModel the instance of IButtonModel
	 * @param g the instance of Graphics
	 * @param c the instance of JComponent
	 */
	public void paintRollover(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		g.setColor(brightColor);
		g.drawLine(0, 0, c.getWidth() - 1, 0); // top
		g.drawLine(0, 0, 0, c.getHeight() - 1); // left
		g.drawLine(c.getWidth() - 11, -1, c.getWidth() - 11, c.getHeight() - 2); // center
		
		g.setColor(darkColor);
		g.drawLine(0, c.getHeight() - 1, c.getWidth() - 1, c.getHeight() - 1); // bottom
		g.drawLine(c.getWidth() - 1, 0, c.getWidth() - 1, c.getHeight() - 1); // right
		g.drawLine(c.getWidth() - 12, -1, c.getWidth() - 12, c.getHeight() - 2); // center
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
		textRect.x -= 1;
		
		super.paintText(g, c, textRect, text);
	}
	
	/**
	 * Paints the icon.
	 * @param g the instance of Graphics
	 * @param c the instance of JComponent
	 * @param iconRect the instance of Rectangle
	 */
	protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect)
	{
		iconRect.x -= 1;
		
		super.paintIcon(g, c, iconRect);
	}
}