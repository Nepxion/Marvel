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

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;

import com.nepxion.util.encoder.EncoderContext;
import com.nepxion.util.io.IOUtil;
import com.nepxion.util.net.http.HttpConfig;
import com.nepxion.util.net.http.IClientInvoker;
import com.nepxion.util.net.http.IClientRequest;

public class ClientInvoker
	extends DefaultHttpClient implements IClientInvoker
{
	/**
	 * Invokes the web server to get the serializable object by a client request.
	 * @param clientRequest the instance of IClientRequest
	 * @return the serializable object
	 * @throws Exception
	 */
	public Object invoke(IClientRequest clientRequest)
		throws Exception
	{		
		if (clientRequest.getURI() == null)
		{
			throw new IllegalArgumentException("Invalid URL for invoking");
		}
			
		// If the method is HttpPost, the URLParameter is ""		
		clientRequest.setURI(URI.create(clientRequest.getURI() + clientRequest.getURLParameter()));
	
		HttpConfig httpConfig = clientRequest.getHttpConfig();
		if (httpConfig != null)
		{	
			getParams().setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, httpConfig.getConnectionTimeOut());		
			getParams().setIntParameter(HttpConnectionParams.SO_TIMEOUT, httpConfig.getResponseTimeOut());
			getParams().setIntParameter(HttpConnectionParams.SOCKET_BUFFER_SIZE, httpConfig.getBufferSize());
		}
		
		HttpUriRequest request = (HttpUriRequest) clientRequest;
		HttpResponse response = null;
		try
		{
			response = execute(request);
		}
		catch (ClientProtocolException e)
		{
			request.abort();
			e.printStackTrace();
			
			throw e;
		}
		catch (IOException e)
		{
			request.abort();
			e.printStackTrace();
			
			throw e;			
		}
		
		return response;
	}
	
	/**
	 * Gets the response entity by a client request.
	 * @param clientRequest the instance of IClientRequest
	 * @return the instance of HttpEntity
	 * @throws Exception
	 */
	public HttpEntity getResponseEntity(IClientRequest clientRequest)
		throws Exception
	{
		HttpResponse response = (HttpResponse) invoke(clientRequest);
		HttpEntity entity = response.getEntity();
		
		return entity;
	}
	
	/**
	 * Gets the response object by a client request.
	 * @param clientRequest the instance of IClientRequest
	 * @return the response object
	 * @throws Exception
	 */
	public Object getResponseObject(IClientRequest clientRequest)
		throws Exception
	{
		HttpEntity entity = getResponseEntity(clientRequest);
		Object object = IOUtil.read(entity.getContent());
		entity.consumeContent();
		clientRequest.abort();
		
		ClientLogger.responseInfo("Serializable Entity", object);
		
		if (object instanceof Exception)
		{
			Exception e = (Exception) object;
			Exception exception = null;
			if (e.getCause() != null && e.getCause() instanceof Exception)
			{
				exception = (Exception) e.getCause();
			}
			else
			{
				exception = e;
			}
			ClientLogger.fatal(exception);
			throw exception;
		}	
		
		return object;
	}
	
	/**
	 * Gets the response text by a client request.
	 * The charset is registered in EncoderContext.
	 * @param clientRequest the instance of IClientRequest
	 * @return the response text
	 * @throws Exception
	 */
	public String getResponseText(IClientRequest clientRequest)
		throws Exception
	{
		return getResponseText(clientRequest, EncoderContext.getHttpCharset());
	}
	
	/**
	 * Gets the response text by a client request and charset.
	 * @param clientRequest the instance of IClientRequest
	 * @param charset the charset string
	 * @return the response text
	 * @throws Exception
	 */
	public String getResponseText(IClientRequest clientRequest, String charset)
		throws Exception
	{		
		HttpEntity entity = getResponseEntity(clientRequest);
		String text = IOUtil.getString(entity.getContent(), charset);
		entity.consumeContent();
		clientRequest.abort();
		
		ClientLogger.responseInfo(charset, "String - [Text, XML, JSON, Properties ...]", text);
		
		return text;
	}	
	
	/**
	 * Shuts down the client invoker.
	 */
	public void shutdown()
	{
		getConnectionManager().shutdown();
	}
}