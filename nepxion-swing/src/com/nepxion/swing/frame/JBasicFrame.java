package com.nepxion.swing.frame;

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
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.window.WindowManager;

public class JBasicFrame
	extends JFrame
{
	/**
	 * the boolean value of hint.
	 */
	private boolean hint = true;
	
	/**
	 * the boolean value of destroy.
	 */
	private boolean destroy = true;
	
	/**
	 * Constructs with the default.
	 */
	public JBasicFrame()
	{
		this("");
	}
	
	/**
	 * Constructs with the specified initial title.
	 * @param title the title string
	 */
	public JBasicFrame(String title)
	{
		this(title, true);
	}
	
	/**
	 * Constructs with the specified initial title and image icon.
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 */
	public JBasicFrame(String title, ImageIcon imageIcon)
	{
		this(title, imageIcon, true);
	}
	
	/**
	 * Constructs with the specified initial title and dimension.
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 */
	public JBasicFrame(String title, Dimension dimension)
	{
		this(title, null, dimension);
	}
	
	/**
	 * Constructs with the specified initial title and destroy.
	 * @param title the title string
	 * @param destroy the boolean value of destroy
	 */
	public JBasicFrame(String title, boolean destroy)
	{
		this(title, (Dimension) null, destroy);
	}
	
	/**
	 * Constructs with the specified initial title, image icon and dimension.
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 * @param dimension the instance of Dimension
	 */
	public JBasicFrame(String title, ImageIcon imageIcon, Dimension dimension)
	{
		this(title, imageIcon, dimension, true);
	}
	
	/**
	 * Constructs with the specified initial title, image icon and destroy.
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 * @param destroy the boolean value of destroy
	 */
	public JBasicFrame(String title, ImageIcon imageIcon, boolean destroy)
	{
		this(title, imageIcon, true, destroy);
	}
	
	/**
	 * Constructs with the specified initial title, dimension and destroy.
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param destroy the boolean value of destroy
	 */
	public JBasicFrame(String title, Dimension dimension, boolean destroy)
	{
		this(title, dimension, true, destroy);
	}
	
	/**
	 * Constructs with the specified initial title, hint and destroy.
	 * @param title the title string
	 * @param hint the boolean value of hint
	 * @param destroy the boolean value of destroy
	 */
	public JBasicFrame(String title, boolean hint, boolean destroy)
	{
		this(title, (Dimension) null, hint, destroy);
	}
	
	/**
	 * Constructs with the specified initial title, image icon, dimension and destroy.
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 * @param dimension the instance of Dimension
	 * @param destroy the boolean value of destroy
	 */
	public JBasicFrame(String title, ImageIcon imageIcon, Dimension dimension, boolean destroy)
	{
		this(title, imageIcon, dimension, true, destroy);
	}
	
	/**
	 * Constructs with the specified initial title, image icon, hint and destroy.
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 * @param hint the boolean value of hint
	 * @param destroy the boolean value of destroy
	 */
	public JBasicFrame(String title, ImageIcon imageIcon, boolean hint, boolean destroy)
	{
		this(title, imageIcon, null, hint, destroy);
	}
	
	/**
	 * Constructs with the specified initial title dimension, hint and destroy.
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param hint the boolean value of hint
	 * @param destroy the boolean value of destroy
	 */
	public JBasicFrame(String title, Dimension dimension, boolean hint, boolean destroy)
	{
		this(title, null, dimension, hint, destroy);
	}
	
	/**
	 * Constructs with the specified initial title, image icon, dimension, hint and destroy.
	 * The boolean value of hint means that it will be shown confirming hint or not when closing the dialog.
	 * The boolean value of hint means that it will kill JVM process when closing the frame.
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 * @param dimension the instance of Dimension
	 * @param hint the boolean value of hint
	 * @param destroy the boolean value of destroy
	 */
	public JBasicFrame(String title, ImageIcon imageIcon, Dimension dimension, boolean hint, boolean destroy)
	{
		super(title);
		
		this.hint = hint;
		this.destroy = destroy;
		
		WindowManager.setCenter(this, dimension);
		if (imageIcon != null)
		{
			setIconImage(imageIcon.getImage());
		}
	}
	
	/**
	 * Returns true if hint.
	 * @return true if hint
	 */
	public boolean isHint()
	{
		return hint;
	}
	
	/**
	 * Sets the hint.
	 * @param hint the boolean value of hint.
	 */
	public void setHint(boolean hint)
	{
		this.hint = hint;
	}
	
	/**
	 * Returns true if destroy.
	 * @return true if destroy
	 */
	public boolean isDestroy()
	{
		return destroy;
	}
	
	/**
	 * Sets the destroy.
	 * @param destroy the boolean value of destroy.
	 */
	public void setDestroy(boolean destroy)
	{
		this.destroy = destroy;
	}
	
	/**
	 * Invoked when a window event occurs.
	 * @param e the instance of WindowEvent
	 */
	protected void processWindowEvent(WindowEvent e)
	{
		if (hint)
		{
			if (e.getID() == WindowEvent.WINDOW_CLOSING)
			{
				int selectedValue = JBasicOptionPane.showConfirmDialog(this, SwingLocale.getString("confirm_to_exit"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
				if (selectedValue != JBasicOptionPane.YES_OPTION)
				{
					return;
				}
			}
		}
		
		super.processWindowEvent(e);
		
		if (destroy)
		{
			if (e.getID() == WindowEvent.WINDOW_CLOSING)
			{
				System.exit(0);
			}
		}
	}
	
	/**
	 * Sets the extended state.
	 * @param state the state value
	 */
	public void setExtendedState(int state)
	{
		if ((state & MAXIMIZED_BOTH) == MAXIMIZED_BOTH)
		{
			Rectangle bounds = getGraphicsConfiguration().getBounds();
			Rectangle maxBounds = null;
			if (bounds.x == 0 && bounds.y == 0)
			{
				Insets screenInsets = getToolkit().getScreenInsets(getGraphicsConfiguration());
				maxBounds = new Rectangle(screenInsets.left, screenInsets.top, bounds.width - screenInsets.right - screenInsets.left, bounds.height - screenInsets.bottom - screenInsets.top);
			}
			else
			{
				maxBounds = null;
			}
			
			super.setMaximizedBounds(maxBounds);
		}
		
		super.setExtendedState(state);
	}
}