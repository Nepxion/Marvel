package com.nepxion.swing.button;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.SwingUtilities;

public class JBasicSplitButton
	extends JBasicMenuButton
{
	/**
	 * Constructs with the default.
	 */
	public JBasicSplitButton()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial action.
	 * @param action the instance of Action
	 */
	public JBasicSplitButton(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string
	 */
	public JBasicSplitButton(String text)
	{
		super(text);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of Icon
	 */
	public JBasicSplitButton(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string
	 * @param icon the icon of Icon
	 */
	public JBasicSplitButton(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and tooltip text.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JBasicSplitButton(String text, String toolTipText)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JBasicSplitButton(Icon icon, String toolTipText)
	{
		super(icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string 
	 * @param icon the icon of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JBasicSplitButton(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		widthInset += 3;
	}
	
	/**
	 * Invoked when the mouse button has been pressed on a component.
	 * @param e the instance of MouseEvent
	 */
	public void mousePressed(MouseEvent e)
	{
		BasicButtonModel buttonModel = (BasicButtonModel) getModel();
		if (!buttonModel.isEnabled())
		{
			return;
		}
		
		if (SwingUtilities.isLeftMouseButton(e) && e.getX() > getSize().width - 13 && e.getX() < getSize().width)
		{
			if (popupMenu != null)
			{
				popupMenu.show(this, 0, getSize().height);
			}
			buttonModel.setActionButtonPressed(false);
		}
		else
		{
			buttonModel.setActionButtonPressed(true);
		}
	}
	
	/**
	 * Invoked when an action occurs.
	 * @param e the instance of ActionEvent
	 */
	protected void fireActionPerformed(ActionEvent e)
	{
		BasicButtonModel buttonModel = (BasicButtonModel) getModel();
		if (buttonModel.isActionButtonPressed())
		{
			super.fireActionPerformed(e);
		}
	}
}