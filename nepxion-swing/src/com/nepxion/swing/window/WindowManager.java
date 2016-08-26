package com.nepxion.swing.window;

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
import java.awt.GraphicsConfiguration;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Window;

public class WindowManager
{
	/**
	 * Sets the window to center of the screen.
	 * It sets the window with the preferred bounds (full screen).
	 * @param window the instance of Window
	 */
	public static void setCenter(Window window)
	{
		setCenter(window, null);
	}
	
	/**
	 * Sets the window to center of the screen with a window dimension.
	 * @param window the instance of Window
	 * @param windowDimension the instance of Dimension
	 */
	public static void setCenter(Window window, Dimension windowDimension)
	{
		Rectangle screenBounds = getPreferredBounds(window);
		if (windowDimension == null)
		{
			windowDimension = new Dimension(screenBounds.width, screenBounds.height);
		}
		setCenter(window, screenBounds, windowDimension);
	}
	
	/**
	 * Sets the window to center of the screen with a screen bounds and window dimension.
	 * @param window the instance of Window
	 * @param screenBounds the instance of Rectangle
	 * @param windowDimension the instance of Dimension
	 */
	public static void setCenter(Window window, Rectangle screenBounds, Dimension windowDimension)
	{
		window.setSize(windowDimension);
		window.setLocation((int) (screenBounds.width - windowDimension.width) / 2 + screenBounds.x, (int) (screenBounds.height - windowDimension.height) / 2 + screenBounds.y);
	}
	
	/**
	 * Sets the window always on top.
	 * @param window the instance of Window
	 * @param isAlwaysOnTop the boolean value of isAlwaysOnTop
	 */
	public static void setAlwaysOnTop(Window window, boolean isAlwaysOnTop)
	{
		window.setAlwaysOnTop(isAlwaysOnTop);
		// NativeSkin.getInstance().setAlwaysOnTop(window, isAlwaysOnTop);
	}
	
	/**
	 * Gets the preferred bounds of a window.
	 * @param window the instance of Window
	 * @return the instance of Rectangle
	 */
	public static Rectangle getPreferredBounds(Window window)
	{
		GraphicsConfiguration configuration = window.getGraphicsConfiguration();
		Rectangle bounds = configuration.getBounds();
		Insets screenInsets = window.getToolkit().getScreenInsets(configuration);
		bounds = new Rectangle(screenInsets.left, screenInsets.top, bounds.width - screenInsets.right - screenInsets.left, bounds.height - screenInsets.bottom - screenInsets.top);
		
		return bounds;
	}
}