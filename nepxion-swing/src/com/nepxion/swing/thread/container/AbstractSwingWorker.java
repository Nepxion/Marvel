package com.nepxion.swing.thread.container;

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

import com.nepxion.swing.swingworker.JSwingWorker;

public abstract class AbstractSwingWorker
	extends JSwingWorker
{
	/**
	 * The delay time value.
	 */
	private int delayTime = 0;
	
	/**
	 * Constructs with the specified initial component and delay time.
	 * @param component the instance of Component
	 * @param delayTime the delay time value
	 */
	public AbstractSwingWorker(Component component, int delayTime)
	{
		super(component);
		
		this.delayTime = delayTime;
	}
	
	/**
	 * Gets the delay time.
	 * @return the delay time value
	 */
	public int getDelayTime()
	{
		return delayTime;
	}
	
	/**
	 * Sets the delay time.
	 * @param delayTime the delay time value
	 */
	public void setDelayTime(int delayTime)
	{
		this.delayTime = delayTime;
	}
	
	/**
	 * Invoked when the swing worker loads the background data.
	 * @return the background data
	 */
	protected Object doInBackground()
		throws Exception
	{
		AbstractThreadContainer threadContainer = (AbstractThreadContainer) getComponent();
		if (delayTime > 0)
		{
			threadContainer.start(delayTime);
		}
		else
		{
			threadContainer.start();
		}
		
		Object data = super.doInBackground();
		
		threadContainer.finish();
		
		return data;
	}
	
	/**
	 * Fires the pending status changed.
	 */
	public void firePendingStatusChanged()
	{
		
	}
	
	/**
	 * Fires the started status changed.
	 */
	public void fireStartedStatusChanged()
	{
		AbstractThreadContainer threadContainer = (AbstractThreadContainer) getComponent();
		threadContainer.showThread();
	}
	
	/**
	 * Fires the done status changed.
	 */
	public void fireDoneStatusChanged()
	{
		AbstractThreadContainer threadContainer = (AbstractThreadContainer) getComponent();
		threadContainer.stop();
	}
	
	/**
	 * Fires the progress value changed.
	 * @param value the value object
	 */
	public void fireProgressValueChanged(Object value)
	{
		
	}
	
	/**
	 * Fires the cancelled status changed.
	 */
	public void fireCancelledStatusChanged()
	{
		AbstractThreadContainer threadContainer = (AbstractThreadContainer) getComponent();
		threadContainer.stop();
		threadContainer.showInformation();
	}
	
	/**
	 * Fires the foreground exception.
	 * @param e the instance of Exception
	 */
	public void fireForegroundException(Exception e)
	{
		AbstractThreadContainer threadContainer = (AbstractThreadContainer) getComponent();
		threadContainer.stop();
		threadContainer.showError();
	}
	
	/**
	 * Fires the background exception.
	 * @param e the instance of Exception
	 */
	public void fireBackgroundException(Exception e)
	{
		
	}
}