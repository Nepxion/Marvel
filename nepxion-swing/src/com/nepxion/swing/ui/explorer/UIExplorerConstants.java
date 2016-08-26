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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.InputMap;
import javax.swing.border.Border;

import com.nepxion.swing.locale.SwingLocale;

public class UIExplorerConstants
{
	/**
	 * 
	 */
	public static final String ROOT_NAME = SwingLocale.getString("parameter");
	
	/**
	 * 
	 */
	public static final String ALL_NAME = SwingLocale.getString("all");
	
	/**
	 * 
	 */
	public static final String COMPONENT_NAME = SwingLocale.getString("component");
	
	/**
	 * 
	 */
	public static final String TYPE_NAME = SwingLocale.getString("type");
	
	/**
	 * 
	 */
	public static final Class[] CLASS_TYPES = {Boolean.class, Border.class, Color.class, Dimension.class, Font.class, Icon.class, InputMap.class, Insets.class, Number.class, String.class};
	
	/**
	 * 
	 */
	public static final String[] CLASS_TYPE_NAMES = {"Boolean", "Border", "Color", "Dimension", "Font", "Icon", "InputMap", "Insets", "Number", "String", SwingLocale.getString("others")};
}