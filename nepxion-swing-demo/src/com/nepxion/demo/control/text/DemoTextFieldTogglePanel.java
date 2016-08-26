package com.nepxion.demo.control.text;

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
import com.nepxion.demo.component.textfield.DemoBasicTextFieldPanel;
import com.nepxion.demo.component.textfield.DemoHoverBorderTextFieldPanel;
import com.nepxion.demo.component.textfield.DemoIPAddressPanel;
import com.nepxion.demo.component.textfield.DemoLabelStyleTextFieldPanel;
import com.nepxion.demo.component.textfield.DemoNumberTextFieldPanel;
import com.nepxion.demo.component.textfield.DemoUnderlineBorderTextFieldPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoTextFieldTogglePanel
	extends DemoTogglePanel
{
	public DemoTextFieldTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Basic TextField", IconFactory.getSwingIcon("component/text_field_16.png"), new DemoToggleTemplate(new DemoBasicTextFieldPanel()), "Basic TextField");
		toggleTabbedPane.addTab("Number TextField", IconFactory.getSwingIcon("component/text_field_16.png"), new DemoToggleTemplate(new DemoNumberTextFieldPanel()), "Number TextField");
		toggleTabbedPane.addTab("IP Address TextField", IconFactory.getSwingIcon("component/text_field_16.png"), new DemoToggleTemplate(new DemoIPAddressPanel()), "IP Address TextField");
		toggleTabbedPane.addTab("Label Style TextField", IconFactory.getSwingIcon("component/text_field_16.png"), new DemoToggleTemplate(new DemoLabelStyleTextFieldPanel()), "Label Style TextField");
		toggleTabbedPane.addTab("Hover Border TextField", IconFactory.getSwingIcon("component/text_field_16.png"), new DemoToggleTemplate(new DemoHoverBorderTextFieldPanel()), "Hover Border TextField");
		toggleTabbedPane.addTab("Underline Border TextField", IconFactory.getSwingIcon("component/text_field_16.png"), new DemoToggleTemplate(new DemoUnderlineBorderTextFieldPanel()), "Underline Border TextField");		
	}
	
	public String getToggleText()
	{
		return "TextField";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/text_field_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/text_field_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style TextField";
	}
}