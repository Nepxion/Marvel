package com.nepxion.swing.style.button.lite;

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

public class LiteMenuButtonUI
	extends LiteButtonUI
{
	/**
	 * The identity value.
	 */
	public static final String ID = LiteMenuButtonUI.class.getName();
	
	/**
	 * Constructs with the specified initial button style.
	 * @param buttonStyle the instance of IButtonStyle
	 */
	public LiteMenuButtonUI(IButtonStyle buttonStyle)
	{
		super(buttonStyle);
		
		setArrowPainted(true);
	}
	
	/**
	 * Paints the menu drop down ui.
	 * @param buttonModel the instance of IButtonModel
	 * @param g the instance of Graphics
	 * @param c the instance of JComponent
	 */
	public void paintMenuDropDown(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		paintPressed(buttonModel, g, c);
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
		textRect.x -= 4;
		
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
		iconRect.x -= 4;
		
		super.paintIcon(g, c, iconRect);
	}
}