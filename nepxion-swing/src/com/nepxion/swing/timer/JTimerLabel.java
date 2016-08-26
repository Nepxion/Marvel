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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.Timer;

import com.nepxion.swing.icon.IconFactory;

public class JTimerLabel
	extends JLabel implements ITimerComponent
{
	/**
	 * The path of the loop icon.
	 */
	public static final String LOOP_ICON = "thread/loop/";
	
	/**
	 * The path of the ball icon.
	 */
	public static final String BALL_ICON = "thread/ball/";
	
	/**
	 * The path of the circle icon.
	 */
	public static final String CIRCLE_ICON = "thread/circle/";
	
	/**
	 * The path of the compass icon.
	 */
	public static final String COMPASS_ICON = "thread/compass/";
	
	/**
	 * The path of the magnifier icon.
	 */
	public static final String MAGNIFIER_ICON = "thread/magnifier/";
	
	/**
	 * The instance of UpdateTimer.
	 */
	private UpdateTimer updateTimer;
	
	/**
	 * The delay time value.
	 */
	private int delayTime = 30;
	
	/**
	 * The icon group array.
	 */
	private Icon[] iconGroup;
	
	/**
	 * The index value.
	 */
	private int index = 0;
	
	/**
	 * Constructs with the default.
	 */
	public JTimerLabel()
	{
		this(LOOP_ICON);
	}
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the icon string
	 */
	public JTimerLabel(String icon)
	{
		updateTimer = new UpdateTimer();
		
		if (icon.equals(LOOP_ICON))
		{
			iconGroup = new Icon[15];
			updateTimer.setDelay(30);
		}
		else if (icon.equals(BALL_ICON))
		{
			iconGroup = new Icon[30];
			updateTimer.setDelay(80);
		}
		else if (icon.equals(CIRCLE_ICON))
		{
			iconGroup = new Icon[60];
			updateTimer.setDelay(80);
		}
		else if (icon.equals(COMPASS_ICON))
		{
			iconGroup = new Icon[15];
			updateTimer.setDelay(350);
		}
		else if (icon.equals(MAGNIFIER_ICON))
		{
			iconGroup = new Icon[22];
			updateTimer.setDelay(80);
		}
		for (int i = 0; i < iconGroup.length; i++)
		{
			iconGroup[i] = IconFactory.getSwingIcon(icon + (i + 1) + ".png");
		}
		
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
		index = 0;
		
		setIcon(iconGroup[0]);
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
			index = (index + 1) % iconGroup.length;
			
			setIcon(iconGroup[index]);
		}
	}
}