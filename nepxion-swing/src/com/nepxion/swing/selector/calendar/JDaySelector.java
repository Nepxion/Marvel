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

import com.nepxion.swing.font.FontContext;
import com.toedter.calendar.JDayChooser;

public class JDaySelector
	extends JDayChooser
{
	/**
	 * Constructs with the default.
	 */
	public JDaySelector()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial week of year visible.
	 * @param weekOfYearVisible the boolean value of weekOfYearVisible
	 */
	public JDaySelector(boolean weekOfYearVisible)
	{
		super(weekOfYearVisible);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		setFont(FontContext.getFont());
	}
}