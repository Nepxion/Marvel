package com.nepxion.demo.control.data;

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

public class DemoDataControlOutlook
	extends DemoToggleOutlook
{
	public DemoDataControlOutlook()
	{
		DemoToggleActionButton treeButton = new DemoToggleActionButton(new DemoTreeTogglePanel());
        addButton(treeButton);
        
		DemoToggleActionButton tableButton = new DemoToggleActionButton(new DemoTableTogglePanel());
        addButton(tableButton);
        
		DemoToggleActionButton listButton = new DemoToggleActionButton(new DemoListTogglePanel());
        addButton(listButton);        
        
        ButtonManager.updateUI(this, new Dimension(50, 70), new int[] {VERTICAL, CENTER});
	}
}