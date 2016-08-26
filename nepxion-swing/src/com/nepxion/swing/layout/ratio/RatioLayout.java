package com.nepxion.swing.layout.ratio;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.l2fprod.common.swing.PercentLayout;

public class RatioLayout
	extends PercentLayout
{
	/**
	 * Constructs with the default.
	 */
	public RatioLayout()
	{
		this(HORIZONTAL);
	}
	
	/**
	 * Constructs with the specified initial orientation.
	 * @param orientation the orientation value
	 */
	public RatioLayout(int orientation)
	{
		this(orientation, 0);
	}
	
	/**
	 * Constructs with the specified initial orientation and gap.
	 * @param orientation the orientation value
	 * @param gap the gap value
	 */
	public RatioLayout(int orientation, int gap)
	{
		super(orientation, gap);
	}
}