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

public class JDateSelectorOptionPane
	extends JBasicOptionPane implements IDateSelectorComponent
{
	/**
	 * The owner.
	 */
	private Component owner;
	
	/**
	 * The instance of JDateSelector.
	 */
	private JDateSelector dateSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial owner and date selector.
	 * @param owner the instance of Component
	 * @param dateSelector the instance of JDateSelector
	 */
	public JDateSelectorOptionPane(Component owner, JDateSelector dateSelector)
	{
		this.owner = owner;
		this.dateSelector = dateSelector;
		this.dateSelector.setPreferredSize(new Dimension(180, dateSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(dateSelector, BorderLayout.NORTH);
	}
	
	/**
	 * Shows the date selector dialog.
	 * @return the selected value
	 */
	public int showDateDialog()
	{
		return showDialog(owner, layoutPanel, SwingLocale.getString("date_selector"), IconFactory.getSwingIcon("component/calendar_48.png"));
	}
	
	/**
	 * Gets the date selector.
	 * @return the instance of JDateSelector
	 */
	public JDateSelector getDateSelector()
	{
		return dateSelector;
	}
	
	/**
	 * Sets the date selector.
	 * @param dateSelector the instance of JDateSelector
	 */
	public void setDateSelector(JDateSelector dateSelector)
	{
		this.dateSelector = dateSelector;
		this.dateSelector.setPreferredSize(new Dimension(180, this.dateSelector.getPreferredSize().height));
		
		layoutPanel.removeAll();
		layoutPanel.add(dateSelector);
	}
}