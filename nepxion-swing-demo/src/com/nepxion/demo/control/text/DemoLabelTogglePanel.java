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
import com.nepxion.demo.component.label.DemoStyledLabelBuilderPanel;
import com.nepxion.demo.component.label.DemoStyledLabelPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoLabelTogglePanel
	extends DemoTogglePanel
{
	public DemoLabelTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Styled Label", IconFactory.getSwingIcon("component/label_16.png"), new DemoToggleTemplate(new DemoStyledLabelPanel()), "Styled Label");
		toggleTabbedPane.addTab("Style Label Builder", IconFactory.getSwingIcon("component/label_16.png"), new DemoToggleTemplate(new DemoStyledLabelBuilderPanel()), "Style Label Builder");
	}
	
	public String getToggleText()
	{
		return "Label";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/label_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/label_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Label";
	}
}