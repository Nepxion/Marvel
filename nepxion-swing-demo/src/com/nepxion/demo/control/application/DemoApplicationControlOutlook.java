package com.nepxion.demo.control.application;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Dimension;

import com.nepxion.demo.common.DemoToggleActionButton;
import com.nepxion.demo.common.DemoToggleOutlook;
import com.nepxion.swing.button.ButtonManager;

public class DemoApplicationControlOutlook
	extends DemoToggleOutlook
{
	public DemoApplicationControlOutlook()
	{
		DemoToggleActionButton gisButton = new DemoToggleActionButton(new DemoGisTogglePanel());
		addButton(gisButton);
		
		DemoToggleActionButton ipButton = new DemoToggleActionButton(new DemoIPTogglePanel());
		addButton(ipButton);
		
		DemoToggleActionButton idButton = new DemoToggleActionButton(new DemoIDTogglePanel());
		addButton(idButton);
		
		DemoToggleActionButton mobileButton = new DemoToggleActionButton(new DemoMobileTogglePanel());
		addButton(mobileButton);
		
		DemoToggleActionButton zoneButton = new DemoToggleActionButton(new DemoZoneTogglePanel());
		addButton(zoneButton);
		
		ButtonManager.updateUI(this, new Dimension(50, 70), new int[] {VERTICAL, CENTER});
	}
}