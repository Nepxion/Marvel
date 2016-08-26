package com.nepxion.util.io;

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
import java.net.JarURLConnection;
import java.net.URL;

public class JarUtil
{
	/**
	 * Gets the jarURLConnection by an url.
	 * @param url the instance of URL
	 * @return the instance of JarURLConnection
	 * @throws IOException
	 */
	public static JarURLConnection getJarURLConnection(URL url) 
		throws IOException
	{
		JarURLConnection connection = (JarURLConnection) url.openConnection();
		
		return connection;
	}
}