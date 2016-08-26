package com.nepxion.swing.radiobutton;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.JRadioButton;

import com.nepxion.swing.lookandfeel.LookAndFeelManager;

public class RadioButtonManager
{
	public static void setPreferenceStyle(JRadioButton radioButton)
	{
		if (!LookAndFeelManager.isNimbusLookAndFeel())
		{
			radioButton.setFocusPainted(false);
		}
	}
}