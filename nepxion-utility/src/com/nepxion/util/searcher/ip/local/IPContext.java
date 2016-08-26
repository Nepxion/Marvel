package com.nepxion.util.searcher.ip.local;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.nepxion.util.io.FileUtil;

public class IPContext
	implements IPConstants
{
	/**
	 * The instance of File.
	 */
	private static File file;
	
	/**
	 * Registers the ip context by the default config file path.
	 */
	public static void register()
	{
		register(DATA_FILE_PATH);
	}
	
	/**
	 * Registers the ip context by a config file path.
	 * @param filePath
	 */
	public static void register(String filePath)
	{
		file = new File(filePath);
	}
	
	/**
	 * Registers the ip context by an url.
	 * @param codeBase the instance of URL
	 */
	public static void register(URL codeBase)
	{				
		String url = codeBase + DATA_FILE_PATH;
		
		try
		{
			file = FileUtil.download(url, DATA_FILE_CACHE_PATH);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}		
	}
	
	/**
	 * Gets the ip file.
	 * @return the instance of File
	 */
	public static File getFile()
	{
		return file;
	}
}