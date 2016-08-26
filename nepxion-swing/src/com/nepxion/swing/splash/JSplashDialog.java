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
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JRootPane;

import com.nepxion.swing.dialog.JBasicDialog;
import com.nepxion.swing.window.WindowManager;

public class JSplashDialog
	extends JBasicDialog
{
	private JSplash splash;
	private boolean isAlwaysOnTop;
	
	public JSplashDialog(Icon splashIcon)
	{
		this(splashIcon, true);
	}
	
	public JSplashDialog(Icon splashIcon, boolean isAlwaysOnTop)
	{
		this((Frame) null, splashIcon, isAlwaysOnTop);
	}
	
	public JSplashDialog(JSplash splash)
	{
		this(splash, true);
	}
	
	public JSplashDialog(JSplash splash, boolean isAlwaysOnTop)
	{
		this((Frame) null, splash, isAlwaysOnTop);
	}
	
	public JSplashDialog(Frame owner, Icon splashIcon)
	{
		this(owner, splashIcon, true);
	}
	
	public JSplashDialog(Dialog owner, Icon splashIcon)
	{
		this(owner, splashIcon, true);
	}
	
	public JSplashDialog(Frame owner, Icon splashIcon, boolean isAlwaysOnTop)
	{
		this(owner, new JSplash(splashIcon), isAlwaysOnTop);
	}
	
	public JSplashDialog(Dialog owner, Icon splashIcon, boolean isAlwaysOnTop)
	{
		this(owner, new JSplash(splashIcon), isAlwaysOnTop);
	}
	
	public JSplashDialog(Frame owner, JSplash splash)
	{
		this(owner, splash, true);
	}
	
	public JSplashDialog(Dialog owner, JSplash splash)
	{
		this(owner, splash, true);
	}
	
	public JSplashDialog(Frame owner, JSplash splash, boolean isAlwaysOnTop)
	{
		super(owner, null, null, false, false);
		
		this.splash = splash;
		this.isAlwaysOnTop = isAlwaysOnTop;
		
		initComponents();
	}
	
	public JSplashDialog(Dialog owner, JSplash splash, boolean isAlwaysOnTop)
	{
		super(owner, null, null, false, false);
		
		this.splash = splash;
		this.isAlwaysOnTop = isAlwaysOnTop;
		
		initComponents();
	}
	
	private void initComponents()
	{
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
		
		WindowManager.setAlwaysOnTop(this, isAlwaysOnTop);
		
		setDefaultCloseOperation(JBasicDialog.DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
	}
	
	public JSplash getSplash()
	{
		return splash;
	}
}