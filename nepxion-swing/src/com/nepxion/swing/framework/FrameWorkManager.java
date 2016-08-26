package com.nepxion.swing.framework;

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
import java.awt.Container;

public class FrameWorkManager
{
	/**
	 * Gets the framework hierarchy by the child component.
	 * @param component the child component
	 * @return the instance of JFrameWorkHierarchy
	 */
	public static JFrameWorkHierarchy getFrameWorkHierarchy(Component component)
	{
		if (component == null)
		{
			return null;
		}
		
		if (component instanceof JFrameWorkHierarchy)
		{
			return (JFrameWorkHierarchy) component;
		}
		
		Container parent = component.getParent();
		while (parent != null)
		{
			if (parent instanceof JFrameWorkHierarchy)
			{
				return (JFrameWorkHierarchy) parent;
			}
			parent = parent.getParent();
		}
		
		return null;
	}
	
	/**
	 * Gets the framework window by the child component.
	 * @param component the child component
	 * @return the instance of JFrameWorkWindow
	 */
	public static JFrameWorkWindow getFrameWorkWindow(Component component)
	{
		if (component == null)
		{
			return null;
		}
		
		if (component instanceof JFrameWorkWindow)
		{
			return (JFrameWorkWindow) component;
		}
		
		Container parent = component.getParent();
		while (parent != null)
		{
			if (parent instanceof JFrameWorkWindow)
			{
				return (JFrameWorkWindow) parent;
			}
			parent = parent.getParent();
		}
		
		return null;
	}
}