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
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.nepxion.swing.dialog.JOptionDialog;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;

public abstract class JMonthSelectorDialog
	extends JOptionDialog implements IMonthSelectorComponent
{	
	/**
	 * The instance of JMonthSelector.
	 */
	private JMonthSelector monthSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial frame and time selector.
	 * @param owner the instance of Frame
	 * @param monthSelector the instance of JMonthSelector
	 */
	public JMonthSelectorDialog(Frame owner, JMonthSelector monthSelector)
	{
		this(owner, monthSelector, true);
	}
	
	/**
	 * Constructs with the specified initial dialog and time selector.
	 * @param owner the instance of Dialog
	 * @param monthSelector the instance of JMonthSelector
	 */
	public JMonthSelectorDialog(Dialog owner, JMonthSelector monthSelector)
	{
		this(owner, monthSelector, true);
	}
	
	/**
	 * Constructs with the specified initial frame, time selector and modal.
	 * @param owner the instance of Frame
	 * @param monthSelector the instance of JMonthSelector
	 * @param modal the boolean value of modal
	 */
	public JMonthSelectorDialog(Frame owner, JMonthSelector monthSelector, boolean modal)
	{
		this(owner, monthSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial dialog, time selector and modal.
	 * @param owner the instance of Dialog
	 * @param monthSelector the instance of JMonthSelector
	 * @param modal the boolean value of modal
	 */
	public JMonthSelectorDialog(Dialog owner, JMonthSelector monthSelector, boolean modal)
	{
		this(owner, monthSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial frame, time selector, modal and hint.
	 * @param owner the instance of Frame
	 * @param monthSelector the instance of JMonthSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JMonthSelectorDialog(Frame owner, JMonthSelector monthSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("month_selector"), new Dimension(280, 145), modal, hint, true);
		
		this.monthSelector = monthSelector;
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial dialog, time selector, modal and hint.
	 * @param owner the instance of Dialog
	 * @param monthSelector the instance of JMonthSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JMonthSelectorDialog(Dialog owner, JMonthSelector monthSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("month_selector"), new Dimension(280, 145), modal, hint, true);
		
		this.monthSelector = monthSelector;
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(monthSelector, BorderLayout.NORTH);
		
		getOptionPanel().setBorder(BorderFactory.createEmptyBorder(15, 15, 0, 15));
		
		setOption(YES_NO_OPTION);
		setIcon(IconFactory.getSwingIcon("component/calendar_48.png"));
		setContent(layoutPanel);
		
		Dimension size = getSize();
		setMinimumDimension(size);
		setMaximumDimension(size);
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
		
		layoutPanel.removeAll();
		layoutPanel.add(monthSelector, BorderLayout.NORTH);
	}
		
	/**
	 * Returns true if it is confirmed.
	 * @return true if it is confirmed
	 */
	public abstract boolean confirm();
	
	/**
	 * Returns true if it is cancelled.
	 * @return true if it is cancelled.
	 */
	public abstract boolean cancel();
}