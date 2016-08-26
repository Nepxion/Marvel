package com.nepxion.swing.tree.toggle;

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

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import com.nepxion.swing.toggle.ITogglePanel;
import com.nepxion.swing.tree.xml.Dom4JTreeConstants;

public class DefaultToggleAdapter
	extends AbstractToggleAdapter
{
	public DefaultToggleAdapter(IToggleTree toggleTree)
	{
		super(toggleTree);
	}
	
	public ITogglePanel getTogglePanel(TreeNode treeNode)
	{
		Object userObject = ((DefaultMutableTreeNode) treeNode).getUserObject();
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