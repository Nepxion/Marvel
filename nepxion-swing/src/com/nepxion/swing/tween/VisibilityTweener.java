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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class VisibilityTweener
	implements ActionListener
{
	/**
	 * The instance of Component.
	 */
	private Component component;
	
	/**
	 * The instance of Dimension.
	 */
	private Dimension dimension;
	
	/**
	 * The boolean value of horizontalTweening.
	 */
	private boolean horizontalTweening = true;
	
	/**
	 * The boolean value of verticalTweening.
	 */
	private boolean verticalTweening = true;
	
	/**
	 * The boolean value of visibleTweening.
	 */
	private boolean visibleTweening = true;
	
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
	private int frameIndex;
	
	/**
	 * The instance of Timer.
	 */
	private Timer timer;
	
	/**
	 * Constructs with the specified initial component.
	 * @param component the instance of Component
	 */
	public VisibilityTweener(Component component)
	{
		this(component, true, true);
	}
	
	/**
	 * Constructs with the specified initial component, frame interval and frame count.
	 * @param component the instance of Component
	 * @param frameInterval the frame interval value
	 * @param frameCount the frame count value
	 */
	public VisibilityTweener(Component component, int frameInterval, int frameCount)
	{
		this(component, true, true, frameInterval, frameCount);
	}
	
	/**
	 * Constructs with the specified initial component, horizontal tweening and vertical tweening.
	 * @param component the instance of Component
	 * @param horizontalTweening the boolean value of horizontalTweening
	 * @param verticalTweening the boolean value of verticalTweening
	 */
	public VisibilityTweener(Component component, boolean horizontalTweening, boolean verticalTweening)
	{
		this(component, horizontalTweening, verticalTweening, 1, 20);
	}
	
	/**
	 * Constructs with the specified initial component, horizontal tweening, vertical tweening, frame interval and frame count.
	 * @param component the instance of Component
	 * @param horizontalTweening the boolean value of horizontalTweening
	 * @param verticalTweening the boolean value of verticalTweening
	 * @param frameInterval the frame interval value
	 * @param frameCount the frame count value
	 */
	public VisibilityTweener(Component component, boolean horizontalTweening, boolean verticalTweening, int frameInterval, int frameCount)
	{
		this.component = component;
		this.dimension = component.getSize();
		
		this.horizontalTweening = horizontalTweening;
		this.verticalTweening = verticalTweening;
		
		this.frameInterval = frameInterval;
		this.frameCount = frameCount;
				
		timer = new Timer(this.frameInterval, this);
	}
	
	/**
	 * Invokes the tweening.
	 * @param visibleTweening the boolean value of visibleTweening
	 */
	public void tween(boolean visibleTweening)
	{		
		this.visibleTweening = visibleTweening;
		
		if (visibleTweening)
		{
			frameIndex = 0;
			
			component.setSize(0, 0);
			component.setVisible(true);
		}
		else
		{
			frameIndex = frameCount;
		}
		
		timer.start();
	}
	
    /**
     * Invoked when an action occurs.
     * @param e the instance of ActionEvent
     */
	public void actionPerformed(ActionEvent e)
	{		
		if (visibleTweening)
		{
			component.setSize(horizontalTweening ? dimension.width * frameIndex / frameCount : dimension.width, verticalTweening ? dimension.height * frameIndex / frameCount : dimension.height);
			
			if (frameIndex == frameCount)
			{
				timer.stop();
			}
			else
			{
				frameIndex++;
			}
		}
		else
		{
			component.setSize(horizontalTweening ? dimension.width * frameIndex / frameCount : dimension.width, verticalTweening ? dimension.height * frameIndex / frameCount : dimension.height);
						
			if (frameIndex == 0)
			{
				component.setVisible(false);
				
				timer.stop();
			}
			else
			{
				frameIndex--;
			}
		}
	}
	
	/**
	 * Gets the dimension.
	 * @return the instance of Dimension
	 */
	public Dimension getDimension()
	{
		return dimension;
	}

	/**
	 * Sets the dimension.
	 * @param dimension the instance of Dimension.
	 */
	public void setDimension(Dimension dimension)
	{
		this.dimension = dimension;
	}
	
	/**
	 * Returns true if it is horizontal tweening.
	 * @return true if it is horizontal tweening
	 */
	public boolean isHorizontalTweening()
	{
		return horizontalTweening;
	}

	/**
	 * Sets the horizontal tweening.
	 * @param horizontalTweening the boolean value of horizontalTweening
	 */
	public void setHorizontalTweening(boolean horizontalTweening)
	{
		this.horizontalTweening = horizontalTweening;
	}

	/**
	 * Returns true if it is vertical tweening.
	 * @return true if it is vertical tweening
	 */
	public boolean isVerticalTweening()
	{
		return verticalTweening;
	}

	/**
	 * Sets the vertical tweening.
	 * @param verticalTweening the boolean value of verticalTweening
	 */
	public void setVerticalTweening(boolean verticalTweening)
	{
		this.verticalTweening = verticalTweening;
	}

	/**
	 * Gets the frame interval.
	 * @return the frame interval value
	 */
	public int getFrameInterval()
	{
		return frameInterval;
	}

	/**
	 * Sets the frame interval.
	 * @param frameInterval the frame interval value
	 */
	public void setFrameInterval(int frameInterval)
	{
		this.frameInterval = frameInterval;
		
		timer.setDelay(this.frameInterval);
	}

	/**
	 * Gets the frame count.
	 * @return the frame count value
	 */
	public int getFrameCount()
	{
		return frameCount;
	}

	/**
	 * Sets the frame count.
	 * @param frameCount the frame count value
	 */
	public void setFrameCount(int frameCount)
	{
		this.frameCount = frameCount;
	}
}