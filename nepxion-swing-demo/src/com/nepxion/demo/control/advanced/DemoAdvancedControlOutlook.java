package com.nepxion.demo.control.advanced;

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

public class DemoAdvancedControlOutlook
	extends DemoToggleOutlook
{
	public DemoAdvancedControlOutlook()
	{
		DemoToggleActionButton plugInButton = new DemoToggleActionButton(new DemoPlugInTogglePanel());
		addButton(plugInButton);
		
		DemoToggleActionButton searchableButton = new DemoToggleActionButton(new DemoSearchableTogglePanel());
		addButton(searchableButton);
		
		DemoToggleActionButton completionButton = new DemoToggleActionButton(new DemoCompletionTogglePanel());
		addButton(completionButton);
		
		DemoToggleActionButton hintButton = new DemoToggleActionButton(new DemoHintTogglePanel());
		addButton(hintButton);
		
		DemoToggleActionButton fullScreenButton = new DemoToggleActionButton(new DemoFullScreenTogglePanel());
		addButton(fullScreenButton);
				
		DemoToggleActionButton paginationButton = new DemoToggleActionButton(new DemoPaginationTogglePanel());
		addButton(paginationButton);
		
		DemoToggleActionButton toggleButton = new DemoToggleActionButton(new DemoToggleTogglePanel());
		addButton(toggleButton);
		
		DemoToggleActionButton configButton = new DemoToggleActionButton(new DemoConfigTogglePanel());
		addButton(configButton);
		
		DemoToggleActionButton wizardButton = new DemoToggleActionButton(new DemoWizardTogglePanel());
		addButton(wizardButton);
		
		DemoToggleActionButton trayButton = new DemoToggleActionButton(new DemoTrayTogglePanel());
		addButton(trayButton);
		
		DemoToggleActionButton tipButton = new DemoToggleActionButton(new DemoTipTogglePanel());
		addButton(tipButton);
		
		ButtonManager.updateUI(this, new Dimension(50, 70), new int[] {VERTICAL, CENTER});
	}
}