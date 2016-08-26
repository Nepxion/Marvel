package com.nepxion.util.searcher.ip.netease;

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

public class NeteaseIPEntity
	implements Serializable
{
	private static final long serialVersionUID = 7048603907416561396L;
	
	/**
	 * The ip string.
	 */
	private String ip;
	
	/**
	 * The country string.
	 */
	private String country;
	
	/**
	 * The region string.
	 */
	private String region;
	
	/**
	 * Constructs with the default.
	 */
	public NeteaseIPEntity()
	{
		
	}
	
	/**
	 * Gets the ip.
	 * @return the ip string 
	 */
	public String getIP()
	{
		return ip;
	}
	
	/**
	 * Sets the ip.
	 * @param ip the ip string
	 */
	public void setIP(String ip)
	{
		this.ip = ip;
	}
	
	/**
	 * Gets the country.
	 * @return the country string
	 */
	public String getCountry()
	{
		return country;
	}
	
	/**
	 * Sets the country.
	 * @param country the country string
	 */
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	/**
	 * Gets the region.
	 * @return the region string
	 */
	public String getRegion()
	{
		return region;
	}
	
	/**
	 * Sets the region.
	 * @param region the region string
	 */
	public void setRegion(String region)
	{
		this.region = region;
	}
	
	/**
	 * Gets the location.
	 * @return the location string
	 */
	public String getLocation()
	{
		return getCountry() + getRegion();
	}
}