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

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.event.MouseInputAdapter;

public class SplitListener
	extends MouseInputAdapter implements ShrinkContants
{
	protected Point lastPoint;
	protected JShrinkHeader shrinkHeader;
	
	public SplitListener(JShrinkHeader shrinkHeader)
	{
		this.shrinkHeader = shrinkHeader;
	}
	
	public void mousePressed(MouseEvent e)
	{
		if (shrinkHeader.isShrinked())
		{
			return;
		}
		
		lastPoint = e.getPoint();
	}
	
	public void mouseReleased(MouseEvent e)
	{
		lastPoint = null;
	}
	
	public void mouseDragged(MouseEvent e)
	{
		if (shrinkHeader.isShrinked())
		{
			return;
		}
		
		if (lastPoint == null)
		{
			return;
		}
		
		Point point = e.getPoint();
		int x = point.x - lastPoint.x;
		
		JComponent parent = (JComponent) shrinkHeader.getParent();
		
		int placement = shrinkHeader.getPlacement();
		int shrinkedWidth = shrinkHeader.getShrinkedWidth();
		
		Dimension size = parent.getPreferredSize();
		if (placement == PLACEMENT_EAST)
		{
			size.width -= x;
		}
		else if (placement == PLACEMENT_WEST)
		{
			size.width += x;
		}
		size.width = Math.max(size.width, shrinkedWidth);
		
		parent.setPreferredSize(size);
		
		shrinkHeader.revalidateParent();
	}
}