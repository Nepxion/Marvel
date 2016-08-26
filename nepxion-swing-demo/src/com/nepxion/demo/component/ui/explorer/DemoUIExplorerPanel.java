package com.nepxion.demo.component.ui.explorer;

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

import com.nepxion.swing.ui.explorer.UIExplorerHierarchy;

public class DemoUIExplorerPanel
	extends JPanel
{
	public DemoUIExplorerPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new UIExplorerPanel());
	}
	
	public class UIExplorerPanel
		extends JPanel
	{
		public UIExplorerPanel()
		{			
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(new UIExplorerHierarchy());
		}
	}
}