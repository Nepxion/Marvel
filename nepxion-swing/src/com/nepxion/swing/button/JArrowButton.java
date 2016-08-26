package com.nepxion.swing.button;

import java.awt.Dimension;

import javax.swing.JButton;

import com.nepxion.swing.icon.paint.ArrowIcon;

public class JArrowButton
	extends JButton
{
	/**
	 * Constructs with the default.
	 */
	public JArrowButton()
	{
		super(new ArrowIcon(5, ArrowIcon.SOUTH));
		
		setPreferredSize(new Dimension(17, getPreferredSize().height));
		setFocusPainted(false);
	}
}