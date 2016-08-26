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

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class LocaleManager
	implements LocaleConstants
{
	/**
	 * The resource bundle cache map.
	 */
	private static Map resourceBundleMap;
	
	/**
	 * Gets the i18n string by a bundle class and key.
	 * @param bundleClazz the bundle class
	 * @param key the key string
	 * @return the i18n string
	 */
	public static String getString(Class bundleClazz, String key)
	{
		ResourceBundle resourceBundle = getResourceBundle(bundleClazz);
		
		return resourceBundle.getString(key);
	}
	
	/**
	 * Gets the i18n string with the given locale by a bundle class and key.
	 * @param bundleClazz the bundle class
	 * @param key the key string
	 * @param locale the instance of Locale
	 * @return the i18n string
	 */
	public static String getString(Class bundleClazz, String key, Locale locale)
	{
		ResourceBundle resourceBundle = getResourceBundle(bundleClazz, locale);
		
		return resourceBundle.getString(key);
	}
	
	/**
	 * Gets the i18n string by a bundle name and key.
	 * @param bundleName the bundle name string
	 * @param key the key string
	 * @return the i18n string
	 */
	public static String getString(String bundleName, String key)
	{
		ResourceBundle resourceBundle = getResourceBundle(bundleName);
		
		return resourceBundle.getString(key);
	}
	
	/**
	 * Gets the i18n string with the given locale by a bundle name and key.
	 * @param bundleName the bundle name
	 * @param key the key string
	 * @param locale the instance of Locale
	 * @return the i18n string
	 */
	public static String getString(String bundleName, String key, Locale locale)
	{
		ResourceBundle resourceBundle = getResourceBundle(bundleName, locale);
		
		return resourceBundle.getString(key);
	}
	
	/**
	 * Gets the resource bundle by a bundle class.
	 * @param bundleClazz the bundle class
	 * @return the instance of ResourceBundle
	 */
	public static ResourceBundle getResourceBundle(Class bundleClazz)
	{
		String bundleName = getBundleName(bundleClazz);
		
		return getResourceBundle(bundleName);
	}
	
	/**
	 * Gets the resource bundle with the given locale by a bundle class.
	 * @param bundleClazz
	 * @param locale the bundle class
	 * @return the instance of ResourceBundle
	 */
	public static ResourceBundle getResourceBundle(Class bundleClazz, Locale locale)
	{
		String bundleName = getBundleName(bundleClazz);
		
		return getResourceBundle(bundleName, locale);
	}
	
	/**
	 * Gets the resource bundle by a bundle name.
	 * @param bundleName the bundle name
	 * @return the instance of ResourceBundle
	 */
	public static ResourceBundle getResourceBundle(String bundleName)
	{
		return getResourceBundle(bundleName, LocaleContext.getLocale());
	}
	
	/**
	 * Gets the resource bundle with the given locale by a bundle name.
	 * It is initialized and persisted in the map with the key for the bundleName and the entry for the ResourceBundle class. 
	 * @param bundleName the bundle name
	 * @param locale the instance of Locale
	 * @return the instance of ResourceBundle
	 */
	public static ResourceBundle getResourceBundle(String bundleName, Locale locale)
	{
		if (resourceBundleMap == null)
		{
			resourceBundleMap = new HashMap();
		}
		
		String key = bundleName + "_" + locale;
		
		ResourceBundle resourceBundle = (ResourceBundle) resourceBundleMap.get(key);
		if (resourceBundle == null)
		{
			resourceBundle = ResourceBundle.getBundle(bundleName, locale);
			resourceBundleMap.put(key, resourceBundle);
		}

		return resourceBundle;
	}
	
	/*public static ResourceBundle getResourceBundle(String bundleName, Locale locale)
	{		
		return ResourceBundle.getBundle(bundleName, locale);
	}*/
	
	/**
	 * Gets the bundle name by a bundle class.
	 * @param bundleClazz the bundle class
	 * @return the bundle name string
	 */
	public static String getBundleName(Class bundleClazz)
	{
		String bundleName = bundleClazz.getName();
		int index = bundleName.lastIndexOf('.');
		if (index != -1)
		{
			bundleName = bundleName.substring(0, index) + "." + BASE_BUNDLE;
		}
		else
		{
			bundleName = BASE_BUNDLE;
		}
		
		return bundleName;
	}
}