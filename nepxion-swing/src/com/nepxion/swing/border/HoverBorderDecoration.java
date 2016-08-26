package com.nepxion.swing.border;

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
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class HoverBorderDecoration
	extends MouseAdapter
{
	/**
	 * The hover background color.
	 */
	private Color hoverBackground;
	
	/**
	 * The background color.
	 */
	private Color background;
	
	/**
	 * The hover border color.
	 */
	private Color hoverBorderColor;
	
	/**
	 * The border color.
	 */
	private Color borderColor;
	
	/**
	 * The hover border.
	 */
	private Border hoverBorder;
	
	/**
	 * The border.
	 */
	private Border border;
	
	/**
	 * The instance of JComponent.
	 */
	private JComponent component;
	
	/**
	 * Constructs with the specified initial component.
	 * @param component the instance of JComponent
	 */
	public HoverBorderDecoration(JComponent component)
	{
		this.component = component;
		
		background = component.getBackground();
		hoverBackground = new Color(255, 255, 225);
		
		borderColor = new Color(125, 125, 125, 100);
		hoverBorderColor = new Color(215, 215, 215, 255);
		
		border = BorderFactory.createCompoundBorder(new LineBorder(borderColor, 1), new EmptyBorder(new Insets(2, 2, 2, 2)));
		hoverBorder = new HoverBorder(hoverBorderColor, 3);
		
		component.setBorder(border);
		component.setBackground(background);
		component.addMouseListener(this);
	}
	
	/**
	 * Invoked when the mouse enters a component.
	 * @param e the instance of MouseEvent
	 */
	public void mouseEntered(MouseEvent e)
	{
		component.setBorder(hoverBorder);
		component.setBackground(hoverBackground);
		component.repaint();
	}
	
	/**
	 * Invoked when the mouse exits a component.
	 * @param e the instance of MouseEvent
	 */
	public void mouseExited(MouseEvent e)
	{
		component.setBorder(border);
		component.setBackground(background);
		component.repaint();
	}
}