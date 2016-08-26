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
import javax.swing.JEditorPane;

import com.nepxion.demo.common.DemoTogglePanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoTextPaneTogglePanel
	extends DemoTogglePanel
{
	public DemoTextPaneTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		JEditorPane editorPane = new JEditorPane();	
	}
	
	public String getToggleText()
	{
		return "TextPane";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/text_area_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/text_area_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style TextPane";
	}
}