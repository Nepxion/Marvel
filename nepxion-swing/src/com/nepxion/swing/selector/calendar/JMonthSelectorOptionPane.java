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

public class JMonthSelectorOptionPane
	extends JBasicOptionPane implements IMonthSelectorComponent
{
	/**
	 * The owner.
	 */
	private Component owner;
	
	/**
	 * The instance of JMonthSelector.
	 */
	private JMonthSelector monthSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial owner and month selector.
	 * @param owner the instance of Component
	 * @param monthSelector the instance of JMonthSelector
	 */
	public JMonthSelectorOptionPane(Component owner, JMonthSelector monthSelector)
	{
		this.owner = owner;
		this.monthSelector = monthSelector;
		this.monthSelector.setPreferredSize(new Dimension(180, monthSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(monthSelector, BorderLayout.NORTH);
	}
	
	/**
	 * Shows the month selector dialog.
	 * @return the selected value
	 */
	public int showMonthDialog()
	{
		return showDialog(owner, layoutPanel, SwingLocale.getString("month_selector"), IconFactory.getSwingIcon("component/calendar_48.png"));
	}
	
	/**
	 * Gets the month selector.
	 * @return the instance of JMonthSelector
	 */
	public JMonthSelector getMonthSelector()
	{
		return monthSelector;
	}
	
	/**
	 * Sets the month selector.
	 * @param monthSelector the instance of JMonthSelector
	 */
	public void setMonthSelector(JMonthSelector monthSelector)
	{
		this.monthSelector = monthSelector;
		this.monthSelector.setPreferredSize(new Dimension(180, this.monthSelector.getPreferredSize().height));
		
		layoutPanel.removeAll();
		layoutPanel.add(monthSelector);
	}
}