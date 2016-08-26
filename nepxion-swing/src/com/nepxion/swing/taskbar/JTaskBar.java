package com.nepxion.swing.taskbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.l2fprod.common.swing.JTaskPane;

public class JTaskBar
	extends JTaskPane
{
	/**
	 * Constructs with the default.
	 */
	public JTaskBar()
	{
		
	}
	
	/**
	 * Gets the task group by a name.
	 * @param name the name string
	 * @return the instance of JTaskGroup
	 */
	public JTaskGroup getTaskGroupByName(String name)
	{
		for (int i = 0; i < getComponentCount(); i++)
		{
			JTaskGroup taskGroup = (JTaskGroup) getComponent(i);
			if (taskGroup.getName().trim().equals(name.trim()))
			{
				return taskGroup;
			}
		}
		
		return null;
	}
	
	/**
	 * Gets the task group by a title.
	 * @param title the title string
	 * @return the instance of JTaskGroup
	 */
	public JTaskGroup getTaskGroupByTitle(String title)
	{
		for (int i = 0; i < getComponentCount(); i++)
		{
			JTaskGroup taskGroup = (JTaskGroup) getComponent(i);
			if (taskGroup.getTitle().trim().equals(title.trim()))
			{
				return taskGroup;
			}
		}
		
		return null;
	}
	
	/**
	 * Gets the task group by an index.
	 * @param index the index value
	 * @return the instance of JTaskGroup
	 */
	public JTaskGroup getTaskGroupByIndex(int index)
	{
		return (JTaskGroup) getComponent(index);
	}
}