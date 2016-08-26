package com.nepxion.swing.tree.lazyloader;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JTree;
import javax.swing.tree.TreeNode;

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.tree.TreeController;

public class LazyLoaderTreeController
	extends TreeController
{
	public static JSecurityAction getLoadAction(final ILazyLoaderTree lazyLoaderTree, final ILazyLoaderAdapter lazyLoaderAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("load"), IconFactory.getSwingIcon("stereo/control_play_16.png"), SwingLocale.getString("load") + SwingLocale.getString("children_nodes"))
		{
			public void execute(ActionEvent e)
			{
				boolean isMultiLoadable = isMultiLoadable(lazyLoaderTree);
				if (!isMultiLoadable)
				{
					return;
				}
				
				TreeNode[] treeNodes = lazyLoaderTree.getSelectionTreeNodes();
				if (!lazyLoaderAdapter.loadPermitted(treeNodes))
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame((JTree) lazyLoaderTree), SwingLocale.getString("node_selection") + SwingLocale.getString("load_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
					
					return;
				}	
				
				lazyLoaderTree.getLazyLoader().setRecursive(false);
				lazyLoaderTree.load(treeNodes);
				
				lazyLoaderAdapter.load(treeNodes);
			}
		};
		KeyStrokeManager.registerComponent((JTree) lazyLoaderTree, action, KeyEvent.VK_F3);
		
		return action;
	}
	
	public static JSecurityAction getLoadGrandchildrenAction(final ILazyLoaderTree lazyLoaderTree, final ILazyLoaderAdapter lazyLoaderAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("load") + SwingLocale.getString("grandchildren_nodes"), IconFactory.getSwingIcon("stereo/control_play_16.png"), SwingLocale.getString("load") + SwingLocale.getString("grandchildren_nodes"))
		{
			public void execute(ActionEvent e)
			{
				boolean isMultiLoadable = isMultiLoadable(lazyLoaderTree);
				if (!isMultiLoadable)
				{
					return;
				}
				
				TreeNode[] treeNodes = lazyLoaderTree.getSelectionTreeNodes();
				if (!lazyLoaderAdapter.loadPermitted(treeNodes))
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame((JTree) lazyLoaderTree), SwingLocale.getString("node_selection") + SwingLocale.getString("load_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				lazyLoaderTree.getLazyLoader().setRecursive(false);
				lazyLoaderTree.loadGrandchildren(treeNodes);
				
				lazyLoaderAdapter.loadGrandchildren(treeNodes);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getLoadAllAction(final ILazyLoaderTree lazyLoaderTree, final ILazyLoaderAdapter lazyLoaderAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("load") + SwingLocale.getString("all_nodes"), IconFactory.getSwingIcon("stereo/control_play_16.png"), SwingLocale.getString("load") + SwingLocale.getString("all_nodes"))
		{
			public void execute(ActionEvent e)
			{
				if (!lazyLoaderAdapter.loadPermitted(null))
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame((JTree) lazyLoaderTree), SwingLocale.getString("node_selection") + SwingLocale.getString("load_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				lazyLoaderTree.getLazyLoader().setRecursive(true);
				lazyLoaderTree.loadAll();
				
				lazyLoaderAdapter.loadAll();
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getCancelAction(final ILazyLoaderTree lazyLoaderTree, final ILazyLoaderAdapter lazyLoaderAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("cancel_load"), IconFactory.getSwingIcon("stereo/cancel_16.png"), SwingLocale.getString("cancel_load") + SwingLocale.getString("children_nodes"))
		{
			public void execute(ActionEvent e)
			{
				boolean isMultiCancelable = isMultiCancelable(lazyLoaderTree);
				if (!isMultiCancelable)
				{
					return;
				}
				
				TreeNode[] treeNodes = lazyLoaderTree.getSelectionTreeNodes();
				if (!lazyLoaderAdapter.loadPermitted(treeNodes))
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame((JTree) lazyLoaderTree), SwingLocale.getString("node_selection") + SwingLocale.getString("cancel_load_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				lazyLoaderTree.cancel(treeNodes);
				lazyLoaderTree.getLazyLoader().setRecursive(false);
				
				lazyLoaderAdapter.cancel(treeNodes);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getCancelGrandchildrenAction(final ILazyLoaderTree lazyLoaderTree, final ILazyLoaderAdapter lazyLoaderAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("cancel_load") + SwingLocale.getString("grandchildren_nodes"), IconFactory.getSwingIcon("stereo/cancel_16.png"), SwingLocale.getString("cancel_load") + SwingLocale.getString("grandchildren_nodes"))
		{
			public void execute(ActionEvent e)
			{
				boolean isMultiCancelable = isMultiCancelable(lazyLoaderTree);
				if (!isMultiCancelable)
				{
					return;
				}
				
				TreeNode[] treeNodes = lazyLoaderTree.getSelectionTreeNodes();
				if (!lazyLoaderAdapter.loadPermitted(treeNodes))
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame((JTree) lazyLoaderTree), SwingLocale.getString("node_selection") + SwingLocale.getString("cancel_load_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				lazyLoaderTree.cancelGrandchildren(treeNodes);
				lazyLoaderTree.getLazyLoader().setRecursive(false);
				
				lazyLoaderAdapter.cancelGrandchildren(treeNodes);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getCancelAllAction(final ILazyLoaderTree lazyLoaderTree, final ILazyLoaderAdapter lazyLoaderAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("cancel_load") + SwingLocale.getString("all_nodes"), IconFactory.getSwingIcon("stereo/cancel_16.png"), SwingLocale.getString("cancel_load") + SwingLocale.getString("all_nodes"))
		{
			public void execute(ActionEvent e)
			{
				if (!lazyLoaderAdapter.loadPermitted(null))
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame((JTree) lazyLoaderTree), SwingLocale.getString("node_selection") + SwingLocale.getString("cancel_load_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				lazyLoaderTree.cancelAll();
				lazyLoaderTree.getLazyLoader().setRecursive(false);
				
				lazyLoaderAdapter.cancelAll();
			}
		};
		KeyStrokeManager.registerComponent((JTree) lazyLoaderTree, action, KeyEvent.VK_ESCAPE);
		
		return action;
	}
	
	public static JSecurityAction getSyncLoadStrategyAction(final ILazyLoaderTree lazyLoaderTree)
	{
		final JSecurityAction action = new JSecurityAction(SwingLocale.getString("sync_loader_strategy"), IconFactory.getSwingIcon("stereo/application_16.png"), SwingLocale.getString("sync_loader_strategy"))
		{
			public void execute(ActionEvent e)
			{
				lazyLoaderTree.getLazyLoader().setSynchronized(true);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAsynLoadStrategyAction(final ILazyLoaderTree lazyLoaderTree)
	{
		final JSecurityAction action = new JSecurityAction(SwingLocale.getString("asyn_loader_strategy"), IconFactory.getSwingIcon("stereo/application_16.png"), SwingLocale.getString("asyn_loader_strategy"))
		{
			public void execute(ActionEvent e)
			{
				lazyLoaderTree.getLazyLoader().setSynchronized(false);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getRefreshAction(final ILazyLoaderTree lazyLoaderTree, final ILazyLoaderAdapter lazyLoaderAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("refresh"), IconFactory.getSwingIcon("stereo/refresh_16.png"), SwingLocale.getString("refresh") + SwingLocale.getString("children_nodes"))
		{
			public void execute(ActionEvent e)
			{
				boolean isLoadable = isLoadable(lazyLoaderTree);
				if (!isLoadable)
				{
					return;
				}
				
				int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame((JTree) lazyLoaderTree), SwingLocale.getString("load_refresh_description"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
				if (selectedValue != JBasicOptionPane.YES_OPTION)
				{
					return;
				}
				
				TreeNode treeNode = lazyLoaderTree.getSelectionTreeNode();
				if (!lazyLoaderAdapter.refreshPermitted(treeNode))
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame((JTree) lazyLoaderTree), SwingLocale.getString("node") + " " + SwingLocale.getString("quotation_left") + treeNode.toString() + SwingLocale.getString("quotation_right") + " " +  SwingLocale.getString("refresh_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				lazyLoaderTree.getLazyLoader().setRecursive(false);
				lazyLoaderTree.refresh(treeNode);
				
				lazyLoaderAdapter.refresh(treeNode);
			}
		};
		KeyStrokeManager.registerComponent((JTree) lazyLoaderTree, action, KeyEvent.VK_F5);
		
		return action;
	}
	
	public static JSecurityAction getSearchAction(final ILazyLoaderTree lazyLoaderTree)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("search"), IconFactory.getSwingIcon("stereo_search.png"), SwingLocale.getString("search_recursion"))
		{
			public void execute(ActionEvent e)
			{
				if (lazyLoaderTree.getLazyLoaderContainer() != null)
				{
					lazyLoaderTree.getLazyLoaderContainer().toggleShown();
				}
			}
		};
		
		return action;
	}
	
	public static boolean isLoadable(ILazyLoaderTree lazyLoaderTree)
	{
		boolean isSingleSelection = isSingleSelection((JTree) lazyLoaderTree, SwingLocale.getString("load"));
		if (!isSingleSelection)
		{
			return false;
		}
		
		TreeNode treeNode = lazyLoaderTree.getSelectionTreeNode();
		if (!(treeNode instanceof JLazyLoaderTreeNode))
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame((JTree) lazyLoaderTree), SwingLocale.getString("node") + " " + SwingLocale.getString("quotation_left") + treeNode.toString() + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("load_forbidden"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		
		return true;
	}
	
	public static boolean isMultiLoadable(ILazyLoaderTree lazyLoaderTree)
	{
		boolean isMultiSelection = isMultiSelection((JTree) lazyLoaderTree, SwingLocale.getString("load"));
		if (!isMultiSelection)
		{
			return false;
		}
		
		TreeNode[] treeNodes = lazyLoaderTree.getSelectionTreeNodes();
		for (int i = 0; i < treeNodes.length; i++)
		{
			TreeNode treeNode = treeNodes[i];
			if (!(treeNode instanceof JLazyLoaderTreeNode))
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame((JTree) lazyLoaderTree), SwingLocale.getString("node") + " " + SwingLocale.getString("quotation_left") + treeNode.toString() + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("load_forbidden"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
				
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isCancelable(ILazyLoaderTree lazyLoaderTree)
	{
		boolean isSingleSelection = isSingleSelection((JTree) lazyLoaderTree, SwingLocale.getString("cancel_load"));
		if (!isSingleSelection)
		{
			return false;
		}
		
		TreeNode treeNode = lazyLoaderTree.getSelectionTreeNode();
		if (!(treeNode instanceof JLazyLoaderTreeNode) && !(treeNode instanceof LoadingTreeNode))
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame((JTree) lazyLoaderTree), SwingLocale.getString("node") + " " + SwingLocale.getString("quotation_left") + treeNode.toString() + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("cancel_load_forbidden"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		
		return true;
	}
	
	public static boolean isMultiCancelable(ILazyLoaderTree lazyLoaderTree)
	{
		boolean isMultiSelection = isMultiSelection((JTree) lazyLoaderTree, SwingLocale.getString("cancel_load"));
		if (!isMultiSelection)
		{
			return false;
		}
		
		TreeNode[] treeNodes = lazyLoaderTree.getSelectionTreeNodes();
		for (int i = 0; i < treeNodes.length; i++)
		{
			TreeNode treeNode = treeNodes[i];
			if (!(treeNode instanceof JLazyLoaderTreeNode) && !(treeNode instanceof LoadingTreeNode))
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame((JTree) lazyLoaderTree), SwingLocale.getString("node") + " " + SwingLocale.getString("quotation_left") + treeNode.toString() + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("cancel_load_forbidden"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
				
				return false;
			}
		}
		
		return true;
	}
}