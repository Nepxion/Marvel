package com.nepxion.util.context;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.net.URL;
import java.util.Properties;

import com.nepxion.util.database.pool.proxool.ProxoolContext;
import com.nepxion.util.encoder.EncoderContext;
import com.nepxion.util.io.FileContext;
import com.nepxion.util.locale.LocaleContext;
import com.nepxion.util.log.LoggerContext;
import com.nepxion.util.net.http.HttpContext;
import com.nepxion.util.net.url.URLContext;
import com.nepxion.util.scheduler.quartz.QuartzContext;
import com.nepxion.util.searcher.ip.local.IPContext;
import com.nepxion.util.searcher.zone.local.ZoneConstants;

public class ContextRegister
	extends AbstractContextRegister implements ContextConstants
{
	/**
	 * The instance of Properties.
	 */
	protected Properties properties;
	
	/**
	 * The instance of URL.
	 */
	protected URL codeBase;
	
	/**
	 * Registers the context by a properties of context file.
	 * The context file is a native file.
	 * @param properties the instance of Properties
	 */
	public void initializeContext(Properties properties)
	{
		initializeContext(null, properties);
	}
	
	/**
	 * Registers the context by an url and properties of context file.
	 * The context file is a remote file.
	 * @param codeBase the instance of URL
	 * @param properties the instance of Properties
	 */
	public void initializeContext(URL codeBase, Properties properties)
	{
		this.properties = properties;
		this.codeBase = codeBase;
		
		initEncoder();
		initLocale();
		initLogger();
		initHttp();
		initURL();
		initDBConnectionPool();
		initScheduler();
		initIp();
		initZone();
	}
	
	/**
	 * Initialize the encoder config.
	 * The encoder values are configured in data.properties.
	 * The encoder config includes the io charset and http charset.
	 */
	private void initEncoder()
	{
		String ioCharset = properties.getProperty("ioCharset");
		if (isValid(ioCharset))
		{
			EncoderContext.registerIOCharset(ioCharset);
		}
		
		String httpCharset = properties.getProperty("httpCharset");
		if (isValid(httpCharset))
		{
			EncoderContext.registerHttpCharset(httpCharset);
		}
	}
	
	/**
	 * Initialize the locale config.
	 * The locale value is configured in data.properties.
	 */
	private void initLocale()
	{
		String locale = properties.getProperty("locale");
		if (isValid(locale))
		{
			LocaleContext.registerLocale(locale);
		}
	}
	
	/**
	 * Initialize the logger config.
	 * Currently the logger config is applied for Apache Log4J.
	 * The logger value is configured in data.properties.
	 * If the value of boolean is false, the logger function will be disabled.
	 */
	private void initLogger()
	{
		String loggerEnabled = properties.getProperty("logger-3rd-enabled");
		
		boolean isLoggerEnabled = false;
		
		if (isValid(loggerEnabled))
		{
			isLoggerEnabled = loggerEnabled.equals("true");
		}
		
		if (isLoggerEnabled)
		{
			try
			{
				if (codeBase == null)
				{
					LoggerContext.register();
				}
				else
				{
					LoggerContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Initialize the http config.
	 * Currently the http config is applied for Apache HttpComponent.
	 * The http values are configured in data.properties.
	 * If the value of boolean is false, the http function will be disabled.
	 */
	private void initHttp()
	{
		String httpEnabled = properties.getProperty("http-3rd-enabled");
		
		boolean isHttpEnabled = false;
		
		if (isValid(httpEnabled))
		{
			isHttpEnabled = httpEnabled.equals("true");
		}
		
		if (isHttpEnabled)
		{
			try
			{
				if (codeBase == null)
				{
					HttpContext.register();
				}
				else
				{
					HttpContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Initialize the url config.
	 * The url value is configured in data.properties.
	 * If the value of boolean is false, the url function will be disabled.
	 */
	private void initURL()
	{
		String urlEnabled = properties.getProperty("url-3rd-enabled");
		
		boolean isURLEnabled = false;
		
		if (isValid(urlEnabled))
		{
			isURLEnabled = urlEnabled.equals("true");
		}
		
		if (isURLEnabled)
		{
			try
			{
				if (codeBase == null)
				{
					URLContext.register();
				}
				else
				{
					URLContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Initialize the database connection pool config.
	 * Currently the database connection pool config is applied for Proxool.
	 * The database connection pool value is configured in data.properties.
	 * If the value of boolean is false, the database connection pool function will be disabled.
	 */
	private void initDBConnectionPool()
	{
		String dbConnectionPoolEnabled = properties.getProperty("dbConnectionPool-3rd-enabled");
		
		boolean isDBConnectionPoolEnabled = false;
		
		if (isValid(dbConnectionPoolEnabled))
		{
			isDBConnectionPoolEnabled = dbConnectionPoolEnabled.equals("true");
		}
		
		if (isDBConnectionPoolEnabled)
		{
			try
			{
				if (codeBase == null)
				{
					ProxoolContext.register();
				}
				else
				{
					ProxoolContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Initialize the scheduler config.
	 * Currently the scheduler config is applied for Quartz.
	 * The scheduler value is configured in data.properties.
	 * If the value of boolean is false, the scheduler function will be disabled.
	 */
	private void initScheduler()
	{
		String schedulerEnabled = properties.getProperty("scheduler-3rd-enabled");
		
		boolean isSchedulerEnabled = false;
		
		if (isValid(schedulerEnabled))
		{
			isSchedulerEnabled = schedulerEnabled.equals("true");
		}
		
		if (isSchedulerEnabled)
		{
			try
			{
				if (codeBase == null)
				{
					QuartzContext.register();
				}
				else
				{
					QuartzContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Initialize the ip config.
	 * The ip value is configured in data.properties.
	 * If the value of boolean is false, the ip function will be disabled.
	 */
	private void initIp()
	{
		String ipEnabled = properties.getProperty("ip-3rd-enabled");
		
		boolean isIpEnabled = false;
		
		if (isValid(ipEnabled))
		{
			isIpEnabled = ipEnabled.equals("true");
		}
		
		if (isIpEnabled)
		{
			try
			{
				if (codeBase == null)
				{
					IPContext.register();
				}
				else
				{
					IPContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Initialize the zone config.
	 * The zone value is configured in data.properties.
	 * If the value of boolean is false, the zone function will be disabled.
	 */
	private void initZone()
	{
		String zoneEnabled = properties.getProperty("zone-3rd-enabled");
		
		boolean isZoneEnabled = false;
		
		if (isValid(zoneEnabled))
		{
			isZoneEnabled = zoneEnabled.equals("true");
		}
		
		if (isZoneEnabled)
		{
			try
			{
				if (codeBase == null)
				{
					FileContext.register(ZoneConstants.CONFIG_FILE_PATH);
				}
				else
				{
					FileContext.register(codeBase, ZoneConstants.CONFIG_FILE_PATH);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Returns true if the content valid.
	 * @param content the string
	 * @return true if the content valid
	 */
	public boolean isValid(String content)
	{
		return content != null && !content.trim().equals("");
	}
}