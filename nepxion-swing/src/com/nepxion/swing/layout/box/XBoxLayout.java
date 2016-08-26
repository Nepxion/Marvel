package com.nepxion.swing.layout.box;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Container;

import com.jidesoft.swing.JideBoxLayout;

public class XBoxLayout
	extends JideBoxLayout
{
	/**
	 * Constructs with the specified initial target.
	 * @param target the instance of Container
	 */
	public XBoxLayout(Container target)
	{
		super(target);
	}
	
	/**
	 * Constructs with the specified initial target and axis.
	 * @param target the instance of Container
	 * @param axis the axis value
	 */
	public XBoxLayout(Container target, int axis)
	{
		super(target, axis);
	}
	
	/**
	 * Constructs with the specified initial target, axis and gap.
	 * @param target the instance of Container
	 * @param axis the axis value
	 * @param gap the gap value
	 */
	public XBoxLayout(Container target, int axis, int gap)
	{
		super(target, axis, gap);
	}
}