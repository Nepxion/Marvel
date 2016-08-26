package com.nepxion.demo.control.selector;

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

public class DemoSelectorControlOutlook
	extends DemoToggleOutlook
{
	public DemoSelectorControlOutlook()
	{
		DemoToggleActionButton calendarSelectorButton = new DemoToggleActionButton(new DemoCalendarSelectorTogglePanel());
        addButton(calendarSelectorButton);  

		DemoToggleActionButton localeSelectorButton = new DemoToggleActionButton(new DemoLocaleSelectorTogglePanel());
        addButton(localeSelectorButton);  
        
		DemoToggleActionButton fileSelectorButton = new DemoToggleActionButton(new DemoFileSelectorTogglePanel());
        addButton(fileSelectorButton);    
        
		DemoToggleActionButton colorSelectorButton = new DemoToggleActionButton(new DemoColorSelectorTogglePanel());
        addButton(colorSelectorButton); 
        
		DemoToggleActionButton dropDownSelectorButton = new DemoToggleActionButton(new DemoDropDownSelectorTogglePanel());
        addButton(dropDownSelectorButton);
        
		DemoToggleActionButton checkBoxSelectorButton = new DemoToggleActionButton(new DemoCheckBoxSelectorTogglePanel());
        addButton(checkBoxSelectorButton);
        
		DemoToggleActionButton radioButtonSelectorButton = new DemoToggleActionButton(new DemoRadioButtonSelectorTogglePanel());
        addButton(radioButtonSelectorButton);        
        
        ButtonManager.updateUI(this, new Dimension(50, 70), new int[] {VERTICAL, CENTER});
	}
}