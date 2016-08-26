package com.nepxion.swing.tween;

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
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class PositionTweener
	implements ActionListener
{
	/**
	 * The instance of Component.
	 */
	private Component component;
	
	/**
	 * The frame interval value.
	 */
	private int frameInterval = 1;
	
	/**
	 * The frame count value.
	 */
	private int frameCount = 20;
	
	/**
	 * The frame index value.
	 */
	private int frameIndex = 0;
	
	/**
	 * The instance of Timer.
	 */
	private Timer timer;
	
	/**
	 * The start bounds.
	 */
	private Rectangle startBounds;
	
	/**
	 * The end bounds.
	 */
	private Rectangle endBounds;
	
	/**
	 * Constructs with the specified initial component.
	 * @param component the instance of Component
	 * @param frameInterval the frame interval value
	 * @param frameCount the frame count value
	 */
	public PositionTweener(Component component, Rectangle startBounds, Rectangle endBounds)
	{
		this(component, startBounds, endBounds, 1, 20);
	}
	
	/**
	 * Constructs with the specified initial component, start bounds, end
	 * bounds, frame interval and frame count.
	 * @param component the instance of Component
	 * @param startBounds the instance of Rectangle
	 * @param endBounds the instance of Rectangle
	 * @param frameInterval the frame interval value
	 * @param frameCount the frame count value
	 */
	public PositionTweener(Component component, Rectangle startBounds, Rectangle endBounds, int frameInterval, int frameCount)
	{
		this.component = component;
		this.startBounds = startBounds;
		this.endBounds = endBounds;
		
		this.frameInterval = frameInterval;
		this.frameCount = frameCount;
		
		timer = new Timer(this.frameInterval, this);
	}
	
	/**
	 * Invokes the tweening.
	 */
	public void tween()
	{
		timer.start();
	}
	
	/**
	 * Invoked when an action occurs.
	 * @param e the instance of ActionEvent
	 */
	public void actionPerformed(ActionEvent e)
	{
		int startX = startBounds.x;
		int startY = startBounds.y;
		int startWidth = startBounds.width;
		int startHeight = startBounds.height;
		
		int endX = endBounds.x;
		int endY = endBounds.y;
		int endWidth = endBounds.width;
		int endHeight = endBounds.height;
		
		int xOffset = (endX - startX) * frameIndex / frameCount;
		int yOffset = (endY - startY) * frameIndex / frameCount;
		int widthOffset = (endWidth - startWidth) * frameIndex / frameCount;
		int heightOffset = (endHeight - startHeight) * frameIndex / frameCount;
		
		Rectangle bounds = new Rectangle(startX + xOffset, startY + yOffset, startWidth + widthOffset, startHeight + heightOffset);
		component.setBounds(bounds);
		component.validate();
		
		if (frameIndex == frameCount)
		{
			timer.stop();
		}
		else
		{
			frameIndex++;
		}
	}
}