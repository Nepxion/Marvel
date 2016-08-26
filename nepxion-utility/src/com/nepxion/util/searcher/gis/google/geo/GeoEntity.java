package com.nepxion.util.searcher.gis.google.geo;

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

public class GeoEntity
	implements Serializable
{
	private static final long serialVersionUID = 6363021430950951419L;
	
	/**
	 * The address string.
	 */
	private String address;
	
	/**
	 * The center latitude value.
	 */
	private double centerLatitude;
	
	/**
	 * The center longitude value.
	 */
	private double centerLongitude;
	
	/**
	 * The north latitude value.
	 */
	private double northLatitude;
	
	/**
	 * The east longitude value.
	 */
	private double eastLongitude;
	
	/**
	 * The south latitude value.
	 */
	private double southLatitude;
	
	/**
	 * The west longitude value.
	 */
	private double westLongitude;
	
	/**
	 * Constructs with the default.
	 */
	public GeoEntity()
	{
		
	}
	
	/**
	 * Gets the address.
	 * @return the address string
	 */
	public String getAddress()
	{
		return address;
	}
	
	/**
	 * Sets the address.
	 * @param address the address string
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	/**
	 * Gets the center latitude.
	 * @return the center latitude value
	 */
	public double getCenterLatitude()
	{
		return centerLatitude;
	}
	
	/**
	 * Sets the center latitude.
	 * @param centerLatitude the center latitude value
	 */
	public void setCenterLatitude(double centerLatitude)
	{
		this.centerLatitude = centerLatitude;
	}
	
	/**
	 * Gets the center longitude.
	 * @return the center longitude value
	 */
	public double getCenterLongitude()
	{
		return centerLongitude;
	}
	
	/**
	 * Sets the center longitude.
	 * @param centerLongitude the center longitude value
	 */
	public void setCenterLongitude(double centerLongitude)
	{
		this.centerLongitude = centerLongitude;
	}
	
	/**
	 * Gets the north latitude.
	 * @return the north latitude value
	 */
	public double getNorthLatitude()
	{
		return northLatitude;
	}
	
	/**
	 * Sets the north latitude. 
	 * @param northLatitude the north latitude value
	 */
	public void setNorthLatitude(double northLatitude)
	{
		this.northLatitude = northLatitude;
	}
	
	/**
	 * Gets the east longitude.
	 * @return the east longitude value
	 */
	public double getEastLongitude()
	{
		return eastLongitude;
	}
	
	/**
	 * Sets the east longitude.
	 * @param eastLongitude the east longitude value
	 */
	public void setEastLongitude(double eastLongitude)
	{
		this.eastLongitude = eastLongitude;
	}
	
	/**
	 * Gets the south latitude.
	 * @return the south latitude value
	 */
	public double getSouthLatitude()
	{
		return southLatitude;
	}
	
	/**
	 * Sets the south latitude.
	 * @param southLatitude the south latitude value
	 */
	public void setSouthLatitude(double southLatitude)
	{
		this.southLatitude = southLatitude;
	}
	
	/**
	 * Gets the west longitude.
	 * @return the west longitude value
	 */
	public double getWestLongitude()
	{
		return westLongitude;
	}
	
	/**
	 * Sets the west longitude.
	 * @param westLongitude the west longitude
	 */
	public void setWestLongitude(double westLongitude)
	{
		this.westLongitude = westLongitude;
	}
}