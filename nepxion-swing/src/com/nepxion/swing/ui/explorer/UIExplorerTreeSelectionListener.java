package com.nepxion.swing.ui.explorer;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.Map;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.tree.TreePath;

import com.nepxion.swing.framework.dockable.JDockableView;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.table.layoutable.TableCellRendererLayout;

public class UIExplorerTreeSelectionListener
	implements TreeSelectionListener
{
	/**
	 * 
	 */
	private UIExplorerTable table;
	
	/**
	 * 
	 */
	public void valueChanged(TreeSelectionEvent evt)
	{
		UIExplorerTree tree = (UIExplorerTree) evt.getSource();
		TreePath treePath = tree.getSelectionPath();
		if (treePath != null)
		{
			if (table == null)
			{
				UIExplorerHierarchy hierarchy = (UIExplorerHierarchy) HandleManager.getComponent(tree, UIExplorerHierarchy.class);
				JDockableView dockableView = hierarchy.getDockableView(UIExplorerHierarchy.CONTENT_PANE_TITLE);
				JBasicScrollPane scrollPane = (JBasicScrollPane) dockableView.getContentPane();
				table = (UIExplorerTable) scrollPane.getViewport().getView();
			}
			
			UIExplorerTreeNode treeNode = (UIExplorerTreeNode) treePath.getLastPathComponent();
			Object key = treeNode.getKey();
			Object value = treeNode.getValue();
			
			if (value != null)
			{
				Map map = (Map) value;
				
				TableModel tableModel = table.getModel();
				if (tableModel != null && tableModel instanceof UIExplorerTableModel)
				{
					((UIExplorerTableModel) tableModel).setRowData(map);
				}
				else
				{
					table.setModel(new UIExplorerTableModel(map));
				}
				TableCellRendererLayout layout = new TableCellRendererLayout(table);
				layout.doLayout(new int[][] { {300, 400, 100}, {}});
			}
		}
	}
}