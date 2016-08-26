package com.nepxion.swing.toggle;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import com.nepxion.swing.button.JBasicToggleButton;

public class JToggleActionButton
	extends JBasicToggleButton implements SwingConstants
{
	/**
	 * The instance of IToggleContentPanel.
	 */
	private IToggleContentPanel toggleContentPanel;
	
	/**
	 * The instance of ITogglePanel.
	 */
	private ITogglePanel togglePanel;
	
	/**
	 * Constructs with the specified initial toggle content panel and toggle panel.
	 * @param toggleContentPanel the instance of IToggleContentPanel
	 * @param togglePanel the instance of ITogglePanel
	 */
	public JToggleActionButton(IToggleContentPanel toggleContentPanel, ITogglePanel togglePanel)
	{
		this.toggleContentPanel = toggleContentPanel;
		
		addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				toggle();
			}
		}
		);
		
		setTogglePanel(togglePanel);
		setEnabled(togglePanel.isEnabled());
	}
	
	/**
	 * Gets the toggle content panel.
	 * @return the instance of IToggleContentPanel
	 */
	public IToggleContentPanel getToggleContentPanel()
	{
		return toggleContentPanel;
	}
	
	/**
	 * Sets the toggle content panel.
	 * @param toggleContentPanel the instance of IToggleContentPanel
	 */
	public void setToggleContentPanel(IToggleContentPanel toggleContentPanel)
	{
		this.toggleContentPanel = toggleContentPanel;
	}
	
	/**
	 * Gets the toggle panel.
	 * @return the instance of ITogglePanel
	 */
	public ITogglePanel getTogglePanel()
	{
		return togglePanel;
	}
	
	/**
	 * Sets the toggle panel.
	 * @param togglePanel the instance of ITogglePanel
	 */
	public void setTogglePanel(ITogglePanel togglePanel)
	{
		this.togglePanel = togglePanel;
		
		setText(togglePanel.getToggleText());
		
		if (togglePanel.getToggleIcon() != null)
		{
			setIcon(togglePanel.getToggleIcon());
		}
		else if (togglePanel.getToggleBannerIcon() != null)
		{
			setIcon(togglePanel.getToggleBannerIcon());
		}
		
		setToolTipText(togglePanel.getToggleDescription());
	}
	
	/**
	 * Toggles.
	 */
	public void toggle()
	{
		toggleContentPanel.toggle(togglePanel);
	}
}