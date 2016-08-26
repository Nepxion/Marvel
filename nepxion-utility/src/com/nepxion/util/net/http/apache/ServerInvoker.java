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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nepxion.util.encoder.EncoderContext;
import com.nepxion.util.encoder.EncoderUtil;
import com.nepxion.util.io.IOUtil;
import com.nepxion.util.net.http.HttpConstants;

public class ServerInvoker
	extends HttpServlet implements HttpConstants
{
	/**
	 * The request entity type for parameter.
	 * The client is allowed to send parameter list to server. It supports GET and POST mode.
	 * This function is mostly like the url parameter transfer as ("http://localhost:8080?key1=value1&key2=value2").
	 */
	public static final int REQUEST_ENTITY_TYPE_PARAMETER = 0;
	
	/**
	 * The request entity type for string.
	 * The client is allowed to send string(Text, XML, JSON, Properties...) to server. It only supports POST mode.
	 */
	public static final int REQUEST_ENTITY_TYPE_STRING = 1;
	
	/**
	 * The request entity type for serializable.
	 * The client is allowed to send serializable object to server. It only supports POST mode.
	 */
	public static final int REQUEST_ENTITY_TYPE_SERIALIZABLE = 2;
	
	/**
	 * The response entity type for stream.
	 * The server will response the object by output stream.
	 */
	public static final int RESPONSE_ENTITY_TYPE_STREAM = 3;
	
	/**
	 * The response entity type for PrintWriter.
	 * The server will response the string by out.println().
	 */
	public static final int RESPONSE_ENTITY_TYPE_PRINTWRITER = 4;
	
	/**
	 * The request entity type.
	 */
	private int requestEntityType = REQUEST_ENTITY_TYPE_SERIALIZABLE;
	
	/**
	 * The response entity type.
	 */
	private int responseEntityType = RESPONSE_ENTITY_TYPE_STREAM;
	
	/**
	 * The charset string.
	 */
	private String charset = EncoderContext.getHttpCharset();
	
	/**
	 * Doget.
	 * @param request the instance of HttpServletRequest
	 * @param response the instance of HttpServletResponse
	 * It is overridden from HttpServlet
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		doExecute(request, response, GET);
	}
	
	/**
	 * Dopost.
	 * @param request the instance of HttpServletRequest
	 * @param response the instance of HttpServletResponse
	 * It is overridden from HttpServlet
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		doExecute(request, response, POST);
	}
	
	/**
	 * Executes the server invoker.
	 * @param request the instance of HttpServletRequest
	 * @param response the instance of HttpServletResponse
	 * @param method the method, the value should be GET or POST
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doExecute(HttpServletRequest request, HttpServletResponse response, String method)
		throws ServletException, IOException
	{
		Object requestObject = null;
		switch (requestEntityType)
		{
			case REQUEST_ENTITY_TYPE_PARAMETER :
			{
				Map parameters = new HashMap();
				for (Enumeration enumeration = request.getParameterNames(); enumeration.hasMoreElements();)
				{
					String key = (String) enumeration.nextElement();
					String value = request.getParameter(key);
					
					if (method.equals(GET))
					{
						value = EncoderUtil.format(value, charset);
					}
					parameters.put(key, value);
				}
				requestObject = parameters;
				ServerLogger.requestInfo(method, charset, "List - [URL Parameter]", requestObject);
				break;
			}
			case REQUEST_ENTITY_TYPE_STRING :
			{
				requestObject = IOUtil.getString(request.getInputStream(), charset);
				ServerLogger.requestInfo(method, charset, "String - [Text, XML, JSON, Properties ...]", requestObject);
				break;
			}
			case REQUEST_ENTITY_TYPE_SERIALIZABLE :
			{
				try
				{
					requestObject = IOUtil.read(request.getInputStream());
				}
				catch (Exception e)
				{
					IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The request serializable entity is null or invalid");
					
					ServerLogger.responseInfo("Serializable Entity", illegalArgumentException);
					
					illegalArgumentException.printStackTrace();
				}
				ServerLogger.requestInfo(method, "Serializable Entity", requestObject);
				break;
			}
		}
		
		Object responseObject = invoke(requestObject, request, response);
		
		switch (responseEntityType)
		{
			case RESPONSE_ENTITY_TYPE_STREAM : 
			{
				if (responseObject != null)
				{
					ServerLogger.responseInfo("Serializable Entity", responseObject);
					
					IOUtil.write(response.getOutputStream(), responseObject);
				}
				else
				{
					IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The response serializable entity is null or invalid");
					
					ServerLogger.responseInfo("Serializable Entity", illegalArgumentException);
					
					IOUtil.write(response.getOutputStream(), illegalArgumentException);
				}
				break;
			}
			case RESPONSE_ENTITY_TYPE_PRINTWRITER :
			{
				ServerLogger.responseInfo("String - [Text, XML, JSON, Properties ...]", "It is output by the PrintWriter");
			}
			break;
		}
	}
	
	/**
	 * Invokes the web server to get the serializable object. 
	 * If it is overridden by the child class, the method will be executed. 
	 * @param requestObject the request object
	 * @param request the instance of HttpServletRequest
	 * @param response the instance of HttpServletResponse
	 * @return the response object which should be serializabled
	 * @throws ServletException
	 * @throws IOException
	 */
	public Object invoke(Object requestObject, HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		return null;
	}
	
	/**
	 * Gets the request entity type.
	 * @return the request entity type value
	 */
	public int getRequestEntityType()
	{
		return requestEntityType;
	}
	
	/**
	 * Sets the request entity type.
	 * @param requestEntityType the request entity type value
	 */
	public void setRequestEntityType(int requestEntityType)
	{
		this.requestEntityType = requestEntityType;
	}
	
	/**
	 * Gets the response entity type.
	 * @return the response entity type value
	 */
	public int getResponseEntityType()
	{
		return responseEntityType;
	}
	
	/**
	 * Sets the response entity type.
	 * @param responseEntityType the response entity type value
	 */
	public void setResponseEntityType(int responseEntityType)
	{
		this.responseEntityType = responseEntityType;
	}
	
	/**
	 * Gets the charset.
	 * @return the charset string.
	 */
	public String getCharset()
	{
		return charset;
	}
	
	/**
	 * Sets the charset.
	 * @param charset the charset string
	 */
	public void setCharset(String charset)
	{
		this.charset = charset;
	}
}