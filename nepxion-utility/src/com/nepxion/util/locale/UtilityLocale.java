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

public class UtilityLocale
{
	/**
	 * The bundle class for UtilityLocale.
	 * It is mainly used for the i18n of Nepxion-Utility, The configuration files 
	 * of UtilityLocale is at the folder "nepxion-utility/locale/com/nepxion/util/locale".
	 * Locale.properties is the i18n for zh_CN locale (You also can change it to another language), Locale_en_US.properties is the i18n for en_US.
	 * You can run "Locale.bat" to generate Locale_zh_CN.properties by the Locale.properties.
	 */
	public static final Class BUNDLE_CLASS = UtilityLocale.class;
	
	/**
	 * Gets the i18n string by a key.
	 * @param key the key string
	 * @return the i18n string
	 */
	public static String getString(String key)
	{
		return LocaleManager.getString(BUNDLE_CLASS, key);
	}
	
	/**
	 * Gets the i18n string withe the given locale by a key.
	 * @param key the key string
	 * @return the i18n string
	 */
	public static String getString(String key, Locale locale)
	{
		return LocaleManager.getString(BUNDLE_CLASS, key, locale);
	}
}