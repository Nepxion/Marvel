package com.nepxion.swing.chart.pie;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import org.jfree.chart.plot.PiePlot;

import com.nepxion.swing.chart.JChartPanel;

public class PiePlotRotator
	extends Timer implements ActionListener
{
	/**
	 * The instance of PiePlot.
	 */
	private PiePlot piePlot;
	
	/**
	 * The rotation angle value.
	 */
	private int angle;
	
	/**
	 * Constructs with the specified initial chartPanel and isClickingStarted.
	 * @param chartPanel the instance of JChartPanel
	 * @param isClickingStarted the boolean value of isClickingStarted
	 */
	public PiePlotRotator(JChartPanel chartPanel, boolean isClickingStarted)
	{
		this(chartPanel, 100, isClickingStarted);
	}
	
	/**
	 * Constructs with the specified initial chartPanel, delay and isClickingStarted.
	 * @param chartPanel the instance of JChartPanel
	 * @param delay the delay value
	 * @param isClickingStarted the boolean value of isClickingStarted
	 */
	public PiePlotRotator(JChartPanel chartPanel, int delay, boolean isClickingStarted)
	{
		super(delay, null);
		
		this.angle = 270;
		this.piePlot = (PiePlot) chartPanel.getChart().getPlot();
		
		if (isClickingStarted)
		{	
			chartPanel.addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{
					if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1)
					{
						execute();
					}
				}
			}
			);
		}
		addActionListener(this);
	}
	
    /**
     * Invoked when an action occurs.
     * @param e the instance of ActionEvent
     */
	public void actionPerformed(ActionEvent e)
	{
		piePlot.setStartAngle(angle);
		angle = angle + 1;
		if (angle == 360)
		{
			angle = 0;
		}
	}
	
	/**
	 * Executes the timer.
	 */
	public void execute()
	{
		if (!isRunning())
		{
			start();
		}
		else
		{
			stop();
		}
	}
}