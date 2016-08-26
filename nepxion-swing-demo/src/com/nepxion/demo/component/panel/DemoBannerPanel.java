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
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.panel.JBannerPanel;

public class DemoBannerPanel
	extends JPanel
{
	public DemoBannerPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new BannerPanel());
	}
	
	public class BannerPanel
		extends JPanel
	{
		public BannerPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Banner Panel"));
			
			JBannerPanel bannerPanel = new JBannerPanel("This is a BannerPanel", "BannerPanel is very useful to display a title, a description and an icon. It can be used in dialog to show some help information or display a product logo in a nice way.", IconFactory.getSwingIcon("tip.png"));
			add(bannerPanel);
		}
	}
}