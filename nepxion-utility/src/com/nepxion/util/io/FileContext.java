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

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class FileContext
{
	/**
	 * The file cache map.
	 */
	private static Map map = new HashMap();
	
	/**
	 * Registers the file content of string by a native file path.
	 * It is mainly used for the static file, such as a properties file and xml file etc.
	 * It is initialized and persisted in the map with the key for the file path and the entry for the file content.
	 * @param filePath the file path
	 * @throws Exception
	 */
	public static void register(String filePath)
		throws Exception
	{
		InputStream inputStream = FileUtil.getInputStream(filePath, false);
		String content = IOUtil.getString(inputStream);
		map.put(filePath, content);
	}
	
	/**
	 * Registers the file content of string by a remote file url.
	 * It is mainly used for the static file, such as a properties file and xml file etc.
	 * It is initialized and persisted in the map with the key for the file path and the entry for the file content.
	 * @param codeBase the instance of URL
	 * @param filePath the file path
	 * @throws Exception
	 */
	public static void register(URL codeBase, String filePath)
		throws Exception
	{
		InputStream inputStream = FileUtil.getInputStream(codeBase, filePath);
		String content = IOUtil.getString(inputStream);
		map.put(filePath, content);
	}
	
	/**
	 * Gets the file content of string by a file path.
	 * @param filePath the file path
	 * @return the file content of string
	 */
	public static String getContent(String filePath)
	{
		if (!map.containsKey(filePath))
		{
			throw new IllegalArgumentException(filePath + " hasn't been registered in FileContext");
		}
		
		String content = (String) map.get(filePath);	
		
		return content;
	}
}