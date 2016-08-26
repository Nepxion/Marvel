package com.nepxion.swing.handle;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.applet.Applet;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;

public class HandleManager
{
	/**
	 * Gets the parent component by a child component and parent class.
	 * @param component the child component
	 * @param clazz the parent class
	 * @return the instance of Component
	 */
	public static Component getComponent(Component component, Class clazz)
	{
		if (component == null || clazz == null)
		{
			return null;
		}
		
		if (clazz.isInstance(component))
		{
			return (Component) component;
		}
		
		Container parent = component.getParent();
		while (parent != null)
		{
			if (clazz.isInstance(parent))
			{
				return (Component) parent;
			}
			parent = parent.getParent();
		}
		
		return null;
	}
	
	/**
	 * Gets the top window by a child component.
	 * @param component the child component
	 * @return the instance of Window
	 */
	public static Window getWindow(Component component)
	{
		if (component == null)
		{
			return null;
		}
		
		if (component instanceof Window)
		{
			return (Window) component;
		}
		
		Container parent = component.getParent();
		while (parent != null)
		{
			if (parent instanceof Window)
			{
				return (Window) parent;
			}
			parent = parent.getParent();
		}
		
		return null;
	}
	
	/**
	 * Gets the top frame by a child component.
	 * @param component the child component
	 * @return the instance of Frame
	 */
	public static Frame getFrame(Component component)
	{
		if (component == null)
		{
			return null;
		}
		
		if (component instanceof Frame)
		{
			return (Frame) component;
		}
		
		Container parent = component.getParent();
		while (parent != null)
		{
			if (parent instanceof Frame)
			{
				return (Frame) parent;
			}
			parent = parent.getParent();
		}
		
		return null;
	}
	
	/**
	 * Gets the top applet by a child component.
	 * @param component the child component
	 * @return the instance of Applet
	 */
	public static Applet getApplet(Component component)
	{
		if (component == null)
		{
			return null;
		}
		
		if (component instanceof Applet)
		{
			return (Applet) component;
		}
		
		Container parent = component.getParent();
		while (parent != null)
		{
			if (parent instanceof Applet)
			{
				return (Applet) parent;
			}
			parent = parent.getParent();
		}
		
		return null;
	}
	
	/**
	 * Gets the top dialog by a child component.
	 * @param component the child component
	 * @return the instance of Dialog
	 */
	public static Dialog getDialog(Component component)
	{
		if (component == null)
		{
			return null;
		}
		
		if (component instanceof Dialog)
		{
			return (Dialog) component;
		}
		
		Container parent = component.getParent();
		while (parent != null)
		{
			if (parent instanceof Dialog)
			{
				return (Dialog) parent;
			}
			parent = parent.getParent();
		}
		
		return null;
	}
	
	/**
	 * Gets the modal dialog by a window.
	 * @param window the instance of Window
	 * @return the instance of Dialog
	 */
	public static Dialog getModalDialog(Window window)
	{
		Window[] windows = window.getOwnedWindows();
		for (int i = 0; i < windows.length; i++)
		{
			if (windows[i].isVisible() && windows[i] instanceof Dialog && ((Dialog) windows[i]).isModal())
			{
				return (getModalDialog(windows[i]));
			}
		}
		
		return (Dialog) window;
	}
	
	/**
	 * Gets the ancestor modal dialog by a window.
	 * @param window the instance of Window
	 * @return the instance of Dialog
	 */
	public static Dialog getAncestorModalDialog(Window window)
	{
		Window[] windows = window.getOwnedWindows();
		for (int i = 0; i < windows.length; i++)
		{
			if (windows[i].isVisible() && windows[i] instanceof Dialog && ((Dialog) windows[i]).isModal())
			{
				return (getModalDialog(windows[i]));
			}
		}
		
		return (Dialog) window;
	}
}