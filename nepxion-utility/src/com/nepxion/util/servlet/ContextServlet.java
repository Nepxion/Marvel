package com.nepxion.util.servlet;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.nepxion.util.database.pool.proxool.ProxoolContext;
import com.nepxion.util.log.LoggerContext;
import com.nepxion.util.scheduler.quartz.QuartzContext;

public class ContextServlet
	extends HttpServlet
{
	/**
	 * Initializes the servlet context.
	 * It is overridden from HttpServlet
	 * @param config the instance of ServletConfig
	 */
	public void init(ServletConfig config)
		throws ServletException
	{
		super.init(config);
		
		initLogger();
		initProxool();
		initQuartz();
	}
	
	/**
	 * Initializes the logger context.
	 * If the logger path isn't configured in web.xml in the web server, the logger context won't be initialized.
	 */
	private void initLogger()
	{
		String loggerPath = getInitParameter("loggerPath");
		if (loggerPath != null)
		{
			loggerPath = getServletContext().getRealPath(loggerPath);
			
			Properties properties = new Properties();
			
			InputStream inputStream = null;
			try
			{
				inputStream = new FileInputStream(loggerPath);
				properties.load(inputStream);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if (inputStream != null)
				{
					try
					{
						inputStream.close();
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}	
			}
			
			loggerPath = loggerPath.substring(0, loggerPath.lastIndexOf("\\") + 1);
			
			properties.setProperty("log4j.appender.FileAppender.File", loggerPath + properties.getProperty("log4j.appender.FileAppender.File"));
			properties.setProperty("log4j.appender.RollingFileAppender.File", loggerPath + properties.getProperty("log4j.appender.RollingFileAppender.File"));
			
			initServiceLogger(properties, loggerPath);
			
			try
			{
				LoggerContext.register(properties);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Initializes the service logger context.
	 * If it is overridden by the child class, the method will be executed. 
	 * @param properties the instance of Properties.It will be registered to LoggerContext 
	 * @param loggerPath the logger file path.It is configured in web.xml in the web server
	 */
	public void initServiceLogger(Properties properties, String loggerPath)
	{
		
	}
	
	/**
	 * Initializes the proxool context.
	 * If the Proxool path isn't configured in web.xml in the web server, the Proxool context won't be initialized.
	 */
	private void initProxool()
	{
		String proxoolPath = getInitParameter("proxoolPath");
		if (proxoolPath != null)
		{
			proxoolPath = getServletContext().getRealPath(proxoolPath);
			try
			{
				ProxoolContext.register(proxoolPath);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Initializes the quartz context.
	 * If the quartz path isn't configured in web.xml in the web server, the quartz context won't be initialized.
	 */
	private void initQuartz()
	{
		String quartzPath = getInitParameter("quartzPath");
		if (quartzPath != null)
		{
			quartzPath = getServletContext().getRealPath(quartzPath);
			try
			{
				QuartzContext.register(quartzPath);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}