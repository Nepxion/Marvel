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

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class ServletUtil
	implements ServletConstants
{
	/**
	 * Gets the date info for http request.
	 * If it includes the password, the password won't be shown.
	 * @param request the instance of HttpServletRequest
	 * @param dataType the data type
	 * @return the data info string
	 */
	public static String getDataInfo(HttpServletRequest request, String dataType)
	{
		StringBuffer stringBuffer = new StringBuffer();
		
		Enumeration enumeration = null;
		if (dataType.equals(PARAMETER))
		{
			enumeration = request.getParameterNames();
		}
		else if (dataType.equals(ATTRIBUTE))
		{
			enumeration = request.getAttributeNames();
		}
		
		while (enumeration.hasMoreElements())
		{
			Object key = enumeration.nextElement();
			Object value = null;
			if (dataType.equals(PARAMETER))
			{
				value = request.getParameter(key.toString());
			}
			else if (dataType.equals(ATTRIBUTE))
			{
				value = request.getAttribute(key.toString());
			}
			
			if (!key.toString().equals("password"))
			{
				stringBuffer.append(dataType + " - " + key + " : [" + value + "]\n");
			}
		}
		
		String dataInfo = stringBuffer.toString();
		dataInfo = dataInfo.substring(0, dataInfo.lastIndexOf("\n"));
		
		return dataInfo;
	}
}