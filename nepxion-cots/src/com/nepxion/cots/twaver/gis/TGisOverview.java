package com.nepxion.cots.twaver.gis;

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

import twaver.gis.gadget.GisOverviewPanel;

import com.nepxion.swing.tween.VisibilityTweener;

public class TGisOverview
	extends GisOverviewPanel
{
	private VisibilityTweener visibilityTweener;
	
	public TGisOverview(TGisGraph gisGraph, Dimension size)
	{
		this(gisGraph, "", size, new Dimension(0, 0), null);
	}
	
	public TGisOverview(TGisGraph gisGraph, Dimension size, Icon icon)
	{
		this(gisGraph, "", size, icon);
	}
	
	public TGisOverview(TGisGraph gisGraph, Dimension size, Dimension location)
	{
		this(gisGraph, "", size, location);
	}
	
	public TGisOverview(TGisGraph gisGraph, String title, Dimension size)
	{
		this(gisGraph, title, size, new Dimension(0, 0), null);
	}
	
	public TGisOverview(TGisGraph gisGraph, String title, Dimension size, Icon icon)
	{
		this(gisGraph, title, size, new Dimension(0, 0), icon);
	}
	
	public TGisOverview(TGisGraph gisGraph, String title, Dimension size, Dimension location)
	{
		this(gisGraph, title, size, location, null);
	}
	
	public TGisOverview(TGisGraph gisGraph, String title, Dimension size, Dimension location, Icon icon)
	{
		super(gisGraph);
		
		visibilityTweener = new VisibilityTweener(this, 1, 1);
		
		setTitle(title);
		setSize(size);
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