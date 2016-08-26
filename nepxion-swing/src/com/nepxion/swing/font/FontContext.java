package com.nepxion.swing.font;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Font;

public class FontContext
	implements FontConstants
{	
	/**
	 * The font name.
	 */
	private static String fontName = DEFAULT_FONT_NAME;
	
	/**
	 * The font style.
	 */
	private static int fontStyle = DEFAULT_FONT_STYLE;
	
	/**
	 * The font size.
	 */
	private static int fontSize = DEFAULT_FONT_SIZE;
	
	/**
	 * The chart title font name.
	 */
	private static String chartTitleFontName = DEFAULT_CHART_TITLE_FONT_NAME;
	
	/**
	 * The chart title font style.
	 */
	private static int chartTitleFontStyle = DEFAULT_CHART_TITLE_FONT_STYLE;
	
	/**
	 * The chart title font size.
	 */
	private static int chartTitleFontSize = DEFAULT_CHART_TITLE_FONT_SIZE;
	
	/**
	 * The chart sub title font name.
	 */
	private static String chartSubTitleFontName = DEFAULT_CHART_SUB_TITLE_FONT_NAME;
	
	/**
	 * The chart sub title font style.
	 */
	private static int chartSubTitleFontStyle = DEFAULT_CHART_SUB_TITLE_FONT_STYLE;
	
	/**
	 * The chart sub title font size.
	 */
	private static int chartSubTitleFontSize = DEFAULT_CHART_SUB_TITLE_FONT_SIZE;
	
	/**
	 * The chart label font name.
	 */
	private static String chartLabelFontName = DEFAULT_CHART_LABEL_FONT_NAME;
	
	/**
	 * The chart label font style.
	 */
	private static int chartLabelFontStyle = DEFAULT_CHART_LABEL_FONT_STYLE;
	
	/**
	 * The chart label font size.
	 */
	private static int chartLabelFontSize = DEFAULT_CHART_LABEL_FONT_SIZE;
	
	/**
	 * The chart tick label font name.
	 */
	private static String chartTickLabelFontName = DEFAULT_CHART_TICK_LABEL_FONT_NAME;
	
	/**
	 * The chart tick label font style.
	 */	
	private static int chartTickLabelFontStyle = DEFAULT_CHART_TICK_LABEL_FONT_STYLE;
	
	/**
	 * The chart tick label font size.
	 */		
	private static int chartTickLabelFontSize = DEFAULT_CHART_TICK_LABEL_FONT_SIZE;
	
	/**
	 * The font.
	 */
	private static Font font = new Font(fontName, fontStyle, fontSize);
	
	/**
	 * The chart title font.
	 */
	private static Font chartTitleFont = new Font(chartTitleFontName, chartTitleFontStyle, chartTitleFontSize);
	
	/**
	 * The chart sub title font.
	 */
	private static Font chartSubTitleFont = new Font(chartSubTitleFontName, chartSubTitleFontStyle, chartSubTitleFontSize);
	
	/**
	 * The chart label font.
	 */
	private static Font chartLabelFont = new Font(chartLabelFontName, chartLabelFontStyle, chartLabelFontSize);
	
	/**
	 * The chart tick label font.
	 */
	private static Font chartTickLabelFont = new Font(chartTickLabelFontName, chartTickLabelFontStyle, chartTickLabelFontSize);
	
	/**
	 * Registers the font.
	 * @param fontName the font name string
	 * @param fontStyle the font style value
	 * @param fontSize the font size value
	 */
	public static void registerFont(String fontName, int fontStyle, int fontSize)
	{
		boolean isRetrieved = retrieveFont(fontName);
		if (isRetrieved)
		{
			FontContext.fontName = fontName;
			FontContext.fontStyle = fontStyle;
			FontContext.fontSize = fontSize;
			
			font = new Font(fontName, fontStyle, fontSize);
		}
	}
	
	/**
	 * Registers the chart title font.
	 * @param chartTitleFontName the chart title font name string
	 * @param chartTitleFontStyle the chart title font style value
	 * @param chartTitleFontSize the chart title font size value
	 */
	public static void registerChartTitleFont(String chartTitleFontName, int chartTitleFontStyle, int chartTitleFontSize)
	{
		boolean isRetrieved = retrieveFont(chartTitleFontName);
		if (isRetrieved)
		{
			FontContext.chartTitleFontName = chartTitleFontName;
			FontContext.chartTitleFontStyle = chartTitleFontStyle;
			FontContext.chartTitleFontSize = chartTitleFontSize;
			
			chartTitleFont = new Font(chartTitleFontName, chartTitleFontStyle, chartTitleFontSize);
		}		
	}
	
	/**
	 * Registers the chart sub title font.
	 * @param chartSubTitleFontName the chart sub title font name string
	 * @param chartSubTitleFontStyle the chart sub title font style value
	 * @param chartSubTitleFontSize the chart sub title font size value
	 */
	public static void registerChartSubTitleFont(String chartSubTitleFontName, int chartSubTitleFontStyle, int chartSubTitleFontSize)
	{
		boolean isRetrieved = retrieveFont(chartSubTitleFontName);
		if (isRetrieved)
		{
			FontContext.chartSubTitleFontName = chartSubTitleFontName;
			FontContext.chartSubTitleFontStyle = chartSubTitleFontStyle;
			FontContext.chartSubTitleFontSize = chartSubTitleFontSize;
			
			chartSubTitleFont = new Font(chartSubTitleFontName, chartSubTitleFontStyle, chartSubTitleFontSize);			
		}
	}
	
	/**
	 * Registers the chart label font.
	 * @param chartLabelFontName the chart label font name string
	 * @param chartLabelFontStyle the chart label font style value
	 * @param chartLabelFontSize the chart label font size value
	 */
	public static void registerChartLabelFont(String chartLabelFontName, int chartLabelFontStyle, int chartLabelFontSize)
	{
		boolean isRetrieved = retrieveFont(chartLabelFontName);
		if (isRetrieved)
		{
			FontContext.chartLabelFontName = chartLabelFontName;
			FontContext.chartLabelFontStyle = chartLabelFontStyle;
			FontContext.chartLabelFontSize = chartLabelFontSize;
			
			chartLabelFont = new Font(chartLabelFontName, chartLabelFontStyle, chartLabelFontSize);			
		}
	}
	
	/**
	 * Registers the chart tick label font.
	 * @param chartTickLabelFontName the chart tick label font name
	 * @param chartTickLabelFontStyle the chart tick label font style value
	 * @param chartTickLabelFontSize the chart tick label font size value
	 */
	public static void registerChartTickLabelFont(String chartTickLabelFontName, int chartTickLabelFontStyle, int chartTickLabelFontSize)
	{
		boolean isRetrieved = retrieveFont(chartTickLabelFontName);
		if (isRetrieved)
		{
			FontContext.chartTickLabelFontName = chartTickLabelFontName;
			FontContext.chartTickLabelFontStyle = chartTickLabelFontStyle;
			FontContext.chartTickLabelFontSize = chartTickLabelFontSize;
			
			chartTickLabelFont = new Font(chartTickLabelFontName, chartTickLabelFontStyle, chartTickLabelFontSize);			
		}
	}
	
	/**
	 * Gets the font name.
	 * @return the font name string
	 */
	public static String getFontName()
	{
		return fontName;
	}
	
	/**
	 * Gets the font style.
	 * @return the font style value
	 */
	public static int getFontStyle()
	{
		return fontStyle;
	}
	
	/**
	 * Gets the font size.
	 * @return the font size value
	 */
	public static int getFontSize()
	{
		return fontSize;
	}
	
	/**
	 * Gets the chart title font name.
	 * @return the chart title font name string
	 */
	public static String getChartTitleFontName()
	{
		return chartTitleFontName;
	}
	
	/**
	 * Gets the chart title font style.
	 * @return the chart title font style value
	 */
	public static int getChartTitleFontStyle()
	{
		return chartTitleFontStyle;
	}
	
	/**
	 * Gets the chart title font size.
	 * @return the chart title font size value
	 */
	public static int getChartTitleFontSize()
	{
		return chartTitleFontSize;
	}
	
	/**
	 * Gets the chart sub title font name.
	 * @return the chart sub title font name string
	 */
	public static String getChartSubTitleFontName()
	{
		return chartSubTitleFontName;
	}
	
	/**
	 * Gets the chart sub title font style.
	 * @return the chart sub title font style value
	 */
	public static int getChartSubTitleFontStyle()
	{
		return chartSubTitleFontStyle;
	}
	
	/**
	 * Gets the chart sub title font size.
	 * @return the chart sub title font size value
	 */
	public static int getChartSubTitleFontSize()
	{
		return chartSubTitleFontSize;
	}
	
	/**
	 * Gets the chart label font name.
	 * @return the chart label font name string
	 */
	public static String getChartLabelFontName()
	{
		return chartLabelFontName;
	}
	
	/**
	 * Gets the chart label font style.
	 * @return the chart label font style value
	 */
	public static int getChartLabelFontStyle()
	{
		return chartLabelFontStyle;
	}
	
	/**
	 * Gets the chart label font size.
	 * @return the chart label font size value
	 */
	public static int getChartLabelFontSize()
	{
		return chartLabelFontSize;
	}
	
	/**
	 * Gets the chart tick label font name.
	 * @return the chart tick label font name string
	 */
	public static String getChartTickLabelFontName()
	{
		return chartTickLabelFontName;
	}
	
	/**
	 * Gets the chart tick label font style.
	 * @return the chart tick label font style value
	 */
	public static int getChartTickLabelFontStyle()
	{
		return chartTickLabelFontStyle;
	}
	
	/**
	 * Gets the chart tick label font size.
	 * @return the chart tick label font size value
	 */
	public static int getChartTickLabelFontSize()
	{
		return chartTickLabelFontSize;
	}
		
	/**
	 * Gets the font.
	 * @return the font
	 */
	public static Font getFont()
	{		
		return font;
	}
	
	/**
	 * Gets the chart title font.
	 * @return the chart title font
	 */
	public static Font getChartTitleFont()
	{		
		return chartTitleFont;
	}
	
	/**
	 * Gets the chart sub title font.
	 * @return the chart sub title font
	 */
	public static Font getChartSubTitleFont()
	{		
		return chartSubTitleFont;
	}
	
	/**
	 * Gets the chart label font.
	 * @return the chart label font
	 */
	public static Font getChartLabelFont()
	{
		return chartLabelFont;
	}
	
	/**
	 * Gets the chart tick label font.
	 * @return the chart tick label font
	 */
	public static Font getChartTickLabelFont()
	{		
		return chartTickLabelFont;
	}
	
	/**
	 * Retrieves the font by a font name.
	 * @param fontName the font name string
	 * @return true if the font is existed
	 */
	public static boolean retrieveFont(String fontName)
	{		                                   
		String[] availableFontFamilyNames = FontManager.getAvailableFontFamilyNames();
		for (int i = 0; i < availableFontFamilyNames.length; i++)
		{
			if (availableFontFamilyNames[i].equals(fontName))
			{
				return true;
			}	
		}	
		
		return false;
	}	
}