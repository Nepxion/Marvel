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

import org.apache.http.message.BasicNameValuePair;

public class ClientParameter
	extends BasicNameValuePair
{
	/**
	 * Constructs with the specified initial name and value.
	 * @param name the name string
	 * @param value the value string
	 */	
	public ClientParameter(String name, String value) 
	{
		super(name, value);
	}
}