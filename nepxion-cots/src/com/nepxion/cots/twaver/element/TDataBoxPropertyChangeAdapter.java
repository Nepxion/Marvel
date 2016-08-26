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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import twaver.TDataBox;
import twaver.TWaverConst;

public class TDataBoxPropertyChangeAdapter
	implements PropertyChangeListener
{
	public TDataBoxPropertyChangeAdapter(TDataBox dataBox)
	{
		dataBox.addElementPropertyChangeListener(this);
	}
	
	public void propertyChange(PropertyChangeEvent e)
	{
		Object object = e.getSource();
		if (!(object instanceof TNode))
		{
			return;
		}
		
		TNode node = (TNode) object;
		if (e.getPropertyName().endsWith(TWaverConst.PROPERTYNAME_PARENT))
		{
			node.enableChildrenHidden();
		}
		if (e.getPropertyName().endsWith(TWaverConst.PROPERTYNAME_CHILDREN))
		{
			node.enableChildrenHidden();
		}
	}
}