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
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public class JLocaleSelectorOptionPane
	extends JBasicOptionPane implements ILocaleSelectorComponent
{
	/**
	 * The owner.
	 */
	private Component owner;
	
	/**
	 * The instance of JLocaleSelector.
	 */
	private JLocaleSelector localeSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial owner and locale selector.
	 * @param owner the instance of Component
	 * @param localeSelector the instance of JLocaleSelector
	 */
	public JLocaleSelectorOptionPane(Component owner, JLocaleSelector localeSelector)
	{
		this.owner = owner;
		this.localeSelector = localeSelector;
		this.localeSelector.setPreferredSize(new Dimension(220, localeSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(localeSelector, BorderLayout.NORTH);
	}
	
	/**
	 * Shows the locale selector dialog.
	 * @return the selected value
	 */
	public int showLocaleDialog()
	{
		return showDialog(owner, layoutPanel, SwingLocale.getString("locale_selector"), IconFactory.getSwingIcon("component/locale_48.png"));
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
		this.localeSelector.setPreferredSize(new Dimension(220, this.localeSelector.getPreferredSize().height));
		
		layoutPanel.removeAll();
		layoutPanel.add(localeSelector);
	}
}