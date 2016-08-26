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

public interface IContextInitializer
{
	/**
	 * Initializes for the context file.
	 * The context file is a native file and its path is default context file path.
	 */
	public void initialize();
	
	/**
	 * Initializes for the context file by a context file path.
	 * The context file is a native file.
	 * @param filePath the context file path string
	 */
	public void initialize(String filePath);
	
	/**
	 * Initializes for the context file by an url.
	 * The context file is a remote file and its path is default context file path.
	 * @param codeBase the instance of URL
	 */
	public void initialize(URL codeBase);
	
	/**
	 * Initializes for the context file by an url and context file path.
	 * The context file is a remote file.
	 * @param filePath the context file path string
	 * @param codeBase the instance of URL
	 */
	public void initialize(URL codeBase, String filePath);
	
	/**
	 * Gets the context register.
	 * @return the instance of IContextRegister
	 */
	public IContextRegister getContextRegister();
	
	/**
	 * Gets the default context file path.
	 * @return the default context file path string
	 */
	public String getDefaultContextFilePath();
}