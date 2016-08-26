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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

import com.nepxion.swing.button.IButtonModel;
import com.nepxion.swing.style.button.AbstractButtonUI;
import com.nepxion.swing.style.button.IButtonStyle;

public class FlatButtonUI
	extends AbstractButtonUI
{
	/**
	 * The identity value.
	 */
	public static final String ID = FlatButtonUI.class.getName();
	
	/**
	 * The bright color.
	 */
	protected Color brightColor;
	
	/**
	 * The dark color.
	 */
	protected Color darkColor;
	
	/**
	 * The flat button style.
	 */
	protected IFlatButtonStyle buttonStyle;
	
	/**
	 * Constructs with the default.
	 */
	public FlatButtonUI()
	{
		this(new JFlatButtonStyle());
	}
	
	/**
	 * Constructs with the specified initial button style.
	 * @param buttonStyle the instance of IButtonStyle
	 */
	public FlatButtonUI(IButtonStyle buttonStyle)
	{
		setButtonStyle(buttonStyle);
		setArrowPainted(false);
	}
	
	/**
	 * Gets the button style.
	 * @return the instance of IButtonStyle
	 */
	public IButtonStyle getButtonStyle()
	{
		return buttonStyle;
	}
	
	/**
	 * Sets the button style.
	 * @param buttonStyle the instance of IButtonStyle
	 */
	public void setButtonStyle(IButtonStyle buttonStyle)
	{
		this.buttonStyle = (IFlatButtonStyle) buttonStyle;
		
		brightColor = this.buttonStyle.getBrightColor();
		darkColor = this.buttonStyle.getDarkColor();
	}
	
	/**
	 * Paints the menu drop down ui.
	 * @param buttonModel the instance of IButtonModel
	 * @param g the instance of Graphics
	 * @param c the instance of JComponent
	 */
	public void paintMenuDropDown(IButtonModel buttonModel, Graphics g, JComponent c)
	{
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
		
		g.setColor(brightColor);
		g.drawLine(0, c.getHeight() - 1, c.getWidth() - 1, c.getHeight() - 1); // bottom
		g.drawLine(c.getWidth() - 1, 0, c.getWidth() - 1, c.getHeight() - 1); // right
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
		
		g.setColor(darkColor);
		g.drawLine(0, c.getHeight() - 1, c.getWidth() - 1, c.getHeight() - 1); // bottom
		g.drawLine(c.getWidth() - 1, 0, c.getWidth() - 1, c.getHeight() - 1); // right
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
		if (c.getWidth() % 2 != 0)
		{
			textRect.x += 1;
		}
		if (c.getHeight() % 2 != 0)
		{
			textRect.y += 1;
		}
		
		textRect.x += getWidthOffset();
		textRect.y += getHeightOffset();
		
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
		if (c.getWidth() % 2 != 0)
		{
			iconRect.x += 1;
		}
		if (c.getHeight() % 2 != 0)
		{
			iconRect.y += 1;
		}
		
		iconRect.x += getWidthOffset();
		iconRect.y += getHeightOffset();
		
		super.paintIcon(g, c, iconRect);
	}
}