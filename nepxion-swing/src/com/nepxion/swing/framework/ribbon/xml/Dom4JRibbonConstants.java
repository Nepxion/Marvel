package com.nepxion.swing.framework.ribbon.xml;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Insets;

import javax.swing.SwingConstants;

public interface Dom4JRibbonConstants
	extends SwingConstants
{
	/**
	 * The path of config file for "ribbon.xml".
	 */
	public static final String CONFIG_FILE_PATH = "data/ribbon.xml";
	
	/**
	 * The tag for "name".
	 */
	public static final String TAG_NAME = "name";
	
	/**
	 * The tag for "title".
	 */
	public static final String TAG_TITLE = "title";
	
	/**
	 * The tag for "text".
	 */
	public static final String TAG_TEXT = "text";
	
	/**
	 * The tag for "largetext".
	 */
	public static final String TAG_LARGE_TEXT = "largetext";
	
	/**
	 * The tag for "icon".
	 */
	public static final String TAG_ICON = "icon";
	
	/**
	 * The tag for "largeicon".
	 */
	public static final String TAG_LARGE_ICON = "largeicon";
	
	/**
	 * The tag for "tooltip".
	 */
	public static final String TAG_TOOL_TIP_TEXT = "tooltip";
	
	/**
	 * The tag for "ribbonname".
	 */
	public static final String TAG_RIBBON_NAME = "ribbonname";
	
	/**
	 * The tag for "ribbontitle".
	 */
	public static final String TAG_RIBBON_TITLE = "ribbontitle";
	
	/**
	 * The tag for "ribbonicon".
	 */
	public static final String TAG_RIBBON_ICON = "ribbonicon";
	
	/**
	 * The tag for "ribbontooltip".
	 */
	public static final String TAG_RIBBON_TOOL_TIP_TEXT = "ribbontooltip";
	
	/**
	 * The tag for "separator".
	 */
	public static final String TAG_SEPARATOR = "separator";
	
	/**
	 * The tag for "orientation".
	 */
	public static final String TAG_ORIENTATION = "orientation";
	
	/**
	 * The tag for "arrowposition".
	 */
	public static final String TAG_ARROW_POSITION = "arrowposition";
	
	/**
	 * The tag for "closable".
	 */
	public static final String TAG_CLOSABLE = "closable";
	
	/**
	 * The tag for "layout".
	 */
	public static final String TAG_LAYOUT = "layout";
	
	/**
	 * The tag for "buttonlayout".
	 */
	public static final String TAG_BUTTON_LAYOUT = "buttonlayout";
	
	/**
	 * The tag for "buttoninsets".
	 */
	public static final String TAG_BUTTON_INSETS = "buttoninsets";
	
	/**
	 * The tag for "constraints".
	 */
	public static final String TAG_CONSTRAINTS = "constraints";
	
	/**
	 * The tag for "component".
	 */
	public static final String TAG_COMPONENT = "component";
	
	/**
	 * The tag for "action".
	 */
	public static final String TAG_ACTION = "action";
	
	/**
	 * The tag for "cornername".
	 */
	public static final String TAG_CORNER_NAME = "cornername";
	
	/**
	 * The tag for "cornertooltiptext".
	 */
	public static final String TAG_CORNER_TOOL_TIP_TEXT = "cornertooltip";
	
	/**
	 * The tag for "corneraction".
	 */
	public static final String TAG_CORNER_ACTION = "corneraction";
	
	/**
	 * The tag for "containerstyle";
	 */
	public static final String TAG_CONTAINER_STYLE = "containerstyle";
	
	/**
	 * The tag for "maximumcount".
	 */
	public static final String TAG_MAXIMUM_COUNT = "maximumcount";
	
	/**
	 * The tag for "ribbonnavigator".
	 */
	public static final String TAG_RIBBON_NAVIGATOR = "ribbonnavigator";
	
	/**
	 * The tag for "ribboncontainer".
	 */
	public static final String TAG_RIBBON_CONTAINER = "ribboncontainer";
	
	/**
	 * The button layout array.
	 */
	public static final int[] BUTTON_LAYOUT = new int[] {VERTICAL, CENTER};
	
	/**
	 * The button insets array. 
	 */
	public static final Insets BUTTON_INSETS = new Insets(8, 8, 8, 8);
}