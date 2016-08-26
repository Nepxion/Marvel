package com.nepxion.swing.context;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.net.URL;
import java.util.Properties;

import com.nepxion.swing.activex.ActiveXConstants;
import com.nepxion.swing.activex.ActiveXContext;
import com.nepxion.swing.exception.ExceptionTracerContext;
import com.nepxion.swing.framework.ribbon.xml.Dom4JRibbonConstants;
import com.nepxion.util.context.ContextRegister;
import com.nepxion.util.io.FileContext;

public class DataContextRegister
	extends ContextRegister implements DataContextConstants
{		
	/**
	 * Registers the context by an url and properties of context file.
	 * The context file is a remote file.
	 * @param codeBase the instance of URL
	 * @param properties the instance of Properties
	 */
	public void initializeContext(URL codeBase, Properties properties)
	{
		super.initializeContext(codeBase, properties);
		
		initActiveX();
		initRibbon();
		initException();
	}
	
	/**
	 * Initialize for the activeX config.
	 * The activeX value is configured in data.properties.
	 * If the value of boolean is false, the activeX function will be disabled.
	 */
	private void initActiveX()
	{
		String activeXEnabled = properties.getProperty("activeX-3rd-enabled");
		
		boolean isActiveXEnabled = false;
		
		if (isValid(activeXEnabled))
		{
			isActiveXEnabled = activeXEnabled.equals("true");
		}
		
		if (isActiveXEnabled)
		{	
			if (codeBase == null)
			{
				ActiveXContext.registerStrategy(ActiveXConstants.STRATEGY_APPLICATION);	
			}	
			else
			{
				ActiveXContext.registerStrategy(ActiveXConstants.STRATEGY_APPLET);
			}
		}
	}
	
	/**
	 * Initialize for the ribbon config.
	 * The ribbon value is configured in data.properties.
	 * If the value of boolean is false, the ribbon function will be disabled.
	 */
	private void initRibbon()
	{
		String ribbonEnabled = properties.getProperty("ribbon-3rd-enabled");
		
		boolean isRibbonEnabled = false;
		
		if (isValid(ribbonEnabled))
		{
			isRibbonEnabled = ribbonEnabled.equals("true");
		}
		
		if (isRibbonEnabled)
		{	
			try
			{
				if (codeBase == null)
				{
					FileContext.register(Dom4JRibbonConstants.CONFIG_FILE_PATH);
				}	
				else
				{
					FileContext.register(codeBase, Dom4JRibbonConstants.CONFIG_FILE_PATH);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Initialize for the exception print config.
	 * The exception print value is configured in data.properties.
	 * If the value of boolean is false, it will show exception on JOptionPane, otherwise on JExceptionDialog particularly.
	 * It isn't a good idea for the user to see the exception detail information, so you can disable exception debug. 
	 */
	private void initException()
	{
		String exceptionDebugEnabled = properties.getProperty("exception-debug-enabled");
		
		boolean isExceptionDebugEnabled = false;
		
		if (isValid(exceptionDebugEnabled))
		{
			isExceptionDebugEnabled = exceptionDebugEnabled.equals("true");
		}
		
		ExceptionTracerContext.register(isExceptionDebugEnabled);
	}
}