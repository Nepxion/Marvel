package com.nepxion.util.net.http.apache;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;

import com.nepxion.util.encoder.EncoderContext;
import com.nepxion.util.net.http.HttpConfig;
import com.nepxion.util.net.http.IClientRequest;

public class ClientRequestGet
	extends HttpGet implements IClientRequest
{	
	/**
	 * The instance of HttpConfig.
	 */
	private HttpConfig httpConfig;
	
	/**
	 * The url parameter string.
	 */
	private String urlParameter = "";
	
	/**
	 * Constructs with the default.
	 */
	public ClientRequestGet()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial http config.
	 * @param httpConfig the instance of HttpConfig
	 */
	public ClientRequestGet(HttpConfig httpConfig)
	{
		super(httpConfig.toURI());
		
		this.httpConfig = httpConfig;
	}
	
	/**
	 * Gets the http config.
	 * @return the instance of HttpConfig
	 */
	public HttpConfig getHttpConfig()
	{
		return httpConfig;
	}

	/**
	 * Sets the http config.
	 * @param httpConfig the instance of HttpConfig
	 */
	public void setHttpConfig(HttpConfig httpConfig)
	{
		this.httpConfig = httpConfig;
		
		setURI(httpConfig.toURI());
	}	
	
	/**
	 * Gets the url parameter.
	 * @return the url parameter string
	 */
	public String getURLParameter()
	{
		return urlParameter;
	}
	
	/**
	 * Sets the parameter entity.
	 * The charset is registered in EncoderContext.
	 * @param parameterEntity the parameter entity
	 */
	public void setParameterEntity(List parameterEntity)
	{
		setParameterEntity(parameterEntity, EncoderContext.getHttpCharset());
	}
	
	/**
	 * Sets the parameter entity by a charset.
	 * @param parameterEntity the parameter entity
	 * @param charset the charset string
	 */
	public void setParameterEntity(List parameterEntity, String charset)
	{		
		ClientLogger.requestInfo(GET, charset, "List - [URL Parameter]", parameterEntity);
		
		String format = URLEncodedUtils.format(parameterEntity, charset);
		if (format != null)
		{	
			urlParameter = "?" + format;
		}
	}	
}