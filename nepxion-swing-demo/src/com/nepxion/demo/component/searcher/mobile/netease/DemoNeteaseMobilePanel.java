package com.nepxion.demo.component.searcher.mobile.netease;

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
import com.nepxion.swing.searcher.mobile.netease.JNeteaseMobilePanel;

public class DemoNeteaseMobilePanel
	extends JPanel
{
	public DemoNeteaseMobilePanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new NeteaseMobilePanel());
	}
	
	public class NeteaseMobilePanel
		extends JPanel
	{
		public NeteaseMobilePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("手机归属地查询"));
			
			JNeteaseMobilePanel mobilePanel = new JNeteaseMobilePanel();			
			add(mobilePanel);
		}
	}
}