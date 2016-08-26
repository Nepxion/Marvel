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

import javax.swing.ButtonGroup;

public class DemoToggleButtonGroup
	extends ButtonGroup
{
	private static DemoToggleButtonGroup buttonGroup;
	
	public static DemoToggleButtonGroup getInstance()
	{
		if (buttonGroup == null)
		{
			buttonGroup = new DemoToggleButtonGroup(); 
		}
		
		return buttonGroup;
	}
	
	private DemoToggleButtonGroup()
	{
	}
}