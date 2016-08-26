package com.nepxion.demo;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.swing.framework.JFrameWorkStatusBar;
import com.nepxion.swing.framework.ribbon.JRibbonHierarchy;

public class DemoRibbonHierarchy
	extends JRibbonHierarchy
{
	public DemoRibbonHierarchy()
	{
		initNavigatorBar();
		initContentPane();
		initStatusBar();
	}
	
	private void initNavigatorBar()
	{
		new DemoRibbonNavigatorBar(this);
	}
	
	private void initContentPane()
	{
		new DemoRibbonWorkspaceBar(this);
	}
	
	private void initStatusBar()
	{
		JFrameWorkStatusBar statusBar = getStatusBar();
		statusBar.setVisible(false);
	}
}