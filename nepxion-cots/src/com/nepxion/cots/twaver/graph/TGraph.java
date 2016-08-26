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
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.JComponent;
import javax.swing.JViewport;
import javax.swing.KeyStroke;

import twaver.Element;
import twaver.TDataBox;
import twaver.TUIManager;
import twaver.TWaverConst;
import twaver.TWaverUtil;
import twaver.network.TNetwork;

import com.nepxion.cots.twaver.element.TDataBoxPropertyChangeAdapter;
import com.nepxion.cots.twaver.element.TGroup;
import com.nepxion.cots.twaver.element.TNode;
import com.nepxion.cots.twaver.element.TType;
import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.selector.file.JFileSelector;

public class TGraph
	extends TNetwork
{
	public static final Cursor PAN_CURSOR = Toolkit.getDefaultToolkit().createCustomCursor(TIconFactory.getContextIcon("pan_cursor.png").getImage(), new Point(0, 0), "Pan");
	public static final Cursor ZOOM_IN_CURSOR = Toolkit.getDefaultToolkit().createCustomCursor(TIconFactory.getContextIcon("zoom_in_cursor.png").getImage(), new Point(0, 0), "ZoomIn");
	public static final Cursor ZOOM_OUT_CURSOR = Toolkit.getDefaultToolkit().createCustomCursor(TIconFactory.getContextIcon("zoom_out_cursor.png").getImage(), new Point(0, 0), "ZoomOut");
	public static final Cursor ZOOM_IN_RECTANGLE_CURSOR = Toolkit.getDefaultToolkit().createCustomCursor(TIconFactory.getContextIcon("zoom_in_rectangle_cursor.png").getImage(), new Point(0, 0), "ZoomInRectangle");
	
	private TGraphBackground background;
	private TOverview overview;
	
	private JFileSelector importDataFileSelector;
	
	private TExportDataConfig exportDataConfig;
	private JFileSelector exportDataFileSelector;
	
	private JFileSelector svgFileSelector;
	
	private TExportImageConfig exportImageConfig;
	private JFileSelector imageFileSelector;
	
	private TLabelConfig labelConfig;
	private TInternalFrame controlBarInternalFrame;
	private TInternalFrame layoutInternalFrame;
	private TInternalFrame scaleInternalFrame;
	
	private TGraphAdapter adapter;
	
	private TType type;
	
	private Object dndObject;
	
	public TGraph()
	{
		this(new TDataBox());
	}
	
	public TGraph(TDataBox dataBox)
	{
		this(dataBox, null);
	}
	
	public TGraph(TType type)
	{
		this(new TDataBox(), type);
	}
	
	public TGraph(TDataBox dataBox, TType type)
	{
		super(dataBox);
		
		this.type = type;
		
		initServiceStyle();
		initComponents();
		initListeners();
	}
	
	private void initServiceStyle()
	{
		// ������ͼ����ɫ
		getViewport().setBackground(Color.white);
		
		// ����ɾ��������
		setEnableDeleteWithKeyboard(false);
		
		// �����ճ��
		setEnableCopyPasteWithKeyboard(false);
		
		// ���������
		setEnableUndoRedoWithKeyboard(false);
		
		// ��ѡ�е�ͼԪ�ڿɼ���Χ��
		setEnsureVisibleOnSelected(true);
		
		// ͼԪѡ��͸�����򣬴���ѡ��
		setElementTransparentAreaSelectable(true);
		
		// ͼԪ�ɱ༭
		// TGraphManager.setElementLabelEditable(this, true);
		
		// ͼԪ������
		TGraphManager.setResizableFilter(this, true);
		
		// ͼԪ��ǩѡ��
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_LABEL_SELECTABLE, Boolean.TRUE);
		
		// ͼԪѡ��ʱ��ɫ����
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_LABEL_HIGHLIGHTABLE, Boolean.TRUE);
		
		// ͼԪѡ�п�ı߽�����
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_BORDER_TYPE, TWaverUtil.valueOf(TWaverConst.BORDER_TYPE_POINT));
		
		// ͼԪѡ�п�Ĵ�ϸ
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_BORDER_STROKE, TWaverConst.STROKE_SOLID_THINNEST);
		
		// ͼԪѡ�п�ļ�϶
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_BORDER_INSETS, TWaverUtil.valueOf(4)); // 5
		
		// ͼԪѡ�п��Ƿ����
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_BORDER_FILL, Boolean.TRUE);
		
		// ͼԪѡ�п�����ɫ(ȫ������)
		// TUIManager.registerDefault(TWaverConst.PROPERTYNAME_BORDER_COLOR, new Color(125, 125, 125));
		
		// ͼԪѡ�п�����ɫ
		TGraphManager.setElementSelectColorGenerator(this, new Color(125, 125, 125), new Color(0, 0, 0, 0));
		
		// ͼԪѡ�п�����ɫ
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_BORDER_FILL_COLOR, Color.red);
		
		// ͼԪ�Ŵ󾵵���״�ʹ�С
		TGraphManager.setMagnifierShape(this, new Rectangle(0, 0, 160, 160));
		
		// LinkĬ��ɫ
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_LINK_COLOR, new Color(220, 222, 224));
		
		// Link��ϸ
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_LINK_WIDTH, TWaverUtil.valueOf(3));
		
		// Link����ϸ
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_LINK_OUTLINE_WIDTH, TWaverUtil.valueOf(1));
		
		// ����ʱ�򣬲�����ҵ�����(UserObject)
		TUIManager.registerPredefinedPropertyCopied(TWaverConst.PROPERTYNAME_USEROBJECT, false);
		
		// ��LinkBundle�ı�ǩ���ж�
		// new TLabelGenerator(this);
	}
	
	private void initComponents()
	{
		// ������
		new TGraphToolBar(this);
		
		// �Ҽ��˵�
		// new TGraphPopupMenuGenerator(this);
	}
	
	private void initListeners()
	{
		// ����¼�����
		// new TGraphMouseAdapter(this);
		
		// ���ѡ���¼�����
		// new TDataBoxSelectionAdapter(this);
		
		// ���ѡ����л���֪ͨLinkѡ��ɫ�ı�
		TGraphManager.addLinkSelectionListener(this, Color.red);
		
		// ͼԪ�Ƿ������¼�ͼԪ
		TGraphManager.addVisibleFilter(this);
		
		// DataBox��Ĳ��(����)��ϵ�Ƿ�ı��¼�����
		new TDataBoxPropertyChangeAdapter(getDataBox());
		
		// DataBox�ı��¼�����
		// TGraphManager.addDataBoxChangeListener(this);
		
		// �ڲ�����λ�õ����¼�����
		TGraphManager.addCanvasAdjustListener(this);
	}
	
	public void setDataBox(TDataBox dataBox)
	{
		TDataBox oldDataBox = getDataBox();
		super.setDataBox(dataBox);
		TDataBox newDataBox = getDataBox();
		
		// ��DataBox������ʱ���Ѿ�DataBox�ϵ�Selection�����Ƶ���DataBox��
		TGraphManager.fireDataBoxChangeEvent(oldDataBox, newDataBox);
		
		// ��DataBox������ʱ���Ѿ�DataBox�ϵ�Element�����Ƶ���DataBox��
		TGraphManager.fireElementPropertyChangeEvent(oldDataBox, newDataBox);
		
		super.setName(newDataBox.getName());
	}
	
	public boolean isMovable(Element element)
	{
		if (element instanceof TNode)
		{
			TNode node = (TNode) element;
			if (!node.isMovable())
			{
				return false;
			}
		}
		if (element instanceof TGroup)
		{
			TGroup group = (TGroup) element;
			if (!group.isMovable())
			{
				return false;
			}
		}
		
		return super.isMovable(element);
	}
	
	public void registerKeyboardAction(JSecurityAction action, int keyCode, int modifiers)
	{
		KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, modifiers);
		action.putValue(JSecurityAction.ACCELERATOR_KEY, keyStroke);
		
		getCanvas().registerKeyboardAction(action, keyStroke, JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
	}
	
	public TGraphBackground getGraphBackground()
	{
		return background;
	}
	
	public void setGraphBackground(TGraphBackground background)
	{
		super.setBackground(background);

		this.background = background;
	}
	
	public TOverview getOverview()
	{
		return overview;
	}
	
	public void setOverview(TOverview overview)
	{
		this.overview = overview;
	}
	
	public JFileSelector getImportDataFileSelector()
	{
		return importDataFileSelector;
	}
	
	public void setImportDataFileSelector(JFileSelector importDataFileSelector)
	{
		this.importDataFileSelector = importDataFileSelector;
	}
	
	public TExportDataConfig getExportDataConfig()
	{
		return exportDataConfig;
	}
	
	public void setExportDataConfig(TExportDataConfig exportDataConfig)
	{
		this.exportDataConfig = exportDataConfig;
	}
	
	public JFileSelector getExportDataFileSelector()
	{
		return exportDataFileSelector;
	}
	
	public void setExportDataFileSelector(JFileSelector exportDataFileSelector)
	{
		this.exportDataFileSelector = exportDataFileSelector;
	}
	
	public TExportImageConfig getExportImageConfig()
	{
		return exportImageConfig;
	}
	
	public void setExportImageConfig(TExportImageConfig exportImageConfig)
	{
		this.exportImageConfig = exportImageConfig;
	}
	
	public JFileSelector getSVGFileSelector()
	{
		return svgFileSelector;
	}
	
	public void setSVGFileSelector(JFileSelector svgFileSelector)
	{
		this.svgFileSelector = svgFileSelector;
	}
	
	public JFileSelector getImageFileSelector()
	{
		return imageFileSelector;
	}
	
	public void setImageFileSelector(JFileSelector imageFileSelector)
	{
		this.imageFileSelector = imageFileSelector;
	}
	
	public TLabelConfig getLabelConfig()
	{
		return labelConfig;
	}
	
	public void setLabelConfig(TLabelConfig labelConfig)
	{
		this.labelConfig = labelConfig;
	}
	
	public TInternalFrame getControlBarInternalFrame()
	{
		return controlBarInternalFrame;
	}
	
	public void setControlBarInternalFrame(TInternalFrame controlBarInternalFrame)
	{
		this.controlBarInternalFrame = controlBarInternalFrame;
	}
	
	public TInternalFrame getLayoutInternalFrame()
	{
		return layoutInternalFrame;
	}
	
	public void setLayoutInternalFrame(TInternalFrame layoutInternalFrame)
	{
		this.layoutInternalFrame = layoutInternalFrame;
	}
	
	public TInternalFrame getScaleInternalFrame()
	{
		return scaleInternalFrame;
	}
	
	public void setScaleInternalFrame(TInternalFrame scaleInternalFrame)
	{
		this.scaleInternalFrame = scaleInternalFrame;
	}
	
	public TType getGraphType()
	{
		return type;
	}
	
	public void setGraphType(TType type)
	{
		this.type = type;
		
		setName(type.toString());
	}
	
	public TGraphAdapter getAdapter()
	{
		return adapter;
	}
	
	public void setAdapter(TGraphAdapter adapter)
	{
		this.adapter = adapter;
	}
	
	public Object getDndObject()
	{
		return dndObject;
	}
	
	public void setDnDObject(Object dndObject)
	{
		this.dndObject = dndObject;
	}
	
	public void handleDrop(DropTargetDropEvent e, String className)
	{
		Element element = createDnDElement(dndObject);
		if (element != null)
		{
			dropComplete(e, element);
		}
	}
	
	public Element createDnDElement(Object dndObject)
	{
		return null;
	}
	
	public JViewport getViewport()
	{
		return getCanvasScrollPane().getViewport();
	}
	
	public void setName(String name)
	{
		super.setName(name);
		
		getDataBox().setName(name);
	}
}