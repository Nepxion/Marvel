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

import javax.swing.AbstractButton;

import com.nepxion.swing.outlookbar.JFlatOutlook;

public class DemoToggleOutlook
	extends JFlatOutlook
{
	public DemoToggleOutlook()
	{
	}
	
	public void addButton(AbstractButton button)
	{
		super.addButton(button);
		
		DemoToggleButtonGroup.getInstance().add(button);
	}
}
