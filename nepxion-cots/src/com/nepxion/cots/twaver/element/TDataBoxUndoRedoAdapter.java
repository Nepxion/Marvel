package com.nepxion.cots.twaver.element;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.AbstractButton;

import twaver.TDataBox;
import twaver.UndoRedoListener;

public class TDataBoxUndoRedoAdapter
	implements UndoRedoListener
{
	private TDataBox dataBox;
	
	private AbstractButton undoButton;
	private AbstractButton redoButton;
	
	public TDataBoxUndoRedoAdapter(TDataBox dataBox, AbstractButton undoButton, AbstractButton redoButton)
	{
		this.dataBox = dataBox;
		this.undoButton = undoButton;
		this.redoButton = redoButton;
		this.dataBox.getUndoRedoManager().setLimit(200);
		this.dataBox.getUndoRedoManager().addUndoRedoListener(this);
		
		enableButton();
	}
	
	public void undid(Object event)
	{
		enableButton();
	}
	
	public void redid(Object event)
	{
		enableButton();
	}
	
	public void eventAdded(Object event)
	{
		enableButton();
	}
	
	public void eventRemoved(Object event)
	{
		enableButton();
	}
	
	public void reset()
	{
		enableButton();
	}
	
	public void enableButton()
	{
		undoButton.setEnabled(dataBox.getUndoRedoManager().canUndo());
		redoButton.setEnabled(dataBox.getUndoRedoManager().canRedo());
	}
}