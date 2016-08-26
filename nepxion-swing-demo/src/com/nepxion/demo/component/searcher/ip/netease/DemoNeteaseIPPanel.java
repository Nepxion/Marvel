package com.nepxion.demo.component.searcher.ip.netease;

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
import com.nepxion.swing.searcher.ip.netease.JNeteaseIPPanel;

public class DemoNeteaseIPPanel
	extends JPanel
{
	public DemoNeteaseIPPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new NeteaseIPPanel());
	}
	
	public class NeteaseIPPanel
		extends JPanel
	{
		public NeteaseIPPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("根据IP地址查询地理位置"));
			
			JNeteaseIPPanel ipPanel = new JNeteaseIPPanel();
			add(ipPanel);
		}
	}
}