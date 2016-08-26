package com.nepxion.util.net.url;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.io.Serializable;

public interface URLConstants
	extends Serializable
{
	/**
	 * The path of config file for "url.properties".
	 */
	public static final String CONFIG_FILE_PATH = "conf/url.properties";
	
	/**
	 * The prefix string.
	 */
	public static final String PREFIX = "url";
	
	/**
	 * The dot string.
	 */
	public static final String DOT = ".";
	
	/**
	 * The alias string.
	 * A alias is corresponding to a url config.
	 * The alias value is configured in url.properties.
	 */
	public static final String ALIAS = "alias";
	
	/**
	 * The host string.
	 * The host value is configured in url.properties.
	 */
	public static final String HOST = "host";
	
	/**
	 * The port sting.
	 * The port value is configured in url.properties.
	 */
	public static final String PORT = "port";
	
	/**
	 * The path string.
	 * The path value is configured in url.properties.
	 */
	public static final String PATH = "path";
}