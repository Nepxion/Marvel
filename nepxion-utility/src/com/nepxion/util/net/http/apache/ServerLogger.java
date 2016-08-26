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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServerLogger
{
	private static Log log = LogFactory.getLog(ServerLogger.class);
	
	/**
	 * Prints the http request info.
	 * @param method the method string
	 * @param charset the charset string
	 * @param dataType the data type string
	 * @param dataInfo the data info object
	 */	
	public static void requestInfo(String method, String charset, String dataType, Object dataInfo)
	{
		log.info("--------- Http Server Invoker Start ---------");
		log.info("Request Method     : " + method);
		log.info("Request Charset    : " + charset);
		log.info("Request Data Type  : " + dataType);
		log.info("Request Data Info  :\n" + parse(dataInfo));
	}
	
	/**
	 * Prints the http request info.
	 * @param method the method string
	 * @param dataType the data type string
	 * @param dataInfo the data info object
	 */
	public static void requestInfo(String method, String dataType, Object dataInfo)
	{
		log.info("--------- Http Server Invoker Start ---------");
		log.info("Request Method     : " + method);
		log.info("Request Data Type  : " + dataType);
		log.info("Request Data Info  :\n" + parse(dataInfo));
	}
	
	/**
	 * Prints the http response info.
	 * @param charset the charset string
	 * @param dataType the data type string
	 * @param dataInfo the data info object
	 */
	public static void responseInfo(String charset, String dataType, Object dataInfo)
	{
		log.info("---------------------------------------------");
		log.info("Response Charset   : " + charset);
		log.info("Response Data Type : " + dataType);
		log.info("Response Data Info :\n" + parse(dataInfo));
		log.info("---------- Http Server Invoker End ----------");
	}
	
	/**
	 * Prints the http response info.
	 * @param dataType the data type string
	 * @param dataInfo the data info object
	 */
	public static void responseInfo(String dataType, Object dataInfo)
	{
		log.info("---------------------------------------------");
		log.info("Response Data Type : " + dataType);
		log.info("Response Data Info :\n" + parse(dataInfo));
		log.info("---------- Http Server Invoker End ----------");
	}
	
	/**
	 * Parses the data info object to string.
	 * @param dataInfo the data info object
	 * @return the string
	 */
	public static String parse(Object dataInfo)
	{
		if (dataInfo instanceof List)
		{
			List list = (List) dataInfo;
			int size = list.size();
			
			if (size > 10)
			{	
				String classInfo = "List";
				String containClassInfo = "Class:" + list.get(0).getClass().getName();
				String sizeInfo = "Size:" + size;
				
				return  classInfo + "(" + containClassInfo + ", " + sizeInfo + ")";
			}
		}
		
		return dataInfo != null ? dataInfo.toString() : "null";
	}
}