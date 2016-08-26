package com.nepxion.cots.twaver.element;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.io.Serializable;

public class TType
	implements Serializable
{
	private String name;
	private String imageIcon;
	
	public TType()
	{
		this(null);
	}
	
	public TType(String name)
	{
		this(name, null);
	}
	
	public TType(String name, String imageIcon)
	{
		this.name = name;
		this.imageIcon = imageIcon;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getImageIcon()
	{
		return imageIcon;
	}
	
	public String toString()
	{
		return name;
	}
	
	public int hashCode()
	{
		return name.hashCode();
	}
	
	public boolean equals(Object object)
	{
		if (this == object)
		{
			return true;
		}
		
		if (object instanceof TType)
		{
			TType type = (TType) object;
			if (type.getName().equals(name))
			{
				return true;
			}
		}
		
		return false;
	}
}