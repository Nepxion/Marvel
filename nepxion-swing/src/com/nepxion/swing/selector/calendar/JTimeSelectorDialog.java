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

public abstract class JTimeSelectorDialog
	extends JOptionDialog implements ITimeSelectorComponent
{	
	/**
	 * The instance of JTimeSelector.
	 */
	private JTimeSelector timeSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial frame and time selector.
	 * @param owner the instance of Frame
	 * @param timeSelector the instance of JTimeSelector
	 */
	public JTimeSelectorDialog(Frame owner, JTimeSelector timeSelector)
	{
		this(owner, timeSelector, true);
	}
	
	/**
	 * Constructs with the specified initial dialog and time selector.
	 * @param owner the instance of Dialog
	 * @param timeSelector the instance of JTimeSelector
	 */
	public JTimeSelectorDialog(Dialog owner, JTimeSelector timeSelector)
	{
		this(owner, timeSelector, true);
	}
	
	/**
	 * Constructs with the specified initial frame, time selector and modal.
	 * @param owner the instance of Frame
	 * @param timeSelector the instance of JTimeSelector
	 * @param modal the boolean value of modal
	 */
	public JTimeSelectorDialog(Frame owner, JTimeSelector timeSelector, boolean modal)
	{
		this(owner, timeSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial dialog, time selector and modal.
	 * @param owner the instance of Dialog
	 * @param timeSelector the instance of JTimeSelector
	 * @param modal the boolean value of modal
	 */
	public JTimeSelectorDialog(Dialog owner, JTimeSelector timeSelector, boolean modal)
	{
		this(owner, timeSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial frame, time selector, modal and hint.
	 * @param owner the instance of Frame
	 * @param timeSelector the instance of JTimeSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JTimeSelectorDialog(Frame owner, JTimeSelector timeSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("time_selector"), new Dimension(285, 145), modal, hint, true);
		
		this.timeSelector = timeSelector;
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial dialog, time selector, modal and hint.
	 * @param owner the instance of Dialog
	 * @param timeSelector the instance of JTimeSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JTimeSelectorDialog(Dialog owner, JTimeSelector timeSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("time_selector"), new Dimension(285, 145), modal, hint, true);
		
		this.timeSelector = timeSelector;
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(timeSelector, BorderLayout.NORTH);
		
		getOptionPanel().setBorder(BorderFactory.createEmptyBorder(15, 15, 0, 15));
		
		setOption(YES_NO_OPTION);
		setIcon(IconFactory.getSwingIcon("component/calendar_48.png"));
		setContent(layoutPanel);
		
		Dimension size = getSize();
		setMinimumDimension(size);
		setMaximumDimension(size);
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
		
		layoutPanel.removeAll();
		layoutPanel.add(timeSelector, BorderLayout.NORTH);
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