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

import twaver.gis.GeographyMap;
import twaver.gis.utils.GisInputHandlerFactory;
import twaver.gis.utils.GisToolkits;

import com.nepxion.cots.twaver.graph.TInternalFrame;
import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.cots.twaver.locale.TLocale;

public class TGisGraphManager
{
    // 选择模式
    public static void select(TGisGraph gisGraph)
    {
        GeographyMap map = gisGraph.getMap();
        if (map != null)
        {
            gisGraph.setInteractionMode(GisInputHandlerFactory.createDefaultMode(gisGraph, map));
        }
    }

    // 拖动模式
    public static void pan(TGisGraph gisGraph)
    {
        GeographyMap map = gisGraph.getMap();
        if (map != null)
        {
            gisGraph.setInteractionMode(GisInputHandlerFactory.createPanMode(gisGraph, map));
            gisGraph.getCanvas().setCursor(TGisGraph.PAN_CURSOR);
        }
    }

    // 放大
    public static void zoomIn(TGisGraph gisGraph)
    {
        GeographyMap map = gisGraph.getMap();
        if (map != null)
        {
            gisGraph.setInteractionMode(GisInputHandlerFactory.createZoomMode(gisGraph, map,GeographyMap.MAPMODE_ZOOMIN));
            gisGraph.getCanvas().setCursor(TGisGraph.ZOOM_IN_CURSOR);
        }
    }

    // 缩小
    public static void zoomOut(TGisGraph gisGraph)
    {
        GeographyMap map = gisGraph.getMap();
        if (map != null)
        {
            gisGraph.setInteractionMode(GisInputHandlerFactory.createZoomMode(gisGraph, map,GeographyMap.MAPMODE_ZOOMOUT));
            gisGraph.getCanvas().setCursor(TGisGraph.ZOOM_OUT_CURSOR);
        }
    }

    // 实际大小
    public static void zoomReset(TGisGraph gisGraph)
    {
        GeographyMap map = gisGraph.getMap();
        if (map != null)
        {
            gisGraph.setInteractionMode(GisInputHandlerFactory.createResetMode(gisGraph, map));
        }
    }

    // 缩放后退
    public static void zoomBack(TGisGraph gisGraph)
    {
        GeographyMap map = gisGraph.getMap();
        if (map != null)
        {
            GisToolkits.goBack(gisGraph, map);
        }
    }

    // 显示导航
    public static void navigator(TGisGraph gisGraph)
    {
    	TGisNavigator gisNavigator = gisGraph.getGisNavigator();
    	gisNavigator.showout(!gisNavigator.isShowing());
    }
    
    // 距离测量
    public static void distance(TGisGraph gisGraph)
    {
        GeographyMap map = gisGraph.getMap();
        if (map != null)
        {
            gisGraph.setInteractionMode(GisInputHandlerFactory.createDistanceMode(gisGraph, map));
        }
    }

	// 坐标和比例显示
	public static void scale(TGisGraph gisGraph)
	{
		TInternalFrame scaleInternalFrame = gisGraph.getScaleInternalFrame();
		if (scaleInternalFrame == null)
		{
			TGisGraphScaleBar scaleBar = new TGisGraphScaleBar(gisGraph);
			scaleBar.setPreferredSize(new Dimension(540, 20));
			
			scaleInternalFrame = new TInternalFrame(gisGraph, TLocale.getString("graph_scale"), TIconFactory.getContextIcon("scale.png"), scaleBar);
			scaleInternalFrame.setResizable(false);
			scaleInternalFrame.setLocation(0, gisGraph.getViewport().getHeight() - scaleInternalFrame.getHeight() + 2);
			scaleInternalFrame.setHorizontalTweening(true);
			scaleInternalFrame.setVerticalTweening(false);
			scaleInternalFrame.setTweeningDimension(scaleInternalFrame.getSize());
			
			gisGraph.getLayeredPane().add(scaleInternalFrame);
			gisGraph.setScaleInternalFrame(scaleInternalFrame);
		}
		
		if (!scaleInternalFrame.isVisible())
		{
			scaleInternalFrame.tween(true);
		}
		else
		{
			scaleInternalFrame.tween(false);
		}
	}
	
	// 鹰眼展示
	public static void overview(TGisGraph gisGraph)
	{
		TGisOverview overview = gisGraph.getGisOverview();
		if (overview == null)
		{
			overview = new TGisOverview(gisGraph, TLocale.getString("graph_overview"), new Dimension(150, 150), TIconFactory.getContextIcon("overview.png"));
			overview.setLocation(gisGraph.getViewport().getWidth() - overview.getWidth() + 2, gisGraph.getViewport().getHeight() - overview.getHeight() + 2);
			overview.setHorizontalTweening(true);
			overview.setVerticalTweening(true);
			overview.setTweeningDimension(overview.getSize());
			
			gisGraph.getLayeredPane().add(overview);
			gisGraph.setOverview(overview);
		}
		
		if (!overview.isVisible())
		{
			overview.tween(true);
		}
		else
		{
			overview.tween(false);
		}	
	}

	public static void setMapType(TGisGraph gisGraph, TMapType mapType)
	{
		GeographyMap map = gisGraph.getMap();
		map.removeAllLayers();
		map.addLayer(mapType.getName(), mapType.getType());
	}
}