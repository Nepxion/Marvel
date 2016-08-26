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

public class JDaySelectorOptionPane
	extends JBasicOptionPane implements IDaySelectorComponent
{
	/**
	 * The owner.
	 */
	private Component owner;
	
	/**
	 * The instance of JDaySelector.
	 */
	private JDaySelector daySelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial owner and day selector.
	 * @param owner the instance of Component
	 * @param daySelector the instance of JDaySelector
	 */
	public JDaySelectorOptionPane(Component owner, JDaySelector daySelector)
	{
		this.owner = owner;
		this.daySelector = daySelector;
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(daySelector, BorderLayout.NORTH);
	}
	
	/**
	 * Shows the day selector dialog.
	 * @return the selected value
	 */
	public int showDayDialog()
	{
		return showDialog(owner, layoutPanel, SwingLocale.getString("day_selector"), IconFactory.getSwingIcon("component/calendar_48.png"));
	}
	
	/**
	 * Gets the day selector.
	 * @return the instance of JDaySelector
	 */
	public JDaySelector getDaySelector()
	{
		return daySelector;
	}
	
	/**
	 * Sets the day selector.
	 * @param daySelector the instance of JDaySelector
	 */
	public void setDaySelector(JDaySelector daySelector)
	{
		this.daySelector = daySelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(daySelector);
	}
}