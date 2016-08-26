package com.nepxion.swing.action;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.AbstractButton;

public class ActionManager
{
	/**
	 * Sets the button enabled.
	 * @param button the instance of AbstractButton
	 * @param enabled the boolean value if the button is enabled
	 */
	public static void setEnabled(AbstractButton button, boolean enabled)
	{
		if (button != null)
		{
			JSecurityAction action = (JSecurityAction) button.getAction();
			
			if (action.isPermitted())
			{	
				action.setEnabled(enabled);
			}
		}
	}
}