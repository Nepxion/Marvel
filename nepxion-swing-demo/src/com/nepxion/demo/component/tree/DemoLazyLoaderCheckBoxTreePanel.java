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

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.button.JBasicMenuButton;
import com.nepxion.swing.button.JBasicSplitButton;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.frame.JBasicFrame;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.layout.toolbar.ToolBarLayout;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.menuitem.JBasicRadioButtonMenuItem;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;
import com.nepxion.swing.renderer.tree.ElementTreeCellRenderer;
import com.nepxion.swing.separator.JBasicSeparator;
import com.nepxion.swing.tree.AbstractTreeAdapter;
import com.nepxion.swing.tree.lazyloader.AbstractLazyLoader;
import com.nepxion.swing.tree.lazyloader.AbstractLazyLoaderAdapter;
import com.nepxion.swing.tree.lazyloader.JLazyLoaderCheckBoxTree;
import com.nepxion.swing.tree.lazyloader.JLazyLoaderContainer;
import com.nepxion.swing.tree.lazyloader.JLazyLoaderTreeNode;
import com.nepxion.swing.tree.lazyloader.LazyLoaderTreeController;

public class DemoLazyLoaderCheckBoxTreePanel
	extends JPanel
{
	private FileSystemView fileSystemView;
	private FileTree fileTree;
	private FileTreeAdapter treeAdapter;
	private FileLazyLoaderAdapter lazyLoaderAdapter;
	
	public DemoLazyLoaderCheckBoxTreePanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new LazyLoaderTreePanel());
	}
	
	public class LazyLoaderTreePanel
		extends JPanel
	{
		public LazyLoaderTreePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("LazyLoader CheckBox Tree"));
			
			fileSystemView = FileSystemView.getFileSystemView();
			
			fileTree = new FileTree();
			
			FileToolBar fileToolBar = new FileToolBar(fileTree);	
			
			JLazyLoaderContainer lazyLoaderContainer = new JLazyLoaderContainer(fileTree);
			lazyLoaderContainer.add(fileToolBar, BorderLayout.NORTH);
			add(lazyLoaderContainer);
		}
	}
	
	private FileNode createFileNode(File file)
	{
		FileNode fileNode = new FileNode(file);
		if (file.isDirectory())
		{
			File[] files = fileSystemView.getFiles(file, false);
			if (files != null && files.length > 0)
			{
				fileNode.setLoaded(false);
				fileNode.setLeaf(false);
			}
			else
			{
				fileNode.setLoaded(true);
				fileNode.setLeaf(true);
			}
		}
		else
		{
			fileNode.setLoaded(true);
			fileNode.setLeaf(true);
		}
		String name = fileSystemView.getSystemDisplayName(file);
		Icon icon = fileSystemView.getSystemIcon(file);
		
		fileNode.setText(name);
		fileNode.setIcon(icon);
		fileNode.setToolTipText(name);
		
		return fileNode;
	}
	
	public class FileTree
		extends JLazyLoaderCheckBoxTree
	{
		private FilePopopMenu popupMenu;
		
		public FileTree()
		{
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("File System View");
			
			File[] files = fileSystemView.getRoots();
			for (int i = 0; i < files.length; i++)
			{
				FileNode fileNode = createFileNode(files[i]);
				root.add(fileNode);
			}
			
			DefaultTreeModel treeModel = new DefaultTreeModel(root);
			
			setModel(treeModel);
			// setRootVisible(false);
			// setSelectionMode(SINGLE_TREE_SELECTION);
			setCellRenderer(new ElementTreeCellRenderer(20));
			setLazyLoader(new FileLazyLoader(false));
			
			lazyLoaderAdapter = new FileLazyLoaderAdapter(this);
			treeAdapter = new FileTreeAdapter(this);
			
			popupMenu = new FilePopopMenu(this);
		}
		
		public void executePopupMenu(TreeNode treeNode, int treePathCount, int x, int y)
		{
			popupMenu.show(this, x, y);
		}
	}
	
	public class FileNode
		extends JLazyLoaderTreeNode
	{
		private File file;
		
		public FileNode(File file)
		{
			this.file = file;
		}
		
		public File getFile()
		{
			return file;
		}
		
		public void setFile(File file)
		{
			this.file = file;
		}
	}
	
	public class FileLazyLoader
		extends AbstractLazyLoader
	{
		public FileLazyLoader()
		{
			super();
		}
		
		public FileLazyLoader(boolean isSynchronized)
		{
			super(isSynchronized);
		}
		
		public void loadForeground(Object data, JLazyLoaderTreeNode lazyLoaderTreeNode)
			throws Exception
		{
			File[] files = (File[]) data;
			if (files != null && files.length > 0)
			{
				for (int i = 0; i < files.length; ++i)
				{
					FileNode fileNode = createFileNode(files[i]);
					lazyLoaderTreeNode.add(fileNode);
				}
			}
		}
		
		public Object loadBackground(JLazyLoaderTreeNode lazyLoaderTreeNode)
			throws Exception
		{
			FileNode fileNode = (FileNode) lazyLoaderTreeNode;
			File file = fileNode.getFile();
			File[] files = fileSystemView.getFiles(file, true);
			
			if (files != null && files.length != 0)
			{	
				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e)
				{
				}
			}
			
			return files;
		}
	}
	
	public class FileTreeAdapter
		extends AbstractTreeAdapter
	{
		public FileTreeAdapter(FileTree fileTree)
		{
		}
		
		public boolean addTreeNodePermitted(DefaultMutableTreeNode parentTreeNode)
		{
			return true;
		}
		
		public DefaultMutableTreeNode addTreeNode(DefaultMutableTreeNode parentTreeNode)
		{			
			return new ElementNode("新增节点", IconFactory.getSwingIcon("stereo/add_16.png"), "新增节点");
		}
		
		
		public boolean modifyTreeNodePermitted(DefaultMutableTreeNode treeNode)
		{
			return true;
		}
		
		public Object modifyTreeNode(DefaultMutableTreeNode treeNode)
		{
			return null;
		}
		
		
		public boolean deleteTreeNodePermitted(DefaultMutableTreeNode treeNode)
		{
			return true;
		}
		
		public boolean deleteTreeNode(DefaultMutableTreeNode treeNode)
		{
			return true;
		}
		
		
		public boolean deleteTreeNodesPermitted(TreeNode[] treeNodes)
		{
			return true;
		}
		
		public boolean deleteTreeNodes(TreeNode[] treeNodes)
		{
			return true;
		}
		
		
		public boolean renameTreeNodePermitted(DefaultMutableTreeNode treeNode)
		{
			return true;
		}
		
		public boolean renameTreeNode(DefaultMutableTreeNode treeNode, String text)
		{
			return true;
		}
		
		public boolean moveUpTreeNodePermitted(DefaultMutableTreeNode treeNode)
		{
			return true;
		}
		
		public boolean moveUpTreeNode(DefaultMutableTreeNode treeNode)
		{
			return true;
		}
		
		
		public boolean moveDownTreeNodePermitted(DefaultMutableTreeNode treeNode)
		{
			return true;
		}
		
		public boolean moveDownTreeNode(DefaultMutableTreeNode treeNode)
		{
			return true;
		}
	}
	
	public class FileLazyLoaderAdapter
		extends AbstractLazyLoaderAdapter
	{
		public FileLazyLoaderAdapter(FileTree fileTree)
		{
		}
		
		public boolean loadPermitted(TreeNode[] treeNodes)
		{
			return true;
		}
		
		public boolean load(TreeNode[] treeNodes)
		{
			return true;
		}
		
		public boolean loadGrandchildren(TreeNode[] treeNodes)
		{
			return true;
		}	
		
		public boolean loadAll()
		{
			return true;
		}	
		
		
		public boolean cancelPermitted(TreeNode[] treeNodes)
		{
			return true;
		}	
		
		public boolean cancel(TreeNode[] treeNodes)
		{
			return true;
		}	
		
		public boolean cancelGrandchildren(TreeNode[] treeNodes)
		{
			return true;
		}	
		
		public boolean cancelAll()
		{
			return true;
		}	
		
		
		public boolean refreshPermitted(TreeNode treeNode)
		{
			return true;
		}	
		
		public boolean refresh(TreeNode treeNode)
		{
			return true;
		}
	}
	
	public class FileToolBar
		extends JPanel
	{
		public FileToolBar(JLazyLoaderCheckBoxTree lazyLoaderTree)
		{
			setLayout(new ToolBarLayout());
			setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0));
			
			JBasicButton newButton = new JBasicButton(LazyLoaderTreeController.getAddAction(lazyLoaderTree, treeAdapter));
			KeyStrokeManager.registerButton(newButton, KeyEvent.VK_N, KeyEvent.CTRL_MASK);
			add(newButton);
			
			JBasicButton deleteButton = new JBasicButton(LazyLoaderTreeController.getDeleteAction(lazyLoaderTree, treeAdapter));
			KeyStrokeManager.registerButton(deleteButton, KeyEvent.VK_DELETE);	
			add(deleteButton);	
			
			JBasicButton renameButton = new JBasicButton(LazyLoaderTreeController.getRenameAction(lazyLoaderTree, treeAdapter));
			KeyStrokeManager.registerButton(renameButton, KeyEvent.VK_R, KeyEvent.CTRL_MASK);	
			add(renameButton);						
						
			add(new JBasicSeparator());	
			
			JBasicSplitButton loadButton = new JBasicSplitButton(LazyLoaderTreeController.getLoadAction(lazyLoaderTree, lazyLoaderAdapter));
			add(loadButton);
			
			JBasicPopupMenu loadPopupMenu = new JBasicPopupMenu();
			loadButton.setPopupMenu(loadPopupMenu);
			
			JBasicMenuItem loadMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getLoadAction(lazyLoaderTree, lazyLoaderAdapter));
			KeyStrokeManager.registerButton(loadMenuItem, KeyEvent.VK_F3);
			loadPopupMenu.add(loadMenuItem);
			
			loadPopupMenu.addSeparator();
			
			JBasicMenuItem loadGrandchildrenMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getLoadGrandchildrenAction(lazyLoaderTree, lazyLoaderAdapter));
			loadPopupMenu.add(loadGrandchildrenMenuItem);
			
			JBasicMenuItem loadAllMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getLoadAllAction(lazyLoaderTree, lazyLoaderAdapter));
			loadPopupMenu.add(loadAllMenuItem);
			
			JBasicSplitButton cancelButton = new JBasicSplitButton(LazyLoaderTreeController.getCancelAllAction(lazyLoaderTree, lazyLoaderAdapter));
			cancelButton.setText("取消");
			add(cancelButton);
			
			JBasicPopupMenu cancelPopupMenu = new JBasicPopupMenu();
			cancelButton.setPopupMenu(cancelPopupMenu);			
			
			JBasicMenuItem cancelMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCancelAction(lazyLoaderTree, lazyLoaderAdapter)); 
			cancelPopupMenu.add(cancelMenuItem);
			
			cancelPopupMenu.addSeparator();
			
			JBasicMenuItem cancelGrandchildrenMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCancelGrandchildrenAction(lazyLoaderTree, lazyLoaderAdapter));
			cancelPopupMenu.add(cancelGrandchildrenMenuItem);
			
			JBasicMenuItem cancelAllMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCancelAllAction(lazyLoaderTree, lazyLoaderAdapter));		
			KeyStrokeManager.registerButton(cancelAllMenuItem, KeyEvent.VK_ESCAPE);	
			cancelPopupMenu.add(cancelAllMenuItem);
			
			JBasicMenuButton loadStrategyButton = new JBasicMenuButton("策略", IconFactory.getSwingIcon("stereo/application_16.png"), "装载策略");
			add(loadStrategyButton);
			
			JBasicPopupMenu loadStrategyPopupMenu = new JBasicPopupMenu();
			loadStrategyButton.setPopupMenu(loadStrategyPopupMenu);
			
			ButtonGroup buttonGroup = new ButtonGroup();

			JBasicRadioButtonMenuItem asynLoadStrategyMenuItem = new JBasicRadioButtonMenuItem(LazyLoaderTreeController.getAsynLoadStrategyAction(lazyLoaderTree));	
			asynLoadStrategyMenuItem.setSelected(true);
			asynLoadStrategyMenuItem.setIcon(null);
			buttonGroup.add(asynLoadStrategyMenuItem);
			loadStrategyPopupMenu.add(asynLoadStrategyMenuItem);
			
			loadStrategyPopupMenu.addSeparator();
			
			JBasicRadioButtonMenuItem syncLoadStrategyMenuItem = new JBasicRadioButtonMenuItem(LazyLoaderTreeController.getSyncLoadStrategyAction(lazyLoaderTree)); 		
			syncLoadStrategyMenuItem.setIcon(null);
			buttonGroup.add(syncLoadStrategyMenuItem);
			loadStrategyPopupMenu.add(syncLoadStrategyMenuItem);			
			
			add(new JBasicSeparator());
			
			JBasicButton refreshButton = new JBasicButton(LazyLoaderTreeController.getRefreshAction(lazyLoaderTree, lazyLoaderAdapter));
			KeyStrokeManager.registerButton(refreshButton, KeyEvent.VK_F5);	
			add(refreshButton);

			JBasicButton searchButton = new JBasicButton(LazyLoaderTreeController.getSearchAction(lazyLoaderTree));
			KeyStrokeManager.registerButton(searchButton, KeyEvent.VK_F, KeyEvent.CTRL_MASK);	
			add(searchButton);
			
			add(new JBasicSeparator());
			
			JBasicButton moveUpAction = new JBasicButton(LazyLoaderTreeController.getMoveUpAction(lazyLoaderTree, treeAdapter));
			add(moveUpAction);	
			
			JBasicButton moveDownAction = new JBasicButton(LazyLoaderTreeController.getMoveDownAction(lazyLoaderTree, treeAdapter));
			add(moveDownAction);
			
			add(new JBasicSeparator());

			JBasicSplitButton expandButton = new JBasicSplitButton(LazyLoaderTreeController.getExpandAction(lazyLoaderTree));
			add(expandButton);
			
			JBasicPopupMenu expandPopupMenu = new JBasicPopupMenu();
			expandButton.setPopupMenu(expandPopupMenu);			
			
			JBasicMenuItem expandMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getExpandAction(lazyLoaderTree));
			expandPopupMenu.add(expandMenuItem);
			
			expandPopupMenu.addSeparator();
			
			JBasicMenuItem expandGrandchildrenMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getExpandGrandchildrenAction(lazyLoaderTree));
			expandPopupMenu.add(expandGrandchildrenMenuItem);
			
			JBasicMenuItem expandAllMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getExpandAllAction(lazyLoaderTree));
			expandPopupMenu.add(expandAllMenuItem);
			

			JBasicSplitButton collapseButton = new JBasicSplitButton(LazyLoaderTreeController.getCollapseAction(lazyLoaderTree));
			add(collapseButton);
			
			JBasicPopupMenu collapsePopupMenu = new JBasicPopupMenu();
			collapseButton.setPopupMenu(collapsePopupMenu);				
			
			JBasicMenuItem collapseMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCollapseAction(lazyLoaderTree));
			collapsePopupMenu.add(collapseMenuItem);
			
			collapsePopupMenu.addSeparator();
			
			JBasicMenuItem collapseGrandchildrenMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCollapseGrandchildrenAction(lazyLoaderTree));
			collapsePopupMenu.add(collapseGrandchildrenMenuItem);
			
			JBasicMenuItem collapseAllMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCollapseAllAction(lazyLoaderTree));
			collapsePopupMenu.add(collapseAllMenuItem);
			
			ButtonManager.updateUI(this);		
		}
	}
	
	public class FilePopopMenu
		extends JBasicPopupMenu
	{
		public FilePopopMenu(JLazyLoaderCheckBoxTree lazyLoaderTree)
		{		
			JBasicMenuItem newMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getAddAction(lazyLoaderTree, treeAdapter));
			KeyStrokeManager.registerButton(newMenuItem, KeyEvent.VK_N, KeyEvent.CTRL_MASK);				
			add(newMenuItem);						
			
			JBasicMenuItem deleteMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getDeleteAction(lazyLoaderTree, treeAdapter));
			KeyStrokeManager.registerButton(deleteMenuItem, KeyEvent.VK_DELETE);			
			add(deleteMenuItem);
						
			JBasicMenuItem renameMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getRenameAction(lazyLoaderTree, treeAdapter));
			KeyStrokeManager.registerButton(renameMenuItem, KeyEvent.VK_R, KeyEvent.CTRL_MASK);				
			add(renameMenuItem);							
						
			addSeparator();	    
			
			JBasicMenuItem loadMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getLoadAction(lazyLoaderTree, lazyLoaderAdapter));
			KeyStrokeManager.registerButton(loadMenuItem, KeyEvent.VK_F3);			
			add(loadMenuItem);
			
			JBasicMenuItem loadGrandchildrenMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getLoadGrandchildrenAction(lazyLoaderTree, lazyLoaderAdapter));
			add(loadGrandchildrenMenuItem);
			
			JBasicMenuItem loadAllMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getLoadAllAction(lazyLoaderTree, lazyLoaderAdapter));
			add(loadAllMenuItem);
			
			addSeparator();
			
			JBasicMenuItem cancelMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCancelAction(lazyLoaderTree, lazyLoaderAdapter)); 
			add(cancelMenuItem);
			
			JBasicMenuItem cancelGrapndchildrenMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCancelGrandchildrenAction(lazyLoaderTree, lazyLoaderAdapter));
			add(cancelGrapndchildrenMenuItem);
			
			JBasicMenuItem cancelAllMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCancelAllAction(lazyLoaderTree, lazyLoaderAdapter));		
			KeyStrokeManager.registerButton(cancelAllMenuItem, KeyEvent.VK_ESCAPE);	
			add(cancelAllMenuItem);
			
			addSeparator();
			
			JBasicMenuItem refreshMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getRefreshAction(lazyLoaderTree, lazyLoaderAdapter));
			KeyStrokeManager.registerButton(refreshMenuItem, KeyEvent.VK_F5);				
			add(refreshMenuItem);		

			JBasicMenuItem searchMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getSearchAction(lazyLoaderTree));
			KeyStrokeManager.registerButton(searchMenuItem, KeyEvent.VK_F, KeyEvent.CTRL_MASK);				
			add(searchMenuItem);
			
			addSeparator();			
			
			JBasicMenuItem moveUpAction = new JBasicMenuItem(LazyLoaderTreeController.getMoveUpAction(lazyLoaderTree, treeAdapter));
			add(moveUpAction);	
			
			JBasicMenuItem moveDownAction = new JBasicMenuItem(LazyLoaderTreeController.getMoveDownAction(lazyLoaderTree, treeAdapter));
			add(moveDownAction);
			
			addSeparator();
			
			JBasicMenuItem expandMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getExpandAction(lazyLoaderTree));
			add(expandMenuItem);
			
			JBasicMenuItem expandGrandchildrenMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getExpandGrandchildrenAction(lazyLoaderTree));
			add(expandGrandchildrenMenuItem);
			
			JBasicMenuItem expandAllMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getExpandAllAction(lazyLoaderTree));
			add(expandAllMenuItem);
			
			addSeparator();
			
			JBasicMenuItem collapseMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCollapseAction(lazyLoaderTree));
			add(collapseMenuItem);
			
			JBasicMenuItem collapseGrandchildrenMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCollapseGrandchildrenAction(lazyLoaderTree));
			add(collapseGrandchildrenMenuItem);
			
			JBasicMenuItem collapseAllMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCollapseAllAction(lazyLoaderTree));
			add(collapseAllMenuItem);
		}
	}
	
	public static void main(String[] args)
	{
		LookAndFeelManager.setAlloyLookAndFeel();
		JBasicFrame frame = new JBasicFrame();
		frame.getContentPane().add(new DemoLazyLoaderTreePanel());
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
}