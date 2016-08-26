package com.nepxion.demo.component.list;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.list.JBasicList;
import com.nepxion.swing.renderer.list.ElementListCellRenderer;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.util.data.CollectionUtil;

public class DemoElementListPanel
	extends JPanel
{
	public DemoElementListPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new SingleIconElementListPanel());
		add(new MultiIconElementListPanel());
	}
	
	public class SingleIconElementListPanel
		extends JPanel
	{
		public SingleIconElementListPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Single Icon Element List"));
			
			String[] componentNameDatas = DemoDataFactory.getComponentNameDatas();
			
			JBasicList singleIconList = new JBasicList(componentNameDatas);
			singleIconList.setCellRenderer(new ElementListCellRenderer(singleIconList, BorderFactory.createEmptyBorder(0, 5, 0, 0), IconFactory.getSwingIcon("component/list_16.png"), 22));
			
			JBasicScrollPane singleIconListScrollPane = new JBasicScrollPane();
			singleIconListScrollPane.getViewport().add(singleIconList);			
			add(singleIconListScrollPane);
		}
	}
	
	public class MultiIconElementListPanel
		extends JPanel
	{
		public MultiIconElementListPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Multi Icon Element List"));
			
			List componentElementNodes = DemoDataFactory.getComponentElementNodes();
			
			JBasicList multiIconList = new JBasicList(CollectionUtil.parseVector(componentElementNodes));
			multiIconList.setCellRenderer(new ElementListCellRenderer(multiIconList, BorderFactory.createEmptyBorder(0, 5, 0, 0), 22));
			
			JBasicScrollPane multiIconListScrollPane = new JBasicScrollPane();
			multiIconListScrollPane.getViewport().add(multiIconList);			
			add(multiIconListScrollPane);
		}
	}
}