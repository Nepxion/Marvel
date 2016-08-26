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

import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;

import twaver.TDataBox;

import com.nepxion.cots.twaver.element.TElementManager;
import com.nepxion.cots.twaver.element.TGroup;
import com.nepxion.cots.twaver.element.TGroupType;
import com.nepxion.cots.twaver.element.TNode;
import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.cots.twaver.locale.TLocale;
import com.nepxion.swing.action.JSecurityAction;

public class TGraphController
{
	public static JSecurityAction getSelectAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_select"), TIconFactory.getContextIcon("select.png"), TLocale.getString("graph_select"))
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGraphManager.select(graph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPanAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_pan"), TIconFactory.getContextIcon("pan.png"), TLocale.getString("graph_pan"))
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGraphManager.pan(graph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getLazyMoveAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_lazy_move"), TIconFactory.getContextIcon("lazy_move.png"), TLocale.getString("graph_lazy_move"))
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGraphManager.layzMove(graph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getZoomInAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_zoom_in"), TIconFactory.getContextIcon("zoom_in.png"), TLocale.getString("graph_zoom_in") + " Ctrl +")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.zoomIn(graph);
			}
		};
		TGraphKeyboardRegister.registerZoomIn(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getZoomOutAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_zoom_out"), TIconFactory.getContextIcon("zoom_out.png"), TLocale.getString("graph_zoom_out") + " Ctrl -")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.zoomOut(graph);
			}
		};
		TGraphKeyboardRegister.registerZoomOut(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getZoomInRectangleAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_zoom_in_rectangle"), TIconFactory.getContextIcon("zoom_in_rectangle.png"), TLocale.getString("graph_zoom_in_rectangle"))
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGraphManager.zoomInRectangle(graph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getZoomResetAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_zoom_reset"), TIconFactory.getContextIcon("zoom_reset.png"), TLocale.getString("graph_zoom_reset") + " Ctrl-O")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.zoomReset(graph);
			}
		};
		TGraphKeyboardRegister.registerZoomReset(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getZoomToOverviewAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_zoom_to_overview"), TLocale.getString("graph_zoom_to_overview"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.zoomToOverview(graph);
			}
		};
		TGraphKeyboardRegister.registerZoomToOverview(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getZoomBackAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_zoom_back"), TLocale.getString("graph_zoom_back"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.zoomBack(graph);
			}
		};
		TGraphKeyboardRegister.registerZoomBack(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getMagnifierAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_magnifier"), TIconFactory.getContextIcon("magnifier.png"), TLocale.getString("graph_magnifier"))
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGraphManager.magnifier(graph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getScaleAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_scale"), TIconFactory.getContextIcon("scale.png"), TLocale.getString("graph_scale"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.scale(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getFullScreenAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_fullscreen"), TIconFactory.getContextIcon("fullscreen.png"), TLocale.getString("graph_fullscreen") + " F10")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.fullScreen(graph);
				if (e.getSource() instanceof AbstractButton)
				{
					AbstractButton button = (AbstractButton) e.getSource();
					button.getModel().setRollover(false);
				}
			}
		};
		TGraphKeyboardRegister.registerFullScreen(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getOverviewAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("graph_overview"), TIconFactory.getContextIcon("overview.png"), TLocale.getString("graph_overview"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.overview(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAddAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_new"), TIconFactory.getContextIcon("new.png"), TLocale.getString("element_new_description") + " Ctrl+N")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().addElement();
			}
		};
		TGraphKeyboardRegister.registerNew(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getDeleteAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_delete"), TIconFactory.getContextIcon("delete.png"), TLocale.getString("element_delete_description") + " Delete")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().deleteElement();
			}
		};
		TGraphKeyboardRegister.registerDelete(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getClearAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_clear"), TIconFactory.getContextIcon("clear.png"), TLocale.getString("element_clear_description"))
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().clear();
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getRefreshAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_refresh"), TIconFactory.getContextIcon("refresh.png"), TLocale.getString("element_refresh_description") + " F5")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().refresh();
			}
		};
		TGraphKeyboardRegister.registerRefresh(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getRenameAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_rename"), TIconFactory.getContextIcon("rename.png"), TLocale.getString("element_rename_description"))
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().renameElement();
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getSaveAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_save"), TIconFactory.getContextIcon("save.png"), TLocale.getString("element_save_description") + " Ctrl+S")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().save();
			}
		};
		TGraphKeyboardRegister.registerSave(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getPropertyAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_property"), TIconFactory.getContextIcon("config.png"), TLocale.getString("element_property_description"))
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().modifyElement();
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getCopyAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_copy"), TIconFactory.getContextIcon("copy.png"), TLocale.getString("element_copy_description") + " Ctrl+C")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.copy(graph);
			}
		};
		TGraphKeyboardRegister.registerCopy(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getPasteAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_paste"), TIconFactory.getContextIcon("paste.png"), TLocale.getString("element_paste_description") + " Ctrl+V")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.paste(graph);
			}
		};
		TGraphKeyboardRegister.registerPaste(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getSelectAllAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_select_all"), TIconFactory.getContextIcon("select_all.png"), TLocale.getString("element_select_all_description") + " Ctrl+A")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.selectAll(graph);
			}
		};
		TGraphKeyboardRegister.registerSelectAll(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getUndoAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_undo"), TIconFactory.getContextIcon("undo.png"), TLocale.getString("element_undo_description") + " Ctrl+Z")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.undo(graph);
			}
		};
		TGraphKeyboardRegister.registerUndo(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getRedoAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_redo"), TIconFactory.getContextIcon("redo.png"), TLocale.getString("element_redo_description") + " Ctrl+Y")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.redo(graph);
			}
		};
		TGraphKeyboardRegister.registerRedo(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getLabelConfigAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("label_setting"), TIconFactory.getContextIcon("label.png"), TLocale.getString("label_setting"))
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().labelConfig();
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getGroupTypeConfigAction(final TGraph graph, final TGroupType groupType)
	{
		JSecurityAction action = new JSecurityAction(groupType.toString(), groupType.toString())
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.setGroupType(graph, groupType);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getGroupExpandAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("group_expand"), TLocale.getString("group_expand"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.setGroupExpand(graph, true);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getGroupCollapseAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("group_collapse"), TLocale.getString("group_collapse"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.setGroupExpand(graph, false);
			}
		};
		
		return action;
	}
	
    public static JSecurityAction getLinkShowAction(final TGraph graph)
    {
        JSecurityAction action = new JSecurityAction(TLocale.getString("link_show"), TLocale.getString("link_show"))
        {
            public void execute(ActionEvent e)
            {
                TGraphManager.setLinkVisible(graph, true);
            }
        };
        
        return action;
    }
    
    public static JSecurityAction getLinkHideAction(final TGraph graph)
    {
        JSecurityAction action = new JSecurityAction(TLocale.getString("link_hide"), TLocale.getString("link_hide"))
        {
            public void execute(ActionEvent e)
            {
                TGraphManager.setLinkVisible(graph, false);
            }
        };
        
        return action;
    }
	
	public static JSecurityAction getLockAllAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_lock_all"), TLocale.getString("element_lock_all"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.setMovable(graph, false);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getUnLockAllAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_unlock_all"), TLocale.getString("element_unlock_all"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.setMovable(graph, true);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getLockSelectionAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_lock_selection"), TLocale.getString("element_lock_selection"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.lockSelection(graph, false);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getUnLockSelectionAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_unlock_selection"), TLocale.getString("element_unlock_selection"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.lockSelection(graph, true);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getHideChildrenAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_show_and_hide_children"), TIconFactory.getContextIcon("hide.png"), TLocale.getString("element_show_and_hide_children"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.hideChildren(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getLayoutAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("layout"), TIconFactory.getContextIcon("layout.png"), TLocale.getString("layout"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.layout(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignLeftAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_align_left"), TIconFactory.getContextIcon("align_left.png"), TLocale.getString("element_align_left"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignLeft(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignVerticalCenterAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_align_vertical_center"), TIconFactory.getContextIcon("align_vertical_center.png"), TLocale.getString("element_align_vertical_center"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignVerticalCenter(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignRightAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_align_right"), TIconFactory.getContextIcon("align_right.png"), TLocale.getString("element_align_right"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignRight(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignTopAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_align_top"), TIconFactory.getContextIcon("align_top.png"), TLocale.getString("element_align_top"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignTop(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignHorizontalCenterAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_align_horizontal_center"), TIconFactory.getContextIcon("align_horizontal_center.png"), TLocale.getString("element_align_horizontal_center"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignHorizontalCenter(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignBottomAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_align_bottom"), TIconFactory.getContextIcon("align_bottom.png"), TLocale.getString("element_align_bottom"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignBottom(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPileToLeftAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_pile_to_left"), TIconFactory.getContextIcon("pile_to_left.png"), TLocale.getString("element_pile_to_left"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.pileToLeft(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPileToRightAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_pile_to_right"), TIconFactory.getContextIcon("pile_to_right.png"), TLocale.getString("element_pile_to_right"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.pileToRight(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPileToTopAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_pile_to_top"), TIconFactory.getContextIcon("pile_to_top.png"), TLocale.getString("element_pile_to_top"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.pileToTop(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPileToBottomAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_pile_to_bottom"), TIconFactory.getContextIcon("pile_to_bottom.png"), TLocale.getString("element_pile_to_bottom"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.pileToBottom(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getSameWidthAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_same_width"), TIconFactory.getContextIcon("same_width.png"), TLocale.getString("element_same_width"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.sameWidth(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getSameHeightAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_same_height"), TIconFactory.getContextIcon("same_height.png"), TLocale.getString("element_same_height"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.sameHeight(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getSameHorizontalSpaceAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_same_horizontal_space"), TIconFactory.getContextIcon("same_horizontal_space.png"), TLocale.getString("element_same_horizontal_space"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.sameHorizontalSpace(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getSameVerticalSpaceAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_same_vertical_space"), TIconFactory.getContextIcon("same_vertical_space.png"), TLocale.getString("element_same_vertical_space"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.sameVerticalSpace(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getMoveToUpAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_move_to_up"), TIconFactory.getContextIcon("move_to_up.png"), TLocale.getString("element_move_to_up"))
		{
			public void execute(ActionEvent e)
			{
				
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getMoveToDownAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_move_to_down"), TIconFactory.getContextIcon("move_to_down.png"), TLocale.getString("element_move_to_down"))
		{
			public void execute(ActionEvent e)
			{
				
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getMoveToTopAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_move_to_top"), TIconFactory.getContextIcon("move_to_top.png"), TLocale.getString("element_move_to_top"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.moveToTop(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getMoveToBottomAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("element_move_to_bottom"), TIconFactory.getContextIcon("move_to_bottom.png"), TLocale.getString("element_move_to_bottom"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.moveToBottom(graph);
			}
		};
		
		return action;
	}
	
    public static JSecurityAction getPinSelectedNodeAction(final TDataBox dataBox) 
    {
        JSecurityAction action = new JSecurityAction(TLocale.getString("element_lock_and_unlock_node"), TIconFactory.getContextIcon("pin.png"), TLocale.getString("element_lock_and_unlock_node"))
        {
            public void execute(ActionEvent e) 
            {
                TNode node = TElementManager.getSelectedNode(dataBox);
                if (node != null) 
                {
                    node.setMovable(!node.isMovable());
                }
            }
        };

        return action;
    }
    
    public static JSecurityAction getPinSelectedGroupAction(final TDataBox dataBox) 
    {
        JSecurityAction action = new JSecurityAction(TLocale.getString("element_lock_and_unlock_group"), TIconFactory.getContextIcon("pin.png"), TLocale.getString("element_lock_and_unlock_group")) 
        {
            public void execute(ActionEvent e) 
            {
                TGroup group = TElementManager.getSelectedGroup(dataBox);
                if (group != null) 
                {
                    group.setMovable(!group.isMovable());
                }
            }
        };

        return action;
    }
	
	public static JSecurityAction getImportAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("import"), TIconFactory.getContextIcon("import.png"), TLocale.getString("import_data_description") + " Ctrl+M")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.importXML(graph);
			}
		};
		TGraphKeyboardRegister.registerImport(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getExportXMLAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("export_data"), TIconFactory.getContextIcon("xml.png"), TLocale.getString("export_data_description"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.exportXML(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getExportExcelAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("export_table"), TIconFactory.getContextIcon("excel.png"), TLocale.getString("export_table_description"))
		{
			public void execute(ActionEvent e)
			{
				
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getExportSVGAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("export_vector"), TIconFactory.getContextIcon("svg.png"), TLocale.getString("export_vector_description"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.exportSVG(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getExportImageAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("export_image"), TIconFactory.getContextIcon("image.png"), TLocale.getString("export_image_description"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.exportImage(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getStatAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("stat"), TIconFactory.getContextIcon("stat.png"), TLocale.getString("stat"))
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().stat();
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPrintAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("print"), TIconFactory.getContextIcon("print.png"), TLocale.getString("print"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.print(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getShowControlBarAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("operation_pane_show"), TIconFactory.getSwingIcon("toggle_size.png"), TLocale.getString("operation_pane_show"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.toggleControlBar(graph, true);
			}
		};
		TGraphKeyboardRegister.registerShowControlBar(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getHideControlBarAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("operation_pane_hide"), TIconFactory.getSwingIcon("close_item.png"), TLocale.getString("operation_pane_hide"))
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.toggleControlBar(graph, false);
			}
		};
		TGraphKeyboardRegister.registerHideControlBar(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getToggleControlBarAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction(TLocale.getString("operation_pane"), TIconFactory.getContextIcon("pane.png"), TLocale.getString("operation_pane_description"))
		{
			public void execute(ActionEvent e)
			{
				if (graph.getControlBarInternalFrame().isVisible())
				{
					TGraphManager.toggleControlBar(graph, false);
				}
				else
				{
					TGraphManager.toggleControlBar(graph, true);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getToggleControlBarAction(final TInternalFrame controlBarInternalFrame, final int selectedIndex)
	{
		final TGraphControlBar controlBar = (TGraphControlBar) controlBarInternalFrame.getContent();
		String title = controlBar.getTitleAt(selectedIndex);
		
		JSecurityAction action = new JSecurityAction(title, TLocale.getString("operation_pane_toggle_to") + " " + title)
		{
			public void execute(ActionEvent e)
			{
				if (!controlBarInternalFrame.isVisible())
				{
					controlBarInternalFrame.tween(true);
				}
				
				controlBar.setSelectedIndex(selectedIndex);
			}
		};
		
		return action;
	}
}