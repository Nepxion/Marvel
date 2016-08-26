package com.nepxion.util.locale;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.Locale;

public class LocaleContext
	implements LocaleConstants
{
	/**
	 * Registers the locale.
	 * @param locale the instance of Locale
	 */
	public static void registerLocale(Locale locale)
	{
		Locale.setDefault(locale);
	}
	
	/**
	 * Registers the locale by a language.
	 * @param language the language string
	 */
	public static void registerLocale(String language)
	{
		Locale locale = getLocale(language);
		Locale.setDefault(locale);
	}
	
	/**
	 * Gets the default locale.
	 * @return the instance of Locale
	 */
	public static Locale getLocale()
	{
		return Locale.getDefault();
	}
	
	/**
	 * Gets the locale by a language.
	 * @param language the language string
	 * @return the instance of Locale
	 */
	public static Locale getLocale(String language)
	{
		for (int i = 0; i < LOCALE_LIST.length; i++)
		{
			Locale locale = LOCALE_LIST[i];
			if (locale.toString().toLowerCase().equals(language.toLowerCase()))
			{
				return locale;
			}	
		}
		
		return LOCALE_EN_US;
	}
}