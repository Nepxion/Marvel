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

public class JYearSelectorOptionPane
	extends JBasicOptionPane implements IYearSelectorComponent
{
	/**
	 * The owner.
	 */
	private Component owner;
	
	/**
	 * The instance of JYearSelector.
	 */
	private JYearSelector yearSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial owner and year selector.
	 * @param owner the instance of Component
	 * @param yearSelector the instance of JYearSelector
	 */
	public JYearSelectorOptionPane(Component owner, JYearSelector yearSelector)
	{
		this.owner = owner;
		this.yearSelector = yearSelector;
		this.yearSelector.setPreferredSize(new Dimension(180, yearSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(yearSelector, BorderLayout.NORTH);
	}
	
	/**
	 * Shows the year selector dialog.
	 * @return the selected value
	 */
	public int showYearDialog()
	{
		return showDialog(owner, layoutPanel, SwingLocale.getString("year_selector"), IconFactory.getSwingIcon("component/calendar_48.png"));
	}
	
	/**
	 * Gets the year selector.
	 * @return the instance of JYearSelector
	 */
	public JYearSelector getYearSelector()
	{
		return yearSelector;
	}
	
	/**
	 * Sets the year selector.
	 * @param yearSelector the instance of JYearSelector
	 */
	public void setYearSelector(JYearSelector yearSelector)
	{
		this.yearSelector = yearSelector;
		this.yearSelector.setPreferredSize(new Dimension(180, this.yearSelector.getPreferredSize().height));
		
		layoutPanel.removeAll();
		layoutPanel.add(yearSelector);
	}
}