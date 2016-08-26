package com.nepxion.util.searcher.id.netease;

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

public class NeteaseIDEntity
	implements Serializable
{
	private static final long serialVersionUID = -7973227106071684695L;
	
	/**
	 * The code string.
	 */
	private String code;
	
	/**
	 * The location string.
	 */
	private String location;
	
	/**
	 * The birthday string.
	 */
	private String birthday;
	
	/**
	 * The gender string.
	 */
	private String gender;
	
	/**
	 * Constructs with the default.
	 */
	public NeteaseIDEntity()
	{
		
	}
	
	/**
	 * Gets the code.
	 * @return the code string
	 */
	public String getCode()
	{
		return code;
	}
	
	/**
	 * Sets the code.
	 * @param code the code string
	 */
	public void setCode(String code)
	{
		this.code = code;
	}
	
	/**
	 * Gets the location.
	 * @return the location string
	 */
	public String getLocation()
	{
		return location;
	}
	
	/**
	 * Sets the location.
	 * @param location the location string
	 */
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	/**
	 * Gets the birthday.
	 * @return the birthday string
	 */
	public String getBirthday()
	{
		return birthday;
	}
	
	/**
	 * Sets the birthday.
	 * @param birthday the birthday string
	 */
	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}
	
	/**
	 * Gets the gender.
	 * @return the gender string
	 */
	public String getGender()
	{
		return gender;
	}
	
	/**
	 * Sets the gender.
	 * @param gender the gender string
	 */
	public void setGender(String gender)
	{
		this.gender = gender;
	}
}