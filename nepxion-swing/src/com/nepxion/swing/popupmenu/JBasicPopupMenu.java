package com.nepxion.swing.popupmenu;

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
import java.awt.Insets;

import javax.swing.JPopupMenu;

import com.nepxion.swing.container.ContainerManager;
import com.nepxion.swing.style.framework.IStyle;

public class JBasicPopupMenu
	extends JPopupMenu
{
	/**
	 * The instance of PopupMenuPainter.
	 */
	private PopupMenuPainter painter;
	
	/**
	 * Constructs with the default.
	 */
	public JBasicPopupMenu()
	{
		this(PopupMenuContext.getTitle());
	}
	
	/**
	 * Constructs with the specified initial painter.
	 * @param painter the instance of PopupMenuPainter
	 */
	public JBasicPopupMenu(PopupMenuPainter painter)
	{
		setPainter(painter);
	}
	
	/**
	 * Constructs with the specified initial title.
	 * @param title the title string
	 */
	public JBasicPopupMenu(String title)
	{
		setTitle(title);
	}
	
	/**
	 * Constructs with the specified initial style.
	 * @param style the instance of IStyle
	 */
	public JBasicPopupMenu(IStyle style)
	{
		setStyle(style);
	}
	
	/**
	 * Gets the painter.
	 * @return the instance of PopupMenuPainter
	 */
	public PopupMenuPainter getPainter()
	{
		return painter;
	}
	
	/**
	 * Sets the painter.
	 * @param painter the instance of PopupMenuPainter
	 */
	public void setPainter(PopupMenuPainter painter)
	{
		this.painter = painter;
		this.painter.setPopupMenu(this);
		
		PopupMenuManager.setPreferenceStyle(this);
		
		ContainerManager.update(this);
	}
	
	/**
	 * Gets the title.
	 * @return the title string
	 */
	public String getTitle()
	{
		return painter.getTitle();
	}
	
	/**
	 * Sets the title.
	 * @param title the title string
	 */
	public void setTitle(String title)
	{
		PopupMenuPainter painter = new PopupMenuPainter(title);
		setPainter(painter);
	}
	
	/**
	 * Sets the style.
	 * @param style the instance of IStyle
	 */
	public void setStyle(IStyle style)
	{
		PopupMenuPainter painter = new PopupMenuPainter(style);
		setPainter(painter);
	}
	
	/**
	 * Gets the insets.
	 * @return the instance of Insets
	 */
	public Insets getInsets()
	{
		Insets insets = super.getInsets();
		
		if (painter != null)
		{
			return painter.getInsets((Insets) insets.clone());
		}
		else
		{
			return insets;
		}
	}
	
	/**
	 * Paints the component.
	 * @param g the instance of Graphics
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if (painter != null)
		{
			painter.paintComponent(g);
		}
	}
}