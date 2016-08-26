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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.jdesktop.swingworker.SwingWorker;

public class PropertyChangeAdapter
	implements PropertyChangeListener
{
	/**
	 * Invoked when a property value is changed.
	 */
	public void propertyChange(PropertyChangeEvent e)
	{
		if (e.getPropertyName().equals("state"))
		{
			Object newValue = e.getNewValue();
			if (newValue == SwingWorker.StateValue.PENDING) // SwingWorker��������ûִ��doInBackground()������PENDING״̬
			{
				firePendingStatusChanged();
			}
			else if (newValue == SwingWorker.StateValue.STARTED) // SwingWorkerִ��doInBackground()�У�����STARTED״̬
			{
				fireStartedStatusChanged();
			}
			else if (newValue == SwingWorker.StateValue.DONE) // SwingWorkerִ��done()�У� ����DONE״̬
			{
				fireDoneStatusChanged();
			}
		}
		else if (e.getPropertyName().equals("progress")) // SwingWorkerִ�еĽ�������ʾ
		{
			Object value = e.getNewValue();
			fireProgressValueChanged(value);
		}
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
}