package com.nepxion.demo.component.searcher.ip.tencent;

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
import com.nepxion.swing.searcher.ip.tencent.JTencentIPPanel;

public class DemoTencentIPPanel
	extends JPanel
{
	public DemoTencentIPPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new TencentIPPanel());
	}
	
	public class TencentIPPanel
		extends JPanel
	{
		public TencentIPPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("根据IP地址查询地理位置"));
			
			JTencentIPPanel ipPanel = new JTencentIPPanel();
			add(ipPanel);
		}
	}
}