package com.nepxion.util.searcher.ip.sina;

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

public class SinaIPEntity
	implements Serializable
{
	private static final long serialVersionUID = -4814051030961608318L;
	
	/**
	 * The ip string.
	 */
	private String ip;
	
	/**
	 * The country string.
	 */
	private String country;
	
	/**
	 * The province string.
	 */
	private String province;
	
	/**
	 * The city string.
	 */
	private String city;
	
	/**
	 * The corp string.
	 */
	private String corp;
	
	/**
	 * Constructs with the default.
	 */
	public SinaIPEntity()
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
	 * Gets the province.
	 * @return the province string
	 */
	public String getProvince()
	{
		return province;
	}
	
	/**
	 * Sets the province
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
	
	/**
	 * Gets the corp.
	 * @return the corp string
	 */
	public String getCorp()
	{
		return corp;
	}
	
	/**
	 * Sets the corp.
	 * @param corp the corp string
	 */
	public void setCorp(String corp)
	{
		this.corp = corp;
	}
	
	/**
	 * Gets the location.
	 * @return the location string
	 */
	public String getLocation()
	{
		return getCountry() + getProvince() + getCity() + getCorp();
	}
}