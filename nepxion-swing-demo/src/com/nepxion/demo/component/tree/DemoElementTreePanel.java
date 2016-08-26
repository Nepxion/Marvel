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
import com.nepxion.swing.tree.JBasicTree;

public class DemoElementTreePanel
	extends JPanel
{
	public DemoElementTreePanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new ElementTreePanel());
	}
	
	public class ElementTreePanel
		extends JPanel
	{
		public ElementTreePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Element Tree"));
			
			JBasicTree elementTree = new JBasicTree(DemoDataFactory.getRootElementNode());
			elementTree.setCellRenderer(new ElementTreeCellRenderer(20));
			elementTree.expandAll();
			
			JBasicScrollPane decorationTreeScrollPane = new JBasicScrollPane();
			decorationTreeScrollPane.getViewport().add(elementTree);
			add(decorationTreeScrollPane);			
		}
	}
}