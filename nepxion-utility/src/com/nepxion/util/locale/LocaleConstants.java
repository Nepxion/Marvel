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

public interface LocaleConstants
{	
	/**
	 * The locale of China.
	 */
	public static final Locale LOCALE_ZH_CN = Locale.CHINA;
	
	/**
	 * The locale of US.
	 */
	public static final Locale LOCALE_EN_US = Locale.US;
	
	/**
	 * The default locale array.
	 * It includes LOCALE_ZH_CN and LOCALE_EN_US.
	 */
	public static final Locale[] LOCALE_LIST = {LOCALE_ZH_CN, LOCALE_EN_US};

	/**
	 * The locale string of LOCALE_ZH_CN.
	 */
	public static final String ZH_CN = LOCALE_ZH_CN.toString();
	
	/**
	 * The locale string of LOCALE_EN_US.
	 */
	public static final String EN_US = LOCALE_EN_US.toString();
	
	/**
	 * The base bundle string.
	 */
	public static final String BASE_BUNDLE = "Locale";
}