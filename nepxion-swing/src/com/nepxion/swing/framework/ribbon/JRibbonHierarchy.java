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

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.framework.JFrameWorkHierarchy;
import com.nepxion.swing.framework.JFrameWorkStatusBar;

public class JRibbonHierarchy
	extends JFrameWorkHierarchy
{
	/**
	 * The navigator container.
	 */
	private JPanel navigatorContainer;
	
	/**
	 * The ribbon container.
	 */
	private JRibbonContainer container;
	
	/**
	 * The status bar.
	 */
	private JFrameWorkStatusBar statusBar;
	
	/**
	 * The status bar container.
	 * It can hold more than one status bars.
	 */
	private JPanel statusBarContainer;
		
	/**
	 * Constructs with the default.
	 */
	public JRibbonHierarchy()
	{
		navigatorContainer = new JPanel();
		navigatorContainer.setLayout(new BoxLayout(navigatorContainer, BoxLayout.Y_AXIS));
		
		container = new JRibbonContainer();
		
		statusBar = new JFrameWorkStatusBar()
		{
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				
				paintStatusBarBackground(statusBar, g);
			}
			
			public Dimension getPreferredSize()
			{
				int height = getStatusBarBackgroundHeight();
				if (height <= 0)
				{
					return super.getPreferredSize();
				}
				else
				{
					return new Dimension(super.getPreferredSize().width, height);
				}
			}
		};
		
		statusBarContainer = new JPanel();
		statusBarContainer.setLayout(new BorderLayout());
		statusBarContainer.add(statusBar, BorderLayout.NORTH);
		
		setLayout(new BorderLayout());
		add(navigatorContainer, BorderLayout.NORTH);
		add(container, BorderLayout.CENTER);
		add(statusBarContainer, BorderLayout.SOUTH);
	}
	
	/**
	 * Paints the status bar background.
	 * @param component the instance of Component
	 * @param g the instance of Graphics
	 */
	protected void paintStatusBarBackground(Component component, Graphics g)
	{
	}
	
	/**
	 * Gets the status bar background height.
	 * @return the status bar background height value 
	 */
	protected int getStatusBarBackgroundHeight()
	{
		return -1;
	}
	
	/**
	 * Gets the navigator container.
	 * @return the navigator container
	 */
	public JPanel getNavigatorContainer()
	{
		return navigatorContainer;
	}
	
	/**
	 * Gets the ribbon container.
	 * @return the ribbon container
	 */
	public JRibbonContainer getRibbonContainer()
	{
		return container;
	}
	
	/**
	 * Gets the status bar.
	 * @return the status bar
	 */
	public JFrameWorkStatusBar getStatusBar()
	{
		return statusBar;
	}
	
	/**
	 * Gets the status bar container.
	 * @return the status bar container
	 */
	public JPanel getStatusBarContainer()
	{
		return statusBarContainer;
	}
}