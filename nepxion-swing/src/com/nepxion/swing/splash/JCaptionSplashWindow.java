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
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JWindow;

import com.nepxion.swing.window.WindowManager;

public class JCaptionSplashWindow
	extends JWindow
{
	private JCaptionSplash captionSplash;
	
	public JCaptionSplashWindow(Icon splashIcon, int[] captionStartPosition, int[] captionSize, String[] caption)
	{
		this(splashIcon, captionStartPosition, captionSize, caption, true);
	}
	
	public JCaptionSplashWindow(Icon splashIcon, int[] captionStartPosition, int[] captionSize, String[] caption, boolean isAlwaysOnTop)
	{
		this(splashIcon, Color.white, captionStartPosition, captionSize, caption, isAlwaysOnTop);
	}
	
	public JCaptionSplashWindow(Icon splashIcon, Color splashColor, int[] captionStartPosition, int[] captionSize, String[] caption, boolean isAlwaysOnTop)
	{
		this(new JCaptionSplash(splashIcon, splashColor, captionStartPosition, captionSize, caption), isAlwaysOnTop);
	}
	
	public JCaptionSplashWindow(JCaptionSplash captionSplash)
	{
		this(captionSplash, true);
	}
	
	public JCaptionSplashWindow(final JCaptionSplash captionSplash, boolean isAlwaysOnTop)
	{
		this.captionSplash = captionSplash;
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add(captionSplash, BorderLayout.CENTER);
		
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
	
	public JCaptionSplash getCaptionSplash()
	{
		return captionSplash;
	}
}