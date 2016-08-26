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

import java.net.URI;

public class URLConfig
	implements URLConstants
{
	private static final long serialVersionUID = 8699519631775221595L;

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
	 * Constructs with the default.
	 */
	public URLConfig()
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