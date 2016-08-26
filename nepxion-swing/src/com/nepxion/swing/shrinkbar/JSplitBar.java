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

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.Box.Filler;

public class JSplitBar
	extends Filler implements ShrinkContants
{
	public JSplitBar(JShrinkHeader shrinkHeader, int width)
	{
		super(new Dimension(width, 0), new Dimension(width, 0), new Dimension(width, Short.MAX_VALUE));
		
		SplitListener splitListener = new SplitListener(shrinkHeader);
		
		setOpaque(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
		addMouseListener(splitListener);
		addMouseMotionListener(splitListener);
	}
	
	protected void setShrinked(boolean shrinked)
	{
		if (shrinked)
		{
			setCursor(Cursor.getDefaultCursor());
		}
		else
		{
			setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
		}
	}
}