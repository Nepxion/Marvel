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
		// 设置视图背景色
		getViewport().setBackground(Color.white);
		
		// 激活删除快敏键
		setEnableDeleteWithKeyboard(false);
		
		// 激活拷贝粘贴
		setEnableCopyPasteWithKeyboard(false);
		
		// 激活撤销重做
		setEnableUndoRedoWithKeyboard(false);
		
		// 让选中的图元在可见范围内
		setEnsureVisibleOnSelected(true);
		
		// 图元选择透明区域，触发选中
		setElementTransparentAreaSelectable(true);
		
		// 图元可编辑
		// TGraphManager.setElementLabelEditable(this, true);
		
		// 图元可拉伸
		TGraphManager.setResizableFilter(this, true);
		
		// 图元标签选中
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_LABEL_SELECTABLE, Boolean.TRUE);
		
		// 图元选中时反色高亮
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_LABEL_HIGHLIGHTABLE, Boolean.TRUE);
		
		// 图元选中框的边界类型
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_BORDER_TYPE, TWaverUtil.valueOf(TWaverConst.BORDER_TYPE_POINT));
		
		// 图元选中框的粗细
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_BORDER_STROKE, TWaverConst.STROKE_SOLID_THINNEST);
		
		// 图元选中框的间隙
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_BORDER_INSETS, TWaverUtil.valueOf(4)); // 5
		
		// 图元选中框是否填充
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_BORDER_FILL, Boolean.TRUE);
		
		// 图元选中框的外框色(全局设置)
		// TUIManager.registerDefault(TWaverConst.PROPERTYNAME_BORDER_COLOR, new Color(125, 125, 125));
		
		// 图元选中框的外框色
		TGraphManager.setElementSelectColorGenerator(this, new Color(125, 125, 125), new Color(0, 0, 0, 0));
		
		// 图元选中框的填充色
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_BORDER_FILL_COLOR, Color.red);
		
		// 图元放大镜的形状和大小
		TGraphManager.setMagnifierShape(this, new Rectangle(0, 0, 160, 160));
		
		// Link默认色
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_LINK_COLOR, new Color(220, 222, 224));
		
		// Link粗细
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_LINK_WIDTH, TWaverUtil.valueOf(3));
		
		// Link外框粗细
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_LINK_OUTLINE_WIDTH, TWaverUtil.valueOf(1));
		
		// 拷贝时候，不拷贝业务对象(UserObject)
		TUIManager.registerPredefinedPropertyCopied(TWaverConst.PROPERTYNAME_USEROBJECT, false);
		
		// 对LinkBundle的标签的判断
		// new TLabelGenerator(this);
	}
	
	private void initComponents()
	{
		// 工具栏
		new TGraphToolBar(this);
		
		// 右键菜单
		// new TGraphPopupMenuGenerator(this);
	}
	
	private void initListeners()
	{
		// 鼠标事件监听
		// new TGraphMouseAdapter(this);
		
		// 鼠标选择事件监听
		// new TDataBoxSelectionAdapter(this);
		
		// 鼠标选择的切换，通知Link选中色改变
		TGraphManager.addLinkSelectionListener(this, Color.red);
		
		// 图元是否隐藏下级图元
		TGraphManager.addVisibleFilter(this);
		
		// DataBox里的层次(父子)关系是否改变事件监听
		new TDataBoxPropertyChangeAdapter(getDataBox());
		
		// DataBox改变事件监听
		// TGraphManager.addDataBoxChangeListener(this);
		
		// 内部窗体位置调整事件监听
		TGraphManager.addCanvasAdjustListener(this);
	}
	
	public void setDataBox(TDataBox dataBox)
	{
		TDataBox oldDataBox = getDataBox();
		super.setDataBox(dataBox);
		TDataBox newDataBox = getDataBox();
		
		// 当DataBox被重置时，把旧DataBox上的Selection监听移到新DataBox上
		TGraphManager.fireDataBoxChangeEvent(oldDataBox, newDataBox);
		
		// 当DataBox被重置时，把旧DataBox上的Element监听移到新DataBox上
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