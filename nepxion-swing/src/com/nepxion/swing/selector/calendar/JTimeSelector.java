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

import java.awt.Dimension;
import java.util.Date;

import javax.swing.SpinnerDateModel;

import com.jidesoft.spinner.DateSpinner;

public class JTimeSelector
	extends DateSpinner
{
	/**
	 * Constructs with the default.
	 */
	public JTimeSelector()
	{
		super("HH:mm:ss");
	}
	
	/**
	 * Constructs with the specified initial date format string. 
	 * @param dateFormatString the date format string
	 */
	public JTimeSelector(String dateFormatString)
	{
		super(dateFormatString);
	}
	
	/**
	 * Constructs with the specified initial date format string and date. 
	 * @param dateFormatString the date format string
	 * @param date the instance of Date
	 */
	public JTimeSelector(String dateFormatString, Date date)
	{
		super(dateFormatString, date);
	}
	
	/**
	 * Gets the time.
	 * @return the instance of Date
	 */
	public Date getTime()
	{
		SpinnerDateModel model = (SpinnerDateModel) getModel();
		Object value = model.getValue();
		if (value instanceof Date)
		{
			return (Date) value;
		}
		
		return null;
	}
	
	/**
	 * Sets the time.
	 * @param date the instance of Date
	 */
	public void setTime(Date date)
	{
		SpinnerDateModel model = (SpinnerDateModel) getModel();
		model.setValue(date);
	}
	
	/**
	 * Gets the preferred size.
	 * @return the instance of Dimension
	 */
	public Dimension getPreferredSize()
	{
		Dimension preferredSize = super.getPreferredSize();
		
		return new Dimension(preferredSize.width + 5, preferredSize.height);
	}
}