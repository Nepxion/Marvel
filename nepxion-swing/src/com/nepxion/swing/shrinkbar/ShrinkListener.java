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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShrinkListener
	extends MouseAdapter implements ShrinkContants
{
	protected JShrinkHeader shrinkHeader;
	
	public ShrinkListener(JShrinkHeader shrinkHeader)
	{
		this.shrinkHeader = shrinkHeader;
	}
	
	public void mouseClicked(MouseEvent e)
	{
		shrinkHeader.toggleShrinked();
	}
}