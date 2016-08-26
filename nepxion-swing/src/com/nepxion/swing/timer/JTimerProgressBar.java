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

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoundedRangeModel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class JTimerProgressBar
	extends JProgressBar implements ITimerComponent
{
	/**
	 * The instance of UpdateTimer.
	 */
	private UpdateTimer updateTimer;
	
	/**
	 * The delay time value.
	 */
	private int delayTime = 30;
	
	/**
	 * The value.
	 */
	private int value = 0;
	
	/**
	 * The block value.
	 */
	private int blockValue = 99;
	
	/**
	 * Constructs with the default.
	 */
	public JTimerProgressBar()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial orient.
	 * @param orient the orient value
	 */
	public JTimerProgressBar(int orient)
	{
		super(orient);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial min and max.
	 * @param min the minimum value
	 * @param max the maximum value
	 */
	public JTimerProgressBar(int min, int max)
	{
		super(min, max);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial min, max, delay time and block value.
	 * @param min the minimum value
	 * @param max the maximum value
	 * @param delayTime the delay time value
	 * @param blockValue the block value
	 */
	public JTimerProgressBar(int min, int max, int delayTime, int blockValue)
	{
		this(min, max);
		
		this.delayTime = delayTime;
		this.blockValue = blockValue;
	}
	
	/**
	 * Constructs with the specified initial orient, min and max.
	 * @param orient the orient value
	 * @param min the minimum value
	 * @param max the maximum value
	 */
	public JTimerProgressBar(int orient, int min, int max)
	{
		super(orient, min, max);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial orient, min, max, delay time and block value.
	 * @param orient the orient value
	 * @param min the minimum value
	 * @param max the maximum value
	 * @param delayTime the delay time value
	 * @param blockValue the block value
	 */
	public JTimerProgressBar(int orient, int min, int max, int delayTime, int blockValue)
	{
		this(orient, min, max);
		
		this.delayTime = delayTime;
		this.blockValue = blockValue;
	}
	
	/**
	 * Constructs with the specified initial new model.
	 * @param newModel the instance of BoundedRangeModel
	 */
	public JTimerProgressBar(BoundedRangeModel newModel)
	{
		super(newModel);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		setPreferredSize(new Dimension(getPreferredSize().width, 24));
		
		updateTimer = new UpdateTimer();
		
		setStringPainted(true);
		
		reset();
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
	 * Rests the timer.
	 */
	public void reset()
	{
		value = getMinimum();
		
		setValue(value);
	}
	
	/**
	 * Starts the timer.
	 */
	public void start()
	{
		reset();
		
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
	 * Restarts the timer.
	 */
	public void restart()
	{
		updateTimer.start();
	}
	
	/**
	 * Restarts the timer with a delay time.
	 * @param delayTime the delay time value
	 */
	public void restart(int delayTime)
	{
		setDelayTime(delayTime);
		
		restart();
	}
	
	/**
	 * Stops the timer.
	 */
	public void stop()
	{
		updateTimer.stop();
	}
	
	/**
	 * Finishes the timer.
	 */
	public void finish()
	{
		int max = getMaximum();
		setValue(max);
		
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
		}
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
	
	/**
	 * Gets the block value.
	 * @return the block value
	 */
	public int getBlockValue()
	{
		return blockValue;
	}
	
	/**
	 * Sets the block value.
	 * @param blockValue the block value
	 */
	public void setBlockValue(int blockValue)
	{
		this.blockValue = blockValue;
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
			if (getValue() < blockValue)
			{
				value++;
				setValue(value);
			}
			else
			{
				stop();
			}
		}
	}
}