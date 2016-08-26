package com.nepxion.cots.twaver.graph;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.Icon;
import javax.swing.JInternalFrame;

import com.nepxion.swing.tween.VisibilityTweener;

public class TInternalFrame
	extends JInternalFrame
{
	private VisibilityTweener visibilityTweener;
	
	public TInternalFrame(TGraph graph, Component component)
	{
		this(graph, null, null, null, component);
	}
	
	public TInternalFrame(TGraph graph, Icon icon, Component component)
	{
		this(graph, null, icon, component);
	}
	
	public TInternalFrame(TGraph graph, Dimension location, Component component)
	{
		this(graph, null, location, component);
	}
	
	public TInternalFrame(TGraph graph, String titleText, Component component)
	{
		this(graph, titleText, new Dimension(0, 0), component);
	}
	
	public TInternalFrame(TGraph graph, String titleText, Icon icon, Component component)
	{
		this(graph, titleText, new Dimension(0, 0), icon, component);
	}
	
	public TInternalFrame(TGraph graph, String titleText, Dimension location, Component component)
	{
		this(graph, titleText, location, null, component);
	}
	
	public TInternalFrame(final TGraph graph, String titleText, Dimension location, Icon icon, Component component)
	{
		super(titleText, true, false, false, false);
		
		visibilityTweener = new VisibilityTweener(this, 1, 1);
		
		addComponentListener(new ComponentAdapter()
		{
			public void componentMoved(ComponentEvent e)
			{
				graph.adjustComponentPosition(TInternalFrame.this);
			}
		}
		);
		
		setLocation(location.width, location.height);
		setFrameIcon(icon);
		putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
		
		getContentPane().add(component);
		pack();
	}
	
	public Component getContent()
	{
		return getContentPane().getComponent(0);
	}
	
	public VisibilityTweener getVisibilityTweener()
	{
		return visibilityTweener;
	}
	
	public void tween(boolean visibleTweening)
	{
		visibilityTweener.tween(visibleTweening);
	}
	
	public void setTweeningDimension(Dimension dimension)
	{
		visibilityTweener.setDimension(dimension);
	}

	public void setHorizontalTweening(boolean horizontalTweening)
	{
		visibilityTweener.setHorizontalTweening(horizontalTweening);
	}

	public void setVerticalTweening(boolean verticalTweening)
	{
		visibilityTweener.setVerticalTweening(verticalTweening);
	}

	public void setFrameInterval(int frameInterval)
	{
		visibilityTweener.setFrameInterval(frameInterval);
	}

	public void setFrameCount(int frameCount)
	{
		visibilityTweener.setFrameCount(frameCount);
	}
}