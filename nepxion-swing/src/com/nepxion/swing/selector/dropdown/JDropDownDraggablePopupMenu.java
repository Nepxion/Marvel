package com.nepxion.swing.selector.dropdown;

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
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

import com.nepxion.swing.popupmenu.JDraggablePopupMenu;

public class JDropDownDraggablePopupMenu
	extends JDraggablePopupMenu implements IDropDownPopupMenu
{
	/**
	 * The owner.
	 */
	private Component owner;
	
	private Component renderer;
	
	private AbstractButton button;
	
	private int width = -1;
	private int height = -1;
	
	/**
	 * Constructs with the default.
	 */
	public JDropDownDraggablePopupMenu()
	{
		super();
	}
	
	public void registerOwner(Component owner)
	{
		this.owner = owner;
	}
	
	public void registerDropDownPane(IDropDownPane dropDownPane)
	{
		setContentPane((Container) dropDownPane);
	}
	
	public void registerRenderer(Component renderer)
	{
		this.renderer = renderer;
	}
	
	public void registerButton(final AbstractButton button)
	{
		this.button = button;
		this.button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				adaptVisibility();
			}
		}
		);
	}
	
	public void adaptVisibility()
	{
		if (isPopupVisible())
		{
			hidePopupMenu();
		}
		else
		{
			showPopupMenu();
		}
	}
	
	public void showPopupMenu()
	{
		setPreferredSize(new Dimension(getPopupMenuWidth(), getPopupMenuHeight()));
		showPopup(owner);
	}
	
	public void hidePopupMenu()
	{
		hidePopup();
	}
	
	private int getPopupMenuWidth()
	{
		return width != -1 ? width : owner.getSize().width;
	}
	
	public void setPopupMenuWidth(int width)
	{
		this.width = width;
	}
	
	private int getPopupMenuHeight()
	{
		return height != -1 ? height : getPreferredSize().height;
	}
	
	public void setPopupMenuHeight(int height)
	{
		this.height = height;
	}
}