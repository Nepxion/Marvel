package com.nepxion.swing.shrinkbar;

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

public class ShrinkOutlookSelectionListener
	implements PropertyChangeListener
{
	public void propertyChange(PropertyChangeEvent e)
	{
		if (e.getPropertyName().equals("ancestor"))
		{
			JShrinkOutlook shrinkOutlook = (JShrinkOutlook) e.getSource();
			if (shrinkOutlook.isSelected())
			{
				selectionStateChanged(shrinkOutlook);
			}
			else
			{
				deselectionStateChanged(shrinkOutlook);
			}
		}
	}
	
	public void selectionStateChanged(JShrinkOutlook shrinkOutlook)
	{
		
	}
	
	public void deselectionStateChanged(JShrinkOutlook shrinkOutlook)
	{
		
	}
}