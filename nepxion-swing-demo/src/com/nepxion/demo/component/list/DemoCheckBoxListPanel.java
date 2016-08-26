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
import com.nepxion.swing.list.JBasicList;
import com.nepxion.swing.renderer.list.CheckBoxListCellRenderer;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.util.data.CollectionUtil;

public class DemoCheckBoxListPanel
	extends JPanel
{
	public DemoCheckBoxListPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new CheckBoxListPanel());
	}
	
	public class CheckBoxListPanel
		extends JPanel
	{
		public CheckBoxListPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("CheckBox List"));
			
			List componentElementNodes = DemoDataFactory.getComponentElementNodes();
			
			JBasicList checkBoxList = new JBasicList(CollectionUtil.parseVector(componentElementNodes));
			checkBoxList.setCellRenderer(new CheckBoxListCellRenderer(checkBoxList));
			
			JBasicScrollPane checkBoxListScrollPane = new JBasicScrollPane();
			checkBoxListScrollPane.getViewport().add(checkBoxList);			
			add(checkBoxListScrollPane);			
		}
	}
}