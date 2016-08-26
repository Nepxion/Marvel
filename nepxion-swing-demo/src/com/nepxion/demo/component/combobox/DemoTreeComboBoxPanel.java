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

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.renderer.combobox.ElementComboBoxCellRenderer;
import com.nepxion.util.data.CollectionUtil;

public class DemoTreeComboBoxPanel
	extends JPanel
{	
	public DemoTreeComboBoxPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new TreeComboBoxPanel());
	}
	
	public class TreeComboBoxPanel
		extends JPanel
	{
		public TreeComboBoxPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Group ComboBox"));
			
			List comboBoxElementNodes = new ArrayList();
			
			List componentElementNodes = DemoDataFactory.getComponentElementNodes();
			for (Iterator iterator = componentElementNodes.iterator(); iterator.hasNext();)
			{
				ElementNode elementNode = (ElementNode) iterator.next();
				elementNode.setEnabled(true);
				comboBoxElementNodes.add(elementNode);	
				for (Enumeration childEnumeration = elementNode.children(); childEnumeration.hasMoreElements();)
				{
					ElementNode childElementNode = (ElementNode) childEnumeration.nextElement();
					comboBoxElementNodes.add(childElementNode);
				}	
			}	
			
			JBasicComboBox treeComboBox = new JBasicComboBox(CollectionUtil.parseVector(comboBoxElementNodes));
			treeComboBox.setMaximumSize(new Dimension(350, treeComboBox.getPreferredSize().height));
			treeComboBox.setRenderer(new ComboBoxTreeCellRenderer());
			add(treeComboBox);
		}
	}
	
	public class ComboBoxTreeCellRenderer
		extends ElementComboBoxCellRenderer
	{
		public ComboBoxTreeCellRenderer()
		{
		}
		
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
		{
			super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			
			ElementNode elementNode = (ElementNode) value;
			if (elementNode.getChildCount() == 0)
			{
				setBorder(BorderFactory.createEmptyBorder(0, 18, 0, 0));
			}
			
			return this;
		}		
	}	
}