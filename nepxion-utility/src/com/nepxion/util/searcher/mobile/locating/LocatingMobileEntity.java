package com.nepxion.util.searcher.mobile.locating;

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

public class LocatingMobileEntity
	implements Serializable
{
	private static final long serialVersionUID = 7370379740504826892L;
	
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
	 * The area code string.
	 */
	private String areaCode;
	
	/**
	 * The post code string.
	 */
	private String postCode;
	
	/**
	 * The corp string.
	 */
	private String corp;
	
	/**
	 * The card string.
	 */
	private String card;
		
	/**
	 * Constructs with the default.
	 */
	public LocatingMobileEntity()
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
	
	/**
	 * Gets the area code.
	 * @return the area code string
	 */
	public String getAreaCode()
	{
		return areaCode;
	}
	
	/**
	 * Sets the area code.
	 * @param areaCode the area code string
	 */
	public void setAreaCode(String areaCode)
	{
		this.areaCode = areaCode;
	}
	
	/**
	 * Gets the post code.
	 * @return the post code string
	 */
	public String getPostCode()
	{
		return postCode;
	}
	
	/**
	 * Sets the post code.
	 * @param postCode the post code string
	 */
	public void setPostCode(String postCode)
	{
		this.postCode = postCode;
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
	 * Gets the card.
	 * @return the card string
	 */
	public String getCard()
	{
		return card;
	}
	
	/**
	 * Sets the card.
	 * @param card the card string
	 */
	public void setCard(String card)
	{
		this.card = card;
	}
}