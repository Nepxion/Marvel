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

public interface IClientInvoker
	extends HttpConstants
{
	/**
	 * Invokes the web server to get the serializable object by a client request.
	 * @param clientRequest the instance of IClientRequest
	 * @return the serializable object
	 * @throws Exception
	 */
	public Object invoke(IClientRequest clientRequest)
		throws Exception;
}