package com.nepxion.demo.control.chart;

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

public class DemoChartControlOutlook
	extends DemoToggleOutlook
{
	public DemoChartControlOutlook()
	{		
		DemoToggleActionButton pieChartButton = new DemoToggleActionButton(new DemoPieChartTogglePanel());
        addButton(pieChartButton);
        
		DemoToggleActionButton barChartButton = new DemoToggleActionButton(new DemoBarChartTogglePanel());
        addButton(barChartButton);
        
		DemoToggleActionButton lineChartButton = new DemoToggleActionButton(new DemoLineChartTogglePanel());
        addButton(lineChartButton);
        
		ButtonManager.updateUI(this, new Dimension(50, 70), new int[] {VERTICAL, CENTER});
	}
}