package com.nepxion.util.servlet;

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

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServletLogger
{
	private static Log log = LogFactory.getLog(ServletLogger.class);
	
	/**
	 * Prints the http request info.
	 * @param method the method  
	 * @param dataType the data type
	 * @param request the instance of HttpServletRequest
	 */
	public static void requestInfo(String method, String dataType, HttpServletRequest request)
	{
		String dataInfo = ServletUtil.getDataInfo(request, dataType);
		requestInfo(method, dataType, dataInfo);
	}
	
	/**
	 * Prints the http request info.
	 * @param method the method  
	 * @param dataType the data type
	 * @param dataInfo the data info object
	 */
	public static void requestInfo(String method, String dataType, Object dataInfo)
	{
		log.info("--------- Http Server Invoker Start ---------");
		log.info("Request Method     : " + method);
		log.info("Request Data Type  : " + dataType);
		log.info("Request Data Info  :\n" + paser(dataInfo));
		log.info("---------- Http Server Invoker End ----------");
	}
	
	/**
	 * Prints the string of object.
	 * If the object is instance of List and its size is more than 10, it will be print as
	 * "List (Class:the className, Size:the size)".
	 * @param dataInfo the data info object
	 * @return the data info string
	 */
	public static String paser(Object dataInfo)
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