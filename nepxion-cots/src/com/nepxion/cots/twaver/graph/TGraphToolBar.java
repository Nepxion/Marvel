package com.nepxion.cots.twaver.graph;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.cots.twaver.locale.TLocale;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicSplitButton;
import com.nepxion.swing.button.JClassicMenuButton;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.menu.JBasicMenu;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class TGraphToolBar
	extends JBasicToolBar
{
	public TGraphToolBar(TGraph graph)
	{
		this(graph, true);
	}
	
	public TGraphToolBar(final TGraph graph, boolean showControlBar)
	{
		graph.setToolbar(this);
		
		JBasicPopupMenu controlBarPopupMenu = new JBasicPopupMenu();
		
		JBasicMenuItem controlBarVisibleMenuItem = new JBasicMenuItem(TGraphController.getShowControlBarAction(graph));
		controlBarPopupMenu.add(controlBarVisibleMenuItem);
		
		JBasicMenuItem controlBarHiddenMenuItem = new JBasicMenuItem(TGraphController.getHideControlBarAction(graph));
		controlBarPopupMenu.add(controlBarHiddenMenuItem);
		
		if (showControlBar)
		{
			controlBarVisibleMenuItem.doClick();
		}
		else
		{
			controlBarHiddenMenuItem.doClick();
		}
		
		controlBarPopupMenu.addSeparator();
		
		JBasicMenu toggleTabMenu = new JBasicMenu(TLocale.getString("operation_pane_toggle"), TLocale.getString("operation_pane_toggle"));
		toggleTabMenu.setIcon(TIconFactory.getSwingIcon("toggle_layout.png"));
		controlBarPopupMenu.add(toggleTabMenu);
		
		TGraphControlBar controlBar = (TGraphControlBar) graph.getControlBarInternalFrame().getContent();
		for (int i = 0; i < controlBar.getTabCount(); i++)
		{
			JBasicMenuItem toggleMenuItem = new JBasicMenuItem(TGraphController.getToggleControlBarAction(graph.getControlBarInternalFrame(), i));
			toggleTabMenu.add(toggleMenuItem);
		}
		
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			JClassicMenuButton panelButton = new JClassicMenuButton(TLocale.getString("operation_pane"), TIconFactory.getContextIcon("pane.png"), TLocale.getString("operation_pane_description"));
			panelButton.setPopupMenu(controlBarPopupMenu);
			add(panelButton);
		}
		else
		{
			JBasicSplitButton panelButton = new JBasicSplitButton(TGraphController.getToggleControlBarAction(graph));
			panelButton.setPopupMenu(controlBarPopupMenu);
			add(panelButton);
		}
		
		ButtonManager.updateUI(this);
	}
}