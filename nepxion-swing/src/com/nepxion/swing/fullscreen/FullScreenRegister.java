package com.nepxion.swing.fullscreen;

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
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JMenuItem;

public class FullScreenRegister
	extends MouseAdapter implements ActionListener
{
	/**
	 * The instance of FullScreenSupport.
	 */
	private FullScreenSupport fullScreenSupport;
	
	/**
	 * The button list.
	 */
	private List buttons;
	
	/**
	 * Constructs with the specified initial fullscreen support.
	 * @param fullScreenSupport the instance of FullScreenSupport
	 */
	public FullScreenRegister(FullScreenSupport fullScreenSupport)
	{
		this.fullScreenSupport = fullScreenSupport;
		
		buttons = new ArrayList();
	}
	
	/**
	 * Registers the component.
	 * @param component the instance of Component
	 */
	public void register(Component component)
	{
		if (component != null)
		{
			component.addMouseListener(this);
		}
	}
	
	/**
	 * Registers the button.
	 * @param button the instance of AbstractButton
	 */
	public void register(AbstractButton button)
	{
		if (button != null)
		{
			button.addActionListener(this);
			buttons.add(button);
		}
	}
	
	/**
	 * Toggles the fullscreen facade.
	 */
	public void toggleFullScreen()
	{
		for (Iterator iterator = buttons.iterator(); iterator.hasNext();)
		{
			AbstractButton button = (AbstractButton) iterator.next();
			adaptButtonFacade(button);
		}
		fullScreenSupport.toggleFullScreen();
	}

	/**
	 * Adapts the button facade.
	 * @param button the instance of AbstractButton
	 */
	private void adaptButtonFacade(AbstractButton button)
	{
		String text = null;
		Icon icon = null;
		boolean selected = false;

		if (fullScreenSupport.isFullScreen())
		{
			text = FullScreenConstants.TEXT_MAXIMIZE;
			icon = FullScreenConstants.ICON_MAXIMIZE;
			selected = false;
		}
		else
		{
			text = FullScreenConstants.TEXT_RESTORE;
			icon = FullScreenConstants.ICON_MAXIMIZE_RESTORE;
			selected = true;
		}
		
		if (button instanceof JMenuItem)
		{
			button.setSelected(selected);
		}	
		else
		{
			if (!button.getText().equals(""))
			{
				button.setText(text);
			}
			if (button.getIcon() != null)
			{
				button.setIcon(icon);
			}
			button.setToolTipText(text);
		}		
	}
    
	/**
	 * Invoked when the mouse button has been clicked (pressed and released) on a component.
	 * @param e the instance of MouseEvent
	 */
	public void mouseClicked(MouseEvent e)
	{
		if (e.getClickCount() > 1)
		{
			toggleFullScreen();
		}
	}
	
	/**
	 * Invoked when an action occurs.
	 * @param e the instance of ActionEvent
	 */
	public void actionPerformed(ActionEvent e)
	{
		toggleFullScreen();
	}
}