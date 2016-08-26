package com.nepxion.demo.component.button;

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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.TreeNode;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.renderer.tree.ElementTreeCellRenderer;
import com.nepxion.swing.selector.button.JBasicSelectorMenuButton;
import com.nepxion.swing.textfield.JBasicTextField;
import com.nepxion.swing.tree.JBasicTree;

public class DemoSelectorMenuButtonPanel
	extends JPanel
{
	public DemoSelectorMenuButtonPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new SelectorMenuButtonPanel());
	}
	
	public class SelectorMenuButtonPanel
		extends JPanel
	{
		public SelectorMenuButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Flat ButtonUI"));
			
			JBasicTextField textField = new JBasicTextField();
			SelectorMenuButton selectorButton = new SelectorMenuButton(textField);
			
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			panel.add(textField);
			panel.add(selectorButton);
			ButtonManager.updateUI(panel, new Dimension(26, 22));			
			add(panel);
		}
	}
	
	public class SelectorMenuButton
		extends JBasicSelectorMenuButton
	{
		private JBasicTextField textField;
		private JBasicTree tree;
		
		public SelectorMenuButton(JBasicTextField textField)
		{
			super(IconFactory.getSwingIcon("property.png"), "Selector MenuButton");
			
			this.textField = textField;
			
			tree = new JBasicTree()
			{
				public void executeDoubleClicked(TreeNode treeNode)
				{
					if (treeNode.isLeaf())
					{
						doConfirm();
					}
				}
			};
					
			tree.setCellRenderer(new ElementTreeCellRenderer(ElementTreeCellRenderer.TREE_THEME_NIMBUS, 20));
			tree.setSelectionMode(JBasicTree.SINGLE_TREE_SELECTION);			
			tree.expandAll();
			
			JScrollPane scrollPane = new JScrollPane(tree);
			scrollPane.setPreferredSize(new Dimension(300, 300));
			
			setContentPane(scrollPane);
		}
		
		public boolean confirm()
		{
			TreeNode treeNode = tree.getSelectionTreeNode();
			if (treeNode == null || !treeNode.isLeaf())
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame(this), "Please select child tree node", "Message", JBasicOptionPane.WARNING_MESSAGE);
				
				return false;
			}
			
			textField.setText(treeNode.toString());
			
			return true;
		}
		
		public boolean cancel()
		{
			return true;
		}
	}
}