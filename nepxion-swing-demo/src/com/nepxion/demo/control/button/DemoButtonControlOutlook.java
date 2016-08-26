package com.nepxion.demo.control.button;

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

public class DemoButtonControlOutlook
	extends DemoToggleOutlook
{
	public DemoButtonControlOutlook()
	{
		DemoToggleActionButton buttonButton = new DemoToggleActionButton(new DemoButtonTogglePanel());
        addButton(buttonButton);
        
        DemoToggleActionButton checkBoxButton = new DemoToggleActionButton(new DemoCheckBoxTogglePanel());
        addButton(checkBoxButton);  
        
        DemoToggleActionButton radioButtonButton = new DemoToggleActionButton(new DemoRadioButtonTogglePanel());
        addButton(radioButtonButton);        
        
        DemoToggleActionButton comboBoxButton = new DemoToggleActionButton(new DemoComboBoxTogglePanel());
        addButton(comboBoxButton);
        
		DemoToggleActionButton spinnerButton = new DemoToggleActionButton(new DemoSpinnerTogglePanel());
        addButton(spinnerButton);
        
		DemoToggleActionButton slideButton = new DemoToggleActionButton(new DemoSlideTogglePanel());
        addButton(slideButton);        
        
        ButtonManager.updateUI(this, new Dimension(50, 70), new int[] {VERTICAL, CENTER});
        
        buttonButton.doClick();
	}
}