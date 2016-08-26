package com.nepxion.swing.style.button.flat;

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

public abstract class AbstractFlatButtonStyle
	implements IFlatButtonStyle
{
	/**
	 * The bright color.
	 */
	protected Color brightColor;
	
	/**
	 * The dark color.
	 */
	protected Color darkColor;
	
	/**
	 * Gets the bright color.
	 * @return the instance of Color
	 */
	public Color getBrightColor()
	{
		return brightColor;
	}
	
	/**
	 * Gets the dark color.
	 * @return the instance of Color
	 */
	public Color getDarkColor()
	{
		return darkColor;
	}
}