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

public class JTimeSelectorOptionPane
	extends JBasicOptionPane implements ITimeSelectorComponent
{
	/**
	 * The owner.
	 */
	private Component owner;
	
	/**
	 * The instance of JTimeSelector.
	 */
	private JTimeSelector timeSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial owner and time selector.
	 * @param owner the instance of Component
	 * @param timeSelector the instance of JTimeSelector
	 */
	public JTimeSelectorOptionPane(Component owner, JTimeSelector timeSelector)
	{
		this.owner = owner;
		this.timeSelector = timeSelector;
		this.timeSelector.setPreferredSize(new Dimension(180, timeSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(timeSelector, BorderLayout.NORTH);
	}
	
	/**
	 * Shows the time selector dialog.
	 * @return the selected value
	 */
	public int showTimeDialog()
	{
		return showDialog(owner, layoutPanel, SwingLocale.getString("time_selector"), IconFactory.getSwingIcon("component/calendar_48.png"));
	}
	
	/**
	 * Gets the time selector.
	 * @return the instance of JTimeSelector
	 */
	public JTimeSelector getTimeSelector()
	{
		return timeSelector;
	}
	
	/**
	 * Sets the time selector.
	 * @param timeSelector the instance of JTimeSelector
	 */
	public void setTimeSelector(JTimeSelector timeSelector)
	{
		this.timeSelector = timeSelector;
		this.timeSelector.setPreferredSize(new Dimension(180, this.timeSelector.getPreferredSize().height));
		
		layoutPanel.removeAll();
		layoutPanel.add(timeSelector);
	}
}