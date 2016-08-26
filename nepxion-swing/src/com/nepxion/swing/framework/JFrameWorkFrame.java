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

import java.awt.Dimension;

import javax.swing.ImageIcon;

import com.nepxion.swing.frame.JBasicFrame;

public class JFrameWorkFrame
	extends JBasicFrame implements JFrameWorkWindow
{
	/**
	 * The instance of JFrameWorkHierarchy.
	 */
	private JFrameWorkHierarchy frameWorkHierarchy;
	
	/**
	 * Constructs with the default.
	 */
	public JFrameWorkFrame()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial title.
	 * @param title the title string
	 */
	public JFrameWorkFrame(String title)
	{
		super(title);
	}
	
	/**
	 * Constructs with the specified initial title and image icon.
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 */
	public JFrameWorkFrame(String title, ImageIcon imageIcon)
	{
		super(title, imageIcon);
	}
	
	/**
	 * Constructs with the specified initial title and dimension.
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 */
	public JFrameWorkFrame(String title, Dimension dimension)
	{
		super(title, dimension);
	}
	
	/**
	 * Constructs with the specified initial title and destroy.
	 * @param title the title string
	 * @param destroy the boolean value of destroy
	 */
	public JFrameWorkFrame(String title, boolean destroy)
	{
		super(title, destroy);
	}
	
	/**
	 * Constructs with the specified initial title, image icon and dimension.
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 * @param dimension the instance of Dimension
	 */
	public JFrameWorkFrame(String title, ImageIcon imageIcon, Dimension dimension)
	{
		super(title, imageIcon, dimension);
	}
	
	/**
	 * Constructs with the specified initial title, image icon and destroy.
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 * @param destroy the boolean value of destroy
	 */
	public JFrameWorkFrame(String title, ImageIcon imageIcon, boolean destroy)
	{
		super(title, imageIcon, destroy);
	}
	
	/**
	 * Constructs with the specified initial title, dimension and destroy.
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param destroy the boolean value of destroy
	 */
	public JFrameWorkFrame(String title, Dimension dimension, boolean destroy)
	{
		super(title, dimension, destroy);
	}
	
	/**
	 * Constructs with the specified initial title, hint and destroy.
	 * @param title the title string
	 * @param hint the boolean value of hint
	 * @param destroy the boolean value of destroy
	 */
	public JFrameWorkFrame(String title, boolean hint, boolean destroy)
	{
		super(title, hint, destroy);
	}
	
	/**
	 * Constructs with the specified initial title, image icon, dimension and destroy.
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 * @param dimension the instance of Dimension
	 * @param destroy the boolean value of destroy
	 */
	public JFrameWorkFrame(String title, ImageIcon imageIcon, Dimension dimension, boolean destroy)
	{
		super(title, imageIcon, dimension, destroy);
	}
	
	/**
	 * Constructs with the specified initial title, image icon, hint and destroy.
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 * @param hint the boolean value of hint
	 * @param destroy the boolean value of destroy
	 */
	public JFrameWorkFrame(String title, ImageIcon imageIcon, boolean hint, boolean destroy)
	{
		super(title, imageIcon, hint, destroy);
	}
	
	/**
	 * Constructs with the specified initial title dimension, hint and destroy.
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param hint the boolean value of hint
	 * @param destroy the boolean value of destroy
	 */
	public JFrameWorkFrame(String title, Dimension dimension, boolean hint, boolean destroy)
	{
		super(title, dimension, hint, destroy);
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
	public JFrameWorkFrame(String title, ImageIcon imageIcon, Dimension dimension, boolean hint, boolean destroy)
	{
		super(title, imageIcon, dimension, hint, destroy);
	}
	
	/**
	 * Sets the hierarchy.
	 * @param frameWorkHierarchy the instance of JFrameWorkHierarchy
	 */
	public void setHierarchy(JFrameWorkHierarchy frameWorkHierarchy)
	{
		this.frameWorkHierarchy = frameWorkHierarchy;
		
		if (getContentPane().getComponentCount() > 0)
		{
			getContentPane().removeAll();
		}
		getContentPane().add(frameWorkHierarchy);
	}
	
	/**
	 * Gets the hierarchy.
	 * @return the instance of JFrameWorkHierarchy
	 */
	public JFrameWorkHierarchy getHierarchy()
	{
		return frameWorkHierarchy;
	}
}