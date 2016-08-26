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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Enumeration;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.button.JBasicMenuButton;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.layout.toolbar.ToolBarLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menu.JBasicMenu;
import com.nepxion.swing.menuitem.JBasicCheckBoxMenuItem;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.menuitem.JBasicRadioButtonMenuItem;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.searchable.JSearchableContainer;
import com.nepxion.swing.textfield.JBasicTextField;
import com.nepxion.swing.tip.balloon.JBalloonTip;

public class JLazyLoaderContainer
	extends JSearchableContainer implements ILazyLoaderContainer
{
	private ILazyLoaderTree lazyLoaderTree;
	private SearchBar searchBar;
	private boolean isShown = false;
	
	public JLazyLoaderContainer()
	{
		this(null);
	}
	
	public JLazyLoaderContainer(ILazyLoaderTree lazyLoaderTree)
	{
		this.lazyLoaderTree = lazyLoaderTree;
		this.searchBar = new SearchBar();
		
		setLazyLoaderTree(lazyLoaderTree);
		
		ActionListener toggleShownActionListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				toggleShown();
			}
		};
		KeyStrokeManager.registerComponent(this, toggleShownActionListener, KeyEvent.VK_F, KeyEvent.CTRL_MASK);
	}
	
	public ILazyLoaderTree getLazyLoaderTree()
	{
		return lazyLoaderTree;
	}
	
	public void setLazyLoaderTree(ILazyLoaderTree lazyLoaderTree)
	{
		this.lazyLoaderTree = lazyLoaderTree;
		this.lazyLoaderTree.setLazyLoaderContainer(this);
		
		add(new JBasicScrollPane((JTree) lazyLoaderTree), BorderLayout.CENTER);
	}
	
	public void toggleShown()
	{
		if (isShown)
		{
			hide(searchBar);
		}
		else
		{
			show(searchBar);
		}
		isShown = !isShown;
	}
	
	public class SearchBar
		extends JPanel
	{
		private JBasicButton closeButton;
		private JBasicTextField searchTextField;
		private JBasicButton searchButton;
		private JBasicButton backwardButton;
		private JBasicButton forwardButton;
		private JBasicMenuButton preferenceMenuButton;
		private JBasicMenuButton historyMenuButton;
		
		private JBasicCheckBoxMenuItem caseSensitiveMenuItem;
		private JBasicCheckBoxMenuItem matchTextMenuItem;
		
		private ButtonGroup recursionDepthButtonGroup;
		
		private ButtonGroup historyButtonGroup;
		private JBasicMenuItem historyEmptyMenuItem;
		
		private int maximumHistoryCount = 10;
		
		public SearchBar()
		{
			setLayout(new ToolBarLayout());
			
			closeButton = new JBasicButton(IconFactory.getSwingIcon("stereo/close_16.png"), SwingLocale.getString("close"));
			closeButton.setDimension(new Dimension(26, 26));
			closeButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					toggleShown();
				}
			}
			);
			
			searchTextField = new JBasicTextField();
			DimensionManager.setDimension(searchTextField, new Dimension(70, 24));
			
			searchButton = new JBasicButton(IconFactory.getSwingIcon("stereo_search.png"), SwingLocale.getString("search"));
			searchButton.setDimension(new Dimension(26, 26));
			ActionListener searchActionListener = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					boolean isLoadable = LazyLoaderTreeController.isLoadable(lazyLoaderTree);
					if (!isLoadable)
					{
						return;
					}
					
					String searchText = searchTextField.getText().trim();
					if (searchText.equals(""))
					{
						searchTextField.showTip(SwingLocale.getString("input_not_null"), JBalloonTip.TIP_ICON_ERROR_MESSAGE, 1, 7);
						
						return;
					}
					
					JLazyLoaderTreeNode treeNode = (JLazyLoaderTreeNode) lazyLoaderTree.getSelectionTreeNode();
					int recursionDepth = getRecursionDepth();
					
					lazyLoaderTree.getLazyLoader().setRecursive(true);
					lazyLoaderTree.getLazyLoader().setRecursionDepth(recursionDepth);
					
					SearchDescription searchDescription = new SearchDescription();
					searchDescription.setSearchText(searchText);
					searchDescription.setCaseSensitive(caseSensitiveMenuItem.isSelected());
					searchDescription.setTextMatched(matchTextMenuItem.isSelected());
					searchDescription.setTreeNode(treeNode);
					
					lazyLoaderTree.getLazyLoader().setSearchDescription(searchDescription);
					lazyLoaderTree.search(treeNode);
					
					addHistory(searchDescription);
				}
			};
			searchButton.addActionListener(searchActionListener);
			KeyStrokeManager.registerButton(searchButton, searchActionListener, KeyEvent.VK_ENTER);
			
			forwardButton = new JBasicButton(IconFactory.getSwingIcon("stereo/arrow_down_16.png"), SwingLocale.getString("search_forward"));
			forwardButton.setDimension(new Dimension(26, 26));
			ActionListener forwardActionListener = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					SearchDescription searchDescription = getSearchDescription();
					
					boolean hasResult = hasResult(searchDescription);
					if (!hasResult)
					{
						return;
					}
					
					int resultIndex = searchDescription.getResultIndex();
					TreeNode treeNode = (TreeNode) searchDescription.getResult().get(resultIndex);
					lazyLoaderTree.setSelectionTreeNode(treeNode);
					lazyLoaderTree.scrollToVisible(treeNode);
					searchDescription.forward();
				}
			};
			forwardButton.addActionListener(forwardActionListener);
			KeyStrokeManager.registerButton(forwardButton, forwardActionListener, KeyEvent.VK_D, KeyEvent.CTRL_MASK);
			
			backwardButton = new JBasicButton(IconFactory.getSwingIcon("stereo/arrow_up_16.png"), SwingLocale.getString("search_backward"));
			backwardButton.setDimension(new Dimension(26, 26));
			ActionListener backwardActionListener = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					SearchDescription searchDescription = getSearchDescription();
					
					boolean hasResult = hasResult(searchDescription);
					if (!hasResult)
					{
						return;
					}
					
					int resultIndex = searchDescription.getResultIndex();
					TreeNode treeNode = (TreeNode) searchDescription.getResult().get(resultIndex);
					lazyLoaderTree.setSelectionTreeNode(treeNode);
					lazyLoaderTree.scrollToVisible(treeNode);
					searchDescription.backward();
				}
			};
			backwardButton.addActionListener(backwardActionListener);
			KeyStrokeManager.registerButton(backwardButton, backwardActionListener, KeyEvent.VK_U, KeyEvent.CTRL_MASK);
			
			preferenceMenuButton = new JBasicMenuButton(IconFactory.getSwingIcon("stereo/favorite_16.png"), SwingLocale.getString("preference"));
			preferenceMenuButton.setDimension(new Dimension(31, 26));
			
			JBasicPopupMenu preferencePopupMenu = new JBasicPopupMenu();
			preferenceMenuButton.setPopupMenu(preferencePopupMenu);
			
			JBasicMenu recursionDepthMenu = createRecursionDepthMenu();
			preferencePopupMenu.add(recursionDepthMenu);
			
			JBasicMenuItem highlightMenuItem = new JBasicMenuItem(SwingLocale.getString("highlight"), SwingLocale.getString("highlight"));
			highlightMenuItem.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					SearchDescription searchDescription = getSearchDescription();
					
					boolean hasResult = hasResult(searchDescription);
					if (!hasResult)
					{
						return;
					}
					
					TreeNode[] treeNodes = new TreeNode[searchDescription.getResult().size()];
					for (int i = 0; i < searchDescription.getResult().size(); i++)
					{
						treeNodes[i] = (TreeNode) searchDescription.getResult().get(i);
					}
					
					lazyLoaderTree.clearSelection();
					lazyLoaderTree.addSelectionTreeNodes(treeNodes);
				}
			}
			);
			preferencePopupMenu.add(highlightMenuItem);
			
			preferencePopupMenu.addSeparator();
			
			caseSensitiveMenuItem = new JBasicCheckBoxMenuItem(SwingLocale.getString("case_sensitive"), SwingLocale.getString("case_sensitive"));
			preferencePopupMenu.add(caseSensitiveMenuItem);
			
			matchTextMenuItem = new JBasicCheckBoxMenuItem(SwingLocale.getString("match_text"), SwingLocale.getString("match_text"));
			preferencePopupMenu.add(matchTextMenuItem);
			
			historyButtonGroup = new ButtonGroup();
			
			historyMenuButton = new JBasicMenuButton(IconFactory.getSwingIcon("stereo/history_16.png"), SwingLocale.getString("history_record"));
			historyMenuButton.setDimension(new Dimension(31, 26));
			
			JBasicPopupMenu historyPopupMenu = new JBasicPopupMenu();
			historyMenuButton.setPopupMenu(historyPopupMenu);
			
			historyEmptyMenuItem = new JBasicMenuItem(SwingLocale.getString("history_empty"), SwingLocale.getString("history_empty"));
			historyEmptyMenuItem.setEnabled(false);
			historyPopupMenu.add(historyEmptyMenuItem);
			
			historyPopupMenu.addSeparator();
			
			JBasicMenuItem clearMenuItem = new JBasicMenuItem(SwingLocale.getString("history_record_clear"), SwingLocale.getString("history_record_clear"));
			clearMenuItem.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					clearHistories();
				}
			}
			);
			historyPopupMenu.add(clearMenuItem);
			
			setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
			add(closeButton);
			add(searchTextField);
			add(searchButton);
			add(forwardButton);
			add(backwardButton);
			add(preferenceMenuButton);
			add(historyMenuButton);
			
			ButtonManager.updateUI(this);
		}
		
		private JBasicMenu createRecursionDepthMenu()
		{
			JBasicMenu recursionDepthMenu = new JBasicMenu(SwingLocale.getString("search_depth"), SwingLocale.getString("search_depth"));
			
			recursionDepthButtonGroup = new ButtonGroup();
			for (int i = 1; i <= 10; i++)
			{
				RecursionDepthRadioButtonMenuItem recursionDepthMenuItem = new RecursionDepthRadioButtonMenuItem(i + SwingLocale.getString("search_deep_level"), i + SwingLocale.getString("search_deep_level"));
				recursionDepthMenuItem.setRecursionDepth(i);
				recursionDepthButtonGroup.add(recursionDepthMenuItem);
				recursionDepthMenu.add(recursionDepthMenuItem);
			}
			
			RecursionDepthRadioButtonMenuItem recursionAllMenuItem = new RecursionDepthRadioButtonMenuItem(SwingLocale.getString("search_full_deep_level"), SwingLocale.getString("search_full_deep_level"), true);
			recursionAllMenuItem.setRecursionDepth(-1);
			
			recursionDepthMenu.addSeparator();
			
			recursionDepthButtonGroup.add(recursionAllMenuItem);
			recursionDepthMenu.add(recursionAllMenuItem);
			
			return recursionDepthMenu;
		}
		
		private int getRecursionDepth()
		{
			for (Enumeration enumeration = recursionDepthButtonGroup.getElements(); enumeration.hasMoreElements();)
			{
				RecursionDepthRadioButtonMenuItem recursionDepthRadioButtonMenuItem = (RecursionDepthRadioButtonMenuItem) enumeration.nextElement();
				if (recursionDepthRadioButtonMenuItem.isSelected())
				{
					return recursionDepthRadioButtonMenuItem.getRecursionDepth();
				}
			}
			
			return -1;
		}
		
		private SearchDescription getSearchDescription()
		{
			for (Enumeration enumeration = historyButtonGroup.getElements(); enumeration.hasMoreElements();)
			{
				HistoryRadioButtonMenuItem historyRadioButtonMenuItem = (HistoryRadioButtonMenuItem) enumeration.nextElement();
				if (historyRadioButtonMenuItem.isSelected())
				{
					return historyRadioButtonMenuItem.getSearchDescription();
				}
			}
			
			return null;
		}
		
		private void addHistory(SearchDescription searchDescription)
		{
			JBasicPopupMenu historyPopupMenu = (JBasicPopupMenu) historyMenuButton.getPopupMenu();
			
			if (historyPopupMenu.getComponent(0) == historyEmptyMenuItem)
			{
				historyPopupMenu.remove(historyEmptyMenuItem);
			}
			if (historyPopupMenu.getComponentCount() >= maximumHistoryCount + 2)
			{
				historyButtonGroup.remove((HistoryRadioButtonMenuItem) historyPopupMenu.getComponent(maximumHistoryCount - 1));
				historyPopupMenu.remove(historyPopupMenu.getComponent(maximumHistoryCount - 1));
			}
			
			HistoryRadioButtonMenuItem historyRadioButtonMenuItem = new HistoryRadioButtonMenuItem(searchDescription);
			historyButtonGroup.add(historyRadioButtonMenuItem);
			historyPopupMenu.add(historyRadioButtonMenuItem, 0);
			historyRadioButtonMenuItem.setSelected(true);
		}
		
		private void clearHistories()
		{
			JBasicPopupMenu historyPopupMenu = (JBasicPopupMenu) historyMenuButton.getPopupMenu();
			
			for (Enumeration enumeration = historyButtonGroup.getElements(); enumeration.hasMoreElements();)
			{
				HistoryRadioButtonMenuItem historyRadioButtonMenuItem = (HistoryRadioButtonMenuItem) enumeration.nextElement();
				historyPopupMenu.remove(historyRadioButtonMenuItem);
			}
			historyPopupMenu.add(historyEmptyMenuItem, 0);
			historyButtonGroup = new ButtonGroup();
		}
		
		private boolean hasResult(SearchDescription searchDescription)
		{
			if (searchDescription == null)
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame((JTree) lazyLoaderTree), SwingLocale.getString("search_result_empty"), SwingLocale.getString("information"), JBasicOptionPane.INFORMATION_MESSAGE);
				
				return false;
			}
			
			if (searchDescription.getResult() == null || searchDescription.getResult().isEmpty())
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame((JTree) lazyLoaderTree), SwingLocale.getString("search_result_empty"), SwingLocale.getString("information"), JBasicOptionPane.INFORMATION_MESSAGE);
			
				return false;
			}
			
			return true;
		}
	}
	
	public class RecursionDepthRadioButtonMenuItem
		extends JBasicRadioButtonMenuItem
	{
		private int recursionDepth;
		
		public RecursionDepthRadioButtonMenuItem(String text, String toolTipText)
		{
			super(text, toolTipText);
		}
		
		public RecursionDepthRadioButtonMenuItem(String text, String toolTipText, boolean selected)
		{
			super(text, toolTipText, selected);
		}
		
		public int getRecursionDepth()
		{
			return recursionDepth;
		}
		
		public void setRecursionDepth(int recursionDepth)
		{
			this.recursionDepth = recursionDepth;
		}
	}
	
	public class HistoryRadioButtonMenuItem
		extends JBasicRadioButtonMenuItem
	{
		private SearchDescription searchDescription;
		
		public HistoryRadioButtonMenuItem(SearchDescription searchDescription)
		{
			super(searchDescription.toString(), searchDescription.toString());
			
			this.searchDescription = searchDescription;
		}
		
		public HistoryRadioButtonMenuItem(SearchDescription searchDescription, boolean selected)
		{
			super(searchDescription.toString(), searchDescription.toString(), selected);
			
			this.searchDescription = searchDescription;
		}
		
		public SearchDescription getSearchDescription()
		{
			return searchDescription;
		}
		
		public void setSearchDescription(SearchDescription searchDescription)
		{
			this.searchDescription = searchDescription;
		}
	}
}