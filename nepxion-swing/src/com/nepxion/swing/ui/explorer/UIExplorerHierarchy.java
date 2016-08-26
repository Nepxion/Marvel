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

import com.nepxion.swing.framework.dockable.JDockable;
import com.nepxion.swing.framework.dockable.JDockableView;
import com.nepxion.swing.framework.dockable.JDockableHierarchy;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.scrollpane.JBasicScrollPane;

public class UIExplorerHierarchy
	extends JDockableHierarchy
{
	public static final String EXPLORER_TITLE = SwingLocale.getString("explorer");
	public static final String CONTENT_PANE_TITLE = SwingLocale.getString("content_pane");
	
	public UIExplorerHierarchy()
	{
		initContentPane();
		initBar();
	}
	
	private void initContentPane()
	{
		JDockableView explorerView = new JDockableView(EXPLORER_TITLE, IconFactory.getSwingIcon("explorer.png"), EXPLORER_TITLE, new JBasicScrollPane(new UIExplorerTree()));
		JDockableView contentPaneView = new JDockableView(CONTENT_PANE_TITLE, IconFactory.getSwingIcon("content_pane.png"), CONTENT_PANE_TITLE, new JBasicScrollPane(new UIExplorerTable()));
		
		JDockable dockable = new JDockable();
		dockable.setOrientation(JDockable.HORIZONTAL_SPLIT);
		dockable.add(explorerView, JDockable.FLEXIBLE);
		dockable.add(contentPaneView, JDockable.VARY);
		
		dockable.setDividerLocation(0, 250);
		
		getDockableContainer().setContentPane(dockable);
	}
	
	private void initBar()
	{
		getBarContainer().setVisible(false);
		getStatusBarContainer().setVisible(false);
	}
}