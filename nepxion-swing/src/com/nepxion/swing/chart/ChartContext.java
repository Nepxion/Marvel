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

public class ChartContext
	implements ChartConstants
{	
	/**
	 * The author String of the chart pdf file.
	 */
	private static String chartPDFAuthor = DEFAULT_CHART_PDF_AUTHOR;
	
	/**
	 * The subject string of the chart pdf file.
	 */
	private static String chartPDFSubject = DEFAULT_CHART_PDF_SUBJECT;
	
	/**
	 * Registers the author for the chart pdf file.
	 * @param chartPDFAuthor the chart pdf author string
	 */
	public static void registerChartPDFAuthor(String chartPDFAuthor)
	{
		ChartContext.chartPDFAuthor = chartPDFAuthor;
	}
	
	/**
	 * Gets the author for the chart pdf file. 
	 * @return the author for the chart pdf file.
	 */
	public static String getChartPDFAuthor()
	{
		return chartPDFAuthor;
	}
	
	/**
	 * Registers the subject for the chart pdf file.
	 * @param chartPDFAuthor the chart pdf subject string
	 */
	public static void registerChartPDFSubject(String chartPDFSubject)
	{
		ChartContext.chartPDFSubject = chartPDFSubject;
	}
	
	/**
	 * Gets the subject for the chart pdf file.
	 * @return the subject for the chart pdf file
	 */
	public static String getChartPDFSubject()
	{
		return chartPDFSubject;
	}
}