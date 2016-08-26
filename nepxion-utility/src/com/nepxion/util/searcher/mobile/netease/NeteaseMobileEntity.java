package com.nepxion.util.searcher.mobile.netease;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.io.Serializable;

public class NeteaseMobileEntity
	implements Serializable
{
	private static final long serialVersionUID = -7882805926860233586L;
	
	/**
	 * The mobile string.
	 */
	private String mobile;
	
	/**
	 * The province string.
	 */
	private String province;
	
	/**
	 * The city string.
	 */
	private String city;
	
	/**
	 * Constructs with the default.
	 */
	public NeteaseMobileEntity()
	{
		
	}
	
	/**
	 * Gets the mobile.
	 * @return the mobile string
	 */
	public String getMobile()
	{
		return mobile;
	}
	
	/**
	 * Sets the moblile.
	 * @param mobile the mobile string
	 */
	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	
	/**
	 * Gets the province.
	 * @return the province string
	 */
	public String getProvince()
	{
		return province;
	}
	
	/**
	 * Sets the province.
	 * @param province the province string
	 */
	public void setProvince(String province)
	{
		this.province = province;
	}
	
	/**
	 * Gets the city.
	 * @return the city string
	 */
	public String getCity()
	{
		return city;
	}
	
	/**
	 * Sets the city.
	 * @param city the city string
	 */
	public void setCity(String city)
	{
		this.city = city;
	}	
}