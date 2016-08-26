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

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;

import com.nepxion.swing.frame.JBasicFrame;
import com.nepxion.swing.icon.IconFactory;

public class JFullScreenFrame
	extends JBasicFrame implements JFullScreenWindow
{		
	/**
	 * The instance of JFullScreenDecorationPanel.
	 */
	private JFullScreenDecorationPanel decorationPanel;
	
	/**
	 * Constructs with the default.
	 */
	public JFullScreenFrame()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial title.
	 * @param title the title string
	 */
	public JFullScreenFrame(String title)
	{
		super(title);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial title and image icon.
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 */
	public JFullScreenFrame(String title, ImageIcon imageIcon)
	{
		super(title, imageIcon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial title and dimension.
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 */
	public JFullScreenFrame(String title, Dimension dimension)
	{
		super(title, dimension);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial title and destroy.
	 * @param title the title string
	 * @param destroy the boolean value of destroy
	 */
	public JFullScreenFrame(String title, boolean destroy)
	{
		super(title, destroy);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial title, image icon and dimension.
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 * @param dimension the instance of Dimension
	 */
	public JFullScreenFrame(String title, ImageIcon imageIcon, Dimension dimension)
	{
		super(title, imageIcon, dimension);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial title, image icon and destroy.
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 * @param destroy the boolean value of destroy
	 */
	public JFullScreenFrame(String title, ImageIcon imageIcon, boolean destroy)
	{
		super(title, imageIcon, destroy);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial title, dimension and destroy.
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param destroy the boolean value of destroy
	 */
	public JFullScreenFrame(String title, Dimension dimension, boolean destroy)
	{
		super(title, dimension, destroy);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial title, hint and destroy.
	 * @param title the title string
	 * @param hint the boolean value of hint
	 * @param destroy the boolean value of destroy
	 */
	public JFullScreenFrame(String title, boolean hint, boolean destroy)
	{
		super(title, hint, destroy);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial title, image icon, dimension and destroy.
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 * @param dimension the instance of Dimension
	 * @param destroy the boolean value of destroy
	 */
	public JFullScreenFrame(String title, ImageIcon imageIcon, Dimension dimension, boolean destroy)
	{
		super(title, imageIcon, dimension, destroy);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial title, image icon, hint and destroy.
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 * @param hint the boolean value of hint
	 * @param destroy the boolean value of destroy
	 */
	public JFullScreenFrame(String title, ImageIcon imageIcon, boolean hint, boolean destroy)
	{
		super(title, imageIcon, hint, destroy);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial title dimension, hint and destroy.
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param hint the boolean value of hint
	 * @param destroy the boolean value of destroy
	 */
	public JFullScreenFrame(String title, Dimension dimension, boolean hint, boolean destroy)
	{
		super(title, dimension, hint, destroy);
		
		initComponents();
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
	public JFullScreenFrame(String title, ImageIcon imageIcon, Dimension dimension, boolean hint, boolean destroy)
	{
		super(title, imageIcon, dimension, hint, destroy);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		decorationPanel = new JFullScreenDecorationPanel(WINDOW_TITLE, IconFactory.getSwingIcon(WINDOW_ICON), WINDOW_TITLE);
		decorationPanel.setBackground(Color.white);
		
		getContentPane().add(decorationPanel);
	}
	
	/**
	 * Returns true if the content is valid.
	 * @param content the content string
	 * @return true if the content is valid
	 */
	public boolean isValid(String content)
	{
		return content != null && !content.trim().equals("");
	}
	
	/**
	 * Gets the workspace.
	 * @return the instance of JFullScreenDecorationPanel
	 */
	public JFullScreenDecorationPanel getWorkspace()
	{
		return decorationPanel;
	}
}