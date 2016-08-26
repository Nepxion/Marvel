package com.nepxion.swing.selector;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Component;

import com.jidesoft.swing.SelectAllUtils;

public class JSelectAllUtil
{
	/**
	 * Installs the select all feature for a component.
	 * @param component the instance of Component
	 */
	public static void install(Component component)
	{
		SelectAllUtils.install(component);
	}
	
	/**
	 * Installs the select all feature for a component.
	 * It is only allowed to be installed once.
	 * @param component the instance of Component
	 */
	public static void install(Component component, boolean onlyOnce)
	{
		SelectAllUtils.install(component, onlyOnce);
	}
	
	/**
	 * Uninstalls the select all feature for a component. 
	 * @param component component the instance of Component 
	 */
	public static void uninstall(Component component)
	{
		SelectAllUtils.uninstall(component);
	}
}