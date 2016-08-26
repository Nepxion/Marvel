package com.nepxion.swing.radiobutton;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JRadioButton;

public class JBasicRadioButton
	extends JRadioButton
{
	/**
	 * 
	 */
	public JBasicRadioButton()
	{
		super();
		
		initComponents();
	}
	
	public JBasicRadioButton(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	public JBasicRadioButton(Icon icon, String toolTipText)
	{
		super(icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JBasicRadioButton(Action a)
	{
		super(a);
		
		initComponents();
	}
	
	public JBasicRadioButton(Icon icon, boolean selected)
	{
		super(icon, selected);
		
		initComponents();
	}
	
	public JBasicRadioButton(Icon icon, String toolTipText, boolean selected)
	{
		super(icon, selected);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JBasicRadioButton(String text)
	{
		super(text);
		
		initComponents();
	}
	
	public JBasicRadioButton(String text, String toolTipText)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JBasicRadioButton(String text, boolean selected)
	{
		super(text, selected);
		
		initComponents();
	}
	
	public JBasicRadioButton(String text, String toolTipText, boolean selected)
	{
		super(text, selected);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JBasicRadioButton(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	public JBasicRadioButton(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JBasicRadioButton(String text, Icon icon, boolean selected)
	{
		super(text, icon, selected);
		
		initComponents();
	}
	
	public JBasicRadioButton(String text, Icon icon, String toolTipText, boolean selected)
	{
		super(text, icon, selected);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	private void initComponents()
	{
		RadioButtonManager.setPreferenceStyle(this);
	}
}