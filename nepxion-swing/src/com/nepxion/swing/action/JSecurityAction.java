package com.nepxion.swing.action;

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
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.JToggleButton;

import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public abstract class JSecurityAction
	extends JAction
{
	/**
	 * The boolean value of permitted.
	 * It is mainly used for security and authentication module.
	 * If the value is false, a warning dialog will show up and action event won't be triggered.
	 */
	private boolean permitted = true;
	
	/**
	 * Constructs with the default.
	 */
	public JSecurityAction()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string
	 */
	public JSecurityAction(String text)
	{
		super(text);
	}
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of Icon
	 */
	public JSecurityAction(Icon icon)
	{
		super(icon);
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string
	 * @param icon the instance of Icon
	 */
	public JSecurityAction(String text, Icon icon)
	{
		super(text, icon);
	}
	
	/**
	 * Constructs with the specified initial text and tooltip text.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JSecurityAction(String text, String toolTipText)
	{
		super(text, toolTipText);
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JSecurityAction(Icon icon, String toolTipText)
	{
		super(icon, toolTipText);
	}

	/**
	 * Constructs with the specified initial text, icon and tooltip text.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JSecurityAction(String text, Icon icon, String toolTipText)
	{
		super(text, icon, toolTipText);
	}
	
	/**
	 * Constructs with the specified initial name, text and tooltip text.
	 * @param name the name string
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JSecurityAction(String name, String text, String toolTipText)
	{
		super(name, text, toolTipText);
	}
	
	/**
	 * Constructs with the specified initial name, text, icon and tooltip text.
	 * @param name the name string
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JSecurityAction(String name, String text, Icon icon, String toolTipText)
	{
		super(name, text, icon, toolTipText);
	}
	
	/**
	 * Returns the boolean value of isPermitted.
	 * @return the boolean value of isPermitted
	 */
	public boolean isPermitted()
	{
		return permitted;
	}
	
	/**
	 * Sets the the boolean value of isPermitted.
	 * @param isPermitted the boolean value of permitted
	 */
	public void setPermitted(boolean permitted)
	{
		this.permitted = permitted;
	}
	
	/**
	 * Invoked when an action occurs.
	 * It is overridden from Action and judge if isPermitted is false the action event won't be triggered.
	 * @param e the instance of ActionEvent
	 */
	public void actionPerformed(ActionEvent e)
	{
		if (isPermitted())
		{
			execute(e);
		}
		else
		{
			Object resource = e.getSource();
			if (resource instanceof Component) // 宿主是JComponent或者AbstractButton
			{
				Component component = (Component) resource;
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame(component), SwingLocale.getString("access_denied"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
				if (resource instanceof JToggleButton)
				{
					JToggleButton button = (JToggleButton) component;
					button.getModel().setSelected(!button.getModel().isSelected()); // 对ToggleButton的判断
				}
			}
		}
	}
	
	/**
	 * Invoked when an action occurs.
	 * @param e the instance of ActionEvent
	 */
	public abstract void execute(ActionEvent e);
}