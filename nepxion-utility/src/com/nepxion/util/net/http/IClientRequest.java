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

import java.net.URI;

public interface IClientRequest
	extends HttpConstants
{			
	/**
	 * Gets the http config object.
	 * @return the instance of HttpConfig
	 */
	public HttpConfig getHttpConfig();
	
	/**
	 * Sets the http config object.
	 * @param httpConfig the instance of HttpConfig
	 */
	public void setHttpConfig(HttpConfig httpConfig);
	
	/**
	 * Gets the uri object.
	 * @return the instance of URI
	 */
	public URI getURI();
	
	/**
	 * Sets the uri object.
	 * @param uri the instance of URI
	 */
	public void setURI(URI uri);
	
	/**
	 * Gets the url parameter string.
	 * @return the url parameter string
	 */
	public String getURLParameter();
	
	/**
	 * Aborts the client invoker.
	 */
	public void abort();
}