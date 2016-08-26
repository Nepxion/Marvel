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

import java.awt.Font;

import javax.swing.UIManager;

import com.nepxion.swing.font.FontContext;

public class JTaskManager
{
	/**
	 * The task font string.
	 */
	public static final String TASK_FONT = "TaskPaneGroup.font";
	
	/**
	 * Installs the plain font to the task (JTaskAction, Button).
	 */
	public static void installTaskPlainFont()
	{
		Font font = FontContext.getFont();
		
		UIManager.put(TASK_FONT, new Font(font.getName(), Font.PLAIN, font.getSize()));
	}
}