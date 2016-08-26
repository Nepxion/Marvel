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

import javax.swing.Icon;

import com.nepxion.swing.applet.JBasicApplet;
import com.nepxion.swing.icon.IconFactory;

public class JFullScreenApplet
	extends JBasicApplet implements JFullScreenWindow
{	
	/**
	 * The window title string.
	 */
	private String windowTitle;
	
	/**
	 * the window icon.
	 */
	private Icon windowIcon;
	
	/**
	 * The instance of JFullScreenDecorationPanel.
	 */
	private JFullScreenDecorationPanel decorationPanel;
	
	/**
	 * Initializes the applet.
	 * It is overridden from JApplet.
	 */
	public void init()
	{
		super.init();
		
		initWindowTitle();		
		initWindowIcon();
		
		decorationPanel = new JFullScreenDecorationPanel(windowTitle, windowIcon, windowTitle);
		decorationPanel.setBackground(Color.white);
		
		getContentPane().add(decorationPanel);
	}
	
	/**
	 * Initializes the window title.
	 */
	private void initWindowTitle()
	{
		windowTitle = getParameter("windowTitle");
		if (windowTitle == null || windowTitle.equals(""))
		{
			windowTitle = WINDOW_TITLE;
		}
	}
	
	/**
	 * Initializes the window icon.
	 */
	private void initWindowIcon()
	{
		String windowIconName = getParameter("windowIcon");
		if (windowIconName == null || windowIconName.equals(""))
		{
			windowIcon = IconFactory.getSwingIcon(WINDOW_ICON);
		}
		else
		{
			windowIcon = IconFactory.getContextIcon(windowIconName);
		}
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