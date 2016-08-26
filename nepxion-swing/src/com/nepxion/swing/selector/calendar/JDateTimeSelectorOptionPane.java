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

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public class JDateTimeSelectorOptionPane
	extends JBasicOptionPane implements IDateTimeSelectorComponent
{
	/**
	 * The owner.
	 */
	private Component owner;
	
	/**
	 * The instance of JDateTimeSelector.
	 */
	private JDateTimeSelector dateTimeSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial owner and date time selector.
	 * @param owner the instance of Component
	 * @param dateTimeSelector the instance of JDateTimeSelector
	 */
	public JDateTimeSelectorOptionPane(Component owner, JDateTimeSelector dateTimeSelector)
	{
		this.owner = owner;
		this.dateTimeSelector = dateTimeSelector;
		this.dateTimeSelector.setPreferredSize(new Dimension(180, dateTimeSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(dateTimeSelector, BorderLayout.NORTH);
	}
	
	/**
	 * Shows the date time selector dialog.
	 * @return the selected value
	 */
	public int showDateTimeDialog()
	{
		return showDialog(owner, layoutPanel, SwingLocale.getString("date_time_selector"), IconFactory.getSwingIcon("component/calendar_48.png"));
	}
	
	/**
	 * Gets the date time selector. 
	 * @return the instance of JDateTimeSelector
	 */
	public JDateTimeSelector getDateTimeSelector()
	{
		return dateTimeSelector;
	}
	
	/**
	 * Sets the date time selector.
	 * @param dateTimeSelector the instance of JDateTimeSelector
	 */
	public void setDateTimeSelector(JDateTimeSelector dateTimeSelector)
	{
		this.dateTimeSelector = dateTimeSelector;
		this.dateTimeSelector.setPreferredSize(new Dimension(180, this.dateTimeSelector.getPreferredSize().height));
		
		layoutPanel.removeAll();
		layoutPanel.add(dateTimeSelector);
	}
}