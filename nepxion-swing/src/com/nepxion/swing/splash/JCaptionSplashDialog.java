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
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JRootPane;

import com.nepxion.swing.dialog.JBasicDialog;
import com.nepxion.swing.window.WindowManager;

public class JCaptionSplashDialog
	extends JBasicDialog
{
	private JCaptionSplash captionSplash;
	private boolean isAlwaysOnTop;
	
	public JCaptionSplashDialog(Icon splashIcon, int[] captionStartPosition, int[] captionSize, String[] caption)
	{
		this((Frame) null, splashIcon, captionStartPosition, captionSize, caption, true);
	}
	
	public JCaptionSplashDialog(Icon splashIcon, int[] captionStartPosition, int[] captionSize, String[] caption, boolean isAlwaysOnTop)
	{
		this((Frame) null, splashIcon, captionStartPosition, captionSize, caption);
	}
	
	public JCaptionSplashDialog(Icon splashIcon, Color splashColor, int[] captionStartPosition, int[] captionSize, String[] caption)
	{
		this((Frame) null, splashIcon, splashColor, captionStartPosition, captionSize, caption, true);
	}
	
	public JCaptionSplashDialog(Icon splashIcon, Color splashColor, int[] captionStartPosition, int[] captionSize, String[] caption, boolean isAlwaysOnTop)
	{
		this((Frame) null, splashIcon, splashColor, captionStartPosition, captionSize, caption);
	}
	
	public JCaptionSplashDialog(JCaptionSplash captionSplash)
	{
		this(captionSplash, true);
	}
	
	public JCaptionSplashDialog(JCaptionSplash captionSplash, boolean isAlwaysOnTop)
	{
		this((Frame) null, captionSplash, isAlwaysOnTop);
	}
	
	public JCaptionSplashDialog(Frame owner, Icon splashIcon, int[] captionStartPosition, int[] captionSize, String[] caption)
	{
		this(owner, splashIcon, captionStartPosition, captionSize, caption, true);
	}
	
	public JCaptionSplashDialog(Dialog owner, Icon splashIcon, int[] captionStartPosition, int[] captionSize, String[] caption)
	{
		this(owner, splashIcon, captionStartPosition, captionSize, caption, true);
	}
	
	public JCaptionSplashDialog(Frame owner, Icon splashIcon, Color splashColor, int[] captionStartPosition, int[] captionSize, String[] caption)
	{
		this(owner, splashIcon, splashColor, captionStartPosition, captionSize, caption, true);
	}
	
	public JCaptionSplashDialog(Dialog owner, Icon splashIcon, Color splashColor, int[] captionStartPosition, int[] captionSize, String[] caption)
	{
		this(owner, splashIcon, splashColor, captionStartPosition, captionSize, caption, true);
	}
	
	public JCaptionSplashDialog(Frame owner, Icon splashIcon, int[] captionStartPosition, int[] captionSize, String[] caption, boolean isAlwaysOnTop)
	{
		this(owner, splashIcon, Color.white, captionStartPosition, captionSize, caption, isAlwaysOnTop);
	}
	
	public JCaptionSplashDialog(Dialog owner, Icon splashIcon, int[] captionStartPosition, int[] captionSize, String[] caption, boolean isAlwaysOnTop)
	{
		this(owner, splashIcon, Color.white, captionStartPosition, captionSize, caption, isAlwaysOnTop);
	}
	
	public JCaptionSplashDialog(Frame owner, Icon splashIcon, Color splashColor, int[] captionStartPosition, int[] captionSize, String[] caption, boolean isAlwaysOnTop)
	{
		this(owner, new JCaptionSplash(splashIcon, splashColor, captionStartPosition, captionSize, caption), isAlwaysOnTop);
	}
	
	public JCaptionSplashDialog(Dialog owner, Icon splashIcon, Color splashColor, int[] captionStartPosition, int[] captionSize, String[] caption, boolean isAlwaysOnTop)
	{
		this(owner, new JCaptionSplash(splashIcon, splashColor, captionStartPosition, captionSize, caption), isAlwaysOnTop);
	}
	
	public JCaptionSplashDialog(Frame owner, JCaptionSplash captionSplash)
	{
		this(owner, captionSplash, true);
	}
	
	public JCaptionSplashDialog(Dialog owner, JCaptionSplash captionSplash)
	{
		this(owner, captionSplash, true);
	}
	
	public JCaptionSplashDialog(Frame owner, JCaptionSplash captionSplash, boolean isAlwaysOnTop)
	{
		super(owner, null, null, false, false);
		
		this.captionSplash = captionSplash;
		this.isAlwaysOnTop = isAlwaysOnTop;
		
		initComponents();
	}
	
	public JCaptionSplashDialog(Dialog owner, JCaptionSplash captionSplash, boolean isAlwaysOnTop)
	{
		super(owner, null, null, false, false);
		
		this.captionSplash = captionSplash;
		this.isAlwaysOnTop = isAlwaysOnTop;
		
		initComponents();
	}
	
	private void initComponents()
	{
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
		
		WindowManager.setAlwaysOnTop(this, isAlwaysOnTop);
		
		setDefaultCloseOperation(JBasicDialog.DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
	}
	
	public JCaptionSplash getCaptionSplash()
	{
		return captionSplash;
	}
}