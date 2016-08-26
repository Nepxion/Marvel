package com.nepxion.demo.component.searcher.ip.local;

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
import com.nepxion.swing.searcher.ip.local.JAddressPanel;

public class DemoAddressPanel
	extends JPanel
{
	public DemoAddressPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new AddressPanel());
	}
	
	public class AddressPanel
		extends JPanel
	{
		public AddressPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("模糊查询地理位置"));
			
			JAddressPanel addressPanel = new JAddressPanel();			
			add(addressPanel);
		}
	}
}