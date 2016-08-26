package com.nepxion.swing.framework;

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

import javax.swing.BorderFactory;
import javax.swing.Box;

import com.nepxion.swing.statusbar.JStatusBar;
import com.nepxion.swing.statusbar.JStatusItem;
import com.nepxion.swing.timer.JTimerLabel;
import com.nepxion.swing.timer.JTimerProgressBar;

public class JFrameWorkStatusBar
	extends JStatusBar
{
	/**
	 * The instance of JTimerProgressBar.
	 */
	private JTimerProgressBar timerProgressBar;
	
	/**
	 * The instance of JTimerLabel.
	 */
	private JTimerLabel timerLabel;
	
	/**
	 * Constructs with the default.
	 */
	public JFrameWorkStatusBar()
	{
		setBorderVisible(false);
	}
	
	/**
	 * Shows the progress status.
	 */
	public void showProgressStatus()
	{
		timerProgressBar = new JTimerProgressBar(0, 100);
		timerProgressBar.setPreferredSize(new Dimension(60, 16));
		timerLabel = new JTimerLabel();
		
		JStatusItem statusItem = new JStatusItem();
		statusItem.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		statusItem.add(timerProgressBar);
		statusItem.add(Box.createHorizontalStrut(5));
		statusItem.add(timerLabel);
		statusItem.add(Box.createHorizontalStrut(5));
		
		addItem(statusItem, 80, RIGHT);
	}
	
	/**
	 * Starts the progress.
	 */
	public void start()
	{
		if (timerProgressBar != null)
		{	
			timerProgressBar.start();
		}
		
		if (timerLabel != null)
		{
			timerLabel.start();
		}	
	}
	
	/**
	 * Stops the progress.
	 */
	public void stop()
	{
		if (timerProgressBar != null)
		{	
			timerProgressBar.stop();			
		}
		
		if (timerLabel != null)
		{
			timerLabel.stop();
		}
	}
	
	/**
	 * Gets the timer progress bar.
	 * @return the instance of JTimerProgressBar
	 */
	public JTimerProgressBar getTimerProgressBar()
	{
		return timerProgressBar;
	}
	
	/**
	 * Gets the timer label.
	 * @return the instance of JTimerLabel
	 */
	public JTimerLabel getTimerLabel()
	{
		return timerLabel;
	}
}