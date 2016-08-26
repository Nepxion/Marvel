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

import twaver.DataBoxSelectionAdapter;
import twaver.DataBoxSelectionEvent;
import twaver.TDataBox;

public class TDataBoxSelectionAdapter
	extends DataBoxSelectionAdapter
{
	private TDataBox dataBox;
	
	public TDataBoxSelectionAdapter(TDataBox dataBox)
	{
		this.dataBox = dataBox;
		this.dataBox.getSelectionModel().addDataBoxSelectionListener(this);
	}
		
	public void selectionChanged(DataBoxSelectionEvent e)
	{
	}
	
	public TDataBox getDataBox()
	{
		return dataBox;
	}
}