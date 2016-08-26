package com.nepxion.swing.slider;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.jidesoft.swing.RangeSlider;

public class JRangeSlider
	extends RangeSlider
{
	/**
	 * Constructs with the default.
	 */
	public JRangeSlider()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial orientation.
	 * @param orientation the orientation value
	 */
	public JRangeSlider(int orientation)
	{
		super(orientation);
	}
	
	/**
	 * Constructs with the specified initial min and max.
	 * @param min the minimum value
	 * @param max the maximum value
	 */
	public JRangeSlider(int min, int max)
	{
		super(min, max);
	}
	
	/**
	 * Constructs with the specified initial min, max, low and high.
	 * @param min the minimum value
	 * @param max the maximum value
	 * @param low the low value
	 * @param high the high value
	 */
	public JRangeSlider(int min, int max, int low, int high)
	{
		super(min, max, low, high);
	}
}