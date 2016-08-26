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

public class HttpConfig
	implements HttpConstants
{
	private static final long serialVersionUID = -7078182861655615084L;

	/**
	 * The alias string.
	 */
	private String alias;
	
	/**
	 * The host string.
	 */
	private String host;
	
	/**
	 * The port value.
	 */
	private int port = 0;
	
	/**
	 * The path string.
	 */
	private String path;
	
	/**
	 * The connection timeout value.
	 */
	private int connectionTimeOut = DEFAULT_CONNECTION_TIMEOUT;
	
	/**
	 * The response timeout value.
	 */
	private int responseTimeOut = DEFAULT_RESPONSE_TIMEOUT;
	
	/**
	 * The buffer size value.
	 */
	private int bufferSize = DEFAULT_BUFFER_SIZE;
	
	/**
	 * Constructs with the default.
	 */
	public HttpConfig()
	{
		
	}
	
	/**
	 * Gets the alias.
	 * @return the alias string
	 */
	public String getAlias()
	{
		return alias;
	}
	
	/**
	 * Sets the alias.
	 * @param alias the alias string
	 */
	public void setAlias(String alias)
	{
		this.alias = alias;
	}
	
	/**
	 * Gets the host.
	 * @return the host String
	 */
	public String getHost()
	{
		return host;
	}
	
	/**
	 * Sets the host.
	 * @param host the host String
	 */
	public void setHost(String host)
	{
		this.host = host;
	}
	
	/**
	 * Gets the port.
	 * @return the port value
	 */
	public int getPort()
	{
		return port;
	}
	
	/**
	 * Sets the port.
	 * @param port the port value
	 */
	public void setPort(int port)
	{
		this.port = port;
	}
	
	/**
	 * Gets the path.
	 * @return the path string
	 */
	public String getPath()
	{
		return path;
	}
	
	/**
	 * Sets the path.
	 * @param path the path string
	 */
	public void setPath(String path)
	{
		this.path = path;
	}
	
	/**
	 * Gets the connection timeout.
	 * @return the connection timeout value
	 */
	public int getConnectionTimeOut()
	{
		return connectionTimeOut;
	}
	
	/**
	 * Sets the connection timeout.
	 * @param connectionTimeOut the connection timeout value
	 */
	public void setConnectionTimeOut(int connectionTimeOut)
	{
		this.connectionTimeOut = connectionTimeOut;
	}
	
	/**
	 * Gets the response timeout.
	 * @return the response timeout value
	 */
	public int getResponseTimeOut()
	{
		return responseTimeOut;
	}
	
	/**
	 * Sets the response timeout.
	 * @param responseTimeOut the response timeout value
	 */
	public void setResponseTimeOut(int responseTimeOut)
	{
		this.responseTimeOut = responseTimeOut;
	}
	
	/**
	 * Gets the buffer size.
	 * @return the buffer size value
	 */
	public int getBufferSize()
	{
		return bufferSize;
	}
	
	/**
	 * Sets the buffer size.
	 * @param bufferSize the buffer size value
	 */
	public void setBufferSize(int bufferSize)
	{
		this.bufferSize = bufferSize;
	}
	
	/**
	 * To url.
	 * @return the url string
	 */
	public String toURL()
	{
		if (host != null && port != 0 && path != null)
		{
			return "http://" + host + ":" + port + path;
		}
		
		return null;
	}
	
	/**
	 * To uri.
	 * @return the instance of URI
	 */
	public URI toURI()
	{
		String url = toURL();
		if (url != null)
		{
			return URI.create(url);
		}
		
		return null;
	}
}