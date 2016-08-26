package com.nepxion.swing.selector.calendar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.JComboBox;

import com.nepxion.swing.font.FontContext;
import com.toedter.calendar.JMonthChooser;

public class JMonthSelector
	extends JMonthChooser
{
	/**
	 * Constructs with the default.
	 */
	public JMonthSelector()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial spinner.
	 * @param hasSpinner the boolean value of hasSpinner
	 */
	public JMonthSelector(boolean hasSpinner)
	{
		super(hasSpinner);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		setFont(FontContext.getFont());
		
		JComboBox comboBox = (JComboBox) getComboBox();
		CalendarManager.setPreferenceStyle(comboBox);
	}
}