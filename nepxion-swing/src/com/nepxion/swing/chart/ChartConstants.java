package com.nepxion.swing.chart;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;

public interface ChartConstants
{
	/**
	 * The bar chart type string.
	 */
	public static final String CHART_TYPE_BAR = "BarChart";
	
	/**
	 * The pie chart type string.
	 */
	public static final String CHART_TYPE_PIE = "PieChart";
	
	/**
	 * The line chart type string.
	 */
	public static final String CHART_TYPE_LINE = "LineChart";
	
	/**
	 * The default string of author for the chart pdf file. 
	 */
	public static final String DEFAULT_CHART_PDF_AUTHOR = "Haojun Ren";
	
	/**
	 * The default string of subject for the chart pdf file. 
	 */
	public static final String DEFAULT_CHART_PDF_SUBJECT = "Nepxion";
	
	/**
	 * The chart section color when the mouse is over.
	 */
	public static final Paint MOUSE_OVER_PAINT = Color.green;
	
	/**
	 * The chart section color when the mouse is down.
	 */
	public static final Paint MOUSE_DOWN_PAINT = Color.yellow;
	
	/**
	 * The chart section stroke when the mouse is over.
	 */
	public static final Stroke MOUSE_OVER_STROKE = new BasicStroke(2.00F);
	
	/**
	 * The chart section stroke when the mouse is down.
	 */
	public static final Stroke MOUSE_DOWN_STROKE = new BasicStroke(2.00F);
	
	/**
	 * The chart section explode percent when the mouse is over.
	 */
	public static final Double MOUSE_OVER_EXPLODE_PERCENT = Double.valueOf(0.00D);
	
	/**
	 * The chart section explode percent when the mouse is down.
	 */
	public static final Double MOUSE_DOWN_EXPLODE_PERCENT = Double.valueOf(0.05D);
}