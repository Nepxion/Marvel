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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.list.JBasicList;
import com.nepxion.swing.renderer.list.TabbedListCellRenderer;
import com.nepxion.swing.scrollpane.JBasicScrollPane;

public class DemoTabbedListPanel
	extends JPanel
{
	public DemoTabbedListPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new TabbedListPanel());
	}
	
	public class TabbedListPanel
		extends JPanel
	{
		public TabbedListPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Tabbed List"));
			
			String[] componentDescriptonDatas = DemoDataFactory.getComponentDescriptonDatas();
			
			JBasicList checkBoxList = new JBasicList(componentDescriptonDatas);
			checkBoxList.setCellRenderer(new TabbedListCellRenderer(700, "\t", new int[] {100, 270, 430}, 50));
			
			JBasicScrollPane checkBoxListScrollPane = new JBasicScrollPane();
			checkBoxListScrollPane.getViewport().add(checkBoxList);			
			add(checkBoxListScrollPane);			
		}
	}
}