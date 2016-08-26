package com.nepxion.demo.component.searcher.id.netease;

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

import com.nepxion.demo.component.locale.SwingDemoLocale;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.searcher.id.netease.JNeteaseIDPanel;

public class DemoNeteaseIDPanel
	extends JPanel
{
	public DemoNeteaseIDPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new NeteaseIDPanel());
	}
	
	public class NeteaseIDPanel
		extends JPanel
	{
		public NeteaseIDPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder(SwingDemoLocale.getString("id_searcher")));
			
			JNeteaseIDPanel idPanel = new JNeteaseIDPanel();			
			add(idPanel);
		}
	}
}