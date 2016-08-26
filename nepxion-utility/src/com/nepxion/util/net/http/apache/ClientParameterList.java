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

import java.util.ArrayList;
import java.util.Iterator;

public class ClientParameterList
	extends ArrayList
{
	/**
	 * Constructs with the default.
	 */
	public ClientParameterList()
	{
	}
	
	/**
	 * Puts the key and value.
	 * @param key the key string
	 * @param value the value string
	 */
	public void put(String key, String value)
	{
		add(new ClientParameter(key, value));
	}
	
	/**
	 * Gets the value.
	 * @param key the key string
	 * @return the value string
	 */
	public String get(String key)
	{
		for (Iterator iterator = iterator(); iterator.hasNext();)
		{
			ClientParameter clientParameter = (ClientParameter) iterator.next();
			if (clientParameter.getName().equals(key))
			{
				return clientParameter.getValue();
			}
		}
		
		return null;
	}
}