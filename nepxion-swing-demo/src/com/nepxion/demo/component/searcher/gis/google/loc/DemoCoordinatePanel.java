package com.nepxion.demo.component.searcher.gis.google.loc;

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
import com.nepxion.swing.searcher.gis.google.loc.JCoordinatePanel;

public class DemoCoordinatePanel
	extends JPanel
{
	public DemoCoordinatePanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new CoordinatePanel());
	}
	
	public class CoordinatePanel
		extends JPanel
	{
		public CoordinatePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("根据经纬度查询地理位置"));
			
			JCoordinatePanel coordinatePanel = new JCoordinatePanel();
			coordinatePanel.setLatitude(31.231849);
			coordinatePanel.setLongitude(121.475701);
			
			add(coordinatePanel);
		}
	}
}