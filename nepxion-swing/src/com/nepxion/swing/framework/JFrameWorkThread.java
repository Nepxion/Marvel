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

import java.awt.Component;
import java.awt.event.ActionEvent;

public abstract class JFrameWorkThread
	extends Thread
{
	/**
	 * The instance of Component.
	 */
	private Component component;
	
	/**
	 * The instance of JFrameWorkHierarchy.
	 */
	private JFrameWorkHierarchy frameWorkHierarchy;
	
	/**
	 * Constructs with the specified initial framework hierarchy.
	 * @param frameWorkHierarchy the instance of JFrameWorkHierarchy
	 */
	public JFrameWorkThread(JFrameWorkHierarchy frameWorkHierarchy)
	{
		this.frameWorkHierarchy = frameWorkHierarchy;
	}
	
	/**
	 * Constructs with the specified initial framework hierarchy and component.
	 * @param frameWorkHierarchy the instance of JFrameWorkHierarchy
	 * @param component the instance of Component
	 */
	public JFrameWorkThread(JFrameWorkHierarchy frameWorkHierarchy, Component component)
	{
		this.frameWorkHierarchy = frameWorkHierarchy;
		this.component = component;
	}
	
	/**
	 * Constructs with the specified initial framework hierarchy and action event.
	 * @param frameWorkHierarchy the instance of JFrameWorkHierarchy
	 * @param actionEvent the instance of ActionEvent
	 */
	public JFrameWorkThread(JFrameWorkHierarchy frameWorkHierarchy, ActionEvent actionEvent)
	{
		this.frameWorkHierarchy = frameWorkHierarchy;
		
		if (actionEvent != null)
		{
			Object object = actionEvent.getSource();
			if (object != null && object instanceof Component)
			{
				component = (Component) object;
			}
		}
	}
	
	/**
	 * Runs the thread.
	 */
	public void run()
	{
		try
		{
			Thread.sleep(50);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		setComponentEnabled(false);
		setThreadStatus(true);
		
		execute();
		
		setThreadStatus(false);
		setComponentEnabled(true);
	}
	
	/**
	 * Sets the component enabled.
	 * @param isEnabled the boolean value of enabled
	 */
	private void setComponentEnabled(boolean enabled)
	{
		if (component != null)
		{
			component.setEnabled(enabled);
		}
	}
	
	/**
	 * Sets the thread status.
	 * @param isStarted the boolean value of started.
	 */
	private void setThreadStatus(boolean started)
	{
		if (frameWorkHierarchy == null)
		{
			return;
		}
		
		JFrameWorkStatusBar frameWorkStatusBar = frameWorkHierarchy.getStatusBar();
		if (frameWorkStatusBar == null)
		{
			return;
		}
		
		if (frameWorkStatusBar.isVisible())
		{
			if (started)
			{
				frameWorkStatusBar.start();
			}
			else
			{
				frameWorkStatusBar.stop();
			}
		}
	}
	
	/**
	 * Executes.
	 */
	public abstract void execute();
}