package com.nepxion.swing.statusbar;

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

import javax.swing.BorderFactory;

import com.nepxion.swing.toolbar.JBasicToolBar;

public class JStatusItem
	extends JBasicToolBar
{
	/**
	 * The index value.
	 */
	private int index = -1;
	
	/**
	 * Constructs with the specified initial component.
	 * @param component the instance of Component
	 */
	public JStatusItem(Component component)
	{
		this();
		
		add(component);
	}
	
	/**
	 * Initializes the components.
	 */
	public JStatusItem()
	{
		// setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.CENTER, 0));
		setBorder(BorderFactory.createEmptyBorder());
	}
	
	/**
	 * Gets the index.
	 * @return the index value
	 */
	protected int getIndex()
	{
		return index;
	}
	
	/**
	 * Sets the index.
	 * @param index the index value
	 */
	protected void setIndex(int index)
	{
		this.index = index;
	}
}