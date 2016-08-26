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

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComponent;

import com.nepxion.swing.button.JArrowButton;
import com.nepxion.swing.textfield.JBasicTextField;

public class JDropDownSelector
	extends JComponent
{
	private JBasicTextField textField;
	private JArrowButton arrowButton;
	
	private IDropDownPane dropDownPane;
	
	public JDropDownSelector()
	{
		this(null);
	}
	
	public JDropDownSelector(IDropDownPane dropDownPane)
	{
		textField = new JBasicTextField();
		textField.setEditable(false);
		textField.setBackground(Color.white);
		
		arrowButton = new JArrowButton();
		
		setLayout(new BorderLayout());
		add(textField, BorderLayout.CENTER);
		add(arrowButton, BorderLayout.EAST);
		
		setDropDownPane(dropDownPane);
	}
	
	public IDropDownPane getDropDownPane()
	{
		return dropDownPane;
	}
	
	public void setDropDownPane(IDropDownPane dropDownPane)
	{
		if (dropDownPane == null)
		{
			return;
		}
		
		this.dropDownPane = dropDownPane;
		
		IDropDownPopupMenu popupMenu = this.dropDownPane.getPopupMenu();
		popupMenu.registerOwner(this);
		popupMenu.registerRenderer(textField);
		popupMenu.registerButton(arrowButton);
	}
	
	public JBasicTextField getTextField()
	{
		return textField;
	}
	
	public JButton getArrawButton()
	{
		return arrowButton;
	}
}