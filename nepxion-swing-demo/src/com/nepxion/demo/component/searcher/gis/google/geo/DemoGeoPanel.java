package com.nepxion.demo.component.searcher.gis.google.geo;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.searcher.gis.google.geo.JGeoPanel;

public class DemoGeoPanel
	extends JPanel
{
	public DemoGeoPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new GeoPanel());
	}
	
	public class GeoPanel
		extends JPanel
	{
		public GeoPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("模糊查询地理位置"));
			
			JGeoPanel geoPanel = new JGeoPanel();			
			add(geoPanel);
		}
	}
}