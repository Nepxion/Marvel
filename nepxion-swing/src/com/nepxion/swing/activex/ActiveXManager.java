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

import com.nepxion.swing.applet.JBasicApplet;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.util.jni.ApplicationUtil;
import com.nepxion.util.net.url.URLConfig;

public class ActiveXManager
	implements ActiveXConstants
{
	/**
	 * Calls the web application by an url config.
	 * The web application is InternetExplorer, FireFox etc.
	 * The calling in application or applet depends on the strategy in ActiveXContext.
	 * @param component the instance of Component who's top component is JFrame or JApplet
	 * @param urlConfig the instance of URLConfig
	 * @throws Exception
	 */
	public static void callWeb(Component component, URLConfig urlConfig)
		throws Exception
	{
		String url = "";
		
		String host = urlConfig.getHost();
		if (host != null && !host.equals(""))
		{
			url = urlConfig.toURL();
		}
		else
		{
			JBasicApplet applet = (JBasicApplet) HandleManager.getApplet(component);
			
			url = "http://" + applet != null ? applet.getHost() : "localhost" + ":" + urlConfig.getPort() + urlConfig.getPath();
		}

		ActiveXManager.callWeb(component, url);
	}
	
	/**
	 * Calls the web application by an url.
	 * The web application is InternetExplorer, FireFox etc.
	 * The calling in application or applet depends on the strategy in ActiveXContext.
	 * @param component the instance of Component who's top component is JFrame or JApplet
	 * @param url the url string
	 * @throws Exception
	 */
	public static void callWeb(Component component, String url)
		throws Exception
	{
		/*if (ActiveXContext.getStrategy() == ActiveXContext.STRATEGY_APPLICATION)
		{
			ApplicationXManager.callInternetExplorer(url);
		}
		else if (ActiveXContext.getStrategy() == ActiveXContext.STRATEGY_APPLET)
		{
			AppletXManager.callWeb(component, url);
		}*/
		ApplicationUtil.callApplication(url);
	}
	
	/**
	 * Calls the Word application of Windows Office by a file path.
	 * The calling in application or applet depends on the strategy in ActiveXContext.
	 * @param component the instance of Component who's top component is JFrame or JApplet
	 * @param filePath the file path
	 * @param readOnly the boolean value of readOnly
	 * @throws Exception
	 */
	public static void callWord(Component component, String filePath, boolean readOnly)
		throws Exception
	{
		if (ActiveXContext.getStrategy() == STRATEGY_APPLICATION)
		{
			ApplicationXManager.callWord(filePath, readOnly);
		}
		else if (ActiveXContext.getStrategy() == STRATEGY_APPLET)
		{
			AppletXManager.callWord(component, filePath, readOnly);
		}
	}
	
	/**
	 * Calls the Excel application of Windows Office by a file path.
	 * The calling in application or applet depends on the strategy in ActiveXContext.
	 * @param component the instance of Component who's top component is JFrame or JApplet
	 * @param filePath the file path
	 * @param readOnly the boolean value of readOnly
	 * @throws Exception
	 */
	public static void callExcel(Component component, String filePath, boolean readOnly)
		throws Exception
	{
		if (ActiveXContext.getStrategy() == STRATEGY_APPLICATION)
		{
			ApplicationXManager.callExcel(filePath, readOnly);
		}
		else if (ActiveXContext.getStrategy() == STRATEGY_APPLET)
		{
			AppletXManager.callExcel(component, filePath, readOnly);
		}
	}
	
	/**
	 * Calls the PowerPoint application of Windows Office by a file path.
	 * The calling in application or applet depends on the strategy in ActiveXContext.
	 * @param component the instance of Component who's top component is JFrame or JApplet
	 * @param filePath the file path
	 * @param readOnly the boolean value of readOnly
	 * @param fullScreen the boolean value of fullScreen
	 * @throws Exception
	 */
	public static void callPowerPoint(Component component, String filePath, boolean readOnly, boolean fullScreen)
		throws Exception
	{
		if (ActiveXContext.getStrategy() == STRATEGY_APPLICATION)
		{
			ApplicationXManager.callPowerPoint(filePath, readOnly, fullScreen);
		}
		else if (ActiveXContext.getStrategy() == STRATEGY_APPLET)
		{
			AppletXManager.callPowerPoint(component, filePath, readOnly, fullScreen);
		}
	}
}