package com.nepxion.swing.context;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.util.context.AbstractContextInitializer;
import com.nepxion.util.context.IContextRegister;

public class DataContextInitializer
	extends AbstractContextInitializer implements DataContextConstants
{
	/**
	 * Gets the context register.
	 * @return the instance of IContextRegister
	 */
	public IContextRegister getContextRegister()
	{
		return new DataContextRegister();
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