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

import com.jidesoft.swing.PartialLineBorder;

public class ComplexLineBorder
	extends PartialLineBorder
{
	/**
	 * Constructs with the specified initial color.
	 * @param color the instance of Color
	 */
	public ComplexLineBorder(Color color)
	{
		super(color);
	}
	
	/**
	 * Constructs with the specified initial color and thickness.
	 * @param color the instance of Color
	 * @param thickness the thickness value
	 */
	public ComplexLineBorder(Color color, int thickness)
	{
		super(color, thickness);
	}
	
	/**
	 * Constructs with the specified initial color, thickness and rounded corners.
	 * @param color the instance of Color
	 * @param thickness the thickness value
	 * @param roundedCorners the boolean value of roundedCorners
	 */
	public ComplexLineBorder(Color color, int thickness, boolean roundedCorners)
	{
		super(color, thickness, roundedCorners);
	}
	
	/**
	 * Constructs with the specified initial color, thickness, rounded corners and rounded corner size.
	 * @param color the instance of Color
	 * @param thickness the thickness value
	 * @param roundedCorners the boolean value of roundedCorners
	 * @param roundedCornerSize the rounded corner size value
	 */
	public ComplexLineBorder(Color color, int thickness, boolean roundedCorners, int roundedCornerSize) 
	{
		super(color, thickness, roundedCorners, roundedCornerSize);
	}
	
	/**
	 * Constructs with the specified initial color, thickness and side.
	 * @param color the instance of Color
	 * @param thickness the thickness value
	 * @param side the side value
	 */
	public ComplexLineBorder(Color color, int thickness, int side)
	{
		super(color, thickness, side);
	}
}