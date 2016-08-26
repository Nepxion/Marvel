package com.nepxion.util.net.http;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.util.servlet.ServletConstants;

public interface HttpConstants
	extends ServletConstants
{
	/**
	 * The path of config file for "http.properties".
	 */
	public static final String CONFIG_FILE_PATH = "conf/http.properties";
	
	/**
	 * The prefix string.
	 */
	public static final String PREFIX = "http";
	
	/**
	 * The dot string.
	 */
	public static final String DOT = ".";
	
	/**
	 * The default alias string.
	 */
	public static final String DEFAULT_ALIAS = "DefaultHttp";
	
	/**
	 * The default connection timeout value.
	 */
	public static final int DEFAULT_CONNECTION_TIMEOUT = 0;
	
	/**
	 * The default response timeout value.
	 */
	public static final int DEFAULT_RESPONSE_TIMEOUT = 0;
	
	/**
	 * The default buffer size value.
	 */
	public static final int DEFAULT_BUFFER_SIZE = 8192;
	
	/**
	 * The alias string.
	 * A alias is corresponding to a http config.
	 * The alias value is configured in http.properties.
	 */
	public static final String ALIAS = "alias";
	
	/**
	 * The host string.
	 * The host value is configured in http.properties.
	 */
	public static final String HOST = "host";
	
	/**
	 * The port sting.
	 * The port value is configured in http.properties.
	 */
	public static final String PORT = "port";
	
	/**
	 * The path string.
	 * The path value is the servlet url-pattern of the servlet-mapping in web.xml.
	 * The path value is configured in http.properties.
	 */
	public static final String PATH = "path";
	
	/**
	 * The connection timeout string.
	 * It defines the timeout millisecond for client connection and it can't be out of the timeout millisecond.
	 * For example : if the server is not published or shut down and the client can't get data in the timeout period, an exception will be thrown out. 
	 * The connection timeout value is configured in http.properties. 
	 */
	public static final String CONNECTION_TIMEOUT = "connection-timeout";
	
	/**
	 * The response timeout string.
	 * It defines the timeout millisecond for server response and it can't be out of the timeout millisecond.
	 * For example : if the server receives the request of the client and can't return data in the timeout period, an exception will be thrown out.
	 * The response timeout value is configured in http.properties. 
	 */
	public static final String RESPONSE_TIMEOUT = "response-timeout";
	
	/**
	 * The buffer size string.
	 * It defines the size of io buffer and the object which is sent from client to server can't be out of the size.
	 * The buffer value is configured in http.properties.
	 */
	public static final String BUFFER_SIZE = "buffer-size";
}