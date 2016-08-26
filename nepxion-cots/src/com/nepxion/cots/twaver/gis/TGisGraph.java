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

import java.awt.event.HierarchyEvent;

import javax.swing.SwingUtilities;

import twaver.TDataBox;
import twaver.gis.GeographyMap;
import twaver.gis.GisNetworkAdapter;
import twaver.gis.TWaverGisConst;

import com.nepxion.cots.twaver.element.TType;
import com.nepxion.cots.twaver.graph.TGraph;
import com.nepxion.cots.twaver.graph.TGraphToolBar;
import com.nepxion.swing.listener.VisibilityListener;

public class TGisGraph
	extends TGraph
{
	private TGisNavigator gisNavigator;
	private TGisOverview gisOverview;
	
	private GisNetworkAdapter gisAdapter;
	
	public TGisGraph()
	{
		this(new TDataBox());
	}
	
	public TGisGraph(TDataBox dataBox)
	{
		this(dataBox, null);
	}
	
	public TGisGraph(TType type)
	{
		this(new TDataBox(), type);
	}
	
	public TGisGraph(TDataBox dataBox, TType type)
	{
		super(dataBox, type);
		
		initComponents();
	}
	
	private void initComponents()
	{
		gisAdapter = new GisNetworkAdapter(this);
		gisAdapter.installAdapter();
		
		gisNavigator = new TGisNavigator(this);
		
		GeographyMap map = gisAdapter.getMap();
		map.setGroundingColor(TWaverGisConst.GOOGLE_COLOR);
		
		new TGraphToolBar(this);
		new TGisGraphControlBarGenerator(this);
		
		addHierarchyListener(new VisibilityListener()
		{
			public void visibilityChanged(HierarchyEvent e)
			{
				SwingUtilities.invokeLater(new Runnable()
				{
					public void run()
					{
						gisNavigator.showout(true);
					}
				}
				);
				
				removeHierarchyListener(this);
			}
		}
		);
	}
	
	public TGisOverview getGisOverview()
	{
		return gisOverview;
	}
	
	public void setOverview(TGisOverview gisOverview)
	{
		this.gisOverview = gisOverview;
	}
	
	public TGisNavigator getGisNavigator()
	{
		return gisNavigator;
	}
	
	public GeographyMap getMap()
	{
		return gisAdapter.getMap();
	}
}