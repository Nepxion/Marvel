package com.nepxion.swing.splash;

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
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JWindow;

import com.nepxion.swing.window.WindowManager;

public class JSplashWindow
	extends JWindow
{
	private JSplash splash;
	
	public JSplashWindow(Icon splashIcon)
	{
		this(splashIcon, true);
	}
	
	public JSplashWindow(Icon splashIcon, boolean isAlwaysOnTop)
	{
		this(new JSplash(splashIcon), isAlwaysOnTop);
	}
	
	public JSplashWindow(JSplash splash)
	{
		this(splash, true);
	}
	
	public JSplashWindow(JSplash splash, boolean isAlwaysOnTop)
	{
		this.splash = splash;
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add(splash, BorderLayout.CENTER);
		
		addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				setVisible(false);
			}
		}
		);
		
		WindowManager.setCenter(this, container.getPreferredSize());
		WindowManager.setAlwaysOnTop(this, isAlwaysOnTop);
	}
	
	public JSplash getSplash()
	{
		return splash;
	}
}