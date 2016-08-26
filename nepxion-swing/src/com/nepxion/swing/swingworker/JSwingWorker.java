package com.nepxion.swing.swingworker;

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

import org.jdesktop.swingworker.SwingWorker;

import com.nepxion.swing.exception.ExceptionTracer;
import com.nepxion.swing.handle.HandleManager;

public abstract class JSwingWorker
	extends SwingWorker
{
	/**
	 * The instance of Component.
	 */
	private Component component;
	
	/**
	 * Constructs with the default.
	 */
	public JSwingWorker()
	{
		this(null);
	}
	
	/**
	 * Constructs with the specified initial component.
	 * @param component the instance of Component
	 */
	public JSwingWorker(Component component)
	{
		this.component = component;
		
		addPropertyChangeListener(new PropertyChangeAdapter()
		{
			public void firePendingStatusChanged()
			{
				JSwingWorker.this.firePendingStatusChanged();
			}
			
			public void fireStartedStatusChanged()
			{
				JSwingWorker.this.fireStartedStatusChanged();
			}
			
			public void fireDoneStatusChanged()
			{
				JSwingWorker.this.fireDoneStatusChanged();
			}
			
			public void fireProgressValueChanged(Object value)
			{
				JSwingWorker.this.fireProgressValueChanged(value);
			}
		}
		);
	}
	
	/**
	 * Gets the component.
	 * @return the instance of Component
	 */
	public Component getComponent()
	{
		return component;
	}
	
	/**
	 * Sets the component.
	 * @param component the instance of Component
	 */
	public void setComponent(Component component)
	{
		this.component = component;
	}
	
	/**
	 * Invoked when the swing worker loads the foreground data.
	 * It is mainly used for the gui updating. 
	 */
	protected void done()
	{
		if (isCancelled())
		{
			fireCancelledStatusChanged();
			
			return;
		}
		
		Object data = null;
		try
		{
			data = get();
		}
		catch (Exception e)
		{
			data = e;
		}
		
		if (data instanceof Exception)
		{
			Exception e = (Exception) data;
			fireForegroundException(e);
			if (component != null)
			{
				ExceptionTracer.traceException(HandleManager.getFrame(component), e);
			}
		}	
		
		try
		{
			loadForeground(data);
		}
		catch (Exception e)
		{
			fireForegroundException(e);
			if (component != null)
			{
				ExceptionTracer.traceException(HandleManager.getFrame(component), e);
			}
		}
	}
	
	/**
	 * Invoked when the swing worker loads the background data.
	 * @return the background data
	 */
	protected Object doInBackground()
		throws Exception
	{
		Object data = null;
		try
		{
			data = loadBackground();
		}
		catch (Exception e)
		{
			if (!isCancelled())
			{
				fireBackgroundException(e);
				
				throw e;
			}
		}
		
		return data;
	}
	
	/**
	 * Fires the pending status changed.
	 */
	public void firePendingStatusChanged()
	{
		
	}
	
	/**
	 * Fires the started status changed.
	 */
	public void fireStartedStatusChanged()
	{
		
	}
	
	/**
	 * Fires the done status changed.
	 */
	public void fireDoneStatusChanged()
	{
		
	}
	
	/**
	 * Fires the progress value changed.
	 * @param value the value object
	 */
	public void fireProgressValueChanged(Object value)
	{
		
	}
	
	/**
	 * Fires the cancelled status changed.
	 */
	public void fireCancelledStatusChanged()
	{
		
	}
	
	/**
	 * Fires the foreground exception.
	 * @param e the instance of Exception
	 */
	public void fireForegroundException(Exception e)
	{
		
	}
	
	/**
	 * Fires the background exception.
	 * @param e the instance of Exception
	 */
	public void fireBackgroundException(Exception e)
	{
		
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