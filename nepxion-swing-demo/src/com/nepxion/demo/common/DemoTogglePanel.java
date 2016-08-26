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

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.HierarchyEvent;

import javax.swing.BorderFactory;

import com.nepxion.swing.framework.ribbon.IRibbonComponent;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.listener.DisplayAbilityListener;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;
import com.nepxion.swing.toggle.JThreadTogglePanel;

public abstract class DemoTogglePanel
	extends JThreadTogglePanel implements IRibbonComponent
{
	private JEclipseTabbedPane toggleTabbedPane;
	
	public DemoTogglePanel()
	{
		super("Initializing, please wait...");
		
		setToggleBannerIcon(IconFactory.getSwingIcon("banner/edit.png"));
		setInformationText("Initialize the component");
		setInformationIcon(IconFactory.getSwingIcon("banner/query_128.png"));
		setErrorText("Initialize the component failure");
		setErrorIcon(IconFactory.getSwingIcon("banner/error_128.png"));
		setThreadPanelWidth(300);
		
		showInformation();
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		
		addHierarchyListener(new DisplayAbilityListener()
		{
			public void displayAbilityChanged(HierarchyEvent e)
			{
				execute();
				
				removeHierarchyListener(this);
			}
		}
		);
	}
	
	public JEclipseTabbedPane getToggleTabbedPane()
	{
		return toggleTabbedPane;
	}
	
	public Component getContentPane()
	{
		return toggleTabbedPane;
	}
	
	public boolean isLoadCache()
	{
		return toggleTabbedPane != null;
	}
	
	protected void loadForeground(Object data)
		throws Exception
	{
		if (toggleTabbedPane == null)
		{
			toggleTabbedPane = new JEclipseTabbedPane();
			add(toggleTabbedPane, BorderLayout.CENTER);
			
			initialize();
		}
	}
	
	protected Object loadBackground()
		throws Exception
	{
		return null;
	}
	
	public Object getUserObject()
	{
		return null;
	}
	
	public void setUserObject(Object userObject)
	{
		
	}
	
	public abstract void initialize();
}

/*
public abstract class DemoTogglePanel
	extends JTogglePanel implements IRibbonComponent
{
	private JEclipseTabbedPane toggleTabbedPane;
	
	public DemoTogglePanel()
	{
		toggleTabbedPane = new JEclipseTabbedPane();
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		add(toggleTabbedPane, BorderLayout.CENTER);
		
		initialize();
	}
	
	public JEclipseTabbedPane getToggleTabbedPane()
	{
		return toggleTabbedPane;
	}
	
	public Object getUserObject()
	{
		return null;
	}
	
	public void setUserObject(Object userObject)
	{
		
	}
	
	public abstract void initialize();
}
*/