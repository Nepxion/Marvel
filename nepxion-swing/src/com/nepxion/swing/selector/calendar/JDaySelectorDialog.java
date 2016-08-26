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

public abstract class JDaySelectorDialog
	extends JOptionDialog implements IDaySelectorComponent
{	
	/**
	 * The instance of JDaySelector.
	 */
	private JDaySelector daySelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial frame and day selector.
	 * @param owner the instance of Frame
	 * @param daySelector the instance of JDaySelector
	 */
	public JDaySelectorDialog(Frame owner, JDaySelector daySelector)
	{
		this(owner, daySelector, true);
	}
	
	/**
	 * Constructs with the specified initial dialog and day selector.
	 * @param owner the instance of Dialog
	 * @param daySelector the instance of JDaySelector
	 */
	public JDaySelectorDialog(Dialog owner, JDaySelector daySelector)
	{
		this(owner, daySelector, true);
	}
	
	/**
	 * Constructs with the specified initial frame, day selector and modal.
	 * @param owner the instance of Frame
	 * @param daySelector the instance of JDaySelector
	 * @param modal the boolean value of modal
	 */
	public JDaySelectorDialog(Frame owner, JDaySelector daySelector, boolean modal)
	{
		this(owner, daySelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial dialog, day selector and modal.
	 * @param owner the instance of Dialog
	 * @param daySelector the instance of JDaySelector
	 * @param modal the boolean value of modal
	 */
	public JDaySelectorDialog(Dialog owner, JDaySelector daySelector, boolean modal)
	{
		this(owner, daySelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial frame, day selector, modal and hint.
	 * @param owner the instance of Frame
	 * @param daySelector the instance of JDaySelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JDaySelectorDialog(Frame owner, JDaySelector daySelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("day_selector"), new Dimension(380, CalendarManager.getDaySelectorDialogHeight()), modal, hint, true);
		
		this.daySelector = daySelector;
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial dialog, day selector, modal and hint.
	 * @param owner the instance of Dialog
	 * @param daySelector the instance of JDaySelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JDaySelectorDialog(Dialog owner, JDaySelector daySelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("day_selector"), new Dimension(380, CalendarManager.getDaySelectorDialogHeight()), modal, hint, true);
		
		this.daySelector = daySelector;
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(daySelector, BorderLayout.NORTH);
		
		getOptionPanel().setBorder(BorderFactory.createEmptyBorder(15, 15, 0, 15));
		
		setOption(YES_NO_OPTION);
		setIcon(IconFactory.getSwingIcon("component/calendar_48.png"));
		setContent(layoutPanel);
		
		Dimension size = getSize();
		setMinimumDimension(size);
		setMaximumDimension(size);		
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
		layoutPanel.add(daySelector, BorderLayout.NORTH);
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