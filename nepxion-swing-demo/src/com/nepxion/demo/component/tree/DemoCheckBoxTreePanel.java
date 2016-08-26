package com.nepxion.demo.component.tree;

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
import com.nepxion.swing.renderer.tree.ElementTreeCellRenderer;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.tree.JCheckBoxTree;

public class DemoCheckBoxTreePanel
	extends JPanel
{
	public DemoCheckBoxTreePanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new CheckBoxTreePanel());
	}
	
	public class CheckBoxTreePanel
		extends JPanel
	{
		public CheckBoxTreePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("CheckBox Tree"));
			
			JCheckBoxTree checkBoxTree = new JCheckBoxTree(DemoDataFactory.getRootElementNode());
			checkBoxTree.setCellRenderer(new ElementTreeCellRenderer(20));
			checkBoxTree.expandAll();
			
			JBasicScrollPane checkBoxTreeScrollPane = new JBasicScrollPane();
			checkBoxTreeScrollPane.getViewport().add(checkBoxTree);
			add(checkBoxTreeScrollPane);			
		}
	}
}