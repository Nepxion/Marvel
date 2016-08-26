package com.nepxion.util.database.pool.proxool;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

public interface ProxoolConstants
{
	/**
	 * The path of config file for "proxool.properties".
	 */
	public static final String CONFIG_FILE_PATH = "conf/proxool.properties";
	
	/**
	 * The connection pool driver for proxool.
	 */
	public static final String PROXOOL_DRIVER = "org.logicalcobwebs.proxool.ProxoolDriver";
	
	/**
	 * The prefix for proxool.
	 */
	public static final String PREFIX = "proxool.";
	
	/**
	 * The default alias for connection.
	 */
	public static final String DEFAULT_ALIAS = "DefaultProxool";
}