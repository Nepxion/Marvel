package com.nepxion.swing.query.condition;

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
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.selector.calendar.JDateTimeSelector;
import com.nepxion.swing.selector.calendar.editor.JSpinnerDateTimeEditor;
import com.nepxion.swing.validation.IValidation;
import com.nepxion.util.time.TimeConstants;
import com.nepxion.util.time.TimeUtil;

public class JQueryDateTimeBar
	extends JPanel implements SwingConstants, IValidation
{
	/**
	 * The start data time selector.
	 */
	private JDateTimeSelector startDateTimeSelector;
	
	/**
	 * The end data time selector.
	 */
	private JDateTimeSelector endDateTimeSelector;
	
	/**
	 * Constructs with the default.
	 */
	public JQueryDateTimeBar()
	{
		this(VERTICAL);
	}
	
	/**
	 * Constructs with the specified initial direction.
	 * @param direction the direction value
	 */
	public JQueryDateTimeBar(int direction)
	{
        Date endDateTime = new Date();
        Date startDateTime = TimeUtil.calculateDateTime(endDateTime, Calendar.HOUR, -24);
        
        JLabel startDateTimeLabel = new JLabel(SwingLocale.getString("start_time"));
		JLabel endDateTimeLabel = new JLabel(SwingLocale.getString("end_time"));
		
		startDateTimeSelector = new JDateTimeSelector(startDateTime, TimeConstants.DATE_TIME_FORMAT_STRING, new JSpinnerDateTimeEditor());		
		endDateTimeSelector = new JDateTimeSelector(endDateTime, TimeConstants.DATE_TIME_FORMAT_STRING, new JSpinnerDateTimeEditor());
		
		switch (direction)
		{
			case VERTICAL :
			{
				double[][] size = 
				{ 
					{60, TableLayout.FILL}, 
					{TableLayout.PREFERRED, TableLayout.PREFERRED}
				};
				
				TableLayout tableLayout = new TableLayout(size);
				tableLayout.setHGap(5);
				tableLayout.setVGap(5);
				setLayout(tableLayout);
				setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 2, 0, 2), BorderManager.createComplexTitledBorder(SwingLocale.getString("time_parameter"))));
				
				add(startDateTimeLabel, "0, 0");
				add(startDateTimeSelector, "1, 0");
				
				add(endDateTimeLabel, "0, 1");
				add(endDateTimeSelector, "1, 1");
				break;
			}
			case HORIZONTAL :
			{
				DimensionManager.setDimension(startDateTimeSelector, new Dimension(180, startDateTimeSelector.getPreferredSize().height));
				DimensionManager.setDimension(endDateTimeSelector, new Dimension(180, endDateTimeSelector.getPreferredSize().height));
				
				setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
				
				add(startDateTimeLabel);
				add(startDateTimeSelector);
				
				add(Box.createHorizontalStrut(5));
				
				add(endDateTimeLabel);
				add(endDateTimeSelector);
				break;
			}	
		}		
	}
	
	/**
	 * Gets the start date time selector.
	 * @return the instance of JDateTimeSelector
	 */
	public JDateTimeSelector getStartDateTimeSelector()
	{
		return startDateTimeSelector;
	}
	
	/**
	 * sets the start date time selector.
	 * @param startDateTimeSelector the instance of JDateTimeSelector
	 */
	public void setStartDateTimeSelector(JDateTimeSelector startDateTimeSelector)
	{
		this.startDateTimeSelector = startDateTimeSelector;
	}
	
	/**
	 * Gets the end date time selector.
	 * @return the instance of JDateTimeSelector
	 */
	public JDateTimeSelector getEndDateTimeSelector()
	{
		return endDateTimeSelector;
	}
	
	/**
	 * Sets the end date time selector.
	 * @param endDateTimeSelector the instance of JDateTimeSelector
	 */
	public void setEndDateTimeSelector(JDateTimeSelector endDateTimeSelector)
	{
		this.endDateTimeSelector = endDateTimeSelector;
	}
	
	/**
	 * Gets the time range.
	 * @return the time range string
	 */
	public String getTimeRange()
	{
		Date startDateTime = startDateTimeSelector.getDate();
		Date endDateTime = endDateTimeSelector.getDate();
		
		return TimeUtil.getDateTime(startDateTime) + " - " + TimeUtil.getDateTime(endDateTime);
	}
	
	/**
	 * Returns true if it is verified.
	 * @return true if it is verified
	 */
	public boolean verify()
	{
		Date startDateTime = startDateTimeSelector.getDate();
		Date endDateTime = endDateTimeSelector.getDate();
		
		return TimeUtil.isTimeBefore(TimeUtil.getDateTime(startDateTime), TimeUtil.getDateTime(endDateTime));
	}
}