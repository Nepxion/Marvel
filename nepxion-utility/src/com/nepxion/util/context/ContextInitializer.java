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

public class ContextInitializer
	extends AbstractContextInitializer implements ContextConstants
{
	/**
	 * Gets the context register.
	 * @return the instance of IContextRegister
	 */
	public IContextRegister getContextRegister()
	{
		return new ContextRegister();
	}

	/**
	 * Gets the default context file path.
	 * @return the default context file path string
	 */
	public String getDefaultContextFilePath()
	{
		return CONTEXT_FILE_PATH;
	}
}