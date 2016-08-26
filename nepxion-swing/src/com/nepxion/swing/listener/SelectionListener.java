package com.nepxion.swing.listener;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SelectionListener
	implements ItemListener
{
	/**
	 * Invoked when the item state is changed.
	 * @param e the instance of ItemEvent
	 */
	public void itemStateChanged(ItemEvent e)
	{
		if (e.getStateChange() == ItemEvent.SELECTED)
		{
			itemSelectionStateChanged(e);
		}
		else if (e.getStateChange() == ItemEvent.DESELECTED)
		{
			itemDeselectionStateChanged(e);
		}
	}
	
	/**
	 * Invoked when the item selection state is changed.
	 * @param e the instance of ItemEvent
	 */
	public void itemSelectionStateChanged(ItemEvent e)
	{
		
	}
	
	/**
	 * Invoked when the item deselection state is changed.
	 * @param e the instance of ItemEvent
	 */
	public void itemDeselectionStateChanged(ItemEvent e)
	{
		
	}
}