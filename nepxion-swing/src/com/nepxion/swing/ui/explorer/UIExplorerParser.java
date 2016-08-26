package com.nepxion.swing.ui.explorer;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.UIManager;

import com.nepxion.swing.locale.SwingLocale;

public class UIExplorerParser
{
	private static Map allMap;
	private static Map componentMap;
	private static Map typeMap;
	
	/**
	 * 
	 * @return
	 */
	public static Map parseAllMap()
	{
		if (allMap == null)
		{
			allMap = new TreeMap();
			
			for (Enumeration enumeration = UIManager.getDefaults().keys(); enumeration.hasMoreElements();)
			{
				Object key = enumeration.nextElement();
				Object value = UIManager.get(key);
				allMap.put(key.toString(), value);
			}
		}
		
		return allMap;
	}
	
	public static Map parseComponentMap()
	{
		if (componentMap == null)
		{
			componentMap = new TreeMap();
			
			for (Enumeration enumeration = UIManager.getDefaults().keys(); enumeration.hasMoreElements();)
			{
				Object key = enumeration.nextElement();
				Object value = UIManager.get(key);
				String componentName = getComponentName(key.toString());
				if (componentName != null)
				{
					Map parameterMap = null;
					if (componentMap.containsKey(componentName))
					{
						parameterMap = (Map) componentMap.get(componentName);
					}
					else
					{
						parameterMap = new TreeMap();
						componentMap.put(componentName, parameterMap);
					}
					parameterMap.put(key.toString(), value);
				}
			}
		}
		return componentMap;
	}
	
	public static Map parseTypeMap()
	{
		if (typeMap == null)
		{
			typeMap = new TreeMap();
			
			for (Enumeration enumeration = UIManager.getDefaults().keys(); enumeration.hasMoreElements();)
			{
				Object key = enumeration.nextElement();
				Object value = UIManager.get(key);
				String type = getTypeName(value);
				if (type != null)
				{
					Map parameterMap = null;
					if (typeMap.containsKey(type))
					{
						parameterMap = (Map) typeMap.get(type);
					}
					else
					{
						parameterMap = new TreeMap();
						typeMap.put(type, parameterMap);
					}
					parameterMap.put(key.toString(), value);
				}
			}
		}
		
		return typeMap;
	}
	
	public static String getComponentName(String key)
	{
		String componentName = null;
		
		int index = key.indexOf(".");
		if (index == -1)
		{
			if (key.endsWith("UI"))
			{
				componentName = key.substring(0, key.length() - 2);
			}
			else
			{
				componentName = key;
			}
		}
		else
		{
			componentName = key.substring(0, index);
		}
		
		return componentName;
	}
	
	public static String getTypeName(Object value)
	{
		for (int i = 0; i < UIExplorerConstants.CLASS_TYPES.length; i++)
		{
			Class clazz = UIExplorerConstants.CLASS_TYPES[i];
			if (clazz.isInstance(value))
			{
				String className = clazz.getName();
				
				int index = className.lastIndexOf(".");
				if (index == -1)
				{
					return className;
				}
				else
				{
					return className.substring(index + 1);
				}
			}
		}
		
		return SwingLocale.getString("others");
	}
}