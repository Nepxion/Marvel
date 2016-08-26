package com.nepxion.swing.thread.dialog;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Dialog;
import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import com.nepxion.swing.exception.ExceptionTracer;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;

public abstract class JThreadDialog
	extends AbstractThreadDialog
{
	/**
	 * The instance of SwingWorker.
	 */
	private SwingWorker swingWorker;
	
	/**
	 * The delay time value.
	 */
	private int delayTime = 200;

	/**
	 * Constructs with the specified initial frame and title.
	 * @param owner the instance of Frame
	 * @param title the title string
	 */
	public JThreadDialog(Frame owner, String title)
	{
		this(owner, title, SwingLocale.getString("transact_and_wait"));
	}
	
	/**
	 * Constructs with the specified initial dialog and title.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 */
	public JThreadDialog(Dialog owner, String title)
	{
		this(owner, title, SwingLocale.getString("transact_and_wait"));
	}
	
	/**
	 * Constructs with the specified initial frame, title and information.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param information the information string
	 */
	public JThreadDialog(Frame owner, String title, String information)
	{
		this(owner, title, new JLabel(IconFactory.getSwingIcon("thread/progress.gif")), information);
	}
	
	/**
	 * Constructs with the specified initial dialog, title and information.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param information the information string
	 */
	public JThreadDialog(Dialog owner, String title, String information)
	{
		this(owner, title, new JLabel(IconFactory.getSwingIcon("thread/progress.gif")), information);
	}
	
	/**
	 * Constructs with the specified initial frame, title, animation label and information.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param animationLabel the animation label
	 * @param information the information string
	 */
	public JThreadDialog(Frame owner, String title, JLabel animationLabel, String information)
	{
		super(owner, title, animationLabel, information);
	}
	
	/**
	 * Constructs with the specified initial dialog, title, animation label and information.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param animationLabel the animation label
	 * @param information the information string
	 */
	public JThreadDialog(Dialog owner, String title, JLabel animationLabel, String information)
	{
		super(owner, title, animationLabel, information);
	}
	
	/**
	 * Executes.
	 */
	public void execute()
	{
		swingWorker = new SwingWorker();
		swingWorker.execute();
		
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				setVisible(true);
				dispose();
			}
		}
		);
	}
	
	/**
	 * Fires the hidden.
	 */
	protected void fireHidden()
	{
		dispose();
	}
	
	/**
	 * Fires the cancelled.
	 */
	protected void fireCancelled()
	{
		if (swingWorker != null)
		{
			swingWorker.cancel(true);
		}
	}
	
	/**
	 * Gets the delay time.
	 * @return the delay time value
	 */
	public int getDelayTime()
	{
		return delayTime;
	}
	
	/**
	 * Sets the delay time.
	 * @param delayTime the delay time value
	 */
	public void setDelayTime(int delayTime)
	{
		this.delayTime = delayTime;
	}
	
	public class SwingWorker
		extends AbstractSwingWorker
	{		
		/**
		 * Constructs with the default.
		 */
		public SwingWorker()
		{
			super(JThreadDialog.this, delayTime);
		}
		
		/**
		 * Loads the foreground.
		 * @param data the background data
		 * @throws Exception
		 */
		protected void loadForeground(final Object data)
			throws Exception
		{
			SwingUtilities.invokeLater(new Runnable()
			{
				public void run()
				{
					if (data instanceof Exception)
					{
						return;
					}
					
					try
					{
						JThreadDialog.this.loadForeground(data);
					}
					catch (Exception e)
					{
						e.printStackTrace();
						
						fireForegroundException(e);
						
						Exception exception = null;
						if (e.getCause() != null && e.getCause() instanceof Exception)
						{
							exception = (Exception) e.getCause();
						}
						else
						{
							exception = e;
						}
						
						ExceptionTracer.traceException(HandleManager.getFrame(SwingWorker.this.getComponent()), exception);
						
						return;
					}
					
					fireHidden();
				}
			}
			);
		}
		
		/**
		 * Loads the background.
		 * @return the background data
		 * @throws Exception
		 */
		protected Object loadBackground()
			throws Exception
		{
			return JThreadDialog.this.loadBackground();
		}
	}
	
	/**
	 * Loads the foreground.
	 * @param data the background data
	 * @throws Exception
	 */
	protected abstract void loadForeground(Object data)
		throws Exception;
	
	/**
	 * Loads the background.
	 * @return the background data
	 * @throws Exception
	 */
	protected abstract Object loadBackground()
		throws Exception;
}