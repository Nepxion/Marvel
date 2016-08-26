package com.nepxion.demo.control.layout;
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

public class DemoLayoutControlOutlook
	extends DemoToggleOutlook
{
	public DemoLayoutControlOutlook()
	{
		DemoToggleActionButton tableLayoutButton = new DemoToggleActionButton(new DemoTableLayoutTogglePanel());
        addButton(tableLayoutButton);
        
		DemoToggleActionButton filedLayoutButton = new DemoToggleActionButton(new DemoFiledLayoutTogglePanel());
        addButton(filedLayoutButton);
        
		DemoToggleActionButton ratioLayoutButton = new DemoToggleActionButton(new DemoRatioLayoutTogglePanel());
        addButton(ratioLayoutButton);        
        
		DemoToggleActionButton xBorderLayoutButton = new DemoToggleActionButton(new DemoXBorderLayoutTogglePanel());
        addButton(xBorderLayoutButton); 
        
		DemoToggleActionButton xBoxLayoutButton = new DemoToggleActionButton(new DemoXBoxLayoutTogglePanel());
        addButton(xBoxLayoutButton);      
        
        ButtonManager.updateUI(this, new Dimension(50, 70), new int[] {VERTICAL, CENTER});
	}
}