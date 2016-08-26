package com.nepxion.swing.fullscreen;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JWindow;
import javax.swing.KeyStroke;

import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.keystroke.KeyStrokeManager;

public class FullScreenSupport
{
	/**
	 * The fullscreen window. 
	 */
	private JWindow fullScreenWindow;
	
	/**
	 * The container.
	 */
	private Container container;
	
	/**
	 * The fullscreen component.
	 */
	private Component fullScreenComponent;
	
	/**
	 * The layout constraints value.
	 */
	private Object layoutConstraints;
	
	/**
	 * Constructs with the specified initial fullscreen component.
	 * @param fullScreenComponent the fullscreen component
	 */
	public FullScreenSupport(Component fullScreenComponent)
	{
		this(fullScreenComponent, null, null);
	}
	
	/**
	 * Constructs with the specified initial fullscreen component and layout constraints.
	 * @param fullScreenComponent the fullscreen component
	 * @param layoutConstraints the layout constraints value
	 */
	public FullScreenSupport(Component fullScreenComponent, Object layoutConstraints)
	{
		this(fullScreenComponent, layoutConstraints, null);
	}
	
	/**
	 * Constructs with the specified initial fullscreen component and toggle fullscreen key stroke.
	 * @param fullScreenComponent the fullscreen component
	 * @param toggleFullScreenKeyStroke the toggle fullscreen key stroke
	 */
	public FullScreenSupport(Component fullScreenComponent, KeyStroke toggleFullScreenKeyStroke)
	{
		this(fullScreenComponent, null, toggleFullScreenKeyStroke);
	}
	
	/**
	 * Constructs with the specified initial fullscreen component, layout constraints and toggle fullscreen key stroke.
	 * @param fullScreenComponent the fullscreen component
	 * @param layoutConstraints the layout constraints value
	 * @param toggleFullScreenKeyStroke the toggle fullscreen key stroke
	 */
	public FullScreenSupport(Component fullScreenComponent, Object layoutConstraints, KeyStroke toggleFullScreenKeyStroke)
	{
		this.fullScreenComponent = fullScreenComponent;
		this.layoutConstraints = layoutConstraints;
		
		if (fullScreenComponent instanceof JComponent)
		{
			JComponent component = (JComponent) fullScreenComponent;
			if (toggleFullScreenKeyStroke != null)
			{
				ActionListener toggleFullScreenActionListener = new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						toggleFullScreen();
					}
				};
				KeyStrokeManager.registerComponent(component, toggleFullScreenActionListener, toggleFullScreenKeyStroke);
			}
			ActionListener exitFullScreenActionListener = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					exitFullScreen();
				}
				
			};
			KeyStrokeManager.registerComponentToEscapeKey(component, exitFullScreenActionListener);
		}
	}
	
	/**
	 * Toggles the fullscreen facade.
	 */
	public void toggleFullScreen()
	{
		if (isFullScreen())
		{
			exitFullScreen();
		}
		else
		{
			showFullScreen();
		}
	}
	
	/**
	 * Shows the full screen facade.
	 */
	public void showFullScreen()
	{
		if (fullScreenWindow != null || fullScreenComponent == null)
		{
			return;
		}
		
		Window parentWindow = HandleManager.getWindow(fullScreenComponent);
		if (parentWindow == null)
		{
			fullScreenWindow = new JWindow();
		}
		else
		{
			fullScreenWindow = new JWindow(parentWindow, parentWindow.getGraphicsConfiguration());
		}
		
		container = fullScreenComponent.getParent();
		if (container != null)
		{
			container.remove(fullScreenComponent);
			if (container instanceof JComponent)
			{
				((JComponent) container).revalidate();
			}
			else
			{
				container.invalidate();
			}
		}
		
		fullScreenWindow.getContentPane().setLayout(new BorderLayout());
		fullScreenWindow.getContentPane().add(fullScreenComponent, BorderLayout.CENTER);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		GraphicsConfiguration graphicsconfiguration = fullScreenWindow.getGraphicsConfiguration();
		Insets insets = toolkit.getScreenInsets(graphicsconfiguration);
		dimension.width -= insets.left + insets.right;
		dimension.height -= insets.top + insets.bottom;
		fullScreenWindow.setSize(dimension);
		fullScreenWindow.setLocation(insets.left, insets.top);
		
		fullScreenWindow.setVisible(true);
		fullScreenWindow.validate();
		fullScreenComponent.requestFocus();
	}
	
	/**
	 * Exits the full screen facade.
	 */
	public void exitFullScreen()
	{
		if (fullScreenWindow == null)
		{
			return;
		}
		
		fullScreenWindow.getContentPane().removeAll();
		fullScreenWindow.setVisible(false);
		fullScreenWindow.dispose();
		fullScreenWindow = null;
		if (container != null)
		{
			if (layoutConstraints == null)
			{
				container.add(fullScreenComponent);
			}
			else
			{
				container.add(fullScreenComponent, layoutConstraints);
			}
			if (container instanceof JComponent)
			{
				((JComponent) container).revalidate();
			}
			else
			{
				container.invalidate();
			}
		}
		fullScreenComponent.requestFocus();
	}
	
	/**
	 * Returns true if is full screen.
	 * @return true if is full screen
	 */
	public boolean isFullScreen()
	{
		return fullScreenWindow != null;
	}
}