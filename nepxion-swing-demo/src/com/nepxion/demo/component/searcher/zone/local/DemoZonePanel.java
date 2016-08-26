package com.nepxion.demo.component.searcher.zone.local;

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
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.searcher.zone.local.JZoneSelectorPanel;

public class DemoZonePanel
	extends JPanel
{
	public DemoZonePanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new ZonePanel());
	}
	
	public class ZonePanel
		extends JPanel
	{
		public ZonePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("ÇøºÅ²éÑ¯"));
			
			JZoneSelectorPanel zoneSelectorPanel = new JZoneSelectorPanel();		
			add(zoneSelectorPanel);
		}
	}
}