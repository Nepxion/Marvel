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

import java.awt.BorderLayout;

import javax.swing.JLabel;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.toggle.JToggleContentPanel;

public class DemoToggleContentPanel
	extends JToggleContentPanel
{
	private static DemoToggleContentPanel toggleContentPanel;
	
	public static DemoToggleContentPanel getInstance()
	{
		if (toggleContentPanel == null)
		{
			toggleContentPanel = new DemoToggleContentPanel();
		}
		
		return toggleContentPanel;
	}
	
	private DemoToggleContentPanel()
	{
		super();
		
		JLabel logoLabel = new JLabel(IconFactory.getSwingIcon("logo.png"));
		getHeader().add(logoLabel, BorderLayout.EAST);
	}
}