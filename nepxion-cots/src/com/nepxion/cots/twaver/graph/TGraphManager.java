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

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JInternalFrame;

import twaver.DataBoxOutputSetting;
import twaver.DataBoxSelectionEvent;
import twaver.DataBoxSelectionModel;
import twaver.DoubleClickableFilter;
import twaver.EditableFilter;
import twaver.Element;
import twaver.Generator;
import twaver.Link;
import twaver.MovableFilter;
import twaver.ResizableFilter;
import twaver.SubNetworkPersistentFilter;
import twaver.TDataBox;
import twaver.TSubNetwork;
import twaver.TUIManager;
import twaver.TWaverConst;
import twaver.VisibleFilter;
import twaver.network.InteractionEvent;
import twaver.network.InteractionModeFactory;

import com.nepxion.cots.twaver.element.TDataBoxPropertyChangeAdapter;
import com.nepxion.cots.twaver.element.TDataBoxSelectionAdapter;
import com.nepxion.cots.twaver.element.TDataBoxUndoRedoAdapter;
import com.nepxion.cots.twaver.element.TElement;
import com.nepxion.cots.twaver.element.TGroup;
import com.nepxion.cots.twaver.element.TGroupType;
import com.nepxion.cots.twaver.element.TLink;
import com.nepxion.cots.twaver.element.TNode;
import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.cots.twaver.locale.TLocale;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.selector.checkbox.JCheckBoxSelector;
import com.nepxion.swing.selector.file.JFileFilter;
import com.nepxion.swing.selector.file.JFileSelector;
import com.nepxion.swing.thread.dialog.JThreadDialog;
import com.nepxion.util.data.CollectionUtil;

public class TGraphManager
{
	// 选择模式
	public static void select(TGraph graph)
	{
		graph.setInteractionMode(InteractionModeFactory.getDefaultMode(graph));
	}
	
	// 延迟拖动模式
	public static void layzMove(TGraph graph)
	{
		graph.setInteractionMode(InteractionModeFactory.getDefaultLazySelectionMode(graph));
	}
	
	// 拖动模式
	public static void pan(TGraph graph)
	{
		graph.setInteractionMode(InteractionModeFactory.getPanMode(graph));
		graph.getCanvas().setCursor(TGraph.PAN_CURSOR);
	}
	
	// 放大
	public static void zoomIn(TGraph graph)
	{
		graph.getZoomer().zoomIn();
	}
	
	// 缩小
	public static void zoomOut(TGraph graph)
	{
		graph.getZoomer().zoomOut();
	}
	
	// 拉框放大模式
	public static void zoomInRectangle(TGraph graph)
	{
		graph.setInteractionMode(InteractionModeFactory.getZoomToRectMode(graph));
		graph.getCanvas().setCursor(TGraph.ZOOM_IN_RECTANGLE_CURSOR);
	}
	
	// 实际大小
	public static void zoomReset(TGraph graph)
	{
		graph.getZoomer().zoomReset();
	}
	
	// 缩放后退
	public static void zoomBack(TGraph graph)
	{
		graph.zoomBack();
	}
	
	// 适应屏幕
	public static void zoomToOverview(TGraph graph)
	{
		graph.getZoomer().zoomToOverview(10, 10);
	}
	
	// 全屏切换
	public static void fullScreen(TGraph graph)
	{
		graph.toggleFullScreen();
	}
	
	// 放大镜模式
	public static void magnifier(TGraph graph)
	{
		graph.setInteractionMode(InteractionModeFactory.getMagnifierMode(graph));
	}
	
	// 图元放大镜的形状和大小
	public static void setMagnifierShape(TGraph graph, Shape shape)
	{
		graph.getMagnifier().setShape(shape);
	}
	
	// 图元删除
	public static void delete(TGraph graph)
	{
		DataBoxSelectionModel dataBoxSelectionModel = graph.getDataBox().getSelectionModel();
		if (dataBoxSelectionModel.size() > 0)
		{
			int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(graph), TLocale.getString("element_delete_confirm"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
			if (selectedValue == JBasicOptionPane.OK_OPTION)
			{
				List allSelectedElement = dataBoxSelectionModel.getAllSelectedElement();
				for (Iterator iterator = allSelectedElement.iterator(); iterator.hasNext();)
				{
					TElement element = (TElement) iterator.next();
					if (!element.isDeletePermitted())
					{
						JBasicOptionPane.showMessageDialog(HandleManager.getFrame(graph), TLocale.getString("element") + " " + element.toString() + " " + TLocale.getString("element_delete_denied"), SwingLocale.getString("error"), JBasicOptionPane.WARNING_MESSAGE);
						
						return;
					}
				}
				
				graph.getDataBox().removeSelectedElements();
				graph.adjustCanvasSize();
				
				InteractionEvent event = new InteractionEvent(allSelectedElement, InteractionEvent.ELEMENT_DELETED);
				graph.fireInteractionPerformed(event);
			}
		}
	}
	
	public static void clear(TGraph graph)
	{
		if (graph.getDataBox().getAllElements().size() != 0)
		{
			int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(graph), TLocale.getString("element_clear_confirm"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
			if (selectedValue == JBasicOptionPane.OK_OPTION)
			{
				graph.getDataBox().clear();
			}
		}
	}
	
	// 图元拷贝
	public static void copy(TGraph graph)
	{
		graph.getDataBox().copySelection();
	}
	
	// 图元粘贴
	public static void paste(TGraph graph)
	{
		graph.pasteElements();
	}
	
	// 图元重命名
	public static void rename(TGraph graph)
	{
		if (graph.getDataBox().getSelectionModel().size() != 1)
		{
			return;
		}
		
		Element element = graph.getDataBox().getLastSelectedElement();
		graph.startEditingAtElement(element);
	}
	
	// 图元全选
	public static void selectAll(TGraph graph)
	{
		graph.getDataBox().selectAll();
	}
	
	// 撤消
	public static void undo(TGraph graph)
	{
		graph.getDataBox().getUndoRedoManager().undo();
	}
	
	// 重做
	public static void redo(TGraph graph)
	{
		graph.getDataBox().getUndoRedoManager().redo();
	}
	
	// 左边对齐
	public static void alignLeft(TGraph graph)
	{
		graph.getDataBox().alignLeftSelection();
	}
	
	// 纵向中央对齐
	public static void alignVerticalCenter(TGraph graph)
	{
		graph.getDataBox().alignCenterSelection();
	}
	
	// 右边对齐
	public static void alignRight(TGraph graph)
	{
		graph.getDataBox().alignRightSelection();
	}
	
	// 顶部对齐
	public static void alignTop(TGraph graph)
	{
		graph.getDataBox().alignTopSelection();
	}
	
	// 横向中央对齐
	public static void alignHorizontalCenter(TGraph graph)
	{
		graph.getDataBox().alignMiddleSelection();
	}
	
	// 底部对齐
	public static void alignBottom(TGraph graph)
	{
		graph.getDataBox().alignBottomSelection();
	}
	
	// 左边堆列
	public static void pileToLeft(TGraph graph)
	{
		graph.getDataBox().leftPileSelection();
	}
	
	// 右边堆列
	public static void pileToRight(TGraph graph)
	{
		graph.getDataBox().rightPileSelection();
	}
	
	// 顶部堆列
	public static void pileToTop(TGraph graph)
	{
		graph.getDataBox().topPileSelection();
	}
	
	// 底部堆列
	public static void pileToBottom(TGraph graph)
	{
		graph.getDataBox().bottomPileSelection();
	}
	
	// 等宽
	public static void sameWidth(TGraph graph)
	{
		graph.getDataBox().sameWidthSelection();
	}
	
	// 等高
	public static void sameHeight(TGraph graph)
	{
		graph.getDataBox().sameHeightSelection();
	}
	
	// 横向等距
	public static void sameHorizontalSpace(TGraph graph)
	{
		graph.getDataBox().evenHSpaceSelection();
	}
	
	// 纵向等距
	public static void sameVerticalSpace(TGraph graph)
	{
		graph.getDataBox().evenVSpaceSelection();
	}
	
	// 移至最顶层
	public static void moveToTop(TGraph graph)
	{
		Element element;
		for (Iterator iterator = graph.getDataBox().selection(); iterator.hasNext(); graph.getDataBox().sendToTop(element))
		{
			element = (Element) iterator.next();
		}
	}
	
	// 移至最底层
	public static void moveToBottom(TGraph graph)
	{
		Element element;
		for (Iterator iterator = graph.getDataBox().selection(); iterator.hasNext(); graph.getDataBox().sendToBottom(element))
		{
			element = (Element) iterator.next();
		}
	}
	
	// 切换Node是否可移动
	public static void lockSelection(TGraph graph)
	{
		for (Iterator iterator = graph.getSelectionModel().getAllSelectedElement().iterator(); iterator.hasNext();)
		{
			Object object = iterator.next();
			
			lockSelection(object);
		}
	}
	
	public static void lockSelection(Object object)
	{
		if (object instanceof TNode)
		{
			TNode node = (TNode) object;
			node.setMovable(!node.isMovable());
		}
		else if (object instanceof TGroup)
		{
			TGroup group = (TGroup) object;
			group.setMovable(!group.isMovable());
			
			for (Iterator iterator = group.getChildren().iterator(); iterator.hasNext();)
			{
				Object childObject = iterator.next();
				
				lockSelection(childObject);
			}
		}
	}
	
	// 切换Node是否可移动
	public static void lockSelection(TGraph graph, boolean isMovable)
	{
		for (Iterator iterator = graph.getSelectionModel().getAllSelectedElement().iterator(); iterator.hasNext();)
		{
			Object object = iterator.next();
			
			lockSelection(object, isMovable);
		}
	}
	
	public static void lockSelection(Object object, boolean isMovable)
	{
		if (object instanceof TNode)
		{
			TNode node = (TNode) object;
			node.setMovable(isMovable);
		}
		else if (object instanceof TGroup)
		{
			TGroup group = (TGroup) object;
			group.setMovable(isMovable);
			
			for (Iterator iterator = group.getChildren().iterator(); iterator.hasNext();)
			{
				Object childObject = iterator.next();
				
				lockSelection(childObject, isMovable);
			}
		}
	}
	
	// 切换Node是否隐藏下级Node
	public static void hideChildren(TGraph graph)
	{
		for (Iterator iterator = graph.getSelectionModel().getAllSelectedElement().iterator(); iterator.hasNext();)
		{
			Object object = iterator.next();
			if (object instanceof TNode)
			{
				TNode node = (TNode) object;
				node.setChildrenHidden(!node.isChildrenHidden());
			}
		}
		
		graph.getCanvas().repaint();
	}
	
	// 组类型设置
	public static void setGroupType(TGraph graph, TGroupType groupType)
	{
		for (Iterator iterator = graph.getDataBox().iteratorReverse(); iterator.hasNext();)
		{
			Element element = (Element) iterator.next();
			
			if (element instanceof TGroup)
			{
				TGroup group = (TGroup) element;
				group.setGroupType(groupType.getType());
			}
		}
	}
	
	// 组样式设置
	public static void setGroupExpand(TGraph graph, boolean isExpand)
	{
		for (Iterator iterator = graph.getDataBox().iteratorReverse(); iterator.hasNext();)
		{
			Element element = (Element) iterator.next();
			
			if (element instanceof TGroup)
			{
				TGroup group = (TGroup) element;
				group.setExpand(isExpand);
			}
		}
	}
	
	// 连接显示设置
    public static void setLinkVisible(TGraph graph, boolean isVisible)
    {
        for (Iterator iterator = graph.getDataBox().iteratorReverse(); iterator.hasNext();)
        {
            Element element = (Element) iterator.next();
            
            if (element instanceof TLink)
            {
                TLink link = (TLink) element;
                link.setVisible(isVisible);
            }
        }
    }
	
	// DataBox改变的事件监听
	public static void addDataBoxChangeListener(TGraph graph)
	{
		graph.addPropertyChangeListener(TWaverConst.DATABOX, new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent e)
			{
				TDataBox oldDataBox = (TDataBox) e.getOldValue();
				TDataBox newDataBox = (TDataBox) e.getNewValue();
				
				if (oldDataBox != null && newDataBox != null)
				{
					fireDataBoxChangeEvent(oldDataBox, newDataBox);
				}
			}
		}
		);
	}
	
	// 执行DataBox改变事件
	public static void fireDataBoxChangeEvent(TDataBox oldDataBox, TDataBox newDataBox)
	{
		List selectionListeners = oldDataBox.getSelectionModel().getDataBoxSelectionListeners();
		for (Iterator iterator = selectionListeners.iterator(); iterator.hasNext();)
		{
			Object selectionAdapterObject = iterator.next();
			
			if (selectionAdapterObject instanceof TDataBoxSelectionAdapter)
			{
				TDataBoxSelectionAdapter selectionAdapter = (TDataBoxSelectionAdapter) selectionAdapterObject;
				oldDataBox.getSelectionModel().removeDataBoxSelectionListener(selectionAdapter);
				newDataBox.getSelectionModel().addDataBoxSelectionListener(selectionAdapter);
			}
		}
		
		List undoRedoListeners = oldDataBox.getUndoRedoManager().getUndoRedoListeners();
		for (Iterator iterator = undoRedoListeners.iterator(); iterator.hasNext();)
		{
			Object undoRedoAdapterObject = iterator.next();
			
			if (undoRedoAdapterObject instanceof TDataBoxUndoRedoAdapter)
			{
				TDataBoxUndoRedoAdapter undoRedoAdapter = (TDataBoxUndoRedoAdapter) undoRedoAdapterObject;
				oldDataBox.getUndoRedoManager().removeUndoRedoListener(undoRedoAdapter);
				newDataBox.getUndoRedoManager().addUndoRedoListener(undoRedoAdapter);
				undoRedoAdapter.enableButton();
			}
		}
		
		newDataBox.getUndoRedoManager().setLimit(200);
	}
	
	// 执行Property改变事件
	public static void fireElementPropertyChangeEvent(TDataBox oldDataBox, TDataBox newDataBox)
	{
		List elementPropertyChangeListeners = oldDataBox.getElementPropertyChangeListeners();
		for (Iterator iterator = elementPropertyChangeListeners.iterator(); iterator.hasNext();)
		{
			Object elementPropertyAdapterObject = iterator.next();
			
			if (elementPropertyAdapterObject instanceof TDataBoxPropertyChangeAdapter)
			{
				TDataBoxPropertyChangeAdapter propertyChangeAdapter = (TDataBoxPropertyChangeAdapter) elementPropertyAdapterObject;
				oldDataBox.removeElementPropertyChangeListener(propertyChangeAdapter);
				newDataBox.addElementPropertyChangeListener(propertyChangeAdapter);
			}
		}
	}
	
	// 内部窗体位置调整事件监听
	public static void addCanvasAdjustListener(final TGraph graph)
	{
		graph.getCanvas().addComponentListener(new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e)
			{
				for (int i = 0; i < graph.getLayeredPane().getComponentCount(); i++)
				{
					Component component = graph.getLayeredPane().getComponent(i);
					
					if (component instanceof JInternalFrame)
					{
						graph.adjustComponentPosition((JInternalFrame) component);
					}
				}
			}
		}
		);
	}
	
	// 图元的选中色
	public static void setElementSelectColorGenerator(TGraph graph, final Color nodeColor, final Color linkColor)
	{
		graph.setElementSelectColorGenerator(new Generator()
		{
			public Object generate(Object element)
			{
				if (element instanceof TNode || element instanceof TGroup)
				{
					return nodeColor;
				}
				else if (element instanceof TLink)
				{
					return linkColor;
				}
				return null;
			}
		}
		);
	}
	
	// 图元选中事件监听，包括Node图标，Node的高亮图标，Link颜色，Link的高亮颜色
	public static void addElementSelectionListener(TGraph graph, final String nodeImage, final String nodeSelectionImage, final Color linkColor, final Color linkSelectionColor)
	{
		new TDataBoxSelectionAdapter(graph.getDataBox())
		{
			public void selectionChanged(DataBoxSelectionEvent e)
			{
				Iterator iterator = e.getElements().iterator();
				while (iterator.hasNext())
				{
					Element element = (Element) iterator.next();
					
					if (element instanceof TNode || element instanceof TGroup)
					{
						if (element.isSelected())
						{
							element.setImage(nodeSelectionImage);
							element.setIcon(nodeSelectionImage);
						}
						else
						{
							element.setImage(nodeImage);
							element.setIcon(nodeImage);
						}
					}
					else if (element instanceof TLink)
					{
						if (element.isSelected())
						{
							element.putClientProperty(TWaverConst.PROPERTYNAME_LINK_COLOR, linkSelectionColor);
						}
						else
						{
							element.putClientProperty(TWaverConst.PROPERTYNAME_LINK_COLOR, linkColor);
						}
					}
				}
			}
		};
	}
	
	// Node选中事件监听，包括Node图标，Node的高亮图标
	public static void addNodeSelectionListener(TGraph graph, final String nodeImage, final String nodeSelectionImage)
	{
		new TDataBoxSelectionAdapter(graph.getDataBox())
		{
			public void selectionChanged(DataBoxSelectionEvent e)
			{
				Iterator iterator = e.getElements().iterator();
				
				while (iterator.hasNext())
				{
					Element element = (Element) iterator.next();
					
					if (element instanceof TNode || element instanceof TGroup)
					{
						if (element.isSelected())
						{
							element.setImage(nodeSelectionImage);
							element.setIcon(nodeSelectionImage);
						}
						else
						{
							element.setImage(nodeImage);
							element.setIcon(nodeImage);
						}
					}
				}
			}
		};
	}
	
	// Link选中事件监听，Link颜色，Link的高亮颜色
	public static void addLinkSelectionListener(TGraph graph, final Color linkSelectionColor)
	{
		new TDataBoxSelectionAdapter(graph.getDataBox())
		{
			public void selectionChanged(DataBoxSelectionEvent e)
			{
				Iterator iterator = e.getElements().iterator();
				
				while (iterator.hasNext())
				{
					Element element = (Element) iterator.next();
					
					if (element instanceof TLink)
					{
						if (element.isSelected())
						{
							element.putClientProperty(TWaverConst.PROPERTYNAME_LINK_COLOR, linkSelectionColor);
						}
						else
						{
							TLink link = (TLink) element;
							if (link.isHighLightable())
							{
								element.putClientProperty(TWaverConst.PROPERTYNAME_LINK_COLOR, link.getHighLightColor());
							}
							else
							{
								element.putClientProperty(TWaverConst.PROPERTYNAME_LINK_COLOR, TUIManager.get(TWaverConst.PROPERTYNAME_LINK_COLOR));
							}
						}
					}
				}
			}
		};
	}
	
	// 图元双击事件过滤
	public static void setDoubleClickableFilter(TGraph graph, final boolean nodeFiltable, final boolean linkFiltable)
	{
		graph.setDoubleClickableFilter(new DoubleClickableFilter()
		{
			public boolean isDoubleClickable(Element element)
			{
				if (element instanceof TNode || element instanceof TGroup)
				{
					return nodeFiltable;
				}
				else if (element instanceof TLink)
				{
					return linkFiltable;
				}
				
				return true;
			}
		}
		);
	}
	
	// 图元锁定切换
	public static void setMovable(TGraph graph, boolean isMovable)
	{
		if (!isMovable)
		{
			addMovableFilter(graph, isMovable);
		}
		else
		{
			graph.clearMovableFilters();
		}
	}
	
	// 图元锁定，是否可移动
	public static void addMovableFilter(TGraph graph, final boolean isMovable)
	{
		graph.addMovableFilter(new MovableFilter()
		{
			public boolean isMovable(Element element)
			{
				return isMovable;
			}
		}
		);
	}
	
	// 图元是否可编辑
	public static void setElementLabelEditable(TGraph graph, final boolean isEditable)
	{
		graph.setElementLabelEditableFilter(new EditableFilter()
		{
			public boolean isEditable(Element element)
			{
				return isEditable;
			}
		}
		);
	}
	
	// 图元是否可拉伸
	public static void setResizableFilter(TGraph graph, final boolean isResizable)
	{
		graph.setResizableFilter(new ResizableFilter()
		{
			public boolean isResizable(Element element)
			{
				return isResizable;
			}
		}
		);
	}
	
	// 图元是否隐藏下级图元
	public static void addVisibleFilter(final TGraph graph)
	{
		graph.addVisibleFilter(new VisibleFilter()
		{
			public boolean isVisible(Element element)
			{
				Element parent = element.getParent();
				
				if (parent instanceof TNode)
				{
					if (((TNode) parent).isChildrenHidden())
					{
						return false;
					}
				}
				if (parent != null && !(parent instanceof Link))
				{
					return graph.isVisible(parent);
				}
				else
				{
					return true;
				}
			}
		}
		);
	}
	
	// 面板显示
	public static void toggleControlBar(TGraph graph, boolean isVisible)
	{
		TInternalFrame controlBarInternalFrame = graph.getControlBarInternalFrame();
		if (controlBarInternalFrame == null)
		{
			TGraphControlBar controlBar = new TGraphControlBar(graph);
			controlBar.setPreferredSize(new Dimension(90, 310));
			
			controlBarInternalFrame = new TInternalFrame(graph, TLocale.getString("operation_pane"), TIconFactory.getContextIcon("pane.png"), controlBar);
			controlBarInternalFrame.setLocation(0, 0);
			controlBarInternalFrame.setHorizontalTweening(false);
			controlBarInternalFrame.setVerticalTweening(true);
			controlBarInternalFrame.setTweeningDimension(controlBarInternalFrame.getSize());
			
			graph.getLayeredPane().add(controlBarInternalFrame);
			graph.setControlBarInternalFrame(controlBarInternalFrame);
		}
		
		if (isVisible)
		{
			controlBarInternalFrame.tween(true);
		}
		else
		{
			controlBarInternalFrame.tween(false);
		}
	}
	
	// 坐标和比例显示
	public static void scale(TGraph graph)
	{
		TInternalFrame scaleInternalFrame = graph.getScaleInternalFrame();
		if (scaleInternalFrame == null)
		{
			TGraphScaleBar scaleBar = new TGraphScaleBar(graph);
			scaleBar.setPreferredSize(new Dimension(230, 20));
			
			scaleInternalFrame = new TInternalFrame(graph, TLocale.getString("graph_scale"), TIconFactory.getContextIcon("scale.png"), scaleBar);
			scaleInternalFrame.setResizable(false);
			scaleInternalFrame.setLocation(0, graph.getViewport().getHeight() - scaleInternalFrame.getHeight() + 2);
			scaleInternalFrame.setHorizontalTweening(true);
			scaleInternalFrame.setVerticalTweening(false);
			scaleInternalFrame.setTweeningDimension(scaleInternalFrame.getSize());
			
			graph.getLayeredPane().add(scaleInternalFrame);
			graph.setScaleInternalFrame(scaleInternalFrame);
		}
		
		if (!scaleInternalFrame.isVisible())
		{
			scaleInternalFrame.tween(true);
		}
		else
		{
			scaleInternalFrame.tween(false);
		}
	}
	
	// 鹰眼展示
	public static void overview(TGraph graph)
	{
		TOverview overview = graph.getOverview();
		if (overview == null)
		{
			overview = new TOverview(graph, TLocale.getString("graph_overview"), new Dimension(150, 150), TIconFactory.getContextIcon("overview.png"));
			overview.setLocation(graph.getViewport().getWidth() - overview.getWidth() + 2, graph.getViewport().getHeight() - overview.getHeight() + 2);
			overview.setHorizontalTweening(true);
			overview.setVerticalTweening(true);
			overview.setTweeningDimension(overview.getSize());
			
			graph.getLayeredPane().add(overview);
			graph.setOverview(overview);
		}
		
		if (!overview.isVisible())
		{
			overview.tween(true);
		}
		else
		{
			overview.tween(false);
		}
		
		if (overview.isVisible())
		{
			graph.adjustComponentPosition(overview);
		}	
	}
	
	// 布局器显示
	public static void layout(TGraph graph)
	{
		TInternalFrame layoutInternalFrame = graph.getLayoutInternalFrame();
		if (layoutInternalFrame == null)
		{
			TLayouterBar layouterBar = new TLayouterBar(graph);
			layouterBar.setPreferredSize(new Dimension(225, 295));

			layoutInternalFrame = new TInternalFrame(graph, TLocale.getString("layout"), TIconFactory.getContextIcon("layout.png"), layouterBar);
			layoutInternalFrame.setResizable(false);
			layoutInternalFrame.setLocation(graph.getViewport().getWidth() - layoutInternalFrame.getPreferredSize().width + 2, 0);
			layoutInternalFrame.setHorizontalTweening(false);
			layoutInternalFrame.setVerticalTweening(true);
			layoutInternalFrame.setTweeningDimension(layoutInternalFrame.getSize());
			
			graph.getLayeredPane().add(layoutInternalFrame);
			graph.setLayoutInternalFrame(layoutInternalFrame);
		}
		if (!layoutInternalFrame.isVisible())
		{
			layoutInternalFrame.tween(true);
		}
		else
		{
			layoutInternalFrame.tween(false);
		}
	}
	
	// 导入XML文件到视图
	public static void importXML(final TGraph graph)
	{
		JFileSelector fileSelector = graph.getImportDataFileSelector();
		if (fileSelector == null)
		{
			List xmlFilterWords = CollectionUtil.parseList(new String[] {"xml"});
			String xmlFilterDescription = "XML File(*.xml)";
			JFileFilter xmlFileFilter = new JFileFilter(xmlFilterWords, xmlFilterDescription);
			
			fileSelector = new JFileSelector(HandleManager.getFrame(graph), TLocale.getString("import_data_description"));
			fileSelector.addChoosableFileFilter(xmlFileFilter);
			fileSelector.setFileFilter(xmlFileFilter);
			
			graph.setImportDataFileSelector(fileSelector);
		}

		final File file = fileSelector.openFile();
		if (file != null)
		{
			if (graph.getDataBox().size() != 0)
			{
				int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(graph), TLocale.getString("import_confirm"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_CANCEL_OPTION);
				if (selectedValue == JBasicOptionPane.OK_OPTION)
				{
					graph.getDataBox().clear();
				}
				else if (selectedValue == JBasicOptionPane.CANCEL_OPTION)
				{
					return;
				}
			}
			
			JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(graph), TLocale.getString("import_data_description"), SwingLocale.getString("export_and_wait"))
			{
				protected void loadForeground(Object data)
					throws Exception
				{
					try
					{
						TSubNetwork currentSubNetwork = graph.getCurrentSubNetwork();
						graph.getDataBox().parse(file.toURI().toString(), currentSubNetwork);
					}
					catch (IOException e)
					{
						e.printStackTrace();
						
						throw e;
					}
					
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame(graph), TLocale.getString("import_data_description"), SwingLocale.getString("information"), JBasicOptionPane.INFORMATION_MESSAGE);
				}
				
				protected Object loadBackground()
					throws Exception
				{					
					return null;
				}
			};
			dialog.execute();
		}
	}
	
	// 导出视图成XML文件
	public static void exportXML(final TGraph graph)
	{
		// 设置导出参数
		TExportDataConfig exportDataConfig = graph.getExportDataConfig();
		if (exportDataConfig == null)
		{
			exportDataConfig = new TExportDataConfig(graph);
			graph.setExportDataConfig(exportDataConfig);
		}
		
		JCheckBoxSelector selector = exportDataConfig.getSelector();
		selector.setVisible(true);
		selector.dispose();
		
		if (selector.getSelectedElementNodes() == null || !selector.isConfirmed())
		{
			return;
		}
				
		// 设置导出路径
		JFileSelector fileSelector = graph.getExportDataFileSelector();
		if (fileSelector == null)
		{
			List xmlFilterWords = CollectionUtil.parseList(new String[] {"xml"});
			String xmlFilterDescription = "XML File(*.xml)";
			JFileFilter xmlFileFilter = new JFileFilter(xmlFilterWords, xmlFilterDescription);
			
			fileSelector = new JFileSelector(HandleManager.getFrame(graph), TLocale.getString("export_data_description"));
			fileSelector.addChoosableFileFilter(xmlFileFilter);
			fileSelector.setFileFilter(xmlFileFilter);
			
			graph.setExportDataFileSelector(fileSelector);
		}

		final boolean isSaveElementID = exportDataConfig.isSaveElementID();
		final boolean isSaveLayers = exportDataConfig.isSaveLayers();
		final boolean isSaveAlarmState = exportDataConfig.isSaveAlarmState();
		final boolean isSaveCurrentSubNetwork = exportDataConfig.isSaveCurrentSubNetwork();
		final String filePath = fileSelector.saveFile(graph.getDataBox().getName());
		if (filePath != null)
		{
			JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(graph), TLocale.getString("export_data_description"), SwingLocale.getString("export_and_wait"))
			{
				protected void loadForeground(Object data)
					throws Exception
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame(graph), TLocale.getString("export_data_successfully"), SwingLocale.getString("information"), JBasicOptionPane.INFORMATION_MESSAGE);
				}
				
				protected Object loadBackground()
					throws Exception
				{
					try
					{
						DataBoxOutputSetting setting = new DataBoxOutputSetting();
						setting.setWithElementId(isSaveElementID);
						setting.setWithAlarmState(isSaveAlarmState);
						setting.setWithLayers(isSaveLayers);
						
						if (isSaveCurrentSubNetwork)
						{
							TSubNetwork subNetwork = graph.getCurrentSubNetwork();
							setting.setElementFilter(new SubNetworkPersistentFilter(subNetwork));
						}
						
						graph.getDataBox().output(filePath, setting);
					}
					catch (IOException e)
					{
						e.printStackTrace();
						
						throw e;
					}
					
					return null;
				}
			};
			dialog.execute();
		}
	}
	
	// 导出视图成SVG
	public static void exportSVG(final TGraph graph)
	{
		// 设置导出路径
		JFileSelector fileSelector = graph.getSVGFileSelector();
		if (fileSelector == null)
		{			
			List svgFilterWords = CollectionUtil.parseList(new String[] {"svg"});
			String svgFilterDescription = "SVG File(*.svg)";
			JFileFilter svgFileFilter = new JFileFilter(svgFilterWords, svgFilterDescription);
			
			fileSelector = new JFileSelector(HandleManager.getFrame(graph), TLocale.getString("export_vector_description"));
			fileSelector.addChoosableFileFilter(svgFileFilter);
			fileSelector.setFileFilter(svgFileFilter);
			
			graph.setSVGFileSelector(fileSelector);
		}
		
		final String filePath = fileSelector.saveFile(graph.getDataBox().getName());
		if (filePath != null)
		{
			JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(graph), TLocale.getString("export_vector_description"), SwingLocale.getString("export_and_wait"))
			{
				protected void loadForeground(Object data)
					throws Exception
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame(graph), TLocale.getString("export_vector_successfully"), SwingLocale.getString("information"), JBasicOptionPane.INFORMATION_MESSAGE);
				}
				
				protected Object loadBackground()
					throws Exception
				{
					try
					{
						graph.exportSVG(filePath);
					}
					catch (Exception e)
					{
						e.printStackTrace();
						
						throw e;
					}
					
					return null;
				}
			};
			dialog.execute();
		}
	}
	
	// 导出视图成图片
	public static void exportImage(final TGraph graph)
	{
		TExportImageConfig exportImageConfig = graph.getExportImageConfig();
		if (exportImageConfig == null)
		{
			exportImageConfig = new TExportImageConfig(graph);
			exportImageConfig.setPreferredSize(new Dimension(250, 250));
			
			graph.setExportImageConfig(exportImageConfig);
		}
		exportImageConfig.setZoom();
		
		int selectedValue = JBasicOptionPane.showDialog(HandleManager.getFrame(graph), exportImageConfig, TLocale.getString("export_image_setting"), IconFactory.getSwingIcon("banner/image.png"));
		if (selectedValue != JBasicOptionPane.YES_OPTION)
		{
			return;
		}
				
		// 设置导出路径
		JFileSelector fileSelector = graph.getImageFileSelector();
		if (fileSelector == null)
		{
			List jpgFilterWords = CollectionUtil.parseList(new String[] {"jpg"});
			String jpgFilterDescription = "JPG File(*.jpg)";
			JFileFilter jpgFileFilter = new JFileFilter(jpgFilterWords, jpgFilterDescription);
			
			List jpegFilterWords = CollectionUtil.parseList(new String[] {"jpeg"});
			String jpegFilterDescription = "JPEG File(*.jpeg)";
			JFileFilter jpegFileFilter = new JFileFilter(jpegFilterWords, jpegFilterDescription);
			
			List pngFilterWords = CollectionUtil.parseList(new String[] {"png"});
			String pngFilterDescription = "PNG File(*.png)";
			JFileFilter pngFileFilter = new JFileFilter(pngFilterWords, pngFilterDescription);
			
			fileSelector = new JFileSelector(HandleManager.getFrame(graph), TLocale.getString("export_image_description"));
			fileSelector.addChoosableFileFilter(jpgFileFilter);
			fileSelector.addChoosableFileFilter(jpegFileFilter);
			fileSelector.addChoosableFileFilter(pngFileFilter);
			fileSelector.setFileFilter(jpgFileFilter);
			
			graph.setImageFileSelector(fileSelector);
		}
		
		final boolean isSaveWhole = exportImageConfig.isSaveWhole();
		final boolean isSaveElement = exportImageConfig.isSaveElement();
		final double zoom = exportImageConfig.getZoom();
		final int margin = exportImageConfig.getMargin();
		final String filePath = fileSelector.saveFile(graph.getDataBox().getName());
		final String formatName = fileSelector.getFileFilter().getDescription();
		if (filePath != null)
		{
			JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(graph), TLocale.getString("export_image_description"), SwingLocale.getString("export_and_wait"))
			{
				protected void loadForeground(Object data)
					throws Exception
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame(graph), TLocale.getString("export_image_successfully"), SwingLocale.getString("information"), JBasicOptionPane.INFORMATION_MESSAGE);
				}
				
				protected Object loadBackground()
					throws Exception
				{
					try
					{
						if (isSaveWhole)
						{
							graph.exportImage(filePath, formatName, zoom);
						}
						else if (isSaveElement)
						{
							graph.exportImageCoverElements(filePath, formatName, margin, zoom);
						}
					}
					catch (Exception e)
					{
						e.printStackTrace();
						
						throw e;
					}
					
					return null;
				}
			};
			dialog.execute();
		}
	}
	
	// 打印
	public static void print(TGraph graph)
	{
		graph.getPrinter().preview();
	}
}