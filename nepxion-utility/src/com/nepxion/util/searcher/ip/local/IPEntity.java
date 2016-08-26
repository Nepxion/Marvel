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

import java.io.Serializable;

public class IPEntity
	implements Serializable
{
	private static final long serialVersionUID = 5429316904963543813L;

	/**
	 * The ip string.
	 */
	private String ip;
	
	/**
	 * The start ip string.
	 */
	private String startIP;
	
	/**
	 * The end ip string.
	 */
	private String endIP;
	
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
	public IPEntity()
	{
		ip = "";
		startIP = "";
		endIP = "";
		country = "";
		region = "";
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
	 * Gets the start ip.
	 * @return the start ip string 
	 */
	public String getStartIP()
	{
		return startIP;
	}
	
	/**
	 * Sets the start ip.
	 * @param startIP the start ip string
	 */
	public void setStartIP(String startIP)
	{
		this.startIP = startIP;
	}
	
	/**
	 * Gets the end ip.
	 * @return the end ip string 
	 */
	public String getEndIP()
	{
		return endIP;
	}
	
	/**
	 * Sets the end ip.
	 * @param endIP the end ip string
	 */
	public void setEndIP(String endIP)
	{
		this.endIP = endIP;
	}
	
	/**
	 * Gets the country.
	 * @return the country string
	 */
	public String getCountry()
	{
		return country.trim().equals("CZ88.NET") ?  "" : country.trim();
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
		return region.trim().equals("CZ88.NET") ?  "" : region.trim();
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
	
	/**
	 * Clones the ip entity.
	 * @return the instance of IPEntity
	 */
	public IPEntity clone()
	{
		IPEntity ipEntity = new IPEntity();
		ipEntity.startIP = startIP;
		ipEntity.endIP = endIP;
		ipEntity.country = country;
		ipEntity.region = region;
		
		return ipEntity;
	}
}