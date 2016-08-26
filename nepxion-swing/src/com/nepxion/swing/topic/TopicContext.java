package com.nepxion.swing.topic;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Component;

public class TopicContext
{
	/**
	 * The instance of Component.
	 */
	private static Component topicComponent;
	
	/**
	 * Registers the topic component.
	 * @param topicComponent the instance of Component
	 */
	public static void registerTopicComponent(Component topicComponent)
	{
		TopicContext.topicComponent = topicComponent;
	}
	
	/**
	 * Registers the topic component by a topic component class string.
	 * @param topicComponentClass the topic component class string
	 */
	public static void registerTopicComponent(String topicComponentClass)
	{
		if (topicComponentClass != null)
		{
			try
			{
				topicComponent = (Component) Class.forName(topicComponentClass).newInstance();
			}
			catch (InstantiationException e)
			{
				e.printStackTrace();
			}
			catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Gets the topic component.
	 * @return the instance of Component
	 */
	public static Component getTopicComponent()
	{
		return topicComponent;
	}
}