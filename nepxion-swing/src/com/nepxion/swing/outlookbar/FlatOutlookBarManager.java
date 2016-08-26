package com.nepxion.swing.outlookbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.plaf.ScrollBarUI;

import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.style.scrollpane.ScrollPaneUIManager;

public class FlatOutlookBarManager
{
	/**
	 * Sets the preference style for the scroll pane.
	 * @param scrollPane the instance of JScrollPane
	 */	
	public static void setPreferenceStyle(JScrollPane scrollPane)
	{
		ScrollBarUI scrollBarUI = null;
		
		if (!LookAndFeelManager.isNimbusLookAndFeel())
		{
			scrollBarUI = ScrollPaneUIManager.getScrollBarUI();
		}
		else
		{
			JScrollBar scrollBar = new JScrollBar();
			scrollBarUI = scrollBar.getUI();
			
			scrollPane.setViewportBorder(BorderFactory.createEmptyBorder());
		}
		
		scrollPane.getVerticalScrollBar().setUI(scrollBarUI);
	}
}