package com.nepxion.swing.button;

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

public interface IButton
{
	/**
	 * Gets the width inset.
	 * @return the width inset value
	 */
	public int getWidthInset();
	
	/**
	 * Sets the width inset.
	 * @param widthInset the width inset value
	 */
	public void setWidthInset(int widthInset);
	
	/**
	 * Gets the height inset.
	 * @return the height inset value
	 */
	public int getHeightInset();
	
	/**
	 * Sets the height inset.
	 * @param heightInset the height inset value
	 */
	public void setHeightInset(int heightInset);
	
	/**
	 * Sets the dimension.
	 * @param dimension the instance of Dimension
	 */
	public void setDimension(Dimension dimension);
}