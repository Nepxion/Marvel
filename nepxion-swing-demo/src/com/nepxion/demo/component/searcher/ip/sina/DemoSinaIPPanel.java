package com.nepxion.demo.component.searcher.ip.sina;

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
import com.nepxion.swing.searcher.ip.sina.JSinaIPPanel;

public class DemoSinaIPPanel
	extends JPanel
{
	public DemoSinaIPPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new SinaIPPanel());
	}
	
	public class SinaIPPanel
		extends JPanel
	{
		public SinaIPPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("����IP��ַ��ѯ����λ��"));
			
			JSinaIPPanel ipPanel = new JSinaIPPanel();
			add(ipPanel);
		}
	}
}