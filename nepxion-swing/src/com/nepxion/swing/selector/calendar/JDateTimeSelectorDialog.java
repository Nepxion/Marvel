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

public abstract class JDateTimeSelectorDialog
	extends JOptionDialog implements IDateTimeSelectorComponent
{	
	/**
	 * The instance of JDateTimeSelector.
	 */
	private JDateTimeSelector dateTimeSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial frame and date time selector.
	 * @param owner the instance of Frame
	 * @param dateTimeSelector the instance of JDateTimeSelector
	 */
	public JDateTimeSelectorDialog(Frame owner, JDateTimeSelector dateTimeSelector)
	{
		this(owner, dateTimeSelector, true);
	}
	
	/**
	 * Constructs with the specified initial dialog and date time selector.
	 * @param owner the instance of Dialog
	 * @param dateTimeSelector the instance of JDateTimeSelector
	 */
	public JDateTimeSelectorDialog(Dialog owner, JDateTimeSelector dateTimeSelector)
	{
		this(owner, dateTimeSelector, true);
	}
	
	/**
	 * Constructs with the specified initial frame, date time selector and modal.
	 * @param owner the instance of Frame
	 * @param dateTimeSelector the instance of JDateTimeSelector
	 * @param modal the boolean value of modal
	 */
	public JDateTimeSelectorDialog(Frame owner, JDateTimeSelector dateTimeSelector, boolean modal)
	{
		this(owner, dateTimeSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial dialog, date time selector and modal.
	 * @param owner the instance of Dialog
	 * @param dateTimeSelector the instance of JDateTimeSelector
	 * @param modal the boolean value of modal
	 */
	public JDateTimeSelectorDialog(Dialog owner, JDateTimeSelector dateTimeSelector, boolean modal)
	{
		this(owner, dateTimeSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial frame, date time selector, modal and hint.
	 * @param owner the instance of Frame
	 * @param dateTimeSelector the instance of JDateTimeSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JDateTimeSelectorDialog(Frame owner, JDateTimeSelector dateTimeSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("date_time_selector"), new Dimension(285, 145), modal, hint, true);
		
		this.dateTimeSelector = dateTimeSelector;
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial dialog, date time selector, modal and hint.
	 * @param owner the instance of Dialog
	 * @param dateTimeSelector the instance of JDateTimeSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JDateTimeSelectorDialog(Dialog owner, JDateTimeSelector dateTimeSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("date_time_selector"), new Dimension(285, 145), modal, hint, true);
		
		this.dateTimeSelector = dateTimeSelector;
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(dateTimeSelector, BorderLayout.NORTH);
		
		getOptionPanel().setBorder(BorderFactory.createEmptyBorder(15, 15, 0, 15));
		
		setOption(YES_NO_OPTION);
		setIcon(IconFactory.getSwingIcon("component/calendar_48.png"));
		setContent(layoutPanel);
		
		Dimension size = getSize();
		setMinimumDimension(size);
		setMaximumDimension(size);
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
		
		layoutPanel.removeAll();
		layoutPanel.add(dateTimeSelector, BorderLayout.NORTH);
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