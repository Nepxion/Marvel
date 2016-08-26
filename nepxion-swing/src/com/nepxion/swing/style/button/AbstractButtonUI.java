package com.nepxion.swing.style.button;

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

import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicButtonUI;

import com.nepxion.swing.button.IButtonModel;

public abstract class AbstractButtonUI
	extends BasicButtonUI implements IButtonUI
{
	/**
	 * The shadow color.
	 */
	private Color shadow;
	
	/**
	 * The dark shadow color.
	 */
	private Color darkShadow;
	
	/**
	 * The width offset value.
	 */
	private int widthOffset = 0;
	
	/**
	 * The height offset value.
	 */
	private int heightOffset = 0;
	
	/**
	 * The boolean value of isArrowPainted.
	 */
	protected boolean isArrowPainted = true;
	
	/**
	 * Constructs with the default.
	 */
	public AbstractButtonUI()
	{
		super();
		
		shadow = UIManager.getColor("controlShadow");
		darkShadow = Color.black;
	}
	
	/**
	 * Gets the width offset.
	 * @return the width offset value
	 */
	public int getWidthOffset()
	{
		return widthOffset;
	}
	
	/**
	 * Sets the width offset.
	 * @param widthOffset the width offset value
	 */
	public void setWidthOffset(int widthOffset)
	{
		this.widthOffset = widthOffset;
	}
	
	/**
	 * Gets the height offset.
	 * @return the height offset value
	 */
	public int getHeightOffset()
	{
		return heightOffset;
	}
	
	/**
	 * Sets the height offset.
	 * @param heightOffset the height offset value
	 */
	public void setHeightOffset(int heightOffset)
	{
		this.heightOffset = heightOffset;
	}
	
	/**
	 * Returns true if the arrow is painted.
	 * @return true if the arrow is painted
	 */
	public boolean isArrowPainted()
	{
		return isArrowPainted;
	}
	
	/**
	 * Sets the arrow painted.
	 * @param isArrowPainted the boolean value of isArrowPainted
	 */
	public void setArrowPainted(boolean isArrowPainted)
	{
		this.isArrowPainted = isArrowPainted;
	}
	
	/**
	 * Installs the ui.
	 * @param c the instance of JComponent
	 */
	public void installUI(JComponent c)
	{
		super.installUI(c);
		
		AbstractButton button = (AbstractButton) c;
		button.setRolloverEnabled(true);
		button.setBorder(BorderFactory.createEmptyBorder(1, 3, 1, 3));
	}
	
	/**
	 * Paints the ui.
	 * @param g the instance of Graphics
	 * @param c the instance of JComponent
	 */
	public void paint(Graphics g, JComponent c)
	{
		AbstractButton button = (AbstractButton) c;
		IButtonModel buttonModel = (IButtonModel) button.getModel();
		
		Action action = button.getAction();
		if (action != null)
		{
			if (!action.isEnabled())
			{
				buttonModel.setEnabled(false);
			}
		}	
		
		Color background = g.getColor();
		if (buttonModel.isMenuDropDown())
		{
			paintMenuDropDown(buttonModel, g, c);
		}
		else if (buttonModel.isPressed())
		{
			paintPressed(buttonModel, g, c);
		}
		else if (buttonModel.isSelected())
		{
			paintSelected(buttonModel, g, c);
		}
		else if (buttonModel.isRollover())
		{
			paintRollover(buttonModel, g, c);
		}
		if (isArrowPainted)
		{
			paintArrow(buttonModel, g, c);
		}
		g.setColor(background);
		
		super.paint(g, c);
	}
	
	/**
	 * Paints the menu drop down ui.
	 * @param buttonModel the instance of IButtonModel
	 * @param g the instance of Graphics
	 * @param c the instance of JComponent
	 */
	public abstract void paintMenuDropDown(IButtonModel buttonModel, Graphics g, JComponent c);
	
	/**
	 * Paints the pressed ui.
	 * @param buttonModel the instance of IButtonModel
	 * @param g the instance of Graphics
	 * @param c the instance of JComponent
	 */
	public abstract void paintPressed(IButtonModel buttonModel, Graphics g, JComponent c);
	
	/**
	 * Paints the selected ui.
	 * @param buttonModel the instance of IButtonModel
	 * @param g the instance of Graphics
	 * @param c the instance of JComponent
	 */
	public abstract void paintSelected(IButtonModel buttonModel, Graphics g, JComponent c);
	
	/**
	 * Paints the roll over ui.
	 * @param buttonModel the instance of IButtonModel
	 * @param g the instance of Graphics
	 * @param c the instance of JComponent
	 */
	public abstract void paintRollover(IButtonModel buttonModel, Graphics g, JComponent c);
	
	/**
	 * Paints the arrow ui.
	 * @param buttonModel the instance of IButtonModel
	 * @param g the instance of Graphics
	 * @param c the instance of JComponent
	 */
	public void paintArrow(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		if (buttonModel.isEnabled())
		{
			g.setColor(darkShadow);
		}
		else
		{
			g.setColor(shadow);
		}
		
		g.drawLine(c.getWidth() - 6 - 2, c.getHeight() / 2 - 1, c.getWidth() - 6 + 2, c.getHeight() / 2 - 1);
		g.drawLine(c.getWidth() - 6 - 1, c.getHeight() / 2, c.getWidth() - 6 + 1, c.getHeight() / 2);
		g.drawLine(c.getWidth() - 6, c.getHeight() / 2 + 1, c.getWidth() - 6, c.getHeight() / 2 + 1);
	}
}