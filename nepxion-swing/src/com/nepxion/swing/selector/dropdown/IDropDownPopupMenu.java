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

import java.awt.Component;

import javax.swing.AbstractButton;

public interface IDropDownPopupMenu
{
	public void registerOwner(Component owner);
	
	public void registerDropDownPane(IDropDownPane dropDownPane);
	
	public void registerRenderer(Component component);
	
	public void registerButton(AbstractButton button);
	
	public void adaptVisibility();
	
	public void showPopupMenu();
	
	public void hidePopupMenu();
	
	public void setPopupMenuWidth(int width);
	
	public void setPopupMenuHeight(int height);
}