package com.nepxion.util.jni;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class JacobUtil
{
	/**
	 * Calls the Internet Explorer with Jacob activeX by an url.
	 * @param url the url string
	 * @throws Exception
	 */
	public static void callInternetExplorer(String url)
		throws Exception
	{
		ActiveXComponent internetExplorer = null;
		try
		{
			internetExplorer = new ActiveXComponent("InternetExplorer.Application");
			internetExplorer.setProperty("Visible", new Variant(true));
			internetExplorer.setProperty("AddressBar", new Variant(true));
			internetExplorer.setProperty("StatusText", new Variant("Nepxion"));
			
			Dispatch.call(internetExplorer.getObject(), "Navigate", new Variant(url));
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			if (internetExplorer != null)
			{
				internetExplorer = null;
			}
			ComThread.Release();
		}
	}
	
	/**
	 * Calls the Word application of Windows Office with Jacob activeX by a file path.
	 * @param filePath the file path
	 * @param readOnly the boolean value of readOnly
	 * @throws Exception
	 */
	public static void callWord(String filePath, boolean readOnly)
		throws Exception
	{
		ActiveXComponent word = null;
		try
		{
			word = new ActiveXComponent("Word.Application");
			word.setProperty("Visible", new Variant(true));
			
			Dispatch documents = word.getProperty("Documents").toDispatch();
			Dispatch.invoke(documents, "Open", Dispatch.Method, new Object[] {filePath, new Variant(true), new Variant(readOnly)}, new int[1]).toDispatch();
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			if (word != null)
			{
				word = null;
			}
			ComThread.Release();
		}
	}
	
	/**
	 * Calls the Excel application of Windows Office with Jacob activeX by a file path.
	 * @param filePath the file path
	 * @param readOnly the boolean value of readOnly
	 * @throws Exception
	 */
	public static void callExcel(String filePath, boolean readOnly)
		throws Exception
	{
		ActiveXComponent excel = null;
		try
		{
			excel = new ActiveXComponent("Excel.Application");
			excel.setProperty("Visible", new Variant(true));
			
			Dispatch workbooks = excel.getProperty("Workbooks").toDispatch();
			Dispatch.invoke(workbooks, "Open", Dispatch.Method, new Object[] {filePath, new Variant(true), new Variant(readOnly)}, new int[1]).toDispatch();
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			if (excel != null)
			{
				excel = null;
			}
			ComThread.Release();
		}
	}
	
	/**
	 * Calls the PowerPoint application of Windows Office with Jacob activeX by a file path.
	 * @param filePath the file path
	 * @param readOnly the boolean value of readOnly
	 * @param fullScreen the boolean value of fullScreen
	 * @throws Exception
	 */
	public static void callPowerPoint(String filePath, boolean readOnly, boolean fullScreen)
		throws Exception
	{
		ActiveXComponent powerPoint = null;
		try
		{
			powerPoint = new ActiveXComponent("PowerPoint.Application");
			powerPoint.setProperty("Visible", new Variant(true));
			
			ActiveXComponent presentations = powerPoint.getPropertyAsComponent("Presentations");
			ActiveXComponent presentation = presentations.invokeGetComponent("Open", new Variant(filePath), new Variant(readOnly));
			
			if (fullScreen)
			{
				ActiveXComponent slideShowSettings = presentation.getPropertyAsComponent("SlideShowSettings");
				slideShowSettings.invoke("Run");
			}
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			if (powerPoint != null)
			{
				powerPoint = null;
			}
			ComThread.Release();
		}
	}
	
	/**
	 * Transforms the Word file to the Html file with Jacob activeX.
	 * @param wordFilePath the word file path
	 * @param htmlFilePath the html file path
	 * @throws Exception
	 */
	public static void transformWordToHtml(String wordFilePath, String htmlFilePath)
		throws Exception
	{
		ActiveXComponent word = null;
		try
		{
			word = new ActiveXComponent("Word.Application");
			word.setProperty("Visible", new Variant(false));
			
			Dispatch documents = word.getProperty("Documents").toDispatch();
			Dispatch document = Dispatch.invoke(documents, "Open", Dispatch.Method, new Object[] {wordFilePath, new Variant(true), new Variant(false)}, new int[1]).toDispatch();
			Dispatch.invoke(document, "SaveAs", Dispatch.Method, new Object[] {htmlFilePath, new Variant(8)}, new int[1]);
			Dispatch.call(document, "Close", new Variant(false));
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			if (word != null)
			{
				word.invoke("Quit", new Variant[] {});
				word = null;
			}
			ComThread.Release();
		}
	}
	
	/**
	 * Transforms the Excel file to the Html file with Jacob activeX.
	 * @param excelFilePath the excel file path
	 * @param htmlFilePath the html file path
	 * @throws Exception
	 */
	public static void transformExcelToHtml(String excelFilePath, String htmlFilePath)
		throws Exception
	{
		ActiveXComponent excel = null;
		try
		{
			excel = new ActiveXComponent("Excel.Application");
			excel.setProperty("Visible", new Variant(false));
			
			Dispatch workbooks = excel.getProperty("Workbooks").toDispatch();
			Dispatch workbook = Dispatch.invoke(workbooks, "Open", Dispatch.Method, new Object[] {excelFilePath, new Variant(true), new Variant(false)}, new int[1]).toDispatch();
			Dispatch.invoke(workbook, "SaveAs", Dispatch.Method, new Object[] {htmlFilePath, new Variant(44)}, new int[1]);
			Dispatch.call(workbook, "Close", new Variant(false));
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			if (excel != null)
			{
				excel.invoke("Quit", new Variant[] {});
				excel = null;
			}
			ComThread.Release();
		}
	}
}