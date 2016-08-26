package com.nepxion.swing.scrollpane;

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

import javax.swing.JScrollPane;

public class ScrollPaneManager
{
	/**
	 * Sets the preference style for the scroll pane.
	 * @param scrollPane the instance of JScrollPane
	 */
	public static void setPreferenceStyle(JScrollPane scrollPane)
	{
		scrollPane.getViewport().setBackground(Color.white);
	}
	
	/**
	 * Sets the label style for the scroll pane.
	 * @param scrollPane the instance of JScrollPane
	 */
	public static void setLabelStyle(JScrollPane scrollPane)
	{
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
	}
}