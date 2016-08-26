package com.nepxion.swing.layout.border;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.jidesoft.swing.JideBorderLayout;

public class XBorderLayout
	extends JideBorderLayout
{
	/**
	 * Constructs with the default.
	 */
	public XBorderLayout()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial horizontal gap and vertical gap.
	 * @param hgap the horizontal gap
	 * @param vgap the vertical gap
	 */
	public XBorderLayout(int hgap, int vgap)
	{
		super(hgap, vgap);
	}
}