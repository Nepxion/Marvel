package com.nepxion.cots.twaver.locale;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.Locale;

import com.nepxion.util.locale.LocaleManager;

public class TLocale
{
	public static final Class BUNDLE_CLASS = TLocale.class;
	
	public static String getString(String key)
	{
		return LocaleManager.getString(BUNDLE_CLASS, key);
	}
	
	public static String getString(String key, Locale locale)
	{
		return LocaleManager.getString(BUNDLE_CLASS, key, locale);
	}
}