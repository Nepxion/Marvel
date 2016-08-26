package com.nepxion.swing.thread.container;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import com.nepxion.swing.exception.ExceptionTracer;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.timer.JTimerLabel;

public abstract class JThreadContainer
	extends AbstractThreadContainer
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
	 * The boolean value of isLoadCache.
	 */
	private boolean isLoadCache = false;
	
	/**
	 * Constructs with the default.
	 */
	public JThreadContainer()
	{
		this(SwingLocale.getString("transact_and_wait"));
	}
	
	/**
	 * Constructs with the specified initial information.
	 * @param information the information string
	 */
	public JThreadContainer(String information)
	{
		this(new JTimerLabel(JTimerLabel.MAGNIFIER_ICON), information);
	}
	
	/**
	 * Constructs with the specified initial animation label and information.
	 * @param animationLabel the animation label
	 * @param information the information string
	 */
	public JThreadContainer(JLabel animationLabel, String information)
	{
		super(animationLabel, information);
	}
	
	/**
	 * Executes.
	 */
	public void execute()
	{
		if (!isLoadCache())
		{
			if (swingWorker == null)
			{
				swingWorker = new SwingWorker();
				swingWorker.execute();
			}
			else
			{
				if (swingWorker.isDone())
				{
					swingWorker = new SwingWorker();
					swingWorker.execute();
				}
			}
		}
		else
		{
			fireHidden();
		}
	}
	
	/**
	 * Fires the hidden.
	 */
	protected void fireHidden()
	{
		Component contentPane = getContentPane();
		if (contentPane != null)
		{	
			addComponent(contentPane, BorderLayout.CENTER);
		}
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
	
	/**
	 * Returns true if the container loads the cached component.
	 * @return true if the container loads the cached component
	 */
	public boolean isLoadCache()
	{
		return isLoadCache;
	}
	
	/**
	 * Sets the cache loaded.
	 * @param isLoadCache the boolean value of isLoadCache
	 */
	public void setLoadCache(boolean isLoadCache)
	{
		this.isLoadCache = isLoadCache;
	}
	
	public class SwingWorker
		extends AbstractSwingWorker
	{			
		/**
		 * Constructs with the default.
		 */
		public SwingWorker()
		{
			super(JThreadContainer.this, delayTime);
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
						JThreadContainer.this.loadForeground(data);
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
			return JThreadContainer.this.loadBackground();
		}
	}
	
	/**
	 * Gets the content pane.
	 * @return the instance of Component
	 */
	public abstract Component getContentPane();
	
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