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
import java.awt.Dimension;

import javax.swing.JPopupMenu;

public abstract class JColorSelectorPopupMenu
	extends JPopupMenu implements IColorSelectorComponent
{
	/**
	 * The instance of JColorSelector.
	 */
	private JColorSelector colorSelector;
	
	/**
	 * Constructs with the default.
	 */
	public JColorSelectorPopupMenu()
	{
		colorSelector = new JColorSelector()
		{
			public void executeSelection()
			{
				Color color = getColor();
				
				JColorSelectorPopupMenu.this.executeSelection(color);
			}
		};
		
		colorSelector.setPreferredSize(new Dimension(colorSelector.getPreferredSize().width, 207));
		
		add(colorSelector);
	}
	
	/**
	 * Gets the color selector.
	 * @return the instance of JColorSelector
	 */
	public JColorSelector getColorSelector()
	{
		return colorSelector;
	}
}