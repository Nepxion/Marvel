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
	// ѡ��ģʽ
	public static void select(TGraph graph)
	{
		graph.setInteractionMode(InteractionModeFactory.getDefaultMode(graph));
	}
	
	// �ӳ��϶�ģʽ
	public static void layzMove(TGraph graph)
	{
		graph.setInteractionMode(InteractionModeFactory.getDefaultLazySelectionMode(graph));
	}
	
	// �϶�ģʽ
	public static void pan(TGraph graph)
	{
		graph.setInteractionMode(InteractionModeFactory.getPanMode(graph));
		graph.getCanvas().setCursor(TGraph.PAN_CURSOR);
	}
	
	// �Ŵ�
	public static void zoomIn(TGraph graph)
	{
		graph.getZoomer().zoomIn();
	}
	
	// ��С
	public static void zoomOut(TGraph graph)
	{
		graph.getZoomer().zoomOut();
	}
	
	// ����Ŵ�ģʽ
	public static void zoomInRectangle(TGraph graph)
	{
		graph.setInteractionMode(InteractionModeFactory.getZoomToRectMode(graph));
		graph.getCanvas().setCursor(TGraph.ZOOM_IN_RECTANGLE_CURSOR);
	}
	
	// ʵ�ʴ�С
	public static void zoomReset(TGraph graph)
	{
		graph.getZoomer().zoomReset();
	}
	
	// ���ź���
	public static void zoomBack(TGraph graph)
	{
		graph.zoomBack();
	}
	
	// ��Ӧ��Ļ
	public static void zoomToOverview(TGraph graph)
	{
		graph.getZoomer().zoomToOverview(10, 10);
	}
	
	// ȫ���л�
	public static void fullScreen(TGraph graph)
	{
		graph.toggleFullScreen();
	}
	
	// �Ŵ�ģʽ
	public static void magnifier(TGraph graph)
	{
		graph.setInteractionMode(InteractionModeFactory.getMagnifierMode(graph));
	}
	
	// ͼԪ�Ŵ󾵵���״�ʹ�С
	public static void setMagnifierShape(TGraph graph, Shape shape)
	{
		graph.getMagnifier().setShape(shape);
	}
	
	// ͼԪɾ��
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
	
	// ͼԪ����
	public static void copy(TGraph graph)
	{
		graph.getDataBox().copySelection();
	}
	
	// ͼԪճ��
	public static void paste(TGraph graph)
	{
		graph.pasteElements();
	}
	
	// ͼԪ������
	public static void rename(TGraph graph)
	{
		if (graph.getDataBox().getSelectionModel().size() != 1)
		{
			return;
		}
		
		Element element = graph.getDataBox().getLastSelectedElement();
		graph.startEditingAtElement(element);
	}
	
	// ͼԪȫѡ
	public static void selectAll(TGraph graph)
	{
		graph.getDataBox().selectAll();
	}
	
	// ����
	public static void undo(TGraph graph)
	{
		graph.getDataBox().getUndoRedoManager().undo();
	}
	
	// ����
	public static void redo(TGraph graph)
	{
		graph.getDataBox().getUndoRedoManager().redo();
	}
	
	// ��߶���
	public static void alignLeft(TGraph graph)
	{
		graph.getDataBox().alignLeftSelection();
	}
	
	// �����������
	public static void alignVerticalCenter(TGraph graph)
	{
		graph.getDataBox().alignCenterSelection();
	}
	
	// �ұ߶���
	public static void alignRight(TGraph graph)
	{
		graph.getDataBox().alignRightSelection();
	}
	
	// ��������
	public static void alignTop(TGraph graph)
	{
		graph.getDataBox().alignTopSelection();
	}
	
	// �����������
	public static void alignHorizontalCenter(TGraph graph)
	{
		graph.getDataBox().alignMiddleSelection();
	}
	
	// �ײ�����
	public static void alignBottom(TGraph graph)
	{
		graph.getDataBox().alignBottomSelection();
	}
	
	// ��߶���
	public static void pileToLeft(TGraph graph)
	{
		graph.getDataBox().leftPileSelection();
	}
	
	// �ұ߶���
	public static void pileToRight(TGraph graph)
	{
		graph.getDataBox().rightPileSelection();
	}
	
	// ��������
	public static void pileToTop(TGraph graph)
	{
		graph.getDataBox().topPileSelection();
	}
	
	// �ײ�����
	public static void pileToBottom(TGraph graph)
	{
		graph.getDataBox().bottomPileSelection();
	}
	
	// �ȿ�
	public static void sameWidth(TGraph graph)
	{
		graph.getDataBox().sameWidthSelection();
	}
	
	// �ȸ�
	public static void sameHeight(TGraph graph)
	{
		graph.getDataBox().sameHeightSelection();
	}
	
	// ����Ⱦ�
	public static void sameHorizontalSpace(TGraph graph)
	{
		graph.getDataBox().evenHSpaceSelection();
	}
	
	// ����Ⱦ�
	public static void sameVerticalSpace(TGraph graph)
	{
		graph.getDataBox().evenVSpaceSelection();
	}
	
	// �������
	public static void moveToTop(TGraph graph)
	{
		Element element;
		for (Iterator iterator = graph.getDataBox().selection(); iterator.hasNext(); graph.getDataBox().sendToTop(element))
		{
			element = (Element) iterator.next();
		}
	}
	
	// ������ײ�
	public static void moveToBottom(TGraph graph)
	{
		Element element;
		for (Iterator iterator = graph.getDataBox().selection(); iterator.hasNext(); graph.getDataBox().sendToBottom(element))
		{
			element = (Element) iterator.next();
		}
	}
	
	// �л�Node�Ƿ���ƶ�
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
	
	// �л�Node�Ƿ���ƶ�
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
	
	// �л�Node�Ƿ������¼�Node
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
	
	// ����������
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
	
	// ����ʽ����
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
	
	// ������ʾ����
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
	
	// DataBox�ı���¼�����
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
	
	// ִ��DataBox�ı��¼�
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
	
	// ִ��Property�ı��¼�
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
	
	// �ڲ�����λ�õ����¼�����
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
	
	// ͼԪ��ѡ��ɫ
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
	
	// ͼԪѡ���¼�����������Nodeͼ�꣬Node�ĸ���ͼ�꣬Link��ɫ��Link�ĸ�����ɫ
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
	
	// Nodeѡ���¼�����������Nodeͼ�꣬Node�ĸ���ͼ��
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
	
	// Linkѡ���¼�������Link��ɫ��Link�ĸ�����ɫ
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
	
	// ͼԪ˫���¼�����
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
	
	// ͼԪ�����л�
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
	
	// ͼԪ�������Ƿ���ƶ�
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
	
	// ͼԪ�Ƿ�ɱ༭
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
	
	// ͼԪ�Ƿ������
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
	
	// ͼԪ�Ƿ������¼�ͼԪ
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
	
	// �����ʾ
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
	
	// ����ͱ�����ʾ
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
	
	// ӥ��չʾ
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
	
	// ��������ʾ
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
	
	// ����XML�ļ�����ͼ
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
	
	// ������ͼ��XML�ļ�
	public static void exportXML(final TGraph graph)
	{
		// ���õ�������
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
				
		// ���õ���·��
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
	
	// ������ͼ��SVG
	public static void exportSVG(final TGraph graph)
	{
		// ���õ���·��
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
	
	// ������ͼ��ͼƬ
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
				
		// ���õ���·��
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
	
	// ��ӡ
	public static void print(TGraph graph)
	{
		graph.getPrinter().preview();
	}
}