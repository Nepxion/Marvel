package com.nepxion.swing.border;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Color;

import com.jidesoft.swing.PartialGradientLineBorder;

public class ComplexGradientLineBorder
	extends PartialGradientLineBorder
{
	/**
	 * Constructs with the specified initial colors.
	 * @param colors the color array
	 */
	public ComplexGradientLineBorder(Color[] colors)
	{
		super(colors);
	}
	
	/**
	 * Constructs with the specified initial colors and thickness.
	 * @param colors the color array
	 * @param thickness the thickness value
	 */
	public ComplexGradientLineBorder(Color[] colors, int thickness)
	{
		super(colors, thickness);
	}
	
	/**
	 * Constructs with the specified initial colors, thickness and sides.
	 * @param colors the color array
	 * @param thickness the thickness value
	 * @param sides the sides value
	 */
	public ComplexGradientLineBorder(Color[] colors, int thickness, int sides)
	{
		super(colors, thickness, sides);
	}
}