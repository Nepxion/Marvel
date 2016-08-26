package com.nepxion.swing.table.treetable;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.EventObject;

import javax.swing.CellEditor;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.EventListenerList;

public class AbstractCellEditor
    implements CellEditor
{
    protected EventListenerList listenerList = new EventListenerList();

    public Object getCellEditorValue()
    {
        return null;
    }

    public boolean isCellEditable(EventObject e)
    {
        return true;
    }

    public boolean shouldSelectCell(EventObject anEvent)
    {
        return false;
    }

    public boolean stopCellEditing()
    {
        return true;
    }

    public void cancelCellEditing()
    {}

    public void addCellEditorListener(CellEditorListener l)
    {
        listenerList.add(CellEditorListener.class, l);
    }

    public void removeCellEditorListener(CellEditorListener l)
    {
        listenerList.remove(CellEditorListener.class, l);
    }

    /*
     * Notify all listeners that have registered interest for
     * notification on this event type.
     * @see EventListenerList
     */
    protected void fireEditingStopped()
    {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2)
        {
            if (listeners[i] == CellEditorListener.class)
            {
                ((CellEditorListener) listeners[i + 1]).editingStopped(new ChangeEvent(this));
            }
        }
    }

    /*
     * Notify all listeners that have registered interest for
     * notification on this event type.
     * @see EventListenerList
     */
    protected void fireEditingCanceled()
    {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2)
        {
            if (listeners[i] == CellEditorListener.class)
            {
                ((CellEditorListener) listeners[i + 1]).editingCanceled(new ChangeEvent(this));
            }
        }
    }
}