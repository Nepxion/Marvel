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

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JPopupMenu;

public class JDropDownPopupMenu
	extends JPopupMenu implements IDropDownPopupMenu
{
	/**
	 * The owner.
	 */
	private Component owner;
	
	private Component renderer;
	
	private AbstractButton button;
	
	private int width = -1;
	private int height = -1;
	
	public void registerOwner(Component owner)
	{
		this.owner = owner;
	}
	
	public void registerDropDownPane(IDropDownPane dropDownPane)
	{
		removeAll();
		
		setLayout(new BorderLayout());
		add((Container) dropDownPane, BorderLayout.CENTER);
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
		if (isVisible())
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
		show(renderer, 0, renderer.getSize().height);
	}
	
	public void hidePopupMenu()
	{
		setVisible(false);
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