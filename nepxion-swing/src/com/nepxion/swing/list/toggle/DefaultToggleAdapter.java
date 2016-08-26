package com.nepxion.swing.list.toggle;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.HashMap;

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.toggle.ITogglePanel;
import com.nepxion.swing.tree.xml.Dom4JTreeConstants;

public class DefaultToggleAdapter
	extends AbstractToggleAdapter
{
	/**
	 * Constructs with the specified initial toggle list.
	 * @param toggleList the instance of IToggleList
	 */
	public DefaultToggleAdapter(IToggleList toggleList)
	{
		super(toggleList);
	}
	
	/**
	 * Gets the toggle panel by an element node.
	 * @param elementNode the instance of IElementNode 
	 * @return the instance of ITogglePanel
	 */
	public ITogglePanel getTogglePanel(IElementNode elementNode)
	{
		Object userObject = elementNode.getUserObject();
		if (userObject == null)
		{
			return null;
		}
		
		if (userObject instanceof ITogglePanel)
		{
			return (ITogglePanel) userObject;
		}
		else if (userObject instanceof HashMap)
		{
			HashMap map = (HashMap) userObject;
			
			return (ITogglePanel) map.get(Dom4JTreeConstants.TAG_CLASS);
		}
		
		return null;
	}
}