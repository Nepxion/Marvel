package com.nepxion.swing.selector.locale;

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

public abstract class JLocaleSelectorDialog
	extends JOptionDialog implements ILocaleSelectorComponent
{	
	/**
	 * The instance of JLocaleSelector.
	 */
	private JLocaleSelector localeSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial frame and locale selector.
	 * @param owner the instance of Frame
	 * @param localeSelector the instance of JLocaleSelector
	 */
	public JLocaleSelectorDialog(Frame owner, JLocaleSelector localeSelector)
	{
		this(owner, localeSelector, true);
	}
	
	/**
	 * Constructs with the specified initial dialog and locale selector.
	 * @param owner the instance of Dialog
	 * @param localeSelector the instance of JLocaleSelector
	 */
	public JLocaleSelectorDialog(Dialog owner, JLocaleSelector localeSelector)
	{
		this(owner, localeSelector, true);
	}
	
	/**
	 * Constructs with the specified initial frame, locale selector and modal.
	 * @param owner the instance of Frame
	 * @param localeSelector the instance of JLocaleSelector
	 * @param modal the boolean value of modal
	 */
	public JLocaleSelectorDialog(Frame owner, JLocaleSelector localeSelector, boolean modal)
	{
		this(owner, localeSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial dialog, locale selector and modal.
	 * @param owner the instance of Dialog
	 * @param localeSelector the instance of JLocaleSelector
	 * @param modal the boolean value of modal
	 */
	public JLocaleSelectorDialog(Dialog owner, JLocaleSelector localeSelector, boolean modal)
	{
		this(owner, localeSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial frame, locale selector, modal and hint.
	 * @param owner the instance of Frame
	 * @param localeSelector the instance of JLocaleSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JLocaleSelectorDialog(Frame owner, JLocaleSelector localeSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("locale_selector"), new Dimension(320, 145), modal, hint, true);
		
		this.localeSelector = localeSelector;
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial dialog, locale selector, modal and hint.
	 * @param owner the instance of Dialog
	 * @param localeSelector the instance of JLocaleSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JLocaleSelectorDialog(Dialog owner, JLocaleSelector localeSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("locale_selector"), new Dimension(320, 145), modal, hint, true);
		
		this.localeSelector = localeSelector;
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(localeSelector, BorderLayout.NORTH);
		
		getOptionPanel().setBorder(BorderFactory.createEmptyBorder(15, 15, 0, 15));
		
		setOption(YES_NO_OPTION);
		setIcon(IconFactory.getSwingIcon("component/locale_48.png"));
		setContent(layoutPanel);
		
		Dimension size = getSize();
		setMinimumDimension(size);
		setMaximumDimension(size);
	}
	
	/**
	 * Gets the locale selector.
	 * @return the instance of JLocaleSelector
	 */
	public JLocaleSelector getLocaleSelector()
	{
		return localeSelector;
	}
	
	/**
	 * Sets the locale selector.
	 * @param localeSelector the instance of JLocaleSelector
	 */
	public void setLocaleSelector(JLocaleSelector localeSelector)
	{
		this.localeSelector = localeSelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(localeSelector, BorderLayout.NORTH);
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