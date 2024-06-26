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

import javax.swing.JPanel;

public abstract class JFrameWorkHierarchy
	extends JPanel
{
	/**
	 * Constructs with the default.
	 * The hierarchy is the core container of the framework.
	 * It mainly includes the tool bar, content panel and status bar.
	 */
	public JFrameWorkHierarchy()
	{
		
	}
	
	/**
	 * Gets the status bar.
	 * @return the instance of JFrameWorkStatusBar
	 */
	public abstract JFrameWorkStatusBar getStatusBar();
}