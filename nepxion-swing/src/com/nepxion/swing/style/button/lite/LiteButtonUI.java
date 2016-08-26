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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

import com.nepxion.swing.button.IButtonModel;
import com.nepxion.swing.style.button.AbstractButtonUI;
import com.nepxion.swing.style.button.IButtonStyle;

public class LiteButtonUI
	extends AbstractButtonUI
{
	/**
	 * The identity value.
	 */
	public static final String ID = LiteButtonUI.class.getName();
	
	/**
	 * The roll over background.
	 */
	protected Color rolloverBackground;
	
	/**
	 * The roll over border color.
	 */
	protected Color rolloverBorderColor;
	
	/**
	 * The selection background.
	 */
	protected Color selectionBackground;
	
	/**
	 * The selection border color.
	 */
	protected Color selectionBorderColor;
	
	/**
	 * The lite button style.
	 */
	protected ILiteButtonStyle buttonStyle;
	
	/**
	 * Constructs with the specified initial button style.
	 * @param buttonStyle the instance of IButtonStyle
	 */
	public LiteButtonUI(IButtonStyle buttonStyle)
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
		this.buttonStyle = (ILiteButtonStyle) buttonStyle;
		
		this.rolloverBackground = this.buttonStyle.getRolloverBackground();
		this.rolloverBorderColor = this.buttonStyle.getRolloverBorderColor();
		this.selectionBackground = this.buttonStyle.getSelectionBackground();
		this.selectionBorderColor = this.buttonStyle.getSelectionBorderColor();
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
		g.setColor(selectionBackground);
		g.fillRect(0, 0, c.getWidth() - 1, c.getHeight() - 1);
		
		g.setColor(selectionBorderColor);
		g.drawRect(0, 0, c.getWidth() - 1, c.getHeight() - 1);
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
		g.setColor(rolloverBackground);
		g.fillRect(0, 0, c.getWidth() - 1, c.getHeight() - 1);
		
		g.setColor(rolloverBorderColor);
		g.drawRect(0, 0, c.getWidth() - 1, c.getHeight() - 1);
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