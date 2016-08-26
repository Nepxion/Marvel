package com.nepxion.swing.timer;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

public interface ITimerComponent
{
	/**
	 * Returns true if the timer is running.
	 * @return true if the timer is running
	 */
	public boolean isRunning();
	
	/**
	 * Rests the timer.
	 */
	public void reset();
	
	/**
	 * Starts the timer.
	 */
	public void start();
	
	/**
	 * Starts the timer with a delay time.
	 * @param delayTime the delay time value
	 */
	public void start(int delayTime);
	
	/**
	 * Restarts the timer.
	 */
	public void restart();
	
	/**
	 * Restarts the timer with a delay time.
	 * @param delayTime the delay time value
	 */
	public void restart(int delayTime);
	
	/**
	 * Stops the timer.
	 */
	public void stop();
	
	/**
	 * Finishes the timer.
	 */
	public void finish();
	
	/**
	 * Gets the delay time.
	 * @return the delay time value
	 */
	public int getDelayTime();
	
	/**
	 * Sets the delay time.
	 * @param delayTime the delay time value
	 */
	public void setDelayTime(int delayTime);
}