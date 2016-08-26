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

import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import com.nepxion.cots.twaver.element.TGroupType;
import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.cots.twaver.locale.TLocale;
import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.button.JBasicMenuButton;
import com.nepxion.swing.button.JBasicToggleButton;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.menuitem.JBasicRadioButtonMenuItem;
import com.nepxion.swing.outlookbar.JFlatOutlook;
import com.nepxion.swing.outlookbar.JFlatOutlookBar;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;

public class TGraphControlBar
	extends JFlatOutlookBar
{
	private TGraph graph;
	
	private ViewToolBar viewToolBar;
	private NodeToolBar nodeToolBar;
	private IOToolBar ioToolBar;
	
	public TGraphControlBar(TGraph graph)
	{
		this.graph = graph;
		
		viewToolBar = new ViewToolBar();
		nodeToolBar = new NodeToolBar();
		ioToolBar = new IOToolBar();
		
		addTab(TLocale.getString("operation_view"), null, makeScrollPane(viewToolBar), TLocale.getString("operation_view"));
		addTab(TLocale.getString("operation_node"), null, makeScrollPane(nodeToolBar), TLocale.getString("operation_view"));
		addTab(TLocale.getString("operation_io"), null, makeScrollPane(ioToolBar), TLocale.getString("operation_view"));
		
		setEnableImport(false);
	}
	
	public TGraph getGraph()
	{
		return graph;
	}
	
	public ViewToolBar getViewToolBar()
	{
		return viewToolBar;
	}
	
	public NodeToolBar getNodeToolBar()
	{
		return nodeToolBar;
	}
	
	public IOToolBar getIOToolBar()
	{
		return ioToolBar;
	}
	
	public class ViewToolBar
		extends JPanel
	{
		private JFlatOutlook viewOutlook;
		
		public ViewToolBar()
		{
			double[][] size = 
			{
				{30, 30},
				{TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}
			};
			
			viewOutlook = new JFlatOutlook();
			viewOutlook.setLayout(new TableLayout(size));
			
			JBasicToggleButton selectButton = new JBasicToggleButton(TGraphController.getSelectAction(graph));
			selectButton.setSelected(true);
			selectButton.setText("");
			viewOutlook.add(selectButton, "0, 0");
			
			JBasicToggleButton panButton = new JBasicToggleButton(TGraphController.getPanAction(graph));
			panButton.setText("");
			viewOutlook.add(panButton, "0, 1");
			
			JBasicToggleButton lazeMoveButton = new JBasicToggleButton(TGraphController.getLazyMoveAction(graph));
			lazeMoveButton.setText("");
			viewOutlook.add(lazeMoveButton, "1, 1");
			
			JBasicButton zoomInButton = new JBasicButton(TGraphController.getZoomInAction(graph));
			zoomInButton.setText("");
			viewOutlook.add(zoomInButton, "0, 2");
			
			JBasicButton zoomOutButton = new JBasicButton(TGraphController.getZoomOutAction(graph));
			zoomOutButton.setText("");
			viewOutlook.add(zoomOutButton, "1, 2");
			
			JBasicToggleButton zoomInRectangleButton = new JBasicToggleButton(TGraphController.getZoomInRectangleAction(graph));
			zoomInRectangleButton.setText("");
			viewOutlook.add(zoomInRectangleButton, "0, 3");
			
			JBasicButton zoomResetButton = new JBasicButton(TGraphController.getZoomResetAction(graph));
			zoomResetButton.setText("");
			viewOutlook.add(zoomResetButton, "1, 3");
			
			JBasicToggleButton magnifierButton = new JBasicToggleButton(TGraphController.getMagnifierAction(graph));
			magnifierButton.setText("");
			viewOutlook.add(magnifierButton, "0, 4");
			
			JBasicPopupMenu zoomPopupMenu = new JBasicPopupMenu();
			
			JBasicMenuItem zoomToOverviewMenuItem = new JBasicMenuItem(TGraphController.getZoomToOverviewAction(graph));
			zoomPopupMenu.add(zoomToOverviewMenuItem);
			
			zoomPopupMenu.addSeparator();
			
			JBasicMenuItem zoomBackMenuItem = new JBasicMenuItem(TGraphController.getZoomBackAction(graph));
			zoomPopupMenu.add(zoomBackMenuItem);
			
			JBasicMenuButton zoomButton = new JBasicMenuButton(TIconFactory.getContextIcon("zoom.png"), TLocale.getString("graph_zoom"));
			zoomButton.setPopupMenu(zoomPopupMenu);
			viewOutlook.add(zoomButton, "1, 4");
			
			JBasicToggleButton scaleButton = new JBasicToggleButton(TGraphController.getScaleAction(graph));
			scaleButton.setText("");
			scaleButton.setGrouped(false);
			viewOutlook.add(scaleButton, "0, 5");
			
			JBasicToggleButton layoutButton = new JBasicToggleButton(TGraphController.getLayoutAction(graph));
			layoutButton.setText("");
			layoutButton.setGrouped(false);
			viewOutlook.add(layoutButton, "1, 5");
			
			JBasicButton fullscreenButton = new JBasicButton(TGraphController.getFullScreenAction(graph));
			fullscreenButton.setText("");
			viewOutlook.add(fullscreenButton, "0, 6");
			
			JBasicToggleButton overviewButton = new JBasicToggleButton(TGraphController.getOverviewAction(graph));
			overviewButton.setText("");
			overviewButton.setGrouped(false);
			viewOutlook.add(overviewButton, "1, 6");
						
			ButtonManager.updateUI(viewOutlook, new Dimension(25, 25), new ButtonGroup());
			
			add(viewOutlook);
		}
		
		public JFlatOutlook getViewOutlook()
		{
			return viewOutlook;
		}
	}
	
	
	public class NodeToolBar
		extends JPanel
	{
		private JFlatOutlook nodeOutlook;
		
		public NodeToolBar()
		{
			double[][] size = 
			{
				{30, 30},
				{TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}
			};
			
			nodeOutlook = new JFlatOutlook();
			nodeOutlook.setLayout(new TableLayout(size));
						
			JBasicPopupMenu lockPopupMenu = new JBasicPopupMenu();
			
			JBasicMenuItem lockAllMenuItem = new JBasicMenuItem(TGraphController.getLockAllAction(graph));
			lockPopupMenu.add(lockAllMenuItem);
			
			JBasicMenuItem unLockAllMenuItem = new JBasicMenuItem(TGraphController.getUnLockAllAction(graph));
			lockPopupMenu.add(unLockAllMenuItem);
			
			lockPopupMenu.addSeparator();
			
			JBasicMenuItem lockSelectionMenuItem = new JBasicMenuItem(TGraphController.getLockSelectionAction(graph));
			lockPopupMenu.add(lockSelectionMenuItem);
			
			JBasicMenuItem unLockSelectionMenuItem = new JBasicMenuItem(TGraphController.getUnLockSelectionAction(graph));
			lockPopupMenu.add(unLockSelectionMenuItem);
			
			JBasicMenuButton lockButton = new JBasicMenuButton(TIconFactory.getContextIcon("lock.png"), TLocale.getString("element_lock_and_unlock"));
			lockButton.setPopupMenu(lockPopupMenu);
			nodeOutlook.add(lockButton, "0, 0");
			
			JBasicButton hideChildrenButton = new JBasicButton(TGraphController.getHideChildrenAction(graph));
			hideChildrenButton.setText("");
			nodeOutlook.add(hideChildrenButton, "1, 0");
			
			JBasicPopupMenu alignPopupMenu = new JBasicPopupMenu();
			
			JBasicMenuItem alignLeftMenuItem = new JBasicMenuItem(TGraphController.getAlignLeftAction(graph));
			alignPopupMenu.add(alignLeftMenuItem);
			
			JBasicMenuItem alignVerticalCenterMenuItem = new JBasicMenuItem(TGraphController.getAlignVerticalCenterAction(graph));
			alignPopupMenu.add(alignVerticalCenterMenuItem);
			
			JBasicMenuItem alignRightMenuItem = new JBasicMenuItem(TGraphController.getAlignRightAction(graph));
			alignPopupMenu.add(alignRightMenuItem);
			
			alignPopupMenu.addSeparator();
			
			JBasicMenuItem alignTopMenuItem = new JBasicMenuItem(TGraphController.getAlignTopAction(graph));
			alignPopupMenu.add(alignTopMenuItem);
			
			JBasicMenuItem alignHorizontalCenterMenuItem = new JBasicMenuItem(TGraphController.getAlignHorizontalCenterAction(graph));
			alignPopupMenu.add(alignHorizontalCenterMenuItem);
			
			JBasicMenuItem alignBottomMenuItem = new JBasicMenuItem(TGraphController.getAlignBottomAction(graph));
			alignPopupMenu.add(alignBottomMenuItem);
			
			JBasicMenuButton alignButton = new JBasicMenuButton(TIconFactory.getContextIcon("align_vertical_center.png"), TLocale.getString("element_align"));
			alignButton.setPopupMenu(alignPopupMenu);
			nodeOutlook.add(alignButton, "0, 1");
			
			JBasicPopupMenu pilePopupMenu = new JBasicPopupMenu();
			
			JBasicMenuItem pileToLeftMenuItem = new JBasicMenuItem(TGraphController.getPileToLeftAction(graph));
			pilePopupMenu.add(pileToLeftMenuItem);
			
			JBasicMenuItem pileToRightMenuItem = new JBasicMenuItem(TGraphController.getPileToRightAction(graph));
			pilePopupMenu.add(pileToRightMenuItem);
			
			pilePopupMenu.addSeparator();
			
			JBasicMenuItem pileToTopMenuItem = new JBasicMenuItem(TGraphController.getPileToTopAction(graph));
			pilePopupMenu.add(pileToTopMenuItem);
			
			JBasicMenuItem pileToBottomMenuItem = new JBasicMenuItem(TGraphController.getPileToBottomAction(graph));
			pilePopupMenu.add(pileToBottomMenuItem);
			
			JBasicMenuButton pileButton = new JBasicMenuButton(TIconFactory.getContextIcon("pile_to_top.png"), TLocale.getString("element_pile"));
			pileButton.setPopupMenu(pilePopupMenu);
			nodeOutlook.add(pileButton, "1, 1");
			
			JBasicPopupMenu sameSizePopupMenu = new JBasicPopupMenu();
			
			JBasicMenuItem sameWidthMenuItem = new JBasicMenuItem(TGraphController.getSameWidthAction(graph));
			sameSizePopupMenu.add(sameWidthMenuItem);
			
			JBasicMenuItem sameHeightMenuItem = new JBasicMenuItem(TGraphController.getSameHeightAction(graph));
			sameSizePopupMenu.add(sameHeightMenuItem);
			
			sameSizePopupMenu.addSeparator();
			
			JBasicMenuItem evenHorizontalSpaceMenuItem = new JBasicMenuItem(TGraphController.getSameHorizontalSpaceAction(graph));
			sameSizePopupMenu.add(evenHorizontalSpaceMenuItem);
			
			JBasicMenuItem evenVerticalSpaceMenuItem = new JBasicMenuItem(TGraphController.getSameVerticalSpaceAction(graph));
			sameSizePopupMenu.add(evenVerticalSpaceMenuItem);
			
			JBasicMenuButton sameSizeButton = new JBasicMenuButton(TIconFactory.getContextIcon("same_horizontal_space.png"), TLocale.getString("element_size_and_distance_adjust"));
			sameSizeButton.setPopupMenu(sameSizePopupMenu);
			nodeOutlook.add(sameSizeButton, "0, 2");
			
			JBasicPopupMenu layerPopupMenu = new JBasicPopupMenu();
			
			JBasicMenuItem moveToUpMenuItem = new JBasicMenuItem(TGraphController.getMoveToUpAction(graph));
			layerPopupMenu.add(moveToUpMenuItem);
			
			JBasicMenuItem moveToDownMenuItem = new JBasicMenuItem(TGraphController.getMoveToDownAction(graph));
			layerPopupMenu.add(moveToDownMenuItem);
			
			layerPopupMenu.addSeparator();
			
			JBasicMenuItem moveToTopMenuItem = new JBasicMenuItem(TGraphController.getMoveToTopAction(graph));
			layerPopupMenu.add(moveToTopMenuItem);
			
			JBasicMenuItem moveToBottomMenuItem = new JBasicMenuItem(TGraphController.getMoveToBottomAction(graph));
			layerPopupMenu.add(moveToBottomMenuItem);
			
			JBasicMenuButton layerButton = new JBasicMenuButton(TIconFactory.getContextIcon("move_to_up.png"), TLocale.getString("element_layer_adjust"));
			layerButton.setPopupMenu(layerPopupMenu);
			nodeOutlook.add(layerButton, "1, 2");
			
			JBasicPopupMenu groupPopupMenu = new JBasicPopupMenu();
			
			ButtonGroup groupTypeButtonGroup = new ButtonGroup();
			TGroupType[] groupTypes = new TGroupType[] {TGroupType.RECTANGLE_GROUP_TYPE, TGroupType.ROUND_RECTANGLE_GROUP_TYPE, TGroupType.ROUND_GROUP_TYPE, TGroupType.OCTAGON_GROUP_TYPE, TGroupType.PARALLELOGRAM_GROUP_TYPE, TGroupType.ELLIPSE_GROUP_TYPE};
			for (int i = 0; i < groupTypes.length; i++)
			{
				TGroupType groupType = groupTypes[i];
				
				JBasicRadioButtonMenuItem groupTypeMenuItem = new JBasicRadioButtonMenuItem(TGraphController.getGroupTypeConfigAction(graph, groupType));
				groupPopupMenu.add(groupTypeMenuItem);
				
				if (groupType == TGroupType.PARALLELOGRAM_GROUP_TYPE)
				{
					groupTypeMenuItem.setSelected(true);
				}	
				
				groupTypeButtonGroup.add(groupTypeMenuItem);
			}
			
			groupPopupMenu.addSeparator();
			
			JBasicMenuItem expandAllGroupsMenuItem = new JBasicMenuItem(TGraphController.getGroupExpandAction(graph));
			groupPopupMenu.add(expandAllGroupsMenuItem);
			
			JBasicMenuItem collapseAllGroupsMenuItem = new JBasicMenuItem(TGraphController.getGroupCollapseAction(graph));
			groupPopupMenu.add(collapseAllGroupsMenuItem);
			
			JBasicMenuButton groupButton = new JBasicMenuButton(TIconFactory.getContextIcon("group.png"), TLocale.getString("group_setting"));
			groupButton.setPopupMenu(groupPopupMenu);
			nodeOutlook.add(groupButton, "0, 3");
			
			JBasicPopupMenu linkPopupMenu = new JBasicPopupMenu();
			
            JBasicMenuItem showAllLinksMenuItem = new JBasicMenuItem(TGraphController.getLinkShowAction(graph));
            linkPopupMenu.add(showAllLinksMenuItem);
            
            JBasicMenuItem hideAllLinksMenuItem = new JBasicMenuItem(TGraphController.getLinkHideAction(graph));
            linkPopupMenu.add(hideAllLinksMenuItem);
            
            JBasicMenuButton linkButton = new JBasicMenuButton(TIconFactory.getContextIcon("link.png"), TLocale.getString("link_setting"));
            linkButton.setPopupMenu(linkPopupMenu);
            nodeOutlook.add(linkButton, "1, 3");			
			
			ButtonManager.updateUI(nodeOutlook, new Dimension(25, 25), new ButtonGroup());
			
			add(nodeOutlook);
		}
		
		public JFlatOutlook getNodeOutlook()
		{
			return nodeOutlook;
		}
	}
		
	public class IOToolBar
		extends JPanel
	{
		private JFlatOutlook ioOutlook;
		
		public IOToolBar()
		{
			double[][] size = 
			{
				{30, 30},
				{TableLayout.FILL, TableLayout.FILL}
			};
			
			ioOutlook = new JFlatOutlook();
			ioOutlook.setLayout(new TableLayout(size));
			
			importButton = new JBasicButton(TGraphController.getImportAction(graph));
			importButton.setText("");
			ioOutlook.add(importButton, "0, 0");
			
			JBasicPopupMenu exportPopupMenu = new JBasicPopupMenu();
			
			JBasicMenuItem exportXMLMenuItem = new JBasicMenuItem(TGraphController.getExportXMLAction(graph));
			exportPopupMenu.add(exportXMLMenuItem);
			
			exportPopupMenu.addSeparator();
			
			JBasicMenuItem exportSVGMenuItem = new JBasicMenuItem(TGraphController.getExportSVGAction(graph));
			exportPopupMenu.add(exportSVGMenuItem);
			
			JBasicMenuItem exportImageMenuItem = new JBasicMenuItem(TGraphController.getExportImageAction(graph));
			exportPopupMenu.add(exportImageMenuItem);
			
			JBasicMenuButton exportButton = new JBasicMenuButton(TIconFactory.getContextIcon("export.png"), TLocale.getString("export"));
			exportButton.setPopupMenu(exportPopupMenu);
			ioOutlook.add(exportButton, "1, 0");
			
			JBasicButton printButton = new JBasicButton(TGraphController.getPrintAction(graph));
			printButton.setText("");
			ioOutlook.add(printButton, "0, 1");
			
			ButtonManager.updateUI(ioOutlook, new Dimension(25, 25));
			
			add(ioOutlook);
		}
		
		public JFlatOutlook getIOOutlook()
		{
			return ioOutlook;
		}
	}
	
	private JBasicButton importButton;
	
	public void setEnableImport(boolean enabled)
	{
		((JSecurityAction) importButton.getAction()).setPermitted(enabled);
	}
}