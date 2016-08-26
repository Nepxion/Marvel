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

import javax.swing.JPanel;

public class DefaultRibbonComponent
	extends JPanel implements IRibbonComponent
{
	/**
	 * The user object 
	 */
	private Object userObject;
	
	/**
	 * Gets the user object.
	 * @return the user object
	 */
	public Object getUserObject()
	{
		return userObject;
	}
	
	/**
	 * Sets the user object.
	 * @param userObject the user object
	 */
	public void setUserObject(Object userObject)
	{
		this.userObject = userObject;
	}
}