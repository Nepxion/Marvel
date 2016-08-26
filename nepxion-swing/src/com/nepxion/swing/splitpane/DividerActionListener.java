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

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSplitPane;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class DividerActionListener
	implements ActionListener
{
	/**
	 * The instance of JSplitPane.
	 */
	private JSplitPane splitPane;
	
	/**
	 * The boolean value of minimum.
	 */
	private boolean minimum;
	
	/**
	 * Constructs with the specified initial split pane and minimum.
	 * @param splitPane the instance of JSplitPane
	 * @param minimum the boolean value of minimum
	 */
	public DividerActionListener(JSplitPane splitPane, boolean minimum)
	{
		this.splitPane = splitPane;
		this.minimum = minimum;
	}
	
    /**
     * Invoked when an action occurs.
     * @param e the instance of ActionEvent
     */
	public void actionPerformed(ActionEvent e)
	{
		if (splitPane == null)
		{
			throw new IllegalArgumentException("SplitPane can't be null");
		}
		
		BasicSplitPaneUI splitPaneUI = (BasicSplitPaneUI) splitPane.getUI();
		BasicSplitPaneDivider splitPaneDivider = splitPaneUI.getDivider();
		
		int orientation = splitPane.getOrientation();
		Insets insets = splitPane.getInsets();
		
		int lastLocation = splitPane.getLastDividerLocation();
		int currentLocation = splitPaneUI.getDividerLocation(splitPane);
		int newLocation;
		
		if (minimum)
		{
			if (orientation == JSplitPane.VERTICAL_SPLIT)
			{
				if (currentLocation >= (splitPane.getHeight() - insets.bottom - splitPaneDivider.getHeight()))
				{
					int maxLocation = splitPane.getMaximumDividerLocation();
					newLocation = Math.min(lastLocation, maxLocation);
				}
				else
				{
					newLocation = insets.top;
				}
			}
			else
			{
				if (currentLocation >= (splitPane.getWidth() - insets.right - splitPaneDivider.getWidth()))
				{
					int maxLocation = splitPane.getMaximumDividerLocation();
					newLocation = Math.min(lastLocation, maxLocation);
				}
				else
				{
					newLocation = insets.left;
				}
			}
		}
		else
		{
			if (orientation == JSplitPane.VERTICAL_SPLIT)
			{
				if (currentLocation == insets.top)
				{
					int maxLoc = splitPane.getMaximumDividerLocation();
					newLocation = Math.min(lastLocation, maxLoc);
				}
				else
				{
					newLocation = splitPane.getHeight() - splitPaneDivider.getHeight() - insets.top;
				}
			}
			else
			{
				if (currentLocation == insets.left)
				{
					int maxLoc = splitPane.getMaximumDividerLocation();
					newLocation = Math.min(lastLocation, maxLoc);
				}
				else
				{
					newLocation = splitPane.getWidth() - splitPaneDivider.getWidth() - insets.left;
				}
			}
		}
		if (currentLocation != newLocation)
		{
			splitPane.setDividerLocation(newLocation);
			splitPane.setLastDividerLocation(currentLocation);
		}
	}
}