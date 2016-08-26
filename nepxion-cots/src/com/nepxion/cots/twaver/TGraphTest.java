package com.nepxion.cots.twaver;

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

import java.awt.Color;

import javax.swing.JFrame;

import twaver.GeoCoordinate;
import twaver.TDataBox;
import twaver.gis.GeographyMap;

import com.nepxion.cots.twaver.element.TNode;
import com.nepxion.cots.twaver.gis.TGisGraph;
import com.nepxion.cots.twaver.graph.TGraph;
import com.nepxion.cots.twaver.graph.TGraphBackground;
import com.nepxion.cots.twaver.graph.TGraphPointBackground;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.tabbedpane.JBasicTabbedPane;

public class TGraphTest
{
	private static TGraph createGraph()
	{
		TNode node = new TNode();
		node.setName("Nepxion");
		node.setLocation(300, 300);
		
		TDataBox dataBox = new TDataBox();
		dataBox.addElement(node);
		
		TGraph graph = new TGraph();
		graph.setDataBox(dataBox);
		
		TGraphPointBackground background = new TGraphPointBackground(Color.white, TGraphBackground.BLUE_STYLE_COLOR);
		background.setTitleAlignment(TGraphPointBackground.TOP);
		background.setTitle("Nepxion Cots");
		// background.setTitleColor(Color.black);
		// background.setTitleFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		
		graph.setGraphBackground(background);
		
		return graph;
	}
	
	private static TGisGraph createGisGraph()
	{
		TNode node = new TNode();
		node.setName("Nepxion");
		node.setGeoCoordinate(new GeoCoordinate(118.795896, 32.088683));
		
		TDataBox dataBox = new TDataBox();
		dataBox.addElement(node);
		
		TGisGraph gisGraph = new TGisGraph();
		gisGraph.setDataBox(dataBox);
		
		GeographyMap map = gisGraph.getMap();
		map.setZoom(16);
		map.setCenterPoint(new GeoCoordinate(118.795896, 32.088683));
		
		return gisGraph;
	}
	
	public static void main(String[] args)
	{
	    // LocaleContext.registerLocale("en_US");
	    // FontContext.registerFont("Calibri", Font.PLAIN, 12);
	    
	    // LocaleContext.registerLocale("zh_CN");
	    // FontContext.registerFont("Î¢ÈíÑÅºÚ", Font.PLAIN, 12);
	    
		LookAndFeelManager.setNimbusLookAndFeel();
		
		TGraph graph = createGraph();
		
		TGisGraph gisGraph = createGisGraph();
		
		JBasicTabbedPane tabbedPane = new JBasicTabbedPane();
		tabbedPane.addTab("GIS", gisGraph);
		tabbedPane.addTab("Graph", graph);
		
		JFrame frame = new JFrame();
		frame.getContentPane().add(tabbedPane);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
}