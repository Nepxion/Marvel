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

import java.awt.Dimension;

import javax.swing.Icon;

import twaver.network.Overview;

import com.nepxion.swing.tween.VisibilityTweener;

public class TOverview
	extends Overview
{
	private VisibilityTweener visibilityTweener;
	
	public TOverview(TGraph graph, Dimension size)
	{
		this(graph, "", size, new Dimension(0, 0), null);
	}
	
	public TOverview(TGraph graph, Dimension size, Icon icon)
	{
		this(graph, "", size, icon);
	}
	
	public TOverview(TGraph graph, Dimension size, Dimension location)
	{
		this(graph, "", size, location);
	}
	
	public TOverview(TGraph graph, String title, Dimension size)
	{
		this(graph, title, size, new Dimension(0, 0), null);
	}
	
	public TOverview(TGraph graph, String title, Dimension size, Icon icon)
	{
		this(graph, title, size, new Dimension(0, 0), icon);
	}
	
	public TOverview(TGraph graph, String title, Dimension size, Dimension location)
	{
		this(graph, title, size, location, null);
	}
	
	public TOverview(TGraph graph, String title, Dimension size, Dimension location, Icon icon)
	{
		super(title, graph, size);
		
		visibilityTweener = new VisibilityTweener(this, 1, 1);
		
		setLocation(location.width, location.height);
		setFrameIcon(icon);
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