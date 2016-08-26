package com.nepxion.demo.common;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.swing.toggle.JToggleActionButton;

public class DemoToggleActionButton
	extends JToggleActionButton
{
	public DemoToggleActionButton(DemoTogglePanel togglePanel)
	{
		super(DemoToggleContentPanel.getInstance(), togglePanel);
	}
}
