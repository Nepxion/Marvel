package com.nepxion.swing.activex;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.util.jni.JacobUtil;

public class ApplicationXManager
{
	/**
	 * Calls the Internet Explorer in application by an url.
	 * @param url the url string
	 * @throws Exception
	 */
	public static void callInternetExplorer(String url)
		throws Exception
	{
		JacobUtil.callInternetExplorer(url);
	}
	
	/**
	 * Calls the Word application of Windows Office in application by a file path.
	 * @param filePath the file path
	 * @param readOnly the boolean value of readOnly
	 * @throws Exception
	 */
	public static void callWord(String filePath, boolean readOnly)
		throws Exception
	{
		JacobUtil.callWord(filePath, readOnly);
	}
	
	/**
	 * Calls the Excel application of Windows Office in application by a file path.
	 * @param filePath the file path
	 * @param readOnly the boolean value of readOnly
	 * @throws Exception
	 */
	public static void callExcel(String filePath, boolean readOnly)
		throws Exception
	{
		JacobUtil.callExcel(filePath, readOnly);
	}
	
	/**
	 * Calls the PowerPoint application of Windows Office in application by a file path.
	 * @param filePath the file path
	 * @param readOnly the boolean value of readOnly
	 * @param fullScreen the boolean value of fullScreen
	 * @throws Exception
	 */
	public static void callPowerPoint(String filePath, boolean readOnly, boolean fullScreen)
		throws Exception
	{
		JacobUtil.callPowerPoint(filePath, readOnly, fullScreen);
	}
	
	/**
	 * Transforms the Word file to the Html file in application.
	 * @param wordFilePath the word file path
	 * @param htmlFilePath the html file path
	 * @throws Exception
	 */
	public static void transformWordToHtml(String wordFilePath, String htmlFilePath)
		throws Exception
	{
		JacobUtil.transformWordToHtml(wordFilePath, htmlFilePath);
	}
	
	/**
	 * Transforms the Excel file to the Html file in application.
	 * @param excelFilePath the excel file path
	 * @param htmlFilePath the html file path
	 * @throws Exception
	 */
	public static void transformExcelToHtml(String excelFilePath, String htmlFilePath)
		throws Exception
	{
		JacobUtil.transformWordToHtml(excelFilePath, htmlFilePath);
	}
}