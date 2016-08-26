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

import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;

import com.nepxion.cots.twaver.graph.TGraphKeyboardRegister;
import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.cots.twaver.locale.TLocale;
import com.nepxion.swing.action.JSecurityAction;

public class TGisGraphController
{
	public static JSecurityAction getSelectAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_select"), TIconFactory.getContextIcon("select.png"), TLocale.getString("graph_select"))
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGisGraphManager.select(gisGraph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPanAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_pan"), TIconFactory.getContextIcon("pan.png"), TLocale.getString("graph_pan"))
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGisGraphManager.pan(gisGraph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getZoomInAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_zoom_in"), TIconFactory.getContextIcon("zoom_in.png"), TLocale.getString("graph_zoom_in"))
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGisGraphManager.zoomIn(gisGraph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getZoomOutAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_zoom_out"), TIconFactory.getContextIcon("zoom_out.png"), TLocale.getString("graph_zoom_out"))
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGisGraphManager.zoomOut(gisGraph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getZoomResetAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_zoom_reset"), TIconFactory.getContextIcon("zoom_reset.png"), TLocale.getString("graph_zoom_reset") + " Ctrl-O")
		{
			public void execute(ActionEvent e)
			{
				TGisGraphManager.zoomReset(gisGraph);
			}
		};
		TGraphKeyboardRegister.registerZoomReset(gisGraph, action);
		
		return action;
	}
	
	public static JSecurityAction getZoomBackAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_zoom_back"), TIconFactory.getContextIcon("zoom.png"), TLocale.getString("graph_zoom_back"))
		{
			public void execute(ActionEvent e)
			{
				TGisGraphManager.zoomBack(gisGraph);
			}
		};
		TGraphKeyboardRegister.registerZoomBack(gisGraph, action);
		
		return action;
	}
	
	public static JSecurityAction getNavigatorAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_navigator"), TIconFactory.getContextIcon("navigator.png"), TLocale.getString("graph_navigator"))
		{
			public void execute(ActionEvent e)
			{
				TGisGraphManager.navigator(gisGraph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getDistanceAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_distance"), TIconFactory.getContextIcon("distance.png"), TLocale.getString("graph_distance"))
		{
			public void execute(ActionEvent e)
			{
				TGisGraphManager.distance(gisGraph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getScaleAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_scale"), TIconFactory.getContextIcon("scale.png"), TLocale.getString("graph_scale"))
		{
			public void execute(ActionEvent e)
			{
				TGisGraphManager.scale(gisGraph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getOverviewAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_overview"), TIconFactory.getContextIcon("overview.png"), TLocale.getString("graph_overview"))
		{
			public void execute(ActionEvent e)
			{
				TGisGraphManager.overview(gisGraph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getMapTypeConfigAction(final TGisGraph gisGraph, final TMapType mapType)
	{
		JSecurityAction action = new JSecurityAction(mapType.toString(), TLocale.getString("graph_switch_map_to") + mapType)
		{
			public void execute(ActionEvent e)
			{
				TGisGraphManager.setMapType(gisGraph, mapType);
			}
		};
		
		return action;
	}
}