package com.nepxion.swing.checkbox;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.JCheckBox;

import com.nepxion.swing.lookandfeel.LookAndFeelManager;

public class CheckBoxManager
{
	/**
	 * Sets the preference style for the check box.
	 * @param checkBox the instance of JCheckBox
	 */
	public static void setPreferenceStyle(JCheckBox checkBox)
	{
		if (!LookAndFeelManager.isNimbusLookAndFeel())
		{
			checkBox.setFocusPainted(false);
		}	
	}
}
