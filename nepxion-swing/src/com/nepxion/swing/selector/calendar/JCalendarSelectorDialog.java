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

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.nepxion.swing.dialog.JOptionDialog;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;

public abstract class JCalendarSelectorDialog
	extends JOptionDialog implements ICalendarSelectorComponent
{	
	/**
	 * The instance of JCalendarSelector.
	 */
	private JCalendarSelector calendarSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial frame and calendar selector.
	 * @param owner the instance of Frame
	 * @param calendarSelector the instance of JCalendarSelector
	 */
	public JCalendarSelectorDialog(Frame owner, JCalendarSelector calendarSelector)
	{
		this(owner, calendarSelector, true);		
	}
	
	/**
	 * Constructs with the specified initial dialog and calendar selector.
	 * @param owner the instance of Dialog
	 * @param calendarSelector the instance of JCalendarSelector
	 */
	public JCalendarSelectorDialog(Dialog owner, JCalendarSelector calendarSelector)
	{
		this(owner, calendarSelector, true);
	}
	
	/**
	 * Constructs with the specified initial frame, calendar selector and modal.
	 * @param owner the instance of Frame
	 * @param calendarSelector the instance of JCalendarSelector
	 * @param modal the boolean value of modal
	 */
	public JCalendarSelectorDialog(Frame owner, JCalendarSelector calendarSelector, boolean modal)
	{
		this(owner, calendarSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial dialog, calendar selector and modal.
	 * @param owner the instance of Dialog
	 * @param calendarSelector the instance of JCalendarSelector
	 * @param modal the boolean value of modal
	 */
	public JCalendarSelectorDialog(Dialog owner, JCalendarSelector calendarSelector, boolean modal)
	{
		this(owner, calendarSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial frame, calendar selector, modal and hint.
	 * @param owner the instance of Frame
	 * @param calendarSelector the instance of JCalendarSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JCalendarSelectorDialog(Frame owner, JCalendarSelector calendarSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("calendar_selector"), new Dimension(380, CalendarManager.getCalendarSelectorDialogHeight()), modal, hint, true);
		
		this.calendarSelector = calendarSelector;
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial dialog, calendar selector, modal and hint.
	 * @param owner the instance of Dialog
	 * @param calendarSelector the instance of JCalendarSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JCalendarSelectorDialog(Dialog owner, JCalendarSelector calendarSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("calendar_selector"), new Dimension(380, CalendarManager.getCalendarSelectorDialogHeight()), modal, hint, true);
		
		this.calendarSelector = calendarSelector;
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{		
		layoutPanel = new JPanel();
		layoutPanel.add(calendarSelector);
		
		getOptionPanel().setBorder(BorderFactory.createEmptyBorder(15, 15, 0, 15));
		
		setOption(YES_NO_OPTION);
		setIcon(IconFactory.getSwingIcon("component/calendar_48.png"));
		setContent(layoutPanel);
		
		Dimension size = getSize();
		setMinimumDimension(size);
		setMaximumDimension(size);
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