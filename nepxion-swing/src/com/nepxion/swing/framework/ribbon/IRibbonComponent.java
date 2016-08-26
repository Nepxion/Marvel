package com.nepxion.swing.framework.ribbon;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

public interface IRibbonComponent
{
	/**
	 * Gets the name.
	 * @return the name string
	 */
	public String getName();
	
	/**
	 * Sets the name.
	 * @param name the name string
	 */
	public void setName(String name);
	
	/**
	 * Gets the user object.
	 * @return the user object
	 */
	public Object getUserObject();
	
	/**
	 * Sets the user object.
	 * @param userObject the user object
	 */
	public void setUserObject(Object userObject);
}