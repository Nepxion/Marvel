package com.nepxion.demo.control.bar;

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

public class DemoBarControlOutlook
	extends DemoToggleOutlook
{
	public DemoBarControlOutlook()
	{
		DemoToggleActionButton taskBarButton = new DemoToggleActionButton(new DemoTaskBarTogglePanel());
        addButton(taskBarButton); 
        
		DemoToggleActionButton outlookBarButton = new DemoToggleActionButton(new DemoOutlookBarTogglePanel());
        addButton(outlookBarButton); 
        
		DemoToggleActionButton buttonBarButton = new DemoToggleActionButton(new DemoButtonBarTogglePanel());
        addButton(buttonBarButton);
        
		DemoToggleActionButton shrinkBarButton = new DemoToggleActionButton(new DemoShrinkBarTogglePanel());
        addButton(shrinkBarButton); 
        
		DemoToggleActionButton toolBarButton = new DemoToggleActionButton(new DemoToolBarTogglePanel());
        addButton(toolBarButton); 
        
		DemoToggleActionButton menuBarButton = new DemoToggleActionButton(new DemoMenuBarTogglePanel());
        addButton(menuBarButton); 
        
		DemoToggleActionButton statusBarButton = new DemoToggleActionButton(new DemoStatusBarTogglePanel());
        addButton(statusBarButton); 
                
        ButtonManager.updateUI(this, new Dimension(50, 70), new int[] {VERTICAL, CENTER});
	}
}