package com.nepxion.util.searcher.ip.local;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.util.system.SystemUtil;

public interface IPConstants
{
	/**
	 * The path of data file for "ip.dat".
	 */
	public static final String DATA_FILE_PATH = "data/ip.dat";
	
	/**
	 * The cache path of data file for "ip.dat".
	 */
	public static final String DATA_FILE_CACHE_PATH = SystemUtil.getTempDirectory() + "ip.dat";
	
	/**
	 * The version date string.
	 */
	public static final String VERSION_DATE = "2011-05-10";
	
	/**
	 * The total count value.
	 */
	public static final int TOTAL_COUNT = 425675;
	
	/**
	 * The initialized count value.
	 */
	public static final int INITIALIZED_COUNT = 0;
}