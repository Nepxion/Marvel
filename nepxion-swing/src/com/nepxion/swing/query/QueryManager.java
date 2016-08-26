package com.nepxion.swing.query;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.swing.framework.dockable.JDockable;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;

public class QueryManager
{
	/**
	 * Sets the preference style for the query dockable.
	 * @param dockable the instance of JDockable
	 */
	public static void setPreferenceStyle(JDockable dockable)
	{
		if (!LookAndFeelManager.isNimbusLookAndFeel())
		{
			dockable.setDividerLocation(0, 245);
		}
		else
		{
			dockable.setDividerLocation(0, 260);
		}
	}
}
