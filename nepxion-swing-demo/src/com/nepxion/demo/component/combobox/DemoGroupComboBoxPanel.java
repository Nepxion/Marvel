package com.nepxion.demo.component.combobox;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.combobox.JGroupComboBox;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.renderer.combobox.GroupComboBoxCellRenderer;
import com.nepxion.util.data.CollectionUtil;

public class DemoGroupComboBoxPanel
	extends JPanel
{	
	public DemoGroupComboBoxPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new GroupComboBoxPanel());
	}
	
	public class GroupComboBoxPanel
		extends JPanel
	{
		public GroupComboBoxPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Group ComboBox"));
			
			List componentElementNodes = DemoDataFactory.getComponentElementNodes();
			componentElementNodes.add(3, GroupComboBoxCellRenderer.SEPARATOR);
			componentElementNodes.add(8, GroupComboBoxCellRenderer.SEPARATOR);
			
			JGroupComboBox groupComboBox = new JGroupComboBox(CollectionUtil.parseVector(componentElementNodes));
			groupComboBox.setMaximumSize(new Dimension(350, groupComboBox.getPreferredSize().height));
			groupComboBox.setRenderer(new GroupComboBoxCellRenderer(BorderFactory.createEmptyBorder(0, 5, 0, 0), -1));
			add(groupComboBox);
		}
	}
}