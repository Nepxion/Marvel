package com.nepxion.demo.common;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.style.framework.JAcidStyle;
import com.nepxion.swing.style.framework.JAlloyStyle;
import com.nepxion.swing.style.framework.JBedouinStyle;
import com.nepxion.swing.style.framework.JBlueStyle;
import com.nepxion.swing.style.framework.JBorlandStyle;
import com.nepxion.swing.style.framework.JEclipseStyle;
import com.nepxion.swing.style.framework.JFervencyStyle;
import com.nepxion.swing.style.framework.JGlassStyle;
import com.nepxion.swing.style.framework.JLiteStyle;
import com.nepxion.swing.style.framework.JNimbusStyle;
import com.nepxion.swing.style.framework.JPlasticStyle;
import com.nepxion.swing.style.framework.JRibbonStyle;
import com.nepxion.swing.style.framework.JWindowsStyle;
import com.nepxion.swing.style.framework.JYellowStyle;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoDataFactory
{	
	public static ElementNode getRootElementNode()
	{		
		ElementNode root = new ElementNode(1, "Nepxion", "Nepxion", IconFactory.getSwingIcon("tray_java.png"), "Nepxion Swing");
		List elementNodes = getComponentElementNodes();
		for (Iterator childIterator = elementNodes.iterator(); childIterator.hasNext();)
		{
			ElementNode childElementNode = (ElementNode) childIterator.next();
			root.add(childElementNode);
		}
		
		return root;
	}
	
	public static List getComponentElementNodes()
	{
		// Button Control
		ElementNode buttonControlElementNode = new ElementNode(1, "Button Control", IconFactory.getSwingIcon("component/button_16.png"), "Button Control Component", false, true);		
		buttonControlElementNode.add(new ElementNode(1, "Button", IconFactory.getSwingIcon("component/button_16.png"), "Multi-style Button ToggleButton MenuButton & SplitButton"));
		buttonControlElementNode.add(new ElementNode(2, "CheckBox", IconFactory.getSwingIcon("component/check_box_16.png"), "Multi-style CheckBox"));
		buttonControlElementNode.add(new ElementNode(3, "RadioButton", IconFactory.getSwingIcon("component/radio_button_16.png"), "Multi-style RadioButton"));
		buttonControlElementNode.add(new ElementNode(4, "ComboBox", IconFactory.getSwingIcon("component/combo_box_16.png"), "Multi-style ComboBox"));

		// Text Control
		ElementNode textControlElementNode = new ElementNode(2, "Text Control", IconFactory.getSwingIcon("component/label_16.png"), "Text Control Component", false, false);		
		textControlElementNode.add(new ElementNode(1, "TextField", IconFactory.getSwingIcon("component/text_field_16.png"), "Multi-style TextField"));
		textControlElementNode.add(new ElementNode(2, "TextArea", IconFactory.getSwingIcon("component/text_area_16.png"), "Multi-style TextArea"));		
		
		// Menu Control
		ElementNode menuControlElementNode = new ElementNode(3, "Menu Control", IconFactory.getSwingIcon("component/menu_16.png"), "Menu Control Component", false, true);		
		menuControlElementNode.add(new ElementNode(1, "Menu", IconFactory.getSwingIcon("component/menu_16.png"), "Multi-style Menu"));
		menuControlElementNode.add(new ElementNode(2, "PopupMenu", IconFactory.getSwingIcon("component/popup_menu_16.png"), "Multi-style PopupMenu"));	
		
		// Border Control
		ElementNode borderControlElementNode = new ElementNode(4, "Border Control", IconFactory.getSwingIcon("component/split_pane_16.png"), "Border Control Component", false, false);
		
		// Container Control
		ElementNode containerControlElementNode = new ElementNode(5, "Container Control", IconFactory.getSwingIcon("component/internal_frame_16.png"), "Container Control Component", false, true);
		containerControlElementNode.add(new ElementNode(1, "Panel", IconFactory.getSwingIcon("component/panel_16.png"), "Multi-style Panel"));
		containerControlElementNode.add(new ElementNode(2, "ScrollPane", IconFactory.getSwingIcon("component/scroll_pane_16.png"), "Multi-style ScrollPane"));		
		containerControlElementNode.add(new ElementNode(3, "TabbedPane", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), "Multi-style TabbedPane"));
		
		// Bar Control
		ElementNode barControlElementNode = new ElementNode(6, "Bar Control", IconFactory.getSwingIcon("component/tool_bar_16.png"), "Bar Control Component", false, false);
		barControlElementNode.add(new ElementNode(1, "TaskBar", IconFactory.getSwingIcon("component/tool_bar_16.png"), "Multi-style TaskBar"));
		barControlElementNode.add(new ElementNode(2, "OutlookBar", IconFactory.getSwingIcon("component/tool_bar_16.png"), "Multi-style OutlookBar"));		
		barControlElementNode.add(new ElementNode(3, "ButtonBar", IconFactory.getSwingIcon("component/tool_bar_16.png"), "Multi-style ButtonBar"));
		barControlElementNode.add(new ElementNode(4, "StatusBar", IconFactory.getSwingIcon("component/tool_bar_16.png"), "Multi-style StatusBar"));	
		
		// Data Control
		ElementNode dataControlElementNode = new ElementNode(7, "Data Control", IconFactory.getSwingIcon("component/table_16.png"), "Data Control Component", false, true);
		dataControlElementNode.add(new ElementNode(1, "Tree", IconFactory.getSwingIcon("component/tree_16.png"), "Multi-style Tree"));
		dataControlElementNode.add(new ElementNode(2, "Table", IconFactory.getSwingIcon("component/table_16.png"), "Multi-style Table"));		
		dataControlElementNode.add(new ElementNode(3, "List", IconFactory.getSwingIcon("component/list_16.png"), "Multi-style List"));
		
		// Selector Control
		ElementNode selectorControlElementNode = new ElementNode(8, "Selector Control", IconFactory.getSwingIcon("component/file_chooser_16.png"), "Selector Control Component", false, false);
		selectorControlElementNode.add(new ElementNode(1, "Calendar", IconFactory.getSwingIcon("component/calendar_16.png"), "Multi-style Calendar Selector"));
		selectorControlElementNode.add(new ElementNode(2, "Locale", IconFactory.getSwingIcon("component/locale_16.png"), "Multi-style Locale Selector"));		
		selectorControlElementNode.add(new ElementNode(3, "File", IconFactory.getSwingIcon("component/file_chooser_16.png"), "Multi-style File Selector"));
		selectorControlElementNode.add(new ElementNode(4, "Color", IconFactory.getSwingIcon("component/color_chooser_16.png"), "Multi-style Color Selector"));
		selectorControlElementNode.add(new ElementNode(5, "DropDown", IconFactory.getSwingIcon("component/popup_menu_16.png"), "Multi-style DropDown Selector"));		
		selectorControlElementNode.add(new ElementNode(6, "CheckBox", IconFactory.getSwingIcon("component/check_box_16.png"), "Multi-style CheckBox Selector"));
		selectorControlElementNode.add(new ElementNode(7, "RadioButton", IconFactory.getSwingIcon("component/radio_button_16.png"), "Multi-style RadioButton Selector"));		
		
		// Layout Control
		ElementNode layoutControlElementNode = new ElementNode(9, "Layout Control", IconFactory.getSwingIcon("component/layout_16.png"), "Layout Control Component", false, true);
		layoutControlElementNode.add(new ElementNode(1, "Table Layout", IconFactory.getSwingIcon("component/layout_16.png"), "Multi-style Table Layout"));
		layoutControlElementNode.add(new ElementNode(2, "Filed Layout", IconFactory.getSwingIcon("component/layout_16.png"), "Multi-style Filed Layout"));		
		layoutControlElementNode.add(new ElementNode(3, "Ratio Layout", IconFactory.getSwingIcon("component/layout_16.png"), "Multi-style Ratio Layout"));
		layoutControlElementNode.add(new ElementNode(4, "XBorder Layout", IconFactory.getSwingIcon("component/layout_16.png"), "Multi-style XBorder Layout"));
		layoutControlElementNode.add(new ElementNode(5, "XBox Layout", IconFactory.getSwingIcon("component/layout_16.png"), "Multi-style XBox Layout"));
		
		// UI Control
		ElementNode uiControlElementNode = new ElementNode(10, "UI Control", IconFactory.getSwingIcon("component/ui_16.png"), "UI Control Component", false, true);
		uiControlElementNode.add(new ElementNode(1, "UI Explorer", IconFactory.getSwingIcon("component/ui_16.png"), "UI Explorer"));	
		
		// FrameWork Control
		ElementNode frameWorkControlElementNode = new ElementNode(11, "FrameWork Control", IconFactory.getSwingIcon("component/framework_16.png"), "FrameWork Control Component", false, false);
		frameWorkControlElementNode.add(new ElementNode(1, "Dockable", IconFactory.getSwingIcon("component/framework_16.png"), "Dockable FrameWork"));
		frameWorkControlElementNode.add(new ElementNode(2, "VLDocking", IconFactory.getSwingIcon("component/framework_16.png"), "VLDocking Framework"));		
		
		// Application Control
		ElementNode applicationControlElementNode = new ElementNode(12, "Application Control", IconFactory.getSwingIcon("component/application_16.png"), "Application Control Component", false, true);
		applicationControlElementNode.add(new ElementNode(1, "Google Map", IconFactory.getSwingIcon("component/application_16.png"), "Google Map"));		
		applicationControlElementNode.add(new ElementNode(1, "IP", IconFactory.getSwingIcon("component/application_16.png"), "IP"));	
		applicationControlElementNode.add(new ElementNode(1, "Mobile", IconFactory.getSwingIcon("component/application_16.png"), "Mobile"));	
		
		List componentElementNodes = new ArrayList();
		componentElementNodes.add(buttonControlElementNode);
		componentElementNodes.add(textControlElementNode);
		componentElementNodes.add(menuControlElementNode);
		componentElementNodes.add(borderControlElementNode);
		componentElementNodes.add(containerControlElementNode);
		componentElementNodes.add(barControlElementNode);
		componentElementNodes.add(dataControlElementNode);
		componentElementNodes.add(selectorControlElementNode);
		componentElementNodes.add(layoutControlElementNode);
		componentElementNodes.add(uiControlElementNode);
		componentElementNodes.add(frameWorkControlElementNode);
		componentElementNodes.add(applicationControlElementNode);
		
		return componentElementNodes;
	}
	
	public static String[] getComponentNameColumns()
	{
		String[] columns = {"Index", "Name", "Text", "Icon", "ToolTipText", "Selected", "Enabled", "UserObject"};
		
		return columns;
	}
	
	public static String[] getComponentNameDatas()
	{
		List componentElementNodes = getComponentElementNodes();
		String[] componentNameDatas = new String[componentElementNodes.size()];
		int index = 0;
		for (Iterator iterator = componentElementNodes.iterator(); iterator.hasNext();)
		{
			componentNameDatas[index] = iterator.next().toString();
			index++;
		}	
		
		return componentNameDatas;
	}
	
	public static String[] getComponentDescriptonDatas()
	{
		List componentElementNodes = getComponentElementNodes();
		String[] componentDescriptonDatas = new String[componentElementNodes.size()];
		
		int index = 0;
		for (Iterator iterator = componentElementNodes.iterator(); iterator.hasNext();)
		{
			ElementNode elementNode = (ElementNode) iterator.next();
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("Index : [");
			stringBuffer.append(elementNode.getIndex());
			stringBuffer.append("]\t");
			stringBuffer.append("Name : [");
			stringBuffer.append(elementNode.getName());
			stringBuffer.append("]\t");			
			stringBuffer.append("text : [");
			stringBuffer.append(elementNode.getText());
			stringBuffer.append("]\t");
			stringBuffer.append("TooTipText : [");
			stringBuffer.append(elementNode.getToolTipText());
			stringBuffer.append("]\t");
			componentDescriptonDatas[index] = stringBuffer.toString();
			index++;
		}
		
		return componentDescriptonDatas;
	}	
    
	public static List getTabShapeElementNodes()
	{
		ElementNode eclipse3XShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_ECLIPSE3X, "Eclipse3X Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Eclipse3X Shape");
		ElementNode roundedVSNetShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_ROUNDED_VSNET, "VSNet Shape (Rounded Corner)", IconFactory.getSwingIcon("netbean/canvas_16.png"), "VSNet Shape (Rounded Corner)");
		ElementNode vsNetShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_VSNET, "VSNet Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "VSNet Shape");
		ElementNode boxShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_BOX, "Box Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Box Shape");
		ElementNode roundedFlatShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_ROUNDED_FLAT, "Flat Shape (Rounded)", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Flat Shape (Rounded)");
		ElementNode flatShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_FLAT, "Flat Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Flat Shape");
				
		ElementNode windowsShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_WINDOWS, "Windows Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Windows Shape");
		ElementNode windowsSelectedShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_WINDOWS_SELECTED, "Windows Shape (Selected Only)", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Windows Shape (Selected Only)");
		ElementNode office2003ShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_OFFICE2003, "Office2003 Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Office2003 Shape");
		ElementNode excelShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_EXCEL, "Excel Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Excel Shape");
		ElementNode eclipseShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_ECLIPSE, "Eclipse Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Eclipse Shape");
		
		List shapeElementNodes = new ArrayList();
		shapeElementNodes.add(eclipse3XShapeElementNode);
		shapeElementNodes.add(roundedVSNetShapeElementNode);
		shapeElementNodes.add(vsNetShapeElementNode);
		shapeElementNodes.add(boxShapeElementNode);
		shapeElementNodes.add(roundedFlatShapeElementNode);
		shapeElementNodes.add(flatShapeElementNode);
		
		shapeElementNodes.add(windowsShapeElementNode);
		shapeElementNodes.add(windowsSelectedShapeElementNode);
		shapeElementNodes.add(office2003ShapeElementNode);
		shapeElementNodes.add(excelShapeElementNode);
		shapeElementNodes.add(eclipseShapeElementNode);
		
		return shapeElementNodes;
	}
	
	public static List getStyleElementNodes()
	{
		ElementNode ribbonStyleElementNode = new ElementNode("JRibbonStyle", IconFactory.getSwingIcon("netbean/color_adjust_16.png"), "JRibbonStyle", new JRibbonStyle());
		ElementNode nimbusStyleElementNode = new ElementNode("JNimbusStyle", IconFactory.getSwingIcon("netbean/color_adjust_16.png"), "JNimbusStyle", new JNimbusStyle());
		ElementNode plasticStyleElementNode = new ElementNode("JPlasticStyle", IconFactory.getSwingIcon("netbean/color_adjust_16.png"), "JPlasticStyle", new JPlasticStyle());
		ElementNode eclipseStyleElementNode = new ElementNode("JEclipseStyle", IconFactory.getSwingIcon("netbean/color_adjust_16.png"), "JEclipseStyle", new JEclipseStyle());
		ElementNode liteStyleElementNode = new ElementNode("JLiteStyle", IconFactory.getSwingIcon("netbean/color_adjust_16.png"), "JLiteStyle", new JLiteStyle());
		ElementNode alloyStyleElementNode = new ElementNode("JAlloyStyle", IconFactory.getSwingIcon("netbean/color_adjust_16.png"), "JAlloyStyle", new JAlloyStyle());
		ElementNode acidStyleElementNode = new ElementNode("JAcidStyle", IconFactory.getSwingIcon("netbean/color_adjust_16.png"), "JAcidStyle", new JAcidStyle());
		ElementNode bedouinStyleElementNode = new ElementNode("JBedouinStyle", IconFactory.getSwingIcon("netbean/color_adjust_16.png"), "JBedouinStyle", new JBedouinStyle());
		ElementNode glassStyleElementNode = new ElementNode("JGlassStyle", IconFactory.getSwingIcon("netbean/color_adjust_16.png"), "JGlassStyle", new JGlassStyle());
		ElementNode blueStyleElementNode = new ElementNode("JBlueStyle", IconFactory.getSwingIcon("netbean/color_adjust_16.png"), "JBlueStyle", new JBlueStyle());
		ElementNode yellowStyleElementNode = new ElementNode("JYellowStyle", IconFactory.getSwingIcon("netbean/color_adjust_16.png"), "JYellowStyle", new JYellowStyle());
		
		ElementNode fervencyStyleElementNode = new ElementNode("JFervencyStyle", IconFactory.getSwingIcon("netbean/color_adjust_16.png"), "JFervencyStyle", new JFervencyStyle());
		ElementNode borlandStyleElementNode = new ElementNode("JBorlandStyle", IconFactory.getSwingIcon("netbean/color_adjust_16.png"), "JBorlandStyle", new JBorlandStyle());
		ElementNode windowsStyleElementNode = new ElementNode("JWindowsStyle", IconFactory.getSwingIcon("netbean/color_adjust_16.png"), "JWindowsStyle", new JWindowsStyle());
		
		List shapeElementNodes = new ArrayList();
		shapeElementNodes.add(ribbonStyleElementNode);
		shapeElementNodes.add(nimbusStyleElementNode);
		shapeElementNodes.add(plasticStyleElementNode);
		shapeElementNodes.add(eclipseStyleElementNode);
		shapeElementNodes.add(liteStyleElementNode);
		shapeElementNodes.add(alloyStyleElementNode);
		shapeElementNodes.add(acidStyleElementNode);
		shapeElementNodes.add(bedouinStyleElementNode);
		shapeElementNodes.add(glassStyleElementNode);
		shapeElementNodes.add(blueStyleElementNode);
		shapeElementNodes.add(yellowStyleElementNode);
		shapeElementNodes.add(fervencyStyleElementNode);
		shapeElementNodes.add(borlandStyleElementNode);
		shapeElementNodes.add(windowsStyleElementNode);
		
		return shapeElementNodes;
	}
}