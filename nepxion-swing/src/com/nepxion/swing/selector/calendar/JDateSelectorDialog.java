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

public abstract class JDateSelectorDialog
	extends JOptionDialog implements IDateSelectorComponent
{	
	/**
	 * The instance of JDateSelector.
	 */
	private JDateSelector dateSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial frame and date selector.
	 * @param owner the instance of Frame
	 * @param dateSelector the instance of JDateSelector
	 */
	public JDateSelectorDialog(Frame owner, JDateSelector dateSelector)
	{
		this(owner, dateSelector, true);
	}
	
	/**
	 * Constructs with the specified initial dialog and date selector.
	 * @param owner the instance of Dialog
	 * @param dateSelector the instance of JDateSelector
	 */
	public JDateSelectorDialog(Dialog owner, JDateSelector dateSelector)
	{
		this(owner, dateSelector, true);
	}
	
	/**
	 * Constructs with the specified initial frame, date selector and modal.
	 * @param owner the instance of Frame
	 * @param dateSelector the instance of JDateSelector
	 * @param modal the boolean value of modal
	 */
	public JDateSelectorDialog(Frame owner, JDateSelector dateSelector, boolean modal)
	{
		this(owner, dateSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial dialog, date selector and modal.
	 * @param owner the instance of Dialog
	 * @param dateSelector the instance of JDateSelector
	 * @param modal the boolean value of modal
	 */
	public JDateSelectorDialog(Dialog owner, JDateSelector dateSelector, boolean modal)
	{
		this(owner, dateSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial frame, date selector, modal and hint.
	 * @param owner the instance of Frame
	 * @param dateSelector the instance of JDateSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JDateSelectorDialog(Frame owner, JDateSelector dateSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("date_selector"), new Dimension(280, 145), modal, hint, true);
		
		this.dateSelector = dateSelector;
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial dialog, date selector, modal and hint.
	 * @param owner the instance of Dialog
	 * @param dateSelector the instance of JDateSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JDateSelectorDialog(Dialog owner, JDateSelector dateSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("date_selector"), new Dimension(280, 145), modal, hint, true);
		
		this.dateSelector = dateSelector;
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(dateSelector, BorderLayout.NORTH);
		
		getOptionPanel().setBorder(BorderFactory.createEmptyBorder(15, 15, 0, 15));
		
		setOption(YES_NO_OPTION);
		setIcon(IconFactory.getSwingIcon("component/calendar_48.png"));
		setContent(layoutPanel);
		
		Dimension size = getSize();
		setMinimumDimension(size);
		setMaximumDimension(size);
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
		
		layoutPanel.removeAll();
		layoutPanel.add(dateSelector, BorderLayout.NORTH);
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