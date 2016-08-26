package com.nepxion.swing.selector.locale;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.JComponent;

import com.nepxion.swing.combobox.ComboBoxManager;
import com.toedter.components.JLocaleChooser;

public class JLocaleSelector
	extends JLocaleChooser
{
	/**
	 * Constructs with the default.
	 */
	public JLocaleSelector()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial component.
	 * @param component the instance of JComponent
	 */
	public JLocaleSelector(JComponent component) 
	{
		super(component);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		ComboBoxManager.setPreferenceStyle(this);
	}
}