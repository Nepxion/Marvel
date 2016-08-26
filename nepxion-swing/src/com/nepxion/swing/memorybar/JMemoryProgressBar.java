package com.nepxion.swing.memorybar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.text.NumberFormat;

import javax.swing.JProgressBar;
import javax.swing.Timer;

public class JMemoryProgressBar
	extends JProgressBar
{
	/**
	 * The kilo value.
	 */
	public static final int KILO = 1024;
	
	/**
	 * The mega string.
	 */
	public static final String MEGA = "M";
	
	/**
	 * The instance of UpdateTimer.
	 */
	private UpdateTimer updateTimer;
	
	/**
	 * The instance of MemoryMXBean.
	 */
	private MemoryMXBean memorybean;
	
	/**
	 * The instance of NumberFormat.
	 */
	private NumberFormat numberFormat;
	
	/**
	 * The delay time value.
	 */
	private int delayTime = 2000;
	
	/**
	 * Constructs with the default.
	 */
	public JMemoryProgressBar()
	{		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		updateTimer = new UpdateTimer();
		
		memorybean = ManagementFactory.getMemoryMXBean();
		numberFormat = NumberFormat.getInstance();
		
		setStringPainted(true);
		
		updateMemory();
	}
	
	/**
	 * Updates the memory.
	 */
	private void updateMemory()
	{
		long usedMemory = memorybean.getHeapMemoryUsage().getUsed();
		long totalMemory = memorybean.getHeapMemoryUsage().getMax();
		
		int percent = (int) (usedMemory * 100 / totalMemory);
		setValue(percent);
		
		String usedMega = numberFormat.format(usedMemory / KILO / KILO) + MEGA;
		String totalMega = numberFormat.format(totalMemory / KILO / KILO) + MEGA;
		String message = usedMega + "/" + totalMega;
		setString(message);
		
		setToolTipText("Memory used " + numberFormat.format(usedMemory) + " of total " + numberFormat.format(totalMemory));
	}
	
	/**
	 * Garbage collect.
	 */
	public void gc()
	{
		System.gc();
		
		updateMemory();
	}
	
	/**
	 * Returns true if the timer is running.
	 * @return true if the timer is running
	 */
	public boolean isRunning()
	{
		return updateTimer.isRunning();
	}
	
	/**
	 * Starts the timer.
	 */
	public void start()
	{
		updateTimer.start();
	}
	
	/**
	 * Starts the timer with a delay time.
	 * @param delayTime the delay time value
	 */
	public void start(int delayTime)
	{
		setDelayTime(delayTime);
		
		start();
	}
	
	/**
	 * Stops the timer.
	 */
	public void stop()
	{
		updateTimer.stop();
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
		this.updateTimer.setDelay(delayTime);
	}
	
	public class UpdateTimer
		extends Timer implements ActionListener
	{
		/**
		 * Constructs with the default.
		 */
		public UpdateTimer()
		{
			super(delayTime, null);
			
			addActionListener(this);
		}
		
		/**
		 * Invoked when an action occurs.
		 * @param e the instance of ActionEvent
		 */
		public void actionPerformed(ActionEvent e)
		{
			updateMemory();
		}
	}
}