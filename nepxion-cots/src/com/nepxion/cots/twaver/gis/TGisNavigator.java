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

import twaver.gis.gadget.Navigator;

public class TGisNavigator
	extends Navigator
{
	private TGisGraph gisGraph;
	
	public TGisNavigator(TGisGraph gisGraph)
	{
		super(gisGraph);
		
		this.gisGraph = gisGraph;
	}
	
	public void showout(boolean showout)
	{	
		super.showout(showout);
		
		setPosition(gisGraph.getViewport().getWidth() - getWidth() - 15, 15);
	}
}