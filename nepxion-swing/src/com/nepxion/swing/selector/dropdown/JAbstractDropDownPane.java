package com.nepxion.swing.selector.dropdown;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.JPanel;

public abstract class JAbstractDropDownPane
	extends JPanel implements IDropDownPane
{
	private IDropDownPopupMenu popupMenu;
	
	public JAbstractDropDownPane(IDropDownPopupMenu popupMenu)
	{
		this.popupMenu = popupMenu;
		this.popupMenu.registerDropDownPane(this);
	}
	
	public IDropDownPopupMenu getPopupMenu()
	{
		return popupMenu;
	}
}