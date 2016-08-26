package com.nepxion.demo.component.locale;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.util.locale.LocaleManager;

public class SwingDemoLocale
{
	public static final Class BUNDLE_CLASS = SwingDemoLocale.class;
	
	public static String getString(String key)
	{
		return LocaleManager.getString(BUNDLE_CLASS, key);
	}
}