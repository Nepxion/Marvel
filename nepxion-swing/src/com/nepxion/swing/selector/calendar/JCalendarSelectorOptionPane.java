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

import javax.swing.JPanel;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public class JCalendarSelectorOptionPane
	extends JBasicOptionPane implements ICalendarSelectorComponent
{
	/**
	 * The owner.
	 */
	private Component owner;
	
	/**
	 * The instance of JCalendarSelector.
	 */
	private JCalendarSelector calendarSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial owner and calendar selector.
	 * @param owner the instance of Component
	 * @param calendarSelector the instance of JCalendarSelector
	 */
	public JCalendarSelectorOptionPane(Component owner, JCalendarSelector calendarSelector)
	{
		this.owner = owner;
		this.calendarSelector = calendarSelector;
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(calendarSelector, BorderLayout.NORTH);
	}
	
	/**
	 * Shows the calendar selector dialog.
	 * @return the selected value
	 */
	public int showCalendarDialog()
	{
		return showDialog(owner, layoutPanel, SwingLocale.getString("calendar_selector"), IconFactory.getSwingIcon("component/calendar_48.png"));
	}
	
	/**
	 * Gets the calendar selector.
	 * @return the instance of JCalendarSelector
	 */
	public JCalendarSelector getCalendarSelector()
	{
		return calendarSelector;
	}
	
	/**
	 * Sets the calendar selector.
	 * @param calendarSelector the instance of JCalendarSelector
	 */
	public void setCalendarSelector(JCalendarSelector calendarSelector)
	{
		this.calendarSelector = calendarSelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(calendarSelector);
	}
}