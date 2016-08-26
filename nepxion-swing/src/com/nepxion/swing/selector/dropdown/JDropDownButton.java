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

import javax.swing.Icon;

import com.nepxion.swing.button.JBasicButton;

public abstract class JDropDownButton
	extends JBasicButton
{
	/**
	 * Constructs with the default.
	 */
	public JDropDownButton()
	{
		super();
	}
	
	public JDropDownButton(String text)
	{
		super(text);
	}
	
	public JDropDownButton(Icon icon)
	{
		super(icon);
	}
	
	public JDropDownButton(Icon icon, String toolTipText)
	{
		super(icon, toolTipText);
	}
	
	public JDropDownButton(String text, String toolTipText)
	{
		super(text, toolTipText);
	}
	
	public JDropDownButton(String text, Icon icon)
	{
		super(text, icon);
	}
	
	public JDropDownButton(String text, Icon icon, String toolTipText)
	{
		super(text, icon, toolTipText);
	}
	
	public void setDropDownPane(IDropDownPane dropDownPane)
	{
		if (dropDownPane == null)
		{
			return;
		}
		
		IDropDownPopupMenu popupMenu = dropDownPane.getPopupMenu();
		popupMenu.registerOwner(this);
		popupMenu.registerRenderer(this);
		popupMenu.registerButton(this);
	}
}