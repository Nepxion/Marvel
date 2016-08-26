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

import javax.swing.Icon;

import com.nepxion.demo.common.DemoTogglePanel;
import com.nepxion.demo.common.DemoToggleTemplate;
import com.nepxion.demo.component.spinner.DemoPointSpinnerFieldPanel;
import com.nepxion.demo.component.spinner.DemoNumberSpinnerFieldPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoSpinnerTogglePanel
	extends DemoTogglePanel
{
	public DemoSpinnerTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Number SpinnerField", IconFactory.getSwingIcon("component/spinner_16.png"), new DemoToggleTemplate(new DemoNumberSpinnerFieldPanel()), "Number SpinnerField");		
		toggleTabbedPane.addTab("Point SpinnerField", IconFactory.getSwingIcon("component/spinner_16.png"), new DemoToggleTemplate(new DemoPointSpinnerFieldPanel()), "Point SpinnerField");		
	}
	
	public String getToggleText()
	{
		return "Spinner";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/spinner_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/spinner_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Spinner";
	}
}