package com.nepxion.demo.component.panel;

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
import com.nepxion.swing.panel.JIPPropertyPanel;

public class DemoIPPropertyPanel
	extends JPanel
{
	public DemoIPPropertyPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new IPPropertyPanel());
	}
	
	public class IPPropertyPanel
		extends JPanel
	{
		public IPPropertyPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("IP Property Panel"));
			
			JIPPropertyPanel ipPropertyPanel = new JIPPropertyPanel();
			ipPropertyPanel.setIPAddress("192.168.0.8");
			ipPropertyPanel.setSubnetMask("255.255.255.0");
			ipPropertyPanel.setDefaultGateway("192.168.0.1");
			ipPropertyPanel.setPreferredDNS("202.96.199.133");
			ipPropertyPanel.setAlternateDNS("202.96.0.133");
			ipPropertyPanel.setIconShown(true);
			add(ipPropertyPanel);
		}
	}
}