package com.nepxion.demo.control.container;

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

public class DemoContainerControlOutlook
	extends DemoToggleOutlook
{
	public DemoContainerControlOutlook()
	{
		DemoToggleActionButton windowButton = new DemoToggleActionButton(new DemoWindowTogglePanel());
        addButton(windowButton);
        
		DemoToggleActionButton frameButton = new DemoToggleActionButton(new DemoFrameTogglePanel());
        addButton(frameButton);
        
		DemoToggleActionButton dialogButton = new DemoToggleActionButton(new DemoDialogTogglePanel());
        addButton(dialogButton);
                
		DemoToggleActionButton panelButton = new DemoToggleActionButton(new DemoPanelTogglePanel());
        addButton(panelButton);
        
		DemoToggleActionButton scrollPaneButton = new DemoToggleActionButton(new DemoScrollPaneTogglePanel());
        addButton(scrollPaneButton);
        
		DemoToggleActionButton splitPaneButton = new DemoToggleActionButton(new DemoSplitPaneTogglePanel());
        addButton(splitPaneButton);
        
		DemoToggleActionButton optionPaneButton = new DemoToggleActionButton(new DemoOptionPaneTogglePanel());
        addButton(optionPaneButton);
        
		DemoToggleActionButton tabbedPaneButton = new DemoToggleActionButton(new DemoTabbedPaneTogglePanel());
        addButton(tabbedPaneButton);
        
        ButtonManager.updateUI(this, new Dimension(50, 70), new int[] {VERTICAL, CENTER});
	}
}
