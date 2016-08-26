package com.nepxion.util.context;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.net.URL;
import java.util.Properties;

public interface IContextRegister
{
	/**
	 * Registers the context by a context file path.
	 * The context file is a native file.
	 * @param filePath the context file path
	 * @throws Exception
	 */
	public void register(String filePath)
		throws Exception;
	
	/**
	 * Registers the context by an url and context file path.
	 * The context file is a remote file.
	 * @param codeBase the instance of URL
	 * @param filePath the context file path
	 * @throws Exception
	 */
	public void register(URL codeBase, String filePath)
		throws Exception;
	
	/**
	 * Registers the context by a properties of context file.
	 * The context file is a native file.
	 * @param properties the instance of Properties
	 */
	public void initializeContext(Properties properties);
	
	/**
	 * Registers the context by an url and properties of context file.
	 * The context file is a remote file.
	 * @param codeBase the instance of URL
	 * @param properties the instance of Properties
	 */
	public void initializeContext(URL codeBase, Properties properties);
}