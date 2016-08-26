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

import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

public class DisplayAbilityListener
	implements HierarchyListener
{
	/**
	 * Invoked when the hierarchy state is changed.
	 * @param e the instance of HierarchyEvent
	 */
	public void hierarchyChanged(HierarchyEvent e)
	{
		long changeFlags = e.getChangeFlags();
		if ((changeFlags & HierarchyEvent.DISPLAYABILITY_CHANGED) == HierarchyEvent.DISPLAYABILITY_CHANGED)
		{
			displayAbilityChanged(e);
		}
	}
	
	/**
	 * Invoked when the display ability is changed.
	 * @param e the instance of HierarchyEvent
	 */
	public void displayAbilityChanged(HierarchyEvent e)
	{
		
	}
}