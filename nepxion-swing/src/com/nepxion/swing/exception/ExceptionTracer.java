package com.nepxion.swing.exception;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Component;

import com.nepxion.swing.dialog.JExceptionDialog;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.util.exception.ExceptionUtil;

public class ExceptionTracer
{
	/**
	 * Traces the exception.
	 * @param owner the owner component
	 * @param e the instance of Exception
	 */
	public static void traceException(Component owner, Exception e)
	{
		traceException(owner, null, e);
	}
	
	/**
	 * Traces the exception.
	 * @param owner the owner component 
	 * @param hint the hint string
	 * @param e the instance of Exception
	 */
	public static void traceException(Component owner, String hint, Exception e)
	{
		boolean isDebug = ExceptionTracerContext.isDebug();
		if (isDebug)
		{
			if (hint == null)
			{
				JExceptionDialog.traceException(owner, ExceptionUtil.subString(e), e);
			}
			else
			{
				JExceptionDialog.traceException(owner, hint, e);
			}
		}
		else
		{
			if (hint == null)
			{
				JBasicOptionPane.showMessageDialog(owner, ExceptionUtil.subString(e), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			}
			else
			{
				JBasicOptionPane.showMessageDialog(owner, hint, SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			}
		}
	}
}