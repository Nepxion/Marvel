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
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.combobox.JGroupComboBox;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.renderer.combobox.ElementComboBoxCellRenderer;
import com.nepxion.util.data.CollectionUtil;

public class DemoElementComboBoxPanel
	extends JPanel
{	
	public DemoElementComboBoxPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new SingleIconElementComboBoxPanel());
		add(new MultiIconElementComboBoxPanel());
	}
	
	public class SingleIconElementComboBoxPanel
		extends JPanel
	{
		public SingleIconElementComboBoxPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Single Icon Element ComboBox"));
			
			String[] componentNameDatas = DemoDataFactory.getComponentNameDatas();
			
			JBasicComboBox singleIconComboBox = new JBasicComboBox(componentNameDatas);
			singleIconComboBox.setMaximumSize(new Dimension(350, singleIconComboBox.getPreferredSize().height));
			singleIconComboBox.setRenderer(new ElementComboBoxCellRenderer(BorderFactory.createEmptyBorder(0, 5, 0, 0), IconFactory.getSwingIcon("component/combo_box_16.png")));			
			add(singleIconComboBox);
		}
	}
	
	public class MultiIconElementComboBoxPanel
		extends JPanel
	{
		public MultiIconElementComboBoxPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Multi Icon Element ComboBox"));
			
			List componentElementNodes = DemoDataFactory.getComponentElementNodes();
			
			JBasicComboBox multiIconComboBox = new JGroupComboBox(CollectionUtil.parseVector(componentElementNodes));
			multiIconComboBox.setMaximumSize(new Dimension(350, multiIconComboBox.getPreferredSize().height));
			multiIconComboBox.setRenderer(new ElementComboBoxCellRenderer(BorderFactory.createEmptyBorder(0, 5, 0, 0)));
			add(multiIconComboBox);
		}
	}	
}