package com.nepxion.swing.shrinkbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

public class ShrinkOutlookListener
	extends MouseAdapter
{
	private JShrinkOutlook shrinkOutlook;
	
	public ShrinkOutlookListener(JShrinkOutlook shrinkOutlook)
	{
		this.shrinkOutlook = shrinkOutlook;
	}
	
	public void mouseReleased(MouseEvent e)
	{
		JComponent component = (JComponent) e.getSource();
		Point point = e.getPoint();
		
		if (component.contains(point))
		{
			shrinkOutlook.toggleSelection();
		}
	}
}