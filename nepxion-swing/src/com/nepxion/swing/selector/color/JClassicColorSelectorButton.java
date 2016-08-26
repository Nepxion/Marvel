package com.nepxion.swing.selector.color;

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

import com.nepxion.swing.button.JClassicMenuButton;
import com.nepxion.swing.icon.paint.ColorCombinationIcon;

public abstract class JClassicColorSelectorButton
	extends JClassicMenuButton implements IColorSelectorComponent
{
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of ColorCombinationIcon
	 */
	public JClassicColorSelectorButton(ColorCombinationIcon icon)
	{
		this(null, icon);
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string
	 * @param icon the instance of ColorCombinationIcon
	 */
	public JClassicColorSelectorButton(String text, ColorCombinationIcon icon)
	{
		this(text, icon, null);
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of ColorCombinationIcon
	 * @param toolTipText the tooltip text string
	 */
	public JClassicColorSelectorButton(ColorCombinationIcon icon, String toolTipText)
	{
		this(null, icon, toolTipText);
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of ColorCombinationIcon
	 * @param toolTipText the tooltip text string
	 */
	public JClassicColorSelectorButton(String text, final ColorCombinationIcon icon, String toolTipText)
	{
		super(text, icon, toolTipText);
		
		JColorSelectorPopupMenu colorSelectorPopupMenu = new JColorSelectorPopupMenu()
		{
			public void executeSelection(Color color)
			{				
				ColorCombinationIcon colorCombinationIcon = (ColorCombinationIcon) getIcon();
				colorCombinationIcon.setFillColor(color);
				
				JClassicColorSelectorButton.this.repaint();
				JClassicColorSelectorButton.this.executeSelection(color);
			}
		};
		colorSelectorPopupMenu.getColorSelector().setColor(icon.getFillColor());
		
		setPopupMenu(colorSelectorPopupMenu);
	}
}