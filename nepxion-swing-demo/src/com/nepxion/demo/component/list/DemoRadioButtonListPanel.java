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
import com.nepxion.swing.renderer.list.RadioButtonListCellRenderer;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.util.data.CollectionUtil;

public class DemoRadioButtonListPanel
	extends JPanel
{
	public DemoRadioButtonListPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new RadioButtonListPanel());
	}
	
	public class RadioButtonListPanel
		extends JPanel
	{
		public RadioButtonListPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("RadioButton List"));
			
			List componentElementNodes = DemoDataFactory.getComponentElementNodes();
			
			JBasicList radioButtonList = new JBasicList(CollectionUtil.parseVector(componentElementNodes));
			radioButtonList.setCellRenderer(new RadioButtonListCellRenderer(radioButtonList));
			
			JBasicScrollPane radioButtonListScrollPane = new JBasicScrollPane();
			radioButtonListScrollPane.getViewport().add(radioButtonList);			
			add(radioButtonListScrollPane);			
		}
	}
}