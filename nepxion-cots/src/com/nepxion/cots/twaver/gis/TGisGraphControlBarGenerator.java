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

import javax.swing.ButtonGroup;

import com.nepxion.cots.twaver.graph.TGraphControlBar;
import com.nepxion.cots.twaver.graph.TGraphController;
import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.button.JBasicMenuButton;
import com.nepxion.swing.button.JBasicToggleButton;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.menuitem.JBasicRadioButtonMenuItem;
import com.nepxion.swing.outlookbar.JFlatOutlook;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;

public class TGisGraphControlBarGenerator
{
	public TGisGraphControlBarGenerator(TGisGraph gisGraph)
	{
		TGraphControlBar controlBar = (TGraphControlBar) gisGraph.getControlBarInternalFrame().getContent();
		JFlatOutlook viewOutlook = controlBar.getViewToolBar().getViewOutlook();
		viewOutlook.removeAll();
		
		double size[][] = 
		{
			{30, 30}, 
			{TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}
		};
		viewOutlook.setLayout(new TableLayout(size));
		
		JBasicToggleButton selectButton = new JBasicToggleButton(TGisGraphController.getSelectAction(gisGraph));
		selectButton.setSelected(true);
		selectButton.setText("");
		viewOutlook.add(selectButton, "0, 0");
				
		JBasicToggleButton panButton = new JBasicToggleButton(TGisGraphController.getPanAction(gisGraph));
		panButton.setText("");
		viewOutlook.add(panButton, "0, 1");
		
		JBasicToggleButton lazeMoveButton = new JBasicToggleButton(TGraphController.getLazyMoveAction(gisGraph));
		lazeMoveButton.setText("");
		viewOutlook.add(lazeMoveButton, "1, 1");
		
		JBasicToggleButton zoomInButton = new JBasicToggleButton(TGisGraphController.getZoomInAction(gisGraph));
		zoomInButton.setText("");
		viewOutlook.add(zoomInButton, "0, 2");
		
		JBasicToggleButton zoomOutButton = new JBasicToggleButton(TGisGraphController.getZoomOutAction(gisGraph));
		zoomOutButton.setText("");
		viewOutlook.add(zoomOutButton, "1, 2");
		
		JBasicButton zoomResetButton = new JBasicButton(TGisGraphController.getZoomResetAction(gisGraph));
		zoomResetButton.setText("");
		viewOutlook.add(zoomResetButton, "0, 3");
		
		JBasicToggleButton magnifierButton = new JBasicToggleButton(TGraphController.getMagnifierAction(gisGraph));
		magnifierButton.setText("");
		viewOutlook.add(magnifierButton, "0, 4");
		
		JBasicPopupMenu mapPopupMenu = new JBasicPopupMenu();
		
		ButtonGroup mapTypeButtonGroup = new ButtonGroup();
		TMapType[] mapTypes = new TMapType[] {TMapType.GOOGLE_MAP_TYPE,	TMapType.GOOGLE_SATELLITE_MAP_TYPE, TMapType.GOOGLE_TERRAIN_MAP_TYPE, TMapType.MICROSOFT_BINT_MAP_TYPE, TMapType.OPENSTREET_MAP_TYPE, TMapType.MAPABC_MAP_TYPE, TMapType.TIANDITU_MAP_TYPE};
		for (int i = 0; i < mapTypes.length; i++)
		{
			TMapType mapType = mapTypes[i];
			
			JBasicRadioButtonMenuItem mapTypeMenuItem = new JBasicRadioButtonMenuItem(TGisGraphController.getMapTypeConfigAction(gisGraph, mapType));
			mapPopupMenu.add(mapTypeMenuItem);
			
			if (mapType == TMapType.MAPABC_MAP_TYPE)
			{
				mapTypeMenuItem.doClick();
			}	
			
			mapTypeButtonGroup.add(mapTypeMenuItem);
		}
		
		JBasicMenuButton mapButton = new JBasicMenuButton(TIconFactory.getContextIcon("map.png"));
		mapButton.setPopupMenu(mapPopupMenu);
		viewOutlook.add(mapButton, "1, 4");
		
		JBasicButton zoomButton = new JBasicButton(TGisGraphController.getZoomBackAction(gisGraph));
		zoomButton.setText("");
		viewOutlook.add(zoomButton, "1, 3");
		
		JBasicToggleButton scaleButton = new JBasicToggleButton(TGisGraphController.getScaleAction(gisGraph));
		scaleButton.setText("");
		scaleButton.setGrouped(false);
		viewOutlook.add(scaleButton, "0, 5");
		
		JBasicToggleButton distanceButton = new JBasicToggleButton(TGisGraphController.getDistanceAction(gisGraph));
		distanceButton.setText("");
		viewOutlook.add(distanceButton, "1, 5");
		
		JBasicButton fullscreenButton = new JBasicButton(TGraphController.getFullScreenAction(gisGraph));
		fullscreenButton.setText("");
		viewOutlook.add(fullscreenButton, "0, 6");
		
		JBasicToggleButton overviewButton = new JBasicToggleButton(TGisGraphController.getOverviewAction(gisGraph));
		overviewButton.setText("");
		overviewButton.setGrouped(false);
		viewOutlook.add(overviewButton, "1, 6");
		
		JBasicToggleButton navigatorButton = new JBasicToggleButton(TGisGraphController.getNavigatorAction(gisGraph));
		navigatorButton.setSelected(true);
		navigatorButton.setText("");
		navigatorButton.setGrouped(false);
		viewOutlook.add(navigatorButton, "0, 7");
		
		ButtonManager.updateUI(viewOutlook, new Dimension(25, 25), new ButtonGroup());
	}
}