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

import java.awt.Component;

import netscape.javascript.JSObject;

import com.nepxion.swing.handle.HandleManager;

public class AppletXManager
{
	/**
	 * Calls the web application in applet by an url.
	 * The web application is InternetExplorer, FireFox etc.
	 * @param component the instance of Component who's top component is JApplet
	 * @param url the url string
	 * @throws Exception
	 */	
	public static void callWeb(Component component, String url)
		throws Exception
	{
		url = url.replace("\\", "/");
		callJavaScript(component, "window.open('" + url + "')");
	}
	
	/**
	 * Calls the Word application of Windows Office in applet by a file path.
	 * @param component the instance of Component who's top component is JApplet
	 * @param filePath the file path
	 * @param readOnly the boolean value of readOnly
	 * @throws Exception
	 */	
	public static void callWord(Component component, String filePath, boolean readOnly)
		throws Exception
	{
		filePath = filePath.replace("\\", "/");
		callJavaScript(component, "showWord('" + filePath + "', " + readOnly + ")");
	}
	
	/**
	 * Calls the Excel application of Windows Office in applet by a file path.
	 * @param component the instance of Component who's top component is JApplet
	 * @param filePath the file path
	 * @param readOnly the boolean value of readOnly
	 * @throws Exception
	 */	
	public static void callExcel(Component component, String filePath, boolean readOnly)
		throws Exception
	{
		filePath = filePath.replace("\\", "/");
		callJavaScript(component, "showExcel('" + filePath + "', " + readOnly + ")");
	}
	
	/**
	 * Calls the PowerPoint application of Windows Office in applet by a file path.
	 * @param component the instance of Component who's top component is JApplet
	 * @param filePath the file path
	 * @param readOnly the boolean value of readOnly
	 * @param fullScreen the boolean value of fullScreen
	 * @throws Exception
	 */
	public static void callPowerPoint(Component component, String filePath, boolean readOnly, boolean fullScreen)
		throws Exception
	{
		filePath = filePath.replace("\\", "/");
		callJavaScript(component, "showPowerPoint('" + filePath + "', " + readOnly + ", " + fullScreen + ")");
	}
	
	/**
	 * Calls the javascript in applet.
	 * @param component the instance of Component who's top component is JApplet 
	 * @param javascript the javascript code
	 * @throws Exception
	 */
	public static void callJavaScript(Component component, String javascript)
		throws Exception
	{
		JSObject.getWindow(HandleManager.getApplet(component)).eval(javascript);
	}
}