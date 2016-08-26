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

import javax.swing.JSpinner;

import com.nepxion.swing.font.FontContext;
import com.toedter.calendar.JYearChooser;

public class JYearSelector
	extends JYearChooser
{
	/**
	 * Constructs with the default.
	 */
	public JYearSelector()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		setFont(FontContext.getFont());
		
		JSpinner spinner = (JSpinner) getSpinner();
		CalendarManager.setPreferenceStyle(spinner);
	}
}