package com.nepxion.swing.thread;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Color;

import com.nepxion.swing.border.LineBorder;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.thread.dialog.AbstractThreadDialog;

public class ThreadManager
{
	/**
	 * Sets the preference style of the thread dialog.
	 * @param threadDialog the instance of AbstractThreadDialog
	 */
	public static void setPreferenceStyle(AbstractThreadDialog threadDialog)
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			threadDialog.getLayoutPanel().setBorder(new LineBorder(new Color(167, 172, 180), 1));
		}
	}
	
	/**
	 * Gets the decorated margin.
	 * @param threadDialog the instance of AbstractThreadDialog
	 * @return the decorated margin value
	 */
	public static int getDecoratedMargin(AbstractThreadDialog threadDialog)
	{
		if (!LookAndFeelManager.isNimbusLookAndFeel())
		{
			return threadDialog.getDecoratedMargin();
		}
		else
		{
			return 0;
		}
	}
}