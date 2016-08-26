package com.nepxion.swing.splitpane;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.HierarchyEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import com.jidesoft.swing.JideSplitPane;
import com.nepxion.swing.layout.box.XBoxLayout;
import com.nepxion.swing.listener.DisplayAbilityListener;

public class JBasicSplitPane
	extends JideSplitPane
{
	/**
	 * The layout of fix.
	 */
	public static final String FIX = XBoxLayout.FIX;
	
	/**
	 * The layout of flexible.
	 */
	public static final String FLEXIBLE = XBoxLayout.FLEXIBLE;
	
	/**
	 * The layout of vary.
	 */
	public static final String VARY = XBoxLayout.VARY;
	
	/**
	 * The divider locations.
	 */
	private Map dividerLocations;
	
	/**
	 * Constructs with the default.
	 */
	public JBasicSplitPane()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial new orientation.
	 * @param newOrientation the new orientation value
	 */
	public JBasicSplitPane(int newOrientation)
	{
		super(newOrientation);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		dividerLocations = new HashMap();
		
		setDividerSize(5);
		addHierarchyListener(new DisplayAbilityListener()
		{
			public void displayAbilityChanged(HierarchyEvent e)
			{
				adaptDividerLocation();
				
				removeHierarchyListener(this);
			}
		}
		);
	}
	
	/**
	 * Adapts the divider location.
	 */
	private void adaptDividerLocation()
	{
		if (dividerLocations != null)
		{
			for (Iterator iterator = dividerLocations.keySet().iterator(); iterator.hasNext();)
			{
				Object key = iterator.next();
				int index = ((Integer) key).intValue();
				int location = ((Integer) dividerLocations.get(key)).intValue();
				
				JBasicSplitPane.super.setDividerLocation(index, location);
				
				setPaneSize(index, location);
			}
			dividerLocations = null;
		}
	}
	
	/**
	 * Sets the divider location.
	 * @param index the index value
	 * @param location the location value
	 */
	public void setDividerLocation(int index, int location)
	{
		if (dividerLocations == null)
		{
			super.setDividerLocation(index, location);
		}
		else
		{
			dividerLocations.put(new Integer(index), new Integer(location));
		}
	}
	
	/**
	 * Sets the pane size.
	 * @param index the index value
	 * @param size the size value
	 */
	private void setPaneSize(final int index, final int size)
	{
		Component pane = getPaneAt(index);
		if (pane != null && pane instanceof JComponent)
		{
			int width = 0;
			int height = 0;
			if (getOrientation() == VERTICAL_SPLIT)
			{
				width = getPreferredSize().width;
				height = size;
			}
			else if (getOrientation() == HORIZONTAL_SPLIT)
			{
				width = size;
				height = getPreferredSize().height;
			}
			
			JComponent component = (JComponent) pane;
			Dimension dimension = new Dimension(width, height);
			
			component.setPreferredSize(dimension);
		}
	}
	
	/**
	 * Update the ui.
	 */
	public void updateUI()
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				JBasicSplitPane.super.updateUI();
			}
		}
		);
	}
}