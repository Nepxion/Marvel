package com.nepxion.util.searcher.gis.google.loc;

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

public class LocEntity
	implements Serializable
{
	private static final long serialVersionUID = -2307089454521722153L;

	/**
	 * The latitude value.
	 */
	private double latitude;
	
	/**
	 * The longitude value.
	 */
	private double longitude;
	
	/**
	 * The country string.
	 */
	private String country = "";
	
	/**
	 * The country code string.
	 */
	private String countryCode = "";
	
	/**
	 * The region string.
	 */
	private String region = "";
	
	/**
	 * The city string.
	 */
	private String city = "";
	
	/**
	 * The street string.
	 */
	private String street = "";
	
	/**
	 * The street number string.
	 */
	private String streetNumber = "";
	
	/**
	 * The postal code string.
	 */
	private String postalCode = "";
	
	/**
	 * The accuracy value. 
	 */
	private double accuracy;
	
	/**
	 * The access token string.
	 */
	private String accessToken;
	
	/**
	 * Constructs with the default.
	 */
	public LocEntity()
	{
		
	}
	
	/**
	 * Gets the latitude.
	 * @return the latitude value.
	 */
	public double getLatitude()
	{
		return latitude;
	}
	
	/**
	 * Sets the latitude.
	 * @param latitude the latitude value
	 */
	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}
	
	/**
	 * Gets the longitude.
	 * @return the longitude value
	 */
	public double getLongitude()
	{
		return longitude;
	}
	
	/**
	 * Sets the longitude.
	 * @param longitude the longitude value
	 */
	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}
	
	/**
	 * Gets the country.
	 * @return the country string.
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
	 * Gets the country code.
	 * @return the country code string
	 */
	public String getCountryCode()
	{
		return countryCode;
	}
	
	/**
	 * Sets the country code.
	 * @param countryCode the country code string
	 */
	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
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
	 * Gets the street.
	 * @return the street string
	 */
	public String getStreet()
	{
		return street;
	}
	
	/**
	 * Sets the street.
	 * @param street the street string
	 */
	public void setStreet(String street)
	{
		this.street = street;
	}
	
	/**
	 * Gets the street number.
	 * @return the street number string
	 */
	public String getStreetNumber()
	{
		return streetNumber;
	}
	
	/**
	 * Sets the street number.
	 * @param streetNumber the street number string
	 */
	public void setStreetNumber(String streetNumber)
	{
		this.streetNumber = streetNumber;
	}
	
	/**
	 * Gets the postal code.
	 * @return the postal code string
	 */
	public String getPostalCode()
	{
		return postalCode;
	}
	
	/**
	 * Sets the postal code.
	 * @param postalCode the postal code string
	 */
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}
	
	/**
	 * Gets the accuracy.
	 * @return the accuracy value
	 */
	public double getAccuracy()
	{
		return accuracy;
	}
	
	/**
	 * Sets the accuracy.
	 * @param accuracy the accuracy value
	 */
	public void setAccuracy(double accuracy)
	{
		this.accuracy = accuracy;
	}
	
	/**
	 * Gets the access token.
	 * @return the access token string 
	 */
	public String getAccessToken()
	{
		return accessToken;
	}
	
	/**
	 * Sets the access token.
	 * @param accessToken the access token string
	 */
	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}
	
	/**
	 * To string.
	 * @return the string.
	 */
	public String toString()
	{
		return country + region + city + street + streetNumber;
	}
}